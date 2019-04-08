package com.cdgit.loan.sysManage.acRole.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.sysManage.acMenu.bean.AcMenu;
import com.cdgit.loan.sysManage.acRole.bean.AcRole;
import com.cdgit.loan.sysManage.acRole.bean.AcRoleMenu;
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
	
	public Map<String,String> addRole(AcRole role){
		Map<String,String> map = new HashMap<String,String>();
		try {
			acRoleMapper.insert(role);
			map.put("code", "200");
			map.put("msg", "新增角色成功！");
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
			map.put("msg", "新增角色失败！" + e.getMessage());
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	
	public Map<String,String> updateRole(AcRole role){
		Map<String,String> map = new HashMap<String,String>();
		try {
			acRoleMapper.updateByPrimaryKeySelective(role);
			map.put("code", "200");
			map.put("msg", "修改角色成功！");
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
			map.put("msg", "修改角色失败！" + e.getMessage());
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	
	public Map<String,String> deleteRole(String roleId){
		Map<String,String> map = new HashMap<String,String>();
		try {
			List<AcMenu> roleList = acRoleMapper.findRoleMenus(roleId);
			if(roleList != null && roleList.size() > 0){
				map.put("code", "201");
				map.put("msg", "删除角色失败！该角色下有关联菜单，不能进行删除操作");
			}else{
				acRoleMapper.deleteByPrimaryKey(roleId);
				map.put("code", "200");
				map.put("msg", "删除角色成功！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
			map.put("msg", "删除角色失败！" + e.getMessage());
            e.printStackTrace();
		} finally {
			return map;
		}
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
    
    public Map<String, Object> queryAllRole(){
    	Map<String, Object> map = new HashMap<>();
    	try {
        	List<AcRole> roleList = acRoleMapper.queryAllRole("");
        	map.put("code", "200");
			map.put("msg", "查询成功！");
			map.put("data", roleList);
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询失败！");
            e.printStackTrace();
		} finally {
			return map;
		}
    }
    public Map<String, Object> findRoleMenus(String roleId){
    	Map<String, Object> map = new HashMap<>();
    	try {
        	List<AcMenu> roleList = acRoleMapper.findRoleMenus(roleId);
        	map.put("code", "200");
			map.put("msg", "查询成功！");
			map.put("data", roleList);
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询失败！");
            e.printStackTrace();
		} finally {
			return map;
		}
    }
    
    public Map<String, Object> addRoleMenus(List<AcRoleMenu> params){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		//获取角色编号
    		String roleId = params.get(0).getRoleId();
    		//删除角色下所有已有菜单关联
    		acRoleMapper.deleteRoleMenuByRoleId(roleId);
    		for(int i=0;i<params.size();i++){//遍历关系信息
    			if(StringUtils.isBlank(params.get(i).getMenuId()) || StringUtils.isBlank(params.get(i).getRoleId())){//判断空值
    				throw new Exception("菜单编号、角色编号均不能有空值");
    			}
    			acRoleMapper.addRoleMenu(params.get(i));
    		}
        	map.put("code", "200");
			map.put("msg", "新增成功！");
			map.put("data", null);
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "新增失败！");
            e.printStackTrace();
		} finally {
			return map;
		}
    }
    /**
     * 根据用户号获取角色列表
     * */
//    public Map<String,Object> getRolesByUserId(String userId){
//    	Map<String, Object> map = new HashMap<>();
//    	try {
//        	List<AcRole> roleList = acRoleMapper.getRolesByUserId(userId);
//        	map.put("code", "200");
//			map.put("msg", "查询成功！");
//			map.put("data", roleList);
//		} catch (Exception e) {
//			map.put("code", "201");
//			map.put("msg", "查询失败！");
//            e.printStackTrace();
//		} finally {
//			return map;
//		}
//    }
    /**
     * 根据用户号获取角色列表
     * */
    public Map<String,Object> getRolesSelectBoxData(String userId){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		//获取用户已有角色
        	List<AcRole> roleList = acRoleMapper.queryAllRole("");
        	//获取用户未有角色
        	List<AcRole> hasRoleList = acRoleMapper.getRolesByUserId(userId);

        	String[] rightData = new String[hasRoleList.size()];
        	for(int i=0;i <hasRoleList.size();i++ ){
        		rightData[i] = hasRoleList.get(i).getRoleid();
        	}
        	map.put("code", "200");
			map.put("msg", "查询成功！");
			map.put("allData", roleList);
			map.put("rightData", rightData);
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询失败！" + e.getMessage() + "||||||" + e.getLocalizedMessage() + "||||||" + e.getStackTrace());
            e.printStackTrace();
		} finally {
			return map;
		}
    }
}
