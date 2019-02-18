package com.cdgit.loan.customerManage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.customerManage.bean.CreditInfo;
import com.cdgit.loan.customerManage.mapper.CreditInfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class CreditInfoServiceImpl {
	
	@Autowired
	CreditInfoMapper creditInfoMapper;
	
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
        	List<CreditInfo> list = creditInfoMapper.selectByPartyId(partyId);
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
     * 保存新增信用信息
     * 
     * */
    public Map<String, Object> addCreditInfo(CreditInfo creditInfo){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		creditInfo.setId(UUIDGenerator.getUUID());
    		int back = creditInfoMapper.insertSelective(creditInfo);
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
     * 根据id删除信用信息
     * 
     * */
    public Map<String, Object> deleteByPrimaryKey(String id){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		int back = creditInfoMapper.deleteByPrimaryKey(id);
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
     * 更新信用信息
     * 
     * */
    public Map<String, Object> editCreditInfo(CreditInfo creditInfo){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		int back = creditInfoMapper.updateByPrimaryKeySelective(creditInfo);
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
