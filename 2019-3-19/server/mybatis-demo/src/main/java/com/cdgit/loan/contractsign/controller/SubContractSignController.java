package com.cdgit.loan.contractsign.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.constants.Constant;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.contractsign.bean.ConAttachedInfo;
import com.cdgit.loan.contractsign.bean.ConNoticeAddrs;
import com.cdgit.loan.contractsign.bean.ConSubcontract;
import com.cdgit.loan.contractsign.service.SubContractSignServiceImpl;
import com.cdgit.loan.csm.po.TbConSubcontractRelPo;
import com.cdgit.loan.guaranteevaluation.bean.BizGrtRel;
import com.cdgit.loan.guaranteevaluation.bean.GrtMargin;
import com.cdgit.loan.securitymanagement.bean.GrtCollateral;

/**
 * 从合同信息controller
 * @author wuyong
 *
 */
@RestController
@RequestMapping("/subContractSignController")
public class SubContractSignController {
	@Autowired
	private SubContractSignServiceImpl subContractSignServiceImpl;
	/**
	 * 获取合同下关联的抵押合同信息
	 * @param pageNum
	 * @param pageSize
	 * @param subcontractType
	 * @param applyId
	 * @param contractId
	 * @return
	 */
	@GetMapping("/getConDyList")
	@ResponseBody
	public Map<String, Object> getConDyList(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="subcontractType",required=true) String subcontractType,//抵押01、质押02
			@RequestParam(value="applyId",required=false) String applyId,//业务id
			@RequestParam(value="contractId",required=false) String contractId//合同id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.getConDyList(pageNum,pageSize,subcontractType,applyId,contractId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 通过applyId查询该申请下的抵押品关联信息
	 * @param pageNum
	 * @param pageSize
	 * @param subcontractType
	 * @param applyId
	 * @return
	 */
	@GetMapping("/selectParty")
	@ResponseBody
	public Map<String, Object> selectParty(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="subcontractType",required=true) String subcontractType,//抵押01、质押02
			@RequestParam(value="applyId",required=true) String applyId//业务id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.selectParty(pageNum,pageSize,subcontractType,applyId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 通过担保合同id查询合同信息
	 * TB_CON_SUBCONTRACT,
	 * TB_CON_NOTICE_ADDRS,
	 * TB_CON_ATTACHED_INFO
	 * @param subcontractId
	 * @return
	 */
	@GetMapping("/getGrtConInfo")
	@ResponseBody
	public Map<String, Object> getGrtConInfo(
			@RequestParam(value="subcontractId",required=true) String subcontractId,//担保合同Id
			@RequestParam(value="contractId",required=true) String contractId//主合同Id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.getGrtConInfo(subcontractId,contractId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 更新担保合同信息
	 * @description TODO 当为最高额担保时，需要更新TB_CON_SUBCONTRACT_REL 贷款合同与担保合同关系表
	 * @param subcontractId
	 * @param uuid
	 * @param attached
	 * @param subcontractNum
	 * @param partyName
	 * @param paperConNum
	 * @param ifTopSubcon
	 * @param bz
	 * @param subcontractAmt
	 * @param zgbjxe
	 * @param beginDate
	 * @param endDate
	 * @param signDate
	 * @param jggzrbldj
	 * @param subScope
	 * @param aSendAddr
	 * @param aPostcode
	 * @param aReceiver
	 * @param aPhone
	 * @param aEmail
	 * @param aOther
	 * @param bSendAddr
	 * @param bPostcode
	 * @param bReceiver
	 * @param bPhone
	 * @param bEmail
	 * @param cSendAddr
	 * @param cPostcode
	 * @param cReceiver
	 * @param cPhone
	 * @param cEmail
	 * @param dSendAddr
	 * @param dPostcode
	 * @param dReceiver
	 * @param dPhone
	 * @param dEmail
	 * @param arbitrateType
	 * @param arbitrateName
	 * @param arbitrateAddress
	 * @param legalCourt
	 * @param aHoldCount
	 * @param bHoldCount
	 * @param dHoldCount
	 * @param eHoldCount
	 * @param cName
	 * @param cHoldCount
	 * @param totalCount
	 * @param addClause
	 * @return
	 */
	@GetMapping("/updateGrtConInfo")
	@ResponseBody
	public Map<String, Object> updateGrtConInfo(
			@RequestParam(value="subcontractId",required=true) String subcontractId,//担保合同id
			@RequestParam(value="uuid",required=true) String uuid,//文书送达id
			@RequestParam(value="attached",required=true) String attached,//仲裁方式及签署信息id
			@RequestParam(value="conSubconId",required=true) String conSubconId,//贷款合同与担保合同关系表id
			@RequestParam(value="subcontractNum",required=true) String subcontractNum,//抵押合同编号
			@RequestParam(value="partyName",required=false) String partyName,//抵押人名称
			@RequestParam(value="paperConNum",required=false) String paperConNum,//抵押合同纸质编号
			@RequestParam(value="ifTopSubcon",required=false) String ifTopSubcon,//是否最高额抵押
			@RequestParam(value="bz",required=true) String bz,//币种
			@RequestParam(value="subcontractAmt",required=false) BigDecimal subcontractAmt,//抵押合同金额
			@RequestParam(value="zgbjxe",required=false) BigDecimal zgbjxe,//抵押最高本金限额
			@RequestParam(value="beginDate",required=false) String beginDate,//抵押额度起期
			@RequestParam(value="endDate",required=false) String endDate,//抵押额度止期
			@RequestParam(value="signDate",required=true) String signDate,//签订日期
			@RequestParam(value="jggzrbldj",required=false) BigDecimal jggzrbldj,//几个工作日内办理登记
			@RequestParam(value="subScope",required=false) String subScope,//担保范围
			@RequestParam(value="changePercent",required=false) BigDecimal changePercent,//保证人股权变更达到（）%时，应取得债权人的书面同意
			@RequestParam(value="dbRate",required=false) BigDecimal dbRate,//担保债务百分比(%)
			@RequestParam(value="proguarantyWay",required=false) String proguarantyWay,//保证担保方式
			@RequestParam(value="proguarantyType",required=false) String proguarantyType,//保证担保类型
			@RequestParam(value="proguarantyForm",required=false) String proguarantyForm,//保证担保形式
			@RequestParam(value="jrncrbzj",required=true) BigDecimal jrncrbzj,//几日内存入保证金
			@RequestParam(value="bzjbl",required=false) BigDecimal bzjbl,//保证金比例(%)
			@RequestParam(value="bzjje",required=false) BigDecimal bzjje,//保证金金额
			@RequestParam(value="bzjlx",required=false) String bzjlx,//保证金类型
			@RequestParam(value="anlljx",required=false) BigDecimal anlljx,//按年利率计息(%)
			@RequestParam(value="qtjsxfs",required=false) String qtjsxfs,//其他计收利息方式
			@RequestParam(value="bzjjxzq",required=false) String bzjjxzq,//保证金结息周期
			@RequestParam(value="jrtzkh",required=false) BigDecimal jrtzkh,//若保证金价值下降，应在几日内通知客户补充保证金
			@RequestParam(value="aSendAddr",required=true) String aSendAddr,//通知和文书送达
			@RequestParam(value="aPostcode",required=true) String aPostcode,//
			@RequestParam(value="aReceiver",required=true) String aReceiver,//
			@RequestParam(value="aPhone",required=true) String aPhone,//
			@RequestParam(value="aEmail",required=false) String aEmail,//
			@RequestParam(value="aOther",required=false) String aOther,//
			@RequestParam(value="bSendAddr",required=true) String bSendAddr,//
			@RequestParam(value="bPostcode",required=true) String bPostcode,//
			@RequestParam(value="bReceiver",required=true) String bReceiver,//
			@RequestParam(value="bPhone",required=true) String bPhone,//
			@RequestParam(value="bEmail",required=false) String bEmail,//
			@RequestParam(value="cSendAddr",required=false) String cSendAddr,//
			@RequestParam(value="cPostcode",required=false) String cPostcode,//
			@RequestParam(value="cReceiver",required=false) String cReceiver,//
			@RequestParam(value="cPhone",required=false) String cPhone,//
			@RequestParam(value="cEmail",required=false) String cEmail,//
			@RequestParam(value="dSendAddr",required=false) String dSendAddr,//
			@RequestParam(value="dPostcode",required=false) String dPostcode,//
			@RequestParam(value="dReceiver",required=false) String dReceiver,//
			@RequestParam(value="dPhone",required=false) String dPhone,//
			@RequestParam(value="dEmail",required=false) String dEmail,//
			@RequestParam(value="arbitrateType",required=true) String arbitrateType,//仲裁方式
			@RequestParam(value="arbitrateName",required=false) String arbitrateName,//仲裁委员会名称
			@RequestParam(value="arbitrateAddress",required=false) String arbitrateAddress,//仲裁委员会地址
			@RequestParam(value="legalCourt",required=false) String legalCourt,//指定诉讼法院
			@RequestParam(value="aHoldCount",required=true) BigDecimal aHoldCount,//甲方持有份数
			@RequestParam(value="bHoldCount",required=true) BigDecimal bHoldCount,//乙方持有份数
			@RequestParam(value="dHoldCount",required=false) BigDecimal dHoldCount,//丙方持有份数
			@RequestParam(value="eHoldCount",required=false) BigDecimal eHoldCount,//丁方持有份数
			@RequestParam(value="cName",required=false) String cName,//第三方名称
			@RequestParam(value="cHoldCount",required=false) BigDecimal cHoldCount,//第三方名称持有份数
			@RequestParam(value="totalCount",required=true) BigDecimal totalCount,//共计份数
			@RequestParam(value="addClause",required=false) String addClause//补充条款
			
			) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date updateTime = new Date();
		try{
			ConSubcontract conSubcontract = new ConSubcontract();
			conSubcontract.setSubcontractId(subcontractId);
			conSubcontract.setSubcontractNum(subcontractNum);
			conSubcontract.setPaperConNum(paperConNum);
			conSubcontract.setIfTopSubcon(ifTopSubcon);
			conSubcontract.setBz(bz);
			conSubcontract.setSubcontractAmt(subcontractAmt);
			conSubcontract.setZgbjxe(zgbjxe);
			conSubcontract.setProguarantyForm(proguarantyForm);
			conSubcontract.setProguarantyType(proguarantyType);
			conSubcontract.setProguarantyWay(proguarantyWay);
			if(beginDate!=null){
				conSubcontract.setBeginDate(format.parse(beginDate));
			}
			if(endDate!=null){
				conSubcontract.setEndDate(format.parse(endDate));
			}
			conSubcontract.setJggzrbldj(jggzrbldj);
			conSubcontract.setBzjbl(bzjbl);
			conSubcontract.setBzjje(bzjje);
			conSubcontract.setBzjlx(bzjlx);
			conSubcontract.setAnlljx(anlljx);
			conSubcontract.setQtjsxfs(qtjsxfs);
			conSubcontract.setBzjjxzq(bzjjxzq);
			conSubcontract.setJrtzkh(jrtzkh);
			conSubcontract.setJrncrbzj(jrncrbzj);
			conSubcontract.setChangePercent(changePercent);
			conSubcontract.setDbRate(dbRate);
			conSubcontract.setSignDate(format.parse(signDate));
			conSubcontract.setJggzrbldj(jggzrbldj);
			conSubcontract.setSubScope(subScope);
			conSubcontract.setUpdateTime(updateTime);
			ConNoticeAddrs conNoticeAddrs = new ConNoticeAddrs();
			conNoticeAddrs.setaEmail(aEmail);
			conNoticeAddrs.setaOther(aOther);
			conNoticeAddrs.setaPhone(aPhone);
			conNoticeAddrs.setaPostcode(aPostcode);
			conNoticeAddrs.setaReceiver(aReceiver);
			conNoticeAddrs.setaSendAddr(aSendAddr);
			conNoticeAddrs.setbEmail(bEmail);
			conNoticeAddrs.setbPhone(bPhone);
			conNoticeAddrs.setbPostcode(bPostcode);
			conNoticeAddrs.setbReceiver(bReceiver);
			conNoticeAddrs.setbSendAddr(bSendAddr);
			conNoticeAddrs.setcEmail(cEmail);
			conNoticeAddrs.setcPhone(cPhone);
			conNoticeAddrs.setcPostcode(cPostcode);
			conNoticeAddrs.setcReceiver(cReceiver);
			conNoticeAddrs.setcSendAddr(cSendAddr);
			conNoticeAddrs.setUpdateTime(updateTime);
			conNoticeAddrs.setdEmail(dEmail);
			conNoticeAddrs.setdPhone(dPhone);
			conNoticeAddrs.setdPostcode(dPostcode);
			conNoticeAddrs.setdReceiver(dReceiver);
			conNoticeAddrs.setdSendAddr(dSendAddr);
			conNoticeAddrs.setUuid(uuid);
			ConAttachedInfo conAttachedInfo = new ConAttachedInfo();
			conAttachedInfo.setAttached(attached);
			conAttachedInfo.setArbitrateType(arbitrateType);
			conAttachedInfo.setArbitrateName(arbitrateName);
			conAttachedInfo.setArbitrateAddress(arbitrateAddress);
			conAttachedInfo.setLegalCourt(legalCourt);
			conAttachedInfo.setaHoldCount(aHoldCount);
			conAttachedInfo.setbHoldCount(bHoldCount);
			conAttachedInfo.setdHoldCount(dHoldCount);
			conAttachedInfo.seteHoldCount(eHoldCount);
			conAttachedInfo.setcName(cName);
			conAttachedInfo.setcHoldCount(cHoldCount);
			conAttachedInfo.setTotalCount(totalCount);
			conAttachedInfo.setAddClause(addClause);
			TbConSubcontractRelPo tbConSubcontractRelPo = new TbConSubcontractRelPo();
			if(ifTopSubcon!=null && ifTopSubcon.equals("1")){
				throw new RuntimeException("最高额担保未完成！");
				//tbConSubcontractRelPo.setConSubconId(conSubconId);
				//tbConSubcontractRelPo.setSuretyAmt(suretyAmt);
				//tbConSubcontractRelPo.setSubcontractAmt(subcontractAmt);
			}
			map = subContractSignServiceImpl.updateGrtConInfo(conSubcontract,conNoticeAddrs,conAttachedInfo,tbConSubcontractRelPo);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 获取 担保合同 对应的押品信息 
	 * @param subcontractId
	 * @param subcontractNum
	 * @return
	 */
	@GetMapping("/getConSub")
	@ResponseBody
	public Map<String, Object> getConSub(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="subcontractId",required=true) String subcontractId,//担保合同Id
			@RequestParam(value="subcontractNum",required=false) String subcontractNum,//子合同号
			@RequestParam(value="subcontractType",required=true) String subcontractType//01 抵押 02质押
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.getConSub(pageNum,pageSize,subcontractId,subcontractNum,subcontractType);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 签担保合同时，查询该担保客户下，该业务申请下  该笔业务下的担保物信息(担保合同可以引入的押品) 
	 * @param applyId
	 * @param subcontractType
	 * @return
	 */
	@GetMapping("/selSubGrt")
	@ResponseBody
	public Map<String, Object> selSubGrt(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="applyId",required=true) String applyId,//业务id
			@RequestParam(value="subcontractType",required=true) String subcontractType,//01抵押 02质押
			@RequestParam(value="subcontractId",required=true) String subcontractId,//子合同id
			@RequestParam(value="partyId",required=true) String partyId//担保客户id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.selSubGrt(pageNum,pageSize,applyId,subcontractType,subcontractId,partyId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 查询合同和将要绑定的押品信息
	 * @param suretyId
	 * @param subcontractId
	 * @return
	 */
	@GetMapping("/getSubConAndMortgage")
	@ResponseBody
	public Map<String, Object> getSubConAndMortgage(
			@RequestParam(value="suretyId",required=true) String suretyId,//押品id
			@RequestParam(value="applyId",required=true) String applyId,//业务id
			@RequestParam(value="subcontractId",required=true) String subcontractId//子合同id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.getSubConAndMortgage(suretyId,applyId,subcontractId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 保存担保合同
	 * TODO 合同编号时间戳没有使用TB_PUB_DATE
	 * @param subcontractType
	 * @param partyId
	 * @param conPartyId
	 * @return
	 */
	@GetMapping("/saveGrtCon")
	@ResponseBody
	public Map<String, Object> saveGrtCon(
			@RequestParam(value="userNum",required=true) String userNum,//
			@RequestParam(value="orgNum",required=true) String orgNum,//
			@RequestParam(value="subcontractType",required=true) String subcontractType,//01 抵押 02质押
			@RequestParam(value="partyId",required=true) String partyId,//担保客户id
			@RequestParam(value="contractId",required=true) String contractId,//合同id
			@RequestParam(value="applyId",required=true) String applyId,//业务id
			@RequestParam(value="conPartyId",required=true) String conPartyId//合同客户id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.saveGrtCon(userNum,orgNum,subcontractType,partyId,conPartyId,contractId,applyId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 删除担保合同信息
	 * @param contractId
	 * @param subcontractId
	 * @param relationId
	 * @param conSubconId
	 * @param operationType
	 * @return
	 */
	@GetMapping("/delConGrtRel")
	@ResponseBody
	public Map<String, Object> delConGrtRel(
			@RequestParam(value="contractId",required=true) String contractId,//合同id
			@RequestParam(value="subcontractId",required=true) String subcontractId,//担保合同id
			@RequestParam(value="relationId",required=true) String relationId,//
			@RequestParam(value="conSubconId",required=true) String conSubconId,//
			@RequestParam(value="operationType",required=true) String operationType//操作类型 01为引入 02为新增
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.delConGrtRel(contractId,subcontractId,relationId,conSubconId,operationType);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 保存押品与担保合同关联(抵质押品)
	 * @param suretyId
	 * @param grtStatus
	 * @param partyId
	 * @param subcontractId
	 * @param mortgageValue
	 * @param applyMortgageValue
	 * @param suretyAmt
	 * @return
	 */
	@GetMapping("/insertSubGrtRel")
	@ResponseBody
	public Map<String, Object> insertSubGrtRel(
			@RequestParam(value="suretyId",required=true) String suretyId,//担保品id
			@RequestParam(value="grtStatus",required=true) String grtStatus,//担保品状态
			@RequestParam(value="partyId",required=true) String partyId,//担保人id
			@RequestParam(value="subcontractId",required=true) String subcontractId,//担保合同id
			@RequestParam(value="contractId",required=true) String contractId,//主合同id
			@RequestParam(value="mortgageValue",required=true) BigDecimal mortgageValue,//占用价值
			@RequestParam(value="applyMortgageValue",required=true) BigDecimal applyMortgageValue,//业务申请时的占用价值
			@RequestParam(value="suretyAmt",required=true) BigDecimal suretyAmt//担保金额
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.insertSubGrtRel(suretyId,grtStatus,partyId,subcontractId,contractId,mortgageValue,applyMortgageValue,suretyAmt);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 保存押品与担保合同关联(保证人)
	 * @param params
	 * @return
	 */
	@PostMapping("/insertSubGrtRel2")
	public Map<String, Object> insertSubGrtRel2(
			@RequestBody Map<String, Object> params
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			String suretyId = params.get("suretyId").toString();//担保id
			String subcontractId = params.get("subcontractId").toString();//担保合同id
			String contractId = params.get("contractId").toString();//合同id
			BigDecimal suretyAmt = params.get("suretyAmt")==null ? null : (BigDecimal)params.get("suretyAmt");//担保金额
			
			map = subContractSignServiceImpl.insertSubGrtRel2(suretyId,subcontractId,contractId,suretyAmt);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 
	 * 保存押品与担保合同关联(保证金)
	 * @param params
	 * @return
	 */
	@PostMapping("/insertSubGrtRel3")
	public Map<String, Object> insertSubGrtRel3(
			@RequestBody Map<String, Object> params
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			String suretyId = params.get("suretyId").toString();//担保id
			String subcontractId = params.get("subcontractId").toString();//担保合同id
			String contractId = params.get("contractId").toString();//合同id
			map = subContractSignServiceImpl.insertSubGrtRel3(suretyId,subcontractId,contractId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 查询担保合同和保证人信息
	 * @param suretyId
	 * @return
	 */
	@GetMapping("/getSubConBzr")
	@ResponseBody
	public Map<String, Object> getSubConBzr(
			@RequestParam(value="suretyId",required=true) String suretyId//担保品id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.getSubConBzr(suretyId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 删除抵质押物与担保合同关联关系(抵质押品)
	 * @param suretyId
	 * @param relationId
	 * @param applyId
	 * @return
	 */
	@GetMapping("/delSubGrtRel")
	@ResponseBody
	public Map<String, Object> delSubGrtRel(
			@RequestParam(value="suretyId",required=true) String suretyId,//担保品id
			@RequestParam(value="relationId",required=true) String relationId,//担保与押品关系id
			@RequestParam(value="applyId",required=true) String applyId,//业务id
			@RequestParam(value="grtAmt",required=true) BigDecimal grtAmt//关联合同的抵押品占用价值
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.delSubGrtRel(suretyId,relationId,applyId,grtAmt);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 删除抵质押物与担保合同关联关系(保证人)
	 * @param suretyId
	 * @param relationId
	 * @param applyId
	 * @return
	 */
	@GetMapping("/delSubGrtRel2")
	@ResponseBody
	public Map<String, Object> delSubGrtRel2(
			@RequestParam(value="suretyId",required=true) String suretyId,//担保品id
			@RequestParam(value="relationId",required=true) String relationId//担保与押品关系id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.delSubGrtRel2(suretyId,relationId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 删除抵质押物与担保合同关联关系(保证金)
	 * @param suretyId
	 * @param relationId
	 * @return
	 */
	@GetMapping("/delSubGrtRel3")
	@ResponseBody
	public Map<String, Object> delSubGrtRel3(
			@RequestParam(value="relationId",required=true) String relationId//担保与押品关系id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.delSubGrtRel3(relationId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 核对担保合同基本信息是否填写
	 * @param subcontractId
	 * @return
	 */
	@GetMapping("/checkIfCommitSubBasicInfo")
	@ResponseBody
	public Map<String, Object> checkIfCommitSubBasicInfo(
			@RequestParam(value="subcontractId",required=true) String subcontractId//担保合同id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.checkIfCommitSubBasicInfo(subcontractId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 获取已签合同保证合同信息
	 * @param pageNum
	 * @param pageSize
	 * @param subcontractType
	 * @param applyId
	 * @param contractId
	 * @return
	 */
	@GetMapping("/getConGrtBZRList")
	@ResponseBody
	public Map<String, Object> getConGrtBZRList(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="subcontractType",required=false) String subcontractType,//抵押01、质押02、04保证人
			@RequestParam(value="applyId",required=false) String applyId,//业务id
			@RequestParam(value="contractId",required=true) String contractId//合同id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.getConGrtBZRList(pageNum,pageSize,subcontractType,applyId,contractId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 从合同下的保证人关联关系下的保证人列表
	 * @param pageNum
	 * @param pageSize
	 * @param subcontractType
	 * @param subcontractId
	 * @param contractId
	 * @return
	 */
	@GetMapping("/getConSubBzr")
	@ResponseBody
	public Map<String, Object> getConSubBzr(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="subcontractType",required=false) String subcontractType,//抵押01、质押02、04保证人
			@RequestParam(value="subcontractId",required=true) String subcontractId,//子合同id
			@RequestParam(value="contractId",required=true) String contractId//合同id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.getConSubBzr(pageNum,pageSize,subcontractType,subcontractId,contractId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 查询签担保合同时，可以引入的保证人
	 * @param pageNum
	 * @param pageSize
	 * @param subcontractType
	 * @param subcontractId
	 * @param applyId
	 * @return
	 */
	@GetMapping("/selSubGrtBzr")
	@ResponseBody
	public Map<String, Object> selSubGrtBzr(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="subcontractType",required=true) String subcontractType,//抵押01、质押02、04保证人
			@RequestParam(value="subcontractId",required=true) String subcontractId,//子合同id
			@RequestParam(value="applyId",required=true) String applyId//业务id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.selSubGrtBzr(pageNum,pageSize,subcontractType,subcontractId,applyId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 从合同信息下的保证金协议
	 * @param pageNum
	 * @param pageSize
	 * @param subcontractType
	 * @param subcontractId
	 * @return
	 */
	@GetMapping("/getConGRTBZJList")
	@ResponseBody
	public Map<String, Object> getConGRTBZJList(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="subcontractType",required=true) String subcontractType,//抵押01、质押02、04保证人
			@RequestParam(value="contractId",required=true) String contractId//合同id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.getConGRTBZJList(pageNum,pageSize,subcontractType,contractId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 获取保证金协议下的保证金列表
	 * @param pageNum
	 * @param pageSize
	 * @param subcontractId
	 * @return
	 */
	@GetMapping("/getConSubBzj")
	@ResponseBody
	public Map<String, Object> getConSubBzj(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="subcontractId",required=true) String subcontractId//担保合同id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.getConSubBzj(pageNum,pageSize,subcontractId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	@GetMapping("/selSubGrtBzj")
	@ResponseBody
	public Map<String, Object> selSubGrtBzj(
			@RequestParam(value="pageNum",required=true) Integer pageNum,//
			@RequestParam(value="pageSize",required=true) Integer pageSize,//
			@RequestParam(value="subcontractId",required=true) String subcontractId,//担保合同id
			@RequestParam(value="subcontractType",required=true) String subcontractType,//抵押01、质押02、04保证人，03保证金
			@RequestParam(value="applyId",required=true) String applyId//业务申请Id
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = subContractSignServiceImpl.selSubGrtBzj(pageNum,pageSize,subcontractId,subcontractType,applyId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 合同签约时添加保证金
	 * @param params
	 * @return
	 */
	@PostMapping("/addConCashDeposit")
	public Map<String, Object> addConCashDeposit(
			@RequestBody Map<String, Object> params
			) {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			String subcontractId = params.get("subcontractId").toString();//担保合同id
			String contractId = params.get("contractId").toString();//合同id
			String applyId = params.get("applyId").toString();//
			String partyId = params.get("partyId").toString();//
			String collType = params.get("collType").toString();//
			String userNum = params.get("userNum").toString();//
			String orgNum = params.get("orgNum").toString();//
			String acctName = params.get("acctName").toString();//
			String marginAccount = params.get("marginAccount").toString();
			String marginSort = params.get("marginSort").toString();//
			String openBank = params.get("openBank").toString();//
			String currencyCd = params.get("currencyCd").toString();//
			BigDecimal accBalance = new BigDecimal(params.get("accBalance").toString());//
			String beginDate = params.get("beginDate").toString();//
			String endDate = params.get("endDate").toString();//
			BigDecimal marginRate=null;
			if(params.get("marginRate")!=null && !params.get("marginRate").equals("")){
				marginRate = new BigDecimal(params.get("marginRate").toString());
			}
			String appendFlag = params.get("appendFlag")==null ? null : params.get("appendFlag").toString();
			Date date = subContractSignServiceImpl.getOperateDate("yyyy-MM-dd");
			String suretyKeyId = UUIDGenerator.getUUID();
			String suretyId = UUIDGenerator.getUUID();
			String relationId = UUIDGenerator.getUUID();
			GrtCollateral grtCollateral = new GrtCollateral();
			grtCollateral.setGuarantyId(suretyId);
			grtCollateral.setMpType(collType);
			grtCollateral.setTimeMark(date);
			grtCollateral.setSysUpdateTime(date);
			grtCollateral.setDataCreatorOrgCd(orgNum);
			grtCollateral.setDataCreatUserNum(userNum);
			grtCollateral.setLastUpdateOrgCd(orgNum);
			grtCollateral.setLastUpdateUserNum(userNum);
			grtCollateral.setCollateralNum(suretyKeyId);
			grtCollateral.setCollateralName("*保证金*");
			grtCollateral.setCustomerNum(partyId);
			GrtMargin grtMargin = new GrtMargin();
			grtMargin.setAccBalance(accBalance);
			grtMargin.setAcctName(acctName);
			grtMargin.setBeginDate(format.parse(beginDate));
			grtMargin.setCreateTime(date);
			grtMargin.setCurrencyCd(currencyCd);
			grtMargin.setEndDate(format.parse(endDate));
			grtMargin.setAppendFlag(appendFlag);
			grtMargin.setMarginRate(marginRate);
			grtMargin.setMarginSort(marginSort);
			grtMargin.setOpenBank(openBank);
			grtMargin.setOrgNum(orgNum);
			grtMargin.setSuretyId(suretyId);
			grtMargin.setSuretyKeyId(suretyKeyId);
			grtMargin.setUpdateTime(date);
			grtMargin.setUserNum(userNum);
			grtMargin.setMarginAccount(marginAccount);
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setCreateTime(date);
			bizGrtRel.setSuretyId(suretyId);
			bizGrtRel.setUpdateTime(date);
			//TODO 是否将保证金金额设置为担保金额
			//bizGrtRel.setMortgageValue(accBalance);
			bizGrtRel.setSuretyType(collType);
			bizGrtRel.setSuretyId(suretyId);
			bizGrtRel.setRelationId(relationId);
			map = subContractSignServiceImpl.addConCashDeposit(grtCollateral,grtMargin,bizGrtRel,contractId,subcontractId);
		}catch(Exception e){
			map.put("code", Constant.OPE_FAIL);
			map.put("message", "操作失败啦！"+e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
}
