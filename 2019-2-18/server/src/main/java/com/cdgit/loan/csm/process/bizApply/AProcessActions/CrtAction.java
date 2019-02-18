package com.cdgit.loan.csm.process.bizApply.AProcessActions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbConCreditInfoPoMapper;
import com.cdgit.loan.csm.po.CsmTbConCreditInfoPo;
import com.cdgit.loan.csm.process.bizApply.AProcessAction;
import com.cdgit.loan.csm.process.bizApply.IProcessAction;
import com.cdgit.loan.csm.process.bizApply.ProcessParam;
import com.cdgit.loan.csm.pub.DictContents;
import com.cdgit.loan.csm.pub.gitUtils.GitUtils;

@Service
@Transactional
public class CrtAction extends AProcessAction{
	
	@Autowired
	CsmTbConCreditInfoPoMapper csmTbConCreditInfoPoMapper;
	
	@Autowired
	GitUtils gitUtils;

	public ProcessParam action(String bizId) {
		ProcessParam param = new ProcessParam(bizId);

		CsmTbConCreditInfoPo entity = csmTbConCreditInfoPoMapper.selectByPrimaryKey(bizId);
		//DataObject entity = EntityUtil.getEntityById("com.bos.dataset.crt.TbConContractInfo", "contractId", bizId);
		param.setPartyId(entity.getPartyId());
		String oldConId = entity.getOldContractId();
		
		
		String legorg = gitUtils.getLegorg();
		// 合同申请
		if (null == oldConId || "".equals(oldConId)) {
			if (DictContents.ORG_MCCB.equals(legorg)) {
				param.setTemplateName("crt_sign_mccb");
			} else if (DictContents.ORG_BCFM.equals(legorg)) {
				param.setTemplateName("crt_sign_bcfm");
			} else if (DictContents.ORG_PWFM.equals(legorg)) {
				param.setTemplateName("crt_sign_pwfm");
			}
		} else {// 合同调整
			if (DictContents.ORG_MCCB.equals(legorg)) {
				param.setTemplateName("contract_tz_mccb");
			} else if (DictContents.ORG_BCFM.equals(legorg)) {
				param.setTemplateName("contract_tz_bcfm");
			} else if (DictContents.ORG_PWFM.equals(legorg)) {
				param.setTemplateName("contract_tz_pwfm");
			}
		}
		return param;
	}
}
