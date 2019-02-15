package com.cdgit.loan.user.mapper;

import com.cdgit.loan.user.bean.TbIrmInternalRatingApply;

public interface TbIrmInternalRatingApplyMapper {
    int deleteByPrimaryKey(String IRA_APPLY_ID);

    int insert(TbIrmInternalRatingApply record);

    int insertSelective(TbIrmInternalRatingApply record);

    TbIrmInternalRatingApply selectByPrimaryKey(String IRA_APPLY_ID);

    int updateByPrimaryKeySelective(TbIrmInternalRatingApply record);

    int updateByPrimaryKey(TbIrmInternalRatingApply record);
}