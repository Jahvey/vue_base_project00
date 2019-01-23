/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbConSubContractTPo;

/**
 * @author Administrator
 *
 */

@Mapper
public interface CsmTbConSubContractTPoMapper {
	
	
	TbConSubContractTPo	queryOneTbConSubContractTPoInfo(String subcontractId);
	
	
    int deleteCsmTbConSubContractTById(String id);

    int insertCsmTbConSubContractT(TbConSubContractTPo record);

    int insertCsmTbConSubContractTSelective(TbConSubContractTPo record);

    TbConSubContractTPo queryOneCsmTbConSubContractTById(String id);

    int updateCsmTbConSubContractTSelective(TbConSubContractTPo record);

    int updateCsmTbConSubContractT(TbConSubContractTPo record);
	
	

	
}
