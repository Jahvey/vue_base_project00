package com.cdgit.loan.csm.process.cons;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.BeanUtil;
import com.cdgit.loan.common.util.uid.StringUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.csm.bean.CsmConDetailVo;
import com.cdgit.loan.csm.mapper.ConApplyMapper;
import com.cdgit.loan.csm.mapper.CsmConDetailVoMapper;
import com.cdgit.loan.csm.mapper.CsmRuleEngineMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountLoanrateApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizBgdkApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizBhApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizCktsyhApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizCkttfprzApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizCkxyzyhApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizFrzhtzApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizGdzcdkApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizGjfftApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizGjxyzdbdkApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizGjxyzkzApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizGnblApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizGnxyzApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizHptxApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizJkbhApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizJkdfApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizJkdsyhApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizJkttyhApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizJkxyzApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizJkxyzyhApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizKlyhcdhpApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizLdzjApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizPjxxApplyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizSummaryMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizThdbApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizWtdkApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizXdzmApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizXmdkcnhApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizXwApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConBgdkPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConBhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConCktsyhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConCkxyzyhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConContractInfoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConFrzhtzPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConGdzcdkPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConGjfftPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConGjxyzdbdkPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConGjxyzkzPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConGnblPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConGnxyzPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConHptxPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConJkbhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConJkdfPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConJkdsyhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConJkttyhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConJkxyzPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConJkxyzyhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConKlyhcdhpPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConLdzjPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConLoanratePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConThdbPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConWtdkPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConXdzmPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConXmdkcnhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConXwPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbLoanSummaryMapper;
import com.cdgit.loan.csm.po.CsmTbBizBgdkApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizBhApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizCktsyhApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizCkttfprzApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizCkxyzyhApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizFrzhtzApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizGdzcdkApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizGjfftApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizGjxyzdbdkApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizGjxyzkzApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizGnblApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizGnxyzApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizHptxApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizJkbhApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizJkdfApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizJkdsyhApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizJkttyhApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizJkxyzApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizJkxyzyhApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizKlyhcdhpApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizLdzjApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizPjxxApplyPo;
import com.cdgit.loan.csm.po.CsmTbBizThdbApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizWtdkApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizXdzmApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizXmdkcnhApprovePo;
import com.cdgit.loan.csm.po.CsmTbBizXwApprovePo;
import com.cdgit.loan.csm.po.CsmTbConBgdkPo;
import com.cdgit.loan.csm.po.CsmTbConBhPo;
import com.cdgit.loan.csm.po.CsmTbConCktsyhPo;
import com.cdgit.loan.csm.po.CsmTbConCkxyzyhPo;
import com.cdgit.loan.csm.po.CsmTbConFrzhtzPo;
import com.cdgit.loan.csm.po.CsmTbConGdzcdkPo;
import com.cdgit.loan.csm.po.CsmTbConGjfftPo;
import com.cdgit.loan.csm.po.CsmTbConGjxyzdbdkPo;
import com.cdgit.loan.csm.po.CsmTbConGjxyzkzPo;
import com.cdgit.loan.csm.po.CsmTbConGnblPo;
import com.cdgit.loan.csm.po.CsmTbConGnxyzPo;
import com.cdgit.loan.csm.po.CsmTbConJkbhPo;
import com.cdgit.loan.csm.po.CsmTbConJkdfPo;
import com.cdgit.loan.csm.po.CsmTbConJkdsyhPo;
import com.cdgit.loan.csm.po.CsmTbConJkttyhPo;
import com.cdgit.loan.csm.po.CsmTbConJkxyzPo;
import com.cdgit.loan.csm.po.CsmTbConJkxyzyhPo;
import com.cdgit.loan.csm.po.CsmTbConKlyhcdhpPo;
import com.cdgit.loan.csm.po.CsmTbConLdzjPo;
import com.cdgit.loan.csm.po.CsmTbConLoanratePo;
import com.cdgit.loan.csm.po.CsmTbConThdbPo;
import com.cdgit.loan.csm.po.CsmTbConWtdkPo;
import com.cdgit.loan.csm.po.CsmTbConXdzmPo;
import com.cdgit.loan.csm.po.CsmTbConXmdkcnhPo;
import com.cdgit.loan.csm.po.CsmTbConXwPo;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbBizAmountLoanrateApprovePo;
import com.cdgit.loan.csm.po.TbBizApprovePo;
import com.cdgit.loan.csm.po.TbBizSummaryPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.po.TbLoanSummaryPo;
import com.cdgit.loan.csm.process.accInfo.ContractSub;
import com.cdgit.loan.csm.process.products.ProductUtil;
import com.cdgit.loan.csm.pub.gitUtils.CommonUtils;
import com.cdgit.loan.csm.pub.gitUtils.GitUtils;


