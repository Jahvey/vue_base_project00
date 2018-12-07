package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.VCrdPartyLimit;

public interface VCrdPartyLimitMapper {
    int insert(VCrdPartyLimit record);

    int insertSelective(VCrdPartyLimit record);
}