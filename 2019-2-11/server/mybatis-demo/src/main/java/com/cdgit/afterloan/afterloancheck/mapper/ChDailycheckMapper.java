package com.cdgit.afterloan.afterloancheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.afterloan.afterloancheck.resultbean.BorListResult;
@Mapper
public interface ChDailycheckMapper {
    //可日常检查客户列表查询
	List<BorListResult> selectDailycheckCust(Map map);

   
}