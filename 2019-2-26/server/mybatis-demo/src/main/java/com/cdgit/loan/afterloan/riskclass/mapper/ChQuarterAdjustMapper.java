package com.cdgit.loan.afterloan.riskclass.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.afterloan.riskclass.resultbean.QuarSmallNaturalResult;
@Mapper
public interface ChQuarterAdjustMapper {
    //风险分类-季度调整-小企业自然人
    List<QuarSmallNaturalResult> selectQuarSmallNatural(Map map);

   
}