package com.cdgit.loan.csm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizPjxxApplyPo;

@Mapper
public interface CsmTbBizPjxxApplyPoMapper {
	
	List<CsmTbBizPjxxApplyPo> queryListByAmtDetailIdAndHtbh(HashMap<String, String> map);
	
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizPjxxApplyPo record);

    int insertSelective(CsmTbBizPjxxApplyPo record);

    CsmTbBizPjxxApplyPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizPjxxApplyPo record);

    int updateByPrimaryKey(CsmTbBizPjxxApplyPo record);
    
    List<CsmTbBizPjxxApplyPo> queryByAmountDetailId(String amountDetailId);
}