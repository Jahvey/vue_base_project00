package com.cdgit.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.afterloan.afterloancheck.resultbean.CheckFrequencyResult;
@Mapper
public interface ChCheckFrequencyMapper {
    //贷后检查频率列表
	List<CheckFrequencyResult> selectCheckFrequency(Map map);

   
}