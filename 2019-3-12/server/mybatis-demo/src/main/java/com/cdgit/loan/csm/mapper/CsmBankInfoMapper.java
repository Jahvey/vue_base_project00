/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmBankFinancingListVo;
import com.cdgit.loan.csm.bean.CsmBankFinancingListYWVo;
import com.cdgit.loan.csm.bean.CsmBankGuaranteeListVo;

/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmBankInfoMapper {

	//本行融资情况-批复
	List<CsmBankFinancingListVo> getfinancingList(Map map );
	
	//本行融资情况-业务信息
	List<CsmBankFinancingListYWVo> getfinancingListYW(Map map );
	
	//
	List<CsmBankGuaranteeListVo> getGuaranteeList(Map map );
	
	//为我行客户担保信息 本行抵质押情况
	List<CsmBankGuaranteeListVo> getGuaranteeListDY(Map map );
	
	
	
}
