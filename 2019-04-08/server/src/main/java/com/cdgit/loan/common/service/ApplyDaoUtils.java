package com.cdgit.loan.common.service;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.bean.ApplyDaoParam;
import com.cdgit.loan.common.mapper.CommonUtilMapper;
import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.common.util.SpringUtil;
import com.cdgit.loan.common.util.StringUtil;
import com.cdgit.loan.csm.po.TbSysApplyDaoConfigPo;


/**
 * class数字含义<br/>
 * 数字编号两位一层<br/>
 * 第一层 <br/>
 * 分离式 [00],一体化 [02],单笔单批[03]<br/>
 * 第二层<br/>
 * 正常[01],调整[04],失效[08],循环通[06],冻结[07]<br/>
 * 第三层<br/>
 * 对私[02]对公[01]
 * 
 * @author crms18
 * 
 */
@Transactional
public class ApplyDaoUtils {
	
//	private static ApplyDaoUtils applyDaoUtils=(ApplyDaoUtils)SpringUtil.getBean("ApplyDaoUtils");
	
//	private static DealAccount applyDaoUtils=(DealAccount)SpringUtil.getBean(DealAccount.class);
	
	private static CommonUtilMapper commonUtilMapper=(CommonUtilMapper)SpringUtil.getBean(CommonUtilMapper.class);
	
	
//	public ApplyDaoUtils(){
//		this.commonUtilMapper=(CommonUtilMapper)SpringUtil.getBean("CommonUtilMapper");
//	}
//	
//	public CommonUtilMapper getDao{
//		 this.commonUtilMapper=(CommonUtilMapper)SpringUtil.getBean("CommonUtilMapper");
//	}
	
	/**
	 * 额度类型-分离式
	 */
	public static final String CREDIT_MODE_CLEFT = "00";
	/**
	 * 额度类型-一体化
	 */
	public static final String CREDIT_MODE_UNITE = "02";
	/**
	 * 额度类型-单笔单批
	 */
	public static final String CREDIT_MODE_ONLY = "03";
	/**
	 * 额度类型-低风险
	 */
	public static final String CREDIT_MODE_LOW = "05";

	private static Map<String, List<Object[]>> configMap;
	static {
		loadConfig();
	}

	public static Map<String, List<Object[]>> loadConfig() {
		configMap = new HashMap<String, List<Object[]>>();
		
		List resultList = commonUtilMapper.queryTbSysApplyDaoConfigList();
		
		
		for(int i = 0; i < resultList.size();++i){
			ApplyDaoParam param = ApplyDaoParam.getParam((TbSysApplyDaoConfigPo)resultList.get(i));
			String matchId = param.getMatchId();
			List<Object[]> configList = configMap.get(matchId);
			if (configList == null) {
				configList = new ArrayList<Object[]>();
				configMap.put(matchId, configList);
			}
			configList.add(new Object[] { param.getMatch(), ((TbSysApplyDaoConfigPo)resultList.get(i)) });
		}
		
		for (List<Object[]> list : configMap.values()) {
			ApplyDaoParam.sort(list);
		}
		return configMap;
	}

	public static IApplyDao getApplyDao(ApplyDaoParam param) {
		TbSysApplyDaoConfigPo config = getConfig(param);
		String className = config.getClassName();
		if (StringUtil.isNull(className)) {
			throw new RuntimeException("该业务尚未开通，请联系管理员处理[" + param.getId() + "]");
		}
		try {
			IApplyDao dao = (IApplyDao) Class.forName(className).newInstance();
			dao = (IApplyDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { IApplyDao.class }, new PApplyDao(dao));
			dao.setFlowName(config.getFlowName());
			dao.setDaoParam(param);
			return dao;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("创建ApplyDao配置实体失败：[" + className + "]");
		}
	}

	public static IDao getDetailDao(ApplyDaoParam param) {
		if (!param.getPhase().contains("Dtl")) {
			param.setPhase(param.getPhase() + "Dtl");
		}
		TbSysApplyDaoConfigPo config = ApplyDaoUtils.getConfig(param);
		String className = config.getClassName();//替换原来的方法
		if (StringUtil.isNull(className)) {
			throw new RuntimeException("DetailDao配置信息错误：请联系管理员处理[paramId=" + param.getId() + "]");
		}
		try {
//			return BeanFactory.newInstance().getBean(className);
			return (IDao)SpringUtil.getBean(className);//看哈可以支持不
		} catch (Exception e) {
			throw new RuntimeException("创建DetailDao配置实体失败：[" + className + "]", e);
		}
	}
//
	/**
	 * 测试是否有必要按照以前那样定义个DataObject
	 这个方法到底给几个地方在用？
	 * <p>Title: getConfig</p>  
	
	 * <p>Description: </p>  
	
	 * @param param
	 * @return
	 */
	public static TbSysApplyDaoConfigPo getConfig(ApplyDaoParam param) {
		// -----------测试用begin
		//loadConfig();
		// -----------测试用end
		List<Object[]> configList = configMap.get(param.getMatchId());
		String id = param.getId();
		for (Object[] config : configList) {
			if (id.matches((String) config[0])) {
				return (TbSysApplyDaoConfigPo) config[1];
			}
		}
		throw new RuntimeException("获取ApplyDao配置信息失败：请联系管理员处理[paramId=" + param.getId() + "]");
	}

	public static boolean isZhsx(String creditMode) {
		return GitUtil.contain(creditMode, new String[] { CREDIT_MODE_UNITE, CREDIT_MODE_CLEFT });
	}
}
