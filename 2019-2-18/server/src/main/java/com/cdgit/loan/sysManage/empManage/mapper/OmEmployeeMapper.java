package com.cdgit.loan.sysManage.empManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.sysManage.empManage.bean.AcOperatorRole;
import com.cdgit.loan.sysManage.empManage.bean.OmEmpOrg;
import com.cdgit.loan.sysManage.empManage.bean.OmEmployee;

@Mapper
public interface OmEmployeeMapper {
    int deleteByPrimaryKey(Long empid);

    int insert(OmEmployee record);

    int insertSelective(OmEmployee record);
    
    List<OmEmployee> selectEmployeeByEmpcode(@Param("empcode") String empcode);

    OmEmployee selectByPrimaryKey(Long empid);

    int updateByPrimaryKeySelective(OmEmployee record);

    int updateByPrimaryKey(OmEmployee record);
    
    int updateOperatorStatus(@Param("status") String status,@Param("userid") String userid);
    
    int addEmporg(@Param("empcode") String empcode);
    
    List<OmEmployee> queryEmployeeByTemp(@Param("inorgid") Long inorgid,@Param("empcode") String empcode,@Param("empname") String empname
    		,@Param("orgname") String orgname,@Param("status") String status);
    
    int updateEmporg(OmEmpOrg omEmpOrg);
    
    int insertOperatorRole(AcOperatorRole acOperatorRole);
    
    int deleteOperatorRole(String operatorid);
}