/**
 * 
 */
package com.cdgit.loan.csm.process.bizApply;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author cwalk
 *
 */
@Mapper
public interface IProcessAction {
	
	ProcessParam action(String bizId);

}
