package com.cdgit.loan.csm.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.util.BeanUtil;
import com.cdgit.loan.csm.bean.ApproveAndSxxyVo;
import com.cdgit.loan.csm.mapper.ConApplyMapper;
import com.cdgit.loan.csm.mapper.CsmConDetailVoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizSummaryMapper;
import com.cdgit.loan.csm.mapper.CsmTbConAttachedInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubContractTPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubGrtRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbConZhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbGrtMortgageBasicMapper;
import com.cdgit.loan.csm.mapper.CsmTbLoanSummaryMapper;
import com.cdgit.loan.csm.po.CsmTbBizBankStructApplyPo;
import com.cdgit.loan.csm.po.CsmTbConCreditInfoPo;
import com.cdgit.loan.csm.po.TbBizAmountApprovePo;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbBizApprovePo;
import com.cdgit.loan.csm.po.TbBizSummaryPo;
import com.cdgit.loan.csm.po.TbConAttachedInfoPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.po.TbConSubContractTPo;
import com.cdgit.loan.csm.po.TbConSubGrtRelPo;
import com.cdgit.loan.csm.po.TbConSubcontractPo;
import com.cdgit.loan.csm.po.TbConSubcontractRelPo;
import com.cdgit.loan.csm.po.TbConZhPo;
import com.cdgit.loan.csm.po.TbGrtMortgageBasicPo;
import com.cdgit.loan.csm.po.TbLoanSummaryPo;
import com.cdgit.loan.csm.process.accInfo.ContractApply;
import com.cdgit.loan.csm.process.bizInfo.BizInfo;
import com.cdgit.loan.csm.process.conApply.ConApply;
import com.cdgit.loan.csm.process.conInfo.ConContractInfo;
import com.cdgit.loan.csm.process.conInfo.ConInfoSxxy;
import com.cdgit.loan.csm.process.cons.ConInfoCreateDao;
import com.cdgit.loan.csm.process.products.ProductUtil;
import com.cdgit.loan.csm.pub.gitUtils.CommonUtils;
import com.cdgit.loan.csm.service.CsmTbBizGdzcdkApprovePoServiceImpl;

@RestController
@RequestMapping("SubProcess")
public class SubProcessController {
	
	@Autowired
	CsmTbBizAmountDetailApproveMapper csmTbBizAmountDetailApproveMapper;
	
	@Autowired
	CsmTbBizAmountApproveMapper csmTbBizAmountApproveMapper;
	
	
	@Autowired
	CsmTbConSubContractTPoMapper csmTbConSubContractTPoMapper;
	
	@Autowired
	CsmTbBizApproveMapper csmTbBizApproveMapper;
	
	@Autowired
	CsmTbConAttachedInfoPoMapper csmTbConAttachedInfoPoMapper;
	
	
	@Autowired
	CsmTbLoanSummaryMapper csmTbLoanSummaryMapper;
	
	@Autowired
	CsmTbConZhPoMapper csmTbConZhPoMapper;
	
	@Autowired
	CsmTbConSubcontractRelMapper csmTbConSubcontractRelMapper;
	
	@Autowired
	CsmTbConSubGrtRelMapper csmTbConSubGrtRelMapper;
	
	@Autowired
	CsmTbConSubcontractMapper CsmTbConSubcontractMapper;
	
	@Autowired
	CsmTbGrtMortgageBasicMapper csmTbGrtMortgageBasicMapper;
	
	@Autowired
	CsmTbBizSummaryMapper  csmTbBizSummaryMapper;
	
	
	@Autowired
	CsmConDetailVoMapper csmConDetailVoMapper;
	
	@Autowired
	ConContractInfo conContractInfo1;
	
	@Autowired
	ConInfoSxxy conInfoSxxy1;
	
	@Autowired
	BizInfo bizInfo1;
	
	@Autowired
	ConApplyMapper conApplyMapper;
	
	
	@Autowired
	ConInfoCreateDao conInfoCreateDao;
	
	@Autowired
	ProductUtil productUtil;
	
	@Autowired
	CommonUtils commonUtils;
	
