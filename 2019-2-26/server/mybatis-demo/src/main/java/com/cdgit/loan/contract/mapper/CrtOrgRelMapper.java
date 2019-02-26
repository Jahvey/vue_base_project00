package com.cdgit.loan.contract.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CrtOrgRelMapper {
	
	//查询经办机构相关
	List<HashMap<String,String>> selectOrgRel(Map map);

}
