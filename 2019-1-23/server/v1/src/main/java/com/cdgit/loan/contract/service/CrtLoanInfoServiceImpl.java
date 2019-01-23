package com.cdgit.loan.contract.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.contract.bean.CrtTbBizPjxxApply;
import com.cdgit.loan.contract.bean.CrtTbBizTxxxApply;
import com.cdgit.loan.contract.bean.CrtTbConGjxyzkz;
import com.cdgit.loan.contract.bean.CrtTbConJkbh;
import com.cdgit.loan.contract.bean.CrtTbLoanHpAmt;
import com.cdgit.loan.contract.bean.CrtTbLoanInfo;
import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.mapper.CrtOrgRelMapper;
import com.cdgit.loan.contract.mapper.CrtTbBizPjxxApplyMapper;
import com.cdgit.loan.contract.mapper.CrtTbBizTxxxApplyMapper;
import com.cdgit.loan.contract.mapper.CrtTbLoanHpAmtMapper;
import com.cdgit.loan.contract.mapper.CrtTbLoanInfoMapper;
import com.cdgit.loan.contract.mapper.CrtTbLoanSummaryMapper;
import com.cdgit.loan.contract.mapper.TbConContractInfoMapper;

@Service
@org.springframework.transaction.annotation.Transactional
public class CrtLoanInfoServiceImpl {

	@Autowired	CrtTbLoanInfoMapper	loanInfoMapper;		//放款
	
	@Autowired	CrtTbLoanSummaryMapper loanSummaryMapper;	//借据信息
	
	@Autowired	TbConContractInfoMapper contractInfoMapper;	//合同
	
	@Autowired	CrtGitUtilServiceImpl crtGitUtilService;	//公共的一些方法
	
	@Autowired	CrtTbConJkbhServiceImpl conJkbhService;	//国际保函(22-进口保函批复)
	
	@Autowired	CrtTbConGjxyzkzServiceImpl conGjxyzkzService;	//国际信用证开证
	
	@Autowired	CrtTbLoanHpAmtMapper crtTbLoanHpAmtMapper;	//汇票出账金额表
	
	@Autowired	CrtTbBizTxxxApplyMapper bizTxxxApplyMapper;		//贴现明细
	
	@Autowired	CrtTbBizPjxxApplyMapper bizPjxxApplyMapper;		//票据信息申请表
	
	@Autowired	CrtOrgRelMapper crtOrgRelMapper;		//查询经办机构
	
	
	//根据放款id（主键）查询一条放款信息
	public CrtTbLoanInfo selectByPrimaryKey(String loanId){
		return loanInfoMapper.selectLoanInfoByloanId(loanId);
	}
	
