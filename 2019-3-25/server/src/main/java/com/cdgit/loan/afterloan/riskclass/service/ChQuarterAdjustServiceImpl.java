package com.cdgit.loan.afterloan.riskclass.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.afterloan.afterloancheck.mapper.ChAfterLoanCheckRosterMapper;
import com.cdgit.loan.afterloan.afterloancheck.mapper.ChTbAftFirstCheckMapper;
import com.cdgit.loan.afterloan.afterloancheck.resultbean.BorListResult;
import com.cdgit.loan.afterloan.riskclass.mapper.ChQuarterAdjustMapper;
import com.cdgit.loan.afterloan.riskclass.resultbean.QuarSmallNaturalResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChQuarterAdjustServiceImpl {
	@Autowired
	ChQuarterAdjustMapper chQuarterAdjustMapper;
	
	//风险分类-季度调整-小企业自然人
	public PageInfo<QuarSmallNaturalResult> selectQuarSmallNatural(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<QuarSmallNaturalResult> quarSmallNaturalResultList = chQuarterAdjustMapper.selectQuarSmallNatural(map);
		PageInfo pageInfo = new PageInfo<>(quarSmallNaturalResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
}
