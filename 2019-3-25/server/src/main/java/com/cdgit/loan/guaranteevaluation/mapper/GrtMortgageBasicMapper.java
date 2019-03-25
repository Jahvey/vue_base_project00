package com.cdgit.loan.guaranteevaluation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.guaranteevaluation.bean.MortgageBasicBean;
@Mapper
public interface GrtMortgageBasicMapper {

    /**
     * 查询担保评价中的抵押，质押
     * @param applyId
     * @param suretyType
     * @return
     */
	List<MortgageBasicBean> getMortgageList(@Param("applyId")String applyId, @Param("suretyType")String suretyType);
	/**
	 * 
	 * @param customerType
	 * @return
	 */
	List<MortgageBasicBean> getCollateralList(
			@Param("customerType")String customerType,
			@Param("mpType")String mpType,
			@Param("partyName")String partyName,@Param("certType")String certType,
			@Param("certNum")String certNum);

	/**
	 * 根据主键suretyId查询绑定抵质押品信息，
	 * @param suretyId
	 * @return
	 */
	MortgageBasicBean selectMortgageBasicByRelationId(@Param("relationId")String relationId);
}