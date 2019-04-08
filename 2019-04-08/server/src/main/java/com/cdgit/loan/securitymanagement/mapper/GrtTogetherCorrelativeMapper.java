package com.cdgit.loan.securitymanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.securitymanagement.bean.GrtTogetherCorrelative;
/**
 * 共有人Mapper
 * @author wuyong
 *
 */
@Mapper
public interface GrtTogetherCorrelativeMapper {
    int deleteByPrimaryKey(String togetherCorrelativeId);

    int insert(GrtTogetherCorrelative record);

    int insertSelective(GrtTogetherCorrelative record);

    GrtTogetherCorrelative selectByPrimaryKey(String togetherCorrelativeId);

    int updateByPrimaryKeySelective(GrtTogetherCorrelative record);

    int updateByPrimaryKey(GrtTogetherCorrelative record);
    /**
     * 查询共有人
     * @param pageNum
     * @param pageSize
     * @param collateralNum
     * @param togetherCorrelativeName
     * @param togetherCertificateType
     * @param togetherCertificateNum
     * @param togetherCorrelativeId
     * @param guarantyId
     * @return
     */
	List<GrtTogetherCorrelative> selectAll(
			@Param("collateralNum") String collateralNum,
			@Param("togetherCorrelativeName") String togetherCorrelativeName, 
			@Param("togetherCertificateType") String togetherCertificateType,
			@Param("togetherCertificateNum") String togetherCertificateNum,
			@Param("togetherCorrelativeId") String togetherCorrelativeId, 
			@Param("guarantyId") String guarantyId);
	/**
	 * 批量删除共有人
	 * @param ids
	 * @return
	 */
	int deleteBatch(@Param("ids") String[] ids);
}