package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbBizYesOrNoApply;

@Mapper
public interface CsmTbBizYesOrNoApplyMapper {
    int deleteByPrimaryKey(String yesornoId);

    int insert(CsmTbBizYesOrNoApply record);

    int insertSelective(CsmTbBizYesOrNoApply record);

    CsmTbBizYesOrNoApply selectByPrimaryKey(String yesornoId);

    int updateByPrimaryKeySelective(CsmTbBizYesOrNoApply record);

    int updateByPrimaryKey(CsmTbBizYesOrNoApply record);
}