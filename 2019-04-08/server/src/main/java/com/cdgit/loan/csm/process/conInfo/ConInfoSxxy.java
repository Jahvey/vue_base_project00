/**
 * 
 */
package com.cdgit.loan.csm.process.conInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.ApproveConsVo;
import com.cdgit.loan.csm.bean.CsmTbConContractInfo;
import com.cdgit.loan.csm.mapper.ConApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbConContractInfoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConCreditInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConFlagInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbCsmPartyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbSysExchangeRatePoMapper;
import com.cdgit.loan.csm.po.CsmTbConCreditInfoPo;
import com.cdgit.loan.csm.po.CsmTbConFlagInfoPo;
import com.cdgit.loan.csm.po.CsmTbCsmPartyPo;
import com.cdgit.loan.csm.po.CsmTbSysExchangeRatePo;
import com.cdgit.loan.csm.po.TbBizAmountApprovePo;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbBizApprovePo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.pub.DateUtil;
import com.cdgit.loan.csm.pub.gitUtils.CommonUtils;
import com.cdgit.loan.csm.pub.gitUtils.GitUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class ConInfoSxxy {
	
	@Autowired
	CsmTbConContractInfoMapper  csmTbConContractInfoMapper;
	
	@Autowired
	CsmTbConCreditInfoPoMapper  csmTbConCreditInfoPoMapper;
	
	@Autowired
	CsmTbBizApproveMapper       csmTbBizApproveMapper;
	
	@Autowired
	CsmTbBizAmountApproveMapper csmTbBizAmountApproveMapper;
	
	
	@Autowired
	CsmTbCsmPartyPoMapper csmTbCsmPartyMapper;
	
	@Autowired
	CsmTbBizAmountDetailApproveMapper csmTbBizAmountDetailApproveMapper;
	
	@Autowired
	CsmTbConFlagInfoPoMapper csmTbConFlagInfoPoMapper;
	
	@Autowired
	ConApplyMapper conApplyMapper;
	
	@Autowired
	SynchroData synchroData;
	
	@Autowired
	GitUtils gitUils;
	
	@Autowired
	CommonUtils commonUtils; 
	
	@Autowired
	CsmTbSysExchangeRatePoMapper csmTbSysExchangeRatePoMapper;
	
	@Autowired
	DateUtil dateUtil;
	

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashMap<String, Object> getConInfoByContarctId(String contractId){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		
		
		HashMap<String, Object> bizInfo = new HashMap<String, Object>();
		HashMap<String, Object> bizDtlInfo = new HashMap<String, Object>();
		
		//设置协议信息
		String proFlag1="1";
		CsmTbConCreditInfoPo tbConCreditInfo = csmTbConCreditInfoPoMapper.selectByPrimaryKey(contractId);
		if(null==tbConCreditInfo)System.err.println("[tbConCreditInfo is null!!!]");
		//查询协议信息
		
		//tbConCreditInfo/partyId 是不是等于空或者empty
		if(null!=tbConCreditInfo&&tbConCreditInfo.getApplyId()!=null)
		{//否
			//如果营业事件为空，则设置一个营业时间
			if(tbConCreditInfo.getContractDate()==null){			
				Date handlingDate = gitUils.getBusiDate();
				tbConCreditInfo.setContractDate(handlingDate);

			}

			//设置协议信息
			String contractType="01";
			resultMap.put("conInfo", tbConCreditInfo);
	
			//查询批复信息
			TbBizApprovePo tbBizApprove = csmTbBizApproveMapper.queryByApplyId(tbConCreditInfo.getApplyId());

			//设置批复基本信息
			
			//查询批复基本信息
			TbBizAmountApprovePo tbBizAmountApprove = csmTbBizAmountApproveMapper.queryByApproveId(tbBizApprove.getApproveId());

			//赋值
			bizInfo.put("applyId", tbBizApprove.getApplyId());
			bizInfo.put("bizType", tbBizApprove.getBizType());
			bizInfo.put("isBankTeam", tbBizApprove.getIsBankTeamLoan());
			bizInfo.put("validDate", tbBizApprove.getValidDate());
			bizInfo.put("guarantyType", tbBizAmountApprove.getGuarantyType());
			//bizDtlInfo.put("loanUse", tbbizam); //TODO 这里要特别注明，下面根本没有使用到bizDtlInfo的数据，不管

			
			//查询客户party
			CsmTbCsmPartyPo party = csmTbCsmPartyMapper.selectByPrimaryKey(tbConCreditInfo.getPartyId());
			
			//设置结束信息
			resultMap.put("tbBizApprove", tbBizApprove);
			resultMap.put("tbBizAmountApprove", tbBizAmountApprove);
			resultMap.put("party", party);
			//resultMap.put("tbConFlagInfo", tbConFlagInfo);
			resultMap.put("contractType", contractType);
			resultMap.put("proFlag1", proFlag1);
			resultMap.put("bizInfo", bizInfo);

		}else{
			//是
			//查询业务合同信息
			TbConContractInfoPo tbConContractInfo = csmTbConContractInfoMapper.selectByPrimaryKey(contractId);
			
			if(null==tbConContractInfo.getContractDate()){
				Date handlingDate = gitUils.getBusiDate();
				tbConContractInfo.setContractDate(handlingDate);
				
				if(null==tbConContractInfo.getInternalDays()){
					String jgdays=commonUtils.getDBConfigVal("sys", "sys_internalDays");
					tbConContractInfo.setInternalDays(Integer.parseInt(jgdays));
				}
				
			}
			
			//设置合同信息的信息
			String contractType="02";
			//resultMap.put("conInfo", tbConContractInfo);
			
			if(null==tbConContractInfo.getSpecPaymentDate()){
				tbConContractInfo.setSpecPaymentDate(new Short("21"));
			}
			
			//查询批复明细信息
			TbBizAmountDetailApprovePo tbBizAmountDetailApprove = csmTbBizAmountDetailApproveMapper.//
			queryOneTbBizAmountDetailApproveByAmountDetailId(tbConContractInfo.getAmountDetailId());
			
			//查询批复基本信息
			TbBizAmountApprovePo tbBizAmountApprove = csmTbBizAmountApproveMapper.//
			queryOneTbBizAmountApproveByAmountId(tbBizAmountDetailApprove.getAmountId());
			
			TbBizApprovePo tbBizApprove = csmTbBizApproveMapper.//
					queryOneTbBizApproveByApproveId(tbBizAmountApprove.getApproveId());
			
			if("06".equals(tbBizApprove.getBizHappenType())){
				//设置原合同编号
				String OldContractNum = conApplyMapper.getJxhjContractNum(tbBizApprove.getApplyId());
				tbConContractInfo.setOldContractId(OldContractNum);
				
				
			}
			
			//赋值
			bizInfo.put("approveId", tbBizApprove.getApproveId());
			bizInfo.put("applyId", tbBizApprove.getApplyId());
			bizInfo.put("bizType", tbBizApprove.getBizType());
			bizInfo.put("isBankTeam", tbBizApprove.getIsBankTeamLoan());
			bizInfo.put("validDate", tbBizApprove.getValidDate());
			bizInfo.put("guarantyType", tbBizApprove.getGuarantyType());
			bizDtlInfo.put("creditTerm", tbBizAmountDetailApprove.getCreditTerm());
			bizDtlInfo.put("cycleUnit", tbBizAmountDetailApprove.getCycleUnit());
			bizDtlInfo.put("loanUse", tbBizAmountDetailApprove.getLoanUse());
			bizDtlInfo.put("rmbAmt", tbBizAmountDetailApprove.getRmbAmt());
			bizDtlInfo.put("exchangeRate", tbBizAmountDetailApprove.getExchangeRate());
			//bizDtlInfo.put("maxAmt", );//TODO 由于后面的业务逻辑都没有使用到，所以不写
			bizDtlInfo.put("repaymentType", tbBizAmountDetailApprove.getRepaymentType());
			bizDtlInfo.put("creditMode", tbBizAmountDetailApprove.getCreditMode());
			
			
			//设置客户信息
			bizInfo.put("partyId", tbConContractInfo.getPartyId());
			
			if(null==tbConContractInfo.getOldContractId()||"".equals(tbConContractInfo.getOldContractId())){
				proFlag1="0";
			}
			
			//同步标志数据
			try {
				synchroData.synchroRiskInfo(tbBizApprove.getApplyId(), contractId);
			} catch (Exception e) {
				throw new RuntimeException("同步标志数据失败:["+e+"]");
			}
			
			CsmTbConFlagInfoPo tbConFlagInfo = csmTbConFlagInfoPoMapper.queryOneByConId(contractId);
			
			CsmTbCsmPartyPo party = csmTbCsmPartyMapper.selectByPrimaryKey(tbConContractInfo.getPartyId());
			
			resultMap.put("conInfo", tbConContractInfo);
			resultMap.put("tbBizApprove", tbBizApprove);
			resultMap.put("tbBizAmountApprove", tbBizAmountApprove);
			resultMap.put("party", party);
			resultMap.put("tbBizAmountDetailApprove", tbBizAmountDetailApprove);
			resultMap.put("tbConFlagInfo", tbConFlagInfo);
			resultMap.put("contractType", contractType);
			resultMap.put("proFlag1", proFlag1);
			resultMap.put("bizInfo", bizInfo);
			resultMap.put("bizDtlInfo", bizDtlInfo);
		
		}
		
		
		

		return resultMap;
		
	}
	
	/**
	 * 
	 * @param bz 币种
	 * @return
	 */
	//牌价查询---获取当前币种的汇率信息 2019/02/26
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashMap<String, Object> getChangeRate(String bz){
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		
		String validityInd="";//生效标志
		BigDecimal disRateOfRmb=new BigDecimal("0");//折算人民币
		String msg="";
		//得到了汇率信息
		CsmTbSysExchangeRatePo tbSysExchangeRate = csmTbSysExchangeRatePoMapper.selectByPrimaryKey(bz);
		//拿到汇率折算日期
		Date disCountDate = tbSysExchangeRate.getDiscountDate();
		
		Date workDate = gitUils.getBusiDate();
		String workDateStr = dateUtil.format(workDate, "yyyyMMdd");
		String disCountDateStr = dateUtil.format(disCountDate, "yyyyMMdd");
		
		if(!workDateStr.equals(disCountDateStr)){
			msg="未获取到最新的汇率信息";
		}
		
		disRateOfRmb=tbSysExchangeRate.getDiscountRateOfRmb();
		validityInd=tbSysExchangeRate.getValidityInd();
		
		hashMap.put("validityInd", validityInd);
		hashMap.put("disRateOfRmb", disRateOfRmb);
		hashMap.put("msg", msg);
		
		return hashMap;
	}
	
	
	public PageInfo<TbBizAmountDetailApprovePo> queryConDetailsXy(Map map){
		String contractId=(String) map.get("contractId");
		HashMap<String,Object> resMap = getConInfoByContarctId(contractId);
		System.out.println("[queryConDetailsXy]contractId="+contractId+",res="+resMap);
		TbBizAmountApprovePo tbBizAmountApprovePo=(TbBizAmountApprovePo) resMap.get("tbBizAmountApprove");
		String amountId = tbBizAmountApprovePo.getAmountId();
		List<TbBizAmountDetailApprovePo> BizAmountDetailApprovePoQuery = csmTbBizAmountDetailApproveMapper.queryListByAmountId(amountId);
		
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));

		PageInfo pageInfo=new PageInfo(BizAmountDetailApprovePoQuery,(Integer)map.get("pageSize"));
		
		
		return pageInfo;
		
	}
	

}
