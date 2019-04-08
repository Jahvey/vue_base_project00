package com.cdgit.loan.guaranteevaluation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.guaranteevaluation.bean.BizGrtMaxloanconApply;
@Mapper
public interface BizGrtMaxloanconApplyMapper {
    int deleteByPrimaryKey(String maxloanconId);

    int insert(BizGrtMaxloanconApply record);

    int insertSelective(BizGrtMaxloanconApply record);

    BizGrtMaxloanconApply selectByPrimaryKey(String maxloanconId);

    int updateByPrimaryKeySelective(BizGrtMaxloanconApply record);

    int updateByPrimaryKey(BizGrtMaxloanconApply record);
    /**
     * 
     * @param applyId
     * @param subcontractId
     * @param reType
     * @return
     */
	List<BizGrtMaxloanconApply> selectByConditions(@Param("applyId")String applyId, 
			@Param("subcontractId")String subcontractId,@Param("reType") String reType);
}