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
import com.cdgit.loan.guaranteevaluation.bean.GrtMortgageBasic;
import com.cdgit.loan.guaranteevaluation.service.GrtMortgageBasicServiceImpl;

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
	 * collType：00即可抵押也可质押 01抵押 02质押 03保证金 04保证人 05信用保险
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
			@RequestParam(value="collType",required=true) String collType,//抵押01、质押02
			@RequestParam(value="applyId",required=true) String applyId//业务id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = grtMortgageBasicServiceImpl.getMortgageList(pageNum,pageSize,collType,applyId);
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
			@RequestParam(value="collType",required=true) String collType,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="certNum",required=false) String certNum
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = grtMortgageBasicServiceImpl.getCollateralList(pageNum,pageSize,customerType,collType,partyName,certType,certNum);
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
	 * @param partyName 抵质押人
	 * @param suretyName 抵质押物名称
	 * @param currencyCd 币种
	 * @param marketValue 抵质押物认定价值(元)
	 * @param usedAmt 已设定担保额(元)
	 * @param totalKhAmt 抵质押品占用价值(元)
	 * @param suretyAmt 本次实际担保债权金额(元)
	 * @param collType 抵质押类型
	 * @param suretyNo 抵质押物id
	 * @param applyId 业务id
	 * @param userNum 
	 * @param orgNum
	 * @param sortType 抵质押物类型
	 * @param assessValue 评估价值
	 * @param ifOtherCommon 是否有共有人
	 * @param mybankSetValue 我行已设定担保额
	 * @return
	 */
	@GetMapping("/saveMortgageBasic")
	@ResponseBody
	public Map<String, Object> saveMortgageBasic(
			@RequestParam(value="applyId",required=true) String applyId,
			@RequestParam(value="partyId",required=true) String partyId,
			@RequestParam(value="partyName",required=true) String partyName,
			@RequestParam(value="suretyName",required=true) String suretyName,
			@RequestParam(value="currencyCd",required=true) String currencyCd,
			@RequestParam(value="marketValue",required=true) BigDecimal marketValue,//TODO 暂时未设置
			@RequestParam(value="usedAmt",required=true) BigDecimal usedAmt,//TODO 暂时未设置
			@RequestParam(value="totalKhAmt",required=true) BigDecimal totalKhAmt,
			@RequestParam(value="suretyAmt",required=true) BigDecimal suretyAmt,
			@RequestParam(value="collType",required=true) String collType,
			@RequestParam(value="suretyNo",required=true) String suretyNo,
			@RequestParam(value="suretyId",required=true) String suretyId,
			@RequestParam(value="userNum",required=true) String userNum,
			@RequestParam(value="orgNum",required=true) String orgNum,
			@RequestParam(value="sortType",required=true) String sortType,
			@RequestParam(value="assessValue",required=false) BigDecimal assessValue,
			@RequestParam(value="ifOtherCommon",required=false) String ifOtherCommon,
			@RequestParam(value="mybankSetValue",required=false) BigDecimal mybankSetValue
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		try{
			GrtMortgageBasic grtMortgageBasic = new GrtMortgageBasic();
			grtMortgageBasic.setPartyId(partyId);
			grtMortgageBasic.setSuretyName(suretyName);
			grtMortgageBasic.setCurrencyCd(currencyCd);
			grtMortgageBasic.setTotalKhAmt(totalKhAmt);
			grtMortgageBasic.setSuretyAmt(suretyAmt);
			grtMortgageBasic.setCollType(collType);
			grtMortgageBasic.setSuretyNo(suretyNo);
			grtMortgageBasic.setIfOtherCommon(ifOtherCommon);
			grtMortgageBasic.setSortType(sortType);
			grtMortgageBasic.setAssessValue(assessValue);
			grtMortgageBasic.setMybankSetValue(mybankSetValue);
			grtMortgageBasic.setUserNum(userNum);
			grtMortgageBasic.setOrgNum(orgNum);
			grtMortgageBasic.setCreateTime(date);
			grtMortgageBasic.setUpdateTime(date);
			grtMortgageBasic.setSuretyId(suretyId);
			//计算抵质押率
			BigDecimal mortgageRate = ((suretyAmt.divide(totalKhAmt,6,BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal("100"))).setScale(4, BigDecimal.ROUND_HALF_UP);
			grtMortgageBasic.setMortgageRate(mortgageRate);
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setCreateTime(date);
			bizGrtRel.setUpdateTime(date);
			bizGrtRel.setSuretyId(grtMortgageBasic.getSuretyId());
			bizGrtRel.setMortgageRate(mortgageRate);
			bizGrtRel.setSuretyType(collType);
			bizGrtRel.setSuretyAmt(suretyAmt);
			bizGrtRel.setRelationId(UUIDGenerator.getUUID());
			map = grtMortgageBasicServiceImpl.saveMortgageBasic(grtMortgageBasic,bizGrtRel);
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
	 * @param partyName 抵质押人
	 * @param suretyName 抵质押物名称
	 * @param currencyCd 币种
	 * @param marketValue 抵质押物认定价值(元)
	 * @param usedAmt 已设定担保额(元)
	 * @param totalKhAmt 抵质押品占用价值(元)
	 * @param suretyAmt 本次实际担保债权金额(元)
	 * @param collType 抵质押类型
	 * @param suretyNo 抵质押物id
	 * @param applyId 业务id
	 * @param relationId 业务id
	 * @param suretyId 业务id
	 * @param userNum 
	 * @param orgNum
	 * @param sortType 抵质押物类型
	 * @param assessValue 评估价值
	 * @param ifOtherCommon 是否有共有人
	 * @param mybankSetValue 我行已设定担保额
	 * @return
	 */
	@GetMapping("/updateMortgageBasic")
	@ResponseBody
	public Map<String, Object> updateMortgageBasic(
			@RequestParam(value="applyId",required=true) String applyId,
			@RequestParam(value="relationId",required=true) String relationId,
			@RequestParam(value="suretyId",required=true) String suretyId,
			@RequestParam(value="partyId",required=true) String partyId,
			@RequestParam(value="partyName",required=true) String partyName,
			@RequestParam(value="suretyName",required=true) String suretyName,
			@RequestParam(value="currencyCd",required=true) String currencyCd,
			@RequestParam(value="marketValue",required=true) BigDecimal marketValue,//TODO 暂时未设置
			@RequestParam(value="usedAmt",required=true) BigDecimal usedAmt,//TODO 暂时未设置
			@RequestParam(value="totalKhAmt",required=true) BigDecimal totalKhAmt,
			@RequestParam(value="suretyAmt",required=true) BigDecimal suretyAmt,
			@RequestParam(value="collType",required=true) String collType,
			@RequestParam(value="suretyNo",required=true) String suretyNo,
			@RequestParam(value="userNum",required=true) String userNum,
			@RequestParam(value="orgNum",required=true) String orgNum,
			@RequestParam(value="sortType",required=true) String sortType,
			@RequestParam(value="assessValue",required=false) BigDecimal assessValue,
			@RequestParam(value="ifOtherCommon",required=false) String ifOtherCommon,
			@RequestParam(value="mybankSetValue",required=false) BigDecimal mybankSetValue
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		try{
			GrtMortgageBasic grtMortgageBasic = new GrtMortgageBasic();
			grtMortgageBasic.setPartyId(partyId);
			grtMortgageBasic.setSuretyName(suretyName);
			grtMortgageBasic.setCurrencyCd(currencyCd);
			grtMortgageBasic.setTotalKhAmt(totalKhAmt);
			grtMortgageBasic.setSuretyAmt(suretyAmt);
			grtMortgageBasic.setCollType(collType);
			grtMortgageBasic.setSuretyNo(suretyNo);
			grtMortgageBasic.setIfOtherCommon(ifOtherCommon);
			grtMortgageBasic.setSortType(sortType);
			grtMortgageBasic.setAssessValue(assessValue);
			grtMortgageBasic.setMybankSetValue(mybankSetValue);
			grtMortgageBasic.setUserNum(userNum);
			grtMortgageBasic.setOrgNum(orgNum);
			grtMortgageBasic.setUpdateTime(date);
			grtMortgageBasic.setSuretyId(suretyId);
			//计算抵质押率
			BigDecimal mortgageRate = ((suretyAmt.divide(totalKhAmt,6,BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal("100"))).setScale(4, BigDecimal.ROUND_HALF_UP);
			grtMortgageBasic.setMortgageRate(mortgageRate);
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setUpdateTime(date);
			bizGrtRel.setSuretyId(grtMortgageBasic.getSuretyId());
			bizGrtRel.setMortgageRate(mortgageRate);
			bizGrtRel.setSuretyType(collType);
			bizGrtRel.setSuretyAmt(suretyAmt);
			bizGrtRel.setRelationId(relationId);
			map = grtMortgageBasicServiceImpl.updateMortgageBasic(grtMortgageBasic,bizGrtRel);
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
	@GetMapping("/selectMortgageBasicBySuretyId")
	@ResponseBody
	public Map<String, Object> selectMortgageBasicBySuretyId(
			@RequestParam(value="suretyId",required=true) String suretyId//TB_GRT_MORTGAGE_BASIC 主键
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = grtMortgageBasicServiceImpl.selectMortgageBasicBySuretyId(suretyId);
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
	@GetMapping("/deleteMortgageBasicBySuretyId")
	@ResponseBody
	public Map<String, Object> deleteMortgageBasicBySuretyId(
			@RequestParam(value="suretyId",required=true) String suretyId//TB_GRT_MORTGAGE_BASIC 主键
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = grtMortgageBasicServiceImpl.deleteMortgageBasicBySuretyId(suretyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
}
