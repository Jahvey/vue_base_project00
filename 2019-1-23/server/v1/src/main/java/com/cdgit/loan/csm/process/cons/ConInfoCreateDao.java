package com.cdgit.loan.csm.process.cons;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmTbConContractInfo;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbBizApprovePo;


@Service
@Transactional
public class ConInfoCreateDao {//ConDao0001
	
	@Autowired
	CsmTbBizAmountDetailApproveMapper csmTbBizAmountDetailApproveMapper;
	
	@Autowired
	CsmTbBizApproveMapper  csmTbBizApproveMapper;
	
	
	


	public CsmTbConContractInfo create(Map<String, Object> apply) {//TODO 待测这个是创建合同的核心方法。。。。。。。。。。
		String error = createValid(apply);
		if (error != null) {
			throw new RuntimeException(error);
		}
		CsmTbConContractInfo applyObj = createApply(apply);
		createProcess(applyObj);
		return applyObj;
	}
	
	public String createProcess(CsmTbConContractInfo contractInfo) {
//		String flowName = getFlowName();
//		if (StringUtil.isNull(flowName)) {
//			return null;
//		}
//		String processId = processFactory.createBpsProcessThrowError(bizObj.getString(getEntityId()), flowName);
//		bizObj.set("processInstId", processId);
		return "";
	}
	
	public CsmTbConContractInfo createApply(Map<String, Object> dataMap) {//TODO 未完成得部分周末弄.......
		CsmTbConContractInfo contractInfo = new CsmTbConContractInfo();
		
		
		return contractInfo;
		
		
	}
	
	

	public String createValid(Map<String, Object> dataMap) {
		String bizDtlId = (String) dataMap.get("AMOUNT_DETAIL_ID");
		TbBizAmountDetailApprovePo bizDtl = csmTbBizAmountDetailApproveMapper.queryOneTbBizAmountDetailApproveByAmountDetailId(bizDtlId);
		TbBizApprovePo biz = csmTbBizApproveMapper.queryOneTbBizApproveByApproveId(bizDtl.getApproveId());
		//DataObject bizDtl = EntityUtil.getEntityById(BizTableName.TB_BIZ_AMOUNT_DETAIL_APPROVE, "amountDetailId", bizDtlId);
		//DataObject biz = EntityUtil.getEntityById(BizTableName.TB_BIZ_APPROVE, "approveId", bizDtl.getString("approveId"));

		dataMap.put("amountDetailId", bizDtlId);
		dataMap.put("applyId", biz.getApproveId());// 调整之后old_apply_id存放的approve_id
		dataMap.put("approveId", biz.getApproveId());
		dataMap.put("crdId", biz.getCrdId());
//		RuleUtil.runRules(dataMap, "XFE_0003"// TODO 以后有时间得时候再做  2019-1-18........
//				, "RCON_0202"// 存在在途合同
//				, "RCON_0203"// 存在已生效合同
//				, "RCON_0204"// 该业务已无可用额度
//				, "RBIZ_0046" // 存在在途业务调整
//				, "RCRD_0212"// 存在在途授信调整
//		);

		dataMap.put("db_biz", biz);
		dataMap.put("db_bizDtl", bizDtl);
		return null;
	}
	
	

}
