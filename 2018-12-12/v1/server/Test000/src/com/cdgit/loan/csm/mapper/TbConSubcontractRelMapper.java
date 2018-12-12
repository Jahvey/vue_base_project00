package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbConSubcontractRel;

public interface TbConSubcontractRelMapper {
    int deleteByPrimaryKey(String conSubconId);

    int insert(TbConSubcontractRel record);

    int insertSelective(TbConSubcontractRel record);

    TbConSubcontractRel selectByPrimaryKey(String conSubconId);

    int updateByPrimaryKeySelective(TbConSubcontractRel record);

    int updateByPrimaryKey(TbConSubcontractRel record);
}