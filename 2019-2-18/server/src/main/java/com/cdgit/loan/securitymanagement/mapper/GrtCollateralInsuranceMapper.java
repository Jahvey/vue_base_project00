package com.cdgit.loan.securitymanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.securitymanagement.bean.GrtCollateralInsurance;
/**
 * 保险bean
 * @author wuyong
 * @date 2018.12.29
 *
 */
@Mapper
public interface GrtCollateralInsuranceMapper {
    int deleteByPrimaryKey(String insuranceId);

    int insert(GrtCollateralInsurance record);

    int insertSelective(GrtCollateralInsurance record);

    GrtCollateralInsurance selectByPrimaryKey(String insuranceId);

    int updateByPrimaryKeySelective(GrtCollateralInsurance record);

    int updateByPrimaryKey(GrtCollateralInsurance record);
    /**
     * 查询所有保险信息
     * @param guarantyId
     * @param insuranceCompanyName
     * @param insurancePolicyNum
     * @param policyHolder
     * @return
     */
	List<GrtCollateralInsurance> selectAll(@Param("guarantyId") String guarantyId,
			@Param("insuranceCompanyName") String insuranceCompanyName, 
			@Param("insurancePolicyNum") String insurancePolicyNum,
			@Param("policyHolder") String policyHolder);
	/**
	 * 批量删除保险信息
	 * @param ids
	 * @return
	 */
	int deleteBatch(@Param("ids") String[] ids);
}