@Service
@Transactional
public class ConInfoCreateDao {//ConDao0001
	
	@Autowired
	CsmTbBizAmountDetailApproveMapper csmTbBizAmountDetailApproveMapper;
	
	@Autowired
	CsmTbBizApproveMapper  csmTbBizApproveMapper;
	
	@Autowired
	CsmTbBizSummaryMapper csmTbBizSummaryMapper;
	
	@Autowired
	CsmTbLoanSummaryMapper  csmTbLoanSummaryMapper;
	
	@Autowired
	CsmTbBizAmountLoanrateApproveMapper csmTbBizAmountLoanrateApproveMapper;
	@Autowired
	ConApplyMapper  conApplyMapper;
	
	@Autowired
	GitUtils gitUtils;
	@Autowired
	CommonUtils commonUtils; 
	
	@Autowired
	CsmTbConContractInfoMapper csmTbConContractInfoMapper;
	
	@Autowired
	CsmTbConLoanratePoMapper csmTbConLoanratePoMapper;
	
	@Autowired
	CsmTbBizWtdkApprovePoMapper csmTbBizWtdkApprovePoMapper;
	
	@Autowired
	CsmTbConWtdkPoMapper csmTbConWtdkPoMapper;
	
	@Autowired
	CsmTbBizXmdkcnhApprovePoMapper csmTbBizXmdkcnhApprovePoMapper;
	
	@Autowired
	CsmTbConXmdkcnhPoMapper csmTbConXmdkcnhPoMapper;
	
	@Autowired
	CsmTbBizGjxyzdbdkApprovePoMapper csmTbBizGjxyzdbdkApprovePoMapper;
	
	@Autowired
	CsmTbConGjxyzdbdkPoMapper csmTbConGjxyzdbdkPoMapper;
	
	@Autowired
	CsmTbBizGjfftApprovePoMapper csmTbBizGjfftApprovePoMapper;
	
	@Autowired
	CsmTbConGjfftPoMapper csmTbConGjfftPoMapper;
	
	@Autowired
	CsmTbBizCkxyzyhApprovePoMapper csmTbBizCkxyzyhApprovePoMapper;
	
	@Autowired
	CsmTbConCkxyzyhPoMapper csmTbConCkxyzyhPoMapper;
	
	@Autowired
	CsmTbBizFrzhtzApprovePoMapper csmTbBizFrzhtzApprovePoMapper;
	
	@Autowired
	CsmTbConFrzhtzPoMapper  csmTbConFrzhtzPoMapper;
	
	@Autowired
	CsmTbBizJkttyhApprovePoMapper CsmTbBizJkttyhApprovePoMapper;
	
	@Autowired
	CsmTbConJkttyhPoMapper csmTbConJkttyhPoMapper;
	
	@Autowired
	CsmTbBizJkdsyhApprovePoMapper csmTbBizJkdsyhApprovePoMapper;
	
	@Autowired
	CsmTbConJkdsyhPoMapper csmTbConJkdsyhPoMapper;
	
	@Autowired
	CsmTbBizXwApprovePoMapper csmTbBizXwApprovePoMapper;
	
	@Autowired
	CsmTbConXwPoMapper csmTbConXwPoMapper;
	
	@Autowired
	CsmTbBizCktsyhApprovePoMapper csmTbBizCktsyhApprovePoMapper;
	
	@Autowired
	CsmTbConCktsyhPoMapper csmTbConCktsyhPoMapper;
	
	@Autowired
	CsmTbBizJkxyzApprovePoMapper csmTbBizJkxyzApprovePoMapper;
	
	@Autowired
	CsmTbConJkxyzPoMapper csmTbConJkxyzPoMapper;
	
	@Autowired
	CsmTbBizGnxyzApprovePoMapper csmTbBizGnxyzApprovePoMapper;
	
	@Autowired
	CsmTbConGnxyzPoMapper  csmTbConGnxyzPoMapper;
	
	@Autowired
	CsmTbBizJkdfApprovePoMapper csmTbBizJkdfApprovePoMapper;
	
	@Autowired
	CsmTbConJkdfPoMapper csmTbConJkdfPoMapper;
	
	@Autowired
	CsmTbBizGjxyzkzApprovePoMapper csmTbBizGjxyzkzApprovePoMapper;
	
	@Autowired
	CsmTbConGjxyzkzPoMapper csmTbConGjxyzkzPoMapper;
	
	@Autowired
	CsmTbBizKlyhcdhpApprovePoMapper csmTbBizKlyhcdhpApprovePoMapper;
	
	@Autowired
	CsmTbConKlyhcdhpPoMapper csmTbConKlyhcdhpPoMapper;
	
