package com.cdgit.loan.guaranteevaluation.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.guaranteevaluation.bean.CashDepositBean;
import com.cdgit.loan.guaranteevaluation.bean.GrtMargin;
@Mapper
public interface GrtMarginMapper {
    int deleteByPrimaryKey(String suretyKeyId);

    int insert(GrtMargin record);

    int insertSelective(GrtMargin record);

    GrtMargin selectByPrimaryKey(String suretyKeyId);

    int updateByPrimaryKeySelective(GrtMargin record);

    int updateByPrimaryKey(GrtMargin record);
    /**
     * 查询保证金列表
     * @param applyId
     * @return
     */
	List<CashDepositBean> getCashDepositList(@Param("applyId")String applyId);
	/**
	 * 根据id查询保证金
	 * @param suretyKeyId
	 * @return
	 */
	CashDepositBean selectDepositBySuretyKeyId(@Param("suretyKeyId")String suretyKeyId);
	/**
	 * 通过suretyId查询保证金
	 * @param suretyId
	 * @return
	 */
	Map<String,Object> selectBySuretyId(@Param("suretyId")String suretyId);
}