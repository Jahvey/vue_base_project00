/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.BizNumGenerator;
import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.common.util.StringUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.csm.bean.ApplyJxhjBizInfoVo;
import com.cdgit.loan.csm.bean.CsmTbBizAmountDetailApply;
import com.cdgit.loan.csm.bean.CsmTbBizAmoutApply;
import com.cdgit.loan.csm.bean.CsmTbBizApply;
import com.cdgit.loan.csm.bean.CsmTbBizFamilyFinace;
import com.cdgit.loan.csm.bean.CsmTbBizXmxxApply;
import com.cdgit.loan.csm.bean.CsmTbBizXwApply;
import com.cdgit.loan.csm.bean.CsmTbBizYesOrNoApply;
import com.cdgit.loan.csm.bean.CsmTbConLoanrate;
import com.cdgit.loan.csm.mapper.CsmBizApplyMapper;
import com.cdgit.loan.csm.mapper.CsmRuleEngineMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmoutApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizFamilyFinaceMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizXmxxApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizXwApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizYesOrNoApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbConLoanrateMapper;
import com.cdgit.loan.csm.mapper.CsmTbCsmPartyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbIrmInternalRatingResultMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmBizApplyServiceImpl {
	
	@Autowired
	CsmBizApplyMapper bizApplyMapper;
	@Autowired
	CsmTbBizApplyMapper tbBizApplyMapper;
	@Autowired
	CsmTbBizAmountDetailApplyMapper tbBizAmountDetailApplyMapper;
	@Autowired
	CsmTbConLoanrateMapper tbConLoanrateMapper;
	@Autowired
	CsmTbBizXwApplyMapper tbBizXwApplyMapper;
	@Autowired
	CsmTbBizAmoutApplyMapper tbBizAmoutApplyMapper;
	@Autowired
	CsmTbBizFamilyFinaceMapper tbBizFamilyFinaceMapper;
	@Autowired
	CsmTbBizXmxxApplyMapper tbBizXmxxApplyMapper;
	@Autowired
	CsmTbBizYesOrNoApplyMapper tbBizYesOrNoApplyMapper;
	
	@Autowired
	CsmRuleEngineMapper csmRuleEngineMapper;
	@Autowired
	CsmTbCsmPartyPoMapper tbCsmPartyPoMapper;
	@Autowired
	CsmTbBizApproveMapper tbBizApproveMapper;
	@Autowired
	CsmTbIrmInternalRatingResultMapper tbIrmInternalRatingResultMapper;
	
	private Date now = GitUtil.getCurrDate();
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<ApplyJxhjBizInfoVo> getApplyJxhjBizInfo(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ApplyJxhjBizInfoVo> ApplyJxhjBizInfoVoQuery = bizApplyMapper.getApplyJxhjBizInfo(map);
		PageInfo pageInfo=new PageInfo(ApplyJxhjBizInfoVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	 /**
     * 保存业务申请基本信息
     * 
     * */	Map<String, Object> map = new HashMap<>();
    public Map<String, Object> saveAppBizInfo(CsmTbBizApply csmTbBizApply){
    	Map<String, Object> map = new HashMap<>();
    	try {
			String productType = csmTbBizApply.getProductType();
			String guarantyType = csmTbBizApply.getGuarantyType();
			if (StringUtil.isNullOrEmpty(productType)) {
				map.put("code", "201");
		        map.put("msg", "没有获取到产品信息");
		        return map;
			}
			if (!StringUtil.isNullOrEmpty(guarantyType)) {
				if ("02002004".equals(productType) || "02002005".equals(productType)) {
					// 查询担保方式是否以包含抵押，不存在信用
					String[] guaArray = guarantyType.split(",");
					if (GitUtil.contain("02", guaArray) != true || GitUtil.contain("01", guaArray) == true) {
						map.put("code", "201");
				        map.put("msg", "个人住房按揭贷款,个人商用房按揭贷款担保方式必须存在抵押，不存在信用,请检查");
				        return map;
					}
				} else if ("02005001".equals(productType)) {
					// 公积金住房委托贷款，控制为，选择保证+抵押或者抵押方式
					if ("02,04".equals(guarantyType) || "02".equals(guarantyType) || "04,02".equals(guarantyType)) {
					} else {
						map.put("code", "201");
				        map.put("msg", "公积金住房委托贷款担保方式只有保证+抵押或者抵押方式,请检查");
				        return map;
					}
				}
			}
			// 银团，低风险
			if ("1".equals(csmTbBizApply.getIsBankTeamLoan()) || "05".equals(csmTbBizApply.getCreditMode())) {
				if ("05".equals(csmTbBizApply.getCreditMode()) && StringUtil.isNull(csmTbBizApply.getLowRiskBizType())) {
					map.put("code", "201");
			        map.put("msg", "请选择低风险类型");
			        return map;
				}
				// 业务移交
				Integer count = csmRuleEngineMapper.ruleXFE_0002(csmTbBizApply.getPartyId());
				if (count != 0) {
					map.put("code", "201");
			        map.put("msg", "该客户已被纳入[客户移交或者机构拆并],在业务结束前无法申请新的业务");
			        return map;
				}
			} else {// 正常单笔单批
				if (GitUtil.contain(productType, new String[] { "01007012" })) {
					map.put("code", "201");
			        map.put("msg", "福费廷只能申请低风险业务");
			        return map;
				}
				if (GitUtil.contain(productType, new String[] { "01006001", "01006002", "01006010" })) {
					map.put("code", "201");
			        map.put("msg", "贴现产品只能申请低风险业务");
			        return map;
				}
				//客户存在在途授信业务
				Integer count = csmRuleEngineMapper.ruleRBIZ_0001(csmTbBizApply.getPartyId());
				if (count != 0) {
					map.put("code", "201");
			        map.put("msg", "已发起综合授信业务");
			        return map;
				}
				// 客户存在已生效授信业务
				Integer count2 = csmRuleEngineMapper.ruleRBIZ_0002(csmTbBizApply.getPartyId());
				if (count2 != 0) {
					map.put("code", "201");
			        map.put("msg", "已存在生效的综合授信业务");
			        return map;
				}
				// 用信同产品只能一次申请一笔
				Integer count3 = csmRuleEngineMapper.ruleRBIZ_0206(csmTbBizApply.getPartyId(),productType);
				if (count3 != 0) {
					map.put("code", "201");
			        map.put("msg", "该产品已存在在途用信业务申请");
			        return map;
				}
				// 业务移交
				Integer count4 = csmRuleEngineMapper.ruleXFE_0002(csmTbBizApply.getPartyId());
				if (count4 != 0) {
					map.put("code", "201");
			        map.put("msg", "该客户已被纳入[客户移交或者机构拆并],在业务结束前无法申请新的业务");
			        return map;
				}
				// 客户存在在途授信业务
				Integer count5 = csmRuleEngineMapper.ruleRBIZ_0019(csmTbBizApply.getPartyId());
				if (count5 != 0) {
					map.put("code", "201");
			        map.put("msg", "统一授信成员只能发起低风险或银团贷款");
			        return map;
				}
			}
			if (StringUtil.isNotNull(csmTbBizApply.getBizHappenType())) {
				csmTbBizApply.setBizHappenType(tbBizApproveMapper.getPartyBizIds(csmTbBizApply.getPartyId()));
			}
			if (StringUtil.isNotNull(csmTbBizApply.getLoanType())) {
				csmTbBizApply.setLoanType("0");
			}
			if (StringUtil.isNotNull(csmTbBizApply.getTermUnit())) {
				csmTbBizApply.setTermUnit("04");
			}
			if (StringUtil.isNotNull(csmTbBizApply.getIsBankTeamLoan())) {
				csmTbBizApply.setIsBankTeamLoan("0");
			}
			if (StringUtil.isNotNull(csmTbBizApply.getCsmCrdLevel())) {
				csmTbBizApply.setCsmCrdLevel(tbIrmInternalRatingResultMapper.getPartyCreditLevel(csmTbBizApply.getPartyId()));
			}
    		String bizType = "02".equals(tbCsmPartyPoMapper.selectByPrimaryKey(csmTbBizApply.getPartyId()).getPartyTypeCd()) ? "04" : "01";
    		if (csmTbBizApply.getCreditMode() == "03") {
        		csmTbBizApply.setBizType(bizType);
        		csmTbBizApply.setBizTypeFlag(bizType);
        		csmTbBizApply.setApplyModeType("01");
    		} else if (csmTbBizApply.getCreditMode() == "00") {
    			csmTbBizApply.setBizType("02");
        		csmTbBizApply.setBizTypeFlag("10");
        		csmTbBizApply.setApplyModeType("01");
    		} else if (csmTbBizApply.getCreditMode() == "02") {
    			csmTbBizApply.setBizType("02");
        		csmTbBizApply.setBizTypeFlag("02");
        		csmTbBizApply.setApplyModeType("01");
    		} else if (csmTbBizApply.getCreditMode() == "05") {
    			csmTbBizApply.setBizType(bizType);
        		csmTbBizApply.setBizTypeFlag("07");
        		csmTbBizApply.setApplyModeType("02");
    		} 
    		//基本信息保存
    		csmTbBizApply.setApplyId(UUIDGenerator.getUUID());
    		csmTbBizApply.setBizNum("YW" + BizNumGenerator.getBizNum("SEQ_BIZ_PF"));
    		csmTbBizApply.setStatusType("01");
    		csmTbBizApply.setCreateTime(now);
    		csmTbBizApply.setApplyDate(GitUtil.getBusiDate());
    		int back = tbBizApplyMapper.insertSelective(csmTbBizApply);
            if (back == 0) {
		        map.put("code", "201");
		        map.put("msg", "保存失败!");
		        return map;
			}else {
			    map.put("code", "200");
		        map.put("msg", "保存成功!");
			}
            //额度信息保存
            CsmTbBizAmoutApply csmTbBizAmoutApply = new CsmTbBizAmoutApply();
            csmTbBizAmoutApply.setAmountId(UUIDGenerator.getUUID());
            csmTbBizAmoutApply.setPartyId(csmTbBizApply.getPartyId());
            csmTbBizAmoutApply.setCreateTime(now);
            int aback = tbBizAmoutApplyMapper.insertSelective(csmTbBizAmoutApply);
            if (aback == 0) {
		        map.put("code", "201");
		        map.put("msg", "保存失败!");
		        return map;
			}else {
			    map.put("code", "200");
		        map.put("msg", "保存成功!");
			}
            //业务明细保存
            CsmTbBizAmountDetailApply csmTbBizAmountDetailApply = new CsmTbBizAmountDetailApply();
            csmTbBizAmountDetailApply.setAmountDetailId(UUIDGenerator.getUUID());
            csmTbBizAmountDetailApply.setApplyId(csmTbBizApply.getApplyId());
            csmTbBizAmountDetailApply.setAmountId(csmTbBizAmoutApply.getAmountId());
            csmTbBizAmountDetailApply.setCreditMode(csmTbBizApply.getCreditMode());
            csmTbBizAmountDetailApply.setCycleInd("0");
            csmTbBizAmountDetailApply.setCurrencyCd("CNY");
            csmTbBizAmountDetailApply.setCreateTime(now);
            int adback = tbBizAmountDetailApplyMapper.insertSelective(csmTbBizAmountDetailApply);
            if (adback == 0) {
		        map.put("code", "201");
		        map.put("msg", "保存失败!");
		        return map;
			}else {
			    map.put("code", "200");
		        map.put("msg", "保存成功!");
			}
            // TODO: 创建流程并换得流程ID : processId
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "保存失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
	  
    /**
     * 更新业务申请基本信息
     * 
     * */
    public Map<String, Object> updateAppBizInfo(CsmTbBizApply csmTbBizApply){
    	Map<String, Object> map = new HashMap<>();
    	CsmTbBizApply entity = tbBizApplyMapper.selectByPrimaryKey(csmTbBizApply.getApplyId());
    	if(!"01".equals(entity.getStatusType())) {
    		 map.put("code", "201");
		     map.put("msg", "非[未提交]状态数据不允许操作");
		     return map;
    	}
    	try {
    		csmTbBizApply.setApplyId(csmTbBizApply.getBizId());
    		csmTbBizApply.setTermNum(csmTbBizApply.getTermNum());
    		csmTbBizApply.setGuarantyType(csmTbBizApply.getGuarantyType());
    		csmTbBizApply.setUpdateTime(now);
    		int back = tbBizApplyMapper.updateByPrimaryKeySelective(csmTbBizApply);
            if (back == 0) {
		        map.put("code", "201");
		        map.put("msg", "保存失败!");
			}else {
			    map.put("code", "200");
		        map.put("msg", "保存成功!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "保存失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    /**
     * 
     * 保存更新业务明细
     * 
     * */
    public Map<String, Object> saveAndUpdateXwProductDetail(CsmTbBizAmountDetailApply amountDetailApply, CsmTbConLoanrate loanrate, 
    		CsmTbBizXwApply xwApply, CsmTbBizAmoutApply amoutApply, CsmTbBizApply apply){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		//明细
    		CsmTbBizAmountDetailApply entityADA = tbBizAmountDetailApplyMapper.selectByPrimaryKey(amountDetailApply.getAmountDetailId());
    		if (entityADA == null) {
				//保存
    			amountDetailApply.setAmountDetailId(UUIDGenerator.getUUID());
    			amountDetailApply.setCreateTime(GitUtil.getBusiDate());
	    		int back = tbBizAmountDetailApplyMapper.insertSelective(amountDetailApply);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
			        return map;
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		} else {
    			//更新
    			amountDetailApply.setUpdateTime(GitUtil.getBusiDate());
    			amountDetailApply.setRmbAmt(amountDetailApply.getRmbAmt());
    			int back = tbBizAmountDetailApplyMapper.updateByPrimaryKeySelective(amountDetailApply);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
			        return map;
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		}
    		//利率
    		CsmTbConLoanrate entityL = tbConLoanrateMapper.selectByPrimaryKey(loanrate.getLoanrateId());
    		if (entityL == null) {
				//保存
    			loanrate.setLoanrateId(UUIDGenerator.getUUID());
    			loanrate.setCreateTime(GitUtil.getBusiDate());
	    		int back = tbConLoanrateMapper.insertSelective(loanrate);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
			        return map;
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		} else {
    			//更新
    			loanrate.setUpdateTime(GitUtil.getBusiDate());
    			int back = tbConLoanrateMapper.updateByPrimaryKeySelective(loanrate);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
			        return map;
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		}
    		//小微明细
    		CsmTbBizXwApply entityXA = tbBizXwApplyMapper.selectByPrimaryKey(xwApply.getWtxmId());
    		if (entityXA == null) {
				//保存
    			xwApply.setWtxmId(UUIDGenerator.getUUID());
    			xwApply.setCreateTime(GitUtil.getBusiDate());
	    		int back = tbBizXwApplyMapper.insertSelective(xwApply);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
			        return map;
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		} else {
    			//更新
    			xwApply.setUpdateTime(GitUtil.getBusiDate());
    			amountDetailApply.setAmountDetailId(xwApply.getAmountDetailId());
    			int back = tbBizXwApplyMapper.updateByPrimaryKeySelective(xwApply);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
			        return map;
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		}
    		//额度更新到基本信息
    		amoutApply.setUpdateTime(GitUtil.getBusiDate());
			int aback = tbBizAmoutApplyMapper.updateByPrimaryKeySelective(amoutApply);
            if (aback == 0 ) {
		        map.put("code", "201");
		        map.put("msg", "保存失败!");
		        return map;
			}else {
			    map.put("code", "200");
		        map.put("msg", "保存成功!");
			}
    		//业务基本信息
			apply.setUpdateTime(GitUtil.getBusiDate());
			int back = tbBizApplyMapper.updateByPrimaryKeySelective(apply);
            if (back == 0 ) {
		        map.put("code", "201");
		        map.put("msg", "保存失败!");
		        return map;
			}else {
			    map.put("code", "200");
		        map.put("msg", "保存成功!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "保存失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    /**
     * 
     * 保存更新家庭财务信息
     * 
     * */
    public Map<String, Object> saveAndUpdateFamilyFinace(CsmTbBizFamilyFinace familyFinace){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		CsmTbBizFamilyFinace entity = tbBizFamilyFinaceMapper.selectByPrimaryKey(familyFinace.getFinanceId());
    		if (entity == null) {
				//保存
    			familyFinace.setFinanceId(UUIDGenerator.getUUID());
    			familyFinace.setCreateTime(GitUtil.getBusiDate());
	    		int back = tbBizFamilyFinaceMapper.insertSelective(familyFinace);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		} else {
    			//更新
    			familyFinace.setUpdateTime(GitUtil.getBusiDate());
    			int back = tbBizFamilyFinaceMapper.updateByPrimaryKeySelective(familyFinace);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		}
    	
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "保存失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    /**
     * 
     * 保存更新合作项目额度
     * 
     * */
    public Map<String, Object> saveAndUpdateXmxxApply(CsmTbBizXmxxApply xmxxApply){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		CsmTbBizXmxxApply entity = tbBizXmxxApplyMapper.selectByPrimaryKey(xmxxApply.getRelateId());
    		if (entity == null) {
				//保存
    			xmxxApply.setRelateId(UUIDGenerator.getUUID());
    			xmxxApply.setCreateTime(GitUtil.getBusiDate());
	    		int back = tbBizXmxxApplyMapper.insertSelective(xmxxApply);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		} else {
    			//更新
    			xmxxApply.setUpdateTime(GitUtil.getBusiDate());
    			int back = tbBizXmxxApplyMapper.updateByPrimaryKeySelective(xmxxApply);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		}
    	
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "保存失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
   
    
    //贴息信息
    
    
    //
    /**
     * 
     * 保存更新监管保送信息
     * 
     * */
    public Map<String, Object> saveAndUpdateYesOrNoApply(CsmTbBizYesOrNoApply yesOrNoApply){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		CsmTbBizYesOrNoApply entity = tbBizYesOrNoApplyMapper.selectByPrimaryKey(yesOrNoApply.getYesornoId());
    		if (entity == null) {
				//保存
    			yesOrNoApply.setYesornoId(UUIDGenerator.getUUID());
	    		int back = tbBizYesOrNoApplyMapper.insertSelective(yesOrNoApply);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		} else {
    			//更新
    			int back = tbBizYesOrNoApplyMapper.updateByPrimaryKeySelective(yesOrNoApply);
	            if (back == 0 ) {
			        map.put("code", "201");
			        map.put("msg", "保存失败!");
				}else {
				    map.put("code", "200");
			        map.put("msg", "保存成功!");
				}
    		}
    	
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "保存失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
}
