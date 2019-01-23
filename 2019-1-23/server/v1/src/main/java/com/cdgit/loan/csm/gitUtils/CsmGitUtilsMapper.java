package com.cdgit.loan.csm.gitUtils;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CsmGitUtilsMapper {
	
	
	Date queryInitBusiDate();

	
}
