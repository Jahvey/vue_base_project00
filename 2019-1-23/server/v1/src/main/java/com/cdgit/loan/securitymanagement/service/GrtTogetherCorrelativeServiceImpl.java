package com.cdgit.loan.securitymanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.securitymanagement.bean.GrtTogetherCorrelative;
import com.cdgit.loan.securitymanagerment.mapper.GrtTogetherCorrelativeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class GrtTogetherCorrelativeServiceImpl {
	@Autowired
	private GrtTogetherCorrelativeMapper grtTogetherCorrelativeMapper;
	public Map<String, Object> getAll(Integer pageNum, Integer pageSize, String collateralNum,
			String togetherCorrelativeName, String togetherCertificateType, String togetherCertificateNum,
			String togetherCorrelativeId, String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(pageNum,pageSize);
		List<GrtTogetherCorrelative> list = grtTogetherCorrelativeMapper.selectAll(collateralNum,
				togetherCorrelativeName,togetherCertificateType,togetherCertificateNum,togetherCorrelativeId,guarantyId);
		PageInfo<GrtTogetherCorrelative> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> deleteTogetherCorrelativeById(String togetherCorrelativeId) {
		Map<String, Object> map = new HashMap<>();
		int i = grtTogetherCorrelativeMapper.deleteByPrimaryKey(togetherCorrelativeId);
		if(i>0){
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException();
		}
		return map;
	}
	//批量删除
	public Map<String, Object> deleteTogetherCorrelativedBatch(String[] ids) {
		Map<String, Object> map = new HashMap<>();
		int i = grtTogetherCorrelativeMapper.deleteBatch(ids);
		if(i>0){
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException();
		}
		return map;
	}
	public Map<String, Object> saveTogetherCorrelatived(GrtTogetherCorrelative grtTogetherCorrelative) {
		Map<String, Object> map = new HashMap<>();
		int i = grtTogetherCorrelativeMapper.insertSelective(grtTogetherCorrelative);
		if(i>0){
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException();
		}
		return map;
	}
	public Map<String, Object> updateTogetherCorrelatived(GrtTogetherCorrelative grtTogetherCorrelative) {
		Map<String, Object> map = new HashMap<>();
		int i = grtTogetherCorrelativeMapper.updateByPrimaryKeySelective(grtTogetherCorrelative);
		if(i>0){
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException();
		}
		return map;
	}

	

}
