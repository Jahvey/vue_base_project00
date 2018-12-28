package com.cdgit.loan.business.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cdgit.feignconsumer.client.WorkFlowFeignClient;
import com.cdgit.loan.business.bean.BizApplicationVO;
import com.cdgit.loan.business.bean.TbBizAmountApply;
import com.cdgit.loan.business.bean.TbBizAmountDetailApply;
import com.cdgit.loan.business.bean.TbBizApply;
import com.cdgit.loan.business.bean.TbBizApprove;
import com.cdgit.loan.business.mapper.QueryMapper;
import com.cdgit.loan.common.constants.BizConstants;
import com.cdgit.loan.common.util.MapUtils;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.mycustomer.mapper.MyCustomerMapper;
import com.cdgit.loan.user.bean.TbCsmNaturalPerson;
import com.cdgit.loan.user.bean.TbCsmParty;
import com.cdgit.loan.user.mapper.UserMapper;
import com.github.pagehelper.PageInfo;
import com.cdgit.loan.common.util.FlowUtil;

@Service
@Transactional
public class BusinessEntryServiceImpl {

	@Autowired
	QueryMapper queryMapper;
	
	@Autowired
	MyCustomerMapper myCustomerMapper;
	
	@Autowired
	UserMapper userMapper;
	
//	@Autowired
//	WorkFlowFeignClient workFlowFeignClient;
	
	/**
	 * 发起业务申请，创建流程
	  业务申请模块中 调用客户信息的是否考虑调用微服务？
	  bizDao0301
	 * <p>Title: createBizApply</p>  
	
	 * <p>Description: </p>
	 */
	public void createBizApply(BizApplicationVO bizApplicationVO){
		
		TbCsmParty tbCsmParty=myCustomerMapper.getTbCsmPartyById(bizApplicationVO.getPartyId());
		TbCsmNaturalPerson tbCsmNaturalPerson=myCustomerMapper.getTbCsmNaturalPersonById(bizApplicationVO.getPartyId());
//		List<TbBizApprove> listApprove=queryMapper.queryTbBizApproveList(bizApplicationVO.getPartyId());
		
		TbBizApply tbBizApply=new TbBizApply();
		
		tbBizApply.setApplyId(UUIDGenerator.getUUID());//统一生成主键方法
		tbBizApply.setBizNum("YW180909015961");//根据sequence生成业务编号  写一个公共方法
		tbBizApply.setStatusType("01");//状态
		tbBizApply.setOrgNum("");//获取当前登录人所在机构
		tbBizApply.setUserNum("");//获取当前登录人操作员号
		tbBizApply.setCreateTime(new Date());//创建时间
		tbBizApply.setApplyDate(new Date());//创建时间
		
		
		TbBizAmountApply tbBizAmountApply=new TbBizAmountApply();
		tbBizAmountApply.setAmountId(UUIDGenerator.getUUID());
		tbBizAmountApply.setPartyId(tbBizApply.getPartyId());
		tbBizAmountApply.setApplyId(tbBizApply.getApplyId());
		tbBizAmountApply.setCreateTime(new Date());
		
		
		TbBizAmountDetailApply tbBizAmountDetailApply=new TbBizAmountDetailApply();
		tbBizAmountDetailApply.setAmountDetailId(UUIDGenerator.getUUID());
		tbBizAmountDetailApply.setApplyId(tbBizApply.getApplyId());
		tbBizAmountDetailApply.setAmountId(tbBizAmountApply.getAmountId());
		tbBizAmountDetailApply.setCreditMode(tbBizApply.getCreditMode());
		tbBizAmountDetailApply.setCycleInd("0");
		tbBizAmountDetailApply.setCurrencyCd("CNY");
		tbBizAmountDetailApply.setCreateTime(new Date());
		
//		if(null != listApprove && listApprove.size() > 0){
//			tbBizApply.setBizHappenNature("01");//01-存量新增
//		}else {
//			tbBizApply.setBizHappenNature("10");//10-首次新增
//		}
		
		String tableName="SEQ_BIZ_PF.nextval";
		Map map=new HashMap<String,Object>();
		map.put("tableName", tableName);
		String num=String.valueOf(userMapper.getNextVal(map));
		tbBizApply.setBizNum("YW"+"181210"+StringUtils.leftPad(num, 6, '0'));
		if(BizConstants.PARTY_TYPE_CD_6.equals(tbCsmParty.getPartyTypeCd())){
			
		}
		
		//2018-12-10 调用创建流程服务   传递业务变量封装成对象，统一生成发送格式的json字符串
		StringBuffer sb=new StringBuffer();
		sb.append("{ ");
		sb.append("\r");
		sb.append("\"RequestBody\": { ");
		sb.append("\r");
		sb.append("\"processKey\":");
		sb.append("\r");
		sb.append("\"group_cust_biz_apply_pwfm\"");
		sb.append(",");
		sb.append("\r");
		sb.append("\"userNo\":\"001\"");
		sb.append(",");
		sb.append("\r");
		sb.append("\"businessKey\":");
		sb.append("\"YW\"");
		sb.append("\r");
		sb.append("}");
		sb.append("\r");
		sb.append("}");
//		String process=workFlowFeignClient.startProInst(sb.toString());
		
		Map map1 = new HashMap();
        map1.put("processKey", "group_cust_biz_apply_pwfm");
        map1.put("userNo", "001");
        map1.put("businessKey", "YW001");
//        String str = JSONObject.toJSONString(map1);//fastjson默认转换是不序列化null值对应的key的
		
//		测试返回报文结果 流程实例ID:{"pendingTask":{"id":"310007","executionId":"310004","procInstId":"310001","procDefId":"group_cust_biz_apply_pwfm:3:305004","name":"客户经理岗","taskDefKey":"usertask1","assignee":"001","createTime":"2018-12-11","startUser":"001"}}
		
//		String process=workFlowFeignClient.startProInst(FlowUtil.generatorProcessMessage(map1));
		
		
//		Map processMap=MapUtils.strToMap(process);
		
		
//		Map<String, Object> pendingTaskMap = (Map<String, Object>)MapUtils.strToMap(process).get("pendingTask");
//		String procInstId = (String)pendingTaskMap.get("procInstId");
		
	}
	
