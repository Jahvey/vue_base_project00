package scim.loan.dao;

import scim.loan.domain.TbIrmInternalRatingApply;

public interface TbIrmInternalRatingApplyMapper {
    int deleteByPrimaryKey(String iraApplyId);

    int insert(TbIrmInternalRatingApply record);

    int insertSelective(TbIrmInternalRatingApply record);

    TbIrmInternalRatingApply selectByPrimaryKey(String iraApplyId);

    int updateByPrimaryKeySelective(TbIrmInternalRatingApply record);

    int updateByPrimaryKey(TbIrmInternalRatingApply record);
}