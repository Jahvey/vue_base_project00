/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbGrtMortgageBasicPo;

/**
 * @author Administrator
 *
 */
@Mapper
public interface CsmTbGrtMortgageBasicMapper {

	TbGrtMortgageBasicPo queryOneCsmTbGrtMortgageBasic(String suretyId);
	
	int deleteByPrimaryKey(String suretyId);
	
    int insertOneCsmTbGrtMortgageBasic(TbGrtMortgageBasicPo grt);

    int insertOneCsmTbGrtMortgageBasicSelective(TbGrtMortgageBasicPo grt);
    
    int updateCsmTbGrtMortgageBasicByPrimaryKeySelective(TbGrtMortgageBasicPo grt);
	
	int updateCsmTbGrtMortgageBasic(TbGrtMortgageBasicPo grt);
	
	
	
}
