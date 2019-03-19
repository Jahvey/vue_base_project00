package com.cdgit.loan.irm.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.guaranteevaluation.service.GuarantorServiceImpl;
import com.cdgit.loan.irm.bean.AdJustInfoBean;
import com.cdgit.loan.irm.bean.AddFinanceinfoCriteria;
import com.cdgit.loan.irm.bean.AddNonFinancialInfoCriteria;
import com.cdgit.loan.irm.bean.NonFinanceInfoBean;
import com.cdgit.loan.irm.bean.TbIrmAdjustOptions;
import com.cdgit.loan.irm.bean.TbIrmIndexScore;
import com.cdgit.loan.irm.service.IrmServiceImpl;
import com.cdgit.loan.user.bean.TbIrmInternalRatingApply;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 保证人相关bean
 * @author GIT-cd
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/irmController")
public class IrmController {
	
	@Autowired
	private IrmServiceImpl irmServiceImpl;
	
	/**
	 * 获取客户评级信息
	 * @author yanglong
	 * 说明：1.若客户是自然人，直接返回自然人基本信息
	 *      2.若客户是对公，需要查询评级等级，还要判断是否是担保公司
	 *          2.1 不是担保公司，直接返回
	 *          2.2是担保公司，需要查询担保公司预用额度---》已用额度----》担保公司信息----》担保公司额度
	 * 
	 * */
	@PostMapping("/queryPaginationIrm")
	@ResponseBody
	public Map<String, Object> queryPaginationIrm(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "20";
		String partyId = null;
		String thirdPartyTypeCd = null;
		if(params.get("pageNum") != null){
			pageNum = params.get("pageNum").toString();
		}
		if(params.get("pageSize") != null){
			pageSize = params.get("pageSize").toString();
		}
		if (params.get("partyId") != null) {
			partyId = params.get("partyId").toString();
		}
		if (params.get("thirdPartyTypeCd") != null) {
			thirdPartyTypeCd = params.get("thirdPartyTypeCd").toString();
		}
		Map<String, Object> map = irmServiceImpl.queryPaginationIrm(Integer.valueOf(pageNum), Integer.valueOf(pageSize), partyId,thirdPartyTypeCd);
		return map;
	}
	@PostMapping("/createIrmApply")
	@ResponseBody
	public Map<String, Object> createIrmApply(@RequestBody Map<String, Object> params){
		String partyId = null;
		boolean choose = false;
		String pjlx = null;
		if(params.get("partyId") != null){
			partyId = params.get("partyId").toString();
		}
		if(params.get("choose") != null){
			choose = (boolean)params.get("choose");
		}
		if (params.get("pjlx") != null) {
			pjlx = params.get("pjlx").toString();
		}
		Map<String, Object> map = irmServiceImpl.createIrmApply(partyId, choose, pjlx);
		return map;
	}
	
	@PostMapping("/queryRatingApplyInfo")
	@ResponseBody
	public Map<String, Object> queryRatingApplyInfo(@RequestBody Map<String, Object> params){
		String applyId = null;
		if(params.get("applyId") != null){
			applyId = params.get("applyId").toString();
		}
		Map<String, Object> map = irmServiceImpl.queryRatingApplyInfo(applyId);
		return map;
	}	
	@PostMapping("/getIsProject")
	@ResponseBody
	public Map<String, Object> getIsProject(@RequestBody Map<String, Object> params){
		String applyId = null;
		if(params.get("applyId") != null){
			applyId = params.get("applyId").toString();
		}
		Map<String, Object> map = irmServiceImpl.getIsProject(applyId);
		return map;
	}
	@PostMapping("/getIrmRatingApplyInfo")
	@ResponseBody
	public Map<String, Object> getIrmRatingApplyInfo(@RequestBody Map<String, Object> params){
		String applyId = null;
		if(params.get("applyId") != null){
			applyId = params.get("applyId").toString();
		}
		Map<String, Object> map = irmServiceImpl.getIrmRatingApplyInfo(applyId);
		return map;
	}	
	
	@PostMapping("/queryCustInfoJj")
	@ResponseBody
	public Map<String, Object> queryCustInfoJj(@RequestBody Map<String, Object> params){
		String applyId = null;
		String partyId = null;
		if(params.get("applyId") != null){
			applyId = params.get("applyId").toString();
		}
		if(params.get("partyId") != null){
			partyId = params.get("partyId").toString();
		}
		Map<String, Object> map = irmServiceImpl.queryCustInfoJj(partyId, applyId);
		return map;
	}	
	
