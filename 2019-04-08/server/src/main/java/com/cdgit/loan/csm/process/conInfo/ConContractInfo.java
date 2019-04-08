package com.cdgit.loan.csm.process.conInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.cdgit.loan.common.util.BeanUtil;
import com.cdgit.loan.common.util.uid.UUID;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.csm.mapper.CsmRuleEngineMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountLoanrateApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizMyhtxxApplyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizProductInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConAttachedInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConBgdkPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConBhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConCktsyhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConCkxyzyhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConContractInfoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConFeePoMapper;
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
import com.cdgit.loan.csm.mapper.CsmTbConMyhtxxPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConNoticeAddrsPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConPayoutPlanPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConRepayPlanPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConThdbPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConWtdkPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConXdzmPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConXmdkcnhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConXwPoMapper;
import com.cdgit.loan.csm.po.CsmTbBizMyhtxxApplyPo;
import com.cdgit.loan.csm.po.CsmTbBizProductInfoPo;
import com.cdgit.loan.csm.po.CsmTbConBgdkPo;
import com.cdgit.loan.csm.po.CsmTbConBhPo;
import com.cdgit.loan.csm.po.CsmTbConCktsyhPo;
import com.cdgit.loan.csm.po.CsmTbConCkxyzyhPo;
import com.cdgit.loan.csm.po.CsmTbConFeePo;
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
import com.cdgit.loan.csm.po.CsmTbConJkxyzyhPo;
import com.cdgit.loan.csm.po.CsmTbConKlyhcdhpPo;
import com.cdgit.loan.csm.po.CsmTbConLdzjPo;
import com.cdgit.loan.csm.po.CsmTbConLoanratePo;
import com.cdgit.loan.csm.po.CsmTbConMyhtxxPo;
import com.cdgit.loan.csm.po.CsmTbConNoticeAddrsPo;
import com.cdgit.loan.csm.po.CsmTbConPayoutPlanPo;
import com.cdgit.loan.csm.po.CsmTbConRepayPlanPo;
import com.cdgit.loan.csm.po.CsmTbConThdbPo;
import com.cdgit.loan.csm.po.CsmTbConWtdkPo;
import com.cdgit.loan.csm.po.CsmTbConXdzmPo;
import com.cdgit.loan.csm.po.CsmTbConXmdkcnhPo;
import com.cdgit.loan.csm.po.CsmTbConXwPo;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbBizAmountLoanrateApprovePo;
import com.cdgit.loan.csm.po.TbConAttachedInfoPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.process.accInfo.ContractApply;
import com.cdgit.loan.csm.process.bizProductDetail.BizProductDetail;
import com.cdgit.loan.csm.pub.gitUtils.GitUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class ConContractInfo {

	@Autowired
	CsmTbConContractInfoMapper csmTbConContractInfoMapper;

	@Autowired
	CsmTbBizProductInfoPoMapper csmTbBizProductInfoPoMapper;

	@Autowired
	BizProductDetail bizProductDetail;

	@Autowired
	CsmTbConLoanratePoMapper csmTbConLoanratePoMapper;

	@Autowired
	CsmTbConAttachedInfoPoMapper csmTbConAttachedInfoPoMapper;

	@Autowired
	CsmTbConLdzjPoMapper csmTbConLdzjPoMapper;

	@Autowired
	CsmTbBizAmountDetailApproveMapper csmTbBizAmountDetailApproveMapper;

	@Autowired
	CsmTbBizAmountLoanrateApproveMapper csmTbBizAmountLoanrateApproveMapper;

	@Autowired
	CsmTbConNoticeAddrsPoMapper csmTbConNoticeAddrsPoMapper;

	@Autowired
	GitUtils gitUtils;

	@Autowired
	CsmTbConRepayPlanPoMapper csmTbConRepayPlanPoMapper;

	@Autowired
	CsmTbConPayoutPlanPoMapper csmTbConPayoutPlanPoMapper;

	@Autowired
	CsmTbConFeePoMapper csmTbConFeePoMapper;

	@Autowired
	CsmTbConMyhtxxPoMapper csmTbConMyhtxxPoMapper;

	@Autowired
	CsmTbBizMyhtxxApplyPoMapper csmTbBizMyhtxxApplyPoMapper;

	@Autowired
	ContractApply contractApply;

	@Autowired
	CsmRuleEngineMapper csmRuleEngineMapper;

	@Autowired
	CsmTbConCktsyhPoMapper csmTbConCktsyhPoMapper;

	@Autowired
	CsmTbConJkxyzPoMapper csmTbConJkxyzPoMapper;

	@Autowired
	CsmTbConJkbhPoMapper csmTbConJkbhPoMapper;

	@Autowired
	CsmTbConXmdkcnhPoMapper csmTbConXmdkcnhPoMapper;

	@Autowired
	CsmTbConThdbPoMapper csmTbConThdbPoMapper;

	@Autowired
	CsmTbConWtdkPoMapper csmTbConWtdkPoMapper;

	@Autowired
	CsmTbConHptxPoMapper csmTbConHptxPoMapper;

	@Autowired
	CsmTbConKlyhcdhpPoMapper csmTbConKlyhcdhpPoMapper;

	@Autowired
	CsmTbConGjfftPoMapper csmTbConGjfftPoMapper;

	@Autowired
	CsmTbConGjxyzkzPoMapper csmTbConGjxyzkzPoMapper;

	@Autowired
	CsmTbConBgdkPoMapper csmTbConBgdkPoMapper;

	@Autowired
	CsmTbConJkttyhPoMapper csmTbConJkttyhPoMapper;

	@Autowired
	CsmTbConJkdfPoMapper csmTbConJkdfPoMapper;

	@Autowired
	CsmTbConXwPoMapper csmTbConXwPoMapper;

	@Autowired
	CsmTbConCkxyzyhPoMapper csmTbConCkxyzyhPoMapper;

	@Autowired
	CsmTbConBhPoMapper csmTbConBhPoMapper;

	@Autowired
	CsmTbConXdzmPoMapper csmTbConXdzmPoMapper;

	@Autowired
	CsmTbConGdzcdkPoMapper csmTbConGdzcdkPoMapper;

	@Autowired
	CsmTbConFrzhtzPoMapper csmTbConFrzhtzPoMapper;

	@Autowired
	CsmTbConGnblPoMapper csmTbConGnblPoMapper;

	@Autowired
	CsmTbConJkdsyhPoMapper csmTbConJkdsyhPoMapper;

	@Autowired
	CsmTbConGjxyzdbdkPoMapper csmTbConGjxyzdbdkPoMapper;

	@Autowired
	CsmTbConJkxyzyhPoMapper csmTbConJkxyzyhPoMapper;

	@Autowired
	CsmTbConGnxyzPoMapper csmTbConGnxyzPoMapper;

	/**
	 * 保存合同 明细信息
	 * 
	 * @param map
	 * @return
	 */
	public String saveConContractDetailInfo(HashMap<String, Object> map) {

		String msg = ""; // 该方法返回默认的报错信息
		// 参数op的含义 ：1.对公合同明细,2.小微合同明细
		String op = (String) map.get("op");
		String contractId = (String) map.get("contractId");
		String productType = (String) map.get("productType");
		String amountDetailId = (String) map.get("amountDetailId");

		// 通知文书送达
		CsmTbConNoticeAddrsPo notice = (CsmTbConNoticeAddrsPo) map.get("notice");
		CsmTbConLdzjPo conDetail = (CsmTbConLdzjPo) map.get("conDetail");

		// 利率信息
		CsmTbConLoanratePo loanrate = (CsmTbConLoanratePo) map.get("loanrate");

		TbConAttachedInfoPo tbConAttachedInfo = (TbConAttachedInfoPo) map.get("tbConAttachedInfo");

		// 费用计划
		List<CsmTbConFeePo> fees = (List<CsmTbConFeePo>) map.get("fees");

		// TODO 注意下这里是大写的 提款计划
		List<CsmTbConPayoutPlanPo> payoutPlans = (List<CsmTbConPayoutPlanPo>) map.get("PayoutPlans");

		// 还款计划
		List<CsmTbConRepayPlanPo> repayPlans = (List<CsmTbConRepayPlanPo>) map.get("repayPlans");

		List<CsmTbBizMyhtxxApplyPo> myhtxxs = (List<CsmTbBizMyhtxxApplyPo>) map.get("myhtxxs");

		TbConContractInfoPo conInfo = (TbConContractInfoPo) map.get("tbConContractInfo");

		if (null != conInfo) {
			if (!"2".equals(op)) {
				// 明细部分保存到合同表
				conInfo.setPayWay(conDetail.getPayWay());
				conInfo.setPayDepend1(conDetail.getPayDepend1());
				conInfo.setPayDepend2(conDetail.getPayDepend2());
				conInfo.setPayDepend3(conDetail.getPayDepend3());
				// TODO 这个明细表tb_con_ldzj 中并没有这个 字段Prepayment_Penalty
				// conInfo.setPrepaymentPenalty(conDetail.getp);

				conInfo.setPrepayMakeupRate(conDetail.getPrepayMakeupRate());
				conInfo.setLeastPrepayAmount(conDetail.getLeastPrepayAmount());
				conInfo.setPrepayJs(conDetail.getPrepayJs());

			}

			// if(conDetail.getBzjbl())
			try {
				csmTbConContractInfoMapper.updateByPrimaryKeySelective(conInfo.getContractId());
			} catch (Exception e) {
				msg = "保存失败";
				throw new RuntimeException(e);
			}

		}
		// 获取营业信息
		Date handlingDate = gitUtils.getBusiDate();

		loanrate.setContractId(contractId);
		loanrate.setUpdateTime(handlingDate);

		if (null == loanrate.getCreateTime()) {
			loanrate.setCreateTime(handlingDate);
		}

		try {
			// 保存利率信息
			csmTbConLoanratePoMapper.updateByPrimaryKeySelective(loanrate);

		} catch (Exception e) {
			msg = "保存失败";
			throw new RuntimeException(e);
		}

		if (null != tbConAttachedInfo) {
			tbConAttachedInfo.setContractId(contractId);
			try {
				// 保存附属信息
				csmTbConAttachedInfoPoMapper.updateCsmTbConAttachedInfoSelective(tbConAttachedInfo);

			} catch (Exception e) {
				msg = "保存失败";
				throw new RuntimeException(e);
			}

		}

		if (null != myhtxxs) {
			// 贸易合同信息中的amountDetailId 变更为contractId

			for (CsmTbBizMyhtxxApplyPo myhtxx : myhtxxs) {

				if (null == myhtxx.getCreateTime()) {
					myhtxx.setCreateTime(handlingDate);
				}

				myhtxx.setUpdateTime(handlingDate);
				myhtxx.setAmountDetailId(contractId);

				try {
					// 保存贸易合同信息
					csmTbBizMyhtxxApplyPoMapper.updateByPrimaryKeySelective(myhtxx);

				} catch (Exception e) {
					msg = "保存失败";
					throw new RuntimeException(e);
				}

			}

		}

		// 由于国内保理申请就填费率，关联键改为存amountDetailId--变更为存合同id
		if (null != fees) {

			for (CsmTbConFeePo fee : fees) {

				fee.setUpdateTime(handlingDate);
				fee.setContractDetailId(contractId);

				if (null == fee.getCreateTime()) {
					fee.setCreateTime(handlingDate);
				}

				try {
					// 保存费率信息
					csmTbConFeePoMapper.updateByPrimaryKeySelective(fee);
				} catch (Exception e) {
					msg = "保存失败";
					throw new RuntimeException(e);
				}

			}
		}

		if (null != repayPlans) {

			for (CsmTbConRepayPlanPo repayPlan : repayPlans) {

				repayPlan.setContractId(contractId);
				repayPlan.setUpdateTime(handlingDate);

				if (null == repayPlan.getCreateTime()) {
					repayPlan.setCreateTime(handlingDate);
				}

				try {
					// 保存还款计划
					csmTbConRepayPlanPoMapper.updateByPrimaryKeySelective(repayPlan);

				} catch (Exception e) {
					msg = "保存失败";
					throw new RuntimeException(e);
				}
			}

			// 期数重新排序
			String result = contractApply.aftDeleteRepayPlan(contractId);
			if (result.equals("2")) {
				msg = "保存失败";
			}

		}

		if (null != payoutPlans) {

			for (CsmTbConPayoutPlanPo payoutPlan : payoutPlans) {
				payoutPlan.setContractDetailId(contractId);
				payoutPlan.setUpdateTime(handlingDate);

				if (null == payoutPlan.getCreateTime()) {
					payoutPlan.setCreateTime(handlingDate);
				}

				try {
					// 保存提款计划
					csmTbConPayoutPlanPoMapper.updateByPrimaryKeySelective(payoutPlan);
				} catch (Exception e) {
					msg = "保存失败";
					throw new RuntimeException(e);
				}

			}

		}

		if (null != notice) {
			notice.setCreateTime(handlingDate);
			notice.setUpdateTime(handlingDate);
			try {
				// 保存通知书信息
				csmTbConNoticeAddrsPoMapper.updateByPrimaryKeySelective(notice);
			} catch (Exception e) {
				msg = "保存失败";
				throw new RuntimeException(e);

			}

		}

		if (null != conDetail) {
			String ruleMsg = ruleCheck(contractId);
			if (!"".equals(ruleMsg)) {
				msg = "保存失败！" + ruleMsg;
				// throw new RuntimeException(msg);
			}

			conDetail.setContractId(contractId);
			conDetail.setUpdateTime(handlingDate);

			if (null != msg) {
				conDetail.setUpdateTime(null);
			}

			CsmTbBizProductInfoPo productInfo = getProductInfo(productType);

			// 转化业务品种
			// 接下来有26种表的情况了
			String tableName = productInfo.getTableName();
			tableName = tableName.replace("biz", "con").replace("_apply", "");

			if ("tb_con_cktsyh".equals(tableName)) { // 1 17-出口托收押汇批复表

				CsmTbConCktsyhPo csmTbConCktsyhPo = new CsmTbConCktsyhPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConCktsyhPo, true);

				if (csmTbConCktsyhPo.getCreateTime() == null) {
					csmTbConCktsyhPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[出口托收押汇批复表 tb_con_cktsyh] " + csmTbConCktsyhPo);
					if ("".equals(csmTbConCktsyhPo.getApplyDetailId()) || null == csmTbConCktsyhPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConCktsyhPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConCktsyhPoMapper.insertSelective(csmTbConCktsyhPo);
					} else {
						csmTbConCktsyhPoMapper.updateByPrimaryKeySelective(csmTbConCktsyhPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_jkxyz".equals(tableName)) {// 2 21-进口信用证批复
				CsmTbConJkxyzPo csmTbConJkxyzPo = new CsmTbConJkxyzPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConJkxyzPo, true);

				if (csmTbConJkxyzPo.getCreateTime() == null) {
					csmTbConJkxyzPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[进口信用证批复表   tb_con_jkxyz] " + csmTbConJkxyzPo);
					if ("".equals(csmTbConJkxyzPo.getApplyDetailId()) || null == csmTbConJkxyzPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConJkxyzPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConJkxyzPoMapper.insertSelective(csmTbConJkxyzPo);
					} else {
						csmTbConJkxyzPoMapper.updateByPrimaryKeySelective(csmTbConJkxyzPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_jkbh".equals(tableName)) {// 3 22-进口保函批复

				CsmTbConJkbhPo csmTbConJkbhPo = new CsmTbConJkbhPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConJkbhPo, true);

				if (csmTbConJkbhPo.getCreateTime() == null) {
					csmTbConJkbhPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[进口保函批复表   tb_con_jkbh] " + csmTbConJkbhPo);
					if ("".equals(csmTbConJkbhPo.getApplyDetailId()) || null == csmTbConJkbhPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConJkbhPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConJkbhPoMapper.insertSelective(csmTbConJkbhPo);
					} else {
						csmTbConJkbhPoMapper.updateByPrimaryKeySelective(csmTbConJkbhPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_xmdkcnh".equals(tableName)) {// 4 24-项目贷款承诺函批复

				CsmTbConXmdkcnhPo csmTbConXmdkcnhPo = new CsmTbConXmdkcnhPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConXmdkcnhPo, true);

				if (csmTbConXmdkcnhPo.getCreateTime() == null) {
					csmTbConXmdkcnhPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[项目贷款承诺函批复表   tb_con_xmdkcnh] " + csmTbConXmdkcnhPo);
					if ("".equals(csmTbConXmdkcnhPo.getApplyDetailId())
							|| null == csmTbConXmdkcnhPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConXmdkcnhPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConXmdkcnhPoMapper.insertSelective(csmTbConXmdkcnhPo);
					} else {
						csmTbConXmdkcnhPoMapper.updateByPrimaryKeySelective(csmTbConXmdkcnhPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_thdb".equals(tableName)) {// 5 32-提货担保合同
				CsmTbConThdbPo csmTbConThdbPo = new CsmTbConThdbPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConThdbPo, true);

				if (csmTbConThdbPo.getCreateTime() == null) {
					csmTbConThdbPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[提货担保合同表   tb_con_thdb] " + csmTbConThdbPo);
					if ("".equals(csmTbConThdbPo.getApplyDetailId()) || null == csmTbConThdbPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConThdbPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConThdbPoMapper.insertSelective(csmTbConThdbPo);
					} else {
						csmTbConThdbPoMapper.updateByPrimaryKeySelective(csmTbConThdbPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_wtdk".equals(tableName)) {// 6 11-委托贷款批复

				CsmTbConWtdkPo csmTbConWtdkPo = new CsmTbConWtdkPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConWtdkPo, true);

				if (csmTbConWtdkPo.getCreateTime() == null) {
					csmTbConWtdkPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[委托贷款批复表   tb_con_wtdk] " + csmTbConWtdkPo);
					if ("".equals(csmTbConWtdkPo.getApplyDetailId()) || null == csmTbConWtdkPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConWtdkPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConWtdkPoMapper.insertSelective(csmTbConWtdkPo);
					} else {
						csmTbConWtdkPoMapper.updateByPrimaryKeySelective(csmTbConWtdkPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_hptx".equals(tableName)) {// 7 07-汇票贴现批复
				CsmTbConHptxPo csmTbConHptxPo = new CsmTbConHptxPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConHptxPo, true);

				if (csmTbConHptxPo.getCreateTime() == null) {
					csmTbConHptxPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[汇票贴现批复表   tb_con_hptx] " + csmTbConHptxPo);
					if ("".equals(csmTbConHptxPo.getApplyDetailId()) || null == csmTbConHptxPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConHptxPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConHptxPoMapper.insertSelective(csmTbConHptxPo);
					} else {
						csmTbConHptxPoMapper.updateByPrimaryKeySelective(csmTbConHptxPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_klyhcdhp".equals(tableName)) {// 8 12-开立银行承兑汇票批复

				CsmTbConKlyhcdhpPo csmTbConKlyhcdhpPo = new CsmTbConKlyhcdhpPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConKlyhcdhpPo, true);

				if (csmTbConKlyhcdhpPo.getCreateTime() == null) {
					csmTbConKlyhcdhpPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[开立银行承兑汇票批复表   tb_con_klyhcdhp] " + csmTbConKlyhcdhpPo);
					if ("".equals(csmTbConKlyhcdhpPo.getApplyDetailId())
							|| null == csmTbConKlyhcdhpPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConKlyhcdhpPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConKlyhcdhpPoMapper.insertSelective(csmTbConKlyhcdhpPo);
					} else {
						csmTbConKlyhcdhpPoMapper.updateByPrimaryKeySelective(csmTbConKlyhcdhpPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_gjfft".equals(tableName)) {// 9 28-国际福费廷
				CsmTbConGjfftPo csmTbConGjfftPo = new CsmTbConGjfftPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConGjfftPo, true);

				if (csmTbConGjfftPo.getCreateTime() == null) {
					csmTbConGjfftPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[28-国际福费廷表   tb_con_gjfft] " + csmTbConGjfftPo);
					if ("".equals(csmTbConGjfftPo.getApplyDetailId()) || null == csmTbConGjfftPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConGjfftPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConGjfftPoMapper.insertSelective(csmTbConGjfftPo);
					} else {
						csmTbConGjfftPoMapper.updateByPrimaryKeySelective(csmTbConGjfftPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_gjxyzkz".equals(tableName)) {// 10 unkown table
															// name
				CsmTbConGjxyzkzPo csmTbConGjxyzkzPo = new CsmTbConGjxyzkzPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConGjxyzkzPo, true);

				if (csmTbConGjxyzkzPo.getCreateTime() == null) {
					csmTbConGjxyzkzPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[tb_con_gjxyzkz] " + csmTbConGjxyzkzPo);
					if ("".equals(csmTbConGjxyzkzPo.getApplyDetailId())
							|| null == csmTbConGjxyzkzPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConGjxyzkzPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConGjxyzkzPoMapper.insertSelective(csmTbConGjxyzkzPo);
					} else {
						csmTbConGjxyzkzPoMapper.updateByPrimaryKeySelective(csmTbConGjxyzkzPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_bgdk".equals(tableName)) {// 11 10-并购贷款批复

				CsmTbConBgdkPo csmTbConBgdkPo = new CsmTbConBgdkPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConBgdkPo, true);

				if (csmTbConBgdkPo.getCreateTime() == null) {
					csmTbConBgdkPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[10-并购贷款批复 tb_con_bgdk] " + csmTbConBgdkPo);
					if ("".equals(csmTbConBgdkPo.getApplyDetailId()) || null == csmTbConBgdkPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConBgdkPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConBgdkPoMapper.insertSelective(csmTbConBgdkPo);
					} else {
						csmTbConBgdkPoMapper.updateByPrimaryKeySelective(csmTbConBgdkPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_gnxyz".equals(tableName)) {// 12 14-国内信用证批复

				CsmTbConGnxyzPo csmTbConGnxyzPo = new CsmTbConGnxyzPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConGnxyzPo, true);

				if (csmTbConGnxyzPo.getCreateTime() == null) {
					csmTbConGnxyzPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[国内信用证批复表 tb_con_gnxyz] " + csmTbConGnxyzPo);
					if ("".equals(csmTbConGnxyzPo.getApplyDetailId()) || null == csmTbConGnxyzPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConGnxyzPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConGnxyzPoMapper.insertSelective(csmTbConGnxyzPo);
					} else {
						csmTbConGnxyzPoMapper.updateByPrimaryKeySelective(csmTbConGnxyzPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_jkttyh".equals(tableName)) {// 13 19-进口T/T押汇批复

				CsmTbConJkttyhPo csmTbConJkttyhPo = new CsmTbConJkttyhPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConJkttyhPo, true);

				if (csmTbConJkttyhPo.getCreateTime() == null) {
					csmTbConJkttyhPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[进口T/T押汇批复表 tb_con_jkttyh] " + csmTbConJkttyhPo);
					if ("".equals(csmTbConJkttyhPo.getApplyDetailId()) || null == csmTbConJkttyhPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConJkttyhPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConJkttyhPoMapper.insertSelective(csmTbConJkttyhPo);
					} else {
						csmTbConJkttyhPoMapper.updateByPrimaryKeySelective(csmTbConJkttyhPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_jkdf".equals(tableName)) {// 14 29-进口代付合同

				CsmTbConJkdfPo csmTbConJkdfPo = new CsmTbConJkdfPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConJkdfPo, true);

				if (csmTbConJkdfPo.getCreateTime() == null) {
					csmTbConJkdfPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[进口代付合同表  tb_con_jkdf] " + csmTbConJkdfPo);
					if ("".equals(csmTbConJkdfPo.getApplyDetailId()) || null == csmTbConJkdfPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConJkdfPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConJkdfPoMapper.insertSelective(csmTbConJkdfPo);
					} else {
						csmTbConJkdfPoMapper.updateByPrimaryKeySelective(csmTbConJkdfPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_xw".equals(tableName)) {// 15 25-小企业贷款合同
				CsmTbConXwPo csmTbConXwPo = new CsmTbConXwPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConXwPo, true);

				if (csmTbConXwPo.getCreateTime() == null) {
					csmTbConXwPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[小企业贷款合同表  tb_con_xw] " + csmTbConXwPo);
					if ("".equals(csmTbConXwPo.getApplyDetailId()) || null == csmTbConXwPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConXwPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConXwPoMapper.insertSelective(csmTbConXwPo);
					} else {
						csmTbConXwPoMapper.updateByPrimaryKeySelective(csmTbConXwPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_ldzj".equals(tableName)) {// 16 01-流动资金贷款批复

				CsmTbConLdzjPo csmTbConLdzjPo = new CsmTbConLdzjPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConLdzjPo, true);

				if (csmTbConLdzjPo.getCreateTime() == null) {
					csmTbConLdzjPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[流动资金贷款批复表  tb_con_ldzj] " + csmTbConLdzjPo);
					if ("".equals(csmTbConLdzjPo.getApplyDetailId()) || null == csmTbConLdzjPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConLdzjPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConLdzjPoMapper.insertSelective(csmTbConLdzjPo);
					} else {
						csmTbConLdzjPoMapper.updateByPrimaryKeySelective(csmTbConLdzjPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_ckxyzyh".equals(tableName)) {// 17 15-出口信用证押汇批复

				CsmTbConCkxyzyhPo csmTbConCkxyzyhPo = new CsmTbConCkxyzyhPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConCkxyzyhPo, true);

				if (csmTbConCkxyzyhPo.getCreateTime() == null) {
					csmTbConCkxyzyhPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[出口信用证押汇批复表  tb_con_ckxyzyh] " + csmTbConCkxyzyhPo);
					if ("".equals(csmTbConCkxyzyhPo.getApplyDetailId())
							|| null == csmTbConCkxyzyhPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConCkxyzyhPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConCkxyzyhPoMapper.insertSelective(csmTbConCkxyzyhPo);
					} else {
						csmTbConCkxyzyhPoMapper.updateByPrimaryKeySelective(csmTbConCkxyzyhPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_bh".equals(tableName)) {// 18 13-保函批复

				CsmTbConBhPo csmTbConBhPo = new CsmTbConBhPo();
				BeanUtil.copyBeanProperties(conDetail, csmTbConBhPo, true);

				if (csmTbConBhPo.getCreateTime() == null) {
					csmTbConBhPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[保函批复表  tb_con_bh] " + csmTbConBhPo);
					if ("".equals(csmTbConBhPo.getApplyDetailId()) || null == csmTbConBhPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConBhPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConBhPoMapper.insertSelective(csmTbConBhPo);
					} else {
						csmTbConBhPoMapper.updateByPrimaryKeySelective(csmTbConBhPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_xdzm".equals(tableName)) {// 19 23-信贷证明批复

				CsmTbConXdzmPo csmTbConXdzmPo = new CsmTbConXdzmPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConXdzmPo, true);

				if (csmTbConXdzmPo.getCreateTime() == null) {
					csmTbConXdzmPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[信贷证明批复表  tb_con_xdzm] " + csmTbConXdzmPo);
					if ("".equals(csmTbConXdzmPo.getApplyDetailId()) || null == csmTbConXdzmPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConXdzmPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConXdzmPoMapper.insertSelective(csmTbConXdzmPo);
					} else {
						csmTbConXdzmPoMapper.updateByPrimaryKeySelective(csmTbConXdzmPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_gdzcdk".equals(tableName)) {// 20 04-固定资产贷款批复

				CsmTbConGdzcdkPo csmTbConGdzcdkPo = new CsmTbConGdzcdkPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConGdzcdkPo, true);

				if (csmTbConGdzcdkPo.getCreateTime() == null) {
					csmTbConGdzcdkPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[固定资产贷款批复表  tb_con_gdzcdk] " + csmTbConGdzcdkPo);
					if ("".equals(csmTbConGdzcdkPo.getApplyDetailId()) || null == csmTbConGdzcdkPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConGdzcdkPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConGdzcdkPoMapper.insertSelective(csmTbConGdzcdkPo);
					} else {
						csmTbConGdzcdkPoMapper.updateByPrimaryKeySelective(csmTbConGdzcdkPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_frzhtz".equals(tableName)) {// 21 02-法人账户透支批复

				CsmTbConFrzhtzPo csmTbConFrzhtzPo = new CsmTbConFrzhtzPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConFrzhtzPo, true);

				if (csmTbConFrzhtzPo.getCreateTime() == null) {
					csmTbConFrzhtzPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[法人账户透支批复表  tb_con_frzhtz] " + csmTbConFrzhtzPo);
					if ("".equals(csmTbConFrzhtzPo.getApplyDetailId()) || null == csmTbConFrzhtzPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConFrzhtzPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConFrzhtzPoMapper.insertSelective(csmTbConFrzhtzPo);
					} else {
						csmTbConFrzhtzPoMapper.updateByPrimaryKeySelective(csmTbConFrzhtzPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_gnbl".equals(tableName)) {// 22 09-国内保理批复

				CsmTbConGnblPo csmTbConGnblPo = new CsmTbConGnblPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConGnblPo, true);

				if (csmTbConGnblPo.getCreateTime() == null) {
					csmTbConGnblPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[国内保理批复表  tb_con_gnbl] " + csmTbConGnblPo);
					if ("".equals(csmTbConGnblPo.getApplyDetailId()) || null == csmTbConGnblPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConGnblPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConGnblPoMapper.insertSelective(csmTbConGnblPo);
					} else {
						csmTbConGnblPoMapper.updateByPrimaryKeySelective(csmTbConGnblPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_jkdsyh".equals(tableName)) {// 23 20-进口代收押汇批复
				CsmTbConJkdsyhPo csmTbConJkdsyhPo = new CsmTbConJkdsyhPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConJkdsyhPo, true);

				if (csmTbConJkdsyhPo.getCreateTime() == null) {
					csmTbConJkdsyhPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[进口代收押汇批复表  tb_con_jkdsyh] " + csmTbConJkdsyhPo);
					if ("".equals(csmTbConJkdsyhPo.getApplyDetailId()) || null == csmTbConJkdsyhPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConJkdsyhPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConJkdsyhPoMapper.insertSelective(csmTbConJkdsyhPo);
					} else {
						csmTbConJkdsyhPoMapper.updateByPrimaryKeySelective(csmTbConJkdsyhPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_gjxyzdbdk".equals(tableName)) {// 24
																// 30-国际信用证打包贷款合同

				CsmTbConGjxyzdbdkPo csmTbConGjxyzdbdkPo = new CsmTbConGjxyzdbdkPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConGjxyzdbdkPo, true);

				if (csmTbConGjxyzdbdkPo.getCreateTime() == null) {
					csmTbConGjxyzdbdkPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[国际信用证打包贷款合同表  tb_con_gjxyzdbdk] " + csmTbConGjxyzdbdkPo);
					if ("".equals(csmTbConGjxyzdbdkPo.getApplyDetailId())
							|| null == csmTbConGjxyzdbdkPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConGjxyzdbdkPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConGjxyzdbdkPoMapper.insertSelective(csmTbConGjxyzdbdkPo);
					} else {
						csmTbConGjxyzdbdkPoMapper.updateByPrimaryKeySelective(csmTbConGjxyzdbdkPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_jkxyzyh".equals(tableName)) {// 25 18-进口信用证押汇批复
				CsmTbConJkxyzyhPo csmTbConJkxyzyhPo = new CsmTbConJkxyzyhPo();

				BeanUtil.copyBeanProperties(conDetail, csmTbConJkxyzyhPo, true);

				if (csmTbConJkxyzyhPo.getCreateTime() == null) {
					csmTbConJkxyzyhPo.setCreateTime(handlingDate);
				}

				try {

					System.err.println("[进口信用证押汇批复表  tb_con_jkxyzyh] " + csmTbConJkxyzyhPo);
					if ("".equals(csmTbConJkxyzyhPo.getApplyDetailId())
							|| null == csmTbConJkxyzyhPo.getApplyDetailId()) {
						String applyDetId = UUIDGenerator.getUUID();
						csmTbConJkxyzyhPo.setApplyDetailId(applyDetId);
						System.err.println("apply_detail_id :" + applyDetId);
						csmTbConJkxyzyhPoMapper.insertSelective(csmTbConJkxyzyhPo);
					} else {
						csmTbConJkxyzyhPoMapper.updateByPrimaryKeySelective(csmTbConJkxyzyhPo);
					}

				} catch (Exception e) {
					msg = "保存失败";
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					e.printStackTrace();

				}

			} else if ("tb_con_ckttfprz".equals(tableName)) {// 26 TODO
																// 表tb_con_ckttfprz不存在

			} else {// 27
				msg = "保存失败";
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				// throw new RuntimeException("保存合同明细信息失败！");
			}

		}

		return msg;
	}

	public String ruleCheck(String contractId) {
		String msg = "";
		Integer res = new Integer(0);
		// 还款计划时间重复
		Integer res1 = csmRuleEngineMapper.ruleRCON_0085(contractId);
		if (res.equals(res1)) {
			msg = "【RCON_0085】还款计划不同期次还款日期不能一样";
		}

		if ("".equals(msg)) {
			// 还款总金额校验
			Integer res2 = csmRuleEngineMapper.ruleRCON_0053(contractId);
			if (res.equals(res2)) {
				msg = "【RCON_0053】还款计划总金额不等于合同金额";
			}
		}

		if ("".equals(msg)) {
			// 最后一期日期校验
			Integer res3 = csmRuleEngineMapper.ruleRCON_0054(contractId);
			if (res.equals(res3)) {
				msg = "【RCON_0054】还款计划最后一期止期必须和合同止期一样";
			}

		}

		if ("".equals(msg)) {
			// 提款总金额校验
			Integer res4 = csmRuleEngineMapper.ruleRCON_0052(contractId);
			if (res4.equals(res)) {
				msg = "【RCON_0052】提款计划总金额不等于合同金额";
			}

		}

		if ("".equals(msg)) {
			// 还款计划日期
			Integer res5 = csmRuleEngineMapper.ruleRCON_0055(contractId);
			if (res5.equals(res)) {
				msg = "【RCON_0055】还款计划日期必须在合同起期和止期之间";
			}

		}

		if ("".equals(msg)) {
			// 提款计划日期
			Integer res6 = csmRuleEngineMapper.ruleRCON_0056(contractId);
			if (res6.equals(res)) {
				msg = "【RCON_0056】提款计划日期必须在合同起期和止期之间";
			}

		}

		return msg;
	}

	/**
	 * 查询品种配置信息
	 * 
	 * @param productCd
	 * @return
	 */
	public CsmTbBizProductInfoPo getProductInfo(String productCd) {
		CsmTbBizProductInfoPo TbBizProductInfo = csmTbBizProductInfoPoMapper.queryByProductType(productCd);
		return TbBizProductInfo;

	}

	/**
	 * 删除还款计划列表/提款计划表/费率表数据/贸易合同信息
	 * 
	 * @param repayPlanId
	 * @param deleteType
	 */
	public void deleteRepayPlan(String repayPlanId, String deleteType) {
		System.err.println("deleteRepayPlan invoke...");
		// 删除还款计划

		CsmTbConRepayPlanPo TbConRepayPlan = csmTbConRepayPlanPoMapper.selectByPrimaryKey(repayPlanId);
		if (null != TbConRepayPlan) {
			csmTbConRepayPlanPoMapper.deleteByPrimaryKey(repayPlanId);
		}

		if ("2".equals(deleteType)) {
			// 删除提款计划
			CsmTbConPayoutPlanPo TbConPayoutPlan = csmTbConPayoutPlanPoMapper.selectByPrimaryKey(repayPlanId);
			if (null != TbConPayoutPlan) {
				csmTbConPayoutPlanPoMapper.deleteByPrimaryKey(repayPlanId);
			}

		}

		if ("3".equals(deleteType)) {
			// 删除费率
			CsmTbConFeePo TbConFee = csmTbConFeePoMapper.selectByPrimaryKey(repayPlanId);
			if (null != TbConFee) {
				csmTbConFeePoMapper.deleteByPrimaryKey(repayPlanId);
			}
		}

		if ("4".equals(deleteType)) {
			// 删除贸易合同信息

			CsmTbConMyhtxxPo TbConMyhtxx = csmTbConMyhtxxPoMapper.selectByPrimaryKey(repayPlanId);
			if (null != TbConMyhtxx) {
				csmTbConMyhtxxPoMapper.deleteByPrimaryKey(repayPlanId);
			}

		}

		if ("5".equals(deleteType)) {
			// 删除申请贸易合同信息
			CsmTbBizMyhtxxApplyPo TbBizMyhtxxApply = csmTbBizMyhtxxApplyPoMapper.selectByPrimaryKey(repayPlanId);
			if (TbBizMyhtxxApply != null) {
				csmTbBizMyhtxxApplyPoMapper.deleteByPrimaryKey(repayPlanId);
			}

		}

	}

	/**
	 * 根据合同ID初始化查询合同明细页面 1.先给conDetail赋初值为流动资金否则给明细合同id赋值会报错
	 * 2.根据贷种查出要查询的实体名称，由于品种信息表存的都是申请表实体， 需要将名称转换成合同的，再查询合同明细
	 * 
	 * @param contractId
	 * @param productType
	 * @return
	 */
	public HashMap<String, Object> getConDetailInfoByContractId(String contractId, String productType) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String tableName = getProductInfo(productType).getTableName();
		tableName = tableName.replace("biz", "con");
		tableName = tableName.replace("_apply", "");
		System.err.println("tableName " + tableName);
		// String entityName=getProductInfo(productType).getEntityName();
		// entityName=entityName.replace("biz", "crt");
		// entityName=entityName.replace("Biz", "Con");
		// entityName=entityName.replace("Apply", "");

		CsmTbConLdzjPo conDetail = csmTbConLdzjPoMapper.queryByConInfo(contractId);

		// 查询合同利率信息

		CsmTbConLoanratePo loanrate = csmTbConLoanratePoMapper.queryTbConLoanratePoByConId(contractId);
		// 查询合同附属信息

		TbConAttachedInfoPo tbConAttachedInfo = csmTbConAttachedInfoPoMapper.queryCsmTbConAttachedInfoPo(contractId);
		// 查询合同基本信息
		TbConContractInfoPo tbConContractInfo = csmTbConContractInfoMapper.selectByPrimaryKey(contractId);
		// 查询合同通知书
		CsmTbConNoticeAddrsPo notice = csmTbConNoticeAddrsPoMapper.queryByConId(contractId);

		// 查询批复利率信息
		TbBizAmountLoanrateApprovePo apvrate = csmTbBizAmountLoanrateApproveMapper
				.queryOneCsmTbBizAmountLoanrateApprove(tbConContractInfo.getAmountDetailId());
		// 查询批复明细

		TbBizAmountDetailApprovePo tbBizAmountDetailApprove = csmTbBizAmountDetailApproveMapper
				.queryOneTbBizAmountDetailApproveByAmountDetailId(tbConContractInfo.getAmountDetailId());
		// 获取营业时间
		Date handlingDate = gitUtils.getBusiDate();

		hashMap.put("conDetail", conDetail);
		hashMap.put("loanrate", loanrate);
		hashMap.put("tbConAttachedInfo", tbConAttachedInfo);
		hashMap.put("tbConContractInfo", tbConContractInfo);
		hashMap.put("notice", notice);
		hashMap.put("apvrate", apvrate);
		hashMap.put("tbBizAmountDetailApprove", tbBizAmountDetailApprove);

		return hashMap;
	}

	// 根据合同id查询合同明细页面
	public Map<String, Object> getDetailJspByContractId(String contractId) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		TbConContractInfoPo tbConContractInfo = csmTbConContractInfoMapper.selectByPrimaryKey(contractId);
		String cycleIndCon = tbConContractInfo.getCycleIndCon();
		String productType = tbConContractInfo.getProductType();
		CsmTbBizProductInfoPo tbBizProductInfo = bizProductDetail.getProductInfo(productType);
		String jspAddress = tbBizProductInfo.getJspName();

		String tableName = tbBizProductInfo.getTableName().replace("biz", "con").replace("_apply", "");

		map.put("jspAddress", jspAddress);
		map.put("productType", productType);
		map.put("tableName", tableName);
		map.put("cycleIndCon", cycleIndCon);
		return map;

	}

	/**
	 * 根据contractId查询费率信息
	 * 
	 * @param contractId
	 * @return
	 */
	public PageInfo<CsmTbConFeePo> queryFee(Map map) {
		String contractId = (String) map.get("contractId");
		// 引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));

		List<CsmTbConFeePo> CsmTbConFeePo = csmTbConFeePoMapper.queryListByConId(contractId);

		PageInfo pageInfo = new PageInfo(CsmTbConFeePo, (Integer) map.get("pageSize"));
		return pageInfo;

	}

	/**
	 * 查询还款信息
	 * 
	 * @param contractId
	 * @return
	 */
	public PageInfo<CsmTbConRepayPlanPo> queryRepayPlans(Map map) {
		String contractId = (String) map.get("contractId");
		// 引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));

		List<CsmTbConRepayPlanPo> ConRepayPlanPo = csmTbConRepayPlanPoMapper.queryListByConId(contractId);
		PageInfo pageInfo = new PageInfo(ConRepayPlanPo, (Integer) map.get("pageSize"));
		return pageInfo;

	}

	/**
	 * 查询提款计划
	 * 
	 * @param contractId
	 * @return
	 */
	public PageInfo<CsmTbConPayoutPlanPo> queryPayoutPlan(Map map) {
		String contractId = (String) map.get("contractId");
		// 引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));

		List<CsmTbConPayoutPlanPo> ConPayoutPlanPoQuery = csmTbConPayoutPlanPoMapper.queryListByConDetailId(contractId);
		PageInfo pageInfo = new PageInfo(ConPayoutPlanPoQuery, (Integer) map.get("pageSize"));
		return pageInfo;

	}

}
