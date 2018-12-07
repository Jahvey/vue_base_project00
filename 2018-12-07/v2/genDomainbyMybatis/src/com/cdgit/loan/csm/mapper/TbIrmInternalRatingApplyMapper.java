package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbIrmInternalRatingApply;

public interface TbIrmInternalRatingApplyMapper {
    int deleteByPrimaryKey(String IRA_APPLY_ID);

    int insert(TbIrmInternalRatingApply record);

    int insertSelective(TbIrmInternalRatingApply record);

    TbIrmInternalRatingApply selectByPrimaryKey(String IRA_APPLY_ID);

    int updateByPrimaryKeySelective(TbIrmInternalRatingApply record);

    int updateByPrimaryKey(TbIrmInternalRatingApply record);
}