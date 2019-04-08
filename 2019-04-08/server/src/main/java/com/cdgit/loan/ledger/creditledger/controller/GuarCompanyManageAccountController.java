package com.cdgit.loan.ledger.creditledger.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.ledger.creditledger.resultbean.CompanyContractInfoResult;
import com.cdgit.loan.ledger.creditledger.resultbean.CooperaProjectQuotaResult;
import com.cdgit.loan.ledger.creditledger.resultbean.CorporateLendInfoResult;
import com.cdgit.loan.ledger.creditledger.resultbean.CustQuotaAccountResult;
import com.cdgit.loan.ledger.creditledger.resultbean.GroupCustomerReplyResult;
import com.cdgit.loan.ledger.creditledger.resultbean.GuarCompanyManageAccountResult;
import com.cdgit.loan.ledger.creditledger.resultbean.PersonalContractInfoResult;
import com.cdgit.loan.ledger.creditledger.resultbean.PersonalLendInfoResult;
import com.cdgit.loan.ledger.creditledger.service.ChTbGrtGuaranteeBasicServiceImpl;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.github.pagehelper.PageInfo;

@CrossOrigin
@RestController
@RequestMapping("/guarAccount")
public class GuarCompanyManageAccountController {
	@Autowired
	ChTbGrtGuaranteeBasicServiceImpl chTbGrtGuaranteeBasicServiceImpl;
	
