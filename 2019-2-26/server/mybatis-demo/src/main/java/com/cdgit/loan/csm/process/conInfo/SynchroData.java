package com.cdgit.loan.csm.process.conInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbBizApplyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConFlagInfoPoMapper;
import com.cdgit.loan.csm.po.CsmTbBizApplyPo;
import com.cdgit.loan.csm.po.CsmTbConFlagInfoPo;

@Service
@Transactional
public class SynchroData {
	
	@Autowired
	CsmTbConFlagInfoPoMapper csmTbConFlagInfoPoMapper;
	
	@Autowired
	CsmTbBizApplyPoMapper csmTbBizApplyPoMapper;
	
	public String synchroRiskInfo(String applyId, String contractId) throws Exception {
		
		try {
		CsmTbBizApplyPo tbBizApply = csmTbBizApplyPoMapper.selectByPrimaryKey(applyId);
		
		if(tbBizApply.getZdfxqyType()!=null){
			String riskInfo = tbBizApply.getZdfxqyType();
			
			CsmTbConFlagInfoPo tbConFlagInfoPo = csmTbConFlagInfoPoMapper.queryOneByConId(contractId);
			
			if(null!=tbConFlagInfoPo.getFlagId()){
				if(null!=tbConFlagInfoPo.getRiskInfo()){
					return null;
				}else{
					
					tbConFlagInfoPo.setRiskInfo(riskInfo);
					csmTbConFlagInfoPoMapper.insertSelective(tbConFlagInfoPo);
				}

			}else {
				tbConFlagInfoPo.setRiskInfo(riskInfo);
				csmTbConFlagInfoPoMapper.insertSelective(tbConFlagInfoPo);
				
			}

			
		}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return null;

	}
	

}
