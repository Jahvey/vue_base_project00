/**
 * 
 */
package com.cdgit.loan.csm.process.accInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmConCreditInfo;
import com.cdgit.loan.csm.mapper.CsmTbConAttachedInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbConZhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTzContractInfoVoMapper;
import com.cdgit.loan.csm.po.TbConAttachedInfoPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.po.TbConSubcontractPo;
import com.cdgit.loan.csm.po.TbConSubcontractRelPo;
import com.cdgit.loan.csm.po.TbConZhPo;

/**
 * @author Administrator
 *
 */
@Service
@Transactional
public class ContractApply {

	//TODO 合同调整待完成........
	
	@Autowired
	CsmTzContractInfoVoMapper csmTzContractInfoVoMapper;
	
	@Autowired
	CsmTbConAttachedInfoPoMapper csmTbConAttachedInfoPoMapper;
	
	@Autowired
	CsmTbConSubcontractMapper  csmTbConSubcontractMapper;
	
	@Autowired
	CsmTbConZhPoMapper csmTbConZhPoMapper;
	

	
	@Autowired
	CsmTbConSubcontractRelMapper csmTbConSubcontractRelMapper;
	
	/**
	 * @param contractId
	 * @param args
	 * @author 3231 合同调整
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TbConContractInfoPo tzConInfo(String contractId) {
		if (null == contractId || "".equals(contractId)) {
			throw new RuntimeException("调整时原合同ID为空");
		}
	
		TbConContractInfoPo tbConContractInfo=new TbConContractInfoPo();
		// 业务合同基本信息
		
		
		
		
		
		
		return tbConContractInfo;
		
		
		
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CsmConCreditInfo tzCreditInfo(String contractId) {
		if (null == contractId || "".equals(contractId)) {
			throw new RuntimeException("调整时原合同ID为空");
		}
	
		CsmConCreditInfo tbConCreditInfo=new CsmConCreditInfo();
		// 授信协议基本信息
		
		//账户信息
		List<TbConZhPo> tbConZhs = csmTbConZhPoMapper.queryListCsmTbConZhInfo(contractId);
		
		//附属信息
		TbConAttachedInfoPo conAttachedInfo = csmTbConAttachedInfoPoMapper.queryCsmTbConAttachedInfoPo(contractId);
		
		//担保合同信息 com.bos.dataset.crt.TbConSubcontractRel
		Map<String,String> map=new HashMap<String,String>();
		map.put("contractId", contractId);
		map.put("ifEffective", "1");
		List<TbConSubcontractRelPo> conRels= csmTbConSubcontractRelMapper.queryListCsmTbConSubcontractRelPo(map);
		
		// 新建合同信息并保存
		// 获取时间com.bos.pub.GitUtil.getBusiDate
		
		// 业务合同基本信息
		
		//....
		
		//账户信息
		
		//担保合同信息
		TbConSubcontractPo conSubcon = csmTbConSubcontractMapper.queryCsmTbConSubcontractPo(conRels.get(0).getSubcontractId());
		
		
		
		
		
		
		
		
		return tbConCreditInfo;
		
		
	}
	
	
	
	

}
