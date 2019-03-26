package com.cdgit.loan.contract.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.ConFlagInfo;

/**
 * 合同标志信息表	tb_Con_Flag_Info
 * @author Administrator
 *
 */
@Mapper
public interface ConFlagInfoMapper {

	//测试
    ConFlagInfo selectByPrimaryKey(String flagId);
    
    HashMap<String,String> getSomeThing(String flagId);

}