package com.cdgit.loan.csm.pub.gitUtils;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CsmGitUtilsMapper {
	
	 /**
     * 查询时间配置表里面的日期
     * @return
     */
	Date queryInitBusiDate();
	
	 //查询序列号
    String querySeqByName(Map map);

	
}
