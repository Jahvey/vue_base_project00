package com.cdgit.loan.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
@Mapper
public interface ChSmallDailyCheckMapper {
    //小贷中心日常检查  
	List<BorListResult> selectSmallDailyCheck(Map map);

   
}