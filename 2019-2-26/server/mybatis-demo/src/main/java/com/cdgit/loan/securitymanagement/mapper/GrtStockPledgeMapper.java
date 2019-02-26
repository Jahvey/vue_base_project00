package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtStockPledge;
/**
 * 股权股票基金公共信息Mapper
 * @author wuyong
 * @date 2019.1.10
 *
 */
@Mapper
public interface GrtStockPledgeMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtStockPledge record);

    int insertSelective(GrtStockPledge record);

    GrtStockPledge selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtStockPledge record);

    int updateByPrimaryKey(GrtStockPledge record);
}