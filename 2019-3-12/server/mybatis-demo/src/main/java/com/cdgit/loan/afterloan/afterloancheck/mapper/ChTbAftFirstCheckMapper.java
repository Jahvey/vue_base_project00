package com.cdgit.loan.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
@Mapper
public interface ChTbAftFirstCheckMapper {
    //贷后首次检查借据列表查询
	List<BorListResult> selectBorList(Map map);

   
}