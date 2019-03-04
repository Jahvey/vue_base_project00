package com.cdgit.loan.guaranteevaluation.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.guaranteevaluation.bean.BizApply;
@Mapper
public interface BizApplyMapper {
    int deleteByPrimaryKey(String applyId);

    int insert(BizApply record);

    int insertSelective(BizApply record);

    BizApply selectByPrimaryKey(String applyId);

    int updateByPrimaryKeySelective(BizApply record);

    int updateByPrimaryKey(BizApply record);
}