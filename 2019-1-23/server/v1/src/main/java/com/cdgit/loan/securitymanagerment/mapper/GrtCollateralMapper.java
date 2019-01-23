package com.cdgit.loan.securitymanagerment.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.securitymanagement.bean.GrtCollateral;
import com.cdgit.loan.securitymanagement.bean.NaturalPersonCollateral;
/**
 * 抵质押物dao
 * @author wuyong
 * @date 2018.12.25
 *
 */
@Mapper
public interface GrtCollateralMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtCollateral record);

    int insertSelective(GrtCollateral record);

    GrtCollateral selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtCollateral record);

    int updateByPrimaryKey(GrtCollateral record);

	List<NaturalPersonCollateral> selectNaturalPersonCollateralAll(
			@Param("userNum")String userNum, 
			@Param("orgNum")String orgNum, 
			@Param("orderField")String orderField, 
			@Param("sort")String sort,
			@Param("customerType")String customerType, 
			@Param("partyNum")String partyNum,
			@Param("partyName")String partyName, 
			@Param("certType")String certType, 
			@Param("certNum")String certNum,
			@Param("collateralTypeCd")String collateralTypeCd, 
			@Param("collateralName")String collateralName,
			@Param("isFarmer")String isFarmer,
			@Param("phoneNumber")String phoneNumber);
	/**
	 * 查询抵质押品绑定的担保品共有人、保险、登记、公证、意外条数
	 * @param guarantyId
	 * @return
	 */
	Map<String, Object> selectBandRelationResult(@Param("guarantyId")String guarantyId);
}