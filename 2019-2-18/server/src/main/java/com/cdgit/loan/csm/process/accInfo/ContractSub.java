package com.cdgit.loan.csm.process.accInfo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbConSubGrtRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbGrtMortgageBasicMapper;
import com.cdgit.loan.csm.po.TbConSubGrtRelPo;
import com.cdgit.loan.csm.po.TbConSubcontractPo;
import com.cdgit.loan.csm.po.TbConSubcontractRelPo;
import com.cdgit.loan.csm.po.TbGrtMortgageBasicPo;

/**
 * 2015-12-29 15:11:13 合同发起或调整时，操作从合同数据
 * @author Administrator
 *
 */
@Service
@Transactional
public class ContractSub {
	
	@Autowired
	CsmTbConSubcontractRelMapper csmTbConSubcontractRelMapper;
	
	@Autowired
	CsmTbConSubcontractMapper csmTbConSubcontractMapper;
	
	@Autowired
	CsmTbConSubGrtRelMapper csmTbConSubGrtRelMapper;
	
	
	@Autowired
	CsmTbGrtMortgageBasicMapper csmTbGrtMortgageBasicMapper;
	
	
	// 借新还旧业务，发起合同时，恢复最高额从合同可用额度，恢复一般从合同下所有抵质押物的权利价值
	public void delSubcontract(String contractId) {
		if (null == contractId || "".equals(contractId)) {
			return;
		}
		// 查询主合同下所关联的所有从合同
		List<TbConSubcontractRelPo>  conRels=csmTbConSubcontractRelMapper.queryListCsmTbConSubcontractRelByconId(contractId);
		
		
		// 处理业务合同信息
		for (int i = 0; i < conRels.size(); i++) {
			TbConSubcontractPo subCon = csmTbConSubcontractMapper.queryCsmTbConSubcontractPo(conRels.get(i).getSubcontractId());
			// 操作业务合同下所关联的从合同信息
			if (("01".equals(subCon.getSubcontractType())) || ("02".equals(subCon.getSubcontractType()))
								|| ("04".equals(subCon.getSubcontractType()))) {
				
				if ("1".equals(subCon.getIfTopSubcon())) {
					subCon.setAviAmt(subCon.getZgbjxe());
					//subCon.set("aviAmt", subCon.get("zgbjxe"));
					csmTbConSubcontractMapper.updateCsmTbConSubcontract(subCon);
				}else{
					List<TbConSubGrtRelPo> grtRels=csmTbConSubGrtRelMapper.queryListTbConSubGrtRel(subCon.getSubcontractId());
					
					for (int j = 0; j < grtRels.size(); j++) {

						TbGrtMortgageBasicPo grt = csmTbGrtMortgageBasicMapper.queryOneCsmTbGrtMortgageBasic(grtRels.get(j).getSuretyId());
						grt.setAviAmt(grt.getMortgageValue());
						csmTbGrtMortgageBasicMapper.updateCsmTbGrtMortgageBasic(grt);
						
					}
				}
			}
		}
		
		
	
	}
	

}
