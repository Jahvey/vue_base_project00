package com.cdgit.loan.sysManage.position.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.DateUtil;
import com.cdgit.loan.sysManage.position.bean.OmPosition;
import com.cdgit.loan.sysManage.position.mapper.OmPositionMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class OmPositionServiceImpl {
	
	@Autowired
	OmPositionMapper omPositionMapper;
	
	/**
     * 方法一  查询返回分页对象
     * <p>Title: findUser</p>  
     	第一个参数从第几页开始  第二个参数每页显示数量
     * <p>Description: </p>  
    
     * @return
     */
    public Map<String, Object> queryPositionInfo(Integer pageNum, Integer pageSize, String posiname){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		PageHelper.startPage(pageNum,pageSize);
        	List<OmPosition> posList = omPositionMapper.queryPositionInfo(posiname);
            PageInfo pageInfo = new PageInfo(posList,pageSize);
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
    
    public Map<String, String> addPosition(OmPosition pos) {
	

    	pos.setCreatetime(DateUtil.formatDateTime(new Date()));
    	pos.setLastupdate(pos.getCreatetime());
		
      	Map<String, String> map = new HashMap<>();
    	try {
    		int back = omPositionMapper.insertSelective(pos);
            if (back == 0) {
		        map.put("code", "201");
		        map.put("msg", "新增失败!");
			}else {
			    map.put("code", "200");
		        map.put("msg", "新增成功!");
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
    
    public Map<String, String> editPosition(OmPosition pos) {
	
    	pos.setLastupdate(DateUtil.formatDateTime(new Date()));
    	Map<String, String> map = new HashMap<>();
		
		try {
			int back = omPositionMapper.updateByPrimaryKeySelective(pos);
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
            map.put("msg", e.getStackTrace().toString());
            e.printStackTrace();
		} finally {
			return map;
		}
	}
    
    public Map<String, String> deletePosition(Long positionid) {
    	
    	Map<String, String> map = new HashMap<>();
		
		try {
			int back = omPositionMapper.deleteByPrimaryKey(positionid);
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

}
