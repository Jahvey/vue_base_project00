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
}
