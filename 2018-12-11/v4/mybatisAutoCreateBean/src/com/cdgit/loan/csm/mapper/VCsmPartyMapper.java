package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.VCsmParty;

public interface VCsmPartyMapper {
    int insert(VCsmParty record);

    int insertSelective(VCsmParty record);
}