	/**
	 * 
	转化有问题
	 * <p>Title: getBizList</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public PageInfo<Map<String,Object>> getBizList(Map map){
		List<TbBizApprove> userList=queryMapper.getBizList(map);
        PageInfo pageInfo=new PageInfo(userList,Integer.valueOf((String)map.get("pageSize")));
    	return pageInfo;
	}
	
	/**
	 * 
	
	 * <p>Title: getBizList</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public PageInfo<Map<String,Object>> getBizList1(Map map){
		List<Map<String,Object>> userList=queryMapper.getBizList1(map);
        PageInfo pageInfo=new PageInfo(userList,Integer.valueOf((String)map.get("pageSize")));
    	return pageInfo;
	}
	
	/**
	 * 
		获取下一岗位ID
	 * <p>Title: getNextPosition</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public String getNextPosition(Map map){
//		StringBuffer sb=new StringBuffer();
//		sb.append("{ ");
//		sb.append("\r");
//		sb.append("\"RequestBody\": { ");
//		sb.append("\r");
//		sb.append("\"procDefId\":");
//		sb.append("\"group_cust_biz_apply_pwfm:3:305004\"");//如何动态替换procDefId
//		sb.append(",");
//		sb.append("\r");
//		sb.append("\"procDefNodeId\":");//如何动态替换procDefId  任务节点ID
//		sb.append("\"usertask1\"");
//		sb.append(",");
//		sb.append("\r");
//		sb.append("\"variables\":{");//variables 这个传具体的业务变量用于流程判断
//		sb.append("\r");
//		sb.append("}");
//		sb.append("\r");
//		sb.append("}");
//		sb.append("\r");
//		sb.append("}");
//		String openTaskResult=workFlowFeignClient.openTask(sb.toString());
		
		
//		{"nextTaskNodeAttriBute":{"03":"1878","04":"0","nextTaskDefKey":"usertask2","nextTaskDefName":"风险客户经理岗"}}
//03 标识 岗位   1878 表示岗位ID  04 标识 是否会签  0-否 1-是
		
//		String openTaskResult=workFlowFeignClient.openTask(FlowUtil.generatorProcessMessage(map));
		
		return "";
	}
	
	
	/**
	 * 
	
	 * <p>Title: getTaskagencyConfig</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public String getTaskagencyConfig(Map map){
//		StringBuffer sb=new StringBuffer();
//		sb.append("{ ");
//		sb.append("\r");
//		sb.append("\"RequestBody\": { ");
//		sb.append("\r");
//		sb.append("\"beAgentPersonNo\":");
//		sb.append("\"test100\"");//如何动态替换beAgentPersonNo
//		sb.append("\r");
//		sb.append("}");
//		sb.append("\r");
//		sb.append("}");
//		String getTaskagencyConfigTaskResult=workFlowFeignClient.getTaskagencyConfig(sb.toString());
		
//		String getTaskagencyConfigTaskResult=workFlowFeignClient.getTaskagencyConfig(FlowUtil.generatorProcessMessage(map));
		
		
		return "";
	}

	/**
	 * 任务提交
	 * 2018-12-13
	 */
	public String taskCommit(Map map){
//		StringBuffer sb=new StringBuffer();
//		sb.append("{ ");
//		sb.append("\r");
//		sb.append("\"RequestBody\": { ");
//		sb.append("\r");
//		sb.append("\"nextTaskDefKey\":");
//		sb.append("\"usertask2\"");//下一节点
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"nodeType\":");
//		sb.append("\"0\"");//nodeType
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"procDefId\":");
//		sb.append("\"group_cust_biz_apply_pwfm:3:305004\"");//如何动态替换nextTaskDefKey
//		sb.append(",");
//		sb.append("\r");
//		
//		String assigneeArray="[\"test100\"]";
//		
//		sb.append("\"assignee\":");
//		sb.append(""+assigneeArray+"");//assignee   下一审批人
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"agentPersonNo\":");//agentPersonNo  代办人
//		sb.append("\"\"");
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"createUserNo\":");//createUserNo
//		sb.append("\"\"");//被代办人
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"procInstId\":");
//		sb.append("\"310001\"");//procInstId   流程实例id
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"taskId\":");
//		sb.append("\"310007\"");//openTask中的     taskId   任务id   节点id  从我的工作进入的话，从列表带到意见页面提交
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"comment\":");
//		sb.append("\"test100\"");//comment意见
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"variables\":{");//variables 这个传具体的业务变量用于流程判断
//		sb.append("\r");
//		sb.append("}");
//		sb.append("\r");
//		
//		sb.append("}");
//		sb.append("\r");
//		sb.append("}");
		
		
//		StringBuffer sb=new StringBuffer();
//		sb.append("{ ");
//		sb.append("\r");
//		sb.append("\"RequestBody\": { ");
//		sb.append("\r");
//		sb.append("\"nextTaskDefKey\":");
//		sb.append("\"usertask3\"");//下一节点
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"nodeType\":");
//		sb.append("\"0\"");//nodeType
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"procDefId\":");
//		sb.append("\"group_cust_biz_apply_pwfm:3:305004\"");//如何动态替换nextTaskDefKey
//		sb.append(",");
//		sb.append("\r");
//		
//		String assigneeArray="[\"test200\"]";//数组形式的json字符串  直接前台选择下一审批人时拼接成这种形式的json字符串
//		
//		sb.append("\"assignee\":");
//		sb.append(""+assigneeArray+"");//assignee   下一审批人
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"agentPersonNo\":");//agentPersonNo  代办人
//		sb.append("\"\"");
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"createUserNo\":");//createUserNo
//		sb.append("\"\"");//被代办人
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"procInstId\":");
//		sb.append("\"310001\"");//procInstId   流程实例id
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"taskId\":");
//		sb.append("\"325004\"");//openTask中的     taskId   任务id   节点id  从我的工作进入的话，从列表带到意见页面提交
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"comment\":");
//		sb.append("\"test200\"");//comment意见
//		sb.append(",");
//		sb.append("\r");
//		
//		sb.append("\"variables\":{");//variables 这个传具体的业务变量用于流程分支判断  具体业务逻辑调用时怎么传？
//		sb.append("\r");
//		sb.append("}");
//		sb.append("\r");
//		
//		sb.append("}");
//		sb.append("\r");
//		sb.append("}");
//		String taskCommitResult=workFlowFeignClient.taskCommit(sb.toString());
		
		//对于variables而言,
		Map variables=new HashMap<String,Object>();
		variables.put("loanAmt", "");
		variables.put("term","12");//
		map.put("variables", variables);
//		String taskCommitResult=workFlowFeignClient.taskCommit(FlowUtil.generatorProcessMessage(map));
		return "";
	}
	
	/**
	 * 流程结束时调用 taskId taskId由我的工作列表点击执行时带入页面
	 * openTask 返回下一岗位
	
	 * <p>Title: taskEnd</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public String taskEnd(Map map){
		map.put("taskId", "327504");
//		String taskEnd=workFlowFeignClient.taskEnd(FlowUtil.openTaskProcess(map));
		return "";
	}
	
}
