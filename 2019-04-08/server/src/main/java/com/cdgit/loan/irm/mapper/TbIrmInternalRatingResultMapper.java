package com.cdgit.loan.irm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.irm.bean.TbIrmInternalRatingResult;

@Mapper
public interface TbIrmInternalRatingResultMapper {

	TbIrmInternalRatingResult selectIrmInternalRatingResultByApplyId(Map<String,String> map);
	
	List<TbIrmInternalRatingResult> selectIrmInternalRatingResultByIrrApplyId(String iraApplyId);
	
	int insertSelective(TbIrmInternalRatingResult tbIrmInternalRatingResult);
}
