package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbConSubcontractRelPo;

@Mapper
public interface CsmTbConSubcontractRelMapper {

	
	
	//担保合同信息
	List<TbConSubcontractRelPo> queryListCsmTbConSubcontractRelPo(Map map);
}