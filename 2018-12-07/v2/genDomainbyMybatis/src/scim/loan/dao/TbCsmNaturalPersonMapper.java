package scim.loan.dao;

import scim.loan.domain.TbCsmNaturalPerson;

public interface TbCsmNaturalPersonMapper {
    int deleteByPrimaryKey(String partyId);

    int insert(TbCsmNaturalPerson record);

    int insertSelective(TbCsmNaturalPerson record);

    TbCsmNaturalPerson selectByPrimaryKey(String partyId);

    int updateByPrimaryKeySelective(TbCsmNaturalPerson record);

    int updateByPrimaryKey(TbCsmNaturalPerson record);
}