package com.cdgit.loan.securitymanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.securitymanagement.bean.GrtCollateralNotarization;
/**
 * 抵质押物公证信息Mapper
 * @author wuyong
 * @date 2018.12.29
 *
 */
@Mapper
public interface GrtCollateralNotarizationMapper {
    int deleteByPrimaryKey(String notarizationId);

    int insert(GrtCollateralNotarization record);

    int insertSelective(GrtCollateralNotarization record);

    GrtCollateralNotarization selectByPrimaryKey(String notarizationId);

    int updateByPrimaryKeySelective(GrtCollateralNotarization record);

    int updateByPrimaryKey(GrtCollateralNotarization record);
    
    int deleteBatch(@Param("ids") String[] ids);

	List<GrtCollateralNotarization> selectAll(@Param("guarantyId")String guarantyId, 
			@Param("loanContractNum")String loanContractNum,
			@Param("loanManName") String loanManName,
			@Param("loanCertificateType") String loanCertificateType, 
			@Param("certificateCode") String certificateCode, 
			@Param("notarialDeedNo") String notarialDeedNo,
			@Param("notarialOrg") String notarialOrg);
}