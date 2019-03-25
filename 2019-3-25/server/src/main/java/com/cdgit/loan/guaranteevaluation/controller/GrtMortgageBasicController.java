package com.cdgit.loan.guaranteevaluation.controller;

import java.math.BigDecimal;
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
import com.cdgit.loan.guaranteevaluation.service.GrtMortgageBasicServiceImpl;
import com.cdgit.loan.securitymanagement.bean.GrtCollateral;

/**
 * 担保评价-押品controller（抵押、质押）
 * @author wuyong
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/grtMortgageBasicController")
public class GrtMortgageBasicController {
	@Autowired
	private GrtMortgageBasicServiceImpl grtMortgageBasicServiceImpl;
	/**
	 * 查询指定业务的押品信息
	 * @author wuyong
	 * mpType：00即可抵押也可质押 01抵押 02质押 03保证金 04保证人 05信用保险
	 * 对于此方法该参数只能是：00,01,02
	 * 03是在对应的保证金的DepositController方法中查询，
	 * 04在保证人GuarantorController方法中查询
	 * 05在信用保险中查询CreditInsuranceController
	 * 
	 * */
	@GetMapping("/getMortgageList")
	@ResponseBody
	public Map<String, Object> getMortgageList(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="suretyType",required=true) String suretyType,//抵押01、质押02
			@RequestParam(value="applyId",required=true) String applyId//业务id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = grtMortgageBasicServiceImpl.getMortgageList(pageNum,pageSize,suretyType,applyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 担保评价，获取抵质押品信息
	 * @param pageNum
	 * @param pageSize
	 * @param customerType
	 * @return
	 */
	@GetMapping("/getCollateralList")
	@ResponseBody
	public Map<String, Object> getCollateralList(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="customerType",required=true) String customerType,
			@RequestParam(value="mpType",required=true) String mpType,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="certNum",required=false) String certNum
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = grtMortgageBasicServiceImpl.getCollateralList(pageNum,pageSize,customerType,mpType,partyName,certType,certNum);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 保存担保评价抵押、质押信息
	 * @author wuyong
	 * @return
	 */
	@GetMapping("/saveMortgageBasic")
	@ResponseBody
	public Map<String, Object> saveMortgageBasic(
			@RequestParam(value="applyId",required=true) String applyId,
			@RequestParam(value="suretyAmt",required=true) BigDecimal suretyAmt,//本次实际担保债权金额
			@RequestParam(value="suretyType",required=true) String suretyType,//抵质押类型
			@RequestParam(value="suretyId",required=true) String suretyId,
			@RequestParam(value="setGuarantyAmt",required=true) BigDecimal setGuarantyAmt,//已设定担保额
			@RequestParam(value="mortgageValue",required=true) BigDecimal mortgageValue//抵质押品占用价值
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		try{
			//计算抵质押率
			BigDecimal mortgageRate = ((suretyAmt.divide(mortgageValue,6,BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal("100"))).setScale(4, BigDecimal.ROUND_HALF_UP);
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setCreateTime(date);
			bizGrtRel.setUpdateTime(date);
			bizGrtRel.setSuretyId(suretyId);
			bizGrtRel.setMortgageRate(mortgageRate);
			bizGrtRel.setSuretyType(suretyType);
			bizGrtRel.setSuretyAmt(suretyAmt);
			bizGrtRel.setMortgageValue(mortgageValue);
			bizGrtRel.setRelationId(UUIDGenerator.getUUID());
			GrtCollateral grtCollateral = new GrtCollateral();
			setGuarantyAmt = setGuarantyAmt.add(mortgageValue);
			grtCollateral.setGuarantyId(suretyId);
			grtCollateral.setSetGuarantyAmt(setGuarantyAmt);
			grtCollateral.setSysUpdateTime(date);
			map = grtMortgageBasicServiceImpl.saveMortgageBasic(grtCollateral,bizGrtRel);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 更新担保评价抵押、质押信息
	 * @author wuyong
	 * @return
	 */
	@GetMapping("/updateMortgageBasic")
	@ResponseBody
	public Map<String, Object> updateMortgageBasic(
			@RequestParam(value="relationId",required=true) String relationId,
			@RequestParam(value="suretyAmt",required=true) BigDecimal suretyAmt,//本次实际担保债权金额
			@RequestParam(value="suretyType",required=true) String suretyType,//抵质押类型
			@RequestParam(value="suretyId",required=true) String suretyId,
			@RequestParam(value="setGuarantyAmt",required=true) BigDecimal setGuarantyAmt,//已设定担保额
			@RequestParam(value="mortgageValue",required=true) BigDecimal mortgageValue,//抵质押品占用价值
			@RequestParam(value="oldMortgageValue",required=true) BigDecimal oldMortgageValue,//（原值）抵质押品占用价值
			@RequestParam(value="oldSetGuarantyAmt",required=true) BigDecimal oldSetGuarantyAmt//（原值）已设定担保额
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		try{
			//计算抵质押率
			BigDecimal mortgageRate = ((suretyAmt.divide(mortgageValue,6,BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal("100"))).setScale(4, BigDecimal.ROUND_HALF_UP);
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setUpdateTime(date);
			bizGrtRel.setMortgageRate(mortgageRate);
			bizGrtRel.setSuretyType(suretyType);
			bizGrtRel.setSuretyAmt(suretyAmt);
			bizGrtRel.setRelationId(relationId);
			bizGrtRel.setMortgageValue(mortgageValue);
			GrtCollateral grtCollateral = new GrtCollateral();
			setGuarantyAmt = oldSetGuarantyAmt.subtract(oldMortgageValue).add(mortgageValue);
			grtCollateral.setGuarantyId(suretyId);
			grtCollateral.setSetGuarantyAmt(setGuarantyAmt);
			grtCollateral.setSysUpdateTime(date);
			map = grtMortgageBasicServiceImpl.updateMortgageBasic(grtCollateral,bizGrtRel);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 根据suretyId查询关联抵质押品信息
	 * @param suretyId
	 * @return
	 */
	@GetMapping("/selectMortgageBasicByRelationId")
	@ResponseBody
	public Map<String, Object> selectMortgageBasicBySuretyId(
			@RequestParam(value="relationId",required=true) String relationId//
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = grtMortgageBasicServiceImpl.selectMortgageBasicByRelationId(relationId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 根据suretyId删除关联抵质押品信息
	 * @param suretyId
	 * @return
	 */
	@GetMapping("/deleteMortgageByRelationId")
	@ResponseBody
	public Map<String, Object> deleteMortgageByRelationId(
			@RequestParam(value="relationId",required=true) String relationId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = grtMortgageBasicServiceImpl.deleteMortgageByRelationId(relationId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
}
