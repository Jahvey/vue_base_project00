package com.cdgit.loan.csm.process.conApply;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.ConApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbConContractInfoMapper;
import com.cdgit.loan.csm.po.CsmTbConCreditInfoPo;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.process.accInfo.ContractApply;
import com.cdgit.loan.csm.process.apply.ApplyDaoUtil;
import com.cdgit.loan.csm.process.conInfo.DelBizGrtRel;

@Service
@Transactional
public class ConApply {
	
	@Autowired
	ContractApply contractApply;
	
	@Autowired
	ConApplyMapper conApplyMapper;
	
	@Autowired
	CsmTbConContractInfoMapper csmTbConContractInfoMapper;
	
	@Autowired
	CsmTbBizAmountDetailApproveMapper  csmTbBizAmountDetailApproveMapper;
	
	@Autowired
	ApplyDaoUtil applyDaoUtil;
	
	@Autowired
	DelBizGrtRel delBizGrtRel;
	
	
	
	//业务性质XD_SXYW0002
//    '01': '单笔业务',
//    '02': '综合授信',
//    '03': '统一授信',
//    '04': '单笔业务',
//    '05': '集团成员授信',
//    '06': '集团成员授信',
//    '07': '低风险业务',
//    '10': '用信业务'
	//调整合同
	public HashMap<String,Object> tzContractInfo(String contractId,String bizType){
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		HashMap<String,Object> map;
		if(!"01".equals(bizType)||!"04".equals(bizType)){//调整综合授信协议
			CsmTbConCreditInfoPo tzCreditInfo = contractApply.tzCreditInfo(contractId);//核心方法
			hashMap.put("conInfo",tzCreditInfo);
			
			//合同发起流程
			map=createBpsProcess(tzCreditInfo.getContractId(), "crt");
		}else{//合同调整
			TbConContractInfoPo tzConInfo = contractApply.tzConInfo(contractId);
			hashMap.put("conInfo",tzConInfo);
			
			//合同发起流程
			map=createBpsProcess(tzConInfo.getContractId(), "crt");
		}
		
		
		hashMap.put("processInstId", map.get("processInstId"));
		hashMap.put("msg", map.get("map"));
		
		
		return hashMap;
	}
		
	
	
	
	//TODO 需要完善的地方 写完合同发起流程.......
	//合同发起流程
	public HashMap<String, Object> createBpsProcess(String bizId,String type) {
		HashMap<String,Object>resMap=new HashMap<String,Object>();
		String processInstId="xxxxxxx";
		String msg="";
		
		System.err.println("发起合同流程：[bizID="+bizId+",type="+type+"]");
		
		
		
		
		
		resMap.put("processInstId", processInstId);
		resMap.put("msg", msg);
		return resMap;
		
	}
	
	// 根据合同id查询 业务性质
	public String getConInfoBizType(String contractId){
		
		HashMap<String,Object> conInfoBizType = conApplyMapper.getConInfoBizType(contractId);
		return (String) conInfoBizType.get("bizType");
	}
	
	//失效合同
	public String disConInfo(String contractId,String flag){//flag:1-不失效合同直接刷新额度
		String msg="";
		
		//查询合同
		TbConContractInfoPo conInfo = csmTbConContractInfoMapper.queryOneCsmTbConContractInfoByConId(contractId);
		String amountDetailId=conInfo.getAmountDetailId();
		String partyId=conInfo.getPartyId();
		
		if(!"1".equals(flag)){

		
		//查询业务明细
		TbBizAmountDetailApprovePo amountDetail = csmTbBizAmountDetailApproveMapper.queryOneTbBizAmountDetailApproveByAmountDetailId(amountDetailId);
		
		try {
			

			//更新主合同信息
			conApplyMapper.updateConInfoStatus(contractId);
			//更新从合同信息
			conApplyMapper.updateConInfoRelStatus(contractId);
			if(!applyDaoUtil.isZhsx(conInfo.getCreditMode())){
				//更新批复
				conApplyMapper.updateCancelPF(amountDetailId);
				//TODO 删除业务与押品的关系 2019-2-11
				delBizGrtRel.delBizGrtRel(contractId);
				
			}

		//更新授信额度
			conApplyMapper.updateCreditLimit(partyId);
		} catch (Exception e) {
			msg="处理失败";
			throw new RuntimeException(e);
		}
		
	}else {
			//flag==1 只更新授信额度
			try {			
				conApplyMapper.updateCreditLimit(partyId);
			} catch (Exception e) {
				msg="处理失败";
				throw new RuntimeException(e);
			}
			
	}

		msg="处理成功";
		
		return msg;
	}
	
	
	
	//TODO   小贷合同授权
	public void saveConInfoToPro(String contractId,String processInstId){
		TbConContractInfoPo conInfo = csmTbConContractInfoMapper.queryOneCsmTbConContractInfoByConId(contractId);
		
		String oldConId=conInfo.getOldContractId();
		String orgdegree="";//从缓存里面取出来的数据
		
		if(null!=oldConId &&!"".equals(oldConId) && "2".equals(orgdegree)){
			//TODO 调用相关的工作流的数据
			 BigDecimal rmbAmt = conInfo.getRmbAmt();
			 System.err.println("【调用工作流相关数据】input:[rmbAmt]"+rmbAmt+"[processId]"+processInstId);
			
			
		}
		
	}
	
	
	

}
