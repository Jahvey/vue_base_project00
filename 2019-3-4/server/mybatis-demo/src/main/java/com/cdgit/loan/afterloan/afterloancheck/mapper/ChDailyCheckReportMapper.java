package com.cdgit.loan.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
@Mapper
public interface ChDailyCheckReportMapper {
    //日常检查报告列表
	List<BorListResult> selectDailyCheckReport(Map map);

   
}