/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbSysApplyDaoConfigPo;

/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmTbSysApplyDaoConfigMapper {

	
	List<TbSysApplyDaoConfigPo> queryListTbSysApplyDaoConfigByPhase(String phase);
	
	
	List<TbSysApplyDaoConfigPo> queryAllListTbSysApplyDaoConfig();
	

    int updateCsmTbSysApplyDaoConfigSelective(TbSysApplyDaoConfigPo record);

    int updateCsmTbSysApplyDaoConfig(TbSysApplyDaoConfigPo record);
    
    int deleteCsmTbSysApplyDaoConfig(String configId);

    int insertCsmTbSysApplyDaoConfig(TbSysApplyDaoConfigPo record);

    int insertCsmTbSysApplyDaoConfigSelective(TbSysApplyDaoConfigPo record);
    
   
	
}
