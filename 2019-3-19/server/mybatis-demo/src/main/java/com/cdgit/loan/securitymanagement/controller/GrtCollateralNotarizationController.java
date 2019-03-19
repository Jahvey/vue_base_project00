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
import com.cdgit.loan.securitymanagement.bean.GrtCollateralNotarization;
import com.cdgit.loan.securitymanagement.service.GrtCollateralNotarizationServiceImpl;

/**
 * 公证 controller
 * @author wuyong
 * @date 2018.12.29
 *
 */
@RestController
@RequestMapping("/grtCollateralNotarization")
public class GrtCollateralNotarizationController {
	@Autowired
	private GrtCollateralNotarizationServiceImpl grtCollateralNotarizationServiceImpl;
	//查询公证信息
	@PostMapping("/getAllCollateralNotarization")
	public Map<String,Object> getAllCollateralNotarization(@RequestBody Map<String, Object> params){
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
				String guarantyId = m.get("guarantyId").toString();
				//借款合同号
				String loanContractNum = m.get("loanContractNum")==null ? null : m.get("loanContractNum").toString();
				//借款人名称
				String loanManName = m.get("loanManName")==null ? null : m.get("loanManName").toString();
				//借款人证件类型
				String loanCertificateType = m.get("loanCertificateType")==null ? null : m.get("loanCertificateType").toString();
				//证件号码
				String certificateCode = m.get("certificateCode")==null ? null : m.get("certificateCode").toString();
				//公证书编号
				String notarialDeedNo = m.get("notarialDeedNo")==null ? null : m.get("notarialDeedNo").toString();
				//公证机构
				String notarialOrg = m.get("notarialOrg")==null ? null : m.get("notarialOrg").toString();
				//登记日期
				//String recordDate = m.get("recordDate")==null ? null : m.get("recordDate").toString();
				map=grtCollateralNotarizationServiceImpl.getAllCollateralNotarization(pageNum,pageSize,guarantyId,loanContractNum
						,loanManName,loanCertificateType,certificateCode,notarialDeedNo,notarialOrg);
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
	//通过主键删除公证信息
	@PostMapping("/deleteCollateralNotarizationById")
	public Map<String,Object> deleteCollateralNotarizationById(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("notarizationId") ==null ||
				   m.get("notarizationId").equals("") 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String notarizationId = m.get("notarizationId").toString();
				map=grtCollateralNotarizationServiceImpl.deleteCollateralNotarizationById(notarizationId);
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
	//批量删除公证信息
	@PostMapping("/deleteCollateralNotarizationBatch")
	public Map<String,Object> deleteCollateralNotarizationBatch(@RequestBody Map<String, Object> params){
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
					ids[i] = list.get(i).get("notarizationId").toString();
				}
				map=grtCollateralNotarizationServiceImpl.deleteCollateralNotarizationBatch(ids);
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
	//添加公证信息信息
	@PostMapping("/saveCollateralNotarization")
	public Map<String,Object> saveCollateralNotarization(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("loanContractNum") ==null || m.get("loanManName") ==null ||
				   //m.get("loanCertificateType") ==null || m.get("certificateCode") ==null ||
				   m.get("notarialDeedNo") ==null || m.get("notarialOrg") ==null ||
				   m.get("recordDate") ==null ||
				   m.get("guarantyId") ==null ||  m.get("guarantyId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String loanContractNum = m.get("loanContractNum").toString();
				String loanManName = m.get("loanManName").toString();
				String loanCertificateType = m.get("loanCertificateType")==null ? null : m.get("loanCertificateType").toString();
				String notarialDeedNo = m.get("notarialDeedNo").toString();
				String notarialOrg = m.get("notarialOrg").toString();
				String recordDate = m.get("recordDate").toString();
				String certificateCode = m.get("certificateCode")==null ? null : m.get("certificateCode").toString();
				String guarantyId = m.get("guarantyId").toString();
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
				GrtCollateralNotarization grtCollateralNotarization = new GrtCollateralNotarization();
				grtCollateralNotarization.setGuarantyId(guarantyId);
				grtCollateralNotarization.setLoanContractNum(loanContractNum);
				grtCollateralNotarization.setLoanManName(loanManName);
				grtCollateralNotarization.setLoanCertificateType(loanCertificateType);
				grtCollateralNotarization.setNotarialDeedNo(notarialDeedNo);
				grtCollateralNotarization.setNotarialOrg(notarialOrg);
				grtCollateralNotarization.setCertificateCode(certificateCode);
				grtCollateralNotarization.setNotarizationId(UUIDGenerator.getUUID());
				grtCollateralNotarization.setRecordDate(formate.parse(recordDate));
				map=grtCollateralNotarizationServiceImpl.saveCollateralNotarization(grtCollateralNotarization);
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
	
	//更新公证信息信息
	@PostMapping("/updateCollateralNotarization")
	public Map<String,Object> updateCollateralNotarization(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("loanContractNum") ==null || m.get("loanManName") ==null ||
						   //m.get("loanCertificateType") ==null || m.get("certificateCode") ==null ||
						   m.get("notarialDeedNo") ==null || m.get("notarialOrg") ==null ||
						   m.get("recordDate") ==null ||
						   m.get("guarantyId") ==null ||  m.get("guarantyId").equals("") ||
						   m.get("notarizationId") ==null ||  m.get("notarizationId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String loanContractNum = m.get("loanContractNum").toString();
				String loanManName = m.get("loanManName").toString();
				String loanCertificateType = m.get("loanCertificateType")==null ? null : m.get("loanCertificateType").toString();
				String notarialDeedNo = m.get("notarialDeedNo").toString();
				String notarialOrg = m.get("notarialOrg").toString();
				String recordDate = m.get("recordDate").toString();
				String certificateCode = m.get("certificateCode")==null ? null : m.get("certificateCode").toString();
				String guarantyId = m.get("guarantyId").toString();
				String notarizationId = m.get("notarizationId").toString();
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
				GrtCollateralNotarization grtCollateralNotarization = new GrtCollateralNotarization();
				grtCollateralNotarization.setGuarantyId(guarantyId);
				grtCollateralNotarization.setLoanContractNum(loanContractNum);
				grtCollateralNotarization.setLoanManName(loanManName);
				grtCollateralNotarization.setLoanCertificateType(loanCertificateType);
				grtCollateralNotarization.setNotarialDeedNo(notarialDeedNo);
				grtCollateralNotarization.setNotarialOrg(notarialOrg);
				grtCollateralNotarization.setCertificateCode(certificateCode);
				grtCollateralNotarization.setNotarizationId(notarizationId);
				grtCollateralNotarization.setRecordDate(formate.parse(recordDate));
				map=grtCollateralNotarizationServiceImpl.updateCollateralNotarization(grtCollateralNotarization);
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
