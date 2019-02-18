package com.cdgit.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.afterloan.afterloancheck.resultbean.BorListResult;
@Mapper
public interface ChAfterLoanCheckRosterMapper {
    //贷后检查名单列表
	List<BorListResult> selectAfterLoanCheckRoster(Map map);

   
}