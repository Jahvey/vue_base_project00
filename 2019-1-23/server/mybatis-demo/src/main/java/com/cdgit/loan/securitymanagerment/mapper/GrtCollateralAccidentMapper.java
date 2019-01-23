package com.cdgit.loan.securitymanagerment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.securitymanagement.bean.GrtCollateralAccident;
/**
 * 抵质押物有意外信息Mapper
 * @author wuyong
 * @date 2018.12.29
 *
 */
@Mapper
public interface GrtCollateralAccidentMapper {
    int deleteByPrimaryKey(String accidentId);

    int insert(GrtCollateralAccident record);

    int insertSelective(GrtCollateralAccident record);

    GrtCollateralAccident selectByPrimaryKey(String accidentId);

    int updateByPrimaryKeySelective(GrtCollateralAccident record);

    int updateByPrimaryKey(GrtCollateralAccident record);
    int deleteBatch(@Param("ids") String[] ids);
    
	List<GrtCollateralAccident> selectAll(
			@Param("guarantyId") String guarantyId, 
			@Param("accidentTypeCd") String accidentTypeCd,
			@Param("currencyCd") String currencyCd);
}