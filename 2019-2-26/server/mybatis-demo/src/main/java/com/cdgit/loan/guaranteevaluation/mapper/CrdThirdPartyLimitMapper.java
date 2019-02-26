package com.cdgit.loan.guaranteevaluation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.guaranteevaluation.bean.CrdThirdPartyLimit;

@Mapper
public interface CrdThirdPartyLimitMapper {
    int deleteByPrimaryKey(String limitId);

    int insert(CrdThirdPartyLimit record);

    int insertSelective(CrdThirdPartyLimit record);

    CrdThirdPartyLimit selectByPrimaryKey(String limitId);

    int updateByPrimaryKeySelective(CrdThirdPartyLimit record);

    int updateByPrimaryKey(CrdThirdPartyLimit record);

    /**
     * 查询第三方担保额度信息
     * @param partyId
     * @return
     */
	CrdThirdPartyLimit selectByPartyId(@Param("partyId")String partyId);
}