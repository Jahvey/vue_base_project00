/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbConSubcontractRelMapper;
import com.cdgit.loan.csm.po.TbConSubcontractRelPo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmTzContractInfoVoServiceImpl {

	
	@Autowired
	CsmTbConSubcontractRelMapper csmTbConSubcontractRelMapper;

	
	//查询担保合同
	public List<TbConSubcontractRelPo> queryListCsmTbConSubcontractRelPo(Map map) {
	
		List<TbConSubcontractRelPo> TbConSubcontractRelPo = csmTbConSubcontractRelMapper.queryListCsmTbConSubcontractRelPo(map);

		return TbConSubcontractRelPo;
	}
	
}