	@Autowired
	ContractApply contractApply;
	
	@Autowired
	ConApply conApply;
	
	//根据合同id查询 业务性质  TODO 需要测试2019-2-11
	@GetMapping("/getConInfoBizType1")
	public String getConInfoBizType1(String contractId){
		return conApply.getConInfoBizType(contractId);
		
	}
	
	
	//合同调整综合测试
	@GetMapping("/tzContractInfo1")
	public  HashMap<String,Object> tzContractInfo1(String contractId,String bizType){
		
		return conApply.tzContractInfo(contractId, bizType);
		
	}
	
	
	
	@GetMapping("/gettzConInfo")
	public TbConContractInfoPo gettzConInfo(String contractId){
		
		return contractApply.tzConInfo(contractId);
		
	}
	
	
	@GetMapping("/gettzCreditInfo")
	public CsmTbConCreditInfoPo gettzCreditInfo(String contractId){
		
		return contractApply.tzCreditInfo(contractId);
		
	}
	
	
	
	@GetMapping("/getDBConfigVal")
	public String getDBConfigVal(){
		
		return commonUtils.getDBConfigVal("sys", "sys_internalDays");
		
	}
	
	
	
	@GetMapping("/getTableName")
	public String getTableName(String productType){
		//return ProductUtil.getEntityName(productType);
		return productUtil.getTableName(productType);
	}
	
	
	@GetMapping("/getEntityName")
	public String getEntityName(String productType){
		return productUtil.getEntityName(productType);
		
	}
	
	
	@GetMapping("/createConInfo")
	public TbConContractInfoPo create(){
		
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		//同一条记录
//		hashMap.put("bizNum", "PF180330008993");
//		hashMap.put("partyId", "5AF8118FE74FFABDE05010AC57DD79A2");
//		hashMap.put("partyName", "族满功羊秋钞晔皎迦与狸侏牛");
//		hashMap.put("bizType", "02");
		hashMap.put("amountDetailId", "ff808081627148e60162749c96fe06a5");
		//hashMap.put("AMOUNT_DETAIL_ID", "ff808081627148e60162749c96fe06a5");
		return conInfoCreateDao.create(hashMap);
		
		
	}
	
	@GetMapping("/getApproveAndSxxy")
	public List<ApproveAndSxxyVo> getApproveAndSxxy(
			@RequestParam(value="bizNum",required=false)String bizNum,
			@RequestParam(value="partyId",required=false)String partyId,
			@RequestParam(value="userId",required=false)String userId,
			@RequestParam(value="amountDetailId",required=false)String amountDetailId){
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("bizNum", bizNum);
		hashMap.put("partyId", partyId);
		hashMap.put("userId", userId);
		hashMap.put("amountDetailId", amountDetailId);
		return  conApplyMapper.getApproveAndSxxy(hashMap);
		
		
	}
	
	@Transactional
	@GetMapping("/getDetailJspByContractId")
	public HashMap<String,Object> getDetailJspByContractId(String contractId){
		return (HashMap<String, Object>) conContractInfo1.getDetailJspByContractId(contractId);
		
		
	}
	
	@Transactional
	@GetMapping("/getBankTeamStruct")
	public CsmTbBizBankStructApplyPo getBankTeamStruct(String applyId){
		return bizInfo1.getBankTeamStruct(applyId);
	
	}
	
	
	@Transactional
	@GetMapping("/getConInfoByContarctId")
	public HashMap<String,Object> getConInfoByContarctId(String contractId){
		return (HashMap<String, Object>) conInfoSxxy1.getConInfoByContarctId(contractId);
	
	}
	
	@Transactional
	@GetMapping("/insertDemo1")
	public void insertDemo1(String amountDetailId){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("tarTableName", "Tb_con_Jkbh");
		map.put("srcTableName", "Tb_Biz_Jkbh_Approve");
		map.put("amountDetailId", "OvsgGFnJajz7p71g");
		//csmConDetailVoMapper.insert(map);
		csmConDetailVoMapper.insertSelective(map);
		
		
	}
	
	
	
