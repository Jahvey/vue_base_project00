package com.cdgit.loan.guaranteevaluation.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.guaranteevaluation.bean.ConGuaranteQuota;
import com.cdgit.loan.guaranteevaluation.bean.ConGuaranteQuotaKey;

@Mapper
public interface ConGuaranteQuotaMapper {
    int deleteByPrimaryKey(ConGuaranteQuotaKey key);

    int insert(ConGuaranteQuota record);

    int insertSelective(ConGuaranteQuota record);

    ConGuaranteQuota selectByPrimaryKey(ConGuaranteQuotaKey key);

    int updateByPrimaryKeySelective(ConGuaranteQuota record);

    int updateByPrimaryKey(ConGuaranteQuota record);
}