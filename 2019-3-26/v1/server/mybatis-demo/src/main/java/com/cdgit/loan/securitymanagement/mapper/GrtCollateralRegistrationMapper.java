package com.cdgit.loan.securitymanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.securitymanagement.bean.GrtCollateralRegistration;

/**
 * 抵质押物注册信息Mapper
 * @author wuyong
 * @date 2018.12.29
 *
 */
@Mapper
public interface GrtCollateralRegistrationMapper {
    int deleteByPrimaryKey(String collateralRegistrationId);

    int insert(GrtCollateralRegistration record);

    int insertSelective(GrtCollateralRegistration record);

    GrtCollateralRegistration selectByPrimaryKey(String collateralRegistrationId);

    int updateByPrimaryKeySelective(GrtCollateralRegistration record);

    int updateByPrimaryKey(GrtCollateralRegistration record);
    
    int deleteBatch(@Param("ids") String[] ids);

	List<GrtCollateralRegistration> selectAll(
			@Param("guarantyId") String guarantyId, 
			@Param("registerNum") String registerNum,
			@Param("registerOrgTypeCd") String registerOrgTypeCd,
			@Param("registerOrgName") String registerOrgName, 
			@Param("contractNum") String contractNum);
}