	//担保公司业务管理台账查询
	@GetMapping("/queryGuarAccount")
	public PageBean queryGuarCompanyManageAccount(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="partyName",required=false) String partyName, 
			@RequestParam(value="orgNum",required=false) String orgNum){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("partyName", partyName);	
		map.put("orgNum", orgNum);
		PageInfo<GuarCompanyManageAccountResult> GuarList=chTbGrtGuaranteeBasicServiceImpl.selectGuarCompanyManageAccount(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(GuarList.getTotal());
		pageBean.setData(GuarList.getList());
		return pageBean;
	}
	
		//客户额度台账查询
		@GetMapping("/queryCustQuotaAccount")
		public PageBean queryCustQuotaAccount(
				@RequestParam(value="pageNum",required=true) int pageNum,
				@RequestParam(value="pageSize",required=true) int pageSize,
				@RequestParam(value="partyName",required=false) String partyName, 
				@RequestParam(value="orgNum",required=false) String orgNum,
				@RequestParam(value="certType",required=false) String certType,
				@RequestParam(value="certNum",required=false) String certNum,
				@RequestParam(value="userNum",required=false) String userNum){
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("partyName", partyName);	
			map.put("orgNum", orgNum);
			map.put("certType", certType);
			map.put("certNum", certNum);
			map.put("userNum", userNum);
			PageInfo<CustQuotaAccountResult> CustQuotaAccountList=chTbGrtGuaranteeBasicServiceImpl.selectCustQuotaAccount(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(CustQuotaAccountList.getTotal());
			pageBean.setData(CustQuotaAccountList.getList());
			return pageBean;
		}
	
		//集团客户额度批复查询
		@GetMapping("/queryGroupCustomerReply")
		public PageBean queryGroupCustomerReply(
				@RequestParam(value="pageNum",required=true) int pageNum,
				@RequestParam(value="pageSize",required=true) int pageSize,
				@RequestParam(value="partyName",required=false) String partyName, 
				@RequestParam(value="orgNum",required=false) String orgNum,
				@RequestParam(value="certType",required=false) String certType,
				@RequestParam(value="certNum",required=false) String certNum,
				@RequestParam(value="approvalNum",required=false) String approvalNum){
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("partyName", partyName);	
			map.put("orgNum", orgNum);
			map.put("certType", certType);
			map.put("certNum", certNum);
			map.put("approvalNum", approvalNum);
			PageInfo<GroupCustomerReplyResult> groupCustomerReplyResultList=chTbGrtGuaranteeBasicServiceImpl.selectGroupCustomerReply(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(groupCustomerReplyResultList.getTotal());
			pageBean.setData(groupCustomerReplyResultList.getList());
			return pageBean;
		}
		
		//集团客户额度批复查询
		@GetMapping("/querySingleCustomerReply")
		public PageBean querySingleCustomerReply(
				@RequestParam(value="pageNum",required=true) int pageNum,
				@RequestParam(value="pageSize",required=true) int pageSize,
				@RequestParam(value="partyName",required=false) String partyName, 
				@RequestParam(value="orgNum",required=false) String orgNum,
				@RequestParam(value="certType",required=false) String certType,
				@RequestParam(value="certNum",required=false) String certNum,
				@RequestParam(value="approvalNum",required=false) String approvalNum){
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("partyName", partyName);	
			map.put("orgNum", orgNum);
			map.put("certType", certType);
			map.put("certNum", certNum);
			map.put("approvalNum", approvalNum);
			PageInfo<GroupCustomerReplyResult> groupCustomerReplyResultList=chTbGrtGuaranteeBasicServiceImpl.selectSingleCustomerReply(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(groupCustomerReplyResultList.getTotal());
			pageBean.setData(groupCustomerReplyResultList.getList());
			return pageBean;
		}
		//公司合同信息查询
		@GetMapping("/queryCompanyContractInfo")
		public PageBean queryCompanyContractInfo(
				@RequestParam(value="pageNum",required=true) int pageNum,
				@RequestParam(value="pageSize",required=true) int pageSize,
				@RequestParam(value="partyName",required=false) String partyName,
				@RequestParam(value="corpCustomerTypeCd",required=false) String corpCustomerTypeCd,
				@RequestParam(value="xyContractNum",required=false) String xyContractNum,
				@RequestParam(value="contractNum",required=false) String contractNum,
				@RequestParam(value="mainGuarantyType",required=false) String mainGuarantyType,
				@RequestParam(value="conStatus",required=false) String conStatus,
				@RequestParam(value="userNum",required=false) String userNum,
				@RequestParam(value="productType",required=false) String productType,
				@RequestParam(value="beginDate",required=false) String beginDate,
				@RequestParam(value="endDate",required=false) String endDate,
				@RequestParam(value="orgNum",required=false) String orgNum){
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("partyName", partyName);	
			map.put("orgNum", orgNum);
			map.put("corpCustomerTypeCd", corpCustomerTypeCd);
			map.put("xyContractNum", xyContractNum);
			map.put("contractNum", contractNum);
			map.put("mainGuarantyType", mainGuarantyType);	
			map.put("conStatus", conStatus);
			map.put("productType", productType);
			map.put("beginDate", beginDate);
			map.put("endDate", endDate);
			map.put("userNum", userNum);
			PageInfo<CompanyContractInfoResult> companyContractInfoResultList=chTbGrtGuaranteeBasicServiceImpl.selectCompanyContractInfo(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(companyContractInfoResultList.getTotal());
			pageBean.setData(companyContractInfoResultList.getList());
			return pageBean;
		}
		
		//公司合同信息查询
		@GetMapping("/queryPersonalContractInfo")
		public PageBean queryPersonalContractInfo(
				@RequestParam(value="pageNum",required=true) int pageNum,
				@RequestParam(value="pageSize",required=true) int pageSize,
				@RequestParam(value="partyName",required=false) String partyName,
				@RequestParam(value="certType",required=false) String certType,
				@RequestParam(value="certNum",required=false) String certNum,
				@RequestParam(value="contractNum",required=false) String contractNum,
				@RequestParam(value="mainGuarantyType",required=false) String mainGuarantyType,
				@RequestParam(value="conStatus",required=false) String conStatus,
				@RequestParam(value="userNum",required=false) String userNum,
				@RequestParam(value="productType",required=false) String productType,
				@RequestParam(value="beginDate",required=false) String beginDate,
				@RequestParam(value="endDate",required=false) String endDate,
				@RequestParam(value="orgNum",required=false) String orgNum){
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("partyName", partyName);	
			map.put("orgNum", orgNum);
			map.put("certType", certType);
			map.put("certNum", certNum);
			map.put("contractNum", contractNum);
			map.put("mainGuarantyType", mainGuarantyType);	
			map.put("conStatus", conStatus);
			map.put("productType", productType);
			map.put("beginDate", beginDate);
			map.put("endDate", endDate);
			map.put("userNum", userNum);
			PageInfo<PersonalContractInfoResult> personalContractInfoResultList=chTbGrtGuaranteeBasicServiceImpl.selectPersonalContractInfo(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(personalContractInfoResultList.getTotal());
			pageBean.setData(personalContractInfoResultList.getList());
			return pageBean;
		}
		
		//公司借据信息查询
		@GetMapping("/queryCorporateLendInfo")
		public PageBean queryCorporateLendInfo(
				@RequestParam(value="pageNum",required=true) int pageNum,
				@RequestParam(value="pageSize",required=true) int pageSize,
				@RequestParam(value="orgNum",required=false) String orgNum,
				@RequestParam(value="partyName",required=false) String partyName,
				@RequestParam(value="loanSubject1",required=false) String loanSubject1,
				@RequestParam(value="contractNum",required=false) String contractNum,
				@RequestParam(value="summaryNum",required=false) String summaryNum,
				@RequestParam(value="summaryStatusCd",required=false) String summaryStatusCd,
				@RequestParam(value="summaryAmt",required=false) String summaryAmt,
				@RequestParam(value="jjye",required=false) String jjye,
				@RequestParam(value="beginDate",required=false) String beginDate,
				@RequestParam(value="endDate",required=false) String endDate,
				@RequestParam(value="userNum",required=false) String userNum
				){
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("partyName", partyName);	
			map.put("orgNum", orgNum);
			map.put("loanSubject1", loanSubject1);
			map.put("contractNum", contractNum);
			map.put("summaryNum", summaryNum);
			map.put("summaryStatusCd", summaryStatusCd);
			map.put("summaryAmt", summaryAmt);
			map.put("jjye", jjye);
			map.put("beginDate", beginDate);
			map.put("endDate", endDate);
			map.put("userNum", userNum);
			PageInfo<CorporateLendInfoResult> corporateLendInfoResultList=chTbGrtGuaranteeBasicServiceImpl.selectCorporateLendInfo(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(corporateLendInfoResultList.getTotal());
			pageBean.setData(corporateLendInfoResultList.getList());
			return pageBean;
		}
		
		//个人借据信息查询
		@GetMapping("/queryPersonalLendInfo")
		public PageBean queryPersonalLendInfo(
				@RequestParam(value="pageNum",required=true) int pageNum,
				@RequestParam(value="pageSize",required=true) int pageSize,
				@RequestParam(value="orgNum",required=false) String orgNum,
				@RequestParam(value="partyName",required=false) String partyName,
				@RequestParam(value="certType",required=false) String certType,
				@RequestParam(value="certNum",required=false) String certNum,
				@RequestParam(value="loanSubject1",required=false) String loanSubject1,
				@RequestParam(value="contractNum",required=false) String contractNum,
				@RequestParam(value="summaryNum",required=false) String summaryNum,
				@RequestParam(value="summaryStatusCd",required=false) String summaryStatusCd,
				@RequestParam(value="summaryAmt",required=false) String summaryAmt,
				@RequestParam(value="jjye",required=false) String jjye,
				@RequestParam(value="beginDate",required=false) String beginDate,
				@RequestParam(value="endDate",required=false) String endDate
				
				){
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("partyName", partyName);	
			map.put("orgNum", orgNum);
			map.put("loanSubject1", loanSubject1);
			map.put("contractNum", contractNum);
			map.put("summaryNum", summaryNum);
			map.put("summaryStatusCd", summaryStatusCd);
			map.put("summaryAmt", summaryAmt);
			map.put("jjye", jjye);
			map.put("beginDate", beginDate);
			map.put("endDate", endDate);
			map.put("certType", certType);
			map.put("certNum", certNum);
			PageInfo<PersonalLendInfoResult> personalLendInfoResultList=chTbGrtGuaranteeBasicServiceImpl.selectPersonalLendInfo(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(personalLendInfoResultList.getTotal());
			pageBean.setData(personalLendInfoResultList.getList());
			return pageBean;
		}
		
		//合作项目额度使用明细查询
		@GetMapping("/queryCooperaProjectQuota")
		public PageBean queryCooperaProjectQuota(
				@RequestParam(value="pageNum",required=true) int pageNum,
				@RequestParam(value="pageSize",required=true) int pageSize,
				@RequestParam(value="orgNum",required=false) String orgNum,
				@RequestParam(value="partyName",required=false) String partyName,
				@RequestParam(value="productType",required=false) String productType,
				@RequestParam(value="summaryStatusCd",required=false) String summaryStatusCd,
				@RequestParam(value="hzName",required=false) String hzName
				){
			Map map=new HashMap<String,Object>();
			map.put("pageNum", pageNum);
			map.put("pageSize", pageSize);
			map.put("partyName", partyName);	
			map.put("orgNum", orgNum);
			map.put("summaryStatusCd", summaryStatusCd);
			map.put("productType", productType);
			map.put("hzName", hzName);
			PageInfo<CooperaProjectQuotaResult> cooperaProjectQuotaResultList=chTbGrtGuaranteeBasicServiceImpl.selectCooperaProjectQuota(map);
			PageBean pageBean=new PageBean();
			pageBean.setTotal(cooperaProjectQuotaResultList.getTotal());
			pageBean.setData(cooperaProjectQuotaResultList.getList());
			return pageBean;
		}
		
		
		
}
