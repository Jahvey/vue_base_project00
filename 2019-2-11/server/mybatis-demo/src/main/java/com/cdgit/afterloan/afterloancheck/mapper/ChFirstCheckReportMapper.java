package com.cdgit.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.afterloan.afterloancheck.resultbean.BorListResult;
@Mapper
public interface ChFirstCheckReportMapper {
    //首次检查报告列表
	List<BorListResult> selectFirstCheckReport(Map map);

   
}