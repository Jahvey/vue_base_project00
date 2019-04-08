package com.cdgit.loan.afterloan.riskclass.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.afterloan.riskclass.resultbean.HistoriyAdjustRecordResult;
import com.cdgit.loan.afterloan.riskclass.resultbean.QuarSmallNaturalResult;
@Mapper
public interface ChHistoriyAdjustRecordMapper {
    //风险分类-历史调整记录
    List<HistoriyAdjustRecordResult> selectHistoriyAdjustRecord(Map map);

   
}