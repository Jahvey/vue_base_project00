/**
 * 
 */
package com.cdgit.loan.csm.process.accInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
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
import com.cdgit.loan.csm.mapper.CsmTbBizMyhtxxApplyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizPjxxApplyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizProductInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizSubcontractRelPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizThdbApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizXdzmApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizXmdkcnhApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizXwApprovePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConAttachedInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConBgdkPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConBhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConCktsyhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConCkxyzyhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConContractInfoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConCreditInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConFeePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConFlagInfoPoMapper;
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
import com.cdgit.loan.csm.mapper.CsmTbConNoticeAddrsPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConPayoutPlanPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConRepayPlanPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubGrtRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbConThdbPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConWtdkPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConXdzmPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConXmdkcnhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConXwPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConZhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTzContractInfoVoMapper;
import com.cdgit.loan.csm.po.CsmTbBizMyhtxxApplyPo;
import com.cdgit.loan.csm.po.CsmTbBizPjxxApplyPo;
import com.cdgit.loan.csm.po.CsmTbBizSubcontractRelPo;
import com.cdgit.loan.csm.po.CsmTbConBgdkPo;
import com.cdgit.loan.csm.po.CsmTbConBhPo;
import com.cdgit.loan.csm.po.CsmTbConCktsyhPo;
import com.cdgit.loan.csm.po.CsmTbConCkxyzyhPo;
import com.cdgit.loan.csm.po.CsmTbConCreditInfoPo;
import com.cdgit.loan.csm.po.CsmTbConFeePo;
import com.cdgit.loan.csm.po.CsmTbConFlagInfoPo;
import com.cdgit.loan.csm.po.CsmTbConFrzhtzPo;
import com.cdgit.loan.csm.po.CsmTbConGdzcdkPo;
import com.cdgit.loan.csm.po.CsmTbConGjfftPo;
import com.cdgit.loan.csm.po.CsmTbConGjxyzdbdkPo;
import com.cdgit.loan.csm.po.CsmTbConGjxyzkzPo;
import com.cdgit.loan.csm.po.CsmTbConGnblPo;
import com.cdgit.loan.csm.po.CsmTbConGnxyzPo;
import com.cdgit.loan.csm.po.CsmTbConHptxPo;
import com.cdgit.loan.csm.po.CsmTbConJkbhPo;
import com.cdgit.loan.csm.po.CsmTbConJkdfPo;
import com.cdgit.loan.csm.po.CsmTbConJkdsyhPo;
import com.cdgit.loan.csm.po.CsmTbConJkttyhPo;
import com.cdgit.loan.csm.po.CsmTbConJkxyzPo;
import com.cdgit.loan.csm.po.CsmTbConKlyhcdhpPo;
import com.cdgit.loan.csm.po.CsmTbConLdzjPo;
import com.cdgit.loan.csm.po.CsmTbConLoanratePo;
import com.cdgit.loan.csm.po.CsmTbConNoticeAddrsPo;
import com.cdgit.loan.csm.po.CsmTbConPayoutPlanPo;
import com.cdgit.loan.csm.po.CsmTbConRepayPlanPo;
import com.cdgit.loan.csm.po.CsmTbConThdbPo;
import com.cdgit.loan.csm.po.CsmTbConWtdkPo;
import com.cdgit.loan.csm.po.CsmTbConXdzmPo;
import com.cdgit.loan.csm.po.CsmTbConXmdkcnhPo;
import com.cdgit.loan.csm.po.CsmTbConXwPo;
import com.cdgit.loan.csm.po.TbBizProductInfoPo;
import com.cdgit.loan.csm.po.TbConAttachedInfoPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.po.TbConSubGrtRelPo;
import com.cdgit.loan.csm.po.TbConSubcontractPo;
import com.cdgit.loan.csm.po.TbConSubcontractRelPo;
import com.cdgit.loan.csm.po.TbConZhPo;
import com.cdgit.loan.csm.pub.gitUtils.GitUtils;

/**
 * @author Administrator
 *
 */
@Service
@Transactional
public class ContractApply {

	//TODO 合同调整待完成........
	
	@Autowired
	CsmTzContractInfoVoMapper csmTzContractInfoVoMapper;
	
