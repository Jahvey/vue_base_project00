/**
 * 
 */
package com.cdgit.loan.csm.process.bizInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbBizApplyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizBankStructApplyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbCsmGroupCompanyPoMapper;
import com.cdgit.loan.csm.po.CsmTbBizApplyPo;
import com.cdgit.loan.csm.po.CsmTbBizBankStructApplyPo;
import com.cdgit.loan.csm.po.CsmTbCsmGroupCompanyPo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class BizInfo {
	
	@Autowired
	CsmTbBizApplyPoMapper csmTbBizApplyPoMapper;

	@Autowired
	CsmTbCsmGroupCompanyPoMapper csmTbCsmGroupCompanyPoMapper;
	
	@Autowired
	CsmTbBizBankStructApplyPoMapper csmTbBizBankStructApplyPoMapper;
	
	
	//查询银团结构信息
	public CsmTbBizBankStructApplyPo getBankTeamStruct(String applyId){
		
		CsmTbBizApplyPo bizApply = csmTbBizApplyPoMapper.selectByPrimaryKey(applyId);
		CsmTbBizBankStructApplyPo bankTs = csmTbBizBankStructApplyPoMapper.queryByApplyId(applyId);
		CsmTbCsmGroupCompanyPo group = csmTbCsmGroupCompanyPoMapper.selectByPrimaryKey(bizApply.getPartyId());
		if("03".equals(group.getStatus())){//是否集团客户
			bankTs.setGroupCustomer("1");//是集团客户
		}else {
			bankTs.setGroupCustomer("0");
		}

		return bankTs;
	}
	
	

}
