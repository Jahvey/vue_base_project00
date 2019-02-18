package com.cdgit.ledger.pubquery.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.ledger.pubquery.mapper.ChTbLoanZhMapper;
import com.cdgit.ledger.pubquery.resultbean.MonitorLedgerResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChTbLoanZhMapperImpl {
	
	@Autowired
	ChTbLoanZhMapper chTbLoanZhMapper;
	
	//监控台账查询
	public PageInfo<MonitorLedgerResult> selectMonitorLedger(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		if(map.get("jklx")==null || map.get("jklx").equals("") || map.get("jklx").equals("1") ){
			List<MonitorLedgerResult> monitorLedgerResultList = 
                    chTbLoanZhMapper.selectYuqiMonitorLedger(map);
			PageInfo pageInfo = new PageInfo<>(monitorLedgerResultList, (Integer)map.get("pageSize"));
			return pageInfo;
		}else if(map.get("jklx").equals("2")){
			List<MonitorLedgerResult> monitorLedgerResultList = 
                    chTbLoanZhMapper.selectDaoQiMonitorLedger(map);
			PageInfo pageInfo = new PageInfo<>(monitorLedgerResultList, (Integer)map.get("pageSize"));
			return pageInfo;
		}else if(map.get("jklx").equals("3")){
			List<MonitorLedgerResult> monitorLedgerResultList = 
                    chTbLoanZhMapper.selectFangKuanMonitorLedger(map);
			PageInfo pageInfo = new PageInfo<>(monitorLedgerResultList, (Integer)map.get("pageSize"));
			return pageInfo;
		}else if(map.get("jklx").equals("4")){
			List<MonitorLedgerResult> monitorLedgerResultList = 
                    chTbLoanZhMapper.selectHuiShouMonitorLedger(map);
			PageInfo pageInfo = new PageInfo<>(monitorLedgerResultList, (Integer)map.get("pageSize"));
			return pageInfo;
		}else{
			List<MonitorLedgerResult> monitorLedgerResultList = 
                    chTbLoanZhMapper.selectQianXiMonitorLedger(map);
			PageInfo pageInfo = new PageInfo<>(monitorLedgerResultList, (Integer)map.get("pageSize"));
			return pageInfo;
		}
		
		
	}
	
	
	
	
}
