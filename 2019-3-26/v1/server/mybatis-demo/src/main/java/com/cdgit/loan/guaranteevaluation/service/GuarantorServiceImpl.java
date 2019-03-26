package com.cdgit.loan.guaranteevaluation.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.constants.Constant;
import com.cdgit.loan.common.util.BeanUtils;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.customerManage.mapper.NaturalPersonMapper;
import com.cdgit.loan.guaranteevaluation.bean.BizApply;
import com.cdgit.loan.guaranteevaluation.bean.BizGrtRel;
import com.cdgit.loan.guaranteevaluation.bean.ConGuarantOrgInfo;
import com.cdgit.loan.guaranteevaluation.bean.ConGuaranteQuota;
import com.cdgit.loan.guaranteevaluation.bean.ConZh;
import com.cdgit.loan.guaranteevaluation.bean.CrdThirdPartyLimit;
import com.cdgit.loan.guaranteevaluation.bean.GrtGuaranteeBasic;
import com.cdgit.loan.guaranteevaluation.bean.GuarantorBean;
import com.cdgit.loan.guaranteevaluation.mapper.BizApplyMapper;
import com.cdgit.loan.guaranteevaluation.mapper.BizGrtRelMapper;
import com.cdgit.loan.guaranteevaluation.mapper.ConGuarantOrgInfoMapper;
import com.cdgit.loan.guaranteevaluation.mapper.ConGuaranteQuotaMapper;
import com.cdgit.loan.guaranteevaluation.mapper.ConZhMapper;
import com.cdgit.loan.guaranteevaluation.mapper.CrdThirdPartyLimitMapper;
import com.cdgit.loan.guaranteevaluation.mapper.GrtGuaranteeBasicMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class GuarantorServiceImpl {
	@Autowired
	private NaturalPersonMapper naturalPersonMapper;
	@Autowired
	private ConGuarantOrgInfoMapper conGuarantOrgInfoMapper;
	@Autowired
	private CrdThirdPartyLimitMapper crdThirdPartyLimitMapper;
	@Autowired
	private BizApplyMapper bizApplyMapper;
	@Autowired
	private ConGuaranteQuotaMapper conGuaranteQuotaMapper;
	@Autowired
	private GrtGuaranteeBasicMapper grtGuaranteeBasicMapper;
	@Autowired
	private BizGrtRelMapper bizGrtRelMapper;
	@Autowired
	private ConZhMapper conZhMapper;

	public Map<String, Object> getPartyInfoByPartyId(String partyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> customer = naturalPersonMapper.findByPartyId(partyId);
		
		if(customer!=null){
			customer = BeanUtils.changeUnderlineToHump(customer);
			if(customer.get("partyTypeCd").toString().equals(Constant.CUSTOMER_TYPE_NATURAL_PERSON)){ //自然人客户
				map.put("data", customer);
				map.put("isZYDBGS", "false");
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("data", customer);
				map.put("flag", "true");
				map.put("message", "操作成功!");
				//查询评级信息
				//是否担保公司
				Map<String, Object> isZYDBGS = conGuarantOrgInfoMapper.isZYDBGS(partyId);
				if(isZYDBGS!=null){
					map.put("isZYDBGS", "true");
					//公司预用额度---》已用额度----》担保公司信息----》担保公司额度
					//预用额度 返回值：USEAMT
					Map<String, Object> comMoney = conGuarantOrgInfoMapper.comMoney(partyId);
					//已用额度 返回值：USEDAMT
					Map<String, Object> comMoney1 = conGuarantOrgInfoMapper.comMoney1(partyId);
					//担保公司信息
					ConGuarantOrgInfo conGuarantOrgInfo = conGuarantOrgInfoMapper.selectByPartyId(partyId);
					//担保公司额度
					CrdThirdPartyLimit crdThirdPartyLimit = crdThirdPartyLimitMapper.selectByPartyId(partyId);
					map.put("comMoney", comMoney);
					map.put("comMoney1", comMoney1);
					map.put("conGuarantOrgInfo",conGuarantOrgInfo );
					map.put("crdThirdPartyLimit",crdThirdPartyLimit );
				} else{
					map.put("isZYDBGS", "false");
				}
			}
		} else{
			throw new RuntimeException("该客户信息不存在！");
		}
		return map;
	}

	public Map<String, Object> queryApplyInfoByApplyId(String applyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		BizApply bizApply = bizApplyMapper.selectByPrimaryKey(applyId);
		if(bizApply!=null){
			map.put("bizApply", bizApply);
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{
			throw new RuntimeException("业务申请applyId:"+applyId+"未查到业务信息！");
		}
		return map;
	}

	public Map<String, Object> queryCompanyStatus(String partyId, String conPartyId) {//partyId担保人id
		Map<String, Object> map = new HashMap<String, Object>();
		ConGuaranteQuota conGuaranteQuota = new ConGuaranteQuota();
		conGuaranteQuota.setConPartyId(conPartyId);
		conGuaranteQuota.setPartyId(conPartyId);
		ConGuaranteQuota result = conGuaranteQuotaMapper.selectByPrimaryKey(conGuaranteQuota);
		if(result==null){
			map.put("conGuaranteQuota", result);
			map.put("flag", "true");
			map.put("message", "操作成功!");
			return map;
		} else{
			Map<String, Object> obj = conGuarantOrgInfoMapper.getConPartyAmt(conPartyId);
			if(obj!=null){
				obj = BeanUtils.changeUnderlineToHump(obj);
			}
			map.put("conGuaranteQuota", result);
			map.put("obj", obj);
			map.put("flag", "true");
			map.put("message", "操作成功!");
		}
		return map;
	}

	public Map<String, Object> addGuaranteeApplyTbGrtGuaranteer(BigDecimal suretyAmt, String applyId, String userNum,
			String orgNum, String partyId, String[] accnoWay, String currencyCd, String isGuaranteeCompany,
			String guaranteeForm) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(isGuaranteeCompany.equals(Constant.GUARANTEE_COMPANY)){//是专业担保公司
			//1.核对保证金存储方式
			Map<String, Object> resultAccnoWayMap = conGuarantOrgInfoMapper.RBIZ_0217(partyId);
			if(resultAccnoWayMap!=null){
				if(resultAccnoWayMap.get("ACCNO_WAY")==null || resultAccnoWayMap.get("ACCNO_WAY").toString().equals("")){
					throw new RuntimeException("该担保公司未设置保证金储存方式");
				} else{
					String resultAccWay = resultAccnoWayMap.get("ACCNO_WAY").toString();
					for(String str : accnoWay){
						if(!resultAccWay.contains(str)){
							throw new RuntimeException("该担保公司保证金储存方式不包含:'"+str+"'");
						}
					}
				}
			} else{
				throw new RuntimeException("未查到该担保公司的专业担保机构合作协议");
			}
			//2.查询业务申请详情,排除借款人与保证人相同
			BizApply bizApply = bizApplyMapper.selectByPrimaryKey(applyId);
			if(bizApply.getPartyId().equals(partyId)){
				throw new RuntimeException("借款人与保证人不能相同！");
			}
			//3.查询当前业务申请保证人列表,保证保证人不能重复
			List<GuarantorBean> listGuarantor =  conGuarantOrgInfoMapper.getGuaranteerList(applyId);
			if(listGuarantor!=null && listGuarantor.size()>0){
				for(GuarantorBean guarantor : listGuarantor){
					if(guarantor.getPartyId().equals(partyId)){
						throw new RuntimeException("'"+guarantor.getPartyId()+"'已经是该业务保证人,不能重复添加！");
					}
				}
			}
			//4.保存
			Date date = new Date();
			GrtGuaranteeBasic grtGuaranteeBasic = new GrtGuaranteeBasic();
			StringBuilder sb = new StringBuilder();
			for(String str : accnoWay){
				sb.append(str+",");
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			grtGuaranteeBasic.setAccnoWay(sb.toString());
			grtGuaranteeBasic.setCreateTime(date);
			grtGuaranteeBasic.setCurrencyCd(currencyCd);
			grtGuaranteeBasic.setGuaranteeForm(guaranteeForm);//TODO 担保公司为null,非担保公司为02？
			grtGuaranteeBasic.setGuaranteeType("04");//04代表保证人
			//grtGuaranteeBasic.setGuaranteeWay(guaranteeWay);
			//grtGuaranteeBasic.setIfDataMove(ifDataMove);
			//grtGuaranteeBasic.setIfTopAmt(ifTopAmt);
			grtGuaranteeBasic.setIsGuaranteeCompany(isGuaranteeCompany);
			grtGuaranteeBasic.setOrgNum(orgNum);
			grtGuaranteeBasic.setPartyId(partyId);
			//grtGuaranteeBasic.setPartyNo(partyNo);
			grtGuaranteeBasic.setSuretyAmt(suretyAmt);
			grtGuaranteeBasic.setUpdateTime(date);
			grtGuaranteeBasic.setUserNum(userNum);
			grtGuaranteeBasic.setSuretyId(UUIDGenerator.getUUID());
			//TODO 可用保证金额，默认等于申请金额
			grtGuaranteeBasic.setUsableGuaranteeLimit(suretyAmt);
			int i = grtGuaranteeBasicMapper.insert(grtGuaranteeBasic);
			if(i<=0){
				throw new RuntimeException("TB_GRT_GUARANTEE_BASIC--->保存担保基本信息失败！");
			}
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setCreateTime(date);
			//bizGrtRel.setApproveId(approveId);
			//bizGrtRel.setMortgageRate(mortgageRate);
			bizGrtRel.setRelationId(UUIDGenerator.getUUID());
			bizGrtRel.setSuretyAmt(suretyAmt);
			bizGrtRel.setSuretyId(grtGuaranteeBasic.getSuretyId());
			bizGrtRel.setUpdateTime(date);
			bizGrtRel.setSuretyType("04");//04代表保证人
			i = bizGrtRelMapper.insert(bizGrtRel);
			if(i<=0){
				throw new RuntimeException("TB_BIZ_GRT_REL--->保存押品关联关系表失败！");
			}
		} else{//非专业担保公司
			//1.查询业务申请详情,排除借款人与保证人相同
			BizApply bizApply = bizApplyMapper.selectByPrimaryKey(applyId);
			if(bizApply.getPartyId().equals(partyId)){
				throw new RuntimeException("借款人与保证人不能相同！");
			}
			//2.查询当前业务申请保证人列表,保证保证人不能重复
			List<GuarantorBean> listGuarantor =  conGuarantOrgInfoMapper.getGuaranteerList(applyId);
			if(listGuarantor!=null && listGuarantor.size()>0){
				for(GuarantorBean guarantor : listGuarantor){
					if(guarantor.getPartyId().equals(partyId)){
						throw new RuntimeException("'"+guarantor.getPartyId()+"'已经是该业务保证人,不能重复添加！");
					}
				}
			}
			//3.保存
			Date date = new Date();
			GrtGuaranteeBasic grtGuaranteeBasic = new GrtGuaranteeBasic();
			grtGuaranteeBasic.setCreateTime(date);
			grtGuaranteeBasic.setCurrencyCd(currencyCd);
			grtGuaranteeBasic.setGuaranteeForm(guaranteeForm);//TODO 担保公司为null,非担保公司为02？
			grtGuaranteeBasic.setGuaranteeType("04");//04代表保证人
			//grtGuaranteeBasic.setGuaranteeWay(guaranteeWay);
			//grtGuaranteeBasic.setIfDataMove(ifDataMove);
			//grtGuaranteeBasic.setIfTopAmt(ifTopAmt);
			grtGuaranteeBasic.setIsGuaranteeCompany(isGuaranteeCompany);
			grtGuaranteeBasic.setOrgNum(orgNum);
			grtGuaranteeBasic.setPartyId(partyId);
			//grtGuaranteeBasic.setPartyNo(partyNo);
			grtGuaranteeBasic.setSuretyAmt(suretyAmt);
			grtGuaranteeBasic.setUpdateTime(date);
			grtGuaranteeBasic.setUserNum(userNum);
			grtGuaranteeBasic.setSuretyId(UUIDGenerator.getUUID());
			//TODO 可用保证金额，默认等于申请金额
			grtGuaranteeBasic.setUsableGuaranteeLimit(suretyAmt);
			int i = grtGuaranteeBasicMapper.insert(grtGuaranteeBasic);
			if(i<=0){
				throw new RuntimeException("TB_GRT_GUARANTEE_BASIC--->保存担保基本信息失败！");
			}
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setCreateTime(date);
			//bizGrtRel.setApproveId(approveId);
			//bizGrtRel.setMortgageRate(mortgageRate);
			bizGrtRel.setRelationId(UUIDGenerator.getUUID());
			bizGrtRel.setSuretyAmt(suretyAmt);
			bizGrtRel.setSuretyId(grtGuaranteeBasic.getSuretyId());
			bizGrtRel.setUpdateTime(date);
			bizGrtRel.setSuretyType("04");//04代表保证人
			i = bizGrtRelMapper.insert(bizGrtRel);
			if(i<=0){
				throw new RuntimeException("TB_BIZ_GRT_REL--->保存押品关联关系表失败！");
			}
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	
	public Map<String, Object> updateGuaranteeApplyTbGrtGuaranteer(String suretyId, BigDecimal suretyAmt,
			String applyId, String userNum, String orgNum, String partyId, String[] accnoWay, String currencyCd,
			String isGuaranteeCompany, String guaranteeForm) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(isGuaranteeCompany.equals(Constant.GUARANTEE_COMPANY)){//是专业担保公司
			//1.核对保证金存储方式
			Map<String, Object> resultAccnoWayMap = conGuarantOrgInfoMapper.RBIZ_0217(partyId);
			if(resultAccnoWayMap!=null){
				if(resultAccnoWayMap.get("ACCNO_WAY")==null || resultAccnoWayMap.get("ACCNO_WAY").toString().equals("")){
					throw new RuntimeException("该担保公司未设置保证金储存方式");
				} else{
					String resultAccWay = resultAccnoWayMap.get("ACCNO_WAY").toString();
					for(String str : accnoWay){
						if(!resultAccWay.contains(str)){
							throw new RuntimeException("该担保公司保证金储存方式不包含:'"+str+"'");
						}
					}
				}
			} else{
				throw new RuntimeException("未查到该担保公司的专业担保机构合作协议");
			}
			//4.更新
			Date date = new Date();
			GrtGuaranteeBasic grtGuaranteeBasic = new GrtGuaranteeBasic();
			StringBuilder sb = new StringBuilder();
			for(String str : accnoWay){
				sb.append(str+",");
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			grtGuaranteeBasic.setAccnoWay(sb.toString());
			grtGuaranteeBasic.setCreateTime(date);
			grtGuaranteeBasic.setCurrencyCd(currencyCd);
			grtGuaranteeBasic.setGuaranteeForm(guaranteeForm);//TODO 担保公司为null,非担保公司为02？
			grtGuaranteeBasic.setGuaranteeType("04");//04代表保证人
			//grtGuaranteeBasic.setGuaranteeWay(guaranteeWay);
			//grtGuaranteeBasic.setIfDataMove(ifDataMove);
			//grtGuaranteeBasic.setIfTopAmt(ifTopAmt);
			grtGuaranteeBasic.setIsGuaranteeCompany(isGuaranteeCompany);
			grtGuaranteeBasic.setOrgNum(orgNum);
			grtGuaranteeBasic.setPartyId(partyId);
			//grtGuaranteeBasic.setPartyNo(partyNo);
			grtGuaranteeBasic.setSuretyAmt(suretyAmt);
			grtGuaranteeBasic.setUpdateTime(date);
			grtGuaranteeBasic.setUserNum(userNum);
			grtGuaranteeBasic.setSuretyId(suretyId);
			//TODO 可用保证金额，默认等于申请金额
			grtGuaranteeBasic.setUsableGuaranteeLimit(suretyAmt);
			int i = grtGuaranteeBasicMapper.updateByPrimaryKeySelective(grtGuaranteeBasic);
			if(i<=0){
				throw new RuntimeException("TB_GRT_GUARANTEE_BASIC--->更新担保基本信息失败！");
			}
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setCreateTime(date);
			//bizGrtRel.setApproveId(approveId);
			//bizGrtRel.setMortgageRate(mortgageRate);
			bizGrtRel.setRelationId(UUIDGenerator.getUUID());
			bizGrtRel.setSuretyAmt(suretyAmt);
			bizGrtRel.setSuretyId(grtGuaranteeBasic.getSuretyId());
			bizGrtRel.setUpdateTime(date);
			bizGrtRel.setSuretyType("04");//04代表保证人
			i = bizGrtRelMapper.updateBySuretyIdSelective(bizGrtRel);
			if(i<=0){
				throw new RuntimeException("TB_BIZ_GRT_REL--->更新押品关联关系表失败！");
			}
		} else{//非专业担保公司
			//更新
			Date date = new Date();
			GrtGuaranteeBasic grtGuaranteeBasic = new GrtGuaranteeBasic();
			grtGuaranteeBasic.setCreateTime(date);
			grtGuaranteeBasic.setCurrencyCd(currencyCd);
			grtGuaranteeBasic.setGuaranteeForm(guaranteeForm);//TODO 担保公司为null,非担保公司为02？
			grtGuaranteeBasic.setGuaranteeType("04");//04代表保证人
			//grtGuaranteeBasic.setGuaranteeWay(guaranteeWay);
			//grtGuaranteeBasic.setIfDataMove(ifDataMove);
			//grtGuaranteeBasic.setIfTopAmt(ifTopAmt);
			grtGuaranteeBasic.setIsGuaranteeCompany(isGuaranteeCompany);
			grtGuaranteeBasic.setOrgNum(orgNum);
			grtGuaranteeBasic.setPartyId(partyId);
			//grtGuaranteeBasic.setPartyNo(partyNo);
			grtGuaranteeBasic.setSuretyAmt(suretyAmt);
			grtGuaranteeBasic.setUpdateTime(date);
			grtGuaranteeBasic.setUserNum(userNum);
			grtGuaranteeBasic.setSuretyId(suretyId);
			//TODO 可用保证金额，默认等于申请金额
			grtGuaranteeBasic.setUsableGuaranteeLimit(suretyAmt);
			int i = grtGuaranteeBasicMapper.updateByPrimaryKeySelective(grtGuaranteeBasic);
			if(i<=0){
				throw new RuntimeException("TB_GRT_GUARANTEE_BASIC--->更新担保基本信息失败！");
			}
			BizGrtRel bizGrtRel = new BizGrtRel();
			bizGrtRel.setApplyId(applyId);
			bizGrtRel.setCreateTime(date);
			//bizGrtRel.setApproveId(approveId);
			//bizGrtRel.setMortgageRate(mortgageRate);
			bizGrtRel.setSuretyAmt(suretyAmt);
			bizGrtRel.setSuretyId(grtGuaranteeBasic.getSuretyId());
			bizGrtRel.setUpdateTime(date);
			bizGrtRel.setSuretyType("04");//04代表保证人
			i = bizGrtRelMapper.updateBySuretyIdSelective(bizGrtRel);
			if(i<=0){
				throw new RuntimeException("TB_BIZ_GRT_REL--->更新押品关联关系表失败！");
			}
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}

	public Map<String, Object> selectGuaranteeConZh(String statusCd, String partyId,Integer pageNum,Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		ConGuarantOrgInfo conGuarantOrgInfo = conGuarantOrgInfoMapper.selectByPartyId(partyId);
		if(conGuarantOrgInfo==null){
			throw new RuntimeException("该担保公司未签署专业担保机构合作协议,查询担保公司账户信息失败");
		}
		PageHelper.startPage(pageNum,pageSize);
		List<ConZh> list = conZhMapper.selectByContractId(conGuarantOrgInfo.getContractId());
		PageInfo<ConZh> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}

	public Map<String, Object> getGuaranteerList(Integer pageNum, Integer pageSize, String applyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum,pageSize);
		List<GuarantorBean> list =  conGuarantOrgInfoMapper.getGuaranteerList(applyId);
		PageInfo<GuarantorBean> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}

	public Map<String, Object> getGuaranteerBySuretyId(String suretyId,String applyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//1.担保品基本信息
		GrtGuaranteeBasic grtGuaranteeBasic = grtGuaranteeBasicMapper.selectByPrimaryKey(suretyId);
		if(grtGuaranteeBasic==null){
			throw new RuntimeException("未查询到该保证人信息");
		}
		map.put("grtGuaranteeBasic", grtGuaranteeBasic);
		String partyId = grtGuaranteeBasic.getPartyId();
		//2.额度与客户类型信息
		Map<String,Object> customer = naturalPersonMapper.findByPartyId(partyId);
		if(customer==null){
			throw new RuntimeException("未查询到该保证人信息");
		}
		customer = BeanUtils.changeUnderlineToHump(customer);
		map.put("data", customer);
		if(customer.get("partyTypeCd").toString().equals(Constant.CUSTOMER_TYPE_NATURAL_PERSON)){ //自然人客户
			map.put("isZYDBGS", "false");
		} else{
			//查询评级信息
			//是否担保公司
			Map<String, Object> isZYDBGS = conGuarantOrgInfoMapper.isZYDBGS(partyId);
			if(isZYDBGS!=null){
				map.put("isZYDBGS", "true");
				//公司预用额度---》已用额度----》担保公司信息----》担保公司额度
				//预用额度 返回值：USEAMT
				Map<String, Object> comMoney = conGuarantOrgInfoMapper.comMoney(partyId);
				//已用额度 返回值：USEDAMT
				Map<String, Object> comMoney1 = conGuarantOrgInfoMapper.comMoney1(partyId);
				//担保公司信息
				ConGuarantOrgInfo conGuarantOrgInfo = conGuarantOrgInfoMapper.selectByPartyId(partyId);
				//担保公司额度
				CrdThirdPartyLimit crdThirdPartyLimit = crdThirdPartyLimitMapper.selectByPartyId(partyId);
				map.put("comMoney", comMoney);
				map.put("comMoney1", comMoney1);
				map.put("conGuarantOrgInfo",conGuarantOrgInfo );
				map.put("crdThirdPartyLimit",crdThirdPartyLimit );
			} else{
				map.put("isZYDBGS", "false");
			}
		}
		//3.业务信息
		BizApply bizApply = bizApplyMapper.selectByPrimaryKey(applyId);
		if(bizApply==null){
			throw new RuntimeException("业务申请applyId:"+applyId+"未查到业务信息！");
		}
		map.put("bizApply", bizApply);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}

	public Map<String, Object> deleteGuaranteeApplyTbGrtGuaranteerBySuretyId(String suretyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = bizGrtRelMapper.deleteBySuretyId(suretyId);
		if(i<=0){
			throw new RuntimeException("删除保证人信息失败！");
		}
		i = grtGuaranteeBasicMapper.deleteByPrimaryKey(suretyId);
		if(i<=0){
			throw new RuntimeException("删除保证人信息失败！");
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}


	
}