	@Autowired
	CsmTbBizJkxyzyhApprovePoMapper  csmTbBizJkxyzyhApprovePoMapper;
	
	@Autowired
	CsmTbConJkxyzyhPoMapper  CsmTbConJkxyzyhPoMapper;
	
	@Autowired
	CsmTbBizBhApprovePoMapper  csmTbBizBhApprovePoMapper;
	
	@Autowired
	CsmTbConBhPoMapper  csmTbConBhPoMapper;
	
	@Autowired
	CsmTbBizXdzmApprovePoMapper csmTbBizXdzmApprovePoMapper;
	
	@Autowired
	CsmTbConXdzmPoMapper csmTbConXdzmPoMapper;
	
	@Autowired
	CsmTbBizGdzcdkApprovePoMapper csmTbBizGdzcdkApprovePoMapper;
	
	@Autowired
	CsmTbConGdzcdkPoMapper csmTbConGdzcdkPoMapper;
	
	@Autowired
	CsmTbBizLdzjApprovePoMapper csmTbBizLdzjApprovePoMapper;
	
	@Autowired
	CsmTbConLdzjPoMapper csmTbConLdzjPoMapper;
	
	@Autowired
	CsmTbBizGnblApprovePoMapper csmTbBizGnblApprovePoMapper;
	
	@Autowired
	CsmTbConGnblPoMapper csmTbConGnblPoMapper;
	
	
	@Autowired
	CsmTbBizBgdkApprovePoMapper  csmTbBizBgdkApprovePoMapper;
	
	@Autowired
	CsmTbConBgdkPoMapper csmTbConBgdkPoMapper;
	 
	@Autowired
	CsmTbBizHptxApprovePoMapper csmTbBizHptxApprovePoMapper;
	
	@Autowired
	CsmTbConHptxPoMapper csmTbConHptxPoMapper;
	
	@Autowired
	CsmTbBizCkttfprzApprovePoMapper csmTbBizCkttfprzApprovePoMapper;
//	
//	CsmTbConCkttfprzPoMapper CsmTbConCkttfprzPoMapper;
	
	@Autowired
	CsmTbBizJkbhApprovePoMapper  csmTbBizJkbhApprovePoMapper;

	@Autowired
	CsmTbConJkbhPoMapper csmTbConJkbhPoMapper;
	
	@Autowired
	CsmTbBizThdbApprovePoMapper csmTbBizThdbApprovePoMapper;
	
	@Autowired
	CsmTbConThdbPoMapper csmTbConThdbPoMapper;
	
	@Autowired
	CsmTbBizPjxxApplyPoMapper csmTbBizPjxxApplyPoMapper;
	
	@Autowired
	CsmConDetailVoMapper csmConDetailVoMapper;
	
	
	@Autowired
	ProductUtil productUtil;
	
	@Autowired
	CsmRuleEngineMapper csmRuleEngineMapper;

	@Transactional
	public TbConContractInfoPo create(Map<String, Object> apply) {//TODO 待测这个是创建合同的核心方法。。。。。。。。。。
		String error = createValid(apply);
		if (error != null) {
			throw new RuntimeException(error);
		}
		TbConContractInfoPo applyObj = createApply(apply);
		createProcess(applyObj);
		return applyObj;
	}
	
	public String createProcess(TbConContractInfoPo contractInfo) {
//		String flowName = getFlowName();
//		if (StringUtil.isNull(flowName)) {
//			return null;
//		}
//		String processId = processFactory.createBpsProcessThrowError(bizObj.getString(getEntityId()), flowName);
//		bizObj.set("processInstId", processId);
		return "";
	}
	
