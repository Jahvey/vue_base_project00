package com.cdgit.loan.customerManage.controller;

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

import com.cdgit.loan.customerManage.bean.NaturalPerson;
import com.cdgit.loan.customerManage.service.NaturalPersonServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/customer/natural")
public class NaturalPersonController {
	
	@Autowired
	NaturalPersonServiceImpl naturalPersonService;
	
	/**
	 * 
	 * startPgae(页码，每页几条数据)
	 * @ResponseBody()将返回的page转换为json对象由页面的js进行解析	
	 * 查询自然客户分页列表
	 * <p>Title: findUser</p>  	
	 * <p>Description: </p>  	
	 * @param omOrganizationCriteria
	 * @return
	 */
	@PostMapping("/naturalPerson")
	@ResponseBody
	public Map<String, Object> naturalPerson(@RequestBody Map<String, Object> params){
		String pageNum = "1";
		String pageSize = "20";
		String partyNum = "";
		String partyName = "";
		String certType = "";
		String certNum = "";
		String isPotentialCust = "";
		String isFarmer = "";
		String phoneNumber = "";
		String unitAdress = "";
		if(params.get("pageNum") != null){
			pageNum = params.get("pageNum").toString();
		}
		if(params.get("pageSize") != null){
			pageSize = params.get("pageSize").toString();
		}
		if(params.get("partyNum") != null){
			partyNum = params.get("partyNum").toString();
		}
		if(params.get("partyName") != null){
			partyName = params.get("partyName").toString();
		}
		if(params.get("certType") != null){
			certType = params.get("certType").toString();
		}
		if(params.get("certNum") != null){
			certNum = params.get("certNum").toString();
		}
		if(params.get("isPotentialCust") != null){
			isPotentialCust = params.get("isPotentialCust").toString();
		}
		if(params.get("isFarmer") != null){
			isFarmer = params.get("isFarmer").toString();
		}
		if(params.get("phoneNumber") != null){
			phoneNumber = params.get("phoneNumber").toString();
		}
		if(params.get("unitAdress") != null){
			unitAdress = params.get("unitAdress").toString();
		}
		Map<String, Object> map = naturalPersonService.naturalPersonList(Integer.valueOf(pageNum), Integer.valueOf(pageSize), partyNum
				, partyName, certType, certNum, isPotentialCust, isFarmer, phoneNumber, unitAdress);
		return map;
	}
	
	/**
	 * 新增自然人客户
	 * 
	 * */
	@PostMapping("/addNatural")
	@ResponseBody
	public Map<String, Object> addNatural(@RequestBody NaturalPerson naturalPerson) {
		Map<String, Object> map = naturalPersonService.addNatural(naturalPerson);
		return map;
	}
	
	/**
	 * 根据partyId查询自然人参与人信息
	 * 
	 * */
	@PostMapping("/queryNaturalByPartyId")
	@ResponseBody
	public Map<String, Object> queryNaturalByPartyId(@RequestBody Map<String, Object> params) {
		String partyId = "";
		if(params.get("partyId") != null){
			partyId = params.get("partyId").toString();
		}
		Map<String, Object> map = naturalPersonService.queryNaturalByPartyId(partyId);
		return map;
	}
	
	/**
	 * 编辑自然人客户
	 * 
	 * */
	@PostMapping("/editNatural")
	@ResponseBody
	public Map<String, Object> editNatural(@RequestBody NaturalPerson naturalPerson) {
		Map<String, Object> map = naturalPersonService.editNatural(naturalPerson);
		return map;
	}
	
	
	/**
	 * 查询自然或者对公客户,新增保证人使用
	 * @author 吴勇
	 * TODO 说明：查询了自然人和对公客户，与Controller描述不太匹配，是否更改？
	 * 
	 * */
	@GetMapping("/selectCustomerAllByPartyTypeCd")
	@ResponseBody
	public Map<String, Object> selectCustomerAllByPartyTypeCd(
			//自然人和对公客户共有参数
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="partyName",required=false) String partyName,
			//对公客户使用
			@RequestParam(value="orgRegisterCd",required=false) String orgRegisterCd,
			@RequestParam(value="registrCd",required=false) String registrCd,
			@RequestParam(value="unifySocietyCreditNum",required=false) String unifySocietyCreditNum,
			//客户类型,必须
			@RequestParam(value="partyTypeCd",required=true) String partyTypeCd,
			@RequestParam(value="legOrg",required=true) String legOrg,
			@RequestParam(value="pageNum",required=true) Integer pageNum,
			@RequestParam(value="pageSize",required=true) Integer pageSize
			
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = naturalPersonService.selectCustomerAllByPartyTypeCd(pageNum,pageSize,legOrg,partyTypeCd,certType,certNum,partyName,orgRegisterCd,registrCd,unifySocietyCreditNum);
		}catch(Exception e){
			map.put("flag", "error");
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}

	
}
