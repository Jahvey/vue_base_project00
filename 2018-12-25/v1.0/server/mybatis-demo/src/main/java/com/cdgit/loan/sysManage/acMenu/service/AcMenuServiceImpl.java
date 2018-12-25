package com.cdgit.loan.sysManage.acMenu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
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
	
	public AcMenu selectByPrimaryKey(String menuid) {
		return acMenuMapper.selectByPrimaryKey(menuid);
	}
	/**
	 * 查询数据库全量菜单数据，并且转化为树形结构
     * 使用递归方法rebuildList2Tree建树
     *
     * @param 
     * @return
     */
    public Map<String, Object> queryMenuTree(){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		List<AcMenu> menuList = acMenuMapper.queryMenuTree();
    		List<AcMenu> tree = rebuildList2Tree(menuList);
         	
         	map.put("code", "200");
            map.put("msg", "查询成功!");
            map.put("data", tree);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "查询失败!");
            e.printStackTrace();
		} finally {
			return map;
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
    
    /**
	 * 新增菜单
     *
     * @param 
     * @return
     */
    public Map<String, String> addMenu(AcMenu menu) {
	
      	Map<String, String> map = new HashMap<>();
      	if(StringUtils.isBlank(menu.getParentsid())){//如果是根节点，默认level=1 parentsid = '9999'
      		menu.setParentsid("9999");
      		menu.setMenulevel("1");
      	}
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
    
    /**
	 * 编辑菜单
     *
     * @param 
     * @return
     */
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
    /**
	 * 删除菜单
     *
     * @param 
     * @return
     */
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
    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    private static List<AcMenu> rebuildList2Tree(List<AcMenu> treeNodes) {
        List<AcMenu> newTree = new ArrayList<AcMenu>();//初始化一个新的列表
        for (AcMenu treeNode : treeNodes) {
            if (isRootNode(treeNode)) {//如果不是根节点
            	//选择根节点数据开始找儿子
                newTree.add(findChildren(treeNode, treeNodes));
            }
        }
        return newTree;//返回新的树形列表
    }
 
    /**
     * 判断节点是否是根节点
     * @param checkNode
     * @param treeNodes
     * @return
     */
    private static boolean isRootNode(AcMenu checkNode) {
        if ("9999".equals(checkNode.getParentsid())) {//爸爸id等于9999为根节点，跟数据库设计对应。
            return  true;
        }
        return false;
    }
 
 
    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static AcMenu findChildren(AcMenu parentNode, List<AcMenu> treeNodes) {
        List<AcMenu> children = parentNode.getChildren();
        for (AcMenu it : treeNodes) {
            if (parentNode.getMenuid().equals(it.getParentsid())) {//找儿子，判断parentNode是不是有儿子
                children.add(findChildren(it, treeNodes));
            }
        }
        return parentNode;
    }

}
