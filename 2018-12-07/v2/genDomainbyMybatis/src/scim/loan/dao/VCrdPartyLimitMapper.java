package scim.loan.dao;

import scim.loan.domain.VCrdPartyLimit;

public interface VCrdPartyLimitMapper {
    int insert(VCrdPartyLimit record);

    int insertSelective(VCrdPartyLimit record);
}