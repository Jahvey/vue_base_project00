package scim.loan.dao;

import scim.loan.domain.VCsmParty;

public interface VCsmPartyMapper {
    int insert(VCsmParty record);

    int insertSelective(VCsmParty record);
}