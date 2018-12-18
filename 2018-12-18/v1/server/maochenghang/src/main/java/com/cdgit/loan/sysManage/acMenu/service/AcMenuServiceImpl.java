package com.cdgit.loan.sysManage.acMenu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.GUIDGenerator;
import com.cdgit.loan.sysManage.acMenu.bean.AcMenu;
import com.cdgit.loan.sysManage.acMenu.mapper.AcMenuMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class AcMenuServiceImpl {
	
	@Autowired
	AcMenuMapper acMenuMapper;
	
	private static List<AcMenu> MENU_LIST_ALL;
	
	public AcMenu selectByPrimaryKey(String menuid) {
		return acMenuMapper.selectByPrimaryKey(menuid);
	}
	
	/**
     * 方法一  查询返回分页对象
     * <p>Title: findUser</p>  
     	第一个参数从第几页开始  第二个参数每页显示数量
     * <p>Description: </p>  
    
     * @return
     */
    public Map<String, Object> queryMenuTree(){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		List<AcMenu> menuList = acMenuMapper.queryMenuTree();
        	MENU_LIST_ALL = menuList;
         	for ( int i = 0;i < menuList.size(); i++ ) {
     			convert(menuList.get(i));
         	}
         	map.put("code", "200");
            map.put("msg", "查询成功!");
            map.put("data", menuList);
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
     * 转换为树状结构
     * 
     * */
    public void convert(AcMenu menu) {
    	for (int i=0;i< MENU_LIST_ALL.size();i++) {
    		if (MENU_LIST_ALL.get(i).getParentsid() != null && MENU_LIST_ALL.get(i).getParentsid().equals(menu.getMenuid())) {
    			convert(MENU_LIST_ALL.get(i));
    			menu.getChildren().add(MENU_LIST_ALL.get(i));
    		}
    	}
    }
    
    public Map<String, Object> queryMenuByParentsid(Integer pageNum, Integer pageSize, String parentsid){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		PageHelper.startPage(pageNum,pageSize);
        	List<AcMenu> menuList = acMenuMapper.queryMenuByParentsid(parentsid);
        	PageInfo pageInfo=new PageInfo(menuList,pageSize);
          	map.put("code", "200");
            map.put("msg", "查询成功!");
            map.put("data", menuList);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "查询失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    public Map<String, String> addMenu(AcMenu menu) {
	
      	Map<String, String> map = new HashMap<>();
    	try {
    		int back = acMenuMapper.insertSelective(menu);
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
    
    public Map<String, String> editMenu(AcMenu menu) {
	
    	Map<String, String> map = new HashMap<>();
		
		try {
			int back = acMenuMapper.updateByPrimaryKeySelective(menu);
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
			int back = acMenuMapper.deleteByPrimaryKey(menuid);
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
