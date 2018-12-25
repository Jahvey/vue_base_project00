package com.cdgit.loan.sysManage.empManage.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.DateUtil;
import com.cdgit.loan.sysManage.empManage.bean.OmEmployee;
import com.cdgit.loan.sysManage.empManage.mapper.OmEmployeeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class OmEmployeeServiceImpl {
	
	@Autowired
	OmEmployeeMapper omEmployeeMapper;
	
	/**
     * 方法一  查询返回分页对象
     * <p>Title: findUser</p>  
     	第一个参数从第几页开始  第二个参数每页显示数量
     * <p>Description: </p>  
    
     * @return
     */
    public Map<String, Object> queryEmployee(Integer pageNum, Integer pageSize, Long inorgid
    		, String empcode, String empname, String orgname, String status){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		PageHelper.startPage(pageNum,pageSize);
        	List<OmEmployee> empList = omEmployeeMapper.queryEmployeeByTemp(inorgid, empcode, empname, orgname, status);
            PageInfo pageInfo=new PageInfo(empList,pageSize);
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
     * 新增用户
     * 
     * */
    public Map<String, String> addEmp(OmEmployee emp) {
      	Map<String, String> map = new HashMap<>();
    	try {
    		if (emp.getOrgid() == null || emp.getOrgid().toString().equals("")) {
    			map.put("code", "201");
		        map.put("msg", "请选择机构!");
		        return map;
    		}
    		if (!validateEmpcode(emp)) {
    			map.put("code", "201");
		        map.put("msg", "用户编码已存在，新增失败!");
		        return map;
    		}
    		Date now = DateUtil.StrToDate(DateUtil.getDate("yyyy-MM-dd HH:mm:ss"));
    		emp.setCreatetime(now);
    		emp.setLastmodytime(now);
    		int back = omEmployeeMapper.insertSelective(emp);
    		int checkEO = omEmployeeMapper.addEmporg(emp.getEmpcode());
            if (back == 0 || checkEO == 0) {
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
	 * 检验用户code是否合格
	 * 
	 * @param emp
	 * @return true合格，false不合格
	 */
	public boolean validateEmpcode(OmEmployee emp) {
		List<OmEmployee> back = omEmployeeMapper.selectEmployeeByEmpcode(emp.getEmpcode());
		if (emp.getEmpid() == null || emp.getEmpid().toString().equals("")) {
			if (back == null || back.size() == 0) {
				return true;
			}else {
				return false;
			}
		}else {
			if (back == null || back.size() == 0 ) {
				return true;
			} else if (back !=null && back.size() == 1 && emp.getEmpid().equals(back.get(0).getEmpid())){
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * 根据用户查询出它关联的员工
	 * 
	 * @param user
	 * @return
	 *//*
	private OmEmployee[] queryEmployeesByOperatorId(AcOperator user) {
		if (user != null && String.valueOf(user.getOperatorid()) != null
				&& !"".equals(user.getOperatorid())) {
			IDASCriteria dasCriteria = getDASTemplate().createCriteria(
					OmEmployee.QNAME);
			dasCriteria.add(ExpressionHelper.eq("operatorid", user
					.getOperatorid()));
			return getDASTemplate().queryEntitiesByCriteriaEntity(
					OmEmployee.class, dasCriteria);
		}
		return new OmEmployee[0];
	}*/
    
    public Map<String, String> editEmp(OmEmployee emp) {
	
    	Map<String, String> map = new HashMap<>();
		
		try {
			if (emp.getOrgid() == null || emp.getOrgid().toString().equals("")) {
    			map.put("code", "201");
		        map.put("msg", "请选择机构!");
		        return map;
    		}
			int back = omEmployeeMapper.updateByPrimaryKeySelective(emp);
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
    
    public Map<String, String> deleteEmp(Long empid) {
    	
    	Map<String, String> map = new HashMap<>();
		
		try {
			int back = omEmployeeMapper.deleteByPrimaryKey(empid);
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
    
    public Map<String, String> updateOperatorStatus(String status, String userid) {
    	
	    Map<String, String> map = new HashMap<>();
		
		try {
			int back = omEmployeeMapper.updateOperatorStatus(status, userid);
			if (back == 0) {
	            map.put("code", "201");
	            if(status.equals("running")) {
	            	map.put("msg", "启用失败!");
	            }else {
	            	map.put("msg", "停用失败!");
	            }
	    	}else {
			    map.put("code", "200");
			    if(status.equals("running")) {
	            	map.put("msg", "启用成功!");
	            }else {
	            	map.put("msg", "停用失败!");
	            }
	    	}
        	
		} catch (Exception e) {
			// TODO: handle exception
			 if(status.equals("running")) {
            	map.put("msg", "启用失败!");
             }else {
            	map.put("msg", "停用失败!");
             }
            e.printStackTrace();
		} finally {
			return map;
		}
    	
    }

}