	@Autowired
	CsmTbConAttachedInfoPoMapper csmTbConAttachedInfoPoMapper;
	
	@Autowired
	CsmTbConSubcontractMapper  csmTbConSubcontractMapper;
	
	@Autowired
	CsmTbConZhPoMapper csmTbConZhPoMapper;
	
	@Autowired
	CsmTbConContractInfoMapper csmTbConContractInfoMapper;

	@Autowired
	CsmTbConSubcontractRelMapper csmTbConSubcontractRelMapper;

	@Autowired
	CsmTbConLoanratePoMapper csmTbConLoanratePoMapper;

	@Autowired
	CsmTbConPayoutPlanPoMapper csmTbConPayoutPlanPoMapper;
	
	@Autowired
	CsmTbConRepayPlanPoMapper csmTbConRepayPlanPoMapper;
	
	@Autowired
	CsmTbConFeePoMapper csmTbConFeePoMapper;
	
	@Autowired
	CsmTbConFlagInfoPoMapper csmTbConFlagInfoPoMapper;
	
	@Autowired
	CsmTbBizMyhtxxApplyPoMapper  csmTbBizMyhtxxApplyPoMapper;

	@Autowired
	CsmTbConNoticeAddrsPoMapper csmTbConNoticeAddrsPoMapper;
	
	@Autowired
	CsmTbBizProductInfoPoMapper csmTbBizProductInfoPoMapper;
	
	@Autowired
	CsmTbBizPjxxApplyPoMapper csmTbBizPjxxApplyPoMapper;
	
	@Autowired
	CsmTbConSubGrtRelMapper csmTbConSubGrtRelMapper; 
	
	@Autowired
	CsmTbConCreditInfoPoMapper csmTbConCreditInfoPoMapper;

	@Autowired
	CsmTbBizSubcontractRelPoMapper csmTbBizSubcontractRelPoMapper;
	