	public void test(CsmTbBizGdzcdkApprovePoServiceImpl CsmTbBizGdzcdkApprovePoServiceImpl,String applyDetailId){
		CsmTbBizGdzcdkApprovePoServiceImpl.selectByPrimaryKey(applyDetailId);
		
	}
	
	
	@GetMapping("/queryTestProcessDemo")
	void queryTestProcessDemo(){
		Class<?> tarDetail=null;
		Class<?> srcDetail=null;
		Class<?> MapperDetail=null;
		Class<?> serviceDetail=null;
		
		try {
			srcDetail = Class.forName("com.cdgit.loan.csm.po.CsmTbBizGdzcdkApprovePo");
			
			serviceDetail = Class.forName("com.cdgit.loan.csm.service.CsmTbBizGdzcdkApprovePoServiceImpl");
			MapperDetail = Class.forName("com.cdgit.loan.csm.mapper.CsmTbBizGdzcdkApprovePoMapper");
			tarDetail = Class.forName("com.cdgit.loan.csm.po.CsmTbConGdzcdkPo");
			
			//SubProcessController instance = SubProcessController.class.newInstance();
			//Method method=SubProcessController.class.getMethod("test", serviceDetail,String.class);
			
			Method method = MapperDetail.getDeclaredMethod("selectByPrimaryKey", String.class);
			//Method method = serviceDetail.getDeclaredMethod("selectByPrimaryKey", String.class);
			//method.setAccessible(true);
			
			Object src = srcDetail.getConstructor().newInstance();
			Object tar = tarDetail.getConstructor(). newInstance();
			String srcArg = "ff8080816579223701657928b85b000d";
			//src=method.invoke(instance, serviceDetail.newInstance(),srcArg);
			src=method.invoke(serviceDetail.newInstance(),srcArg);
			
			
			BeanUtil.copyBeanProperties(src, tar);
		
			System.err.println(src);
			System.err.println(tar);
			
			
//			srcDetail = Class.forName("com.cdgit.loan.csm.po.CsmTbBizThdbApprovePo");
//			MapperDetail = Class.forName("com.cdgit.loan.csm.po.CsmTbConThdbPoMapper");
//			tarDetail = Class.forName("com.cdgit.loan.csm.po.CsmTbConThdbPo");
			
//			srcDetail = Class.forName("com.cdgit.loan.csm.po.CsmTbBizGdzcdkApprovePo");
//			MapperDetail = Class.forName("com.cdgit.loan.csm.mapper.CsmTbConGdzcdkPoMapper");
//			tarDetail = Class.forName("com.cdgit.loan.csm.po.CsmTbConGdzcdkPo");
//			
//			Method method2 = MapperDetail.getMethod("selectByPrimaryKey", String.class);
//			
//			 src = srcDetail.getConstructor().newInstance();
//			 tar = tarDetail.getConstructor(). newInstance();
//			 tar=method2.invoke(tar, "ff80808163b5a6570163b932a42b05bb");
//			
//			BeanUtil.copyBeanProperties(tar, src);
//			System.err.println(src);
//			System.err.println(tar);
			
		} catch (ClassNotFoundException e) {
			if(tarDetail==null&&srcDetail!=null){
				System.out.println(srcDetail.getName());
			}else{
				e.printStackTrace();
			}
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	 }
	
	
	
	@GetMapping("/queryOneTbBizSummaryByApplyId")
	TbBizSummaryPo queryOneTbBizSummaryByApplyId(String applyId){
		 
		 return csmTbBizSummaryMapper.queryOneTbBizSummaryByApplyId(applyId);
	 }
	
	//这两个都成功了
	@GetMapping("/queryOneTbGrtMortgageBasic")
	TbGrtMortgageBasicPo queryOneTbGrtMortgageBasic(String suretyId){
		return csmTbGrtMortgageBasicMapper.queryOneCsmTbGrtMortgageBasic(suretyId);
	}
	@GetMapping("/updateCsmTbGrtMortgageBasic")
	void updateCsmTbGrtMortgageBasic(String suretyId){
		TbGrtMortgageBasicPo grt=csmTbGrtMortgageBasicMapper.queryOneCsmTbGrtMortgageBasic(suretyId);
		
		grt.setAviAmt(new BigDecimal("3333333"));
		csmTbGrtMortgageBasicMapper.updateCsmTbGrtMortgageBasicByPrimaryKeySelective(grt);
		
		
	}
	
	@GetMapping("/queryCsmTbConSubcontractPo")
	TbConSubcontractPo queryCsmTbConSubcontractPo(String subcontractId){
		
		return CsmTbConSubcontractMapper.queryCsmTbConSubcontractPo(subcontractId);
		
	}
	
	//TODO 测试相应的updateCsmTbConSubcontract
	@GetMapping("/updateCsmTbConSubcontract")
	void updateCsmTbConSubcontract(String subcontractId){
		TbConSubcontractPo subCon=CsmTbConSubcontractMapper.queryCsmTbConSubcontractPo(subcontractId);
		
		subCon.setAnlljx(new BigDecimal("22222"));
		subCon.setAviAmt(new BigDecimal("12345.02"));
		CsmTbConSubcontractMapper.updateCsmTbConSubcontractByPrimaryKeySelective(subCon);
	}
	
	
	@GetMapping("/queryListTbConSubGrtRel")
	List<TbConSubGrtRelPo> queryListTbConSubGrtRel(String subcontractId){
		return csmTbConSubGrtRelMapper.queryListTbConSubGrtRel(subcontractId);
		
	}
	
	
	//TODO  TbConSubcontractRel 待测试。。。。。。
	@GetMapping("/queryListCsmTbConSubcontractRelByconId")
	List<TbConSubcontractRelPo> queryListCsmTbConSubcontractRelByconId(String contractId){
		return csmTbConSubcontractRelMapper.queryListCsmTbConSubcontractRelByconId(contractId);
		
	}
	
	
	
	
	
	
	
	@GetMapping("/queryListCsmTbConZhInfo")
	List<TbConZhPo> queryListCsmTbConZhInfo(String contractId){
		return csmTbConZhPoMapper.queryListCsmTbConZhInfo(contractId);
		
	}
	
	
	@GetMapping("/queryOneTbLoanSummaryBySummaryId")
	TbLoanSummaryPo queryOneTbLoanSummaryBySummaryId(String summaryId){
		return csmTbLoanSummaryMapper.queryOneTbLoanSummaryBySummaryId(summaryId);
		
	}
	
	

	
	@GetMapping("/queryOneTbBizAmountApproveByAmountId")
	TbBizAmountApprovePo queryOneTbBizAmountApproveByAmountId(String amountId){
		
		return csmTbBizAmountApproveMapper.queryOneTbBizAmountApproveByAmountId(amountId);
		
	}
	
	//TODO 1-18明天待测试。。。。。
	@GetMapping("/queryOneTbBizAmountDetailApproveByAmountDetailId")
	TbBizAmountDetailApprovePo queryOneTbBizAmountDetailApproveByAmountDetailId(String amountDetailId){
		
		return csmTbBizAmountDetailApproveMapper.queryOneTbBizAmountDetailApproveByAmountDetailId(amountDetailId);
		
	}
	
	
	
	@GetMapping("/queryOneTbConSubContractTPoInfo")
	TbConSubContractTPo	queryOneTbConSubContractTPoInfo(String subcontractId){
		return csmTbConSubContractTPoMapper.queryOneTbConSubContractTPoInfo(subcontractId);

		
	}
	
	
	
	@GetMapping("/queryOneTbBizApproveByApproveId")
	TbBizApprovePo queryOneTbBizApproveByApproveId(String approveId){
		return csmTbBizApproveMapper.queryOneTbBizApproveByApproveId(approveId);
	}
	
	@GetMapping("/queryCsmTbConAttachedInfoPo")
	TbConAttachedInfoPo queryCsmTbConAttachedInfoPo(String contractId){
		return csmTbConAttachedInfoPoMapper.queryCsmTbConAttachedInfoPo(contractId);
	}
	
	
	
	

	
	
	
	
	
	

}
