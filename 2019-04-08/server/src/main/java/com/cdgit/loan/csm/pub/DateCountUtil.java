package com.cdgit.loan.csm.pub;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdgit.loan.csm.pub.gitUtils.GitUtils;

@Service
@Transactional
public class DateCountUtil {
	
	@Autowired
	GitUtils gitUtils;
	
	//通过起始日期、到期日期、期限单位计算出期限
	public int getTermByEndDate(HashMap<String, Object> map){
		String beginDate=(String) map.get("beginDate");
		String endDate = (String)map.get("endDate");
		String termUnit = (String)map.get("termUnit");
		
		int term=0;
		try {
			term = gitUtils.retDateTerm(termUnit, beginDate, endDate);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return term;
		
	}
	
	
	//通过起始日期和期限 计算出合同到期日期
	public String getMonthAddDate(@RequestParam HashMap<String, Object> map){
		String qxdw=(String)map.get("qxdw");
		int qx=(int)map.get("qx");
		String rq=(String)map.get("rq");
		
		String dqrq;
		try {
			dqrq = gitUtils.addDate(qxdw, qx, rq);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		
		return dqrq;
		
	}
	

}
