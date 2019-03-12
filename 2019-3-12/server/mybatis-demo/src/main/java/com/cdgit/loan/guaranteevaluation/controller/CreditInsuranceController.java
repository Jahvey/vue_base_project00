package com.cdgit.loan.guaranteevaluation.controller;
/**
 * 担保评价-信用保险
 * @author wuyong
 *
 */

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.guaranteevaluation.bean.BizGrtRel;
import com.cdgit.loan.guaranteevaluation.bean.GrtCreditsafe;
import com.cdgit.loan.guaranteevaluation.bean.GrtGuaranteeBasic;
import com.cdgit.loan.guaranteevaluation.service.CreditInsuranceServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/creditInsuranceController")
public class CreditInsuranceController {
	@Autowired
	private CreditInsuranceServiceImpl creditInsuranceServiceImpl;
	/**
	 * 根据业务申请id,查询信用保险列表
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/getCreditsafeList")
	@ResponseBody
	public Map<String, Object> getCreditsafeList(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="applyId",required=true) String applyId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = creditInsuranceServiceImpl.getCashDepositList(pageNum,pageSize,applyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 保存信用保险
	 * @author 吴勇
	 * 
	 *               policyHolder:"",//投保人
              insurer:"",//保险人
              beneficiary:"",//受益人
              policyNum:"",//保单号
              ndemnityNum:"",//赔款转让协议编号
              currencyCd:"",//币种
              creditLimit:"",//信用限额
              effectiveDate:"",//生效日期
              endDate:"",//到期日期
              minLossRate:"",//最低偿债比例（%）
              guaranteeMoney:"",//本次担保金额
              guaranteeType:this.info.collType,//担保类型
              partyId:this.info.partyId,//客户编号
              applyId:this.info.applyId,//业务id
	 * */
	@GetMapping("/addGuaranteeApplyTbGrtCreditsafe")
	@ResponseBody
	public Map<String, Object> addGuaranteeApplyTbGrtCreditsafe(
			@RequestParam(value="policyHolder",required=true) String policyHolder,//
			@RequestParam(value="insurer",required=true) String insurer,//
			@RequestParam(value="beneficiary",required=true) String beneficiary,//
			@RequestParam(value="policyNum",required=true) String policyNum,//
			@RequestParam(value="ndemnityNum",required=true) String ndemnityNum,//
			@RequestParam(value="currencyCd",required=true) String currencyCd,//
			@RequestParam(value="creditLimit",required=true) BigDecimal creditLimit,//
			@RequestParam(value="effectiveDate",required=true) String effectiveDate,//
			@RequestParam(value="endDate",required=true) String endDate,//
			@RequestParam(value="minLossRate",required=true) BigDecimal minLossRate,//
			@RequestParam(value="guaranteeMoney",required=true) BigDecimal guaranteeMoney,//
			@RequestParam(value="guaranteeType",required=true) String guaranteeType,//
			@RequestParam(value="partyId",required=true) String partyId,//
			@RequestParam(value="applyId",required=true) String applyId,
			@RequestParam(value="userNum",required=true) String userNum,
			@RequestParam(value="orgNum",required=true) String orgNum
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			GrtGuaranteeBasic grtGuaranteeBasic = new GrtGuaranteeBasic();
			grtGuaranteeBasic.setCreateTime(date);
			grtGuaranteeBasic.setCurrencyCd(currencyCd);
			grtGuaranteeBasic.setGuaranteeType(guaranteeType);
			grtGuaranteeBasic.setOrgNum(orgNum);
			grtGuaranteeBasic.setUserNum(userNum);
			grtGuaranteeBasic.setSuretyAmt(guaranteeMoney);
			grtGuaranteeBasic.setUpdateTime(date);
			grtGuaranteeBasic.setSuretyId(UUIDGenerator.getUUID());
			grtGuaranteeBasic.setPartyId(partyId);
			GrtCreditsafe grtCreditsafe = new GrtCreditsafe();
			grtCreditsafe.setSuretyId(grtGuaranteeBasic.getSuretyId());
			grtCreditsafe.setCurrencyCd(currencyCd);
			grtCreditsafe.setBeneficiary(beneficiary);
			grtCreditsafe.setCreditLimit(creditLimit);
			grtCreditsafe.setEffectiveDate(format.parse(effectiveDate));
			grtCreditsafe.setEndDate(format.parse(endDate));
			grtCreditsafe.setGuaranteeMoney(guaranteeMoney);
			grtCreditsafe.setInsurer(insurer);
			grtCreditsafe.setMinLossRate(minLossRate);
			grtCreditsafe.setNdemnityNum(ndemnityNum);
			grtCreditsafe.setPolicyHolder(policyHolder);
			grtCreditsafe.setPolicyNum(policyNum);
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setCreateTime(date);
			bizGrtRel.setRelationId(UUIDGenerator.getUUID());
			bizGrtRel.setSuretyAmt(guaranteeMoney);
			bizGrtRel.setSuretyId(grtGuaranteeBasic.getSuretyId());
			bizGrtRel.setSuretyType(guaranteeType);
			bizGrtRel.setUpdateTime(date);
			map = creditInsuranceServiceImpl.addGuaranteeApplyTbGrtCreditsafe(grtGuaranteeBasic,grtCreditsafe,bizGrtRel);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 根据suretyId,查询信用保险
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/getTbGrtCreditsafeBySuretyId")
	@ResponseBody
	public Map<String, Object> getTbGrtCreditsafeBySuretyId(
			@RequestParam(value="suretyId",required=true) String suretyId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = creditInsuranceServiceImpl.getTbGrtCreditsafeBySuretyId(suretyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 更新信用保险
	 * @author 吴勇
	 * */
	@GetMapping("/updateGuaranteeApplyTbGrtCreditsafe")
	@ResponseBody
	public Map<String, Object> updateGuaranteeApplyTbGrtCreditsafe(
			@RequestParam(value="policyHolder",required=true) String policyHolder,//
			@RequestParam(value="insurer",required=true) String insurer,//
			@RequestParam(value="beneficiary",required=true) String beneficiary,//
			@RequestParam(value="policyNum",required=true) String policyNum,//
			@RequestParam(value="ndemnityNum",required=true) String ndemnityNum,//
			@RequestParam(value="currencyCd",required=true) String currencyCd,//
			@RequestParam(value="creditLimit",required=true) BigDecimal creditLimit,//
			@RequestParam(value="effectiveDate",required=true) String effectiveDate,//
			@RequestParam(value="endDate",required=true) String endDate,//
			@RequestParam(value="minLossRate",required=true) BigDecimal minLossRate,//
			@RequestParam(value="guaranteeMoney",required=true) BigDecimal guaranteeMoney,//
			@RequestParam(value="guaranteeType",required=true) String guaranteeType,//
			@RequestParam(value="partyId",required=true) String partyId,//
			@RequestParam(value="suretyId",required=true) String suretyId,
			@RequestParam(value="userNum",required=true) String userNum,
			@RequestParam(value="orgNum",required=true) String orgNum
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try{
			GrtGuaranteeBasic grtGuaranteeBasic = new GrtGuaranteeBasic();
			grtGuaranteeBasic.setCreateTime(date);
			grtGuaranteeBasic.setCurrencyCd(currencyCd);
			grtGuaranteeBasic.setGuaranteeType(guaranteeType);
			grtGuaranteeBasic.setOrgNum(orgNum);
			grtGuaranteeBasic.setUserNum(userNum);
			grtGuaranteeBasic.setSuretyAmt(guaranteeMoney);
			grtGuaranteeBasic.setUpdateTime(date);
			grtGuaranteeBasic.setSuretyId(suretyId);
			grtGuaranteeBasic.setPartyId(partyId);
			GrtCreditsafe grtCreditsafe = new GrtCreditsafe();
			grtCreditsafe.setSuretyId(suretyId);
			grtCreditsafe.setCurrencyCd(currencyCd);
			grtCreditsafe.setBeneficiary(beneficiary);
			grtCreditsafe.setCreditLimit(creditLimit);
			grtCreditsafe.setEffectiveDate(format.parse(effectiveDate));
			grtCreditsafe.setEndDate(format.parse(endDate));
			grtCreditsafe.setGuaranteeMoney(guaranteeMoney);
			grtCreditsafe.setInsurer(insurer);
			grtCreditsafe.setMinLossRate(minLossRate);
			grtCreditsafe.setNdemnityNum(ndemnityNum);
			grtCreditsafe.setPolicyHolder(policyHolder);
			grtCreditsafe.setPolicyNum(policyNum);
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setSuretyId(suretyId);
			bizGrtRel.setCreateTime(date);
			bizGrtRel.setSuretyAmt(guaranteeMoney);
			bizGrtRel.setSuretyType(guaranteeType);
			bizGrtRel.setUpdateTime(date);
			map = creditInsuranceServiceImpl.updateGuaranteeApplyTbGrtCreditsafe(grtGuaranteeBasic,grtCreditsafe,bizGrtRel);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 根据suretyId,删除信用保险
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/delTbGrtCreditsafeBySuretyId")
	@ResponseBody
	public Map<String, Object> delTbGrtCreditsafeBySuretyId(
			@RequestParam(value="suretyId",required=true) String suretyId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = creditInsuranceServiceImpl.delTbGrtCreditsafeBySuretyId(suretyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
}
