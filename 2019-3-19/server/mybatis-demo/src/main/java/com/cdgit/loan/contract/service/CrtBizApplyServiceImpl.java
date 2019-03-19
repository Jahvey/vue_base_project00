package com.cdgit.loan.contract.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

	// 计算基准利率(直接返回一个利率)
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
		if ("1".equals(rateType)) {// 普通人民币
			if (loanlength <= 6) {
				intRateCd = "1";
			} else if (loanlength > 6 && loanlength <= 12) {
				intRateCd = "2";
			} else if (loanlength > 12 && loanlength <= 36) {
				intRateCd = "3";
			} else if (loanlength > 36 && loanlength <= 60) {
				intRateCd = "4";
			} else if (loanlength > 60) {
				intRateCd = "5";
			}
		} else if ("2".equals(rateType)) {// 公积金
			if (loanlength <= 60) {
				intRateCd = "6";
			} else if (loanlength > 60) {
				intRateCd = "7";
			}
		}
		List<CrtTbSysBasicRate> sysBasicRate = sysBasicRateMapper.selectSysBasicRateByIntRateCd(intRateCd);
		BigDecimal intRate = new BigDecimal(0);
		if (sysBasicRate.size() > 0) {
			intRate = sysBasicRate.get(0).getIntRate();
		}
		return intRate;

	}

	public String addDate(String qxdw, int qx, String rq) {
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		rq = sdf.format(Long.valueOf(rq));
		cl.set(Integer.parseInt(rq.substring(0, 4)), (Integer.parseInt(rq.substring(5, 7)) - 1),
				Integer.parseInt(rq.substring(8, 10)));
		if ("Y".equals(qxdw)) {
			cl.add(Calendar.YEAR, qx);
		} else if ("J".equals(qxdw)) {
			cl.add(Calendar.MONTH, qx * 3);
		} else if ("M".equals(qxdw)) {
			cl.add(Calendar.MONTH, qx);
		} else if ("D".equals(qxdw)) {
			cl.add(Calendar.DAY_OF_MONTH, qx);
		} else {
			return "";
		}
		String nowTimeFormart = cl.get(Calendar.YEAR) + "-" + (cl.get(Calendar.MONTH) < 9 ? "0" : "")
				+ (cl.get(Calendar.MONTH) + 1) + "-" + (cl.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "")
				+ cl.get(Calendar.DAY_OF_MONTH);
		try {
			return String.valueOf(sdf.parse(nowTimeFormart).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	//按期限单位计算两日期间期限
	public Integer retDateTerm(String qxdw, String qsrq, String dqrq) {
		Integer a = 0;
		if ("Y".equals(qxdw)) {
			a = (Integer)accountDateYear(qsrq, dqrq);
		} else if ("M".equals(qxdw)) {
			a = (Integer)accountDateMoth(qsrq, dqrq);
		} else if ("D".equals(qxdw)) {
			a = (Integer) getDistDates(qsrq, dqrq);
		}
		return a;
	}

	// 两日期间计算天数
	public Serializable getDistDates(String qsrq, String dqrq) {
		Long beginTime = Long.parseLong(qsrq);
		Long endTime = Long.parseLong(dqrq);
		Long days = ((endTime - beginTime) / (3600 * 24 * 1000));
		return days;
	}

	// 两日期差值计算月
	public Serializable accountDateMoth(String qsrq, String dqrq) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		qsrq = sdf.format(Long.valueOf(qsrq));
		dqrq = sdf.format(Long.valueOf(dqrq));
		String[] s1 = qsrq.split("-");
		String[] s2 = dqrq.split("-");
		int year1 = Integer.parseInt(s1[0]);
		int year2 = Integer.parseInt(s2[0]);
		if (year2 - year1 < 0) {
			throw new RuntimeException("输入的终止日期年份小于起始日期的年份");
		}
		int a = 12 * (year2 - year1);
		int month1 = Integer.parseInt(s1[1]);
		int month2 = Integer.parseInt(s2[1]);
		int b = month2 - month1;
		int day1 = Integer.parseInt(s1[2]);
		int day2 = Integer.parseInt(s2[2]);
		int c = a + b;
		if (day2 - day1 > 0) {
			c = a + b + 1;
		}
		return c;
	}

	// 根据日期差值计算年
	public Serializable accountDateYear(String qsrq, String dqrq) {
		Integer a = (Integer) accountDateMoth(qsrq, dqrq);
		Integer c = a / 12;
		return Math.ceil(c);
	}

}
