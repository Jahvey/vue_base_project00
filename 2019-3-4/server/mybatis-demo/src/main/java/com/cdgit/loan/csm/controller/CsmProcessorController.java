/**
 * 
 */
package com.cdgit.loan.csm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.ApproveAndSxxyVo;
import com.cdgit.loan.csm.bean.CsmConInfoHtVoQuery;
import com.cdgit.loan.csm.message.PageBean;
import com.cdgit.loan.csm.po.CsmTbBizBankStructApplyPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.process.bizInfo.BizInfo;
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
		System.err.println("[getTermByEndDate] map "+map);
		return dateCountUtil.getTermByEndDate(map);

	}

	// 通过起始日期和期限 计算出合同到期日期
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/dateCountUtil/MonthAddDate")
	@ResponseBody
	public String getMonthAddDate(@RequestParam HashMap<String, Object> map) {
		System.err.println("[MonthAddDate] map "+map);
		return dateCountUtil.getMonthAddDate(map);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/ApplyDaoEos/updateConInfo")
	@ResponseBody
	public TbConContractInfoPo updateConInfo(@RequestParam HashMap<String, Object> dataMap) {
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

	// TODO 合同插入 前台测试的时候注意要使用json格式
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/ApplyDaoEos/create")
	@ResponseBody
	public TbConContractInfoPo createConByBizDtl(@RequestParam Map<String, Object> apply) {
		// HashMap<String,Object> apply = new HashMap<String,Object>();
		System.err.println("create contract..." + apply);
		return conInfoCreateDao.create(apply);

	}

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

}
