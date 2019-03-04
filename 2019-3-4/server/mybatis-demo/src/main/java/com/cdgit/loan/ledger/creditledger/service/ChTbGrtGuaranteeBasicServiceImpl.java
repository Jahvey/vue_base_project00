package com.cdgit.loan.ledger.creditledger.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.ledger.creditledger.mapper.ChTbGrtGuaranteeBasicMapper;
import com.cdgit.loan.ledger.creditledger.resultbean.CompanyContractInfoResult;
import com.cdgit.loan.ledger.creditledger.resultbean.CooperaProjectQuotaResult;
import com.cdgit.loan.ledger.creditledger.resultbean.CorporateLendInfoResult;
import com.cdgit.loan.ledger.creditledger.resultbean.CustQuotaAccountResult;
import com.cdgit.loan.ledger.creditledger.resultbean.GroupCustomerReplyResult;
import com.cdgit.loan.ledger.creditledger.resultbean.GuarCompanyManageAccountResult;
import com.cdgit.loan.ledger.creditledger.resultbean.PersonalContractInfoResult;
import com.cdgit.loan.ledger.creditledger.resultbean.PersonalLendInfoResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ChTbGrtGuaranteeBasicServiceImpl {
	@Autowired
	ChTbGrtGuaranteeBasicMapper chTbGrtGuaranteeBasicMapper;
	//担保公司业务管理台账查询
	public PageInfo<GuarCompanyManageAccountResult> selectGuarCompanyManageAccount(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<GuarCompanyManageAccountResult> guarCompanyManageAccountResultList = chTbGrtGuaranteeBasicMapper.selectGuarCompanyManageAccount(map);
		PageInfo pageInfo = new PageInfo<>(guarCompanyManageAccountResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//客户额度台账
	public PageInfo<CustQuotaAccountResult> selectCustQuotaAccount(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CustQuotaAccountResult> custQuotaAccountResultList = chTbGrtGuaranteeBasicMapper.selectCustQuotaAccount(map);
		PageInfo pageInfo = new PageInfo<>(custQuotaAccountResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//集团客户批复查询
	public PageInfo<GroupCustomerReplyResult> selectGroupCustomerReply(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<GroupCustomerReplyResult> groupCustomerReplyResultList = chTbGrtGuaranteeBasicMapper.selectGroupCustomerReply(map);
		PageInfo pageInfo = new PageInfo<>(groupCustomerReplyResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//单一客户批复查询
	public PageInfo<GroupCustomerReplyResult> selectSingleCustomerReply(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<GroupCustomerReplyResult> groupCustomerReplyResultList = chTbGrtGuaranteeBasicMapper.selectSingleCustomerReply(map);
		PageInfo pageInfo = new PageInfo<>(groupCustomerReplyResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//公司合同信息查询
	public PageInfo<CompanyContractInfoResult> selectCompanyContractInfo(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CompanyContractInfoResult> companyContractInfoResultList = chTbGrtGuaranteeBasicMapper.selectCompanyContractInfo(map);
		PageInfo pageInfo = new PageInfo<>(companyContractInfoResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//个人合同信息查询
	public PageInfo<PersonalContractInfoResult> selectPersonalContractInfo(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<PersonalContractInfoResult> personalContractInfoResultList = chTbGrtGuaranteeBasicMapper.selectPersonalContractInfo(map);
		PageInfo pageInfo = new PageInfo<>(personalContractInfoResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//公司借据信息查询
	public PageInfo<CorporateLendInfoResult> selectCorporateLendInfo(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CorporateLendInfoResult> corporateLendInfoResultList = chTbGrtGuaranteeBasicMapper.selectCorporateLendInfo(map);
		PageInfo pageInfo = new PageInfo<>(corporateLendInfoResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	
	//个人借据信息查询
	public PageInfo<PersonalLendInfoResult> selectPersonalLendInfo(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<PersonalLendInfoResult> personalLendInfoResultList = chTbGrtGuaranteeBasicMapper.selectPersonalLendInfo(map);
		PageInfo pageInfo = new PageInfo<>(personalLendInfoResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//合作项目额度使用明细查询
	public PageInfo<CooperaProjectQuotaResult> selectCooperaProjectQuota(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CooperaProjectQuotaResult> cooperaProjectQuotaResultList = chTbGrtGuaranteeBasicMapper.selectCooperaProjectQuota(map);
		PageInfo pageInfo = new PageInfo<>(cooperaProjectQuotaResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
}
