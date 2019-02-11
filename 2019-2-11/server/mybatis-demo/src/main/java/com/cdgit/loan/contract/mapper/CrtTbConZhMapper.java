package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConZh;

/**
 * 合同账户信息表:Tb_Con_Zh
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConZhMapper {

    int insertSelective(CrtTbConZh record);

    CrtTbConZh selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CrtTbConZh record);

}