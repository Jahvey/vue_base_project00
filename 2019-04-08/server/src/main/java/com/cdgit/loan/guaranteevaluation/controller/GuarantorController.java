package com.cdgit.loan.guaranteevaluation.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.constants.Constant;
import com.cdgit.loan.guaranteevaluation.service.GuarantorServiceImpl;
/**
 * 担保评价-保证人
 * @author wuyong
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/guarantorController")
public class GuarantorController {
	
	@Autowired
	private GuarantorServiceImpl guarantorServiceImpl;
	
	/**
	 * 获取客户信息，添加保证人
	 * @author wuyong
	 * 说明：1.若客户是自然人，直接返回自然人基本信息
	 *      2.若客户是对公，需要查询评级等级，还要判断是否是担保公司
	 *          2.1 不是担保公司，直接返回
	 *          2.2是担保公司，需要查询担保公司预用额度---》已用额度----》担保公司信息----》担保公司额度
	 * 
	 * */
	@GetMapping("/getPartyInfoByPartyId")
	@ResponseBody
	public Map<String, Object> getPartyInfoByPartyId(
			@RequestParam(value="partyId",required=true) String partyId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = guarantorServiceImpl.getPartyInfoByPartyId(partyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 根据业务申请id,查询TB_BIZ_APPLY
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/queryApplyInfoByApplyId")
	@ResponseBody
	public Map<String, Object> queryApplyInfoByApplyId(
			@RequestParam(value="applyId",required=true) String applyId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = guarantorServiceImpl.queryApplyInfoByApplyId(applyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 查询TB_CON_GUARANTE_QUOTA,担保公司为暂停新增时
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/queryCompanyStatus")
	@ResponseBody
	public Map<String, Object> queryCompanyStatus(
			//担保客户id
			@RequestParam(value="guarantorPartyId",required=true) String partyId,
			//客户id
			@RequestParam(value="partyId",required=true) String conPartyId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = guarantorServiceImpl.queryCompanyStatus(partyId,conPartyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 新增保证基本信息、保证人、业务与保证关联信息
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/addGuaranteeApplyTbGrtGuaranteer")
	@ResponseBody
	public Map<String, Object> addGuaranteeApplyTbGrtGuaranteer(
			@RequestParam(value="suretyAmt",required=true) BigDecimal suretyAmt,//担保金额
			@RequestParam(value="applyId",required=true) String applyId,//业务id
			@RequestParam(value="userNum",required=true) String userNum,//操作员
			@RequestParam(value="orgNum",required=true) String orgNum,//机构
			@RequestParam(value="guarantorPartyId",required=true) String partyId,//担保客户 id
			@RequestParam(value="accnoWay[]",required=false) String[] accnoWay,//保证金存储方式
			@RequestParam(value="currencyCd",required=true) String currencyCd,//币种
			@RequestParam(value="isGuaranteeCompany",required=true) String isGuaranteeCompany,//是否担保公司
			@RequestParam(value="guaranteeForm",required=true) String guaranteeForm//担保形式
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if(guaranteeForm!=null && guaranteeForm.equals("")){
				guaranteeForm = null;
			}
			map = guarantorServiceImpl.addGuaranteeApplyTbGrtGuaranteer(suretyAmt,applyId,userNum,
					orgNum,partyId,accnoWay,currencyCd,isGuaranteeCompany,guaranteeForm);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 更新保证基本信息、保证人、业务与保证关联信息
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/updateGuaranteeApplyTbGrtGuaranteer")
	@ResponseBody
	public Map<String, Object> updateGuaranteeApplyTbGrtGuaranteer(
			@RequestParam(value="suretyAmt",required=true) BigDecimal suretyAmt,//担保金额
			@RequestParam(value="applyId",required=true) String applyId,//业务id
			@RequestParam(value="userNum",required=true) String userNum,//操作员
			@RequestParam(value="orgNum",required=true) String orgNum,//机构
			@RequestParam(value="guarantorPartyId",required=true) String partyId,//担保客户 id
			@RequestParam(value="accnoWay[]",required=false) String[] accnoWay,//保证金存储方式
			@RequestParam(value="currencyCd",required=true) String currencyCd,//币种
			@RequestParam(value="suretyId",required=true) String suretyId,//担保id
			@RequestParam(value="isGuaranteeCompany",required=true) String isGuaranteeCompany,//是否担保公司
			@RequestParam(value="guaranteeForm",required=true) String guaranteeForm//担保形式
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if(guaranteeForm!=null && guaranteeForm.equals("")){
				guaranteeForm = null;
			}
			map = guarantorServiceImpl.updateGuaranteeApplyTbGrtGuaranteer(suretyId,suretyAmt,applyId,userNum,
					orgNum,partyId,accnoWay,currencyCd,isGuaranteeCompany,guaranteeForm);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 删除保证基本信息、保证人、业务与保证关联信息
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/deleteGuaranteeApplyTbGrtGuaranteerBySuretyId")
	@ResponseBody
	public Map<String, Object> deleteGuaranteeApplyTbGrtGuaranteerBySuretyId(
			@RequestParam(value="suretyId",required=true) String suretyId//担保基本信息id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = guarantorServiceImpl.deleteGuaranteeApplyTbGrtGuaranteerBySuretyId(suretyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 查询担保基金专用账户
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/selectGuaranteeConZh")
	@ResponseBody
	public Map<String, Object> selectGuaranteeConZh(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="statusCd",required=true) String statusCd,//合作协议状态
			@RequestParam(value="partyId",required=true) String partyId//担保公司id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = guarantorServiceImpl.selectGuaranteeConZh(statusCd,partyId,pageNum,pageSize);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 查询业务申请下关联 保证人
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/getGuaranteerList")
	@ResponseBody
	public Map<String, Object> getGuaranteerList(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="applyId",required=true) String applyId//业务id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = guarantorServiceImpl.getGuaranteerList(pageNum,pageSize,applyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 根据主键查询保证人信息
	 * @author 吴勇
	 * 
	 * 
	 * */
	@GetMapping("/getGuaranteerBySuretyId")
	@ResponseBody
	public Map<String, Object> getGuaranteerBySuretyId(
			@RequestParam(value="suretyId",required=true) String suretyId,//TB_GRT_GUARANTEE_BASIC---担保基本信息 主键(SURETY_ID)
			@RequestParam(value="applyId",required=true) String applyId//业务id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = guarantorServiceImpl.getGuaranteerBySuretyId(suretyId,applyId);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 获取已关联的担保合同
	 * @param collType
	 * @param applyId
	 * @return
	 */
	@GetMapping("/getMaxloanconList")
	@ResponseBody
	public Map<String, Object> getMaxloanconList(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="collType",required=true) String collType,//00即可抵押也可质押 01抵押 02质押 03保证金 04保证人 05信用保险
			@RequestParam(value="applyId",required=true) String applyId//业务id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = guarantorServiceImpl.getMaxloanconList(pageNum,pageSize,collType,applyId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 
	 * @param guarantyType
	 * @param phase
	 * @param applyId
	 * @return
	 */
	@GetMapping("/getBizGrtType")
	@ResponseBody
	public Map<String, Object> getBizGrtType(
			@RequestParam(value="guarantyType",required=true) String guarantyType,//00即可抵押也可质押 01抵押 02质押 03保证金 04保证人 05信用保险
			@RequestParam(value="phase",required=true) String phase,//biz crd
			@RequestParam(value="applyId",required=true) String applyId//业务id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = guarantorServiceImpl.getBizGrtType(applyId,phase,guarantyType);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 业务阶段保存引入最高额关联合同
	 * @param params
	 * @return
	 */
	@PostMapping("/addMaxloancon")
	public Map<String, Object> addMaxloancon(
			@RequestBody Map<String, Object> params
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String applyId = params.get("applyId").toString();
			String subcontractId = params.get("subcontractId").toString();
			String reType = params.get("reType").toString();
			map = guarantorServiceImpl.addMaxloancon(applyId,subcontractId,reType);
		} catch (Exception e) {
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 删引入除最高额担保合同关联
	 * @param maxloanconId
	 * @return
	 */
	@GetMapping("/deleteMaxloancon")
	@ResponseBody
	public Map<String, Object> deleteMaxloancon(
			@RequestParam(value="maxloanconId",required=true) String maxloanconId
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = guarantorServiceImpl.deleteMaxloancon(maxloanconId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
}
