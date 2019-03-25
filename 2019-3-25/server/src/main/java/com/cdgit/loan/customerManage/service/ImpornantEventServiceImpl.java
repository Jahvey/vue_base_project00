package com.cdgit.loan.customerManage.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.DateUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.customerManage.bean.ImpornantEvent;
import com.cdgit.loan.customerManage.mapper.ImpornantEventMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class ImpornantEventServiceImpl {
	
	@Autowired
	ImpornantEventMapper impornantEventMapper;
	
	private Date now = DateUtil.StrToDate(DateUtil.formatDateTime(new Date()));
	
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
        	List<ImpornantEvent> list = impornantEventMapper.selectByPartyId(partyId);
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
     * 保存新增重大事件
     * 
     * */
    public Map<String, Object> addImpornantEvent(ImpornantEvent impornantEvent){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		impornantEvent.setImportantEventId(UUIDGenerator.getUUID());
    		int back = impornantEventMapper.insertSelective(impornantEvent);
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
     * 根据importantEventId删除重大事件
     * 
     * */
    public Map<String, Object> deleteByPrimaryKey(String importantEventId){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		int back = impornantEventMapper.deleteByPrimaryKey(importantEventId);
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
     * 更新重大事件
     * 
     * */
    public Map<String, Object> editImpornantEvent(ImpornantEvent impornantEvent){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		impornantEvent.setUpdateTime(now);
    		int back = impornantEventMapper.updateByPrimaryKeySelective(impornantEvent);
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
