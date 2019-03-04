package com.cdgit.loan.contract.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.CrtTbSysBasicRate;
import com.cdgit.loan.contract.mapper.CrtTbBizApplyMapper;
import com.cdgit.loan.contract.mapper.CrtTbSysBasicRateMapper;

@Service
@org.springframework.transaction.annotation.Transactional
public class CrtBizApplyServiceImpl {

	@Autowired
	CrtTbSysBasicRateMapper sysBasicRateMapper; // 基础利率表

	@Autowired
	CrtTbBizApplyMapper bizApplyMapper; // 业务申请相关

	// 计算基准利率
	// public Serializable countRate(Date beginDate,Date endDate){
	// HashMap<String,Date> map = new HashMap<>();
	// map.put("beginDate", beginDate);
	// map.put("endDate", endDate);
	// Integer loanlength = bizApplyMapper.selectLoanlength(map);
	//
	// return loanlength;
	//
	// }
	
	//计算基准利率(直接返回一个利率)
	public Serializable countRate(String beginDate, String endDate, String productType) {
		HashMap<String, String> map = new HashMap<>();
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		Integer loanlength = bizApplyMapper.selectLoanlength(map);

		String rateType = "1";
		String intRateCd = "";
		if (productType == "02005001" || productType == "02005003" || productType == "02005010") {
			rateType = "2";
		}
		if("1".equals(rateType)){//普通人民币
			if (loanlength <= 6) {
				intRateCd ="1";
			} else if (loanlength > 6 && loanlength <= 12) {
				intRateCd ="2";
			} else if (loanlength > 12 && loanlength <= 36) {
				intRateCd ="3";
			} else if (loanlength > 36 && loanlength <= 60) {
				intRateCd ="4";
			} else if (loanlength > 60) {
				intRateCd ="5";
			}
		}else if ("2".equals(rateType)) {//公积金
			if (loanlength <= 60) {
				intRateCd ="6";
			} else if (loanlength > 60) {
				intRateCd ="7";
			}
		}
		List<CrtTbSysBasicRate> sysBasicRate = sysBasicRateMapper.selectSysBasicRateByIntRateCd(intRateCd);
		BigDecimal intRate = new BigDecimal(0);
		if(sysBasicRate.size()>0){
			intRate = sysBasicRate.get(0).getIntRate();
		}
		 return intRate;

	}

}
