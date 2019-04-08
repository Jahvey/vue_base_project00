package com.cdgit.loan.guaranteevaluation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.guaranteevaluation.bean.CreditsafeBean;
import com.cdgit.loan.guaranteevaluation.bean.GrtCreditsafe;
@Mapper
public interface GrtCreditsafeMapper {
    int deleteByPrimaryKey(String suretyId);

    int insert(GrtCreditsafe record);

    int insertSelective(GrtCreditsafe record);

    GrtCreditsafe selectByPrimaryKey(String suretyId);

    int updateByPrimaryKeySelective(GrtCreditsafe record);

    int updateByPrimaryKey(GrtCreditsafe record);
    /**
     * 查询信用保险bean
     * @param applyId
     * @return
     */
	List<CreditsafeBean> getCreditsafeList(@Param("applyId")String applyId);
}