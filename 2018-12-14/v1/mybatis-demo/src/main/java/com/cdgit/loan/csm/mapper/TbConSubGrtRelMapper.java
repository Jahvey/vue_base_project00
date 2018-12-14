package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbConSubGrtRel;

public interface TbConSubGrtRelMapper {
    int deleteByPrimaryKey(String relationId);

    int insert(TbConSubGrtRel record);

    int insertSelective(TbConSubGrtRel record);

    TbConSubGrtRel selectByPrimaryKey(String relationId);

    int updateByPrimaryKeySelective(TbConSubGrtRel record);

    int updateByPrimaryKey(TbConSubGrtRel record);
}