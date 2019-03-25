package com.cdgit.loan.common.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonUtilMapper {

	 /**
     * 查询时间配置表里面的日期
     * @return
     */
	Date queryInitBusiDate();
	
	/**
	 * 
	根据机构编号查询法人标识
	 * <p>Title: getOrgLegorg</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	String getLegorgByOrgCd(String orgcd);
	
	/**
	 * 
	根据机构编号查询法人标识
	 * <p>Title: getLegorgByPartyId</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	String getLegorgByPartyId(String partyId);
	
	/**
	 * 查询数据库配置表
	
	 * <p>Title: queryTbSysApplyDaoConfigList</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	List queryTbSysApplyDaoConfigList();
}
