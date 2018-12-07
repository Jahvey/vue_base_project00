package scim.loan.dao;

import scim.loan.domain.TbAccFinanceBillAccount;

public interface TbAccFinanceBillAccountMapper {
    int deleteByPrimaryKey(String billAccountId);

    int insert(TbAccFinanceBillAccount record);

    int insertSelective(TbAccFinanceBillAccount record);

    TbAccFinanceBillAccount selectByPrimaryKey(String billAccountId);

    int updateByPrimaryKeySelective(TbAccFinanceBillAccount record);

    int updateByPrimaryKey(TbAccFinanceBillAccount record);
}