package com.cdgit.loan.customerManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.bean.WarningDeal;

@Mapper
public interface WarningDealMapper {
    int deleteByPrimaryKey(String warnNo);

    int insert(WarningDeal record);

    int insertSelective(WarningDeal record);

    WarningDeal selectByPrimaryKey(String warnNo);

    int updateByPrimaryKeySelective(WarningDeal record);

    int updateByPrimaryKey(WarningDeal record);
    
    List<WarningDeal> queryWarnInfo(String ecifCustNum);
}