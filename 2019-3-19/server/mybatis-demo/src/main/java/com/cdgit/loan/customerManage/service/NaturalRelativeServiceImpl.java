package com.cdgit.loan.customerManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.customerManage.bean.NaturalRelative;
import com.cdgit.loan.customerManage.mapper.NaturalRelativeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class NaturalRelativeServiceImpl {
	
	@Autowired
	NaturalRelativeMapper naturalRelativeMapper;
	
	/**
     * 方法一  查询返回分页对象
     * <p>Title: findUser</p>  
     	第一个参数从第几页开始  第二个参数每页显示数量
     * <p>Description: </p>  
    
     * @return
     */
    public Map<String, Object> selectByPartyId(Integer pageNum, Integer pageSize, String partyId, String cType){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		//TODO 对私客户关系信息查询根据前端传来cType区分 person对自然人 其他对公司 
    		//TODO 在ECIF系统中调用查询接口查询并将查询到的信息同步保存到本地数据库
    		PageHelper.startPage(pageNum,pageSize);
        	List<NaturalRelative> list = naturalRelativeMapper.selectByPartyId(partyId);
            PageInfo pageInfo = new PageInfo(list,pageSize);
          	map.put("code", "200");
            map.put("msg", "查询成功!");
            map.put("data", pageInfo);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "查询失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    /**
     * 
     * 保存新增关系人信息
     * 
     * */
    public Map<String, Object> addnaturalRelative(NaturalRelative naturalRelative){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		//TODO 对私客户关系信息删除根据custType区分01对公司 02对自然人在ECIF系统中调用新增接口创建新的关系人信息
    		naturalRelative.setNaturalRelativeId(UUIDGenerator.getUUID());
    		int back = naturalRelativeMapper.insertSelective(naturalRelative);
            if (back == 0) {
		        map.put("code", "201");
		        map.put("msg", "保存失败!");
			}else {
			    map.put("code", "200");
		        map.put("msg", "保存成功!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "新增失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    /**
     * 根据naturalRelativeId删除关系人信息
     * 
     * */
    public Map<String, Object> deleteByPrimaryKey(String naturalRelativeId, String custType){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		//TODO 对私客户关系信息删除根据custType区分01对公司 02对自然人在ECIF系统中调用删除接口删除
    		int back = naturalRelativeMapper.deleteByPrimaryKey(naturalRelativeId);
    		if (back == 0) {
		        map.put("code", "201");
		        map.put("msg", "删除失败!");
			}else {
			    map.put("code", "200");
		        map.put("msg", "删除成功!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "删除失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    /**
     * 更新关系人信息
     * 
     * */
    public Map<String, Object> editnaturalRelative(NaturalRelative naturalRelative){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		//TODO 对私客户关系信息删除根据custType区分01对公司 02对自然人在ECIF系统中调用更新接口维护
    		int back = naturalRelativeMapper.updateByPrimaryKeySelective(naturalRelative);
            if (back == 0) {
		        map.put("code", "201");
		        map.put("msg", "修改失败!");
			}else {
			    map.put("code", "200");
		        map.put("msg", "修改成功!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "修改失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
}
