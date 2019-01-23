package com.cdgit.loan.sysManage.empManage.mapper;

import com.cdgit.loan.sysManage.empManage.bean.AcOperator;

public interface AcOperatorMapper {
    int deleteByPrimaryKey(Long operatorid);

    int insert(AcOperator record);

    int insertSelective(AcOperator record);

    AcOperator selectByPrimaryKey(Long operatorid);

    int updateByPrimaryKeySelective(AcOperator record);

    int updateByPrimaryKey(AcOperator record);
}