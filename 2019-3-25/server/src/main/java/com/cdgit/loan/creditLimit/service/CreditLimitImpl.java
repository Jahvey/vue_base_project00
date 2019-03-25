package com.cdgit.loan.creditLimit.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.creditLimit.bean.TbConGuarantOrgInfo;
import com.cdgit.loan.creditLimit.bean.TbCrdThirdPartyLimit;
import com.cdgit.loan.creditLimit.mapper.CreditLimitMapper;
import com.cdgit.loan.guaranteevaluation.mapper.ConZhMapper;
import com.cdgit.loan.user.bean.NaturealInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CreditLimitImpl {

	@Autowired
	CreditLimitMapper creditLimitMapper;
	
	@Autowired
	ConZhMapper conZhMapper;//查询保证账户暂时用其他模块的
	
	/**
	 * 查询专业担保协议
	
	 * <p>Title: queryThirdHis_protocol</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public PageInfo queryThirdHis_protocol(Map map){
//		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List userList=creditLimitMapper.queryThirdHis_protocol(map);
        PageInfo pageInfo=new PageInfo(userList,(Integer)map.get("pageSize"));
		return pageInfo;
		
	}
	
	/**
	 * 查询第三方专业担保公司额度
	
	 * <p>Title: queryThirdHis_corp</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public PageInfo queryThirdHis_corp(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List userList=creditLimitMapper.queryThirdHis_corp(map);
        PageInfo pageInfo=new PageInfo(userList,(Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	/**
	 * 
	担保公司额度调整
	查询原额度信息 新增第三方额度 新增账户信息 创建流程  涉及插入 更新 删除记录的方法需要添加注解 @Transactional
	 * <p>Title: createPartyCrd</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 */
	@Transactional
	public Map createPartyCrd(Map map){
		TbCrdThirdPartyLimit thirdLimit=new TbCrdThirdPartyLimit();
		thirdLimit.setPartyId((String)map.get("partyId"));
		thirdLimit.setUserNum("");//前端统一配送
		thirdLimit.setCreateTime(new Date());
		thirdLimit.setCreditNum("");//通用方法生成
		thirdLimit.setStatusCd("01");//默认赋值
		thirdLimit.setLimitType((String)map.get("limitType"));//专业担保公司额度调整默认写值  08           兼容其他第三方客户额度调整  从我的客户进去选择第三方客户 再进行申请或额度调整
		thirdLimit.setLimitId(UUIDGenerator.getUUID());
		if(StringUtils.isNotEmpty((String)map.get("oldLimitId"))){//如果是调整
			thirdLimit.setOldLimitId((String)map.get("oldLimitId"));
			TbCrdThirdPartyLimit oldThirdLimit=new TbCrdThirdPartyLimit();
			oldThirdLimit.setLimitId(thirdLimit.getOldLimitId());
			oldThirdLimit=creditLimitMapper.selectByPrimaryKey(thirdLimit.getOldLimitId());//查询原第三方客户原额度信息
			//从原额度信息拷贝以下值
			thirdLimit.setLongestLoanTerm(oldThirdLimit.getLongestLoanTerm());
			thirdLimit.setItemUsed(oldThirdLimit.getItemUsed());
			thirdLimit.setItemAmt(oldThirdLimit.getItemAmt());
			thirdLimit.setItemAvi(oldThirdLimit.getItemAvi());
			thirdLimit.setUserNum(oldThirdLimit.getUserNum());
			thirdLimit.setOrgNum(oldThirdLimit.getOrgNum());
//			map.put("limitId", UUIDGenerator.getUUID());//程序生成uuid
			map.put("limitId", thirdLimit.getLimitId());//获取前面生成的uuid
			creditLimitMapper.insertSelective(thirdLimit);
			creditLimitMapper.insertNewZh(map);
			if(StringUtils.isNotEmpty((String)map.get("limitType")) 
					&& "09".equals((String)map.get("limitType"))){//如果是 limit_type 是  09  需要调用插入 tb_con_zh
				map.put("relId", UUIDGenerator.getUUID());//程序生成uuid
				creditLimitMapper.insertCrdProRel(map);
			}
			
		}else{//如果是申请 则直接插入
			creditLimitMapper.insertSelective(thirdLimit);
		}
		
		Map resultMap=new HashMap();
		resultMap.put("limitId", thirdLimit.getLimitId());
		resultMap.put("processInstId","");
		return resultMap;
		
	}
	
	/**
	 * 创建担保合同
	
	 * <p>Title: createDbht</p>  
	
	 * <p>Description: </p>
	 */
	@Transactional
	public Map createDbht(Map map){
		TbCrdThirdPartyLimit thirdLimit=new TbCrdThirdPartyLimit();
		thirdLimit=creditLimitMapper.getThirdPartyCrdByLimitId(map);
		TbConGuarantOrgInfo guarantOrgInfo=new TbConGuarantOrgInfo();
		guarantOrgInfo.setContractId(UUIDGenerator.getUUID());
		guarantOrgInfo.setStatusCd("01");
		guarantOrgInfo.setPartyId(thirdLimit.getPartyId());
		guarantOrgInfo.setCreateTime(new Date());//后期修改
		guarantOrgInfo.setUpdateTime(new Date());//后期修改
		guarantOrgInfo.setCreditAmount(thirdLimit.getCreditAmount());
		guarantOrgInfo.setSimpleAmount(thirdLimit.getSimpleAmount());
		guarantOrgInfo.setAccnoWay(thirdLimit.getAccnoWay());
		guarantOrgInfo.setCreditType(thirdLimit.getCreditType());
		
		guarantOrgInfo.setCreditStatus(thirdLimit.getCreditStatus());
		guarantOrgInfo.setCreditApport(thirdLimit.getCreditApport());
		guarantOrgInfo.setCreditAbroad(thirdLimit.getCreditAbroad());
		guarantOrgInfo.setCreditOneRepay(thirdLimit.getCreditOneRepay());
		
		
		guarantOrgInfo.setCreditTwoRepay(thirdLimit.getCreditTwoRepay());
		guarantOrgInfo.setCreditTwoOtherRepay(thirdLimit.getCreditTwoOtherRepay());
		guarantOrgInfo.setCreditLoan(thirdLimit.getCreditLoan());
		guarantOrgInfo.setCreditOtherAmount(thirdLimit.getCreditOtherAmount());
		
		guarantOrgInfo.setInnerCret(thirdLimit.getInnerCret());
		guarantOrgInfo.setDeferAssets(thirdLimit.getDeferAssets());
		guarantOrgInfo.setWaitAssets(thirdLimit.getCreditLoan());
		guarantOrgInfo.setGoodsStock(thirdLimit.getGoodsStock());
		
		guarantOrgInfo.setCreditTwoPayable(thirdLimit.getCreditTwoPayable());
		guarantOrgInfo.setLastYearAmount(thirdLimit.getLastYearAmount());
		guarantOrgInfo.setOuterAssets(thirdLimit.getOuterAssets());
		guarantOrgInfo.setFixedAssets(thirdLimit.getFixedAssets());
		
		guarantOrgInfo.setInvisibleAssets(thirdLimit.getInvisibleAssets());
		
		
		creditLimitMapper.insertGuarant(guarantOrgInfo);
//		int i=1/0;//测试事务控制是否生效
		creditLimitMapper.insertconZh(guarantOrgInfo);
		Map resultMap=new HashMap();//跳转到con_tree_db 需要
		resultMap.put("proFlag", "1");
		resultMap.put("contractId", guarantOrgInfo.getContractId());
		resultMap.put("processInstId", "");//流程实例id
		return resultMap;
	}
	
	/**
	 * 查询担保账户列表
	
	 * <p>Title: getAccInfoList</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public PageInfo getAccInfoList(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List conZhList=conZhMapper.selectByContractId((String)map.get("contractId"));//暂时引用其他组件的
        PageInfo pageInfo=new PageInfo(conZhList,(Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	/**
	 * 
	
	 * <p>Title: getThirdPartyCrdByLimitId</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public TbCrdThirdPartyLimit getThirdPartyCrdByLimitId(Map map){
		
		return creditLimitMapper.getThirdPartyCrdByLimitId(map);
	}
	
}
