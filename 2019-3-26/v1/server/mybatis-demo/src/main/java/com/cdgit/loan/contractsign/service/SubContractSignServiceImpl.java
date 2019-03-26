package com.cdgit.loan.contractsign.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.constants.Constant;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.mapper.CrtGitUtilMapper;
import com.cdgit.loan.contract.mapper.TbConContractInfoMapper;
import com.cdgit.loan.contractsign.bean.ConAttachedInfo;
import com.cdgit.loan.contractsign.bean.ConNoticeAddrs;
import com.cdgit.loan.contractsign.bean.ConSubcontract;
import com.cdgit.loan.contractsign.bean.ContractBean;
import com.cdgit.loan.contractsign.mapper.SubContractSignMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizSubcontractRelPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConContractInfoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubGrtRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractRelMapper;
import com.cdgit.loan.csm.po.CsmTbBizSubcontractRelPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.po.TbConSubGrtRelPo;
import com.cdgit.loan.csm.po.TbConSubcontractPo;
import com.cdgit.loan.csm.po.TbConSubcontractRelPo;
import com.cdgit.loan.guaranteevaluation.bean.BizGrtRel;
import com.cdgit.loan.guaranteevaluation.bean.GrtGuaranteeBasic;
import com.cdgit.loan.guaranteevaluation.bean.GrtMargin;
import com.cdgit.loan.guaranteevaluation.mapper.BizGrtRelMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtGuaranteeBasicMapper;
import com.cdgit.loan.securitymanagement.bean.GrtCollateral;
import com.cdgit.loan.securitymanagement.mapper.GrtCollateralMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class SubContractSignServiceImpl {
	
	@Autowired
	private SubContractSignMapper subContractSignMapper;
	@Autowired
	private CsmTbConSubcontractRelMapper csmTbConSubcontractRelMapper;
	@Autowired
	private CsmTbBizSubcontractRelPoMapper csmTbBizSubcontractRelPoMapper;
	@Autowired
    private BizGrtRelMapper bizGrtRelMapper;
	@Autowired
	private TbConContractInfoMapper tbConContractInfoMapper;
	@Autowired
	private CrtGitUtilMapper crtGitUtilMapper;
	@Autowired
	private CsmTbConSubGrtRelMapper csmTbConSubGrtRelMapper;
	@Autowired
	private GrtCollateralMapper grtCollateralMapper;
	@Autowired
	private CsmTbConSubcontractMapper csmTbConSubcontractMapper;
	@Autowired
	private CsmTbConContractInfoMapper csmTbConContractInfoMapper;
	@Autowired
	private GrtGuaranteeBasicMapper grtGuaranteeBasicMapper;
	

	public Map<String, Object> getConDyList(Integer pageNum, Integer pageSize, String subcontractType, String applyId,
			String contractId) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<Map<String, Object>> list = subContractSignMapper.getConDyList(subcontractType,applyId,contractId);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectParty(Integer pageNum, Integer pageSize, String subcontractType, String applyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<Map<String, Object>> list = subContractSignMapper.selectParty(subcontractType,applyId);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> getGrtConInfo(String subcontractId,String contractId) {
		Map<String, Object> map = new HashMap<String, Object>();
		ContractBean contractBean = subContractSignMapper.selectGrtConInfoBySubcontractId(subcontractId,contractId);
		if(contractBean==null){
			throw new RuntimeException("为查询到该担保合同信息！");
		}
		map.put("contractBean", contractBean);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> updateGrtConInfo(ConSubcontract conSubcontract, ConNoticeAddrs conNoticeAddrs,
			ConAttachedInfo conAttachedInfo,TbConSubcontractRelPo tbConSubcontractRelPo) {
		Map<String, Object> map = new HashMap<String, Object>();
		TbConSubcontractPo result = csmTbConSubcontractMapper.queryCsmTbConSubcontractPo(conSubcontract.getSubcontractId());
		if(conSubcontract.getIfTopSubcon()!=null && !result.getIfTopSubcon().equals(conSubcontract.getIfTopSubcon())){
			//当更新担保（保证）合同在最高额与非最高额之间转换时，需要先删除押品（保证）与担保合同的观念信息
			List<Map<String,Object>> list = subContractSignMapper.selectConSubGrtRelBySubcontractId(conSubcontract.getSubcontractId());
			if(list!=null && list.size()>0){
				throw new RuntimeException("更新担保合同失败！该担保合同已经关联押品(保证)信息，请先删除关联押品(保证)信息！");
			}
		}
		int i = subContractSignMapper.updateConAttachedInfoSelective(conAttachedInfo);
		if(i<=0){
			throw new RuntimeException("更新失败===>conAttachedInfo");
		}
		i = subContractSignMapper.updateConNoticeAddrsSelective(conNoticeAddrs);
		if(i<=0){
			throw new RuntimeException("更新失败===>conNoticeAddrs");
		}
		i = subContractSignMapper.updateConSubcontractSelective(conSubcontract);
		if(i<=0){
			throw new RuntimeException("更新失败===>conSubcontract");
		}
		if(conSubcontract.getIfTopSubcon()!=null && conSubcontract.getIfTopSubcon().equals("1")){
			i = csmTbConSubcontractRelMapper.updateCsmTbConSubcontractRelSelective(tbConSubcontractRelPo);
			if(i<=0){
				throw new RuntimeException("更新失败===>tbConSubcontractRelPo");
			}
		}
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> getConSub(Integer pageNum,Integer pageSize,String subcontractId, String subcontractNum,String subcontractType) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<Map<String,Object>> list = subContractSignMapper.getConSub(subcontractId,subcontractNum,subcontractType);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selSubGrt(Integer pageNum, Integer pageSize, String applyId, String subcontractType,String subcontractId,String partyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<Map<String,Object>> list = subContractSignMapper.selSubGrt(applyId,subcontractType,subcontractId,partyId);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> getSubConAndMortgage(String suretyId, String applyId,String subcontractId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mortgage = bizGrtRelMapper.selectBySuretyIdAndApplyId(suretyId, applyId);
		ContractBean contractBean = subContractSignMapper.selectSubContractBySubcontractId(subcontractId);
		if(mortgage==null){
			throw new RuntimeException("查询失败，未查到该押品信息");
		}
		if(contractBean==null){
			throw new RuntimeException("查询失败，未查到该担保合同信息");
		}
		map.put("mortgage", mortgage);
		map.put("contractBean", contractBean);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> saveGrtCon(String userNum, String orgNum, String subcontractType, String partyId,
			String conPartyId,String contractId,String applyId) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//Date date = format.parse(crtGitUtilMapper.queryOperatingDate());
		Date date = new Date();
		//担保合同
		ConSubcontract conSubcontract = new ConSubcontract();
		conSubcontract.setConPartyId(conPartyId);
		conSubcontract.setOrgNum(orgNum);
		conSubcontract.setUserNum(userNum);
		conSubcontract.setUpdateTime(date);
		conSubcontract.setCreateTime(date);
		conSubcontract.setPartyId(partyId);
		conSubcontract.setSubcontractId(UUIDGenerator.getUUID());
		conSubcontract.setSubcontractStatus("01");//创建时是未提交状态
		conSubcontract.setSubcontractType(subcontractType);
		conSubcontract.setBz("CNY");
		if(subcontractType.equals(Constant.SUBCONTRACT_TYPE_DY)){
			
			conSubcontract.setSubcontractNum("DY"+date.getTime());
			
		} else if(subcontractType.equals(Constant.SUBCONTRACT_TYPE_ZY)){
			
			conSubcontract.setSubcontractNum("ZY"+date.getTime());
			
		} else if(subcontractType.equals(Constant.SUBCONTRACT_TYPE_BZJ)){
			
			conSubcontract.setSubcontractNum("BZJ"+date.getTime());
			
		} else if(subcontractType.equals(Constant.SUBCONTRACT_TYPE_BZ)){
			
			conSubcontract.setSubcontractNum("BZ"+date.getTime());
			
		}
		int i = subContractSignMapper.insertConSubcontractSelective(conSubcontract);
		if(i<=0){
			throw new RuntimeException("保存担保合同失败！==>conSubcontract");
		}
		//通知书和文书送达
		ConNoticeAddrs conNoticeAddrs = new ConNoticeAddrs();
		conNoticeAddrs.setContractId(conSubcontract.getSubcontractId());
		conNoticeAddrs.setUpdateTime(date);
		conNoticeAddrs.setCreateTime(date);
		conNoticeAddrs.setUuid(UUIDGenerator.getUUID());
		i = subContractSignMapper.insertConNoticeAddrsSelective(conNoticeAddrs);
		if(i<=0){
			throw new RuntimeException("保存担保合同失败！==>conNoticeAddrs");
		}
		//仲裁方式及签署信息
		ConAttachedInfo conAttachedInfo = new ConAttachedInfo();
		conAttachedInfo.setContractId(conSubcontract.getSubcontractId());
		conAttachedInfo.setAttached(UUIDGenerator.getUUID());
		i = subContractSignMapper.insertConAttachedInfoSelective(conAttachedInfo);
		if(i<=0){
			throw new RuntimeException("保存担保合同失败！==>conAttachedInfo");
		}
		//担保合同与贷款合同关联表
		TbConSubcontractRelPo tbConSubcontractRelPo = new TbConSubcontractRelPo();
		tbConSubcontractRelPo.setConSubconId(UUIDGenerator.getUUID());
		tbConSubcontractRelPo.setContractId(contractId);
		tbConSubcontractRelPo.setCreateTime(date);
		tbConSubcontractRelPo.setOperationType("02");
		tbConSubcontractRelPo.setIfEffective("1");
		tbConSubcontractRelPo.setSubcontractId(conSubcontract.getSubcontractId());
		i = csmTbConSubcontractRelMapper.insertCsmTbConSubcontractRelSelective(tbConSubcontractRelPo);
		if(i<=0){
			throw new RuntimeException("保存担保合同失败！==>tbConSubcontractRelPo");
		}
		//查询担保合同对应业务批复
		Map<String,Object> result = subContractSignMapper.getApproveInfo(conSubcontract.getSubcontractId());
		//担保合同关联表
		CsmTbBizSubcontractRelPo csmTbBizSubcontractRelPo = new CsmTbBizSubcontractRelPo();
		if(result!=null){
			if(result.get("APPROVE_ID")!=null && !result.get("APPROVE_ID").toString().equals("")){
				csmTbBizSubcontractRelPo.setApproveId((String)result.get("APPROVE_ID"));
			}
		}
		csmTbBizSubcontractRelPo.setCreateTime(date);
		csmTbBizSubcontractRelPo.setRelationId(UUIDGenerator.getUUID());
		csmTbBizSubcontractRelPo.setSubcontractId(conSubcontract.getSubcontractId());
		csmTbBizSubcontractRelPo.setApplyId(applyId);
		csmTbBizSubcontractRelPo.setUpdateTime(date);
		i = csmTbBizSubcontractRelPoMapper.insertSelective(csmTbBizSubcontractRelPo);
		if(i<=0){
			throw new RuntimeException("保存担保合同失败！==>csmTbBizSubcontractRelPo");
		}
		map.put("subcontractId", conSubcontract.getSubcontractId());
		map.put("conSubconId", tbConSubcontractRelPo.getConSubconId());
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> delConGrtRel(String contractId,String subcontractId, String relationId, String conSubconId,
			String operationType) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(operationType.equals("02")){//新增的直接删除
			//查询该担保合同下是否关联押品，若有提示先删除关联的押品信息
			List<Map<String,Object>> list = subContractSignMapper.selectConSubGrtRelBySubcontractId(subcontractId);
			if(list!=null && list.size()>0){
				throw new RuntimeException("删除担保合同失败！该担保合同已经关联押品(保证)信息，请先删除关联押品(保证)信息！");
			}
			int i = csmTbBizSubcontractRelPoMapper.deleteByPrimaryKey(relationId);
			if(i<=0){
				throw new RuntimeException("删除担保合同失败！==>TbBizSubcontractRel");
			}
			i = subContractSignMapper.deleteConSuncontractRelById(conSubconId);
			if(i<=0){
				throw new RuntimeException("删除担保合同失败！==>ConSuncontractRel");
			}
			i = subContractSignMapper.deleteConAttachedInfoBySubcontractId(subcontractId);
			if(i<=0){
				throw new RuntimeException("删除担保合同失败！==>ConAttachedInfo");
			}
			i = subContractSignMapper.deleteConNoticeAddrsBySubcontractId(subcontractId);
			if(i<=0){
				throw new RuntimeException("删除担保合同失败！==>ConNoticeAddrs");
			}
			i = subContractSignMapper.deleteSubcontractById(subcontractId);
			if(i<=0){
				throw new RuntimeException("删除担保合同失败！==>Subcontract");
			}
			//删除担保合同和押品关联关系！还原数据
		} else { //引入或者其他的
			TbConContractInfo tbConContractInfo = tbConContractInfoMapper.queryOneConContractInfoByContractId(contractId);
			if(tbConContractInfo==null){
				throw new RuntimeException("删除担保合同失败！未查到担保合同的主合同信息");
			}
			String oldContractId = tbConContractInfo.getOldContractId();//原合同id
			String xyId = tbConContractInfo.getXyId();//协议id
			/**
			 * (null==oldContractId || "".equals(oldContractId))&& (null!=xyId && !"".equals(xyId))
			 * TODO 对综合授信业务不熟悉，暂时不删除引入合同的操作
			 */
			if((oldContractId==null || oldContractId.equals("")) && (xyId!=null && !xyId.equals(""))){
				////综合授信合同签约做更新操作
			} else{ 
				//综合授信合同签约做删除操作
			}
			throw new RuntimeException("删除担保合同失败！==>请学习综合授信合同签约业务在完成此功能！");
		}
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> insertSubGrtRel(String suretyId, String grtStatus, String partyId, String subcontractId,
			String contractId,
			BigDecimal mortgageValue,BigDecimal applyMortgageValue, BigDecimal suretyAmt) throws ParseException {
		//1.校验押品重复绑定:包括同个和非同个担保合同都不能不能重复
		//2.保存押品与担保合同关系表
		//3.更新押品已担保金额表
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(crtGitUtilMapper.queryOperatingDate());
		Map<String,Object> contractToMp = subContractSignMapper.selectContractOnlyOneMpType(contractId,suretyId);
		if(contractToMp!=null){
			throw new RuntimeException("关联押品和担保合同失败！一个主合同下只能关联一种类型的押品，请不要重复关联");
		}
		Map<String,Object> subGrtRel = subContractSignMapper.selectSubGrtRelBySuretyIdAndSubId(suretyId,subcontractId);
		if(subGrtRel!=null){
			throw new RuntimeException("关联押品和担保合同失败！该押品已经与该担保合同关联，请不要重复关联");
		}
		TbConSubGrtRelPo tbConSubGrtRelPo = new TbConSubGrtRelPo();
		tbConSubGrtRelPo.setCreateTime(date);
		tbConSubGrtRelPo.setGrtAmt(mortgageValue);
		tbConSubGrtRelPo.setGrtStatus(grtStatus);
		tbConSubGrtRelPo.setPartyId(partyId);
		tbConSubGrtRelPo.setRelationId(UUIDGenerator.getUUID());
		tbConSubGrtRelPo.setSubcontractId(subcontractId);
		tbConSubGrtRelPo.setSuretyAmt(suretyAmt);
		tbConSubGrtRelPo.setSuretyId(suretyId);
		tbConSubGrtRelPo.setUpdateTime(date);
		int i = csmTbConSubGrtRelMapper.insertCsmTbConSubGrtRel(tbConSubGrtRelPo);
		if(i<=0){
			throw new RuntimeException("关联押品和担保合同失败！===>插入tbConSubGrtRelPo出错");
		}
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(suretyId);
		if(grtCollateral==null){
			throw new RuntimeException("关联押品和担保合同失败！未查到该押品信息！");
		}
		BigDecimal oldSetGuarantyAmt = grtCollateral.getSetGuarantyAmt();
		BigDecimal newSetGuarantyAmt = oldSetGuarantyAmt.add(mortgageValue).subtract(applyMortgageValue);
		if(newSetGuarantyAmt.compareTo(new BigDecimal("0"))<0){
			throw new RuntimeException("关联押品和担保合同失败！===>已设定担保额数据异常");
		}
		grtCollateral.setSetGuarantyAmt(newSetGuarantyAmt);
		i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i<=0){
			throw new RuntimeException("关联押品和担保合同失败！===>更新grtCollateral出错");
		}
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> insertSubGrtRel2(String suretyId, String subcontractId,
			String contractId, BigDecimal suretyAmt) throws ParseException {
		//1.校验押品重复绑定:包括同个和非同个担保合同都不能不能重复
		//2.保存保证人与担保合同关系表
		//3.更新保证人已担保金额表
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(crtGitUtilMapper.queryOperatingDate());
		Map<String,Object> contractToMp = subContractSignMapper.selectContractOnlyOneMpType(contractId,suretyId);
		if(contractToMp!=null){
			throw new RuntimeException("关联保证人和担保合同失败！一个主合同下只能关联一种类型的保证人，请不要重复关联");
		}
		Map<String,Object> subGrtRel = subContractSignMapper.selectSubGrtRelBySuretyIdAndSubId(suretyId,subcontractId);
		if(subGrtRel!=null){
			throw new RuntimeException("关联保证人和担保合同失败！该保证人已经与该担保合同关联，请不要重复关联");
		}

		GrtGuaranteeBasic result = grtGuaranteeBasicMapper.selectByPrimaryKey(suretyId);
		if(result==null){
			throw new RuntimeException("关联保证人和担保合同失败！未查到该保证人信息！");
		}
		TbConSubcontractPo tbConSubcontractPo = csmTbConSubcontractMapper.queryCsmTbConSubcontractPo(subcontractId);
		if(tbConSubcontractPo==null){
			throw new RuntimeException("关联保证人和担保合同失败！未查询到该担保合同信息！");
		}
		
		TbConSubGrtRelPo tbConSubGrtRelPo = new TbConSubGrtRelPo();
		tbConSubGrtRelPo.setCreateTime(date);
		tbConSubGrtRelPo.setPartyId(result.getPartyId());
		tbConSubGrtRelPo.setRelationId(UUIDGenerator.getUUID());
		tbConSubGrtRelPo.setSubcontractId(subcontractId);
		tbConSubGrtRelPo.setSuretyId(suretyId);
		tbConSubGrtRelPo.setUpdateTime(date);
		GrtGuaranteeBasic guaranteeBasic = new GrtGuaranteeBasic();
		guaranteeBasic.setSuretyId(suretyId);
		guaranteeBasic.setUpdateTime(date);
		if(tbConSubcontractPo.getIfTopSubcon().equals("1")){//最高额担保合同
			if(suretyAmt==null){
				throw new RuntimeException("关联保证人和担保合同失败!担保确认金额不能为空！");
			}
			tbConSubGrtRelPo.setSuretyAmt(suretyAmt);
			BigDecimal usableGuaranteeLimit = result.getUsableGuaranteeLimit().subtract(suretyAmt);
			if(usableGuaranteeLimit.compareTo(new BigDecimal("0"))<0){
				throw new RuntimeException("关联保证人和担保合同失败!更新后的可用保证金额不能为负！");
			}
		} else{//不是最高额担保担保合同
			tbConSubGrtRelPo.setSuretyAmt(result.getSuretyAmt());
			guaranteeBasic.setUsableGuaranteeLimit(new BigDecimal("0"));
		}
		//插入担保关系表
		int i = csmTbConSubGrtRelMapper.insertCsmTbConSubGrtRel(tbConSubGrtRelPo);
		if(i<=0){
			throw new RuntimeException("关联保证人和担保合同失败！===>插入tbConSubGrtRelPo出错");
		}
		//更新担保的USABLE_GUARANTEE_LIMIT可用担保金额
		i = grtGuaranteeBasicMapper.updateByPrimaryKeySelective(guaranteeBasic);
		if(i<=0){
			throw new RuntimeException("关联保证人和担保合同失败！===>更新GrtGuaranteeBasic失败！");
		}
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> insertSubGrtRel3(String suretyId, String subcontractId,
			String contractId) throws ParseException {
		//1.校验押品重复绑定:包括同个和非同个担保合同都不能不能重复
		//2.保存保证人与担保合同关系表
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(crtGitUtilMapper.queryOperatingDate());
		Map<String,Object> contractToMp = subContractSignMapper.selectContractOnlyOneMpType(contractId,suretyId);
		if(contractToMp!=null){
			throw new RuntimeException("关联保证金和担保合同失败！一个主合同下只能关联一种类型的保证金，请不要重复关联");
		}
		Map<String,Object> subGrtRel = subContractSignMapper.selectSubGrtRelBySuretyIdAndSubId(suretyId,subcontractId);
		if(subGrtRel!=null){
			throw new RuntimeException("关联保证金和担保合同失败！该保证金已经与该担保合同关联，请不要重复关联");
		}

		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(suretyId);
		if(grtCollateral==null){
			throw new RuntimeException("关联保证金和担保合同失败！未查到该保证金信息！");
		}
		TbConSubcontractPo tbConSubcontractPo = csmTbConSubcontractMapper.queryCsmTbConSubcontractPo(subcontractId);
		if(tbConSubcontractPo==null){
			throw new RuntimeException("关联保证金和担保合同失败！未查询到该担保合同信息！");
		}
		TbConSubGrtRelPo tbConSubGrtRelPo = new TbConSubGrtRelPo();
		tbConSubGrtRelPo.setCreateTime(date);
		tbConSubGrtRelPo.setPartyId(grtCollateral.getCustomerNum());
		tbConSubGrtRelPo.setRelationId(UUIDGenerator.getUUID());
		tbConSubGrtRelPo.setSubcontractId(subcontractId);
		tbConSubGrtRelPo.setSuretyId(suretyId);
		tbConSubGrtRelPo.setUpdateTime(date);
//		tbConSubGrtRelPo.setSuretyAmt(result.getSuretyAmt());
		//插入担保关系表
		int i = csmTbConSubGrtRelMapper.insertCsmTbConSubGrtRel(tbConSubGrtRelPo);
		if(i<=0){
			throw new RuntimeException("关联保证人和担保合同失败！===>插入tbConSubGrtRelPo出错");
		}
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> delSubGrtRel(String suretyId, String relationId, String applyId,BigDecimal grtAmt) {
		//1.先删除关系表
		//2.查询并更新担保品已担保金额
		Map<String, Object> map = new HashMap<String, Object>();
		int i = csmTbConSubGrtRelMapper.deleteCsmTbConSubGrtRelByRelationId(relationId);
		if(i<=0){
			throw new RuntimeException("删除失败！该relationId无效");
		}
		Map<String,Object> result = subContractSignMapper.selectBizGrtRelBySuretyIdAndApplyId(suretyId,applyId);
		if(result==null){
			throw new RuntimeException("删除失败！未查询到该抵押品的业务信息");
		}
		BigDecimal mortgageValue = (BigDecimal)result.get("MORTGAGE_VALUE");
		BigDecimal setGuarantyAmt = (BigDecimal)result.get("SET_GUARANTY_AMT");
		BigDecimal newSetGuarantyAmt = setGuarantyAmt.subtract(grtAmt).add(mortgageValue);
		if(newSetGuarantyAmt.compareTo(new BigDecimal("0"))<0){
			throw new RuntimeException("删除失败！已设定担保额数据异常");
		}
		GrtCollateral grtCollateral = new GrtCollateral();
		grtCollateral.setGuarantyId(suretyId);
		grtCollateral.setSetGuarantyAmt(newSetGuarantyAmt);
		i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i<=0){
			throw new RuntimeException("关联押品和担保合同失败！===>更新grtCollateral出错");
		}
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> delSubGrtRel2(String suretyId, String relationId) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		TbConSubGrtRelPo rel = csmTbConSubGrtRelMapper.queryOneCsmTbConSubGrtRelByRelationId(relationId);
		GrtGuaranteeBasic result = grtGuaranteeBasicMapper.selectByPrimaryKey(suretyId);
		//修改金额
		BigDecimal usableGuaranteeLimit = result.getUsableGuaranteeLimit().add(rel.getSuretyAmt());
		if(usableGuaranteeLimit.compareTo(result.getSuretyAmt())>0){
			throw new RuntimeException("删除失败！更新后的可用保证金额不能大于担保金额");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(crtGitUtilMapper.queryOperatingDate());
		GrtGuaranteeBasic basic = new GrtGuaranteeBasic();
		basic.setSuretyId(suretyId);
		basic.setUsableGuaranteeLimit(usableGuaranteeLimit);
		basic.setUpdateTime(date);
		//更新保证信息
		int i = grtGuaranteeBasicMapper.updateByPrimaryKeySelective(basic);
		if(i<=0){
			throw new RuntimeException("删除失败！更新保证信息失败！");
		}
		//删除关系表
		i = csmTbConSubGrtRelMapper.deleteCsmTbConSubGrtRelByRelationId(relationId);
		if(i<=0){
			throw new RuntimeException("删除失败！删除担保合同与押品信息失败");
		}
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> delSubGrtRel3(String relationId) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		//删除关系表
		int i = csmTbConSubGrtRelMapper.deleteCsmTbConSubGrtRelByRelationId(relationId);
		if(i<=0){
			throw new RuntimeException("删除失败！删除担保合同与押品信息失败");
		}
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> checkIfCommitSubBasicInfo(String subcontractId) {
		Map<String, Object> map = new HashMap<String, Object>();
		TbConSubcontractPo po = csmTbConSubcontractMapper.queryCsmTbConSubcontractPo(subcontractId);
		if(po==null ){
			throw new RuntimeException("未查询到该担保合同信息！");
		}
		if(po.getSignDate()==null){
			throw new RuntimeException("请先填写担保合同基本信息！");
		}
		map.put("TbConSubcontractPo", po);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	
	public Date getOperateDate(String str) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("str");
		Date date = format.parse(crtGitUtilMapper.queryOperatingDate());
		return date;
	}
	public Map<String, Object> getConGrtBZRList(Integer pageNum, Integer pageSize, String subcontractType,
			String applyId, String contractId) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<Map<String, Object>> list = subContractSignMapper.getConBzrList(contractId);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> getConSubBzr(Integer pageNum, Integer pageSize, String subcontractType,
			String subcontractId, String contractId) {
		Map<String, Object> map = new HashMap<String, Object>();
		TbConContractInfoPo tbConContractInfoPo =  csmTbConContractInfoMapper.selectByPrimaryKey(contractId);
		if(tbConContractInfoPo==null){
			//获取 综合授信 下关联 保证人信息
			List<Map<String, Object>> list = subContractSignMapper.getCreditSubBzr(subcontractId,contractId);
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
			map.put("data", pageInfo);
		} else{
			//获取 保证合同 下关联 保证人信息
			List<Map<String, Object>> list = subContractSignMapper.getConSubBzr(subcontractId,contractId);
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
			map.put("data", pageInfo);
		}
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selSubGrtBzr(Integer pageNum, Integer pageSize, String subcontractType,
			String subcontractId, String applyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = subContractSignMapper.selSubGrtBzr(subcontractId,subcontractType,applyId);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> getSubConBzr(String suretyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		GrtGuaranteeBasic grtGuaranteeBasic = grtGuaranteeBasicMapper.selectByPrimaryKey(suretyId);
		if(grtGuaranteeBasic==null){
			throw new RuntimeException("查询保证人信息失败！");
		}
		map.put("grtGuaranteeBasic",grtGuaranteeBasic);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> getConGRTBZJList(Integer pageNum, Integer pageSize, String subcontractType,
			String contractId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = subContractSignMapper.getConBZJList(contractId,subcontractType);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> getConSubBzj(Integer pageNum, Integer pageSize, String subcontractId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = subContractSignMapper.getConSubBzj(subcontractId);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selSubGrtBzj(Integer pageNum, Integer pageSize, String subcontractId,
			String subcontractType, String applyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = subContractSignMapper.selSubGrtBzj(subcontractId,subcontractType,applyId);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> addConCashDeposit(GrtCollateral grtCollateral, GrtMargin grtMargin, BizGrtRel bizGrtRel,
			String contractId, String subcontractId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", Constant.OPE_SUCCESS);
		map.put("message", "操作成功!");
		return map;
	}
}
