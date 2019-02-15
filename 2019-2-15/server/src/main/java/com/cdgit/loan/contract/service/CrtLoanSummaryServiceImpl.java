package com.cdgit.loan.contract.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.bean.TbLoanSummary;
import com.cdgit.loan.contract.mapper.CrtGitUtilMapper;
import com.cdgit.loan.contract.mapper.CrtTbLoanSummaryMapper;
import com.cdgit.loan.contract.mapper.TbConContractInfoMapper;
import com.cdgit.loan.contract.query.LoanSummaryInfoQuery;
import com.cdgit.loan.contract.query.SummaryViewQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class CrtLoanSummaryServiceImpl {

	@Autowired
	CrtTbLoanSummaryMapper loanSummaryMapper;	//放款
	
	@Autowired
	TbConContractInfoMapper contractInfoMapper;	//合同
	
	@Autowired
	CrtGitUtilServiceImpl crtGitUtilService;	//公共的一些方法
	
	public TbLoanSummary selectByPrimaryKey(String summaryId){
		return loanSummaryMapper.selectByPrimaryKey(summaryId);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<LoanSummaryInfoQuery> getLoanSummaryInfo(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<LoanSummaryInfoQuery> tbLoanSummaryList = loanSummaryMapper.selectTbLoanSummaryList(map);
        PageInfo pageInfo=new PageInfo(tbLoanSummaryList,(Integer)map.get("pageSize"));
    	return pageInfo;
	}
	
	//根据借款ID查询一条详细借据信息
	public SummaryViewQuery getSummaryViewBySummaryId(String summaryId){
		return loanSummaryMapper.querySummaryViewBySummaryId(summaryId);
	}
	
	


	
}
