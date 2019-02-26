package com.cdgit.loan.guaranteevaluation.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.guaranteevaluation.bean.GrtGuaranteeBasic;
@Mapper
public interface GrtGuaranteeBasicMapper {
    int deleteByPrimaryKey(String suretyId);

    int insert(GrtGuaranteeBasic record);

    int insertSelective(GrtGuaranteeBasic record);

    GrtGuaranteeBasic selectByPrimaryKey(String suretyId);

    int updateByPrimaryKeySelective(GrtGuaranteeBasic record);

    int updateByPrimaryKey(GrtGuaranteeBasic record);

}