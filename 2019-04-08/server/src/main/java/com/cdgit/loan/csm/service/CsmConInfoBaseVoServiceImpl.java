/**
 * 
 */
package com.cdgit.loan.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmConCreditInfo;
import com.cdgit.loan.csm.bean.CsmConInfoBaseVo;
import com.cdgit.loan.csm.bean.CsmTbBizApprove;
import com.cdgit.loan.csm.pub.gitUtils.CsmGitUtilsMapper;
import com.cdgit.loan.csm.mapper.CsmConInfoBaseVoMapper;
import com.cdgit.loan.csm.po.TbConContractInfoPo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmConInfoBaseVoServiceImpl {

	@Autowired
	CsmConInfoBaseVoMapper csmConInfoBaseVoMapper;
	
	
	@Autowired
	CsmGitUtilsMapper csmGitUtilsMapper;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CsmConInfoBaseVo getConInfoByContarctId(String contractId){
		
		
		CsmConInfoBaseVo csmConInfoBaseVo=new CsmConInfoBaseVo();
		TbConContractInfoPo conInfo2 = new TbConContractInfoPo();
		CsmConCreditInfo conInfo1 = new CsmConCreditInfo();
		//设置协议信息
		csmConInfoBaseVo.setProFlag1("1");
		conInfo1.setContractId(contractId);
		conInfo2.setContractId(contractId);

		
		//查询协议信息
		conInfo1=csmConInfoBaseVoMapper.getCsmTbConCreditInfo(contractId).get(0);//测试成功
		//tbConCreditInfo/partyId 是不是等于空或者empty
		if(conInfo1.getApplyId()!=null||!conInfo1.equals(""))
		{//否
			//如果营业事件为空，则设置一个营业时间
			if(conInfo1.getContractDate()==null){
				
				java.util.Date handlingDate=csmGitUtilsMapper.queryInitBusiDate();//为Null 在解决 /未解决，直接调接口可以拿到数据
				conInfo1.setContractDate(handlingDate);
	
			}
			
			
			//设置协议信息
			csmConInfoBaseVo.setConInfo1(conInfo1);//将conInfo1作为conInfo
			csmConInfoBaseVo.setConInfo2(null);
			csmConInfoBaseVo.setContractType("01");
			CsmTbBizApprove tbBizApprove=new CsmTbBizApprove();
			//tbBizApprove.setApplyId(conInfo1.getApplyId());//注意这里仅仅只是做了赋值操作并没有设置到csmConInfoBaseVo
			 tbBizApprove = csmConInfoBaseVoMapper.queryCsmTbBizApproveVoInfo(conInfo1.getApplyId());

			//查询批复信息
			
			
			
			
			//设置批复基本信息
			
			//查询批复基本信息
			
			
			//赋值
			
			//查询客户party
			
			
			
			
			
			
			
		}else{
		//是
			
			
		}
		
		
		
		//Map map=new HashMap<String,Object>();

		
		return csmConInfoBaseVo;
	
		
	}
	
	
	
	
	
	
}
