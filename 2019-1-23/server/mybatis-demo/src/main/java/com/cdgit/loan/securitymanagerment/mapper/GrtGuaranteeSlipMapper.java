package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtGuaranteeSlip;
/**
 * 保单Mapper
 * @author wuyong
 * @date 2019.1.10
 *
 */
@Mapper
public interface GrtGuaranteeSlipMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtGuaranteeSlip record);

    int insertSelective(GrtGuaranteeSlip record);

    GrtGuaranteeSlip selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtGuaranteeSlip record);

    int updateByPrimaryKey(GrtGuaranteeSlip record);
}