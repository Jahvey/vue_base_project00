package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbSysBasicRate;

@Mapper
public interface CrtTbSysBasicRateMapper {

    CrtTbSysBasicRate selectSysBasicRateByIntRateId(String intRateId);
    
    //通过利率编号查询多条符合的利率信息，存在则获取第一条数据
    List<CrtTbSysBasicRate> selectSysBasicRateByIntRateCd(String intRateCd);

}