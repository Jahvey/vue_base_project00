package com.cdgit.loan.securitymanagement.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.securitymanagement.bean.GrtCollateralInsurance;
import com.cdgit.loan.securitymanagement.service.GrtCollateralInsuranceServiceImpl;

/**
 * 保险 controller
 * @author wuyong
 * @date 2018.12.29
 *
 */
@RestController
@RequestMapping("/grtCollateralInsurance")
public class GrtCollateralInsuranceController {
	@Autowired
	private GrtCollateralInsuranceServiceImpl grtCollateralInsuranceServiceImpl;
	//查询保险信息
	@PostMapping("/getAllCollateralInsurance")
	public Map<String,Object> getAllCollateralInsurance(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("pageNum") ==null || m.get("pageSize") ==null || m.get("guarantyId")==null||
				   m.get("pageNum").equals("") || m.get("pageSize").equals("") ||
				   m.get("guarantyId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				Integer pageNum = Integer.parseInt(m.get("pageNum").toString());
				Integer pageSize = Integer.parseInt(m.get("pageSize").toString());
				String guarantyId = m.get("guarantyId")==null ? null : m.get("guarantyId").toString();
				String insuranceCompanyName = m.get("insuranceCompanyName")==null ? null : m.get("insuranceCompanyName").toString();
				String insurancePolicyNum = m.get("insurancePolicyNum")==null ? null : m.get("insurancePolicyNum").toString();
				String policyHolder = m.get("policyHolder")==null ? null : m.get("policyHolder").toString();
				map=grtCollateralInsuranceServiceImpl.getAllCollateralInsurance(pageNum,pageSize,guarantyId,insuranceCompanyName
						,insurancePolicyNum,policyHolder);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		}else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	//通过主键删除保险信息
	@PostMapping("/deleteCollateralInsuranceById")
	public Map<String,Object> deleteCollateralInsuranceById(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("insuranceId") ==null ||
				   m.get("insuranceId").equals("") 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String insuranceId = m.get("insuranceId").toString();
				map=grtCollateralInsuranceServiceImpl.deleteCollateralInsuranceById(insuranceId);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		}else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	//批量删除保险信息
	@PostMapping("/deleteCollateralInsuranceBatch")
	public Map<String,Object> deleteCollateralInsuranceBatch(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> list = (List<Map<String, Object>>)params.get("params");
				if(list==null || list.size()<=0){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String[] ids = new String[list.size()];
				for(int i=0;i<list.size();i++){
					ids[i] = list.get(i).get("insuranceId").toString();
				}
				map=grtCollateralInsuranceServiceImpl.deleteCollateralInsuranceBatch(ids);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		}else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	//添加保险信息信息
	@PostMapping("/saveCollateralInsurance")
	public Map<String,Object> saveCollateralInsurance(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("insuranceCompanyName") ==null || m.get("insuranceType") ==null ||
				   m.get("insuranceBenefitiary") ==null || m.get("insuranceAmt") ==null ||
				   m.get("effectiveDate") ==null || m.get("endDate") ==null ||
				   m.get("insurancePolicyNum") ==null || m.get("policyHolder") ==null ||
				   m.get("currencyCd") ==null || m.get("startDate") ==null ||
				   m.get("guarantyId") ==null ||  m.get("guarantyId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String insuranceCompanyName = m.get("insuranceCompanyName").toString();
				String insuranceType = m.get("insuranceType").toString();
				String insuranceBenefitiary = m.get("insuranceBenefitiary").toString();
				String insuranceAmt = m.get("insuranceAmt").toString();
				String effectiveDate = m.get("effectiveDate").toString();
				String endDate = m.get("endDate").toString();
				String insurancePolicyNum = m.get("insurancePolicyNum").toString();
				String policyHolder = m.get("policyHolder").toString();
				String currencyCd = m.get("currencyCd").toString();
				String startDate = m.get("startDate").toString();
				String guarantyId = m.get("guarantyId").toString();
				String insuranceTermsInstruction = m.get("insuranceTermsInstruction")== null ? null : m.get("insuranceTermsInstruction").toString();
				String insuranceKind = m.get("insuranceKind")== null ? null : m.get("insuranceKind").toString();
				String certificateCode = m.get("certificateCode")== null ? null : m.get("certificateCode").toString();
				String certificateType = m.get("certificateType")== null ? null : m.get("certificateType").toString();
				String loanmanname = m.get("loanmanname")== null ? null : m.get("loanmanname").toString();
				String loanmanContractNum = m.get("loanmanContractNum")== null ? null : m.get("loanmanContractNum").toString();
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
				GrtCollateralInsurance grtCollateralInsurance = new GrtCollateralInsurance();
				grtCollateralInsurance.setGuarantyId(guarantyId);
				grtCollateralInsurance.setInsuranceCompanyName(insuranceCompanyName);
				grtCollateralInsurance.setInsuranceType(insuranceType);
				grtCollateralInsurance.setInsuranceBenefitiary(insuranceBenefitiary);
				grtCollateralInsurance.setInsuranceAmt(new BigDecimal(insuranceAmt));
				grtCollateralInsurance.setEffectiveDate(formate.parse(effectiveDate));
				grtCollateralInsurance.setEndDate(formate.parse(endDate));
				grtCollateralInsurance.setInsurancePolicyNum(insurancePolicyNum);
				grtCollateralInsurance.setPolicyHolder(policyHolder);
				grtCollateralInsurance.setCurrencyCd(currencyCd);
				grtCollateralInsurance.setStartDate(formate.parse(startDate));
				grtCollateralInsurance.setSysUpdateTime(new Date());
				grtCollateralInsurance.setInsuranceTermsInstruction(insuranceTermsInstruction);
				grtCollateralInsurance.setInsuranceKind(insuranceKind);
				grtCollateralInsurance.setCertificateCode(certificateCode);
				grtCollateralInsurance.setCertificateType(certificateType);
				grtCollateralInsurance.setLoanmanContractNum(loanmanContractNum);
				grtCollateralInsurance.setLoanmanname(loanmanname);
				grtCollateralInsurance.setInsuranceId(UUIDGenerator.getUUID());
				map=grtCollateralInsuranceServiceImpl.saveCollateralInsurance(grtCollateralInsurance);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		}else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	
	//更新保险信息信息
	@PostMapping("/updateCollateralInsurance")
	public Map<String,Object> updateCollateralInsurance(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("insuranceCompanyName") ==null || m.get("insuranceType") ==null ||
				   m.get("insuranceBenefitiary") ==null || m.get("insuranceAmt") ==null ||
				   m.get("effectiveDate") ==null || m.get("endDate") ==null ||
				   m.get("insurancePolicyNum") ==null || m.get("policyHolder") ==null ||
				   m.get("currencyCd") ==null || m.get("startDate") ==null ||
				   m.get("guarantyId") ==null ||  m.get("guarantyId").equals("") ||
				   m.get("insuranceId") ==null ||  m.get("insuranceId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String insuranceCompanyName = m.get("insuranceCompanyName").toString();
				String insuranceType = m.get("insuranceType").toString();
				String insuranceBenefitiary = m.get("insuranceBenefitiary").toString();
				String insuranceAmt = m.get("insuranceAmt").toString();
				String effectiveDate = m.get("effectiveDate").toString();
				String endDate = m.get("endDate").toString();
				String insurancePolicyNum = m.get("insurancePolicyNum").toString();
				String policyHolder = m.get("policyHolder").toString();
				String currencyCd = m.get("currencyCd").toString();
				String startDate = m.get("startDate").toString();
				String guarantyId = m.get("guarantyId").toString();
				String insuranceId = m.get("insuranceId").toString();
				String insuranceTermsInstruction = m.get("insuranceTermsInstruction")== null ? null : m.get("insuranceTermsInstruction").toString();
				String insuranceKind = m.get("insuranceKind")== null ? null : m.get("insuranceKind").toString();
				String certificateCode = m.get("certificateCode")== null ? null : m.get("certificateCode").toString();
				String certificateType = m.get("certificateType")== null ? null : m.get("certificateType").toString();
				String loanmanname = m.get("loanmanname")== null ? null : m.get("loanmanname").toString();
				String loanmanContractNum = m.get("loanmanContractNum")== null ? null : m.get("loanmanContractNum").toString();
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
				GrtCollateralInsurance grtCollateralInsurance = new GrtCollateralInsurance();
				grtCollateralInsurance.setGuarantyId(guarantyId);
				grtCollateralInsurance.setInsuranceCompanyName(insuranceCompanyName);
				grtCollateralInsurance.setInsuranceType(insuranceType);
				grtCollateralInsurance.setInsuranceBenefitiary(insuranceBenefitiary);
				grtCollateralInsurance.setInsuranceAmt(new BigDecimal(insuranceAmt));
				grtCollateralInsurance.setEffectiveDate(formate.parse(effectiveDate));
				grtCollateralInsurance.setEndDate(formate.parse(endDate));
				grtCollateralInsurance.setInsurancePolicyNum(insurancePolicyNum);
				grtCollateralInsurance.setPolicyHolder(policyHolder);
				grtCollateralInsurance.setCurrencyCd(currencyCd);
				grtCollateralInsurance.setStartDate(formate.parse(startDate));
				grtCollateralInsurance.setSysUpdateTime(new Date());
				grtCollateralInsurance.setInsuranceTermsInstruction(insuranceTermsInstruction);
				grtCollateralInsurance.setInsuranceKind(insuranceKind);
				grtCollateralInsurance.setCertificateCode(certificateCode);
				grtCollateralInsurance.setCertificateType(certificateType);
				grtCollateralInsurance.setLoanmanContractNum(loanmanContractNum);
				grtCollateralInsurance.setLoanmanname(loanmanname);
				grtCollateralInsurance.setInsuranceId(insuranceId);
				map=grtCollateralInsuranceServiceImpl.updateCollateralInsurance(grtCollateralInsurance);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		}else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
}
