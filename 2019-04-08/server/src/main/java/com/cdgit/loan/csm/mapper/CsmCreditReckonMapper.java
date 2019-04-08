/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmCreditReckonMapper {

	List<HashMap<String, Object>>  getConCredit(String contractId);
	
	List<HashMap<String, Object>>  getBizDtlCredit(String amountDetailId);
	
	List<HashMap<String, Object>>  getCrdDtlCredit(String crdDtlId);
	
	
	
}
