package com.cdgit.loan.sysManage.orgManage.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.DateUtil;
import com.cdgit.loan.sysManage.orgManage.bean.OmOrganization;
import com.cdgit.loan.sysManage.orgManage.mapper.OmOrganizationMapper;

/**
 * 组织机构Service
 * @author yuanweixiao
 * 
 * 
 * */
@Service
@Transactional
public class OmOrganizationServiceImpl {
	
	@Autowired
	OmOrganizationMapper omOrganizationMapper;

	private static List<OmOrganization> ORG_LIST_ALL;
	
	public OmOrganization selectByPrimaryKey(Long orgid) {
		
		return omOrganizationMapper.selectByPrimaryKey(orgid);
		
	}

	public Map<String, Object> queryOrgWithParams(String orgcode, String orgname){
		Map<String, Object> map = new HashMap<>();
    	try {
    		List<OmOrganization> orgList = omOrganizationMapper.queryOrgWithParams(orgcode,orgname);
         	map.put("code", "200");
            map.put("msg", "查询成功!");
            map.put("data", orgList);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "查询失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    public Map<String, Object> queryOrg(String parentId){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		List<OmOrganization> orgList = omOrganizationMapper.queryOrg(parentId);
         	ORG_LIST_ALL = orgList;
         	OmOrganization resultOrg= null;
         	if (parentId == null || parentId == "") {
         		parentId = "9999";    	
         	}
         	for ( int i = 0;i < orgList.size(); i++ ) {
         		if (parentId.equals(orgList.get(i).getOrgid().toString())) {
         			resultOrg = orgList.get(i);
         			convert(resultOrg);
         		}
         	}
         	map.put("code", "200");
            map.put("msg", "查询成功!");
            map.put("data", resultOrg);
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
    public void convert(OmOrganization org) {
    	for (int i=0;i< ORG_LIST_ALL.size();i++) {
    		if (ORG_LIST_ALL.get(i).getParentorgid() != null && ORG_LIST_ALL.get(i).getParentorgid().equals(org.getOrgid())) {
    			ORG_LIST_ALL.get(i).setParentorgname(org.getRemark());
    			convert(ORG_LIST_ALL.get(i));
    			org.getChildren().add(ORG_LIST_ALL.get(i));
    		}
    	}
    }
    
    public Map<String, String> addOrg(OmOrganization org) {
    	
    	Map<String, String> map = new HashMap<>();
    	Long parentorgid = org.getParentorgid();
    	OmOrganization parentOrg = null;
    	if (parentorgid != null && !parentorgid.toString().equals("")) {
    		parentOrg = omOrganizationMapper.selectByPrimaryKey(parentorgid);
    	}
    	try {
    		if(!validateOrgcode(org)) {
    			map.put("code", "201");
		        map.put("msg", "机构编码已存在，新增失败!");
		        return map;
    		}
    		int back = omOrganizationMapper.insertSelective(org);
    		List<OmOrganization> list = omOrganizationMapper.selectOrgByOrgcode(org.getOrgcode());
    		OmOrganization entity = list.get(0);
    		expandOrganizationPropertyByParent(entity,parentOrg);
    		if (parentOrg != null && parentOrg.getOrgid() != null && parentOrg.getOrgid().toString().equals("")) {
    			omOrganizationMapper.updateByPrimaryKeySelective(entity);
    		} 
        	if (back == 0) {
                map.put("code", "201");
                map.put("msg", "新增失败!");
        	}else {
    		    map.put("code", "200");
                map.put("msg", "新增成功!");
        	}
        	expandParentOrganizationProperty(parentOrg);
        	omOrganizationMapper.updateByPrimaryKeySelective(parentOrg);
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
	 * 检验机构code是否合格
	 * 
	 * @param orgcode
	 * @return true合格，false不合格
	 */
	public boolean validateOrgcode(OmOrganization org) {
		List<OmOrganization> back = omOrganizationMapper.selectOrgByOrgcode(org.getOrgcode());
		if (org.getOrgid() == null || org.getOrgid().toString().equals("")) {
			if (back == null || back.size() == 0) {
				return true;
			}else {
				return false;
			}
		}else {
			if (back == null || back.size() == 0) {
				return true;
			} else if (back !=null && back.size() == 1 && org.getOrgid().equals(back.get(0).getOrgid())){
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 根据父机构设置子机构部分信息：level, seq, isLeaf,subcount
	 * 
	 * @param org
	 * @param parentOrg
	 */
	public static void expandOrganizationPropertyByParent(OmOrganization org,
			OmOrganization parentOrg) {
		if (org == null) {
			return;
		}
		if (parentOrg == null || parentOrg.getOrgid() == null || parentOrg.getOrgid().toString().equals("")) {
//			org.set("orglevel", new BigDecimal(1));
			Short level = 1;
			org.setOrglevel(level);
			// 不存在父机构:"."+本机构ID+".";
			org.setOrgseq( "." + org.getOrgid() + ".");
		} else {
			// 级别在父机构的级别上增加1
//			org.set("orglevel", new BigDecimal(parentOrg.getBigDecimal(
//					"orglevel").intValue() + 1));
			Short level = parentOrg.getOrglevel();
			org.setOrglevel(level++);
			// 存在父机构:父机构顺序+本机构ID+".";
			org.setOrgseq(parentOrg.getOrgseq()
					+ org.getOrgid().toString() + ".");
		}
		Date now = DateUtil.StrToDate(DateUtil.getDate("yyyy-MM-dd HH:mm:ss"));
		org.setCreatetime(now);
		org.setLastupdate(now);
		org.setIsleaf("1");
		org.setSubcount("0");
	}
	
	/**
	 * 更改父机构的信息，isLeaf,subcount
	 * 
	 * @param parentOrg
	 */
	public static void expandParentOrganizationProperty(OmOrganization parentOrg) {
		if (parentOrg == null || parentOrg.getOrgid() == null || parentOrg.getOrgid().toString().equals("")) {
			return;
		}
		if(parentOrg.getSubcount() != null && !parentOrg.getSubcount().equals("")){
		Integer subcount = Integer.valueOf(parentOrg.getSubcount()) + 1;
		parentOrg.setSubcount(subcount.toString());
		}
		parentOrg.setIsleaf("2");
	}
    
    public Map<String, String> editOrg(OmOrganization org) {
    	
     	Map<String, String> map = new HashMap<>();
    	try {
    		if(!validateOrgcode(org)) {
    			map.put("code", "201");
		        map.put("msg", "机构编码已存在，修改失败!");
		        return map;
    		}
    		int back = omOrganizationMapper.updateByPrimaryKeySelective(org);
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
    
    public Map<String, String> deleteOrg(Long orgid) {
    	
    	Map<String, String> map = new HashMap<>();
    	try {
    		int back = omOrganizationMapper.deleteByPrimaryKey(orgid);
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