	public TbConContractInfoPo createApply(Map<String, Object> dataMap) {//TODO 2019-02-12
	
		String amountDetailId = (String) dataMap.get("amountDetailId");
		if (StringUtil.isNull(amountDetailId)) {
			throw new RuntimeException("创建合同失败：请传入业务编号");
		}
		
		TbBizAmountDetailApprovePo bizDtl = (TbBizAmountDetailApprovePo) dataMap.get("db_bizDtl");
		TbBizApprovePo biz = (TbBizApprovePo) dataMap.get("db_biz");
		
		// 借新还旧时释放原贷款借据担保额度--20151229 -BUG #7971 生产环境中发起借新还旧时，之前押品未释放，担保不足值
		if ("06".equals(biz.getBizHappenType())) {
			TbBizSummaryPo bizSum = csmTbBizSummaryMapper.queryOneTbBizSummaryByApplyId(biz.getApplyId());		
			TbLoanSummaryPo loan = csmTbLoanSummaryMapper.queryOneTbLoanSummaryBySummaryId(bizSum.getSummaryId());
			ContractSub cs = new ContractSub();
			cs.delSubcontract(loan.getContractId());
		}
		
		// 查询品种明细信息
		String entityName = productUtil.getEntityName(bizDtl.getProductType());
		String tableName=productUtil.getTableName(bizDtl.getProductType());
		entityName = entityName.replace("Apply", "Approve");
		tableName=tableName.replace("apply", "approve");
		//TODO 周一再说。。。。。。。
//		DataObject productDetail = DataObjectUtil.createDataObject(entityName);
//		productDetail.set("amountDetailId", amountDetailId);
//		DatabaseUtil.expandEntityByTemplate("default", productDetail, productDetail);

		// 查询利率
		TbBizAmountLoanrateApprovePo loanRate = csmTbBizAmountLoanrateApproveMapper.queryOneCsmTbBizAmountLoanrateApprove(amountDetailId);
	

		entityName = entityName.replace("biz", "crt");
		entityName = entityName.replace("Biz", "Con");
		entityName = entityName.replace("Approve", "");
		String srcTableName=tableName;
		String tarTableName=tableName.replace("biz", "con").replace("_approve", "");
		

		Date busDate = gitUtils.getBusiDate();
		// 保存业务合同信息
		TbConContractInfoPo contractInfo = new TbConContractInfoPo();
		contractInfo.setProductType(bizDtl.getProductType());
		contractInfo.setContractId(UUIDGenerator.getUUID());//必须要填写在这里
		System.err.println("[创建的合同编号的id]:"+contractInfo.getContractId());
		
		CsmConDetailVo conDetail=new CsmConDetailVo();

		
		//TODO 一共有26张表，25种情况,其中tb_biz_ckttfprz_apply 这个表没有批复信息表
		if("tb_con_hptx".equals(tarTableName)){//1
			
			CsmTbBizHptxApprovePo productDetail = csmTbBizHptxApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbBizHptxApprovePo csmTbBizHptxApprovePo = new CsmTbBizHptxApprovePo();
			BeanUtil.copyBeanProperties(productDetail, csmTbBizHptxApprovePo, true);
			
			// 汇票贴现要把所有票据的编号拼起来，逗号隔开--金额加起来
			if(gitUtils.contain(contractInfo.getProductType(),new String[] { "01006001", "01006002", "01006010" } )){
				String hpbh="";
				BigDecimal hpamt = new BigDecimal("0");
				BigDecimal hpje= new BigDecimal("0");
				List<CsmTbBizPjxxApplyPo> hps = csmTbBizPjxxApplyPoMapper.queryByAmountDetailId(amountDetailId);
				
				if(hps!=null){
					
					for (int i = 0; i < hps.size(); i++) {
						if (i == 0) {
							hpbh = (String) hps.get(i).getPjhm();
						} else {
							hpbh = hpbh + "," + hps.get(i).getPjhm();
						}
						// 计算金额总和

						hpje= hps.get(i).getHpje();
						hpamt=hpamt.add(hpje);
					}
				}
				
				conDetail.setTxqq(busDate);
				conDetail.setHpbh(hpbh);
				conDetail.setHpTotalAmt(hpamt);
			}
		
			csmTbBizHptxApprovePo.setContractId(contractInfo.getContractId());
			csmTbBizHptxApprovePo.setApplyDetailId(UUIDGenerator.getUUID());
			
			csmTbBizHptxApprovePo.setUpdateTime(null);
			csmTbBizHptxApprovePo.setCreateTime(gitUtils.getCurrDate());
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);

			
		}else if("tb_con_wtdk".equals(tarTableName)){//2
			
			CsmTbBizWtdkApprovePo productDetail = csmTbBizWtdkApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConWtdkPo csmTbConWtdkPo = new CsmTbConWtdkPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConWtdkPo, true);
			
