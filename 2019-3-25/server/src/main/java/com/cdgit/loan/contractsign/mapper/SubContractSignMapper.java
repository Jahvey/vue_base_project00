package com.cdgit.loan.contractsign.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.contractsign.bean.ConAttachedInfo;
import com.cdgit.loan.contractsign.bean.ConNoticeAddrs;
import com.cdgit.loan.contractsign.bean.ConSubcontract;
import com.cdgit.loan.contractsign.bean.ContractBean;

@Mapper
public interface SubContractSignMapper {
	/**
	 * 获取合同下关联的抵押合同信息
	 * @param subcontractType
	 * @param applyId
	 * @param contractId
	 * @return
	 */
	List<Map<String, Object>> getConDyList(@Param("subcontractType")String subcontractType, 
			@Param("applyId")String applyId, @Param("contractId")String contractId);
	/**
	 * 抵押合同页面选择抵质人信息
	 * @param subcontractType
	 * @param applyId
	 * @return
	 */
	List<Map<String, Object>> selectParty(@Param("subcontractType")String subcontractType, @Param("applyId")String applyId);
	/**
	 * 通过担保合同id查询担保合同信息
	 * @param subcontractId
	 * @return
	 */
	ContractBean selectGrtConInfoBySubcontractId(@Param("subcontractId")String subcontractId,@Param("contractId")String contractId );
	int updateConSubcontractSelective(ConSubcontract conSubcontract);
	int updateConNoticeAddrsSelective(ConNoticeAddrs conNoticeAddrs);
	int updateConAttachedInfoSelective(ConAttachedInfo conAttachedInfo);
	/**
	 * 获取 担保合同 对应的押品信息
	 * @param subcontractId
	 * @param subcontractNum
	 * @param subcontractType
	 * @return
	 */
	List<Map<String, Object>> getConSub(@Param("subcontractId")String subcontractId, @Param("subcontractNum")String subcontractNum,
			@Param("subcontractType")String subcontractType);
	/**
	 * 签担保合同时，查询该客户下，该业务申请下  该笔业务下的担保物信息(担保合同可以引入的押品)
	 * @param applyId
	 * @param subcontractType 01 抵押 02质押
	 * @return
	 */
	List<Map<String, Object>> selSubGrt(@Param("applyId")String applyId
			,@Param("subcontractType") String subcontractType,
			@Param("subcontractId") String subcontractId,
			@Param("partyId") String partyId);
	/**
	 * 查询子合同信息
	 * @param subcontractId
	 * @return
	 */
	ContractBean selectSubContractBySubcontractId(@Param("subcontractId")String subcontractId);
	int insertConSubcontractSelective(ConSubcontract conSubcontract);
	int insertConNoticeAddrsSelective(ConNoticeAddrs conNoticeAddrs);
	int insertConAttachedInfoSelective(ConAttachedInfo conAttachedInfo);
	/**
	 * 删除贷款合同和担保合同观念
	 * @param conSubconId
	 * @return
	 */
	int deleteConSuncontractRelById(@Param("conSubconId")String conSubconId);
	/**
	 * 删除担保合同
	 * @param subcontractId
	 * @return
	 */
	int deleteSubcontractById(@Param("subcontractId")String subcontractId);
	/**
	 * 删除仲裁方式及签署信息
	 * @param subcontractId
	 * @return
	 */
	int deleteConAttachedInfoBySubcontractId(@Param("subcontractId")String subcontractId);
	/**
	 * 删除通知书和文书送达
	 * @param subcontractId
	 * @return
	 */
	int deleteConNoticeAddrsBySubcontractId(@Param("subcontractId")String subcontractId);
	/**
	 * 根据suretyId，subcontractId查询担保合同和押品关联信息
	 * @param suretyId
	 * @param subcontractId
	 * @return
	 */
	Map<String, Object> selectSubGrtRelBySuretyIdAndSubId(@Param("suretyId")String suretyId, @Param("subcontractId")String subcontractId);
	/**
	 * 查询业务申请阶段的押品信息
	 * @param suretyId
	 * @param applyId
	 * @return
	 */
	Map<String, Object> selectBizGrtRelBySuretyIdAndApplyId(@Param("suretyId")String suretyId, @Param("applyId")String applyId);
	/**
	 * 查询一个主合同只能绑定一种抵质押品类型
	 * @param contractId
	 * @param suretyId
	 * @return
	 */
	Map<String, Object> selectContractOnlyOneMpType(@Param("contractId")String contractId, @Param("suretyId")String suretyId);
	/**
	 * 获取已签合同保证合同信息
	 * @param contractId
	 * @return
	 */
	List<Map<String, Object>> getConBzrList(@Param("contractId")String contractId);
	/**
	 * 担保合同 对应批复信息
	 * @param subcontractId
	 * @return
	 */
	Map<String, Object> getApproveInfo(@Param("subcontractId")String subcontractId);
	/**
	 * 查询该担保合同下关联的押品
	 * @param subcontractId
	 * @return
	 */
	List<Map<String, Object>> selectConSubGrtRelBySubcontractId(@Param("subcontractId")String subcontractId);
	/**
	 * 获取 保证合同 下关联 保证人信息
	 * @param subcontractId
	 * @param contractId
	 * @return
	 */
	List<Map<String, Object>> getConSubBzr(@Param("subcontractId")String subcontractId, @Param("contractId")String contractId);
	/**
	 * 获取 综合授信 下关联 保证人信息
	 * @param subcontractId
	 * @param contractId
	 * @return
	 */
	List<Map<String, Object>> getCreditSubBzr(@Param("subcontractId")String subcontractId, @Param("contractId")String contractId);
	/**
	 * 签担保合同时，可以引入的保证人
	 * @param subcontractId
	 * @param subcontractType
	 * @param applyId
	 * @return
	 */
	List<Map<String, Object>> selSubGrtBzr(@Param("subcontractId")String subcontractId, 
			@Param("subcontractType")String subcontractType, 
			@Param("applyId")String applyId);
	/**
	 * 获取合同下的保证金协议列表
	 * @param subcontractId
	 * @param subcontractType
	 * @return
	 */
	List<Map<String, Object>> getConBZJList(@Param("contractId")String contractId, 
			@Param("subcontractType")String subcontractType);
	/**
	 * 获取 担保合同 对应的押品信息   保证金
	 * @param subcontractId
	 * @return
	 */
	List<Map<String, Object>> getConSubBzj(@Param("subcontractId")String subcontractId);
	/**
	 * 查询业务申请关联的保证金
	 * @param subcontractId
	 * @param subcontractType
	 * @param applyId
	 * @return
	 */
	List<Map<String, Object>> selSubGrtBzj(@Param("subcontractId")String subcontractId,
			@Param("subcontractType") String subcontractType, @Param("applyId")String applyId);
}
