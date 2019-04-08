package com.cdgit.loan.guaranteevaluation.controller;

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
import com.cdgit.loan.guaranteevaluation.bean.GrtMargin;
import com.cdgit.loan.guaranteevaluation.service.DepositServiceImpl;
import com.cdgit.loan.securitymanagement.bean.GrtCollateral;

/**
 * 担保评价-保证金
 * @author wuyong
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/depositController")
public class DepositController {
	
	
	@Autowired
	private DepositServiceImpl depositServiceImpl;
	/**
	 * 根据业务申请id,查询保证金列表
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/getCashDepositList")
	@ResponseBody
	public Map<String, Object> getCashDepositList(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="applyId",required=true) String applyId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = depositServiceImpl.getCashDepositList(pageNum,pageSize,applyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 保存保证金信息
	 * @author wuyong
	 * @param applyId
	 * @param partyId
	 * @param collType 担保类型，00即可抵押也可质押 01抵押 02质押 03保证金 04保证人 05信用保险
	 * @param userNum
	 * @param orgNum
	 * @param acctName 账户名称
	 * @param marginAccount 保证金账号
	 * @param marginSort 保证金类型
	 * @param openBank 开户行
	 * @param currencyCd 币种
	 * @param accBalance 保证金金额
	 * @param beginDate 起始日期
	 * @param endDate 到期日期
	 * @param marginRate 执行利率
	 * @param appendFlag 追加标志
	 * @return
	 */
	@GetMapping("/saveDeposit")
	@ResponseBody
	public Map<String, Object> saveDeposit(
			@RequestParam(value="applyId",required=true) String applyId,//
			@RequestParam(value="partyId",required=true) String partyId,//
			@RequestParam(value="collType",required=true) String collType,//
			@RequestParam(value="userNum",required=true) String userNum,//
			@RequestParam(value="orgNum",required=true) String orgNum,//
			@RequestParam(value="acctName",required=true) String acctName,//
			@RequestParam(value="marginAccount",required=true) String marginAccount,//
			@RequestParam(value="marginSort",required=true) String marginSort,//
			@RequestParam(value="openBank",required=true) String openBank,//
			@RequestParam(value="currencyCd",required=true) String currencyCd,//
			@RequestParam(value="accBalance",required=true) BigDecimal accBalance,//
			@RequestParam(value="beginDate",required=true) String beginDate,//
			@RequestParam(value="endDate",required=true) String endDate,//
			@RequestParam(value="marginRate",required=false) BigDecimal marginRate,//
			@RequestParam(value="appendFlag",required=false) String appendFlag
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date date = depositServiceImpl.getOperateDate("yyyy-MM-dd");
			String suretyKeyId = UUIDGenerator.getUUID();
			String suretyId = UUIDGenerator.getUUID();
			String relationId = UUIDGenerator.getUUID();
			GrtCollateral grtCollateral = new GrtCollateral();
			grtCollateral.setGuarantyId(suretyId);
			grtCollateral.setMpType(collType);
			grtCollateral.setTimeMark(date);
			grtCollateral.setSysUpdateTime(date);
			grtCollateral.setDataCreatorOrgCd(orgNum);
			grtCollateral.setDataCreatUserNum(userNum);
			grtCollateral.setLastUpdateOrgCd(orgNum);
			grtCollateral.setLastUpdateUserNum(userNum);
			grtCollateral.setCollateralNum(suretyKeyId);
			grtCollateral.setCollateralName("*保证金*");
			grtCollateral.setCustomerNum(partyId);
			GrtMargin grtMargin = new GrtMargin();
			grtMargin.setAccBalance(accBalance);
			grtMargin.setAcctName(acctName);
			grtMargin.setBeginDate(format.parse(beginDate));
			grtMargin.setCreateTime(date);
			grtMargin.setCurrencyCd(currencyCd);
			grtMargin.setEndDate(format.parse(endDate));
			grtMargin.setAppendFlag(appendFlag);
			grtMargin.setMarginRate(marginRate);
			grtMargin.setMarginSort(marginSort);
			grtMargin.setOpenBank(openBank);
			grtMargin.setOrgNum(orgNum);
			grtMargin.setSuretyId(suretyId);
			grtMargin.setSuretyKeyId(suretyKeyId);
			grtMargin.setUpdateTime(date);
			grtMargin.setUserNum(userNum);
			grtMargin.setMarginAccount(marginAccount);
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setCreateTime(date);
			bizGrtRel.setSuretyId(suretyId);
			bizGrtRel.setUpdateTime(date);
			//TODO 是否将保证金金额设置为担保金额
			bizGrtRel.setMortgageValue(accBalance);
			bizGrtRel.setSuretyType(collType);
			bizGrtRel.setSuretyId(suretyId);
			bizGrtRel.setRelationId(relationId);
			map = depositServiceImpl.saveDeposit(grtCollateral,grtMargin,bizGrtRel);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 保存保证金信息
	 * @author wuyong
	 * @param applyId
	 * @param partyId
	 * @param collType 担保类型，00即可抵押也可质押 01抵押 02质押 03保证金 04保证人 05信用保险
	 * @param userNum
	 * @param orgNum
	 * @param acctName 账户名称
	 * @param marginAccount 保证金账号
	 * @param marginSort 保证金类型
	 * @param openBank 开户行
	 * @param currencyCd 币种
	 * @param accBalance 保证金金额
	 * @param beginDate 起始日期
	 * @param endDate 到期日期
	 * @param marginRate 执行利率
	 * @param appendFlag 追加标志
	 * @return
	 */
	@GetMapping("/updateDeposit")
	@ResponseBody
	public Map<String, Object> updateDeposit(
			@RequestParam(value="suretyKeyId",required=true) String suretyKeyId,//
			@RequestParam(value="suretyId",required=true) String suretyId,//
			@RequestParam(value="relationId",required=true) String relationId,//
			@RequestParam(value="applyId",required=true) String applyId,//
			@RequestParam(value="partyId",required=true) String partyId,//
			@RequestParam(value="collType",required=true) String collType,//
			@RequestParam(value="userNum",required=true) String userNum,//
			@RequestParam(value="orgNum",required=true) String orgNum,//
			@RequestParam(value="acctName",required=true) String acctName,//
			@RequestParam(value="marginAccount",required=true) String marginAccount,//
			@RequestParam(value="marginSort",required=true) String marginSort,//
			@RequestParam(value="openBank",required=true) String openBank,//
			@RequestParam(value="currencyCd",required=true) String currencyCd,//
			@RequestParam(value="accBalance",required=true) BigDecimal accBalance,//
			@RequestParam(value="beginDate",required=true) String beginDate,//
			@RequestParam(value="endDate",required=true) String endDate,//
			@RequestParam(value="marginRate",required=false) BigDecimal marginRate,//
			@RequestParam(value="appendFlag",required=false) String appendFlag
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try{
			GrtCollateral grtCollateral = new GrtCollateral();
			grtCollateral.setGuarantyId(suretyId);
			grtCollateral.setMpType(collType);
			grtCollateral.setSysUpdateTime(date);
			grtCollateral.setLastUpdateOrgCd(orgNum);
			grtCollateral.setLastUpdateUserNum(userNum);
			grtCollateral.setCustomerNum(partyId);
			grtCollateral.setCurrencyCd(currencyCd);
			grtCollateral.setMpType(collType);
			grtCollateral.setCollateralNum(suretyKeyId);
			
			GrtMargin grtMargin = new GrtMargin();
			grtMargin.setAccBalance(accBalance);
			grtMargin.setAcctName(acctName);
			grtMargin.setBeginDate(format.parse(beginDate));
			grtMargin.setCurrencyCd(currencyCd);
			grtMargin.setEndDate(format.parse(endDate));
			grtMargin.setAppendFlag(appendFlag);
			grtMargin.setMarginRate(marginRate);
			grtMargin.setMarginSort(marginSort);
			grtMargin.setOpenBank(openBank);
			grtMargin.setOrgNum(orgNum);
			grtMargin.setSuretyId(suretyId);
			grtMargin.setSuretyKeyId(suretyKeyId);
			grtMargin.setUpdateTime(date);
			grtMargin.setUserNum(userNum);
			grtMargin.setMarginAccount(marginAccount);
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setSuretyId(suretyId);
			bizGrtRel.setUpdateTime(date);
			//TODO 是否将保证金金额设置为担保金额
			//bizGrtRel.setMortgageValue(accBalance);
			bizGrtRel.setSuretyType(collType);
			bizGrtRel.setSuretyId(suretyId);
			bizGrtRel.setRelationId(relationId);
			map = depositServiceImpl.updateDeposit(grtCollateral,grtMargin,bizGrtRel);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 根据SuretyKeyId删除保证金信息
	 * @param suretyId
	 * @return
	 */
	@GetMapping("/deleteDepositBySuretyKeyId")
	@ResponseBody
	public Map<String, Object> deleteDepositBySuretyKeyId(
			@RequestParam(value="suretyKeyId",required=true) String suretyKeyId,
			@RequestParam(value="suretyId",required=true) String suretyId,
			@RequestParam(value="relationId",required=true) String relationId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = depositServiceImpl.deleteDepositBySuretyKeyId(suretyKeyId,suretyId,relationId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 根据SuretyKeyId查询保证金信息
	 * @param suretyId
	 * @return
	 */
	@GetMapping("/selectDepositBySuretyKeyId")
	@ResponseBody
	public Map<String, Object> selectDepositBySuretyKeyId(
			@RequestParam(value="suretyKeyId",required=true) String suretyKeyId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = depositServiceImpl.selectDepositBySuretyKeyId(suretyKeyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
}