			csmTbConWtdkPo.setContractId(contractInfo.getContractId());
			csmTbConWtdkPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConWtdkPo.setUpdateTime(null);
			csmTbConWtdkPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConWtdkPoMapper.insertSelective(csmTbConWtdkPo);//后面再更新这个表就行了
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);

		}else if("tb_con_xmdkcnh".equals(tarTableName)){//3
			CsmTbBizXmdkcnhApprovePo productDetail = csmTbBizXmdkcnhApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConXmdkcnhPo csmTbConXmdkcnhPo = new CsmTbConXmdkcnhPo();
			BeanUtil.copyBeanProperties(productDetail, csmTbConXmdkcnhPo, true);
			
			csmTbConXmdkcnhPo.setContractId(contractInfo.getContractId());
			csmTbConXmdkcnhPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConXmdkcnhPo.setUpdateTime(null);
			csmTbConXmdkcnhPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConXmdkcnhPoMapper.insertSelective(csmTbConXmdkcnhPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);

		}else if("tb_con_gjxyzdbdk".equals(tarTableName)){//4
			CsmTbBizGjxyzdbdkApprovePo productDetail = csmTbBizGjxyzdbdkApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConGjxyzdbdkPo csmTbConGjxyzdbdkPo = new CsmTbConGjxyzdbdkPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConGjxyzdbdkPo, true);
			
			csmTbConGjxyzdbdkPo.setContractId(contractInfo.getContractId());
			csmTbConGjxyzdbdkPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConGjxyzdbdkPo.setUpdateTime(null);
			csmTbConGjxyzdbdkPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConGjxyzdbdkPoMapper.insertSelective(csmTbConGjxyzdbdkPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
			
		}else if("tb_con_gjfft".equals(tarTableName)){//5
			CsmTbBizGjfftApprovePo productDetail = csmTbBizGjfftApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConGjfftPo csmTbConGjfftPo = new CsmTbConGjfftPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConGjfftPo, true);
			
			csmTbConGjfftPo.setContractId(contractInfo.getContractId());
			csmTbConGjfftPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConGjfftPo.setUpdateTime(null);
			csmTbConGjfftPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConGjfftPoMapper.insertSelective(csmTbConGjfftPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);

		}else if("tb_con_ckxyzyh".equals(tarTableName)){//6
			CsmTbBizCkxyzyhApprovePo productDetail = csmTbBizCkxyzyhApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConCkxyzyhPo csmTbConCkxyzyhPo = new CsmTbConCkxyzyhPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConCkxyzyhPo, true);
			
			csmTbConCkxyzyhPo.setContractId(contractInfo.getContractId());
			csmTbConCkxyzyhPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConCkxyzyhPo.setUpdateTime(null);
			csmTbConCkxyzyhPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConCkxyzyhPoMapper.insertSelective(csmTbConCkxyzyhPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_frzhtz".equals(tarTableName)){//7
			CsmTbBizFrzhtzApprovePo productDetail = csmTbBizFrzhtzApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConFrzhtzPo csmTbConFrzhtzPo = new CsmTbConFrzhtzPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConFrzhtzPo, true);
			
			csmTbConFrzhtzPo.setContractId(contractInfo.getContractId());
			csmTbConFrzhtzPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConFrzhtzPo.setUpdateTime(null);
			csmTbConFrzhtzPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConFrzhtzPoMapper.insertSelective(csmTbConFrzhtzPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);	
		}else if ("tb_con_jkttyh".equals(tarTableName)) {//8
			CsmTbBizJkttyhApprovePo productDetail = CsmTbBizJkttyhApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConJkttyhPo csmTbConJkttyhPo = new CsmTbConJkttyhPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConJkttyhPo, true);
			
			csmTbConJkttyhPo.setContractId(contractInfo.getContractId());
			csmTbConJkttyhPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConJkttyhPo.setUpdateTime(null);
			csmTbConJkttyhPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConJkttyhPoMapper.insertSelective(csmTbConJkttyhPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if ("tb_con_jkdsyh".equals(tarTableName)) {//9
			CsmTbBizJkdsyhApprovePo productDetail = csmTbBizJkdsyhApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConJkdsyhPo csmTbConJkdsyhPo = new CsmTbConJkdsyhPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConJkdsyhPo, true);
			
			csmTbConJkdsyhPo.setContractId(contractInfo.getContractId());
			csmTbConJkdsyhPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConJkdsyhPo.setUpdateTime(null);
			csmTbConJkdsyhPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConJkdsyhPoMapper.insertSelective(csmTbConJkdsyhPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);	
		}else if("tb_con_xw".equals(tarTableName)){//10
			CsmTbBizXwApprovePo productDetail = csmTbBizXwApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConXwPo csmTbConXwPo = new CsmTbConXwPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConXwPo, true);
			
			csmTbConXwPo.setContractId(contractInfo.getContractId());
			csmTbConXwPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConXwPo.setUpdateTime(null);
			csmTbConXwPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConXwPoMapper.insertSelective(csmTbConXwPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);	
		}else if("tb_con_cktsyh".equals(tarTableName)){//11
			CsmTbBizCktsyhApprovePo productDetail = csmTbBizCktsyhApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConCktsyhPo csmTbConCktsyhPo = new CsmTbConCktsyhPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConCktsyhPo, true);
			
			csmTbConCktsyhPo.setContractId(contractInfo.getContractId());
			csmTbConCktsyhPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConCktsyhPo.setUpdateTime(null);
			csmTbConCktsyhPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConCktsyhPoMapper.insertSelective(csmTbConCktsyhPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_jkxyz".equals(tarTableName)){//12
			CsmTbBizJkxyzApprovePo productDetail = csmTbBizJkxyzApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConJkxyzPo csmTbConJkxyzPo = new CsmTbConJkxyzPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConJkxyzPo, true);
			
			csmTbConJkxyzPo.setContractId(contractInfo.getContractId());
			csmTbConJkxyzPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConJkxyzPo.setUpdateTime(null);
			csmTbConJkxyzPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConJkxyzPoMapper.insertSelective(csmTbConJkxyzPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_gnxyz".equals(tarTableName)){//13
			CsmTbBizGnxyzApprovePo productDetail = csmTbBizGnxyzApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConGnxyzPo csmTbConGnxyzPo = new CsmTbConGnxyzPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConGnxyzPo, true);
			
			csmTbConGnxyzPo.setContractId(contractInfo.getContractId());
			csmTbConGnxyzPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConGnxyzPo.setUpdateTime(null);
			csmTbConGnxyzPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConGnxyzPoMapper.insertSelective(csmTbConGnxyzPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_jkdf".equals(tarTableName)){//14
			CsmTbBizJkdfApprovePo productDetail = csmTbBizJkdfApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConJkdfPo csmTbConJkdfPo = new CsmTbConJkdfPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConJkdfPo, true);
			
			csmTbConJkdfPo.setContractId(contractInfo.getContractId());
			csmTbConJkdfPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConJkdfPo.setUpdateTime(null);
			csmTbConJkdfPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConJkdfPoMapper.insertSelective(csmTbConJkdfPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_gjxyzkz".equals(tarTableName)){//15
			CsmTbBizGjxyzkzApprovePo productDetail = csmTbBizGjxyzkzApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConGjxyzkzPo csmTbConGjxyzkzPo = new CsmTbConGjxyzkzPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConGjxyzkzPo, true);
			
			csmTbConGjxyzkzPo.setContractId(contractInfo.getContractId());
			csmTbConGjxyzkzPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConGjxyzkzPo.setUpdateTime(null);
			csmTbConGjxyzkzPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConGjxyzkzPoMapper.insertSelective(csmTbConGjxyzkzPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_klyhcdhp".equals(tarTableName)){//16
			CsmTbBizKlyhcdhpApprovePo productDetail = csmTbBizKlyhcdhpApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConKlyhcdhpPo csmTbConKlyhcdhpPo = new CsmTbConKlyhcdhpPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConKlyhcdhpPo, true);
			
			csmTbConKlyhcdhpPo.setContractId(contractInfo.getContractId());
			csmTbConKlyhcdhpPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConKlyhcdhpPo.setUpdateTime(null);
			csmTbConKlyhcdhpPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConKlyhcdhpPoMapper.insertSelective(csmTbConKlyhcdhpPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_jkxyzyh".equals(tarTableName)){//17
			CsmTbBizJkxyzyhApprovePo productDetail = csmTbBizJkxyzyhApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConJkxyzyhPo csmTbConJkxyzyhPo = new CsmTbConJkxyzyhPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConJkxyzyhPo, true);
			
			csmTbConJkxyzyhPo.setContractId(contractInfo.getContractId());
			csmTbConJkxyzyhPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConJkxyzyhPo.setUpdateTime(null);
			csmTbConJkxyzyhPo.setCreateTime(gitUtils.getCurrDate());
			CsmTbConJkxyzyhPoMapper.insertSelective(csmTbConJkxyzyhPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_bh".equals(tarTableName)){//18
			CsmTbBizBhApprovePo productDetail = csmTbBizBhApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConBhPo csmTbConBhPo = new CsmTbConBhPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConBhPo, true);
			
			csmTbConBhPo.setContractId(contractInfo.getContractId());
			csmTbConBhPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConBhPo.setUpdateTime(null);
			csmTbConBhPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConBhPoMapper.insertSelective(csmTbConBhPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_xdzm".equals(tarTableName)){//19
			CsmTbBizXdzmApprovePo productDetail = csmTbBizXdzmApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConXdzmPo csmTbConXdzmPo = new CsmTbConXdzmPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConXdzmPo, true);
			
			csmTbConXdzmPo.setContractId(contractInfo.getContractId());
			csmTbConXdzmPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConXdzmPo.setUpdateTime(null);
			csmTbConXdzmPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConXdzmPoMapper.insertSelective(csmTbConXdzmPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_gdzcdk".equals(tarTableName)){//20
			CsmTbBizGdzcdkApprovePo productDetail = csmTbBizGdzcdkApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConGdzcdkPo csmTbConGdzcdkPo = new CsmTbConGdzcdkPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConGdzcdkPo, true);
			
			csmTbConGdzcdkPo.setContractId(contractInfo.getContractId());
			csmTbConGdzcdkPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConGdzcdkPo.setUpdateTime(null);
			csmTbConGdzcdkPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConGdzcdkPoMapper.insertSelective(csmTbConGdzcdkPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_ldzj".equals(tarTableName)){//21
			CsmTbBizLdzjApprovePo productDetail = csmTbBizLdzjApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConLdzjPo csmTbConLdzjPo = new CsmTbConLdzjPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConLdzjPo, true);
			
			csmTbConLdzjPo.setContractId(contractInfo.getContractId());
			csmTbConLdzjPo.setApplyDetailId(UUIDGenerator.getUUID());
			System.err.println("[tb_con_ldzj]数据插入成功！ApplyDetailId;"+csmTbConLdzjPo.getApplyDetailId());
			csmTbConLdzjPo.setUpdateTime(null);
			csmTbConLdzjPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConLdzjPoMapper.insertSelective(csmTbConLdzjPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_gnbl".equals(tarTableName)){//22
			CsmTbBizGnblApprovePo productDetail = csmTbBizGnblApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConGnblPo csmTbConGnblPo = new CsmTbConGnblPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConGnblPo, true);
			
			csmTbConGnblPo.setContractId(contractInfo.getContractId());
			csmTbConGnblPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConGnblPo.setUpdateTime(null);
			csmTbConGnblPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConGnblPoMapper.insertSelective(csmTbConGnblPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_bgdk".equals(tarTableName)){//23
			CsmTbBizBgdkApprovePo productDetail = csmTbBizBgdkApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConBgdkPo csmTbConBgdkPo = new CsmTbConBgdkPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConBgdkPo, true);
			
			csmTbConBgdkPo.setContractId(contractInfo.getContractId());
			csmTbConBgdkPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConBgdkPo.setUpdateTime(null);
			csmTbConBgdkPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConBgdkPoMapper.insertSelective(csmTbConBgdkPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_jkbh".equals(tarTableName)){//24
			CsmTbBizJkbhApprovePo productDetail = csmTbBizJkbhApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConJkbhPo csmTbConJkbhPo = new CsmTbConJkbhPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConJkbhPo, true);
			
			csmTbConJkbhPo.setContractId(contractInfo.getContractId());
			csmTbConJkbhPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConJkbhPo.setUpdateTime(null);
			csmTbConJkbhPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConJkbhPoMapper.insertSelective(csmTbConJkbhPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_thdb".equals(tarTableName)){//25
			CsmTbBizThdbApprovePo productDetail = csmTbBizThdbApprovePoMapper.queryByAmountDetailId(amountDetailId);
			CsmTbConThdbPo csmTbConThdbPo = new CsmTbConThdbPo();
			
			BeanUtil.copyBeanProperties(productDetail, csmTbConThdbPo, true);
			
			csmTbConThdbPo.setContractId(contractInfo.getContractId());
			csmTbConThdbPo.setApplyDetailId(UUIDGenerator.getUUID());
			csmTbConThdbPo.setUpdateTime(null);
			csmTbConThdbPo.setCreateTime(gitUtils.getCurrDate());
			csmTbConThdbPoMapper.insertSelective(csmTbConThdbPo);
			
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else if("tb_con_ckttfprz".equals(tarTableName)) {//26
			CsmTbBizCkttfprzApprovePo productDetail = csmTbBizCkttfprzApprovePoMapper.queryByAmountDetailId(amountDetailId);
			BeanUtil.copyBeanProperties(productDetail, conDetail, true);
		}else {
			//直接抛异常了，还有啥好说的
			throw new RuntimeException("将批复信息表 拷贝到 合同表的操作失败！！！");
		}
		
		//DataObject conDetail = DataObjectUtil.convertDataObject(productDetail, entityName, true);
		

		contractInfo.setAmountDetailId(amountDetailId);
		contractInfo.setCreateTime(gitUtils.getCurrDate());
		
		contractInfo.setPartyId(biz.getPartyId());
		contractInfo.setGuarantyType(biz.getGuarantyType());
		
		//借新还旧
		if("06".equals(biz.getBizHappenType())){
			String datas = conApplyMapper.queryJxhjOldConId(biz.getApplyId());
			if (datas == null || datas.equals("")) {
				throw new RuntimeException("无法找到循环贷所对应的原合同编号[applyId=" + biz.getApplyId() + "]");
			}
			contractInfo.setJxhjId(datas);
			
			
		}
		
		contractInfo.setCrdDtlId(bizDtl.getCrdDtlId());

		contractInfo.setCycleUnit(bizDtl.getCycleUnit());
		contractInfo.setRepaymentType(bizDtl.getRepaymentType());
		contractInfo.setExchangeRate(bizDtl.getExchangeRate());
		contractInfo.setCurrencyCd(bizDtl.getCurrencyCd());
		contractInfo.setCycleIndCon(bizDtl.getCycleIndCon());
		contractInfo.setCreditMode(bizDtl.getCreditMode());
		String conNum=gitUtils.getSeqNo("HT", gitUtils.getCurrentOrgCd());
		contractInfo.setContractNum(conNum);
		contractInfo.setPaperConNum(conNum);
		contractInfo.setBeginDate(busDate);
		contractInfo.setUserNum(gitUtils.getCurrentUserId());
		contractInfo.setOrgNum(gitUtils.getCurrentOrgCd());
		contractInfo.setSpecPaymentDate(new Short("21"));
		contractInfo.setConStatus("01");
		
		//有可能是一个bug
		
		Date validDate=biz.getValidDate();
		
		if(validDate!=null){
			//TODO   valiDate有为空的情况
			//Date tkdate = DateHelper.calculateDate(validDate, 0, 0, 30);
			Date tkdate=validDate;
			contractInfo.setTkDate(tkdate);
			
		}
		
		contractInfo.setHolidayFlg(bizDtl.getHolidayFlg());
		// 小微把贷款用途保存进合同基本信息

		if(null!=conDetail.getLoanUse()&&!"".equals(conDetail.getLoanUse())){
			contractInfo.setLoanUse(conDetail.getLoanUse());
		}
		contractInfo.setFirstRepayTerm(bizDtl.getFirstRepayTerm());
		contractInfo.setInternalDays(Integer.parseInt(commonUtils.getDBConfigVal("sys", "sys_internalDays")));
		
		csmTbConContractInfoMapper.insertCsmTbConContractInfoSelective(contractInfo);
		System.err.println("[contractInfo对象保存到数据库成功！！！！！]contractId:"+contractInfo.getContractId());

		
		CsmTbConLoanratePo conLoanrate=new CsmTbConLoanratePo();
		
		BeanUtil.copyBeanProperties(loanRate, conLoanrate, true);
		conLoanrate.setContractId(contractInfo.getContractId());
		conLoanrate.setLoanrateId(UUIDGenerator.getUUID());
		System.err.println("[保存conLoanrate借贷信息成功！！！]LoanrateId="+conLoanrate.getLoanrateId());
		csmTbConLoanratePoMapper.insertSelective(conLoanrate);

		return contractInfo;
		
		
	}
	
	

	public String createValid(Map<String, Object> dataMap) {
		String bizDtlId = (String) dataMap.get("AMOUNT_DETAIL_ID");
		TbBizAmountDetailApprovePo bizDtl = csmTbBizAmountDetailApproveMapper.queryOneTbBizAmountDetailApproveByAmountDetailId(bizDtlId);
		TbBizApprovePo biz = csmTbBizApproveMapper.queryOneTbBizApproveByApproveId(bizDtl.getApproveId());
		//DataObject bizDtl = EntityUtil.getEntityById(BizTableName.TB_BIZ_AMOUNT_DETAIL_APPROVE, "amountDetailId", bizDtlId);
		//DataObject biz = EntityUtil.getEntityById(BizTableName.TB_BIZ_APPROVE, "approveId", bizDtl.getString("approveId"));

		dataMap.put("amountDetailId", bizDtlId);
		dataMap.put("applyId", biz.getApproveId());// 调整之后old_apply_id存放的approve_id
		dataMap.put("approveId", biz.getApproveId());
		dataMap.put("crdId", biz.getCrdId());
//		RuleUtil.runRules(dataMap, "XFE_0003"// TODO 以后有时间得时候再做  2019-1-18........
//				, "RCON_0202"// 存在在途合同
//				, "RCON_0203"// 存在已生效合同
//				, "RCON_0204"// 该业务已无可用额度
//				, "RBIZ_0046" // 存在在途业务调整
//				, "RCRD_0212"// 存在在途授信调整
//		);
		if(0!=csmRuleEngineMapper.ruleXFE_0003(biz.getApproveId())){
			throw new RuntimeException("[XFE_0003]该批复已被纳入[移交申请],在业务结束前无法处理");
		}
		if(0!=csmRuleEngineMapper.ruleRCON_0202(bizDtlId)){
			throw new RuntimeException("[RCON_0202]该业务已存在在途合同申请");
		}
		if(0!=csmRuleEngineMapper.ruleRCON_0203(bizDtlId)){
			throw new RuntimeException("[RCON_0203]该业务已生成合同");
		}
		if(1!=csmRuleEngineMapper.ruleRCON_0204(bizDtlId)){
			throw new RuntimeException("[RCON_0204]该业务已无可用额度");
		}
		if(0!=csmRuleEngineMapper.ruleRBIZ_0046(biz.getApproveId())){
			throw new RuntimeException("[RBIZ_0046]该业务存在在途调整申请");
		}
		if(0!=csmRuleEngineMapper.ruleRCRD_0212(biz.getCrdId())){
			throw new RuntimeException("[RCRD_0212]该授信数据存在在途授信调整");
		}
		
		dataMap.put("db_biz", biz);
		dataMap.put("db_bizDtl", bizDtl);
		return null;
	}
	
	

}
