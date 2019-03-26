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
import com.cdgit.loan.securitymanagement.bean.GrtCollateralRegistration;
import com.cdgit.loan.securitymanagement.service.GrtCollateralRegistrationServiceImpl;

/**
 * 登记 controller
 * @author wuyong
 * @date 2018.12.29
 *
 */
@RestController
@RequestMapping("/grtCollateralRegistration")
public class GrtCollateralRegistrationController {
	@Autowired
	private GrtCollateralRegistrationServiceImpl grtCollateralRegistrationServiceImpl;
	//查询登记信息
	@PostMapping("/getAllCollateralRegistration")
	public Map<String,Object> getAllCollateralRegistration(@RequestBody Map<String, Object> params){
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
				//登记编号
				String registerNum = m.get("registerNum")==null ? null : m.get("registerNum").toString();
				//登记类型
				String registerOrgTypeCd = m.get("registerOrgTypeCd")==null ? null : m.get("registerOrgTypeCd").toString();
				//登记机构名称
				String registerOrgName = m.get("registerOrgName")==null ? null : m.get("registerOrgName").toString();
				//主合同 编号
				String contractNum = m.get("contractNum")==null ? null : m.get("contractNum").toString();
				map=grtCollateralRegistrationServiceImpl.getAllCollateralRegistration(pageNum,pageSize,guarantyId,registerNum
						,registerOrgTypeCd,registerOrgName,contractNum);
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
	//通过主键删除登记信息
	@PostMapping("/deleteCollateralRegistrationById")
	public Map<String,Object> deleteCollateralRegistrationById(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("collateralRegistrationId") ==null ||
				   m.get("collateralRegistrationId").equals("") 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String collateralRegistrationId = m.get("collateralRegistrationId").toString();
				map=grtCollateralRegistrationServiceImpl.deleteCollateralRegistrationById(collateralRegistrationId);
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
	//批量删除登记信息
	@PostMapping("/deleteCollateralRegistrationBatch")
	public Map<String,Object> deleteCollateralRegistrationBatch(@RequestBody Map<String, Object> params){
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
					ids[i] = list.get(i).get("collateralRegistrationId").toString();
				}
				map=grtCollateralRegistrationServiceImpl.deleteCollateralRegistrationBatch(ids);
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
	//添加登记信息信息
	@PostMapping("/saveCollateralRegistration")
	public Map<String,Object> saveCollateralRegistration(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("registerNum") ==null || m.get("contractNum") ==null ||
				   m.get("registerValue") ==null || m.get("registerOrgTypeCd") ==null ||
				   m.get("registerOrgName") ==null || m.get("registerDate") ==null ||
				   m.get("registerExpirationDate") ==null ||
				   m.get("guarantyId") ==null ||  m.get("guarantyId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String registerNum = m.get("registerNum").toString();
				String contractNum = m.get("contractNum").toString();
				String registerValue = m.get("registerValue").toString();
				String registerOrgTypeCd = m.get("registerOrgTypeCd").toString();
				String registerOrgName = m.get("registerOrgName").toString();
				String registerDate = m.get("registerDate").toString();
				String registerExpirationDate = m.get("registerExpirationDate").toString();
				String guarantyId = m.get("guarantyId").toString();
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
				GrtCollateralRegistration grtCollateralRegistration = new GrtCollateralRegistration();
				grtCollateralRegistration.setGuarantyId(guarantyId);
				grtCollateralRegistration.setRegisterNum(registerNum);
				grtCollateralRegistration.setContractNum(contractNum);
				grtCollateralRegistration.setRegisterValue(new BigDecimal(registerValue));
				grtCollateralRegistration.setRegisterOrgTypeCd(registerOrgTypeCd);
				grtCollateralRegistration.setRegisterOrgName(registerOrgName);
				grtCollateralRegistration.setRegisterDate(formate.parse(registerDate));
				grtCollateralRegistration.setRegisterExpirationDate(formate.parse(registerExpirationDate));
				grtCollateralRegistration.setCollateralRegistrationId(UUIDGenerator.getUUID());
				map=grtCollateralRegistrationServiceImpl.saveCollateralRegistration(grtCollateralRegistration);
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
	
	//更新登记信息信息
	@PostMapping("/updateCollateralRegistration")
	public Map<String,Object> updateCollateralRegistration(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("registerNum") ==null || m.get("contractNum") ==null ||
						   m.get("registerValue") ==null || m.get("registerOrgTypeCd") ==null ||
						   m.get("registerOrgName") ==null || m.get("registerDate") ==null ||
						   m.get("registerExpirationDate") ==null ||
						   m.get("guarantyId") ==null ||  m.get("guarantyId").equals("") ||
						   m.get("collateralRegistrationId") ==null ||  m.get("collateralRegistrationId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String registerNum = m.get("registerNum").toString();
				String contractNum = m.get("contractNum").toString();
				String registerValue = m.get("registerValue").toString();
				String registerOrgTypeCd = m.get("registerOrgTypeCd").toString();
				String registerOrgName = m.get("registerOrgName").toString();
				String registerDate = m.get("registerDate").toString();
				String registerExpirationDate = m.get("registerExpirationDate").toString();
				String collateralRegistrationId = m.get("collateralRegistrationId").toString();
				String guarantyId = m.get("guarantyId").toString();
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
				GrtCollateralRegistration grtCollateralRegistration = new GrtCollateralRegistration();
				grtCollateralRegistration.setGuarantyId(guarantyId);
				grtCollateralRegistration.setRegisterNum(registerNum);
				grtCollateralRegistration.setContractNum(contractNum);
				grtCollateralRegistration.setRegisterValue(new BigDecimal(registerValue));
				grtCollateralRegistration.setRegisterOrgTypeCd(registerOrgTypeCd);
				grtCollateralRegistration.setRegisterOrgName(registerOrgName);
				grtCollateralRegistration.setRegisterDate(formate.parse(registerDate));
				grtCollateralRegistration.setRegisterExpirationDate(formate.parse(registerExpirationDate));
				grtCollateralRegistration.setCollateralRegistrationId(collateralRegistrationId);
				map=grtCollateralRegistrationServiceImpl.updateCollateralRegistration(grtCollateralRegistration);
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
