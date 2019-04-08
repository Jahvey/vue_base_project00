/**
 * 
 */
package com.cdgit.loan.csm.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.social.FacebookAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.ApproveAndSxxyVo;
import com.cdgit.loan.csm.bean.ApproveConsVo;
import com.cdgit.loan.csm.bean.CsmConInfoHtVoQuery;
import com.cdgit.loan.csm.mapper.CsmTbBizMyhtxxApplyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizProductInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConFeePoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConMyhtxxPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConPayoutPlanPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConRepayPlanPoMapper;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.po.CsmTbBizBankStructApplyPo;
import com.cdgit.loan.csm.po.CsmTbBizMyhtxxApplyPo;
import com.cdgit.loan.csm.po.CsmTbConFeePo;
import com.cdgit.loan.csm.po.CsmTbConPayoutPlanPo;
import com.cdgit.loan.csm.po.CsmTbConRepayPlanPo;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.process.bizApply.getBasicRate;
import com.cdgit.loan.csm.process.bizInfo.BizInfo;
import com.cdgit.loan.csm.process.bizProductDetail.BizProductDetail;
import com.cdgit.loan.csm.process.conApply.ConApply;
import com.cdgit.loan.csm.process.conApply.ConSynToCollByWebService;
import com.cdgit.loan.csm.process.conInfo.ConContractInfo;
import com.cdgit.loan.csm.process.conInfo.ConInfoPub;
import com.cdgit.loan.csm.process.conInfo.ConInfoSxxy;
import com.cdgit.loan.csm.process.cons.ConInfoCreateDao;
import com.cdgit.loan.csm.pub.DateCountUtil;
import com.cdgit.loan.csm.pub.gitUtils.GitUtils;
import com.cdgit.loan.csm.service.ConApplyServiceImpl;
import com.cdgit.loan.csm.service.CsmRuleEngineServiceImpl;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk TODO 合同签约所有流程接口 待测试
 */
@RestController
@RequestMapping("process")
public class CsmProcessorController {

	@Autowired
	ConInfoPub conInfoPub;

	@Autowired
	ConSynToCollByWebService conSynToCollByWebService;

	@Autowired
	ConApply conApply;

	@Autowired
	ConApplyServiceImpl conApplyServiceImpl;

	@Autowired
	ConInfoCreateDao conInfoCreateDao;

	@Autowired
	ConContractInfo conContractInfo;

	@Autowired
	ConInfoSxxy conInfoSxxy;

	@Autowired
	BizInfo bizInfo;

	@Autowired
	CsmRuleEngineServiceImpl csmRuleEngineServiceImpl;

	@Autowired
	DateCountUtil dateCountUtil;

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
	CsmTbBizProductInfoPoMapper csmTbBizProductInfoPoMapper;

	@Autowired
	getBasicRate getBasicRate;

