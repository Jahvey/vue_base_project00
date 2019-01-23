package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbConSubcontractRelPo;

@Mapper
public interface CsmTbConSubcontractRelMapper {

	// 查询主合同下所关联的所有从合同
	List<TbConSubcontractRelPo> queryListCsmTbConSubcontractRelByconId(String contractId);
	//担保合同信息
	List<TbConSubcontractRelPo> queryListCsmTbConSubcontractRelPo(Map map);
	
    int deleteCsmTbConSubcontractRelByConSubconId(String conSubconId);

    int insertCsmTbConSubcontractRel(TbConSubcontractRelPo record);

    int insertCsmTbConSubcontractRelSelective(TbConSubcontractRelPo record);

    TbConSubcontractRelPo queryCsmTbConSubcontractRelByConSubconId(String conSubconId);

    int updateCsmTbConSubcontractRelSelective(TbConSubcontractRelPo record);

    int updateCsmTbConSubcontractRel(TbConSubcontractRelPo record);
	
	
}