	@PostMapping("/queryReportNonFinanceinfo")
	@ResponseBody
	public Map<String, Object> queryReportNonFinanceinfo(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "5";
		String applyId = null;
		if(params.get("applyId") != null){
			applyId = params.get("applyId").toString();
		}
		Map<String, Object> map = irmServiceImpl.queryReportNonFinanceinfo(Integer.valueOf(pageNum), Integer.valueOf(pageSize),applyId);
		return map;
	}
	@PostMapping("/queryOpitionInfo")
	@ResponseBody
	public Map<String, Object> queryOpitionInfo(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "5";
		String applyId = null;
		if(params.get("applyId") != null){
			applyId = params.get("applyId").toString();
		}
		Map<String, Object> map = irmServiceImpl.queryOpitionInfo(Integer.valueOf(pageNum), Integer.valueOf(pageSize),applyId);
		return map;
	}
	@PostMapping("/queryOverRecordInfo")
	@ResponseBody
	public Map<String, Object> queryOverRecordInfo(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "5";
		String applyId = null;
		String oldApplyId = null;
		if(params.get("applyId") != null){
			applyId = params.get("applyId").toString();
		}
		if(params.get("oldApplyId") != null){
			oldApplyId = params.get("oldApplyId").toString();
		}
		
		Map<String, Object> map = irmServiceImpl.queryOverRecordInfo(Integer.valueOf(pageNum), Integer.valueOf(pageSize),applyId,oldApplyId);
		return map;
	}
	@PostMapping("/queryNonFinanceInfo")
	@ResponseBody
	public Map<String, Object> queryNonFinanceInfo(@RequestBody Map<String, Object> params){
		
		String applyId = null;
		if(params.get("applyId") != null){
			applyId = params.get("applyId").toString();
		}
		
		Map<String, Object> map = irmServiceImpl.queryNonFinanceInfo(applyId);
		return map;
	}
	
	@PostMapping("/queryHasFinanceInfo")
	@ResponseBody
	public Map<String, Object> queryHasFinanceInfo(@RequestBody Map<String, Object> params){
		
		String partyId = null;
		if(params.get("partyId") != null){
			partyId = params.get("partyId").toString();
		}
		
		Map<String, Object> map = irmServiceImpl.queryHasFinanceInfo(partyId);
		return map;
	}
	
	@PostMapping("/addFinancialInfo")
	@ResponseBody
	public Map<String, String> addFinancialInfo(@RequestBody AddFinanceinfoCriteria params){
		
		Map<String, String> map = irmServiceImpl.addAndUpdateFinanceInfo(params);
		return map;
	}
	
	@PostMapping("/addNonFinancialInfo")
	@ResponseBody
	public Map<String, String> addNonFinancialInfo(@RequestBody AddNonFinancialInfoCriteria criteria){
		
		Map<String, String> map = irmServiceImpl.addNonFinancialInfo(criteria);
		return map;
	}
	@PostMapping("/getModeScaleToCombobx")
	@ResponseBody
	public Map<String, Object> addNonFinancialInfo(@RequestBody Map<String, String> params){
		String modelTypeCd = null;
		if(params.get("modelTypeCd") != null){
			modelTypeCd = params.get("modelTypeCd").toString();
		}
		Map<String,Object> map = irmServiceImpl.getModeScaleToCombobx(modelTypeCd);
		return map;
	}
	@PostMapping("/getIrmApplyCd")
	@ResponseBody
	public Map<String, Object> getIrmApplyCd(@RequestBody Map<String, String> params){
		String applyId = null;
		if(params.get("applyId") != null){
			applyId = params.get("applyId").toString();
		}
		Map<String,Object> map = irmServiceImpl.getIrmApplyCd(applyId);
		return map;
	}
	@PostMapping("/saveIrmApplyCd")
	@ResponseBody
	public Map<String, String> saveIrmApplyCd(@RequestBody AdJustInfoBean adJustInfoBean){
		
		Map<String, String> map = irmServiceImpl.saveIrmApplyCd(adJustInfoBean);
		return map;
	}
	@PostMapping("/queryInitialRatingCd")
	@ResponseBody
	public Map<String, String> queryInitialRatingCd(@RequestBody Map<String, String> params){
		String applyId = null;
		String oldApplyId = null;
		if(params.get("applyId") != null){
			applyId = params.get("applyId").toString();
		}
		if(params.get("oldApplyId") != null){
			oldApplyId = params.get("oldApplyId").toString();
		}
		Map<String,String> map = irmServiceImpl.queryInitialRatingCd(applyId,oldApplyId);
		return map;
	}
	
	
}
