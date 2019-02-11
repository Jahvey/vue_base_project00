/**
 * 
 */
package com.cdgit.loan.csm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.mapper.CsmTbConAttachedInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbConZhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTzContractInfoVoMapper;
import com.cdgit.loan.csm.po.TbConAttachedInfoPo;
import com.cdgit.loan.csm.po.TbConSubcontractPo;
import com.cdgit.loan.csm.po.TbConSubcontractRelPo;
import com.cdgit.loan.csm.po.TbConZhPo;
import com.cdgit.loan.csm.service.CsmTzContractInfoVoServiceImpl;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("contractApply")
public class CsmTzContractInfoVoController {

	@Autowired
	CsmTzContractInfoVoServiceImpl csmTzContractInfoVoServiceImpl;

	@Autowired
	CsmTzContractInfoVoMapper csmTzContractInfoVoMapper;
	
	@Autowired
	CsmTbConAttachedInfoPoMapper csmTbConAttachedInfoPoMapper;
	
	@Autowired
	CsmTbConSubcontractMapper  csmTbConSubcontractMapper;
	
	@Autowired
	CsmTbConSubcontractRelMapper csmTbConSubcontractRelMapper;
	
	
	@Autowired
	CsmTbConZhPoMapper csmTbConZhPoMapper;
	
	
	//TODO 明天测试........
	

	// 查询账户信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryListCsmTbConZhInfo")
	public List<TbConZhPo> queryListCsmTbConZhInfo(String contractId) {

		List<TbConZhPo> SubContractListVo = csmTbConZhPoMapper.queryListCsmTbConZhInfo(contractId);
		System.err.println(SubContractListVo.get(0));

		return SubContractListVo;

	}

	// 附属信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryCsmTbConAttachedInfoPo")
	public TbConAttachedInfoPo queryCsmTbConAttachedInfoPo(String contractId) {

		TbConAttachedInfoPo SubContractListVo = csmTbConAttachedInfoPoMapper.queryCsmTbConAttachedInfoPo(contractId);
		System.err.println(SubContractListVo);

		return SubContractListVo;

	}

	// 担保信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryListCsmTbConSubcontractRel") //TODO 有问题 还需要调试。。。..... /解決了postman缓存问题
	public List<TbConSubcontractRelPo> queryListCsmTbConSubcontractRel(String ifEffective, String contractId) {

		Map map = new HashMap<String, String>();

		map.put("ifEffective", ifEffective);
		map.put("contractId", contractId);
		List<TbConSubcontractRelPo> TbConSubcontractRelPo = csmTzContractInfoVoServiceImpl.queryListCsmTbConSubcontractRelPo(map);

		return TbConSubcontractRelPo;

	}

	// @GetMapping("/testDemo") //有问题 还需要调试。。。
	// public List<TbConSubcontractRelPo> testDemo(String ifEffective, String
	// contractId){
	//
	// Map map=new HashMap<String,String>();
	// map.put("ifEffective", ifEffective);
	// map.put("contractId", contractId);
	// List<TbConSubcontractRelPo> listCsmTbCon =
	// csmTzContractInfoVoServiceImpl.queryListCsmTbCon(map);
	// return listCsmTbCon;
	//
	//
	// }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryCsmTbConSubcontractPo")
	public TbConSubcontractPo queryCsmTbConSubcontractPo(String subcontractId) {

		TbConSubcontractPo ApproveConsVo = csmTbConSubcontractMapper.queryCsmTbConSubcontractPo(subcontractId);
		return ApproveConsVo;

	}

}
