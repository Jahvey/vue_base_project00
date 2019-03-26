package com.cdgit.loan.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
@Mapper
public interface ChImportantCheckMapper {
    //重点常检查客户合同列表查询
	List<BorListResult> selectImportantCheck(Map map);
	
   
}