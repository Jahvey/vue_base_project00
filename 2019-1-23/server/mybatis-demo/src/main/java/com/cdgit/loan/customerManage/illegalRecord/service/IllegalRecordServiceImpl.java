package com.cdgit.loan.customerManage.illegalRecord.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.customerManage.illegalRecord.bean.IllegalRecord;
import com.cdgit.loan.customerManage.illegalRecord.mapper.IllegalRecordMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class IllegalRecordServiceImpl {
	
	@Autowired
	IllegalRecordMapper illegalRecordMapper;
	
	/**
     * 方法一  查询返回分页对象
     * <p>Title: findUser</p>  
     	第一个参数从第几页开始  第二个参数每页显示数量
     * <p>Description: </p>  
    
     * @return
     */
    public Map<String, Object> illegalList(Integer pageNum, Integer pageSize, String partyId){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		PageHelper.startPage(pageNum,pageSize);
        	List<IllegalRecord> list = illegalRecordMapper.illegalList(partyId);
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

    
}
