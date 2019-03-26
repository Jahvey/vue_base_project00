/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmPubConfigPo;
import com.cdgit.loan.csm.po.CsmPubConfigPoKey;

/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmCsmPubConfigMapper {
	
	List<CsmPubConfigPo> queryCsmPubConfig(HashMap map);
	

    int deleteCsmPubConfigByKeys(CsmPubConfigPoKey key);

    int insertCsmPubConfig(CsmPubConfigPo record);

    int insertCsmPubConfigSelective(CsmPubConfigPo record);

    CsmPubConfigPo selectCsmPubConfigByKeys(CsmPubConfigPoKey key);

    int updateByPrimaryKeySelective(CsmPubConfigPo record);

    int updateByPrimaryKey(CsmPubConfigPo record);
	

}
