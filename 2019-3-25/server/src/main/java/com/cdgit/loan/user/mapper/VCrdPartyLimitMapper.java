package com.cdgit.loan.user.mapper;

import com.cdgit.loan.user.bean.VCrdPartyLimit;

public interface VCrdPartyLimitMapper {
    int insert(VCrdPartyLimit record);

    int insertSelective(VCrdPartyLimit record);
}