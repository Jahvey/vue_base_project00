package com.cdgit.loan.contract.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbBizApply;

@Mapper
public interface CrtTbBizApplyMapper {

    CrtTbBizApply selectBizApplyByApplyId(String applyId);
    
    //根据起止期算期限
    Integer selectLoanlength(Map map);

}