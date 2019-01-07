package com.cdgit.loan.sysManage.orgManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.sysManage.orgManage.bean.OmOrganization;

@Mapper
public interface OmOrganizationMapper {
    int deleteByPrimaryKey(Long orgid);

    int insert(OmOrganization record);

    int insertSelective(OmOrganization record);

    OmOrganization selectByPrimaryKey(Long orgid);

    int updateByPrimaryKeySelective(OmOrganization record);

    int updateByPrimaryKey(OmOrganization record);
    
    List<OmOrganization> selectOrgByOrgcode(@Param("orgcode") String orgcode);
  
    List<OmOrganization> queryOrgWithParams(@Param("orgcode") String orgcode,@Param("orgname") String orgname);
    
    List<OmOrganization> queryOrg(@Param("parentId") String parentId);
}