	/**
	 * 创建放款信息	
	 * 	orgNum先写死，写死成0700
	 * 	userNum	写死	200555
	 * @param contractId
	 * @param flag
	 * @param orgNum
	 */
	public String createLoanInfo(String contractId,String flag,String orgNum,String userNum){
		TbConContractInfo contractInfo = contractInfoMapper.queryOneConContractInfoByContractId(contractId);
		String partyId = contractInfo.getPartyId();
		String productType = contractInfo.getProductType();
		String amountDetailId = contractInfo.getAmountDetailId();
		String seqNo;
		CrtTbLoanInfo loanInfo = new CrtTbLoanInfo();
		//获取 放款/借据 编号
		if("01008001".equals(productType) || "01008010".equals(productType) ||	"01008002".equals(productType) ||	//放款信息
			"01006001".equals(productType) || "01006010".equals(productType) ||"01006002".equals(productType)){
			seqNo = crtGitUtilService.getSeqNo("FK", orgNum);
		}else{	//借据信息
			seqNo = crtGitUtilService.getSeqNo("JJ", orgNum);
		}
		
		String busiDate = crtGitUtilService.getBusiDate(); 	//获取营业时间
		
		if("01007014".equals(productType)){		//国际保函
			CrtTbConJkbh crtTbConJkbh = conJkbhService.getOneCrtTbConJkbhByContractInfo(contractId, amountDetailId);
			loanInfo.setEndDate(crtTbConJkbh.getDqrq());
		}
		if("01007013".equals(productType)){	//信用证开证
			CrtTbConGjxyzkz crtTbConGjxyzkz = conGjxyzkzService.getOneCrtTbConGjxyzkzByContractInfo(contractId, amountDetailId);
			loanInfo.setEndDate(crtTbConGjxyzkz.getDqrq());
		}
		
		String loanId = UUIDGenerator.getUUID();	//使用uuid生成一个放款主键 
		loanInfo.setLoanId(loanId);
		loanInfo.setContractId(contractId);
		loanInfo.setPartyId(partyId);
		loanInfo.setUserNum(userNum);
		loanInfo.setOrgNum(orgNum);
		loanInfo.setLoanStatus("01");
		loanInfo.setLoanNum(seqNo);
		loanInfo.setSummaryNum(seqNo);
		try {
			loanInfo.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").parse(busiDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		loanInfo.setProductType(productType);
//		loanInfo.setRcnStan("生成的流水号，怎么来的？？");
		if(flag.equals("1231")){
			loanInfo.setCounterFlg("1231");
		}
		
		loanInfoMapper.insertLoanInfoSelective(loanInfo);
		return loanId;
	}
	
	//修改放款信息(插入票据信息)
	public void updateCrtTbLoanInfo(String productType){
		
	} 
	
	
	//如果产品类型包含以下内容，则插入票据信息，还是在controller里面判断分发吧，现在先不写整个执行流程
//	if("01008001".equals(productType) || "01008010".equals(productType) ||
//	   "01008002".equals(productType) || "01006001".equals(productType) ||
//	   "01006010".equals(productType) || "01006002".equals(productType)){
//		
//		insertXXXX(amountDetailId, productType, loanInfo);		
//	}
	//插入票据信息
	public void insertXXXX(String amountDetailId, String productType, CrtTbLoanInfo loanInfo){
		
		//银承(银行承兑汇票/银承通/富民银行承兑汇票)
		if ("01008001".equals(productType) || "01008002".equals(productType) || "01008010".equals(productType)) {
			insertPJXX(amountDetailId, loanInfo);
		}
		// 贴现(银行承兑汇票贴现/商业承兑汇票贴现/富民银承贴现)
		if ("01006001".equals(productType) || "01006002".equals(productType) || "01006010".equals(productType)) {
			insertTXXX(amountDetailId, loanInfo);
		}
	}
	
	/**
	 * 银承出账时插入银承票据信息:
	 * 	1.当前机构号以前是从session里面去获取的，现在这里先写死，orgCode=0700
	 * 	2.有一条票据明细就有一条对应的汇票出账金额信息
	 * @param amountDetailId
	 * @param loanInfo
	 * @throws Exception 
	 */
	private void insertPJXX(String amountDetailId, CrtTbLoanInfo loanInfo){
		String contractId = loanInfo.getContractId();
		TbConContractInfo contractInfo = contractInfoMapper.queryOneConContractInfoByContractId(contractId);
		// 查询票据明细 明细ID+合同编号
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("amountDetailId", amountDetailId);
		map.put("contractNum", contractInfo.getContractNum());
		List<CrtTbBizPjxxApply> pjxx = bizPjxxApplyMapper.queryPJXX(map);	//票据明细
		
		if (pjxx == null || pjxx.size()<1 ) {
			throw new RuntimeException("票据明细清单为空");
		} else {
			map.put("contractId", contractInfo.getContractId());
			List<CrtTbBizPjxxApply> pjxx1 = bizPjxxApplyMapper.queryPJXX(map);	//票据明细
			if(null !=pjxx1 && pjxx1.size()>0){
				pjxx=pjxx1;
			}
		}
		CrtTbBizPjxxApply tempPj = pjxx.get(0);	//获得第一条票据信息
		String pjzl = tempPj.getHpxs();	// 票据种类
		HashMap<String, String> mapOth = new HashMap<String, String>();
		mapOth.put("orgCode", "0700");	//获取当前机构号，经办机构编号	写死
		if ("01".equals(pjzl)) {
			mapOth.put("type", "2"); // 银承纸票
		} else if ("02".equals(pjzl)) {
			mapOth.put("type", "3"); // 银承电票
		} else {
			throw new RuntimeException("票据类型错误");
		}
		
		List<HashMap<String, String>> other = crtOrgRelMapper.selectOrgRel(mapOth);	//查询经办机构相关信息
		if(other.size() <1 ){
			throw new RuntimeException("未配置入账机构，请联系管理员");
		}
		
		HashMap<String, String> dataOth = other.get(0);
		// 纸票更新承兑行,出票行(更新票据申请表信息)
		if ("01".equals(pjzl)) {//pjzl:票据种类
			for (int i = 0; i < pjxx.size(); i++) {
				CrtTbBizPjxxApply bizPjxxApply = pjxx.get(i);
				bizPjxxApply.setAmountDetailId(amountDetailId);
				bizPjxxApply.setHtbh(contractInfo.getContractNum());
				bizPjxxApply.setAcceptorbankno(dataOth.get("BANKNO"));//承兑行行号
				bizPjxxApply.setAcceptorbankname(dataOth.get("KEHYWM"));//承兑行行名
				bizPjxxApply.setRemitterbankno(dataOth.get("BANKNO"));//出票行行号
				bizPjxxApply.setRemitterbankname(dataOth.get("KEHYWM"));//出票行行名
			}
			bizPjxxApplyMapper.updateAcceptorbank(pjxx);	//根据业务明细id和合同编号批量更新票据信息
		}
		
		//插入发放明细
		for (int i = 0; i < pjxx.size(); i++) {
			CrtTbBizPjxxApply data = pjxx.get(i);
			CrtTbLoanHpAmt crtTbLoanHpAmt = new CrtTbLoanHpAmt();	//汇票出账金额表
			String summaryNum = crtGitUtilService.getSeqNo("JJ", "0700");	//借据号	orgNum:写死了的，需要从前端传过来，这个以后修改
			
			String uuid = UUIDGenerator.getUUID();
			crtTbLoanHpAmt.setMoneyUseId(uuid); // 主键，自己用uuid生成之后插入
			crtTbLoanHpAmt.setApplyDetailId(data.getApplyDetailId());// 票据明细ID
			crtTbLoanHpAmt.setLoanId(loanInfo.getLoanId());	//出账id
			crtTbLoanHpAmt.setLoanAmt(data.getHpje());	// 出账金额(汇票金额)
			crtTbLoanHpAmt.setPyeAcctNm(data.getSkrqc());// 收款人户名
			crtTbLoanHpAmt.setPyeAcctNo(data.getSkrzh());// 收款人账号
			crtTbLoanHpAmt.setPyeOpenAcctBnkNm(data.getPayeebankname());// 收款人开户行行名
			crtTbLoanHpAmt.setDrftExpDt(data.getHpdqrq());// 汇票到期日期
			crtTbLoanHpAmt.setIssuDt(data.getHpcprq());// 出票日期
			crtTbLoanHpAmt.setBillNo(data.getPjhm());// 票据号
			crtTbLoanHpAmt.setBillState("0");// 票据状态(0-正常；1-删除)
			crtTbLoanHpAmt.setSummaryNum(summaryNum);// 借据号 
			crtTbLoanHpAmt.setSortOrder(data.getSortOrder());// 排序序号
			if (other.size() > 0) { // 目前版本中只应该有一个配置的入账机构
				crtTbLoanHpAmt.setDrweBnkNm(dataOth.get("KEHYWM"));// 付款行全称
				crtTbLoanHpAmt.setDrweBnkNo(dataOth.get("BANKNO"));// 付款行行号
				crtTbLoanHpAmt.setDrweBnkAdr(dataOth.get("ORGADDR"));// 付款行地址
			}
			crtTbLoanHpAmtMapper.insertCrtTbLoanHpAmtSelective(crtTbLoanHpAmt);// 先这样写，插入一条汇票出账金额信息
		}
		
		// 更新发放(出账)信息
		loanInfo.setEndDate(contractInfo.getEndDate());// 到期日期
		loanInfo.setLoanAmt(contractInfo.getRmbAmt());// 出账金额
		loanInfo.setRmbAmt(contractInfo.getRmbAmt());// 合同金额*汇率 目前默认人民币汇率1
		loanInfo.setPjzl(pjzl);// 票据种类
		loanInfo.setHpzs(pjxx.size());// 汇票张数
		loanInfo.setLoanOrg(dataOth.get("ACC_ORG_NO"));// 入账机构
		loanInfo.setComAmt(null);
		loanInfo.setDrweBnkNm(dataOth.get("KEHYWM"));
		loanInfo.setDrweBnkNo(dataOth.get("BANKNO"));
		loanInfo.setDrweBnkAdr(dataOth.get("ORGADDR"));
		
		loanInfoMapper.updateLoanInfoBySelect(loanInfo);
	}
	
	
	/**
	 * 贴现出账时插入贴现票据信息：
	 * 	1.有一条贴现明细就有一条对应的汇票出账金额信息
	 * 	2.并没有做时间和日期的验证，可能会出现开始时间大于结束时间的情况，这个给后台还是前端验证？？？
	 * 	3.机构号，需要先写死，写成0700
	 * @param amountDetailId
	 * @param loanInfo
	 * @param orgNum	
	 */
	private void insertTXXX(String amountDetailId, CrtTbLoanInfo loanInfo){
		List<CrtTbBizTxxxApply> txxx = bizTxxxApplyMapper.queryTXXX(amountDetailId);	//贴现明细
		String pjzl = ""; // 票据种类
		
		for (int i = 0; i < txxx.size(); i++) {	
			CrtTbBizTxxxApply data = txxx.get(i);
			pjzl = data.getBillmodel();
			
			CrtTbLoanHpAmt crtTbLoanHpAmt = new CrtTbLoanHpAmt();	//汇票出账金额表
			String summaryNum = crtGitUtilService.getSeqNo("JJ", "0700");	//借据号	orgNum:写死了的，需要从前端传过来，这个以后修改
			
			String uuid = UUIDGenerator.getUUID();
			crtTbLoanHpAmt.setMoneyUseId(uuid); // 主键，自己用uuid生成之后插入
			crtTbLoanHpAmt.setApplyDetailId(data.getApplyDetailId());	//票据明细id
			crtTbLoanHpAmt.setLoanId(loanInfo.getLoanId());	//出账Id
			crtTbLoanHpAmt.setLoanAmt(data.getBillamt());	//出账金额
			crtTbLoanHpAmt.setPyeAcctNm(data.getBenename());	//收款人户名
			crtTbLoanHpAmt.setPyeAcctNo(data.getBeneno()); 	//收款人账号
			crtTbLoanHpAmt.setPyeOpenAcctBnkNm(data.getBenebankname());	// 收款人开户行行名
			crtTbLoanHpAmt.setDrftExpDt(data.getBillenddate());	// 汇票到期日期
			crtTbLoanHpAmt.setIssuDt(data.getBillbegindate());	// 出票日期
			crtTbLoanHpAmt.setBillNo(data.getBillno());	// 票据号
			crtTbLoanHpAmt.setBillState("0"); // 票据状态(0-正常；1-删除)
			crtTbLoanHpAmt.setSummaryNum(summaryNum);	// 借据号
			crtTbLoanHpAmt.setDrweBnkNm(null);	// 付款行全称
			crtTbLoanHpAmt.setDrweBnkNo(null);	// 付款行行号
			crtTbLoanHpAmt.setDrweBnkAdr(null);	// 付款行地址
			crtTbLoanHpAmt.setSortOrder(data.getSortOrder());	// 排序序号
			
			crtTbLoanHpAmtMapper.insertCrtTbLoanHpAmtSelective(crtTbLoanHpAmt);// 先这样写，插入一条汇票出账金额信息
		}
		
		TbConContractInfo contractInfo = contractInfoMapper.queryOneConContractInfoByContractId(loanInfo.getContractId());
		//获取营业日期
		try {
			loanInfo.setBeginDate(new SimpleDateFormat("yyyy-MM-dd").parse(crtGitUtilService.getBusiDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		loanInfo.setEndDate(contractInfo.getEndDate());//到期日期
		loanInfo.setLoanAmt(contractInfo.getRmbAmt());// 出账金额
		loanInfo.setRmbAmt(contractInfo.getRmbAmt());// 合同金额*汇率 目前默认人民币汇率1
		loanInfo.setPjzl(pjzl);	// 票据种类
		loanInfo.setHpzs(txxx.size());	// 汇票张数
		
		loanInfoMapper.updateLoanInfoBySelect(loanInfo);
	}
	
	
	/**
	 * saveConToLoan:将合同信息保存到放款
	 * 	1.感觉有大量的重复代码，整合的时候看看能不能精简掉
	 * @param loanId
	 */
	public void saveConToLoan(String loanId){
		CrtTbLoanInfo loanInfo = loanInfoMapper.selectLoanInfoByloanId(loanId);
		String contractId = loanInfo.getContractId();
		TbConContractInfo contractInfo = contractInfoMapper.queryOneConContractInfoByContractId(contractId);
		
		//合同需要转移到借据里面的信息
		loanInfo.setExchangeRate(contractInfo.getExchangeRate());
		loanInfo.setCurrencyCd(contractInfo.getCurrencyCd());
		loanInfo.setCycleUnit(contractInfo.getCycleUnit());
		loanInfo.setProductType(contractInfo.getProductType());
		loanInfo.setSpecPaymentDate(contractInfo.getSpecPaymentDate());
		loanInfo.setRepayType(contractInfo.getRepaymentType());
		loanInfo.setFirstRepayTerm(contractInfo.getFirstRepayTerm());
		loanInfo.setTrusToPayFlg(contractInfo.getPayWay());
		
		loanInfoMapper.updateLoanInfoBySelect(loanInfo);	//更新借据
		
	}
	
}