	@Autowired
	BizProductDetail BizProductDetail;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conContractInfo/saveConContractDetailInfo")
	@ResponseBody
	public String saveConContractDetailInfo(@RequestParam HashMap<String, Object> map) {
		System.out.println("[saveConContractDetailInfo] mapInfo "+map);
		return conContractInfo.saveConContractDetailInfo(map);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conContractInfo/deleteRepayPlan")
	public void deleteRepayPlan(String repayPlanId, String deleteType) {

		conContractInfo.deleteRepayPlan(repayPlanId, deleteType);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conApply/getBizHappenType")
	public List<HashMap<String, Object>> getBizHappenType(String contractId) {
		return conApplyServiceImpl.getBizHappenType(contractId);
	}

	/**
	 * 根据合同ID初始化查询合同明细页面 1.先给conDetail赋初值为流动资金否则给明细合同id赋值会报错
	 * 2.根据贷种查出要查询的实体名称，由于品种信息表存的都是申请表实体，需要将名称转换成合同的，再查询合同明细
	 * 
	 * @param contractId
	 * @param productType
	 * @return
	 */
	// TODO 待测 根据合同ID初始化查询合同明细页面
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conContractInfo/getConDetailInfoByContractId")
	public HashMap<String, Object> getConDetailInfoByContractId(String contractId, String productType) {
		System.err.println("[getConDetailInfoByContractId] contractId " + contractId + ",productType " + productType);
		return conContractInfo.getConDetailInfoByContractId(contractId, productType);
	}

	// TODO 待测 获取当前币种的汇率信
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conInfoSxxy/getChangeRate")
	public HashMap<String, Object> getChangeRate(String bz) {
		System.err.println("[getChangeRate] bz");
		return conInfoSxxy.getChangeRate(bz);
	}

	// 通过起始日期、到期日期、期限单位计算期限
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/dateCountUtil/getTermByEndDate")
	@ResponseBody
	public int getTermByEndDate(@RequestParam HashMap<String, Object> map) {
		System.err.println("[getTermByEndDate] map " + map);
		return dateCountUtil.getTermByEndDate(map);

	}

	// 通过起始日期和期限 计算出合同到期日期
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/dateCountUtil/MonthAddDate")
	@ResponseBody
	public String getMonthAddDate(@RequestParam HashMap<String, Object> map) {
		System.err.println("[MonthAddDate] map " + map);
		return dateCountUtil.getMonthAddDate(map);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/ApplyDaoEos/updateConInfo")
	public TbConContractInfoPo updateConInfo(@RequestBody HashMap<String, Object> dataMap) {
		System.err.println("拿到数据了![map]=" + dataMap);
		return conInfoCreateDao.update(dataMap);
	}
	// TODO 合同失效 待测

	// 获取业务信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conApply/getConInfoBizType")
	public HashMap<String, Object> getConInfoBizType(String contractId) {

		return conApply.getConInfoBizType(contractId);

	}

	// 获取相应的合同信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/ConInfoPub/selConInfo")
	public Map<String, Object> selConInfo(String contractId) {

		return conInfoPub.selConInfo(contractId);

	}

	// TODO 合同失效 待测试
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conApply/disConInfo")
	public String disConInfo(String contractId, String flag) {

		return conApply.disConInfo(contractId, flag);

	}

	// 调用押品系统
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conSynToCollByWebService/disConSynColl")
	public String disConSynColl(String contractId) {

		return conSynToCollByWebService.disConSynColl(contractId);

	}

	// TODO 合同调整 测试完成 通过 2019/2/21
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conApply/tzContractInfo")
	public HashMap<String, Object> tzContractInfo(String contractId, String bizType) {

		return conApply.tzContractInfo(contractId, bizType);

	}

	// TODO 合同查看 待测 con_tree.jsp

	// 先将品种对应的合同明细页面取出来
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conContractInfo/getDetailJspByContractId")
	public HashMap<String, Object> getDetailJspByContractId(String contractId) {

		return (HashMap<String, Object>) conContractInfo.getDetailJspByContractId(contractId);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conInfoSxxy/getConInfoByContarctId")
	@ResponseBody
	public CsmConInfoHtVoQuery getConInfoByContarctId(@RequestParam String contractId) {
		HashMap<String, Object> map = conInfoSxxy.getConInfoByContarctId(contractId);
		CsmConInfoHtVoQuery bean = (CsmConInfoHtVoQuery) map.get("CsmConInfoHtVo");
		return bean;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conInfoSxxy/getConInfoMapByContarctId")
	public HashMap<String, Object> getConInfoMapByContarctId(String contractId) {
		return conInfoSxxy.getConInfoByContarctId(contractId);
	}

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// @RequestMapping(value="/conInfoSxxy/getConInfoByContarctId",method=RequestMethod.POST)
	// public HashMap<String, Object> getConInfoByContarctId(@RequestBody Map
	// map){
	// return (HashMap<String, Object>)
	// conInfoSxxy.getConInfoByContarctId((String)map.get("contractId"));
	// }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/bizInfo/getBankTeamStruct")
	public CsmTbBizBankStructApplyPo getBankTeamStruct(String applyId) {
		return bizInfo.getBankTeamStruct(applyId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/conApply/saveConInfoToPro")
	public String saveConInfoToPro(String contractId, String processInstId) {
		conApply.saveConInfoToPro(contractId, processInstId);
		return "success";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/rule/RuleEngineMapper")
	public Integer RuleEngineMapper(String name, String param) { // 可以直接调用校验接口
		return csmRuleEngineServiceImpl.updateValidateForCon1(name, param);
	}

	/**
	 * 合同插入 前台测试的时候注意要使用json格式
	 * 
	 * @param apply
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/ApplyDaoEos/create")
	@ResponseBody
	public HashMap<String, Object> createConByBizDtl(@RequestParam Map<String, Object> apply) {
		// System.err.println("create contract..." + apply);
		return conInfoCreateDao.create(apply);

	}

	/**
	 * 业务合同列表页面 的数据来源
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param bizNum
	 * @param partyId
	 * @param userId
	 * @param amountDetailId
	 * @return
	 */
	@GetMapping("/getApproveAndSxxy")
	public PageBean getApproveAndSxxy(@RequestParam(value = "pageNum", required = true) int pageNum,
			@RequestParam(value = "pageSize", required = true) int pageSize,

			@RequestParam(value = "bizNum", required = false) String bizNum,
			@RequestParam(value = "partyId", required = false) String partyId,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "amountDetailId", required = false) String amountDetailId) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bizNum", bizNum);
		hashMap.put("partyId", partyId);
		hashMap.put("userId", userId);
		hashMap.put("amountDetailId", amountDetailId);

		hashMap.put("pageNum", pageNum);
		hashMap.put("pageSize", pageSize);

		PageInfo<ApproveAndSxxyVo> ApproveAndSxxyVo = conApplyServiceImpl.getApproveAndSxxy(hashMap);
		PageBean pageBean = new PageBean();
		pageBean.setTotal(ApproveAndSxxyVo.getTotal());
		pageBean.setData(ApproveAndSxxyVo.getList());

		return pageBean;

	}

	/**
	 * 查询产品申请期限
	 * 
	 * @param amountDetailId
	 * @param contractId
	 * @return
	 */
	@GetMapping("/bizProductDetail/getBizTerm")
	public List<HashMap<String, Object>> getBizTerm(

			@RequestParam(value = "amountDetailId", required = false) String amountDetailId,
			@RequestParam(value = "contractId", required = false) String contractId) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		hashMap.put("contractId", contractId);
		hashMap.put("amountDetailId", amountDetailId);

		return csmTbBizProductInfoPoMapper.getBizTerm(hashMap);

	}

	/**
	 * 
	 * @param loanlength
	 * @param rateType
	 * @return
	 */
	@GetMapping("/bizApply/getBasicrate")
	public BigDecimal getBasicrate(int loanlength, String rateType) {

		return getBasicRate.getBasicrate(loanlength, rateType);

	}

	// Fee.vue
	@GetMapping("/conDetail/getFee")
	public PageBean queryFee(
			@RequestParam(value = "pageNum", required = true) int pageNum,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "contractId", required = true) String contractId) {
		Map map = new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("contractId", contractId);
		PageInfo<CsmTbConFeePo> queryFee = conContractInfo.queryFee(map);

		PageBean pageBean = new PageBean();
		pageBean.setTotal(queryFee.getTotal());
		pageBean.setData(queryFee.getList());

		return pageBean;

	}

	/**
	 * 查询还款计划
	 * 
	 * @param contractId
	 * @return
	 */
	// LoanRepayPlan.vue
	@GetMapping("/conInfo/queryRepayPlans")
	public PageBean queryRepayPlans(
			@RequestParam(value = "pageNum", required = true) int pageNum,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "contractId", required = true) String contractId) {
		Map map = new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("contractId", contractId);
		PageInfo<CsmTbConRepayPlanPo> queryRepayPlans = conContractInfo.queryRepayPlans(map);

		PageBean pageBean = new PageBean();
		pageBean.setTotal(queryRepayPlans.getTotal());
		pageBean.setData(queryRepayPlans.getList());

		return pageBean;

	}

	/**
	 * 查询提款信息
	 * 
	 * @param contractId
	 * @return
	 */
	// PayoutPlan.vue
	@GetMapping("/conInfo/queryPayoutPlan")
	public PageBean queryPayoutPlan(
			@RequestParam(value = "pageNum", required = true) int pageNum,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "contractId", required = true) String contractId) {
		Map map = new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("contractId", contractId);
		PageInfo<CsmTbConPayoutPlanPo> conPayoutPlanPo = conContractInfo.queryPayoutPlan(map);

		PageBean pageBean = new PageBean();
		pageBean.setTotal(conPayoutPlanPo.getTotal());
		pageBean.setData(conPayoutPlanPo.getList());

		return pageBean;

	}

	/**
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param contractId
	 * @return
	 */
	@GetMapping("/bizPjxx/queryMyhtxx")
	public PageBean queryMyhtxx(
			@RequestParam(value = "pageNum", required = true) int pageNum,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "contractId", required = true) String contractId) {
		Map map = new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("contractId", contractId);

		PageInfo<CsmTbBizMyhtxxApplyPo> MyhtxxPo = BizProductDetail.queryMyhtxx(map);

		PageBean pageBean = new PageBean();
		pageBean.setTotal(MyhtxxPo.getTotal());
		pageBean.setData(MyhtxxPo.getList());

		return pageBean;

	}

	/**
	 * 根据协议ID查询批复明细信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param contractId
	 * @return
	 */
	@GetMapping("/conInfoSxxy/queryConDetailsXy")
	public PageBean queryConDetailsXy(
			@RequestParam(value = "pageNum", required = true) int pageNum,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "contractId", required = true) String contractId) {

		Map map = new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("contractId", contractId);

		PageInfo<TbBizAmountDetailApprovePo> ConDetailsXyVo = conInfoSxxy.queryConDetailsXy(map);

		PageBean pageBean = new PageBean();
		pageBean.setTotal(ConDetailsXyVo.getTotal());
		pageBean.setData(ConDetailsXyVo.getList());

		return pageBean;

	}
	
	
	@GetMapping("/bizProductDetail/checkYwbh")
	@ResponseBody
	public HashMap<String, Object> checkYwbh(@RequestParam HashMap<String, Object> map) {
		HashMap<String,Object> resultMap=null;
	
			 resultMap = BizProductDetail.checkYwbh(map);

		

		return resultMap;

	}
	
	

}
