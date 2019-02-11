package com.cdgit.loan.contract.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConJkbh;

/**
 * 22-进口保函批复		TB_CON_JKBH	
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConJkbhMapper {

	//进口保函，根据主键查询一条信息
    CrtTbConJkbh selectCrtTbConJkbhByapplyDetailId(String applyDetailId);
    
    //进口保函，根据合同id和业务申请明细id获得一条进口保函信息
    CrtTbConJkbh selectCrtTbConJkbhByContractInfo(Map map);

}