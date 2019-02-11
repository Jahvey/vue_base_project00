package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbBizTxxxApply;

/**
 * TB_BIZ_TXXX_APPLY:贴现票据信息
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbBizTxxxApplyMapper {

	//根据主键查询一条贴现票据信息
    CrtTbBizTxxxApply selectTbBizTxxxApplyByPrimaryKey(String applyDetailId);
    
    //根据额度申请明细ID查询多条贴现票据信息
    List<CrtTbBizTxxxApply> queryTXXX(String amountDetailId);

}