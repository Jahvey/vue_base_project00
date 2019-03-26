/**
 * 
 */
package com.cdgit.loan.csm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.ApplyJxhjBizInfoVo;
import com.cdgit.loan.csm.bean.CsmTbBizAmountDetailApply;
import com.cdgit.loan.csm.bean.CsmTbBizAmoutApply;
import com.cdgit.loan.csm.bean.CsmTbBizApply;
import com.cdgit.loan.csm.bean.CsmTbBizFamilyFinace;
import com.cdgit.loan.csm.bean.CsmTbBizXmxxApply;
import com.cdgit.loan.csm.bean.CsmTbBizXwApply;
import com.cdgit.loan.csm.bean.CsmTbBizYesOrNoApply;
import com.cdgit.loan.csm.bean.CsmTbConLoanrate;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.service.CsmBizApplyServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("bizApply")
public class CsmBizApplyController {
	
	@Autowired
	CsmBizApplyServiceImpl csmBizApplyServiceImpl;
	
	/**
	 * 保存业务申请基本信息
	 * 
	 * */
	@PostMapping("/saveAppBizInfo")
	@ResponseBody
	public Map<String, Object> saveAppBizInfo(@RequestBody CsmTbBizApply csmTbBizApply) {
		Map<String, Object> map = csmBizApplyServiceImpl.saveAppBizInfo(csmTbBizApply);
		return map;
	}
	
	/**
	 * 更新业务申请基本信息
	 * 
	 * */
	@PostMapping("/updateAppBizInfo")
	@ResponseBody
	public Map<String, Object> updateAppBizInfo(@RequestBody CsmTbBizApply csmTbBizApply) {
		Map<String, Object> map = csmBizApplyServiceImpl.updateAppBizInfo(csmTbBizApply);
		return map;
	}
	
	/**
	 * 保存更新业务明细
	 * 
	 * */
	@PostMapping("/saveAndUpdateXwProductDetail")
	@ResponseBody
	public Map<String, Object> saveAndUpdateXwProductDetail(@RequestBody CsmTbBizAmountDetailApply amountDetailApply, CsmTbConLoanrate loanrate, 
    		CsmTbBizXwApply xwApply, CsmTbBizAmoutApply amoutApply, CsmTbBizApply apply) {
		Map<String, Object> map = csmBizApplyServiceImpl.saveAndUpdateXwProductDetail(amountDetailApply, loanrate
				, xwApply, amoutApply, apply);
		return map;
	}
	
	/**
	 * 保存更新家庭财务信息
	 * 
	 * */
	@PostMapping("/saveAndUpdateFamilyFinace")
	@ResponseBody
	public Map<String, Object> saveAndUpdateFamilyFinace(@RequestBody CsmTbBizFamilyFinace familyFinace) {
		Map<String, Object> map = csmBizApplyServiceImpl.saveAndUpdateFamilyFinace(familyFinace);
		return map;
	}
	
	/**
	 * 保存更新合作项目额度
	 * 
	 * */
	@PostMapping("/saveAndUpdateXmxxApply")
	@ResponseBody
	public Map<String, Object> saveAndUpdateXmxxApply(@RequestBody CsmTbBizXmxxApply xmxxApply) {
		Map<String, Object> map = csmBizApplyServiceImpl.saveAndUpdateXmxxApply(xmxxApply);
		return map;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getApplyJxhjBizInfo")
	public PageBean getApplyJxhjBizInfo(
			@RequestParam(value="pageNum",required=true) int pageNum, 
			@RequestParam(value="pageSize",required=true) int pageSize,
			
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="bizNum",required=false)String bizNum,
			@RequestParam(value="summaryNum",required=false)String summaryNum){
		
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		
		map.put("bizNum", bizNum);
		map.put("partyId", partyId);
		map.put("summaryNum", summaryNum);
	
		PageInfo<ApplyJxhjBizInfoVo> ApplyJxhjBizInfoVo = csmBizApplyServiceImpl.getApplyJxhjBizInfo(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(ApplyJxhjBizInfoVo.getTotal());
		pageBean.setData(ApplyJxhjBizInfoVo.getList());
		
		return pageBean;
	
		
	}
	
	/**
	 * 保存更新监管保送信息
	 * 
	 * */
	@PostMapping("/saveAndUpdateYesOrNoApply")
	@ResponseBody
	public Map<String, Object> saveAndUpdateYesOrNoApply(@RequestBody CsmTbBizYesOrNoApply yesOrNoApply) {
		Map<String, Object> map = csmBizApplyServiceImpl.saveAndUpdateYesOrNoApply(yesOrNoApply);
		return map;
	}

}
