package com.cdgit.loan.guaranteevaluation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.guaranteevaluation.bean.ConZh;
@Mapper
public interface ConZhMapper {
    int deleteByPrimaryKey(String id);

    int insert(ConZh record);

    int insertSelective(ConZh record);

    ConZh selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ConZh record);

    int updateByPrimaryKey(ConZh record);
    /**
     * 通过协议id查询担保账户基金
     * @param contractId
     * @return
     */
	List<ConZh> selectByContractId(@Param("contractId")String contractId);
}