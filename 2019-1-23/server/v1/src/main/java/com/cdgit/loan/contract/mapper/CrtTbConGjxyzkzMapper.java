package com.cdgit.loan.contract.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbConGjxyzkz;
import com.cdgit.loan.contract.bean.CrtTbConJkbh;

/**
 * 国际信用证开证	tb_Con_Gjxyzkz
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbConGjxyzkzMapper {

    CrtTbConGjxyzkz selectCrtTbConGjxyzkzByapplyDetailId(String applyDetailId);
    
    //根据合同id和业务申请明细id获得一条国际信用证开证
    CrtTbConGjxyzkz selectCrtTbConGjxyzkzByContractInfo(Map map);

}