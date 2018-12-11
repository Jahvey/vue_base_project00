package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbConContractInfo;

public interface TbConContractInfoMapper {
    int insert(TbConContractInfo record);

    int insertSelective(TbConContractInfo record);
}