/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmIllegalListVo;
import com.cdgit.loan.csm.bean.CsmNaturalAdditiveListVo;
import com.cdgit.loan.csm.bean.CsmNaturalBusinessVo;
import com.cdgit.loan.csm.bean.CsmNaturalCreditListVo;
import com.cdgit.loan.csm.bean.CsmNaturalInfoVo;
import com.cdgit.loan.csm.bean.CsmNaturalSchoolVo;
import com.cdgit.loan.csm.bean.CsmRelativePsnListVo;



/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmNatrualMapper {
	
	//
	List<CsmNaturalInfoVo> getNaturalInfo(Map map);
	
	//自然人关联关系  
	List<CsmRelativePsnListVo> getRelativePsnList(Map map);
	
	//信用信息
	List<CsmNaturalBusinessVo> queryNaturalBusiness(Map map);
	
	
	List<CsmNaturalSchoolVo> queryNaturalSchool(Map map);
	
	
	List<CsmNaturalCreditListVo> getNaturalCreditList(Map map);
	
	
	List<CsmNaturalAdditiveListVo> getAdditiveList(Map map);
	
	
	//违约记录
	List<CsmIllegalListVo> getIllegalList(Map map);
	
	
	
	
	
	
	
	

}
