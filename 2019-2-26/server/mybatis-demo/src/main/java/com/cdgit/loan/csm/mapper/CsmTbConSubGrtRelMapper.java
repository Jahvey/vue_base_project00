package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbConSubGrtRelPo;

@Mapper
public interface CsmTbConSubGrtRelMapper {
	

	List<TbConSubGrtRelPo> queryListTbConSubGrtRel(String subcontractId);
	
    int deleteCsmTbConSubGrtRelByRelationId(String relationId);

    int insertCsmTbConSubGrtRel(TbConSubGrtRelPo record);

    int insertCsmTbConSubGrtRelSelective(TbConSubGrtRelPo record);

    TbConSubGrtRelPo queryOneCsmTbConSubGrtRelByRelationId(String relationId);

    int updateCsmTbConSubGrtRelSelective(TbConSubGrtRelPo record);

    int updateCsmTbConSubGrtRel(TbConSubGrtRelPo record);

	
}