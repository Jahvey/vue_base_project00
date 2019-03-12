package com.cdgit.loan.contract.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 时间配置表tb_pub_date，里面只有一条数据
 * @author Administrator
 *
 */
@Mapper
public interface CrtGitUtilMapper {

    /**
     * 查询时间配置表里面的日期
     * @return
     */
    String queryOperatingDate();
    
    //查询序列号
    String selectSeqByName(Map map);
}
