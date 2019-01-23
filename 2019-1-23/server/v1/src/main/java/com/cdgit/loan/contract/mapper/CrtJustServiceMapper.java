package com.cdgit.loan.contract.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CrtJustServiceMapper {

	List<HashMap<String,String>> getConXwAmountId(Map map);
	
}
