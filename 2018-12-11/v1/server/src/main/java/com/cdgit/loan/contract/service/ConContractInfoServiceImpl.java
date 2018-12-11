package com.cdgit.loan.contract.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.ConApvList;
import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.mapper.TbConContractInfoMapper;
import com.cdgit.loan.user.bean.NaturealInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ConContractInfoServiceImpl {

	@Autowired
	TbConContractInfoMapper conContractInfoMapper;
	
	public TbConContractInfo getTbCsmNaturalPersonById(String contractId){
		return conContractInfoMapper.getTbConContractInfoById(contractId);
	}
	
	/**
	 * 分页查询首页合同信息
	 * 	pageNum：当前页
	 * 	pageSize：每页条数
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<ConApvList> queryConApvList(Map map){
		//引入配置的分页插件
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ConApvList> conApvList = conContractInfoMapper.queryConApvList(map);
        PageInfo pageInfo=new PageInfo(conApvList,(Integer)map.get("pageSize"));
    	return pageInfo;
	}
	
}
