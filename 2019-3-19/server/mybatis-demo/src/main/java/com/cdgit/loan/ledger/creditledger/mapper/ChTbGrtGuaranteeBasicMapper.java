package com.cdgit.loan.ledger.creditledger.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.ledger.creditledger.resultbean.CompanyContractInfoResult;
import com.cdgit.loan.ledger.creditledger.resultbean.CooperaProjectQuotaResult;
import com.cdgit.loan.ledger.creditledger.resultbean.CorporateLendInfoResult;
import com.cdgit.loan.ledger.creditledger.resultbean.CustQuotaAccountResult;
import com.cdgit.loan.ledger.creditledger.resultbean.GroupCustomerReplyResult;
import com.cdgit.loan.ledger.creditledger.resultbean.GuarCompanyManageAccountResult;
import com.cdgit.loan.ledger.creditledger.resultbean.PersonalContractInfoResult;
import com.cdgit.loan.ledger.creditledger.resultbean.PersonalLendInfoResult;
@Mapper
public interface ChTbGrtGuaranteeBasicMapper {
   
	//担保公司业务管理台账查询
    List<GuarCompanyManageAccountResult> selectGuarCompanyManageAccount(Map map);
    //客户额度台账查询
    List<CustQuotaAccountResult> selectCustQuotaAccount(Map map);
    //集团客户批复查询
    List<GroupCustomerReplyResult> selectGroupCustomerReply(Map map);	
    //单一客户批复查询
    List<GroupCustomerReplyResult> selectSingleCustomerReply(Map map);
    //公司合同信息查询
    List<CompanyContractInfoResult> selectCompanyContractInfo(Map map);
    //个人合同信息查询
    List<PersonalContractInfoResult> selectPersonalContractInfo(Map map);
    //公司借据信息查询
    List<CorporateLendInfoResult> selectCorporateLendInfo(Map map);
    //个人借据信息查询
    List<PersonalLendInfoResult> selectPersonalLendInfo(Map map);
    //合作项目额度使用明细
    List<CooperaProjectQuotaResult> selectCooperaProjectQuota(Map map);
    
    
}