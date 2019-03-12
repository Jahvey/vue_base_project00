package com.cdgit.loan.guaranteevaluation.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.guaranteevaluation.bean.GrtMortgageBasic;
import com.cdgit.loan.guaranteevaluation.bean.MortgageBasicBean;
@Mapper
public interface GrtMortgageBasicMapper {
    int deleteByPrimaryKey(String suretyId);

    int insert(GrtMortgageBasic record);

    int insertSelective(GrtMortgageBasic record);

    GrtMortgageBasic selectByPrimaryKey(String suretyId);

    int updateByPrimaryKeySelective(GrtMortgageBasic record);

    int updateByPrimaryKey(GrtMortgageBasic record);
    /**
     * 查询担保评价中的抵押，质押
     * @param applyId
     * @param collType
     * @return
     */
	List<MortgageBasicBean> getMortgageList(@Param("applyId")String applyId, @Param("collType")String collType);
	/**
	 * 
	 * @param customerType
	 * @return
	 */
	List<MortgageBasicBean> getCollateralList(
			@Param("customerType")String customerType,
			@Param("collType")String collType,
			@Param("partyName")String partyName,@Param("certType")String certType,
			@Param("certNum")String certNum);
	/**
	 * 根据抵质押物id和业务id查询关联抵质押信息
	 * @param suretyNo
	 * @param applyId
	 * @return
	 */
	List<Map<String, Object>> selectBySuretyIdAndApplyId(@Param("suretyId")String suretyId,
			@Param("applyId")String applyId);
	/**
	 * 根据主键suretyId查询绑定抵质押品信息，返回的是TB_GRT_MORTGAGE_BASIC与TB_BIZ_GRT_REL方便更新
	 * @param suretyId
	 * @return
	 */
	MortgageBasicBean selectMortgageBasicBySuretyId(String suretyId);
}