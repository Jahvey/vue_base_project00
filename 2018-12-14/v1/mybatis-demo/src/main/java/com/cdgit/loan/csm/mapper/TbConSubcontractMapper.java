package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbConSubcontract;

public interface TbConSubcontractMapper {
    int deleteByPrimaryKey(String subcontractId);

    int insert(TbConSubcontract record);

    int insertSelective(TbConSubcontract record);

    TbConSubcontract selectByPrimaryKey(String subcontractId);

    int updateByPrimaryKeySelective(TbConSubcontract record);

    int updateByPrimaryKey(TbConSubcontract record);
}