package com.cdgit.loan.guaranteevaluation.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.guaranteevaluation.bean.ConGuarantOrgInfo;
import com.cdgit.loan.guaranteevaluation.bean.GuarantorBean;

@Mapper
public interface ConGuarantOrgInfoMapper {
    int insert(ConGuarantOrgInfo record);

    int insertSelective(ConGuarantOrgInfo record);
    
	/**
	 * 查询该客户是否担保公司
	 * @param partyId
	 * @return
	 */
	Map<String, Object> isZYDBGS(@Param("partyId")String partyId);
	/**
	 * 查询预用额度
	 * @param partyId
	 * @return
	 */
	Map<String, Object> comMoney(@Param("partyId")String partyId);
	/**
	 * 查询已用额度
	 * @param partyId
	 * @return
	 */
	Map<String, Object> comMoney1(@Param("partyId")String partyId);
	/**
	 * 获取专业担保机构协议信息
	 * @param partyId
	 * @return
	 */
	ConGuarantOrgInfo selectByPartyId(@Param("partyId")String partyId);
	/**
	 * 查询该客户在担保公司已用的的担保金额
	 * @param conPartyId 客户id
	 * @return
	 */
	Map<String, Object> getConPartyAmt(@Param("conPartyId")String conPartyId);
	/**该担保公司未包含该保证金存储方式,未按照普元方式
	 * 
	 * @param partyId
	 * @return
	 */
	Map<String, Object> RBIZ_0217(@Param("partyId")String partyId);
	/**
	 * 查询当前业务申请保证人列表
	 * @param applyId
	 * @return
	 */
	List<GuarantorBean> getGuaranteerList(@Param("applyId")String applyId);
	/**
	 * 获取已关联的担保合同
	 * @param applyId
	 * @param collType
	 * @return
	 */
	List<Map<String, Object>> getMaxloanconList(@Param("applyId")String applyId,@Param("guarantyType") String guarantyType);
	/**
	 * 
	 * @param applyId
	 * @param guarantyType
	 * @return
	 */
	Map<String, Object> getGrtTypeCrd(@Param("applyId")String applyId, @Param("guarantyType")String guarantyType);
	/**
	 * 
	 * @param applyId
	 * @param guarantyType
	 * @return
	 */
	Map<String, Object> getGrtTypeBiz(@Param("applyId")String applyId, @Param("guarantyType")String guarantyType);
}