package com.cdgit.loan.customerManage.naturalSchool.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.DateUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.customerManage.naturalSchool.bean.NaturalSchool;
import com.cdgit.loan.customerManage.naturalSchool.mapper.NaturalSchoolMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class NaturalSchoolServiceImpl {
	
	@Autowired
	NaturalSchoolMapper naturalSchoolMapper;
	
	private String now = DateUtil.formatDateTime(new Date());
	
	/**
     * 方法一  查询返回分页对象
     * <p>Title: findUser</p>  
     	第一个参数从第几页开始  第二个参数每页显示数量
     * <p>Description: </p>  
    
     * @return
     */
    public Map<String, Object> selectByPartyId(Integer pageNum, Integer pageSize, String partyId){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		PageHelper.startPage(pageNum,pageSize);
        	List<NaturalSchool> list = naturalSchoolMapper.selectByPartyId(partyId);
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
     * 保存新增高校信息
     * 
     * */
    public Map<String, Object> addNaturalSchool(NaturalSchool naturalSchool){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		naturalSchool.setSchoolId(UUIDGenerator.getUUID());
    		naturalSchool.setLastchandate(now);
    		int back = naturalSchoolMapper.insertSelective(naturalSchool);
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
     * 根据schoolId删除高校信息
     * 
     * */
    public Map<String, Object> deleteByPrimaryKey(String schoolId){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		int back = naturalSchoolMapper.deleteByPrimaryKey(schoolId);
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
     * 更新高校信息
     * 
     * */
    public Map<String, Object> editNaturalSchool(NaturalSchool naturalSchool){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		naturalSchool.setLastchandate(now);
    		int back = naturalSchoolMapper.updateByPrimaryKeySelective(naturalSchool);
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
