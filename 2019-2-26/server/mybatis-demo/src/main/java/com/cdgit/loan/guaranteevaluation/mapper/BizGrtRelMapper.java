package com.cdgit.loan.guaranteevaluation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.guaranteevaluation.bean.BizGrtRel;
@Mapper
public interface BizGrtRelMapper {
    int deleteByPrimaryKey(String relationId);

    int insert(BizGrtRel record);

    int insertSelective(BizGrtRel record);

    BizGrtRel selectByPrimaryKey(String relationId);

    int updateByPrimaryKeySelective(BizGrtRel record);

    int updateByPrimaryKey(BizGrtRel record);

	int updateBySuretyIdSelective(BizGrtRel bizGrtRel);
	/**
	 * 通过suretyId删除
	 * @param suretyId
	 * @return
	 */
	int deleteBySuretyId(@Param("suretyId")String suretyId);
}