	//26张表
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
	GitUtils gitUtils;
	/**
	 * @param contractId
	 * @param args
	 * @author 3231 合同调整
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TbConContractInfoPo tzConInfo(String contractId) {
		if (null == contractId || "".equals(contractId)) {
			throw new RuntimeException("调整时原合同ID为空");
		}
	
		TbConContractInfoPo tbConContractInfo=new TbConContractInfoPo();
		// 业务合同基本信息
		tbConContractInfo=csmTbConContractInfoMapper.queryOneCsmTbConContractInfoByConId(contractId);
		// 合同利率信息
		CsmTbConLoanratePo tbConLoanrate=csmTbConLoanratePoMapper.queryTbConLoanratePoByConId(contractId);
		// 用款计划
		List<CsmTbConPayoutPlanPo> tbConPayoutPlans = csmTbConPayoutPlanPoMapper.queryListByConDetailId(contractId);
		// 还款计划
		List<CsmTbConRepayPlanPo> tbConRepayPlans = csmTbConRepayPlanPoMapper.queryListByConId(contractId);
		
		// 账户信息
		List<TbConZhPo> tbConZhs = csmTbConZhPoMapper.queryListCsmTbConZhInfo(contractId);
		// 费用信息
		List<CsmTbConFeePo> tbConFees = csmTbConFeePoMapper.queryListByConId(contractId);
		// 标志信息
		CsmTbConFlagInfoPo tbConFlagInfo = csmTbConFlagInfoPoMapper.queryOneByConId(contractId);
		
		// 附属信息
		TbConAttachedInfoPo tbConAttachedInfo = csmTbConAttachedInfoPoMapper.queryCsmTbConAttachedInfoPo(contractId);
		
		// 贸易合同信息 --20151016----
		List<CsmTbBizMyhtxxApplyPo> myhts = csmTbBizMyhtxxApplyPoMapper.queryListByAmtDetailId(contractId);
		
		
		// 20160607 二期需求
		// 通知和文书送达
		CsmTbConNoticeAddrsPo noticeAddrs = csmTbConNoticeAddrsPoMapper.queryByConId(contractId);
		
		// 明细信息
		TbBizProductInfoPo productInfo = csmTbBizProductInfoPoMapper.queryByProductType(tbConContractInfo.getProductType());
		String entityName = productInfo.getEntityName();
		String tarTableName=productInfo.getTableName();
		// com.bos.dataset.biz.TbBizLdzjApply
		// com.bos.dataset.crt.TbConLdzj
		entityName = entityName.replace("biz", "crt");
		entityName = entityName.replace("Biz", "Con");
		entityName = entityName.replace("Apply", "");
		tarTableName=tarTableName.replace("biz", "con").replace("_apply", "");
		//TODO 一共有26种情况  每一种情况分别讨论 productDetail还没有创建出来，待测试................
		System.err.println("[tarTableName] is:"+tarTableName);
		if("tb_con_hptx".equals(tarTableName)){//1
			
			CsmTbConHptxPo productDetail = csmTbConHptxPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null!=productDetail && null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConHptxPoMapper.insertSelective(productDetail);
				
			}
			
			
		}else if("tb_con_wtdk".equals(tarTableName)){//2

			CsmTbConWtdkPo productDetail = csmTbConWtdkPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null!=productDetail && null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConWtdkPoMapper.insertSelective(productDetail);
				
			}
			

		}else if("tb_con_xmdkcnh".equals(tarTableName)){//3
			CsmTbConXmdkcnhPo productDetail = csmTbConXmdkcnhPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null!=productDetail && null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConXmdkcnhPoMapper.insertSelective(productDetail);
				
			}


		}else if("tb_con_gjxyzdbdk".equals(tarTableName)){//4
			CsmTbConGjxyzdbdkPo productDetail = csmTbConGjxyzdbdkPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null!=productDetail && null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConGjxyzdbdkPoMapper.insertSelective(productDetail);
				
			}
			

			
		}else if("tb_con_gjfft".equals(tarTableName)){//5
			CsmTbConGjfftPo productDetail = csmTbConGjfftPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null!=productDetail && null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConGjfftPoMapper.insertSelective(productDetail);
				
			}


		}else if("tb_con_ckxyzyh".equals(tarTableName)){//6
			CsmTbConCkxyzyhPo productDetail = csmTbConCkxyzyhPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null!=productDetail && null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConCkxyzyhPoMapper.insertSelective(productDetail);
				
			}
			

		}else if("tb_con_frzhtz".equals(tarTableName)){//7
			CsmTbConFrzhtzPo productDetail = csmTbConFrzhtzPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null!=productDetail && null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConFrzhtzPoMapper.insertSelective(productDetail);
				
			}
			

		}else if ("tb_con_jkttyh".equals(tarTableName)) {//8
			CsmTbConJkttyhPo productDetail = csmTbConJkttyhPoMapper.queryByConInfo(contractId);
			// 明细信息
			if (null!=productDetail &&  null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConJkttyhPoMapper.insertSelective(productDetail);
				
			}
						

		}else if ("tb_con_jkdsyh".equals(tarTableName)) {//9
			CsmTbConJkdsyhPo productDetail = csmTbConJkdsyhPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null!=productDetail && null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConJkdsyhPoMapper.insertSelective(productDetail);
				
			}
	
	
		}else if("tb_con_xw".equals(tarTableName)){//10
			CsmTbConXwPo productDetail = csmTbConXwPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null!=productDetail && null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConXwPoMapper.insertSelective(productDetail);
				
			}
			
	
		}else if("tb_con_cktsyh".equals(tarTableName)){//11
			CsmTbConCktsyhPo productDetail = csmTbConCktsyhPoMapper.queryByConInfo(contractId);
			// 明细信息
			if (null!=productDetail && null != productDetail.getApplyDetailId()) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConCktsyhPoMapper.insertSelective(productDetail);
				
			}			
		

		}else if("tb_con_jkxyz".equals(tarTableName)){//12
			CsmTbConJkxyzPo productDetail = csmTbConJkxyzPoMapper.queryByConInfo(contractId);
			// 明细信息
			if (null!=productDetail ) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConJkxyzPoMapper.insertSelective(productDetail);
				
			}				
			
		

		}else if("tb_con_gnxyz".equals(tarTableName)){//13
			CsmTbConGnxyzPo productDetail = csmTbConGnxyzPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConGnxyzPoMapper.insertSelective(productDetail);
				
			}				


		}else if("tb_con_jkdf".equals(tarTableName)){//14
			CsmTbConJkdfPo productDetail = csmTbConJkdfPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConJkdfPoMapper.insertSelective(productDetail);
				
			}		


		}else if("tb_con_gjxyzkz".equals(tarTableName)){//15
			CsmTbConGjxyzkzPo productDetail = csmTbConGjxyzkzPoMapper.queryByConInfo(contractId);

			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConGjxyzkzPoMapper.insertSelective(productDetail);
				
			}	
			

		}else if("tb_con_klyhcdhp".equals(tarTableName)){//16
			CsmTbConKlyhcdhpPo productDetail = csmTbConKlyhcdhpPoMapper.queryByConInfo(contractId);

			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConKlyhcdhpPoMapper.insertSelective(productDetail);
				
			}	


		}else if("tb_con_jkxyzyh".equals(tarTableName)){//17
			CsmTbConJkxyzPo productDetail = csmTbConJkxyzPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConJkxyzPoMapper.insertSelective(productDetail);
				
			}	


		}else if("tb_con_bh".equals(tarTableName)){//18
			CsmTbConBhPo productDetail = csmTbConBhPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConBhPoMapper.insertSelective(productDetail);
				
			}				

		}else if("tb_con_xdzm".equals(tarTableName)){//19
			CsmTbConXdzmPo productDetail = csmTbConXdzmPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConXdzmPoMapper.insertSelective(productDetail);
				
			}	
			


		}else if("tb_con_gdzcdk".equals(tarTableName)){//20
			CsmTbConGdzcdkPo productDetail = csmTbConGdzcdkPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConGdzcdkPoMapper.insertSelective(productDetail);
				
			}	

		}else if("tb_con_ldzj".equals(tarTableName)){//21
			CsmTbConLdzjPo productDetail = csmTbConLdzjPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConLdzjPoMapper.insertSelective(productDetail);
				
			}	


		}else if("tb_con_gnbl".equals(tarTableName)){//22
			CsmTbConGnblPo productDetail = csmTbConGnblPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConGnblPoMapper.insertSelective(productDetail);
				
			}	

		}else if("tb_con_bgdk".equals(tarTableName)){//23
			CsmTbConBgdkPo productDetail = csmTbConBgdkPoMapper.queryByConInfo(contractId);
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConBgdkPoMapper.insertSelective(productDetail);
				
			}	


		}else if("tb_con_jkbh".equals(tarTableName)){//24
			CsmTbConJkbhPo productDetail = csmTbConJkbhPoMapper.queryByConInfo(contractId);
			
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConJkbhPoMapper.insertSelective(productDetail);
				
			}	


		}else if("tb_con_thdb".equals(tarTableName)){//25
			CsmTbConThdbPo productDetail = csmTbConThdbPoMapper.queryByConInfo(contractId);
			// 明细信息
			if (null != productDetail) {
				productDetail.setApplyDetailId(UUIDGenerator.getUUID());
				productDetail.setUpdateTime(null);
				productDetail.setContractId(contractId);
				System.err.println("合同调整完成:[applyDetailId]"+productDetail.getApplyDetailId());
				csmTbConThdbPoMapper.insertSelective(productDetail);
				
			}	

		}else if("tb_con_ckttfprz".equals(tarTableName)) {//26

			
		}else {
			//直接抛异常了，还有啥好说的
			throw new RuntimeException("【合同调整】 的操作失败！！！");
		}
		System.err.println("26种合同明细情况操作完成!");
		// 担保合同信息 com.bos.dataset.crt.TbConSubcontractRel
		List<TbConSubcontractRelPo> conRels = csmTbConSubcontractRelMapper.queryListCsmTbConSubcontractRelByconId(contractId);
		
		
		//根据合同id查询票据信息
		//查存量数据
		 HashMap<String,String> map = new HashMap<String,String>();
		 map.put("htbh", tbConContractInfo.getContractNum());
		 map.put("amountDetailId", tbConContractInfo.getAmountDetailId());
		List<CsmTbBizPjxxApplyPo> pjxxs = csmTbBizPjxxApplyPoMapper.queryListByAmtDetailIdAndHtbh(map);
		
		if(null !=pjxxs && pjxxs.size()>0){
			//新数据
			map.put("amountDetailId", tbConContractInfo.getAmountDetailId());
			//map.put("contractNum", tbConContractInfo.getContractNum());
			map.put("htbh", tbConContractInfo.getContractNum());
			map.put("contractId", tbConContractInfo.getContractId());
			List<CsmTbBizPjxxApplyPo> pjs = csmTbBizPjxxApplyPoMapper.queryListByAmtDetailIdAndHtbh(map);
			if(null !=pjs && pjs.size()>0){
				pjxxs=pjs;
			}
			
		}
		System.err.println("[存量数据]pjxxs:"+pjxxs);
		// 新建合同信息并保存
		// 获取时间com.bos.pub.GitUtil.getBusiDate
		Date date = gitUtils.getBusiDate();
		// 业务合同基本信息
		if(null!=tbConContractInfo.getPartyId()){
			
			tbConContractInfo.setContractId(UUIDGenerator.getUUID());
			tbConContractInfo.setOldContractId(contractId);
			tbConContractInfo.setConStatus("01");
			tbConContractInfo.setCreateTime(date);
			csmTbConContractInfoMapper.insertCsmTbConContractInfoSelective(tbConContractInfo);
			System.err.println("保存[tbConContractInfo]信息成功!"+tbConContractInfo);
			
		}
		
		// 新合同ID
		contractId = tbConContractInfo.getContractId();
		// 合同利率信息
		if (null != tbConLoanrate) {
			tbConLoanrate.setLoanrateId(UUIDGenerator.getUUID());
			tbConLoanrate.setContractId(contractId);
			csmTbConLoanratePoMapper.insertSelective(tbConLoanrate);
			System.err.println("保存合同利率信息成功![tbConLoanrate]"+tbConLoanrate);
		} 
		// 标志信息
		if (null != tbConFlagInfo) {
			tbConFlagInfo.setFlagId(UUIDGenerator.getUUID());
			tbConFlagInfo.setContractId(contractId);
			csmTbConFlagInfoPoMapper.insertSelective(tbConFlagInfo);
			System.err.println("保存标志信息成功![tbConFlagInfo]"+tbConFlagInfo);
		}
		// 通知书文书送达
		if (null != noticeAddrs) {
			noticeAddrs.setUuid(UUIDGenerator.getUUID());
			noticeAddrs.setContractId(contractId);
			csmTbConNoticeAddrsPoMapper.insertSelective(noticeAddrs);
			System.err.println("保存通知文书信息成功[noticeAddrs]"+noticeAddrs);

		}
		// 合同明细下附属信息
		if (null != tbConAttachedInfo) {
			tbConAttachedInfo.setAttached(UUIDGenerator.getUUID());
			tbConAttachedInfo.setContractId(contractId);
			csmTbConAttachedInfoPoMapper.insertCsmTbConAttachedInfoSelective(tbConAttachedInfo);
			System.err.println("保存合同明细下附属信息成功![tbConAttachedInfo]"+tbConAttachedInfo);
	
		}
		// 用款计划
		for (int i = 0; i <= tbConPayoutPlans.size()- 1; i++) {
			CsmTbConPayoutPlanPo tbConPayoutPlan = tbConPayoutPlans.get(i);
			if (null != tbConPayoutPlan) {
				tbConPayoutPlan.setPayoutPlanId(UUIDGenerator.getUUID());
				tbConPayoutPlan.setContractDetailId(contractId);
				csmTbConPayoutPlanPoMapper.insertSelective(tbConPayoutPlan);
				System.err.println("保存用款计划成功!【tbConPayoutPlan】"+tbConPayoutPlan);

			}
		}
		// 还款计划
		for (int i = 0; i <= tbConRepayPlans.size() - 1; i++) {
			CsmTbConRepayPlanPo tbConRepayPlan = tbConRepayPlans.get(i);
			if (null != tbConRepayPlan) {
				tbConRepayPlan.setRepayPlanId(UUIDGenerator.getUUID());
				tbConRepayPlan.setContractId(contractId);
				csmTbConRepayPlanPoMapper.insertSelective(tbConRepayPlan);
				System.err.println("还款计划成功【tbConRepayPlan】"+tbConRepayPlan);
			}
		}
		// 账户信息
		for (int i = 0; i <= tbConZhs.size() - 1; i++) {
			TbConZhPo tbConZh = tbConZhs.get(i);
			if (null != tbConZh) {
				tbConZh.setId(UUIDGenerator.getUUID());
				tbConZh.setContractId(contractId);
				csmTbConZhPoMapper.insertCsmTbConZhSelective(tbConZh);
				System.err.println("账户信息[tbConZh]"+tbConZh);

			}
		}
		// 费用信息
		for (int i = 0; i <= tbConFees.size() - 1; i++) {
			CsmTbConFeePo tbConFee = tbConFees.get(i);
			if (null != tbConFee) {
				tbConFee.setFeeId(UUIDGenerator.getUUID());
				tbConFee.setContractDetailId(contractId);
				csmTbConFeePoMapper.insertSelective(tbConFee);
				System.err.println("费用信息[tbConFee]"+tbConFee);
		
			}
		}
		// 贸易合同信息-----20151016--
		for (int i = 0; i <= myhts.size()- 1; i++) {
			CsmTbBizMyhtxxApplyPo myht = myhts.get(i);
			if (null != myht) {
				myht.setHtId(UUIDGenerator.getUUID());
				myht.setAmountDetailId(contractId);
				csmTbBizMyhtxxApplyPoMapper.insertSelective(myht);
				System.err.println("贸易合同信息[myht]"+myht);
			}
		}
		
		// 明细信息
//		if (null != productDetail.get("applyDetailId")) {
//			productDetail.set("applyDetailId", null);
//			productDetail.set("updateTime", null);
//			productDetail.set("contractId", contractId);
//			DatabaseUtil.insertEntity("default", productDetail);
//		}
		
		//票据信息
		if(null !=pjxxs && pjxxs.size()!=0){
			for (int i = 0; i < pjxxs.size(); i++) {
				 CsmTbBizPjxxApplyPo tbBizPjxxApply = pjxxs.get(i);
				 tbBizPjxxApply.setApplyDetailId(UUIDGenerator.getUUID());
				 tbBizPjxxApply.setJlzt("01");//未提交
				 tbBizPjxxApply.setContractId(contractId);//调整备份
				 csmTbBizPjxxApplyPoMapper.insertSelective(tbBizPjxxApply);
				 System.err.println("票据信息[tbBizPjxxApply]"+tbBizPjxxApply);
			}
		}
		
		for (int i = 0; i < conRels.size(); i++) {
			TbConSubcontractRelPo conRel = conRels.get(i);
			if(conRel.getSubcontractId() == null){
				continue;
			}
			// 担保合同信息
			TbConSubcontractPo conSubcon = csmTbConSubcontractMapper.queryCsmTbConSubcontractPo(conRel.getSubcontractId());

			//备份担保合同
			conSubcon.setSubcontractId(UUIDGenerator.getUUID());
			conSubcon.setSubcontractStatus("01");
			csmTbConSubcontractMapper.insertOneCsmTbConSubcontractSelective(conSubcon);
			System.err.println("备份担保合同完成！【TbConSubcontract】"+conSubcon);

			//新担保合同Id
			String subcontractId = conSubcon.getSubcontractId();
			
			// 保证金协议下附属信息
			if ("03".equals(conSubcon.getSubcontractType())) {
				tbConAttachedInfo.setAttached(UUIDGenerator.getUUID());
				tbConAttachedInfo.setContractId(subcontractId);
				csmTbConAttachedInfoPoMapper.insertCsmTbConAttachedInfoSelective(tbConAttachedInfo);
				System.err.println("[tbConAttachedInfo]"+tbConAttachedInfo);
			}
			//备份担保合同与押品关系信息表
			List<TbConSubGrtRelPo> conSubgrts = csmTbConSubGrtRelMapper.queryListTbConSubGrtRel(conRel.getSubcontractId());

			if(null != conSubgrts && conSubgrts.size()!= 0){
				for (int j = 0; j < conSubgrts.size(); j++) {
					TbConSubGrtRelPo conSubgrt = conSubgrts.get(j);
					//备份新的关系
					conSubgrt.setRelationId(UUIDGenerator.getUUID());
					conSubgrt.setSubcontractId(subcontractId);
					csmTbConSubGrtRelMapper.insertCsmTbConSubGrtRelSelective(conSubgrt);
					System.err.println("备份担保合同与押品关系信息表完成[TbConSubGrtRelPo]"+conSubgrt);
				}
			}		
			
			//备份担保合同与批复关系信息表com.bos.dataset.biz.TbBizSubcontractRel TODO 待讨论是否可行。。。。。
			
			CsmTbBizSubcontractRelPo bizSubRel = csmTbBizSubcontractRelPoMapper.queryOneBySubcontractId(conRel.getSubcontractId());
			
			bizSubRel.setRelationId(UUIDGenerator.getUUID());
			bizSubRel.setCreateTime(date);
			bizSubRel.setSubcontractId(subcontractId);//合同调整提交至流程最后一步修改为新的担保合同Id，如果撤销则修改为原担保合同Id				
			csmTbBizSubcontractRelPoMapper.insertSelective(bizSubRel);
			System.err.println("[TbBizSubcontractRel]"+bizSubRel);


			
			// 备份担保合同附属信息  文书和通知送达信息
			TbConAttachedInfoPo tbSubConAttachedInfo = csmTbConAttachedInfoPoMapper.queryCsmTbConAttachedInfoPo(conRel.getSubcontractId());
			
		
			if (null != tbSubConAttachedInfo) {
				tbSubConAttachedInfo.setAttached(UUIDGenerator.getUUID());
				tbSubConAttachedInfo.setContractId(subcontractId);
				csmTbConAttachedInfoPoMapper.insertCsmTbConAttachedInfoSelective(tbSubConAttachedInfo);
				System.err.println("备份担保合同附属信息成功![tbSubConAttachedInfo]"+tbSubConAttachedInfo);
			}
			CsmTbConNoticeAddrsPo noticeSubConAddrs = csmTbConNoticeAddrsPoMapper.queryByConId(conRel.getSubcontractId());

			if (null != noticeSubConAddrs) {
				noticeSubConAddrs.setUuid(UUIDGenerator.getUUID());
				noticeSubConAddrs.setContractId(subcontractId);
				csmTbConNoticeAddrsPoMapper.insertSelective(noticeSubConAddrs);
				System.err.println("备份文书和通知送达成功！[noticeSubConAddrs]"+noticeSubConAddrs);
			
			}
			
			//备份担保合同信息与贷款合同信息关系表
			conRel.setConSubconId(UUIDGenerator.getUUID());
			conRel.setContractId(contractId);
			conRel.setSubcontractId(subcontractId);
			conRel.setOperationType("01");
			csmTbConSubcontractRelMapper.insertCsmTbConSubcontractRelSelective(conRel);
			System.err.println("备份担保合同信息与贷款合同信息关系表完成[TbConSubcontractRel]"+conRel);
			

		}

		System.err.println("[业务合同调整完成]"+tbConContractInfo);
		return tbConContractInfo;
		
		
		
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CsmTbConCreditInfoPo tzCreditInfo(String contractId) {
		if (null == contractId || "".equals(contractId)) {
			throw new RuntimeException("调整时原合同ID为空");
		}
	
		CsmTbConCreditInfoPo tbConCreditInfo=new CsmTbConCreditInfoPo();
		// 授信协议基本信息
		
		//账户信息
		List<TbConZhPo> tbConZhs = csmTbConZhPoMapper.queryListCsmTbConZhInfo(contractId);
		
		//附属信息
		TbConAttachedInfoPo tbConAttachedInfo = csmTbConAttachedInfoPoMapper.queryCsmTbConAttachedInfoPo(contractId);
		
		//担保合同信息 com.bos.dataset.crt.TbConSubcontractRel
		Map<String,String> map=new HashMap<String,String>();
		map.put("contractId", contractId);
		map.put("ifEffective", "1");
		List<TbConSubcontractRelPo> conRels= csmTbConSubcontractRelMapper.queryListCsmTbConSubcontractRelPo(map);
		
		// 新建合同信息并保存
		// 获取时间com.bos.pub.GitUtil.getBusiDate
		Date date = gitUtils.getBusiDate();
		// 业务合同基本信息
		if (null != tbConCreditInfo.getPartyId()) {
			tbConCreditInfo.setContractId(null);
			tbConCreditInfo.setOldContractId(contractId);
			tbConCreditInfo.setConStatus("01");
			tbConCreditInfo.setCreateTime(date);
			csmTbConCreditInfoPoMapper.insertSelective(tbConCreditInfo);
			
		}
		//新合同id
		contractId = tbConCreditInfo.getContractId();
		
		// 附属信息
		if (null != tbConAttachedInfo.getAttached()) {
			tbConAttachedInfo.setAttached(null);
			tbConAttachedInfo.setContractId(contractId);
			csmTbConAttachedInfoPoMapper.insertCsmTbConAttachedInfoSelective(tbConAttachedInfo);
			
		}
		//账户信息
		for (int i = 0; i <= tbConZhs.size() - 1; i++) {
			TbConZhPo tbConZh = tbConZhs.get(i);
			if (null != tbConZh.getId()) {
				tbConZh.setId(null);
				tbConZh.setContractId(contractId);
				csmTbConZhPoMapper.insertCsmTbConZhSelective(tbConZh);

			}
		}
		
		
		for (int i = 0; i < conRels.size(); i++) {
			TbConSubcontractRelPo conRel = conRels.get(i);
			if(conRel.getSubcontractId() == null){
				continue;
			}
			String oldSubcontractId=conRels.get(i).getSubcontractId();
			// 担保合同信息
			TbConSubcontractPo conSubcon = csmTbConSubcontractMapper.queryCsmTbConSubcontractPo(conRel.getSubcontractId());
	
			//备份担保合同
			conSubcon.setSubcontractId(null);
			conSubcon.setSubcontractStatus("01");
			csmTbConSubcontractMapper.insertOneCsmTbConSubcontractSelective(conSubcon);
	
			//新担保合同Id
			String subcontractId = conSubcon.getSubcontractId();
			String subcontractNum = conSubcon.getSubcontractNum();
			//备份担保合同与押品关系信息表
			List<TbConSubGrtRelPo> conSubgrts = csmTbConSubGrtRelMapper.queryListTbConSubGrtRel(conRel.getSubcontractId());
			
			if(null != conSubgrts && conSubgrts.size() != 0){
				for (int j = 0; j < conSubgrts.size(); j++) {
					TbConSubGrtRelPo conSubgrt = conSubgrts.get(j);
					//备份新的关系
					conSubgrt.setRelationId(null);
					conSubgrt.setSubcontractId(subcontractId);
					csmTbConSubGrtRelMapper.insertCsmTbConSubGrtRelSelective(conSubgrt);
			
				}
			}
			
			//备份担保合同与批复关系信息表com.bos.dataset.biz.TbBizSubcontractRel
			CsmTbBizSubcontractRelPo bizSubRel = csmTbBizSubcontractRelPoMapper.queryOneBySubcontractId(conRel.getSubcontractId());

			bizSubRel.setRelationId(null);
			bizSubRel.setSubcontractId(subcontractId);
			bizSubRel.setCreateTime(date);
			csmTbBizSubcontractRelPoMapper.insertSelective(bizSubRel);
			

			
			//added by shendl 备份担保合同附属信息  文书和通知送达信息
			TbConAttachedInfoPo tbSubConAttachedInfo = csmTbConAttachedInfoPoMapper.queryCsmTbConAttachedInfoPo(conRel.getSubcontractId());
		
			if (null != tbSubConAttachedInfo.getAttached()) {
				tbSubConAttachedInfo.setAttached(null);
				tbSubConAttachedInfo.setContractId(subcontractId);
				csmTbConAttachedInfoPoMapper.insertCsmTbConAttachedInfoSelective(tbSubConAttachedInfo);
			
			}
			CsmTbConNoticeAddrsPo noticeSubConAddrs = csmTbConNoticeAddrsPoMapper.queryByConId(conRel.getSubcontractId());
	
			if (null != noticeSubConAddrs.getUuid()) {
				noticeSubConAddrs.setUuid(null);
				noticeSubConAddrs.setContractId(subcontractId);
				csmTbConNoticeAddrsPoMapper.insertSelective(noticeSubConAddrs);

			}
			//备份担保合同信息与贷款合同信息关系表
			conRel.setConSubconId(null);
			conRel.setContractId(contractId);
			conRel.setSubcontractId(subcontractId);
			conRel.setOperationType("01");
			conRel.setSubcontractIdBackups(oldSubcontractId);
			csmTbConSubcontractRelMapper.insertCsmTbConSubcontractRelSelective(conRel);

		}
		
		System.err.println("[综合授信完成！]"+tbConCreditInfo);
		return tbConCreditInfo;
		
		
	}
	
	
	
	

}
