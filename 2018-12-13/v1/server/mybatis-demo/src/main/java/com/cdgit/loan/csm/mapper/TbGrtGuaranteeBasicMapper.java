package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbGrtGuaranteeBasic;

public interface TbGrtGuaranteeBasicMapper {
    int deleteByPrimaryKey(String suretyId);

    int insert(TbGrtGuaranteeBasic record);

    int insertSelective(TbGrtGuaranteeBasic record);

    TbGrtGuaranteeBasic selectByPrimaryKey(String suretyId);

    int updateByPrimaryKeySelective(TbGrtGuaranteeBasic record);

    int updateByPrimaryKey(TbGrtGuaranteeBasic record);
}