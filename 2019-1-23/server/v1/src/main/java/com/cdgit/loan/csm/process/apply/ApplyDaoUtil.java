package com.cdgit.loan.csm.process.apply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbSysApplyDaoConfigMapper;
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
@Service
@Transactional
public class ApplyDaoUtil {
	
	@Autowired
	CsmTbSysApplyDaoConfigMapper csmTbSysApplyDaoConfigMapper;
	
	private  Map<String, List<Object[]>> configMap;
//	static {
//		loadConfig();
//	}
	
	public  Map<String, List<Object[]>> loadConfig() {
		configMap = new HashMap<String, List<Object[]>>();
		//Object[] datas = EntityUtil.searchEntitys(SysTableName.TB_SYS_APPLY_DAO_CONFIG);
		List<TbSysApplyDaoConfigPo> datas = csmTbSysApplyDaoConfigMapper.queryAllListTbSysApplyDaoConfig();
		
		HashMap<String,String> map ;
		
		
		for (int i = 0; i < datas.size(); i++) {
			map = new HashMap<String,String>();
			map.put("configId", datas.get(i).getConfigId());
			map.put("phase", datas.get(i).getPhase());
			map.put("legOrg", datas.get(i).getLegOrg());
			map.put("orgNum", datas.get(i).getOrgNum());
			map.put("className", datas.get(i).getClassName());
			map.put("flowName", datas.get(i).getFlowName());
			map.put("code", datas.get(i).getCode());
			map.put("partyType", datas.get(i).getPartyType());
			map.put("remark", datas.get(i).getRemark());
			map.put("productCd", datas.get(i).getProductCd());
			
			
			ApplyDaoParam param = ApplyDaoParam.getParam(map);
			String matchId = param.getMatchId();
			List<Object[]> configList = configMap.get(matchId);
			if (configList == null) {
				configList = new ArrayList<Object[]>();
				configMap.put(matchId, configList);
			}
			configList.add(new Object[] { param.getMatch(), (map) });
			map=null;
		}
		for (List<Object[]> list : configMap.values()) {
			ApplyDaoParam.sort(list);
		}
		
		System.err.println(configMap);
		return configMap;
	}
	

	
	public  TbSysApplyDaoConfigPo getConfig(ApplyDaoParam param) {
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
	
//	public static IApplyDao getApplyDao(ApplyDaoParam param) {
//		DataObject config = getConfig(param);
//		String className = config.getString("className");
//		if (StringUtil.isNull(className)) {
//			throw new RuntimeException("该业务尚未开通，请联系管理员处理[" + param.getId() + "]");
//		}
//		try {
//			IApplyDao dao = (IApplyDao) Class.forName(className).newInstance();
//			dao = (IApplyDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { IApplyDao.class }, new PApplyDao(dao));
//			dao.setFlowName(config.getString("flowName"));
//			dao.setDaoParam(param);
//			return dao;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("创建ApplyDao配置实体失败：[" + className + "]");
//		}			
//	}
	
	
}
