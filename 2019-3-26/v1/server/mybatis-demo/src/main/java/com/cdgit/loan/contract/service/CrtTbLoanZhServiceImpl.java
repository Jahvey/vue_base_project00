package com.cdgit.loan.contract.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.CrtTbLoanZh;
import com.cdgit.loan.contract.mapper.CrtTbLoanZhMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class CrtTbLoanZhServiceImpl {

	@Autowired
	CrtTbLoanZhMapper loanZhMapper;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<CrtTbLoanZh> queryloanZhService(HashMap<String,Object> map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CrtTbLoanZh> loanAccInfoList = loanZhMapper.getLoanAccInfoList((String)map.get("loanId"));
        PageInfo pageInfo=new PageInfo(loanAccInfoList,(Integer)map.get("pageSize"));
    	return pageInfo;
	}

	public CrtTbLoanZh queryCrtTbLoanZhById(String id){
		return loanZhMapper.selectLoanZhByPrimaryKey(id);
	}
}
