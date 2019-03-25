package com.cdgit.loan.securitymanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.securitymanagement.bean.GrtTogetherCorrelative;
import com.cdgit.loan.securitymanagement.service.GrtTogetherCorrelativeServiceImpl;

/**
 * 共有人controller
 * @author wuyong
 * @date 2018.12.28
 *
 */
@RestController
@RequestMapping("/grtTogetherCorrelative")
public class GrtTogetherCorrelativeController {
	@Autowired
	private GrtTogetherCorrelativeServiceImpl grtTogetherCorrelativeServiceImpl;
	//查询共有人
	@PostMapping("/getAllTogetherCorrelative")
	public Map<String,Object> getAllTogetherCorrelative(@RequestBody Map<String, Object> params){
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
				String collateralNum = m.get("collateralNum")==null ? null : m.get("collateralNum").toString();
				String togetherCorrelativeName = m.get("togetherCorrelativeName")==null ? null : m.get("togetherCorrelativeName").toString();
				String togetherCertificateType = m.get("togetherCertificateType")==null ? null : m.get("togetherCertificateType").toString();
				String togetherCertificateNum = m.get("togetherCertificateNum")==null ? null : m.get("togetherCertificateNum").toString();
				String togetherCorrelativeId = m.get("togetherCorrelativeId")==null ? null : m.get("togetherCorrelativeId").toString();
				String guarantyId = m.get("guarantyId")==null ? null : m.get("guarantyId").toString();
				map=grtTogetherCorrelativeServiceImpl.getAll(pageNum,pageSize,collateralNum,togetherCorrelativeName
						,togetherCertificateType,togetherCertificateNum,togetherCorrelativeId,guarantyId);
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
	//通过主键删除共有人
	@PostMapping("/deleteTogetherCorrelativeById")
	public Map<String,Object> deleteTogetherCorrelativeById(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("togetherCorrelativeId") ==null ||
				   m.get("togetherCorrelativeId").equals("") 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String togetherCorrelativeId = m.get("togetherCorrelativeId").toString();
				map=grtTogetherCorrelativeServiceImpl.deleteTogetherCorrelativeById(togetherCorrelativeId);
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
	//批量删除共有人
	@PostMapping("/deleteTogetherCorrelativedBatch")
	public Map<String,Object> deleteTogetherCorrelativedBatch(@RequestBody Map<String, Object> params){
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
					ids[i] = list.get(i).get("togetherCorrelativeId").toString();
				}
				map=grtTogetherCorrelativeServiceImpl.deleteTogetherCorrelativedBatch(ids);
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
	//添加共有人信息
	@PostMapping("/saveTogetherCorrelatived")
	public Map<String,Object> saveTogetherCorrelatived(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("togetherCorrelativeName") ==null || m.get("togetherCertificateType") ==null ||
				   m.get("togetherCertificateNum") ==null || m.get("guarantyId") ==null ||
				   m.get("guarantyId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String togetherCorrelativeName = m.get("togetherCorrelativeName").toString();
				String togetherCertificateType = m.get("togetherCertificateType").toString();
				String togetherCertificateNum = m.get("togetherCertificateNum").toString();
				String guarantyId = m.get("guarantyId").toString();
				GrtTogetherCorrelative grtTogetherCorrelative = new GrtTogetherCorrelative();
				grtTogetherCorrelative.setGuarantyId(guarantyId);
				grtTogetherCorrelative.setTogetherCertificateNum(togetherCertificateNum);
				grtTogetherCorrelative.setTogetherCertificateType(togetherCertificateType);
				grtTogetherCorrelative.setTogetherCorrelativeName(togetherCorrelativeName);
				grtTogetherCorrelative.setTogetherCorrelativeId(UUIDGenerator.getUUID());
				map=grtTogetherCorrelativeServiceImpl.saveTogetherCorrelatived(grtTogetherCorrelative);
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
	
	//更新共有人信息
	@PostMapping("/updateTogetherCorrelatived")
	public Map<String,Object> updateTogetherCorrelatived(@RequestBody Map<String, Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("togetherCorrelativeName") ==null || m.get("togetherCertificateType") ==null ||
				   m.get("togetherCertificateNum") ==null || m.get("guarantyId") ==null || m.get("togetherCorrelativeId") ==null ||
				   m.get("guarantyId").equals("") ||m.get("togetherCorrelativeId").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String togetherCorrelativeName = m.get("togetherCorrelativeName").toString();
				String togetherCertificateType = m.get("togetherCertificateType").toString();
				String togetherCertificateNum = m.get("togetherCertificateNum").toString();
				String guarantyId = m.get("guarantyId").toString();
				String togetherCorrelativeId = m.get("togetherCorrelativeId").toString();
				GrtTogetherCorrelative grtTogetherCorrelative = new GrtTogetherCorrelative();
				grtTogetherCorrelative.setGuarantyId(guarantyId);
				grtTogetherCorrelative.setTogetherCertificateNum(togetherCertificateNum);
				grtTogetherCorrelative.setTogetherCertificateType(togetherCertificateType);
				grtTogetherCorrelative.setTogetherCorrelativeName(togetherCorrelativeName);
				grtTogetherCorrelative.setTogetherCorrelativeId(togetherCorrelativeId);
				map=grtTogetherCorrelativeServiceImpl.updateTogetherCorrelatived(grtTogetherCorrelative);
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
