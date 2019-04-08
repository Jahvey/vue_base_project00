package com.cdgit.loan.csm.process.conInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
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
	
	public String synchroRiskInfo(String applyId, String contractId) {
		System.err.println("[synchroRiskInfo]同步标志数据:applyId "+applyId+",contractId "+contractId);
		
		try {
		CsmTbBizApplyPo tbBizApply = csmTbBizApplyPoMapper.selectByPrimaryKey(applyId);
		
		if(tbBizApply.getZdfxqyType()!=null){  //TODO 环境、安全等重大风险企业类别  XD_DKSQLX0001   zdfxqy_type
			String riskInfo = tbBizApply.getZdfxqyType();
			
			CsmTbConFlagInfoPo tbConFlagInfoPo = csmTbConFlagInfoPoMapper.queryOneByConId(contractId);
			
			if(null!=tbConFlagInfoPo){
				if(null!=tbConFlagInfoPo.getRiskInfo()){
					return null;
				}else{
					
					tbConFlagInfoPo.setRiskInfo(riskInfo);
					tbConFlagInfoPo.setContractId(contractId);
					csmTbConFlagInfoPoMapper.updateByPrimaryKeySelective(tbConFlagInfoPo);
					System.err.println("[tbConFlagInfoPo]更新成功"+tbConFlagInfoPo);
				}

			}else {
				tbConFlagInfoPo=new CsmTbConFlagInfoPo();
				tbConFlagInfoPo.setRiskInfo(riskInfo);
				tbConFlagInfoPo.setFlagId(UUIDGenerator.getUUID());
				tbConFlagInfoPo.setContractId(contractId);
				csmTbConFlagInfoPoMapper.insertSelective(tbConFlagInfoPo);
				System.err.println("[tbConFlagInfoPo]插入成功"+tbConFlagInfoPo);
				
			}

			
		}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return null;

	}
	

}
