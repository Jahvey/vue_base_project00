/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cdgit.loan.csm.bean.CsmBizMainVo;
import com.cdgit.loan.csm.bean.CsmPartyBasisVo;
import com.cdgit.loan.csm.bean.CsmTbBizApprove;

/**
 * @author cwalk
 *
 */
@Mapper  //TODO 待测接口。。。。。。
public interface CsmBizInfoVoMapper {
	
	
	CsmTbBizApprove getBizApproveBasic(String approveId);
	
	CsmPartyBasisVo getPartyBasis(String partyId);
	
	CsmBizMainVo getBizMain(String approveId);
	
}
