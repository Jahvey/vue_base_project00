package com.cdgit.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.afterloan.afterloancheck.resultbean.BorListResult;
@Mapper
public interface ChMicCentreFirstCheckMapper {
    //小贷中心首次检查 
	List<BorListResult> selectMicCentreFirstCheck(Map map);

   
}