package com.cdgit.loan.contract.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.ConApvList;
import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.mapper.TbConContractInfoMapper;
import com.cdgit.loan.contract.query.ConApvListQuery;
import com.cdgit.loan.contract.query.ConInfoHtXwQuery;
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
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ConApvList> conApvList = conContractInfoMapper.queryConApvList(map);
        PageInfo pageInfo=new PageInfo(conApvList,(Integer)map.get("pageSize"));
    	return pageInfo;
	}
	
	//测试自定义
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<ConApvList> queryConApvList1(ConApvListQuery conApvListQuery){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage(conApvListQuery.getPageNum(),conApvListQuery.getPageSize());
		Map<String,Object> map = new HashMap<>();
		//查询条件
		map.put("userId", conApvListQuery.getUserId());
		map.put("orgNum", conApvListQuery.getOrgNum());
		map.put("conStatus", conApvListQuery.getConStatus());
		map.put("partyName", conApvListQuery.getPartyName());
		map.put("contractNum", conApvListQuery.getContractNum());
		map.put("certType", conApvListQuery.getCertType());
		map.put("certNum", conApvListQuery.getCertNum());
		map.put("productType", conApvListQuery.getProductType());
		List<ConApvList> conApvList = conContractInfoMapper.queryConApvList1(map);
        PageInfo pageInfo=new PageInfo(conApvList,conApvListQuery.getPageSize());
    	return pageInfo;
	}
	
	/**
	 * 根据合同编号查询一条详细信息，不需要分页，如果存在原合同，那么会查询2条合同，我们应该
	 * 只返回一条数据，这里返回新的合同
	 * @param contractNum
	 * @return
	 */
	public ConInfoHtXwQuery getConInfoByContractNum(Map map){
		
//		return conContractInfoMapper.getConInfoByContractNum(map);
		ConInfoHtXwQuery conInfoByContractNum = conContractInfoMapper.getConInfoByContractNum(map);
		//如果这条信息里面有旧合同，那么需要展示这条信息的旧合同编号
		if(null !=conInfoByContractNum.getOldContractId()){
			String oldContractNum = conContractInfoMapper.getOldContractNum(conInfoByContractNum.getOldContractId());
			conInfoByContractNum.setOldContractNum(oldContractNum);
			return conInfoByContractNum;
		}
		return conInfoByContractNum;
	}
	
}
