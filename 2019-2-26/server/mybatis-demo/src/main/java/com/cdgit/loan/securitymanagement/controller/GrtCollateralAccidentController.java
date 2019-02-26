package com.cdgit.loan.securitymanagement.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.securitymanagement.bean.GrtCollateralAccident;
import com.cdgit.loan.securitymanagement.service.GrtCollateralAccidentServiceImpl;

/**
 * 意外 controller
 * @author wuyong
 * @date 2018.12.29
 *
 */
@RestController
@RequestMapping("/grtCollateralAccident")
public class GrtCollateralAccidentController {
	@Autowired
	private GrtCollateralAccidentServiceImpl grtCollateralAccidentServiceImpl;
	//查询登记信息
	@PostMapping("/getAllCollateralAccident")
	public Map<String,Object> getAllCollateralAccident(@RequestBody Map<String, Object> params){
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
				//意外情况类型
				String accidentTypeCd = m.get("accidentTypeCd")==null ? null : m.get("accidentTypeCd").toString();
				//币种代码
				String currencyCd = m.get("registerOrgTypeCd")==null ? null : m.get("registerOrgTypeCd").toString();
				map=grtCollateralAccidentServiceImpl.getAllCollateralAccident(pageNum,pageSize,guarantyId,accidentTypeCd
						,currencyCd);
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
	@PostMapping("/deleteCollateralAccidentById")
	public Map<String,Object> deleteCollateralAccidentById(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("accidentId") ==null ||
				   m.get("accidentId").equals("") 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String accidentId = m.get("accidentId").toString();
				map=grtCollateralAccidentServiceImpl.deleteCollateralAccidentById(accidentId);
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
	@PostMapping("/deleteCollateralAccidentBatch")
	public Map<String,Object> deleteCollateralAccidentBatch(@RequestBody Map<String, Object> params){
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
					ids[i] = list.get(i).get("accidentId").toString();
				}
				map=grtCollateralAccidentServiceImpl.deleteCollateralAccidentBatch(ids);
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
	@PostMapping("/saveCollateralAccident")
	public Map<String,Object> saveCollateralAccident(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("accidentTypeCd") ==null || m.get("occurDate") ==null ||
				   m.get("priceLosses") ==null || m.get("pricesCompensation") ==null ||
				   m.get("reason") ==null ||
				   m.get("guarantyId") ==null ||  m.get("guarantyId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String accidentTypeCd = m.get("accidentTypeCd").toString();
				String occurDate = m.get("occurDate").toString();
				String priceLosses = m.get("priceLosses").toString();
				String pricesCompensation = m.get("pricesCompensation").toString();
				String reason = m.get("reason").toString();
				String guarantyId = m.get("guarantyId").toString();
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
				GrtCollateralAccident grtCollateralAccident = new GrtCollateralAccident();
				grtCollateralAccident.setGuarantyId(guarantyId);
				grtCollateralAccident.setAccidentTypeCd(accidentTypeCd);
				grtCollateralAccident.setOccurDate(formate.parse(occurDate));
				grtCollateralAccident.setPriceLosses(new BigDecimal(priceLosses));
				grtCollateralAccident.setPricesCompensation(new BigDecimal(pricesCompensation));
				grtCollateralAccident.setReason(reason);
				grtCollateralAccident.setAccidentId(UUIDGenerator.getUUID());
				map=grtCollateralAccidentServiceImpl.saveCollateralAccident(grtCollateralAccident);
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
	@PostMapping("/updateCollateralAccident")
	public Map<String,Object> updateCollateralAccident(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("accidentTypeCd") ==null || m.get("occurDate") ==null ||
						   m.get("priceLosses") ==null || m.get("pricesCompensation") ==null ||
						   m.get("reason") ==null ||
						   m.get("guarantyId") ==null ||  m.get("guarantyId").equals("") ||
						   m.get("accidentId") ==null ||  m.get("accidentId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String accidentTypeCd = m.get("accidentTypeCd").toString();
				String occurDate = m.get("occurDate").toString();
				String priceLosses = m.get("priceLosses").toString();
				String pricesCompensation = m.get("pricesCompensation").toString();
				String reason = m.get("reason").toString();
				String guarantyId = m.get("guarantyId").toString();
				String accidentId = m.get("accidentId").toString();
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
				GrtCollateralAccident grtCollateralAccident = new GrtCollateralAccident();
				grtCollateralAccident.setGuarantyId(guarantyId);
				grtCollateralAccident.setAccidentTypeCd(accidentTypeCd);
				grtCollateralAccident.setOccurDate(formate.parse(occurDate));
				grtCollateralAccident.setPriceLosses(new BigDecimal(priceLosses));
				grtCollateralAccident.setPricesCompensation(new BigDecimal(pricesCompensation));
				grtCollateralAccident.setReason(reason);
				grtCollateralAccident.setAccidentId(accidentId);
				map=grtCollateralAccidentServiceImpl.updateCollateralAccident(grtCollateralAccident);
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
