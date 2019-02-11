package com.cdgit.ledger.pubquery.mapper ;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.ledger.pubquery.resultbean.MonitorLedgerResult;

@Mapper
public interface ChTbLoanZhMapper {
  //逾期监控查询
  List<MonitorLedgerResult> selectYuqiMonitorLedger(Map map);
  //到期监控查询
  List<MonitorLedgerResult> selectDaoQiMonitorLedger(Map map);
  //到期监控查询
  List<MonitorLedgerResult> selectFangKuanMonitorLedger(Map map);
  //回收监控查询
  List<MonitorLedgerResult> selectHuiShouMonitorLedger(Map map);
  //欠息监控查询
  List<MonitorLedgerResult> selectQianXiMonitorLedger(Map map);
  
}