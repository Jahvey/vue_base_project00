package com.cdgit.loan.irm.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.DateUtil;
import com.cdgit.loan.common.util.StringUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.user.mapper.TbCsmPartyMapper;
import com.cdgit.loan.customerManage.bean.NaturalPerson;
import com.cdgit.loan.customerManage.mapper.NaturalPersonMapper;
import com.cdgit.loan.irm.bean.AdJustInfoBean;
import com.cdgit.loan.irm.bean.AddFinanceinfoCriteria;
import com.cdgit.loan.irm.bean.AddNonFinancialInfoCriteria;
import com.cdgit.loan.irm.bean.AdjustOption;
import com.cdgit.loan.irm.bean.IndexEntity;
import com.cdgit.loan.irm.bean.IrmCriteria;
import com.cdgit.loan.irm.bean.IrmInfoBean;
import com.cdgit.loan.irm.bean.IrmOverRecordInfo;
import com.cdgit.loan.irm.bean.NonFinanceInfoBean;
import com.cdgit.loan.irm.bean.NonFinancialPropertyInfo;
import com.cdgit.loan.irm.bean.ScoreBean;
import com.cdgit.loan.irm.bean.Selector;
import com.cdgit.loan.irm.bean.TbAccCustomerFinance;
import com.cdgit.loan.irm.bean.TbAccFinanceIndexData;
import com.cdgit.loan.irm.bean.TbIrmAdjustOptions;
import com.cdgit.loan.irm.bean.TbIrmFinancialInfo;
import com.cdgit.loan.irm.bean.TbIrmIndexCalc;
import com.cdgit.loan.irm.bean.TbIrmIndexScore;
import com.cdgit.loan.irm.bean.TbIrmInternalRatingResult;
import com.cdgit.loan.irm.bean.TbIrmModelIndex;
import com.cdgit.loan.irm.bean.TbIrmModelScale;
import com.cdgit.loan.irm.bean.TbIrmNonFinancialInfo;
import com.cdgit.loan.irm.bean.TbIrmRatingEngineCalc;
import com.cdgit.loan.irm.bean.TbIrmRatingFinIndex;
import com.cdgit.loan.irm.bean.TbIrmRatingIndexData;
import com.cdgit.loan.irm.bean.TbIrmRatingModel;
import com.cdgit.loan.irm.bean.TbIrmRatingPara;
import com.cdgit.loan.irm.bean.TbIrmScaleDef;
import com.cdgit.loan.irm.bean.irmReportNonFinanceInfo;
import com.cdgit.loan.irm.mapper.IrmMapper;
import com.cdgit.loan.irm.mapper.TbAccCustomerFinanceMapper;
import com.cdgit.loan.irm.mapper.TbIrmInternalRatingResultMapper;
import com.cdgit.loan.mycustomer.corporation.bean.TbAccFinanceStatementData;
import com.cdgit.loan.user.bean.TbCsmCorporation;
import com.cdgit.loan.user.bean.TbCsmNaturalPerson;
import com.cdgit.loan.user.bean.TbCsmParty;
import com.cdgit.loan.user.bean.TbIrmInternalRatingApply;
import com.cdgit.loan.user.mapper.TbCsmCorporationMapper;
import com.cdgit.loan.user.mapper.TbIrmInternalRatingApplyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

@Service
@Transactional
public class IrmServiceImpl {
	
