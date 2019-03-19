package com.cdgit.loan.guaranteevaluation.mapper;

import java.util.Map;

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
	/**
	 * 根据业务id与suretyId查询绑定的担保品信息
	 * @param suretyId
	 * @param applyId
	 * @return
	 */
	Map<String, Object> selectBySuretyIdAndApplyId(@Param("suretyId")String suretyId, @Param("applyId")String applyId);
	
	Map<String, Object> selectBySuretyId(@Param("suretyId")String suretyId);
}