package com.cdgit.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.afterloan.afterloancheck.resultbean.BorListResult;
@Mapper
public interface ChBeforeMatCheckMapper {
    //贷款到期前跟踪检查借据列表
	List<BorListResult> selectBeforeMatCheck(Map map);

   
}