	@Autowired
	IrmMapper irmMapper;
	@Autowired
	TbCsmPartyMapper tbCsmPartyMapper;
	@Autowired
	TbAccCustomerFinanceMapper tbAccCustomerFinanceMapper;
	@Autowired
	NaturalPersonMapper naturalPersonMapper;
	@Autowired
	TbIrmInternalRatingApplyMapper tbIrmInternalRatingApplyMapper;
	@Autowired 
	TbCsmCorporationMapper tbCsmCorporationMapper;
	@Autowired
	TbIrmInternalRatingResultMapper tbIrmInternalRatingResultMapper;
	public  Map<String, Object> queryPaginationIrm(Integer pageNum, Integer pageSize, String partyId,String thirdPartyTypeCd){
		Map<String, Object> map = new HashMap<>();
    	try {
    		IrmCriteria criteria = new IrmCriteria();
    		criteria.setPartyId(partyId);
    		criteria.setThirdPartyTypeCd(thirdPartyTypeCd);
    		PageHelper.startPage(pageNum,pageSize);
        	List<IrmInfoBean> irmList = irmMapper.queryPaginationIrm(criteria);
        	PageInfo pageInfo=new PageInfo(irmList,pageSize);
        	map.put("code", "200");
			map.put("msg", "查询成功！");
			map.put("data", pageInfo);
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询失败！异常");
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	
	public Map<String,Object> createIrmApply(String partyId,boolean choose,String pjlx){
		Map<String, Object> map = new HashMap<>();
		String msg = "发起评级成功";
		String code ="200";
		try {
			String ratingModelCd = "";
			/*******评级开始*********/
			//1：判断choose企业成立未满 1 年或从事主要经营活动未满 1 年 || {true:是，false：否}
			if(choose){//是-》1-1：获取评级模型
				ratingModelCd = this.getIrmModel(partyId, choose, pjlx);
			}else{//否-》1-2：赋值财报信息
				//初始赋值财报信息
				TbAccCustomerFinance tbAccCustomerFinance = new TbAccCustomerFinance();
				tbAccCustomerFinance.setPartyId(partyId);
				tbAccCustomerFinance.setFinanceStatusCd("02");
				tbAccCustomerFinance.setFinanceTypeCd("1");
				tbAccCustomerFinance.setFinanceTypeCd("002");
				//
				//查询是否商户
				TbCsmCorporation corporation = tbCsmCorporationMapper.selectByPrimaryKey(partyId);
				if(corporation != null){//对公客户
					
					String corpCustomerTypeCd = corporation.getCorpCustomerTypeCd();
					if("1".equals(corporation.getThirdCustTypeCd())){//担保公司
						tbAccCustomerFinance.setCustomerTypeCd("006");
						List<TbAccCustomerFinance> customerFinances_006 = tbAccCustomerFinanceMapper.queryTbAccCustomerFinanceMapperByParams(tbAccCustomerFinance);
						if(customerFinances_006.size() > 0){
							String result = this.validCusGm(corporation, pjlx);
							if("OK".equals(result)){
								//验证通过，获取评级模型
								ratingModelCd = this.getIrmModel(partyId, choose, pjlx);
							}else{
								code = "201";
								msg = this.changeMsg(result);
							}
						}else{
							tbAccCustomerFinance.setCustomerTypeCd("002");
							List<TbAccCustomerFinance> customerFinances_002 = tbAccCustomerFinanceMapper.queryTbAccCustomerFinanceMapperByParams(tbAccCustomerFinance);
							if(customerFinances_002.size() > 0){
								String result = this.validCusGm(corporation, pjlx);
								if("OK".equals(result)){
									//验证通过，获取评级模型
									ratingModelCd = this.getIrmModel(partyId, choose, pjlx);
								}else{
									code = "201";
									msg = this.changeMsg(result);
								}
								
							}else{
								//是否事业单位
								if("2".equals(corporation.getCorpCustomerTypeCd())){
									//评级模型T1
									ratingModelCd = "T1";
								}else{
									code = "201";
									msg = "无年报信息";
								}
							}
						}
					}else if("3".equals(corpCustomerTypeCd)){//机关
						//机关获取评级类型=3的评级模型
						pjlx = "3";
						ratingModelCd = this.getIrmModel(partyId, choose, pjlx);
					}else{
						//判断是否对私客户
						NaturalPerson naturalPerson = naturalPersonMapper.queryNaturalByPartyId(partyId);
						if(null != naturalPerson){//是对私客户
							ratingModelCd = this.getIrmModel(partyId, choose, pjlx);
						}else{//不是对私客户
							//赋值
							pjlx = "3";
							//查询是否有财报
							List<TbAccCustomerFinance> customerFinances_002 = tbAccCustomerFinanceMapper.queryTbAccCustomerFinanceMapperByParams(tbAccCustomerFinance);
							if(customerFinances_002.size() > 0){
								String result = this.validCusGm(corporation, pjlx);
								if("OK".equals(result)){
									//验证通过，获取评级模型
									ratingModelCd = this.getIrmModel(partyId, choose, pjlx);
								}else{
									code = "201";
									msg = this.changeMsg(result);
								}
							}else{
								//是否事业单位
								if("2".equals(corporation.getCorpCustomerTypeCd())){
									//评级模型T1
									ratingModelCd = "T1";
								}else{
									code = "201";
									msg = "无年报信息";
								}
							}
						}
					}
				}else{
					code = "201";
					msg = "客户不存在";
				}
			}
			
			if("200".equals(code)){
				if(StringUtil.isBlank(ratingModelCd)){
					code = "201";
					msg="获取评级模型失败";//调用当前类方法getIrmModel 返回Null
				}else{
					//打印评级模型
					System.out.println("客户编号："+partyId+"，评级模型："+ratingModelCd);
					//获取营业时间
					String handlingDate = DateUtil.getDate();
					//组装评级信息
					TbIrmInternalRatingApply tbIrmInternalRatingApply = new TbIrmInternalRatingApply();
					String iraApplyId = UUIDGenerator.getUUID();
					tbIrmInternalRatingApply.setIRA_APPLY_ID(iraApplyId);
					tbIrmInternalRatingApply.setPARTY_ID(partyId);
					tbIrmInternalRatingApply.setRATING_MODEL_CD(ratingModelCd);
					tbIrmInternalRatingApply.setRATING_MODEL_VER("1.00");
					tbIrmInternalRatingApply.setALLOW_MODIFY_FLAG("1");
					tbIrmInternalRatingApply.setRATING_STATE("01");
					tbIrmInternalRatingApply.setUSER_NUM("yl0118");
					tbIrmInternalRatingApply.setORG_NUM("0007");
					tbIrmInternalRatingApply.setAPPLY_DATE(DateUtil.StrToDate(handlingDate,"yyyy-MM-dd"));
					tbIrmInternalRatingApply.setRATING_TYPE(pjlx);
					tbIrmInternalRatingApply.setALLOW_TIMES(new Short("99"));
					//插入评级业务信息
					tbIrmInternalRatingApplyMapper.insertSelective(tbIrmInternalRatingApply);
					//创建流程 ---待后面添加
					this.createBpsProcess(iraApplyId, "G01", pjlx);
					map.put("irmApply", tbIrmInternalRatingApply);
					map.put("processInstId", "none");
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			code = "201";
			msg = "发起评级失败！异常";
            e.printStackTrace();
		} finally {
			map.put("code", code);
			map.put("msg", msg);
			map.put("data", "{}");
			return map;
		}
	}
	/**
	 * 查询评级信息
	 * */
	public  Map<String, Object> queryRatingApplyInfo(String applyId){
		Map<String, Object> map = new HashMap<>();
    	try {
    		if(StringUtils.isBlank(applyId)){//判断传入条件评级信息编号是否为空
    			map.put("code", "201");
    			map.put("msg", "查询评级信息失败，查询条件applyId不能为空！");
    			
    		}else{
    			TbIrmInternalRatingApply tbIrmInternalRatingApply = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(applyId);
    			if(tbIrmInternalRatingApply == null){//判断结果
    				map.put("code", "201");
        			map.put("msg", "查询评级信息失败，传入applyId未查询到评级信息，applyID="+applyId);
    			}else{
    				map.put("code", "200");
    				map.put("msg", "查询评级信息isObject成功");
    				map.put("data", tbIrmInternalRatingApply);
    			}
    		}
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询评级信息失败！异常");
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	/**
	 * 通过评级申请id和参与人id获取评级基本信息。
	 * 获取上次评级结果和评级有效期
	 * jj本地化改造
	 * */
	public Map<String, Object> queryCustInfoJj(String partyId,String applyId){
		Map<String, Object> map = new HashMap<>();
    	try {
    		if(StringUtils.isBlank(partyId) || StringUtils.isBlank(applyId)){//判断传入条件评级信息编号是否为空
    			map.put("code", "201");
    			map.put("msg", "获取评级基本信息失败，查询条件applyId、partyId不能为空！");
    			
    		}else{
    			//获取客户信息
    			TbCsmParty tbCsmParty = tbCsmPartyMapper.selectByPrimaryKey(partyId);
    			//查询财报时间
    			String df = irmMapper.getFinancedate(applyId);
    			//查询评级
    			TbIrmInternalRatingApply tbIrmInternalRatingApply = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(applyId);
    			//查询个人信息
    			NaturalPerson naturalPerson = naturalPersonMapper.queryNaturalByPartyId(partyId);
    			//查询公司信息
    			TbCsmCorporation tbCsmCorporation = tbCsmCorporationMapper.selectByPrimaryKey(partyId);
    			//查询经办人信息
    			String orgNum = "";
    			String userNum = "";
    			//查询上次评级结果
    			Map<String,String> params = new HashMap<String,String>();
    			params.put("partyId", partyId);
    			params.put("applyId", applyId);
    			params.put("ratingState", "03");
    			TbIrmInternalRatingResult tbIrmInternalRatingResult = tbIrmInternalRatingResultMapper.selectIrmInternalRatingResultByApplyId(params);
    			if(tbIrmInternalRatingResult != null && StringUtils.isNotBlank(tbIrmInternalRatingResult.getCreditRatingCdOld())){//存量评级数据组装
    				//上次评级结果
    				List<TbIrmInternalRatingResult> tbIrmInternalRatingResult_last = tbIrmInternalRatingResultMapper.selectIrmInternalRatingResultByIrrApplyId(tbIrmInternalRatingResult.getProjectId());
    				for(int i=0;i<tbIrmInternalRatingResult_last.size();i++){
    					if(tbIrmInternalRatingResult_last.get(i).getRatingState().equals("04")){
    						tbIrmInternalRatingApply.setLAST_CREDIT_RATING_CD(tbIrmInternalRatingResult_last.get(i).getCreditRatingCd());
    	    				tbIrmInternalRatingApply.setLAST_EFFECTIVE_START_DT(tbIrmInternalRatingResult_last.get(i).getEffectiveStartDt());
    	    				tbIrmInternalRatingApply.setLAST_EFFECTIVE_END_DT(tbIrmInternalRatingResult_last.get(i).getEffectiveEndDt());
    	    				tbIrmInternalRatingApply.setRATING_TYPE_CD("存量评级");
    	    				break;
    					}    				
    				}
    			}else{//首次评级数据组装
    				tbIrmInternalRatingApply.setRATING_TYPE_CD("首次评级");
    			}
    			
    			map.put("code", "200");
    			map.put("msg", "获取评级基本信息成功");
    			map.put("party", tbCsmParty);
    			map.put("irmApply", tbIrmInternalRatingApply);
    			map.put("corporation", tbCsmCorporation);
    			map.put("orgNum", orgNum);
    			map.put("userNum", userNum);
    			map.put("natural", naturalPerson);
    		}
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询评级信息失败！异常");
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	/**
	 * 查询评级信息isObject
	 * */
	public  Map<String, Object> getIsProject(String applyId){
		Map<String, Object> map = new HashMap<>();
    	try {
    		if(StringUtils.isBlank(applyId)){
    			map.put("code", "201");
    			map.put("msg", "查询评级信息isObject失败，查询条件applyId不能为空！");
    			
    		}else{
    			TbIrmInternalRatingApply tbIrmInternalRatingApply = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(applyId);
    			if(tbIrmInternalRatingApply == null){
    				map.put("code", "201");
        			map.put("msg", "查询评级信息isObject失败，传入applyId未查询到评级信息，applyID="+applyId);
    			}else{
    				String isObject = "0";
    				if(StringUtils.isNotBlank(tbIrmInternalRatingApply.getPROJECT_ID())){
    					isObject = "1";
    				}
    				map.put("code", "200");
    				map.put("msg", "查询评级信息isObject成功");
    				map.put("data", "{isObject:"+isObject+"}");
    			}
    		}
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询评级信息isObject失败！异常");
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	/**
	 * 查询评级申请信息状态
	 * */
	public  Map<String, Object> getIrmRatingApplyInfo(String applyId){
		Map<String, Object> map = new HashMap<>();
    	try {
    		if(StringUtils.isBlank(applyId)){
    			map.put("code", "201");
    			map.put("msg", "查询评级信息isObject失败，查询条件applyId不能为空！");
    			
    		}else{
    			TbIrmInternalRatingApply tbIrmInternalRatingApply = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(applyId);
    			if(tbIrmInternalRatingApply == null){
    				map.put("code", "201");
        			map.put("msg", "查询评级申请信息状态失败，传入applyId未查询到评级信息，applyID="+applyId);
    			}else{
    				
    				map.put("code", "200");
    				map.put("msg", "查询评级申请信息状态成功");
    				map.put("irmApply",tbIrmInternalRatingApply);
    			}
    		}
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询评级申请信息状态失败！异常");
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	/**
	 * 查询评级非财务信息
	 * */
	public  Map<String, Object> queryReportNonFinanceinfo(Integer pageNum,Integer pageSize,String applyId){
		Map<String, Object> map = new HashMap<>();
    	try {
    		if(StringUtils.isBlank(applyId)){
    			map.put("code", "201");
    			map.put("msg", "查询评级非财务信息失败，查询条件applyId不能为空！");
    			
    		}else{
    			
    			//获取财务指标集信息
    			List<irmReportNonFinanceInfo> nonFinInfoS = irmMapper.queryReportNonFinanceinfo(applyId);
    			
    			PageInfo pageInfo=new PageInfo(nonFinInfoS,pageSize);
				map.put("code", "200");
				map.put("msg", "查询评级非财务信息成功");
				map.put("data", pageInfo);
    		}
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询评级非财务信息失败！异常");
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	/**
	 * 通过客户评级申请表中的评级模型和模型版本，以及评级申请id来查询非财务信息
	 * */
	public  Map<String, Object> queryNonFinanceInfo(String applyId){
		Map<String, Object> map = new HashMap<>();
    	try {
    		if(StringUtils.isBlank(applyId)){
    			map.put("code", "201");
    			map.put("msg", "查询评级非财务信息失败，查询条件applyId不能为空！");
    			
    		}else{
    			List<NonFinanceInfoBean> result = new ArrayList<NonFinanceInfoBean>();
    			//获取财务指标集信息
    			List<NonFinancialPropertyInfo> nonFinInfoS = irmMapper.queryNonFinancialPropertyInfo(applyId);
    			//获取非财务信息
    			Map<String,String> queryTbIrmNonFinancialInfos_param = new HashMap<String,String>();
    			queryTbIrmNonFinancialInfos_param.put("iraApplyId",applyId);
    			List<TbIrmNonFinancialInfo> tbIrmNonFinancialInfos= irmMapper.queryTbIrmNonFinancialInfo(queryTbIrmNonFinancialInfos_param);
    			
    			if(nonFinInfoS == null || nonFinInfoS.size() == 0){//获取财务指标集信息不存在
    				//获取评级申请信息
    				TbIrmInternalRatingApply tbIrmInternalRatingApply = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(applyId);
    				//获取评级模型
    				Map<String,String> modelParams = new HashMap<String,String>();
    				modelParams.put("modelTypeCd", tbIrmInternalRatingApply.getRATING_MODEL_CD());
    				modelParams.put("ratingModelVer", tbIrmInternalRatingApply.getRATING_MODEL_VER());
    				modelParams.put("modelState", "2");
    				List<TbIrmRatingModel> ratingModels = irmMapper.queryTbIrmRatingModelMap(modelParams);
    				//根据模型ModelID获取指标集
    				Map<String,String> modelIndexParams = new HashMap<String,String>();
    				modelIndexParams.put("modelId", ratingModels.get(0).getModelId());
    				modelIndexParams.put("indexType", "02");
    				//获取指标集
    				List<TbIrmModelIndex> modexIndexes = irmMapper.queryTbIrmModelIndexMap(modelIndexParams);
    				for(int i=0;i< modexIndexes.size();i++){
    					TbIrmModelIndex tbIrmModelIndex = modexIndexes.get(i);
    					//根据指标id获取指标选项
    					NonFinanceInfoBean bean = new NonFinanceInfoBean();
    					List<TbIrmIndexScore> tbIrmIndexScores = irmMapper.queryTbIrmIndexScore(tbIrmModelIndex.getIndexId());
    					bean.setIndexId(tbIrmModelIndex.getIndexId());//指标编号
    					bean.setPropertyTypeCd(tbIrmModelIndex.getPropertyTypeCd());//指标类别
    					bean.setIndexName(tbIrmModelIndex.getIndexName());//指标名称
    					bean.setIndexDesc(tbIrmModelIndex.getIndexDesc());//指标说明、
    					bean.setRemarks("");//附加说明
    					bean.setTbIrmIndexScores(tbIrmIndexScores);
    					bean.setIndexValue("");
    					result.add(bean);
    				}
    			}else{
    				for(int i=0;i<tbIrmNonFinancialInfos.size();i++){
    					//非财务信息（已录入指标信息）
    					TbIrmNonFinancialInfo tbIrmNonFinancialInfo = tbIrmNonFinancialInfos.get(i);
    					//获取指标信息详情
    					Map<String,String> modelIndexParams = new HashMap<String,String>();
    					modelIndexParams.put("indexId", tbIrmNonFinancialInfo.getNonFinancialIndexId());//指标编号
    					List<TbIrmModelIndex> modexIndexes = irmMapper.queryNonFinanceinfo(modelIndexParams);
    					
    					NonFinanceInfoBean bean = new NonFinanceInfoBean();
    					List<TbIrmIndexScore> tbIrmIndexScores = irmMapper.queryTbIrmIndexScore(tbIrmNonFinancialInfo.getNonFinancialIndexId());
    					bean.setIndexId(modexIndexes.get(0).getIndexId());//指标编号
    					bean.setPropertyTypeCd(modexIndexes.get(0).getPropertyTypeCd());//指标类别
    					bean.setIndexName(modexIndexes.get(0).getIndexName());//指标名称
    					bean.setIndexDesc(modexIndexes.get(0).getIndexDesc());//指标说明、
    					bean.setRemarks(tbIrmNonFinancialInfo.gettComment());//附加说明
    					bean.setTbIrmIndexScores(tbIrmIndexScores);
    					bean.setIndexValue(tbIrmNonFinancialInfo.getNonFinancialValue());
    					result.add(bean);
    				}
    			}
				map.put("code", "200");
				map.put("msg", "查询评级非财务信息成功");
				map.put("data", result);
    		}
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询评级非财务信息失败！异常");
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	/**
	 * 查询通用评级调整项信息
	 * */
	public  Map<String, Object> queryOpitionInfo(Integer pageNum,Integer pageSize,String applyId){
		Map<String, Object> map = new HashMap<>();
    	try {
    		if(StringUtils.isBlank(applyId)){
    			map.put("code", "201");
    			map.put("msg", "查询通用评级调整项信息失败，查询条件applyId不能为空！");
    			
    		}else{
    			PageHelper.startPage(pageNum,pageSize);
    			List<AdjustOption> options = irmMapper.queryOpitionInfo(applyId);
    			PageInfo pageInfo=new PageInfo(options,pageSize);
				map.put("code", "200");
				map.put("msg", "查询通用评级调整项信息成功");
				map.put("data", pageInfo);
    		}
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询通用评级调整项信息失败！异常");
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	/**
	 * 查询推翻历史信息
	 * */
	public  Map<String, Object> queryOverRecordInfo(Integer pageNum,Integer pageSize,String applyId,String oldApplyId){
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> params = new HashMap<>();
    	try {
    		if(StringUtils.isBlank(applyId)){
    			map.put("code", "201");
    			map.put("msg", "查询推翻历史信息失败，查询条件applyId不能为空！");
    			
    		}else{
    			PageHelper.startPage(pageNum,pageSize);
    			List<IrmOverRecordInfo> list = null;
    			params.put("iraApplyId", applyId);
    			if(StringUtils.isBlank(oldApplyId)){
    				oldApplyId = "un";
        		}
    			params.put("oldApplyId", oldApplyId);
    			TbIrmInternalRatingApply tbIrmInternalRatingApply = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(applyId);
    			TbCsmParty party = tbCsmPartyMapper.selectByPrimaryKey(tbIrmInternalRatingApply.getPARTY_ID());
    			if(party != null && "01".equals(party.getPartyTypeCd())){//公司客户
    				TbCsmCorporation corporation = tbCsmCorporationMapper.selectByPrimaryKey(party.getPartyId());
    				if(true){//StringUtils.isBlank(corporation.getWhetherPassPeanuts())//异常-WHETHER_PASS_PEANUTS表字段确实
    					list = irmMapper.queryOverRecordInfo(params);
    				}else{
    					list = irmMapper.queryOverRecordInfo2(params);
    				}
    			}else{
    				list = irmMapper.queryOverRecordInfo(params);
    			}
    			
    			for (int i = 0; i < list.size(); i++) {
    				list.get(i).setAvagPD(this.getAvgPdAChange(new BigDecimal(list.get(i).getAvagPD())));
				}
    			
    			PageInfo pageInfo=new PageInfo(list,pageSize);
				map.put("code", "200");
				map.put("msg", "查询推翻历史信息成功");
				map.put("data", pageInfo);
    		}
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询推翻历史信息失败！异常");
            e.printStackTrace();
		} finally {
			return map;
		}
	}
	
	
	/**
	 * 查询是否有财报信息
	 * */
	public Map<String, Object> queryHasFinanceInfo(String partyId){
		Map<String, Object> map = new HashMap<>();
		try {
			String hasFlag = "1";
			if(StringUtils.isBlank(partyId)){
    			map.put("code", "201");
    			map.put("msg", "查询是否有财报信息失败，查询条件partyId不能为空！");
    			
    		}else{
    			//初始赋值财报信息
				TbAccCustomerFinance tbAccCustomerFinance = new TbAccCustomerFinance();
				tbAccCustomerFinance.setPartyId(partyId);
				tbAccCustomerFinance.setFinanceStatusCd("02");
				tbAccCustomerFinance.setCustomerTypeCd("006");
				List<TbAccCustomerFinance> customerFinances_006 = tbAccCustomerFinanceMapper.queryTbAccCustomerFinanceMapperByParams(tbAccCustomerFinance);
				if(customerFinances_006 == null || customerFinances_006.size() == 0){
					hasFlag = "0";
				}
				map.put("code", "200");
				map.put("msg", "查询是否有财报信息成功");
				map.put("hasFlag", hasFlag);
    		}
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "查询是否有财报信息失败！异常");
			e.printStackTrace();
			// TODO: handle exception
		} finally{
			return map;
		}
	}
	/**
	 * 更新和插入财务信息
	 * */
	public Map<String,String> addAndUpdateFinanceInfo(AddFinanceinfoCriteria criteria){
		Map<String,String> map = new HashMap<String,String>();
		try {
			String applyId = criteria.getItem().getApplyId();
			String isImport = criteria.getIsImport();
			if(StringUtils.isBlank(applyId)){
    			map.put("code", "201");
    			map.put("msg", "更新和插入财务信息失败，条件applyId不能为空！");
    			return map;
    		}
			//获取财务指标信息（当前评级对应）
			List<TbIrmRatingFinIndex> data =irmMapper.queryTbIrmRatingFinIndexByApplyID(applyId);
			//获取业务时间
			//查询评级参数
			Map<String,String> ratingParaParams = new HashMap<String,String>();
			ratingParaParams.put("paraType", "0007");
			List<TbIrmRatingPara> tbIrmRatingParas = irmMapper.queryTbIrmRatingPara(ratingParaParams);
			//获取财务信息ID
			TbIrmFinancialInfo tbIrmFinancialInfo = irmMapper.queryTbIrmFinancialInfo(applyId);
			if(tbIrmFinancialInfo == null){
				String financialInfoId = UUIDGenerator.getUUID();
				tbIrmFinancialInfo = new TbIrmFinancialInfo();
				tbIrmFinancialInfo.setReportId(criteria.getItem().getReportId());
				tbIrmFinancialInfo.setIraApplyId(applyId);
				tbIrmFinancialInfo.setFinancialInfoId(financialInfoId);
				int re = irmMapper.insertTbIrmFinancialInfo(tbIrmFinancialInfo);
				if(re != 1){
					map.put("code", "201");
	    			map.put("msg", "更新和插入财务信息失败，创建财务信息失败！");
	    			return map;
				}
				
				if("0".equals(isImport)){
					for(TbIrmRatingFinIndex tempData:data){
						TbIrmRatingIndexData tbIrmRatingIndexData = new TbIrmRatingIndexData();
						tbIrmRatingIndexData.setCreateTime(DateUtil.getCurrentDay());//创建时间
						tbIrmRatingIndexData.setFinancialInfoId(financialInfoId);
						tbIrmRatingIndexData.setIndexCd(tempData.getIndexCd());//指标代码
						//tbIrmRatingIndexData.setIndexDisp(tempData.get());
						tbIrmRatingIndexData.setIndexValueDataType(new BigDecimal(1));
						tbIrmRatingIndexData.setStringType("80");
						if(true){//流程图取tempData/indexValueDataType null||empty
							tbIrmRatingIndexData.setStringType("20");
						}
						tbIrmRatingIndexData.setUpdateTime(DateUtil.getCurrentDay());
						tbIrmRatingIndexData.setFinancialInfoId(financialInfoId);
						irmMapper.insertTbIrmRatingIndexData(tbIrmRatingIndexData);
					}
				}else{
					//获取全量财务指标信息（全量）
					List<TbAccFinanceIndexData> tbAccFinanceIndexDatas = irmMapper.queryTbAccFinanceIndexData(criteria.getItem().getReportId());
					for(TbAccFinanceIndexData index:tbAccFinanceIndexDatas){
						TbIrmRatingIndexData tbIrmRatingIndexData = new TbIrmRatingIndexData();
						tbIrmRatingIndexData.setCreateTime(DateUtil.getCurrentDay());//创建时间
						tbIrmRatingIndexData.setIndexCd(index.getIndexCd());//指标代码
						tbIrmRatingIndexData.setFinanceId(index.getFinanceId());
						tbIrmRatingIndexData.setIndexDisp(index.getIndexDisp());
						tbIrmRatingIndexData.setIndexValueDataType(index.getIndexValueDataType());
						tbIrmRatingIndexData.setStringType(index.getStringType());
						if("06".equals(index.getStringType())){
							tbIrmRatingIndexData.setStringType("20");
						}
						tbIrmRatingIndexData.setUpdateTime(DateUtil.getCurrentDay());
						tbIrmRatingIndexData.setFinancialInfoId(financialInfoId);
						irmMapper.insertTbIrmRatingIndexData(tbIrmRatingIndexData);
						
					}
				}
			}else{
				//更新财务报表ID
				tbIrmFinancialInfo.setReportId(criteria.getItem().getReportId());
				tbIrmFinancialInfo.setRemark("");
				irmMapper.udateTbIrmFinancialInfo(tbIrmFinancialInfo);
				//删除原来的指标数据
				irmMapper.deleteTbIrmRatingIndexDataByFinancialInfoId(tbIrmFinancialInfo.getFinancialInfoId());
				if("0".equals(isImport)){
					for(TbIrmRatingFinIndex tempData:data){
						TbIrmRatingIndexData tbIrmRatingIndexData = new TbIrmRatingIndexData();
						tbIrmRatingIndexData.setCreateTime(DateUtil.getCurrentDay());//创建时间
						tbIrmRatingIndexData.setFinancialInfoId(tbIrmFinancialInfo.getFinancialInfoId());
						tbIrmRatingIndexData.setIndexCd(tempData.getIndexCd());//指标代码
						//tbIrmRatingIndexData.setIndexDisp(tempData.get());
						tbIrmRatingIndexData.setIndexValueDataType(new BigDecimal(1));
						tbIrmRatingIndexData.setStringType("80");
						if(true){//流程图取tempData/indexValueDataType null||empty
							tbIrmRatingIndexData.setStringType("20");
						}
						tbIrmRatingIndexData.setUpdateTime(DateUtil.getCurrentDay());
						tbIrmRatingIndexData.setFinancialInfoId(tbIrmFinancialInfo.getFinancialInfoId());
						irmMapper.insertTbIrmRatingIndexData(tbIrmRatingIndexData);
					}
				}else{
					//获取全量财务指标信息（全量）
					List<TbAccFinanceIndexData> tbAccFinanceIndexDatas = irmMapper.queryTbAccFinanceIndexData(criteria.getItem().getReportId());
					for(TbAccFinanceIndexData index:tbAccFinanceIndexDatas){
						TbIrmRatingIndexData tbIrmRatingIndexData = new TbIrmRatingIndexData();
						tbIrmRatingIndexData.setCreateTime(DateUtil.getCurrentDay());//创建时间
						tbIrmRatingIndexData.setIndexCd(index.getIndexCd());//指标代码
						tbIrmRatingIndexData.setFinanceId(index.getFinanceId());
						tbIrmRatingIndexData.setIndexDisp(index.getIndexDisp());
						tbIrmRatingIndexData.setIndexValueDataType(index.getIndexValueDataType());
						tbIrmRatingIndexData.setStringType(index.getStringType());
						if("06".equals(index.getStringType())){
							tbIrmRatingIndexData.setStringType("20");
						}
						tbIrmRatingIndexData.setUpdateTime(DateUtil.getCurrentDay());
						tbIrmRatingIndexData.setFinancialInfoId(tbIrmFinancialInfo.getFinancialInfoId());
						irmMapper.insertTbIrmRatingIndexData(tbIrmRatingIndexData);
						
					}
				}
				
			}
			map.put("code", "200");
			map.put("msg", "更新和插入财务信息成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			return map;
		}
	}
	/**
	 * 更新和插入非财务信息
	 * */
	public Map<String,String> addNonFinancialInfo(AddNonFinancialInfoCriteria criteria){
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			for(NonFinanceInfoBean row:criteria.getInRows()){
				//获取非财务信息
    			Map<String,String> queryTbIrmNonFinancialInfos_param = new HashMap<String,String>();
    			queryTbIrmNonFinancialInfos_param.put("iraApplyId",criteria.getApplyId());
    			queryTbIrmNonFinancialInfos_param.put("nonFinancialIndexId", row.getIndexId());
    			List<TbIrmNonFinancialInfo> tbIrmNonFinancialInfos= irmMapper.queryTbIrmNonFinancialInfo(queryTbIrmNonFinancialInfos_param);
				if(tbIrmNonFinancialInfos != null && tbIrmNonFinancialInfos.size() > 0){//更新
					tbIrmNonFinancialInfos.get(0).setNonFinancialValue(row.getIndexValue());
					tbIrmNonFinancialInfos.get(0).settComment(row.getRemarks());
					irmMapper.updateTbIrmNonFinancialInfo(tbIrmNonFinancialInfos.get(0));
				}else{//插入
					TbIrmNonFinancialInfo tbIrmNonFinancialInfo = new TbIrmNonFinancialInfo();
					tbIrmNonFinancialInfo.setIraApplyId(criteria.getApplyId());
					tbIrmNonFinancialInfo.setNonFinancialIndexId(row.getIndexId());
					tbIrmNonFinancialInfo.setNonFinancialValue(row.getIndexValue());
					tbIrmNonFinancialInfo.settComment(row.getRemarks());
					tbIrmNonFinancialInfo.setFinanceId(UUIDGenerator.getUUID());
					irmMapper.insertTbIrmNonFinancialInfo(tbIrmNonFinancialInfo);
				}
			}
			map.put("code", "200");
			map.put("msg", "更新和插入非财务信息成功！");
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "更新和插入非财务信息异常！");
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			return map;
		}
	}
	/**
	 * 通用调整选项页面初始化
	 * */
	public Map<String,Object> getIrmApplyCd(String applyId){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Map<String,Object> result_queryEngineRecIdJj = this.queryEngineRecIdJj(applyId);
			if("200".equals(result_queryEngineRecIdJj.get("code").toString())){
				TbIrmInternalRatingApply ratingApply = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(applyId);
				TbIrmAdjustOptions adjustOptions = irmMapper.queryTbIrmAdjustOptions(applyId);
				result.put("code", "200");
				result.put("ratingApply", ratingApply);
				result.put("adjustOptions", adjustOptions);
			}else{
				result = result_queryEngineRecIdJj;
			}
			
			
		} catch (Exception e) {
			result.put("code", "201");
			result.put("msg", "获取通用调整选项页面初始化数据失败");
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			return result;
		}
		
		
	}
	public Map<String,String> saveIrmApplyCd(AdJustInfoBean adJustInfoBean){
		Map<String,String> result = new HashMap<String,String>();
		try {
			tbIrmInternalRatingApplyMapper.updateByPrimaryKeySelective(adJustInfoBean.getRatingApply());
			
			irmMapper.deleteTbIrmAdjustOptions(adJustInfoBean.getRatingApply().getIRA_APPLY_ID());
			
			adJustInfoBean.getAdjustOptions().setAdjustOptionId(UUIDGenerator.getUUID());
			adJustInfoBean.getAdjustOptions().setIraApplyId(adJustInfoBean.getRatingApply().getIRA_APPLY_ID());
			irmMapper.insertTbIrmAdjustOptions(adJustInfoBean.getAdjustOptions());
			result.put("code", "200");
			result.put("msg","保存通用调整项信息成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("code", "201");
			result.put("msg","保存通用调整项信息异常！" + e.getMessage());
		} finally {
			return result;
		}
		
	}
	/**
	 * 通过评级申请id获取机评结果。
	 * */
	public Map<String,Object> queryEngineRecIdJj(String applyId){
		Map<String,Object> map = new HashMap<String,Object>();
		//获取评级申请信息
		TbIrmInternalRatingApply temp = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(applyId);
		Short allowTimes = temp.getALLOW_TIMES();//允许计算次数
		String allowModifyFlag = temp.getALLOW_MODIFY_FLAG();//允许修改标志
		String modelCd = temp.getRATING_MODEL_CD();//评级模型
		if(!"1".equals(allowModifyFlag)){
			map.put("code", "201");
			map.put("msg", "获取评级结果次数过多，不能进行再计算！");
			return map;
		}
		TbIrmFinancialInfo tbIrmFinancialInfo = irmMapper.queryTbIrmFinancialInfo(applyId);
		if(null == tbIrmFinancialInfo){
			map.put("code", "201");
			map.put("msg", "请选择财务报表才能获取评级结果！");
			return map;
		}
		Map<String,String> queryTbIrmNonFinancialInfos_param = new HashMap<String,String>();
		queryTbIrmNonFinancialInfos_param.put("iraApplyId",applyId);
		List<TbIrmNonFinancialInfo> tbIrmNonFinancialInfos= irmMapper.queryTbIrmNonFinancialInfo(queryTbIrmNonFinancialInfos_param);
		if(null == tbIrmNonFinancialInfos || tbIrmNonFinancialInfos.size() == 0){
			map.put("code", "201");
			map.put("msg", "请选择非财务信息才能获取评级结果！");
			return map;
		}
		Map<String,String> queryTbIrmRatingModel_param = new HashMap<String,String>();
		queryTbIrmRatingModel_param.put("modelTypeCd",temp.getRATING_MODEL_CD());
		queryTbIrmRatingModel_param.put("ratingModelVer",temp.getRATING_MODEL_VER());
		queryTbIrmRatingModel_param.put("modelState","2");
		List<TbIrmRatingModel> temps1 = irmMapper.queryTbIrmRatingModelMap(queryTbIrmRatingModel_param);
		if(temps1 == null || temps1.size() == 0){
			map.put("code", "201");
			map.put("msg", "获取评级模型ID失败！");
			return map;
		}
		String modelId = temps1.get(0).getModelId();//获取模型编号
		String partyId = temp.getPARTY_ID();//获取客户编号
		//获取引擎计算ID
		String recId = this.addTbIrmRatingEngineCalc(applyId, modelId, partyId);
		Map tbIrmEngineS_params = new HashMap();
		tbIrmEngineS_params.put("recId", recId);
		List<TbIrmRatingEngineCalc> tbIrmEngineS = irmMapper.queryTbIrmRatingEngineCalc(tbIrmEngineS_params);
		if(allowTimes == 1){
			if(StringUtils.isNotBlank(temp.getGENERAL_ADJUST_RATING_CD())){
				temp.setALLOW_TIMES(new Short("0"));
				temp.setALLOW_MODIFY_FLAG("2");
				temp.setGOVERNMENT_ADJUST_RATING_CD(tbIrmEngineS.get(0).getGovernmentAdjustRatingCd());
				temp.setGENERAL_ADJUST_RATING_CD(tbIrmEngineS.get(0).getGeneralAdjustRatingCd());
			}else{
				temp.setALLOW_TIMES(new Short("0"));
				temp.setALLOW_MODIFY_FLAG("2");
				temp.setGOVERNMENT_ADJUST_RATING_CD(tbIrmEngineS.get(0).getInitialRatingCd());
				temp.setGENERAL_ADJUST_RATING_CD(tbIrmEngineS.get(0).getInitialRatingCd());
			}
		}else{
			if(StringUtils.isNotBlank(temp.getGENERAL_ADJUST_RATING_CD())){
				temp.setALLOW_TIMES((short)(temp.getALLOW_TIMES() - 1));
				temp.setGOVERNMENT_ADJUST_RATING_CD(tbIrmEngineS.get(0).getInitialRatingCd());
			}else{
				temp.setALLOW_TIMES((short)(temp.getALLOW_TIMES() - 1));
				temp.setGOVERNMENT_ADJUST_RATING_CD(tbIrmEngineS.get(0).getInitialRatingCd());
				temp.setGENERAL_ADJUST_RATING_CD(tbIrmEngineS.get(0).getInitialRatingCd());
			}
		}
		tbIrmInternalRatingApplyMapper.updateByPrimaryKey(temp);
		TbIrmInternalRatingResult ratingresult = new TbIrmInternalRatingResult();
		ratingresult.setIrrResultId(UUIDGenerator.getUUID());
		ratingresult.setCreditRatingCd(tbIrmEngineS.get(0).getInitialRatingCd());
		ratingresult.setEffectiveStartDt(tbIrmEngineS.get(0).getExecutionDate());
		ratingresult.setIraApplyId(tbIrmEngineS.get(0).getIraApplyId());
		ratingresult.setPartyId(partyId);//普元种取的temps1[1]/partyId temps1应该是没有partyId的
		ratingresult.setRatingDt(tbIrmEngineS.get(0).getExecutionDate());
		ratingresult.setRatingState("01");
		ratingresult.setOrgNum("orgNum");
		ratingresult.setUserNum("uSerNum");
		tbIrmInternalRatingResultMapper.insertSelective(ratingresult);
		map.put("code", "200");
		map.put("recId", recId);
		map.put("allowTimes", allowTimes+"");
		
		return map;
	}
	/**
	 * 获取引擎计算ID addTbIrmRatingEngineCalc
	 * */
	public String addTbIrmRatingEngineCalc(String applyId,String modelId,String partyId){
		String result = "";
		//初始化值
		BigDecimal temp = new BigDecimal(0);
		BigDecimal temp1 = new BigDecimal(0);
		BigDecimal temp2 = new BigDecimal(0);
		//获取业务时间
		
		//获得财务指标得分信息
		List<IndexEntity> financeIndexs = getFinanceIndex(applyId, modelId);
		if(null != financeIndexs && financeIndexs.size() > 0){
			for(int i = 0 ;i < financeIndexs.size();i ++){
				IndexEntity financeIndex = financeIndexs.get(i);
				temp = financeIndex.getiValue().add(temp);
			}
		}
		//获得非财务指标得分信息
		List<TbIrmIndexScore> nonFinanceIndexs = irmMapper.getNonFinanceIndexScore(applyId);
		if(null != nonFinanceIndexs && nonFinanceIndexs.size() > 0){
			for(int i = 0 ;i < nonFinanceIndexs.size();i ++){
				TbIrmIndexScore nonFinanceIndex = nonFinanceIndexs.get(i);
				temp1 = nonFinanceIndex.getIndexScore().add(temp1);
			}
		}
		
		TbIrmRatingEngineCalc tbIrmRatingEngineCalc = new TbIrmRatingEngineCalc();
		tbIrmRatingEngineCalc.setNonFinanceModelScore(temp1);
		tbIrmRatingEngineCalc.setGovernmentAdjustScore(temp2);
		tbIrmRatingEngineCalc.setFinanceModelScore(this.numFormat(temp.doubleValue()));
		tbIrmRatingEngineCalc.setRatingTatalScore(tbIrmRatingEngineCalc.getFinanceModelScore().add(tbIrmRatingEngineCalc.getNonFinanceModelScore()));
		//获取财务指标权重
		Map tbIrmModelIndex_map = new HashMap();
		tbIrmModelIndex_map.put("indexType", "01");
		tbIrmModelIndex_map.put("modelId", modelId);
		List<TbIrmModelIndex> tbIrmModelIndexs = irmMapper.queryTbIrmModelIndexMap(tbIrmModelIndex_map);
		//获取财务指标权重
		tbIrmRatingEngineCalc.setIraApplyId(applyId);
		//获得模型对应信用等级
		String creditRatingCd = this.getModelCreditRating(modelId, tbIrmRatingEngineCalc.getRatingTatalScore(), partyId);
		//获得模型对应信用等级xg
		String creditRatingCd1 = this.getModelCreditRating_xg(modelId,nonFinanceIndexs,tbIrmRatingEngineCalc.getRatingTatalScore(),creditRatingCd);
		tbIrmRatingEngineCalc.setInitialRatingCd(creditRatingCd1);
		//查询客户最大调整选项
		List<TbIrmAdjustOptions> map2 = irmMapper.getMaxAdjustValue(applyId);
		//查询初始信用等级级别
		Map tbIrmScaleDef_params = new HashMap();
		tbIrmScaleDef_params.put("creditRatingDisplay",tbIrmRatingEngineCalc.getInitialRatingCd());
		TbIrmScaleDef tbIrmScaleDef = irmMapper.queryTbIrmScaleDef(tbIrmScaleDef_params);
		int temp3 = Integer.valueOf(tbIrmScaleDef.getOrderNo());
		int temp4 = Integer.valueOf(tbIrmScaleDef.getOrderNo());
		
		if(null != map2.get(0) && StringUtils.isNotBlank(map2.get(0).getAdjustValue())){
			temp3 = temp3-Integer.parseInt(map2.get(0).getAdjustValue());
		}
		if(null != map2.get(1) && StringUtils.isNotBlank(map2.get(1).getAdjustValue())){
			temp3 = temp3-Integer.parseInt(map2.get(1).getAdjustValue());
		}
		if(null != map2.get(2) && StringUtils.isNotBlank(map2.get(2).getAdjustValue())){
			temp4 = temp4-Integer.parseInt(map2.get(2).getAdjustValue());
		}
		if(null != map2.get(3) && StringUtils.isNotBlank(map2.get(3).getAdjustValue())){
			temp4 = temp4-Integer.parseInt(map2.get(3).getAdjustValue());
		}
		//查询模型是否专业贷款
		Map tbIrmRatingModel_params = new HashMap();
		tbIrmRatingModel_params.put("modelId", modelId);
		List<TbIrmRatingModel> tbIrmRatingModels = irmMapper.queryTbIrmRatingModelMap(tbIrmRatingModel_params);
		TbIrmRatingModel tbIrmRatingModel = tbIrmRatingModels.get(0);
		if("S1".equals(tbIrmRatingModel.getModelTypeCd()) || "S2".equals(tbIrmRatingModel.getModelTypeCd())){
			//查询专业贷款调整后等级是否超过主标尺定义范围
			Map maxMinMap = irmMapper.getLoanMaxAndMinLevel();
			int max = Integer.parseInt(maxMinMap.get("max").toString());
			int min = Integer.parseInt(maxMinMap.get("min").toString());
			if(temp3 > max){
				temp3 = max;
			}else if(temp3 < min){
				temp3 = min;
			}
			if(temp4 > max){
				temp4 = max;
			}else if(temp4 < min){
				temp4 = min;
			}
		}else{
			//查询非专业贷款调整后等级是否超过主标尺定义范围
			Map maxMinMap = irmMapper.getNonLoanMaxAndMinLevel();//异常-数据库没有isProfessionalLoan=2的数据
			int max = Integer.parseInt(maxMinMap.get("MAX").toString());
			int min = Integer.parseInt(maxMinMap.get("MIN").toString());
			if(temp3 > max){
				temp3 = max;
			}else if(temp3 < min){
				temp3 = min;
				temp4 = min;
			}
			if(temp4 > max){
				temp4 = max;
			}
		}
		//查询政府融资调整后对应等级
		Map tbIrmScaleDef1_params = new HashMap();
		tbIrmScaleDef1_params.put("orderNo",temp3+"");
		TbIrmScaleDef tbIrmScaleDef1 = irmMapper.queryTbIrmScaleDef(tbIrmScaleDef1_params);
		//查询一般整后对应等级
		Map tbIrmScaleDef2_params = new HashMap();
		tbIrmScaleDef2_params.put("orderNo",temp4+"");
		TbIrmScaleDef tbIrmScaleDef2 = irmMapper.queryTbIrmScaleDef(tbIrmScaleDef1_params);
		
		tbIrmRatingEngineCalc.setGovernmentAdjustRatingCd(tbIrmScaleDef1.getCreditRatingDisplay());
		tbIrmRatingEngineCalc.setGeneralAdjustRatingCd(tbIrmScaleDef2.getCreditRatingDisplay());
		tbIrmRatingEngineCalc.setRecId(UUIDGenerator.getUUID());
		irmMapper.insertTbIrmRatingEngineCalc(tbIrmRatingEngineCalc);
		for(int k = 0;k<financeIndexs.size();k++){
			TbIrmIndexCalc tbIrmIndexCalc = new TbIrmIndexCalc();
			tbIrmIndexCalc.setIdxCalcId(UUIDGenerator.getUUID());
			tbIrmIndexCalc.setIndexId(financeIndexs.get(k).getIndexId());
			tbIrmIndexCalc.setRecId(tbIrmRatingEngineCalc.getRecId());
			tbIrmIndexCalc.setIndexClass(financeIndexs.get(k).getIndexType());
			tbIrmIndexCalc.setIndexType(financeIndexs.get(k).getPropertyTypeCd());
			tbIrmIndexCalc.setIndexScore(financeIndexs.get(k).getiValue());
			tbIrmIndexCalc.setIndexWeight(financeIndexs.get(k).getIndexWeight());//普元忠financeIndexs未设置此值如何取到
			tbIrmIndexCalc.setIndexValue(financeIndexs.get(k).getIndexValueDataType());
			irmMapper.insertTbIrmIndexCalc(tbIrmIndexCalc);
		}
		for(int l =0;l<nonFinanceIndexs.size();l++){
			TbIrmIndexCalc tbIrmIndexCalc = new TbIrmIndexCalc();
			tbIrmIndexCalc.setIdxCalcId(UUIDGenerator.getUUID());
			tbIrmIndexCalc.setIndexId(nonFinanceIndexs.get(l).getIndexId());
			tbIrmIndexCalc.setRecId(tbIrmRatingEngineCalc.getRecId());
			tbIrmIndexCalc.setIndexClass(nonFinanceIndexs.get(l).getIndexType());
			tbIrmIndexCalc.setIndexType(nonFinanceIndexs.get(l).getPropertyTypeCd());
			tbIrmIndexCalc.setIndexScore(nonFinanceIndexs.get(l).getIndexScore());
			tbIrmIndexCalc.setIndexWeight(nonFinanceIndexs.get(l).getIndexWeight());
			irmMapper.insertTbIrmIndexCalc(tbIrmIndexCalc);
		}
		return tbIrmRatingEngineCalc.getRecId();
	}
	public Map<String,Object> setRatingCd(String applyId,String processInstId){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			Map<String,String> map = irmMapper.getRatingCd1(applyId);
			this.setRelativeDataBatch(processInstId,map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			return result;
		}
	}
	/**
	 * 设置流程中使用的相关数据（流程相关 忽略暂时）
	 * */
	public void setRelativeDataBatch(String processInstId,Map<String,String> map){
//		IBPSServiceClient client = BPSServiceClientFactory.getDefaultClient(); 
//		IWFRelativeDataManager relativeDataManager = client.getRelativeDataManager(); 
//		relativeDataManager.setRelativeDataBatch(processInstID, map); 
	}
	/**
	 * 创建流程
	 * */
	public void createBpsProcess(String iraApplyId,String pbsNum,String pjlx){
		
		/*
		
		TbIrmInternalRatingApply tbIrmInternalRatingApply = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(iraApplyId);
		if(null != tbIrmInternalRatingApply){
			if("999".equals(pjlx)){
				String partyId = tbIrmInternalRatingApply.getPARTY_ID();
				String isTree = null;
				//是否第三方客户
				Integer num = tbCsmCorporationMapper.queryThirdPartythreeDB(partyId);
				if(0 == num){
					isTree = "0";
				}else{
					isTree = "1";
				}
				TbCsmParty tbCsmParty = tbCsmPartyMapper.selectByPrimaryKey(partyId);
				tbIrmInternalRatingApply.getGP_MODEL_VER();
				Map processMap = new HashMap<>();
				processMap.put("bizId", tbIrmInternalRatingApply.getIRA_APPLY_ID());
				processMap.put("cusName", tbCsmParty.getPartyName());
				processMap.put("custId", tbCsmParty.getPartyNum());
				processMap.put("isTree", isTree);
			}else{
				
			}
		}
		
		
		//RETURN processInstId msg
	*/}
	
	
	/**
	 * 验证企业贵哦
	 * */
	public String validCusGm(TbCsmCorporation corporation,String pjlx){
		String result = "OK";
		if(StringUtil.isBlank(corporation.getIndustrialTypeCd())){
			result = "A";//无行业门类
		}
		if(StringUtil.isBlank(corporation.getEnterpriseScaleGx())){
			result = "B";//无工信部企业规模
		}
		if("1".equals(corporation.getCorpCustomerTypeCd()) && StringUtil.isBlank(corporation.getBankScaleIdentify()) && !"4".equals(pjlx)){
			result = "C";//无银行认定企业规模
		}
		return result;
		
	}
	public Map<String,Object> getModeScaleToCombobx(String modelTypeCd){
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			
			List<Selector> scals = irmMapper.getModeScaleToCombobx(modelTypeCd);
			map.put("code", "200");
			map.put("msg", "更新和插入非财务信息成功！");
			map.put("scals", scals);
		} catch (Exception e) {
			map.put("code", "201");
			map.put("msg", "更新和插入非财务信息异常！");
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			return map;
		}
	}
	/**
	 * 根据评级申请Id和参与人Id获取最新的评级引擎计算信息。
	 * */
	public Map<String,String> queryInitialRatingCd(String applyId,String oldApplyId){
		Map<String,String> map = new HashMap<String,String>();
		if(StringUtils.isBlank(applyId)){
			map.put("code", "201");
			map.put("msg", "根据评级申请Id和参与人Id获取最新的评级引擎计算信息失败，查询条件applyId不能为空！");
			return map;
		}
		try {
			TbIrmInternalRatingApply temp = null;
			if(StringUtils.isNotBlank(oldApplyId)){
				temp = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(oldApplyId);
			}else{
				temp = tbIrmInternalRatingApplyMapper.selectByPrimaryKey(applyId);
			}
			if(null != temp && StringUtils.isNotBlank(temp.getGENERAL_ADJUST_RATING_CD())){
				
				//获取违约值PD
				Map<String,String> parmas_temp1 = new HashMap<String,String>();
				parmas_temp1.put("creditRatingCd", temp.getGENERAL_ADJUST_RATING_CD());
				TbIrmScaleDef temp1 = irmMapper.queryTbIrmScaleDef(parmas_temp1);
				String initialRatingCd = temp1.getCreditRatingDisplay();
				String orderNo = temp1.getOrderNo();
				String avgPd = this.getAvgPdAChange(temp1.getAvagPd());
				String time = "";//获取业务时间 待添加
				
				map.put("code", "200");
				map.put("initialRatingCd", initialRatingCd);
				map.put("orderNo", orderNo);
				map.put("avgPd", avgPd);
				map.put("time", time);
				map.put("msag", "根据评级申请Id和参与人Id获取最新的评级引擎计算信息成功！");
			}else{
				map.put("code", "201");
				map.put("msg", "根据评级申请Id和参与人Id获取最新的评级引擎计算信息失败，请先获取评级结果！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return map;
		}
	}
	/**
	 * 获取评级模型
	 * */
	public String getIrmModel(String partyId, boolean choose, String pjlx) {

		if (null == partyId || "" == partyId) {
			//System.out.println("获取评级模版时 客户ID为空！");
			return null;
		}
		// 自然人客户
		// DataObject naturalPerson = DataObjectUtil.createDataObject("com.bos.dataset.csm.TbCsmNaturalPerson");
		// naturalPerson.set("partyId", partyId);
		// DatabaseUtil.expandEntityByTemplate("default", naturalPerson, naturalPerson);
		// String naturalPersonTypeCd = (String )naturalPerson.get("naturalPersonTypeCd");

		if (pjlx != null && "1".equals(pjlx)) {
			return "P3";
		} else if (pjlx != null && "2".equals(pjlx)) {
			return "P1";
		} else {
			TbCsmCorporation corporation = tbCsmCorporationMapper.selectByPrimaryKey(partyId);
			String corpCustomerTypeCd = corporation.getCorpCustomerTypeCd();
			String thirdCustTypeCd = corporation.getThirdCustTypeCd();//第三方客户类型
			if("1".equals(thirdCustTypeCd)&& pjlx != null && "4".equals(pjlx)){
				return "D1";
			}
			if ("3".equals(corpCustomerTypeCd)) {
				return "P1";
			}
			if (choose) {
				return "C1";
			}
			// 行业门类
			if (null == corporation.getIndustrialTypeCd() || "" == corporation.getIndustrialTypeCd()) {
				//System.out.println("获取评级模版时  行业门类为空！");
				return null;
			}
			String typeCd = corporation.getIndustrialTypeCd();

			if (null == corporation.getBankScaleIdentify() || "" == corporation.getBankScaleIdentify()) {
				//System.out.println("获取评级模版时  银行认定企业规模为空！");
				return null;
			}
			String scaleGx =  corporation.getBankScaleIdentify();
			System.out.println(corpCustomerTypeCd);
			/**
			 * CDKH0027 1 大 CDKH0027 2 中 CDKH0027 3 小 CDKH0027 4 微
			 */
			// 1农、林、牧、渔业 xiao: P5 zhong: M5
			if ("A".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S5";
			if ("A".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M5";

			// 2采矿业 xiao: P1 zhong: M1
			if ("B".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S1";
			if ("B".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M1";

			// 3制造业 xiao: P1 zhong: M1
			if ("C".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S1";
			if ("C".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M1";

			// 4电力、热力、燃气及水的生产和供应业 xiao: P1 zhong: M1
			if ("D".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S1";
			if ("D".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M1";

			// 5建筑业 xiao: P3 zhong: M3
			if ("E".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S3";
			if ("E".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M3";

			// 6批发和零售业 xiao: P2 zhong: M2
			if ("F".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S2";
			if ("F".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M2";

			// 7交通运输、仓储和邮政业 xiao: P5 zhong: M5
			if ("G".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S5";
			if ("G".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M5";

			// 8住宿和餐饮业 xiao: P4 zhong: M4
			if ("H".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S4";
			if ("H".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M4";

			// 9信息传输、计算机服务和软件业 xiao: P4 zhong: M4
			if ("I".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S4";
			if ("I".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M4";

			// 10金融业 xiao: P5 zhong: M5
			if ("J".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S5";
			if ("J".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M5";

			// 11房地产业 xiao: P3 zhong: M3
			if ("K".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S3";
			if ("K".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M3";

			// 12租赁和商务服务业 xiao: P4 zhong: M4
			if ("L".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S4";
			if ("L".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M4";

			// 13科学研究和技术服务 xiao: P4 zhong: M4
			if ("M".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S4";
			if ("M".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M4";

			// 14水利、环境和公共设施管理业 xiao: P5 zhong: M5
			if ("N".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S5";
			if ("N".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M5";

			// 15居民服务、修理和其他服务业 xiao: P4 zhong: M4
			if ("O".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S4";
			if ("O".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M4";

			// 16教育 xiao: P5 zhong: M5
			if ("P".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S5";
			if ("P".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M5";

			// 17卫生、社会工作 xiao: P5 zhong: M5
			if ("Q".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S5";
			if ("Q".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M5";

			// 18文化、体育和娱乐业 xiao: P5 zhong: M5
			if ("R".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S5";
			if ("R".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M5";

			// 19公共管理、社会保障和社会组织 xiao: P5 zhong: M5
			if ("S".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S5";
			if ("S".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M5";

			// 20国际组织 xiao: P5 zhong: M5
			if ("T".equals(typeCd) && ("3".equals(scaleGx) || "4".equals(scaleGx)))
				return "S5";
			if ("T".equals(typeCd) && ("1".equals(scaleGx) || "2".equals(scaleGx)))
				return "M5";
		}
		return null;
	}
	
	/**
	 * 自定义术语转换
	 * */
	public String changeMsg(String code){
		switch (code) {
		case "A":
			return "无行业门类";
		case "B":
			return "无工信部企业规模";
		case "C":
			return "无银行认定企业规模";
		default:
			return code;
		}
	}
	
	public String getAvgPdAChange(BigDecimal  pd) {
		pd = pd.multiply(new BigDecimal(100));
		DecimalFormat df = new DecimalFormat("#0.00");
		String tt = df.format(pd);
		String avgPd = tt + "%";
		System.out.println(avgPd);
		return avgPd;
	}
	/**
	 * 俩个字符串拼接
	 * */
	public String stringConcatString(String a,String b){
		String c = a+":"+b;
		return c;
	}
	/**
	 * ("获取流程中的岗位代码")
	 * 将流程中的节点代码转换为岗位代码， 节点信息代码第二位代表机构级别 将第二位换成 1 ；就转换为当前流程中的岗位；
	 * @param orgMap
	 * @param orgNum
	 * @return
	 */
	
	public String ReplacePosNum2(String pos){
		if(null != pos && !"".equals(pos)){
			if(pos.indexOf("P_")!=-1){
				pos = pos.substring(pos.indexOf("P_")+2,pos.length());
			}
			if(pos.lastIndexOf("_")!=-1){
				pos = pos.substring(0,pos.lastIndexOf("_"));
			}
		}
		String s1=pos.substring(0,1); 
		String s2=pos.substring(2,pos.length());
		String posCd = s1 + "1" + s2;
		System.out.println("posCd=" + posCd);
		System.out.println("mima===========");
		return posCd ;
	}
	
	public List<IndexEntity>  getFinanceIndex(String iraApplyId,String modelId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("modelId", modelId);
		map.put("iraApplyId", iraApplyId);
		List<TbAccFinanceStatementData> arr = irmMapper.getFinanceIndexScore(iraApplyId);
		if(null == arr || arr.size() == 0){
			return null;
		}
		String customerTypeCd = arr.get(0).getCustomerTypeCd();
		map.put("customerTypeCd", customerTypeCd);
		List<IndexEntity> indexArr = irmMapper.getFinanceIndex(map);
		
		MathContext mc = new MathContext(1, RoundingMode.HALF_DOWN);
		BigDecimal value = null;

		for (int i = 0; i < indexArr.size(); i++) {
			IndexEntity indexEntity = indexArr.get(i);
			String  remarks = indexEntity.getRemarks();
					//		System.out.println(indexEntity);
			HashMap a=getFinanceValues(remarks,arr);
		
			String in_logic = indexEntity.getIndexCalcLogic();
			//		 System.out.println("!!!!"+indexEntity.get("INDEX_CALC_LOGIC"));

			String[] in_calc_logic =in_logic.split(";");
			BigDecimal[] bd=new BigDecimal[in_calc_logic.length];
			for (int j = 0; j < in_calc_logic.length; j++) {
				bd[j] = new BigDecimal(in_calc_logic[j]);
				//			 System.out.println("!!!!"+ bd[j]);
			
			}
			//System.out.println("!!!!"+indexEntity.getIndexCode(););
			if("Y107".equals(indexEntity.getIndexCode())){
				String  MARKS=	indexEntity.getRemarks();
				String[] mk=MARKS.split(",");
				//    System.out.println(mk[0].toString()+"!"+mk[1].toString()+"!"+mk[2].toString()+"!"+mk[3].toString());
				BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
				BigDecimal av2= (BigDecimal) a.get(mk[1].toString());
				BigDecimal av3= (BigDecimal) a.get(mk[2].toString());
				BigDecimal av4= (BigDecimal) a.get(mk[3].toString());
				BigDecimal bv4= bd[0];
				BigDecimal bv5= bd[1];
				if(bv4==null || bv4.equals(new BigDecimal(0))){
					bv4=new  BigDecimal(0.01);
				}
				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("av1",av1 );
				params.put("av2",av2 );
				params.put("av3",av3 );
				params.put("av4",av4 );
				params.put("bv4",bv4 );
				params.put("w",new BigDecimal("10000"));

				System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+mk[1].toString()+"--->"+av2.toString()+"!"+mk[2].toString()+"--->"
						+av3.toString()+"!"+mk[3].toString()+"--->"+av4.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!满分值为:"+indexEntity.getIndexScore());
				//			 System.out.println(av1+"!"+av2+"!"+av3+"!"+av4+"!"+bv4+"!"+bv5) ;
				BigDecimal sum_amt =  expressionBigDecimal("(av1-av2-av3-av4)/w", params);
				System.out.println(sum_amt);
				if(sum_amt.compareTo(bv5)<0){
					value=new BigDecimal(0);
				}else if(sum_amt.compareTo(bv4)>0){ 
					value=indexEntity.getIndexScore();
				}else{
					HashMap<String, Object> params1 = new HashMap<String, Object>();
					params1.put("sum_amt",sum_amt );
					params1.put("INDEX_SCORE",indexEntity.getIndexScore());
					params1.put("bv4", bv4);
					value=expressionBigDecimal("sum_amt/bv4*INDEX_SCORE", params1);

				}
				System.out.println(value);
				indexEntity.setiValue(value);
				System.out.println(iraApplyId+"Y107有形净资产:"+value.toString());
			}
			if("Y108".equals(indexEntity.getIndexCode())){
				String MARKS=indexEntity.getRemarks();;
				String[] mk=MARKS.split(",");
				BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
				BigDecimal av2= (BigDecimal) a.get(mk[1].toString());
				BigDecimal bv4= bd[0];
				BigDecimal bv5= bd[1];
				BigDecimal bv6= bd[2];
				//			 System.out.println(av1+"!"+av2+"!"+bv4+"!"+bv5) ;
				System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+mk[1].toString()+"--->"+av2.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!"+bv6.toString()+"!满分值为:"+indexEntity.getIndexScore());
				if(av2==null || av2.equals(new BigDecimal(0))){
					av2=new  BigDecimal(0.01);
				}
				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("av1",av1 );
				params.put("av2",av2 );
				BigDecimal sum_amt =  expressionBigDecimal("av1/av2", params);
				//			 System.out.println(sum_amt);
				if(sum_amt.compareTo(bv4)<0){
					value=indexEntity.getIndexScore();
				}else if(sum_amt.compareTo(bv5)>0){ 
					value=new BigDecimal(0);
				}else{
					HashMap<String, Object> params1 = new HashMap<String, Object>();
					params1.put("sum_amt",sum_amt );
					params1.put("INDEX_SCORE",indexEntity.getIndexScore());
					params1.put("bv4", bv4);
					params1.put("v4",new BigDecimal("1"));
					params1.put("v5",bv6);
					value=expressionBigDecimal("(v4-(sum_amt-bv4)/v5)*(INDEX_SCORE-v4)+v4", params1);

				}
				//			 System.out.println(value);
				indexEntity.setiValue(value);
				//			 System.out.println(indexEntity);
				System.out.println("Y108资产负债率:"+value.toString());

			}
			if("Y109".equals(indexEntity.getIndexCode())){
				String  MARKS=	indexEntity.getRemarks();
				String[] mk=MARKS.split(",");
				BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
				BigDecimal av2= (BigDecimal) a.get(mk[1].toString());
				BigDecimal bv4= bd[0];
				BigDecimal bv5= bd[1];
				BigDecimal bv6= bd[2];
				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("av1",av1 );
				if(av2==null||av2.equals(new BigDecimal(0))){
					av2=new  BigDecimal(0.01, mc);
				}
				params.put("av2",av2 );
//			 	System.out.println(av1+"!"+av2+"!"+bv4+"!"+bv5) ;
				System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+mk[1].toString()+"--->"+av2.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!"+bv6.toString()+"!满分值为:"+indexEntity.getIndexScore());

				BigDecimal sum_amt =  expressionBigDecimal("av1/av2", params);
				System.out.println(sum_amt);
				if(sum_amt.compareTo(bv5)<0){
					value=new BigDecimal(0);
				}else if(sum_amt.compareTo(bv4)>0){ 
					value=indexEntity.getIndexScore();
			 }else{
				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore());
				 params1.put("bv4", bv4);
				 params1.put("v4",new BigDecimal("1"));
				 params1.put("v5",bv6);
 				 value=expressionBigDecimal("(v4-(bv4-sum_amt)/v5)*(INDEX_SCORE-v4)+v4", params1);
			 }
				//			 System.out.println(value);
				indexEntity.setiValue(value);
			 //			 System.out.println(indexEntity);
			 System.out.println("Y109流动比率:"+value.toString());

		 }
		 if("Y110".equals(indexEntity.getIndexCode())){
			 String  MARKS=	indexEntity.getRemarks();
			 String[] mk=MARKS.split(",");
			 BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
			 BigDecimal av2= (BigDecimal) a.get(mk[1].toString());
			 BigDecimal av3= (BigDecimal) a.get(mk[2].toString());
			 BigDecimal av4= (BigDecimal) a.get(mk[3].toString());
			 BigDecimal bv4= bd[0];
			 BigDecimal bv5= bd[1];
			 BigDecimal bv6= bd[2];
			 if(av4==null||av4.equals(new BigDecimal(0))){
				 av4=new  BigDecimal(0.01);
			 }
			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("av1",av1 );
			 params.put("av2",av2 );
			 params.put("av3",av3 );
			 params.put("av4",av4 );
			 
			 System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+mk[1].toString()+"--->"+av2.toString()+"!"+mk[2].toString()+"--->"
					 +av3.toString()+"!"+mk[3].toString()+"--->"+av4.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!"+bv6.toString()+"!满分值为:"+indexEntity.getIndexScore()) ;
			 BigDecimal sum_amt =  expressionBigDecimal("(av1-av2-av3)/av4", params);
			 System.out.println(sum_amt);
			 if(sum_amt.compareTo(bv5)<0){
				 value=new BigDecimal(0);
			 }else if(sum_amt.compareTo(bv4)>0){ 
				 value= indexEntity.getIndexScore();
			 }else{
				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore());
				 params1.put("bv4", bv4);
				 params1.put("v4",new BigDecimal("1"));
				 params1.put("v5",bv6);
 				 value=expressionBigDecimal("(v4-(bv4-sum_amt)/v5)*(INDEX_SCORE-v4)+v4", params1);
			 }
//			 System.out.println(value);
			 indexEntity.setiValue(value);
			 System.out.println("Y110速动比率:"+value.toString());
		 }
		 if("Y111".equals(indexEntity.getIndexCode())){
			 String  MARKS=	indexEntity.getRemarks();
			 String[] mk=MARKS.split(",");
			 BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
			 BigDecimal av2= (BigDecimal) a.get(mk[1].toString());
			 BigDecimal bv4= bd[0];
			 BigDecimal bv5= bd[1];
			 BigDecimal bv6= bd[2];
			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("av1",av1 );
			 System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+mk[1].toString()+"--->"+av2.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!"+bv6.toString()+"!满分值为:"+indexEntity.getIndexScore());
			 if(av2==null ||av2.equals(new BigDecimal(0))){
				 av2=new  BigDecimal(0.01);
			 }
			 params.put("av2",av2 );
//			 System.out.println(av1+"!"+av2+"!"+bv4+"!"+bv5) ;
			 BigDecimal sum_amt =  expressionBigDecimal("(av1+av2)/av2", params);
//			 System.out.println(sum_amt);
			 if (sum_amt.compareTo(bv5)<0 ){
				 value=new BigDecimal(0);
			 }
			 else if (sum_amt.compareTo(bv4)>0){ 
				 value=indexEntity.getIndexScore();
			 }
			 else{
				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore());
				 params1.put("bv4", bv4);
				 params1.put("v4",new BigDecimal("1"));
				 params1.put("v5",bv6);
 				 value=expressionBigDecimal("(v4-(bv4-sum_amt)/v5)*(INDEX_SCORE-v4)+v4", params1);
			 }
			 System.out.println("Y111利息保障倍数:"+value.toString());
			 indexEntity.setiValue(value);
		 }
		 if("Y112".equals(indexEntity.getIndexCode())){
			 String  MARKS=	(String) indexEntity.getRemarks();
				String[] mk=MARKS.split(",");
			 BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
			 BigDecimal av2= getY112Score(iraApplyId);
			 BigDecimal bv3= bd[0];
			 BigDecimal bv4= bd[1];
			 System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+av2.toString()+"!"+bv3.toString()+"!"+bv4.toString()+"!满分值为:"+indexEntity.getIndexScore());
				
			 if(av2==null||av2.equals(new BigDecimal(0))){
				 av2=new  BigDecimal(0.01);
			 }
			 System.out.println(av1+"@"+av2+"@"+bv3+"@"+bv4);
			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("av1",av1 );
			 params.put("av2",av2 );
			 BigDecimal sum_amt =  expressionBigDecimal("av1/av2", params);
			 
			 if (sum_amt.compareTo(bv3)>0 ){
				 value=indexEntity.getIndexScore();
			 }else if (sum_amt.compareTo(bv4)<0){ 
				 value=new BigDecimal(0);
			 }else{
				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore());
				 params1.put("bv3", bv3);
  				 value=expressionBigDecimal("sum_amt/bv3*INDEX_SCORE", params1); 
			 }
			 
			 indexEntity.setiValue(value);
			 System.out.println("Y112净资产与年末贷款余额比例:"+value.toString());
		 }
		 if("Y113".equals(indexEntity.getIndexCode())){
			 String  MARKS=	indexEntity.getRemarks();
			 String[] mk=MARKS.split(",");
			 BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
			 BigDecimal bv4= bd[0];
 			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("av1",av1 );
			 
			 System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+bv4.toString()+"!满分值为:"+indexEntity.getIndexScore());
				
			 if (av1==null ||av1.equals(new BigDecimal(0))){
 				 value=new BigDecimal(0);
			 }else if (av1.compareTo(bv4)>0 ){
				  value=(BigDecimal) indexEntity.getIndexScore();
			 }else {
				  value=new BigDecimal(0);
			 }
			 System.out.println(value);
			 indexEntity.setiValue(value);
			 System.out.println("Y113经营活动产生的净现金流量:"+value.toString());

		 }
		 if("Y114".equals(indexEntity.getIndexCode())){
			 String  MARKS=	indexEntity.getRemarks();
				String[] mk=MARKS.split(",");
			 BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
			 BigDecimal av2= getY114Score(iraApplyId);
 
			 if(av2==null||av2.equals(new BigDecimal(0))){
				 av2=new  BigDecimal(0.01);
			 }
			 BigDecimal bv4= bd[0];
			 BigDecimal bv5= bd[1];
			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("av1",av1 );
			 params.put("av2",av2 );
			 
			 System.out.println(mk[0].toString()+"--->"+av1.toString()+"!平均资产总额:"+av2.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!"+"!满分值为:"+indexEntity.getIndexScore());

			 
			 
			 System.out.println(av1+"!"+av2+"!"+bv4+"!"+bv5) ;

			 BigDecimal sum_amt =  expressionBigDecimal("av1/av2", params);
			 System.out.println(sum_amt);
			 if (sum_amt.compareTo(bv5)<0 ){
				 value=new BigDecimal(0);
			 }
			 else if (sum_amt.compareTo(bv4)>0){ 
				 value=(BigDecimal) indexEntity.getIndexScore();
			 }
			 else{
				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore() );
				 params1.put("bv4", bv4);
			 

 				 value=expressionBigDecimal("sum_amt/bv4*INDEX_SCORE", params1);

			 }
			 System.out.println(value);
			 indexEntity.setiValue(value);
			 System.out.println(indexEntity);

			 System.out.println("Y114总资产利润率:"+value.toString());

		 }
		 if("Y115".equals(indexEntity.getIndexCode())){
			 String  MARKS=	indexEntity.getRemarks();
				String[] mk=MARKS.split(",");
			 BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
			 BigDecimal av2= (BigDecimal) a.get(mk[1].toString());
			 if(av2==null||av2.equals(new BigDecimal(0))){
				 av2=new  BigDecimal(0.01);
			 }
 
			 BigDecimal bv4= bd[0];
			 BigDecimal bv5= bd[1];
			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("av1",av1 );
			 params.put("av2",av2 );
			 
//			 System.out.println(av1+"!"+av2+"!"+bv4+"!"+bv5) ;
			 System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+mk[1].toString()+"--->"+av2.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!满分值为:"+indexEntity.getIndexScore());
				
			 BigDecimal sum_amt =  expressionBigDecimal("av1/av2", params);
			 System.out.println(sum_amt);
			 if (sum_amt.compareTo(bv5)<0 ){
				 value=new BigDecimal(0);
			 }
			 else if (sum_amt.compareTo(bv4)>0){ 
				 value=(BigDecimal) indexEntity.getIndexScore();
			 }
			 else{
				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore() );
				 params1.put("bv4", bv4);
				  

 				 value=expressionBigDecimal("sum_amt/bv4*INDEX_SCORE", params1);

			 }
			 System.out.println(value);
			 indexEntity.setiValue(value);
			 System.out.println(indexEntity);

			 System.out.println("Y115销售利润率:"+value.toString());

		 }
		 if("Y116".equals(indexEntity.getIndexCode())){
			 String  MARKS=	indexEntity.getRemarks();
				String[] mk=MARKS.split(",");
			 BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
			 BigDecimal av2= (BigDecimal) a.get(mk[1].toString());
			 BigDecimal av3= (BigDecimal) a.get(mk[2].toString());

 
			 BigDecimal bv4= bd[0];
			 BigDecimal bv5= bd[1];
			 if(av1==null||av1.equals(new BigDecimal(0))){
				 av1=new  BigDecimal(0.01);
			 }
			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("av1",av1 );
			 params.put("av2",av2 );
			 params.put("av3",av3 );
			 
			 
//			 System.out.println(av1+"!"+av2+"!"+av3+"!"+bv4+"!"+bv5) ;
			 System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+mk[1].toString()+"--->"+av2.toString()+"!"+mk[2].toString()+"--->"+av3.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!满分值为:"+indexEntity.getIndexScore());
				

			 BigDecimal sum_amt =  expressionBigDecimal("(av1-av2-av3)/av1", params);
			 System.out.println(sum_amt);
			 if (sum_amt.compareTo(bv5)<0 ){
				 value=new BigDecimal(0);
			 }
			 else if (sum_amt.compareTo(bv4)>0){ 
				 value=(BigDecimal) indexEntity.getIndexScore();
			 }
			 else{
				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore() );
				 params1.put("bv4", bv4);
				  

 				 value=expressionBigDecimal("sum_amt/bv4*INDEX_SCORE", params1);

			 }
			 System.out.println(value);
			 indexEntity.setiValue(value);
			 System.out.println(indexEntity);

			 System.out.println("Y116主营业务利润率:"+value.toString());

		 }
		 if("Y117".equals(indexEntity.getIndexCode())){
			 String  MARKS=	indexEntity.getRemarks();
				String[] mk=MARKS.split(",");
			 BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
			 BigDecimal av2= (BigDecimal) a.get(mk[1].toString());
 
 
			 BigDecimal bv4= bd[0];
			 BigDecimal bv5= bd[1];
			 BigDecimal bv6= bd[2];
			 if(av2==null||av2.equals(new BigDecimal(0)) ){
				 av2=new  BigDecimal(0.01);
			 }
			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("av1",av1 );
			 params.put("av2",av2 );
 			 
			 System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+mk[1].toString()+"--->"+av2.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!"+bv6.toString()+"!满分值为:"+indexEntity.getIndexScore());
				
//			 System.out.println(av1+"!"+av2+"!"+bv4+"!"+bv5) ;

			 BigDecimal sum_amt =  expressionBigDecimal("av1/av2", params);
			 System.out.println(sum_amt);
			 if (sum_amt.compareTo(bv5)<0 ){
				 value=new BigDecimal(0);
			 }
			 else if (sum_amt.compareTo(bv4)>0){ 
				 value=(BigDecimal) indexEntity.getIndexScore();
			 }
			 else{
				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore() );
				 params1.put("bv4", bv4);
				 params1.put("v4",new BigDecimal("1"));
				 params1.put("v5",bv6);

 				 value=expressionBigDecimal("(v4-(bv4-sum_amt)/v5)*(INDEX_SCORE-v4)+v4", params1);

			 }
			 System.out.println(value);
			 indexEntity.setiValue(value);
			 System.out.println(indexEntity);

			 System.out.println("Y117主营收入现金率:"+value.toString());

		 }
		 if("Y118".equals(indexEntity.getIndexCode())){
			 String  MARKS=	indexEntity.getRemarks();
				String[] mk=MARKS.split(",");
			 BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
			 BigDecimal av2= (BigDecimal) a.get(mk[1].toString());
			 BigDecimal av3= (BigDecimal) a.get(mk[2].toString());

 
			 BigDecimal bv4= bd[0];
			 BigDecimal bv5= bd[1];
			 if(av2==null||av2.equals(new BigDecimal(0))){
				 av2=new  BigDecimal(0.01);
			 }
			 if(av3==null||av3.equals(new BigDecimal(0))){
				 av3=new  BigDecimal(0.01);
			 }
			 
			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("av1",av1 );
			 params.put("av2",av2 );
			 params.put("av3",av3 );
			 
//			 System.out.println(av1+"!"+av2+"!"+av3+"!"+bv4+"!"+bv5) ;
			 System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+mk[1].toString()+"--->"+av2.toString()+"!"+mk[2].toString()+"--->"+av3.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!满分值为:"+indexEntity.getIndexScore());
				
			 BigDecimal sum_amt =  expressionBigDecimal("av1/(av2+av3)", params);
			 System.out.println(sum_amt);
			 if (sum_amt.compareTo(bv5)<0 ){
				 value=new BigDecimal(0);
			 }
			 else if (sum_amt.compareTo(bv4)>0){ 
				 value=(BigDecimal) indexEntity.getIndexScore();
			 }
			 else{
				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore() );
				 params1.put("bv4", bv4);
				 

 				 value=expressionBigDecimal("sum_amt/bv4*INDEX_SCORE", params1);

			 }
			 System.out.println(value);
			 indexEntity.setiValue(value);
			 System.out.println(indexEntity);

			 System.out.println("Y118应收账款和应收票据周转次数:"+value.toString());

		 }
		 if("Y119".equals(indexEntity.getIndexCode())){
			 String  MARKS=	indexEntity.getRemarks();
				String[] mk=MARKS.split(",");
			 BigDecimal av1= (BigDecimal) a.get(mk[0].toString());
			 BigDecimal av2= (BigDecimal) a.get(mk[1].toString());
 
			 if(av2==null||av2.equals(new BigDecimal(0))){
				 av2=new  BigDecimal(0.01);
			 }
			 BigDecimal bv4= bd[0];
			 BigDecimal bv5= bd[1];
			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("av1",av1 );
			 params.put("av2",av2 );
 			 
			 System.out.println(mk[0].toString()+"--->"+av1.toString()+"!"+mk[1].toString()+"--->"+av2.toString()+"!"+bv4.toString()+"!"+bv5.toString()+"!满分值为:"+indexEntity.getIndexScore());
				
//			 System.out.println(av1+"!"+av2+"!"+bv4+"!"+bv5) ;

			 BigDecimal sum_amt =  expressionBigDecimal("av1/av2", params);
			 System.out.println(sum_amt);
			 if (sum_amt.compareTo(bv5)<0 ){
				 value=new BigDecimal(0);
			 }
			 else if (sum_amt.compareTo(bv4)>0){ 
				 value=(BigDecimal) indexEntity.getIndexScore();
			 }
			 else{
				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore() );
				 params1.put("bv4", bv4);
				 

 				 value=expressionBigDecimal("sum_amt/bv4*INDEX_SCORE", params1);

			 }
			 System.out.println(value);
			 indexEntity.setiValue(value);
			 System.out.println(indexEntity);

			 System.out.println("Y119存货周转次数:"+value.toString());

		 }
		 if("Y122".equals(indexEntity.getIndexCode())){
			 BigDecimal bv0= bd[0];
			 BigDecimal bv1= bd[1];
			 BigDecimal bv2= bd[2];
			 BigDecimal bv3= bd[3];
			 BigDecimal av1= getY122Score(iraApplyId);
//			 System.out.println(bv0+"@"+bv1+"@"+bv2+"@"+bv3+"@"+av1);
			 
			 System.out.println(bv0.toString()+"!"+bv1.toString()+"!"+bv2.toString()+"!"+bv3.toString()+"!满分值为:"+indexEntity.getIndexScore());
				
			 value=new BigDecimal(0);
 			 if(av1.compareTo(bv0)==0){
				 value=bv0;
			 }
			    if(av1.compareTo(bv1)==0){
				 value=bv1;
			 }
			   if(av1.compareTo(bv2)==0){
				 value=bv2;
			 }
			   if(av1.compareTo(bv3)==0){
				 value=bv3;
			 }   
			  
			 
			 indexEntity.setiValue(value);
			 System.out.println("Y122近三年利润情况:"+value.toString());

		 }
		 if("Y123".equals(indexEntity.getIndexCode())){
			 BigDecimal bv0= bd[0];
			 BigDecimal bv1= bd[1];
			 BigDecimal bv2= bd[2];
			 BigDecimal av1= getY123Score(iraApplyId);
			 System.out.println(bv0.toString()+"!"+bv1.toString()+"!"+bv2.toString()+"!满分值为:"+indexEntity.getIndexScore());

			 value=new BigDecimal(0);
			 if(av1.compareTo(bv0)>0){
				 value=new BigDecimal(3);
			 }
			 if(av1.compareTo(bv1)>0 && av1.compareTo(bv0)<0){
				 value=new BigDecimal(2);
			 }
			 if(av1.compareTo(bv2)>0 && av1.compareTo(bv1)<0){
				 value=new BigDecimal(1);
			 }
			 indexEntity.setiValue(value);
			 System.out.println("Y123销售增长率:"+value.toString());

		 }
		 if("Y125".equals(indexEntity.getIndexCode())){
			 BigDecimal bv0= bd[0];
			 BigDecimal bv1= bd[1];
			 BigDecimal bv2= bd[2];
 			 BigDecimal av1= getY125Score(iraApplyId);
 			 
			 System.out.println(bv0.toString()+"!"+bv1.toString()+"!"+bv2.toString()+"!担保金额："+av1+"!满分值为:"+indexEntity.getIndexScore());

			 value=new BigDecimal(0);
			 String  MARKS=	indexEntity.getRemarks();
				String[] mk=MARKS.split(",");
			 BigDecimal av2= (BigDecimal) a.get(mk[0].toString());
//			 System.out.println("Y125!!"+bv0+"!!"+bv1+"!!"+av1+"!!"+av2);
			 if(av1==null || av1.compareTo(new BigDecimal(0)  )==0 ){
				 value=(BigDecimal) indexEntity.getIndexScore();
				 
			 }else  if( av2==null ||av2.compareTo(new BigDecimal(0))==0  ){
				 value=new BigDecimal(0);
				 
			 }else {
				 HashMap<String, Object> params = new HashMap<String, Object>();
				 params.put("av1",av1 );
				 params.put("av2",av2);
				 BigDecimal sum_amt =  expressionBigDecimal("av1/av2", params);
				 if(sum_amt.compareTo(bv0)==-1){
					 value=new BigDecimal(5);
					 }
				 else if(sum_amt.compareTo(bv1)==1){
					 value=new BigDecimal(0);
					 }else{

				 HashMap<String, Object> params1 = new HashMap<String, Object>();
				 params1.put("sum_amt",sum_amt );
				 params1.put("INDEX_SCORE",indexEntity.getIndexScore() );
				 params1.put("bv0", bv0);
				 params1.put("v4",new BigDecimal("1"));
				 params1.put("v5",bv2);
				 

 				 value=expressionBigDecimal("(v4-(sum_amt-bv0)/v5)*(INDEX_SCORE-v4)+v4", params1);
					 }
			 }
			 
			 
			 
			 
			 
			 indexEntity.setiValue(value);
			 System.out.println("Y125对外担保比例:"+value.toString());

			
		 }
		}
		 
 		
		
		return indexArr;
	}
	
	public HashMap getFinanceValues(String remarks,List<TbAccFinanceStatementData> list){
		String [] r=remarks.split(",");
 		HashMap map=new HashMap();
 		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < list.size(); j++) {
	 			if(list.get(j).getProjectCd().equals(r[i])){
	 				map.put(r[i], list.get(j).getProjectValue());
	  				break;
				}else{
					 continue;
				}
			}	
		}
		return map;
	}
	public BigDecimal getY112Score(String iraApplyId ){
//		DataObject[] arr = new DataObject[0];
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("iraApplyId", iraApplyId);
//		Object[] tmpjjye = DatabaseExt.queryByNamedSql(GitUtil.DEFAULT_DS_NAME,
//				"com.bos.irm.modelCalc.model.getjjye", map);
//		arr=new DataObject[tmpjjye.length];
//		for (int i = 0; i < tmpjjye.length; i++) {
//			DataObject dat = (DataObject) tmpjjye[i];
//			arr[i] = new DataObjectImpl(new DataObjectType());
//			List list = dat.getInstanceProperties();
//			for (int j = 0; j < list.size(); j++) {
//				Property prop = (Property) list.get(j);
//				arr[i].set(prop.getName(), dat.get(prop));
//				System.out.println(arr[i]);
//			}
//		
//		}
// 		
//		BigDecimal a= arr[0].getBigDecimal("JJYE");
//		if(a==null||a.equals(new BigDecimal(0))){ a=new BigDecimal(0);}
//		return  a;
		return null;
	}
	
	public BigDecimal expressionBigDecimal(String expStr,Map<String, Object> params){
		Expression compiledExp = AviatorEvaluator.compile(expStr);
		BigDecimal result = (BigDecimal)compiledExp.execute(params);
		return result;
	}
	
	public BigDecimal getY122Score(String iraApplyId ){
		List<ScoreBean> arr = irmMapper.getjlr(iraApplyId);
		if(arr == null || arr.size() < 3){
			BigDecimal s=new BigDecimal(0);
			return s;
		}
		BigDecimal a=new BigDecimal(0);
		if(	   arr.get(0).getProjectValue().compareTo(arr.get(1).getProjectValue()) > 0
			&& arr.get(1).getProjectValue().compareTo(arr.get(2).getProjectValue()) > 0){
			a=new BigDecimal(3);
		}else
		if(    arr.get(0).getProjectValue().compareTo(arr.get(1).getProjectValue()) < 0
	        && arr.get(1).getProjectValue().compareTo(arr.get(2).getProjectValue()) < 0){
			a=new BigDecimal(0);
		}else
		if(    arr.get(0).getProjectValue().compareTo(arr.get(1).getProjectValue()) > 0
			&& arr.get(1).getProjectValue().compareTo(arr.get(2).getProjectValue()) < 0
			&& arr.get(0).getProjectValue().compareTo(arr.get(2).getProjectValue()) > 0){
			a=new BigDecimal(2);
		}else
		if(    arr.get(0).getProjectValue().compareTo(arr.get(1).getProjectValue()) > 0
			&& arr.get(1).getProjectValue().compareTo(arr.get(2).getProjectValue()) < 0
			&& arr.get(0).getProjectValue().compareTo(arr.get(2).getProjectValue()) < 0){
			a=new BigDecimal(1);
		}
		return  a;
	}
	
	public BigDecimal getY123Score(String iraApplyId ){
		List<ScoreBean> arr = irmMapper.getyysr(iraApplyId);
		if(arr == null || arr.size() < 2){
			BigDecimal s=new BigDecimal(0);
			return s;
		}
		 HashMap<String, Object> params = new HashMap<String, Object>();
		 BigDecimal av1=arr.get(0).getProjectValue();
		 BigDecimal av2=arr.get(1).getProjectValue();
		 System.out.println("getY123Score"+av1.toString()+"!"+av2.toString());

		 if(av2==null || av2.equals(new BigDecimal(0))){
			 av2=new BigDecimal(0.01);
		 }
		 params.put("av1",av1);
		 params.put("av2",av2);
			 
 
		 BigDecimal sum_amt =  expressionBigDecimal("(av1-av2)/av2", params);
		 System.out.println(sum_amt);
 		return  sum_amt;
	}
	
	
	
	
	public BigDecimal getY114Score(String iraApplyId ){
		
		List<ScoreBean> arr = irmMapper.getyysr1(iraApplyId);
		if(arr == null || arr.size() < 2){
			BigDecimal s=new BigDecimal(0);
			return s;
		}
		BigDecimal a= new BigDecimal(0);
		HashMap<String, Object> params = new HashMap<String, Object>();
		BigDecimal av1=arr.get(0).getProjectValue();
		BigDecimal av2=arr.get(1).getProjectValue();
		System.out.println("getY114Score:"+av1.toString()+"!"+av2.toString());
	 
		params.put("av1",av1);
		params.put("av2",av2);
		params.put("av3",new BigDecimal(2));
 
		BigDecimal sum_amt =  expressionBigDecimal("(av1+av2)/av3", params);
		System.out.println(sum_amt);
 		a=  sum_amt;
		return   a;
	}
	
	
	public BigDecimal getY125Score(String iraApplyId ){
		List<ScoreBean> arr = irmMapper.getdbje(iraApplyId);
		if(arr == null || arr.size() == 0){
			return new BigDecimal(0);
		}		
 		BigDecimal sum_amt=arr.get(0).getProjectValue();
 		return  sum_amt;
	}
	/**
	 * 俩位小数的四舍五入
	 * */
	public BigDecimal numFormat(double a){
		String result = String.format("%.2f", a);
		System.out.println(result);
		return new BigDecimal(result);
	}
	/**
	 *模型得分对应信用等级显示
	 * */
	public String getModelCreditRating(String modelId,BigDecimal score, String partyId){
		//String creditCall = calAllCredit(partyId);//担保公司定量指标计算
		TbCsmCorporation corporation = tbCsmCorporationMapper.selectByPrimaryKey(partyId);
		String thirdCustTypeCd = corporation.getThirdCustTypeCd();//第三方客户类型
		BigDecimal score1= new BigDecimal("0");
		score1=score.setScale(0,BigDecimal.ROUND_HALF_UP);
		List<TbIrmModelScale> arr = irmMapper.getModelScale(modelId);
		//}
		//score1 = score1.add(creditCal);
		String creditRatingCd = null;
		for (int i = 0; i < arr.size(); i++) {
			
			TbIrmModelScale modelScale = arr.get(i);

			
			if((score1.compareTo(modelScale.getMinValue())==1||score1.compareTo(modelScale.getMinValue())==0)&&(score1.compareTo(modelScale.getMaxValue()))==-1||score1.compareTo(modelScale.getMaxValue())==0){
				creditRatingCd =	modelScale.getCreditRatingCd();
			
			}
		}
		return creditRatingCd;
		
	}
	/**
	 *模型得分对应信用等级显示XG
	 * */
	public static String getModelCreditRating_xg(String modelId,List<TbIrmIndexScore> nonFinanceIndexs,BigDecimal indexScore ,String creditRatingCd ){
		String creditRatingCd1=creditRatingCd;
		BigDecimal score1=indexScore.setScale(0,BigDecimal.ROUND_HALF_UP);
		System.out.println(modelId+";"+indexScore+";"+creditRatingCd);
		for (int i = 0; i < nonFinanceIndexs.size(); i++) {
			String indexCode = nonFinanceIndexs.get(i).getIndexCode();
	 		System.out.println(indexCode);
			if("Y135".equals(indexCode)&& nonFinanceIndexs.get(i).getIndexScore().compareTo(new BigDecimal("0"))==0
				&& score1.compareTo(new BigDecimal("57"))==1){
				creditRatingCd1="B";
				break;
			}else {
				continue;
			}
		}
		return creditRatingCd1;
}
}
