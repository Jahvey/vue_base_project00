/**
 * 
 */
package com.cdgit.loan.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmRuleEngineMapper;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmRuleEngineServiceImpl {
	
	@Autowired
	CsmRuleEngineMapper csmRuleEngineMapper;
	
	

	
}
