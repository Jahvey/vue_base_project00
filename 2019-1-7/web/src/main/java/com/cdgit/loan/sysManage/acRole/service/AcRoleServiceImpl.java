package com.cdgit.loan.sysManage.acRole.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.sysManage.acRole.bean.AcRole;
import com.cdgit.loan.sysManage.acRole.mapper.AcRoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class AcRoleServiceImpl {
	
	@Autowired
	AcRoleMapper acRoleMapper;
	
	public AcRole selectByPrimaryKey(String roleid) {
		return acRoleMapper.selectByPrimaryKey(roleid);
	}
	
    public Map<String, Object> queryAllRole(Integer pageNum, Integer pageSize, String rolename){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		PageHelper.startPage(pageNum,pageSize);
        	List<AcRole> roleList = acRoleMapper.queryAllRole(rolename);
        	PageInfo pageInfo=new PageInfo(roleList,pageSize);
        	map.put("code", "200");
			map.put("msg", "查询成功！");
			map.put("data", pageInfo);
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询失败！");
            e.printStackTrace();
		} finally {
			return map;
		}
    }
    /*
    
    public Map<String, String> addMenu(AcRole menu) {
	
      	Map<String, String> map = new HashMap<>();
    	try {
    		int back = acRoleMapper.insertSelective(menu);
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
    
    public Map<String, String> editMenu(AcRole menu) {
	
    	Map<String, String> map = new HashMap<>();
		
		try {
			int back = acRoleMapper.updateByPrimaryKeySelective(menu);
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
    
    public Map<String, String> deleteMenu(String menuid) {
    	
    	Map<String, String> map = new HashMap<>();
		
		try {
			int back = acRoleMapper.deleteByPrimaryKey(menuid);
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
*/
}
