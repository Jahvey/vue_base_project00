package com.cdgit.loan.workflow.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.cdgit.feignconsumer.client.WorkFlowFeignClient;
import com.cdgit.loan.common.util.FlowConstants;
import com.cdgit.loan.common.util.FlowUtil;
import com.cdgit.loan.common.util.IBIZProcess;
import com.cdgit.loan.common.util.MapUtils;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.contract.bean.TbLoanSummary;
import com.cdgit.loan.contract.mapper.CrtTbLoanSummaryMapper;
import com.cdgit.loan.sysManage.position.mapper.OmPositionMapper;
import com.cdgit.loan.workflow.bean.TbConLoanChange;
import com.cdgit.loan.workflow.bean.TbWfmParticipant;
import com.cdgit.loan.workflow.bean.TbWfmProcessinstance;
import com.cdgit.loan.workflow.bean.TbWfmProcessmapping;
import com.cdgit.loan.workflow.bean.TbWfmWorkiteminstance;
import com.cdgit.loan.workflow.bean.TbWfmWorkitemmapping;
import com.cdgit.loan.workflow.mapper.WorkFlowMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class WorkFlowServiceImpl {

	@Autowired
	WorkFlowMapper workFlowMapper;
	
	@Autowired
	CrtTbLoanSummaryMapper loanSummaryMapper;
	
	@Autowired
	OmPositionMapper omPositionMapper;
	
//	@Autowired
//	WorkFlowFeignClient workFlowFeignClient;
	
//	@Autowired
//	WorkFlowFeignClient workFlowFeignClient;
	
	@RequestMapping(value="/queryWorkingList",method=RequestMethod.POST)
	public Map queryWorkingList(Map map){
		Map workingMap=new HashMap();
		workingMap.put("userNo", (String)map.get("userid"));
		workingMap.put("curPage", (Integer)map.get("pageNum"));
		workingMap.put("pageSize", (Integer)map.get("pageSize"));
		if(StringUtils.isNotEmpty((String)map.get("custName"))
				|| StringUtils.isNotEmpty((String)map.get("startDate"))
				|| StringUtils.isNotEmpty((String)map.get("endDate"))
				|| StringUtils.isNotEmpty((String)map.get("flowTypeCd"))){//如果有输入查询条件 则信贷系统先查询响应满足条件列表 再向流程管理中心发送交易查询流程信息，然后再由信贷查询每条数据   先测试是否可靠
			PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
			List userList=workFlowMapper.queryWorkingList();
	        PageInfo pageInfo=new PageInfo(userList,(Integer)map.get("pageSize"));
		}else{//如果没有输入查询条件 信贷系统直接先调用流程管理中心服务
//			String workingList=workFlowFeignClient.pendingList(FlowUtil.generatorProcessMessage(workingMap));
//			Map workingListMap=MapUtils.strToMap(workingList);
//			List resultList=new ArrayList();
//			if(null != workingListMap.get("total") && (Integer)workingListMap.get("total") > 0){
//				for(int i = 0;i<(Integer)workingListMap.get("total");++i){
//					
//				}
//			}
			
//			return workingListMap;
		}

		return null;
	}
	
	/**
	 * 跟踪列表  先调用流程管理中心服务获取跟踪列表
	 * 再根据业务businesskey查询相关业务信息
	
	 * <p>Title: queryWorkedList</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public Map queryWorkedList(Map map){
		Map workedMap=new HashMap();
		workedMap.put("userNo", (String)map.get("userid"));
		workedMap.put("curPage", (Integer)map.get("pageNum"));
		workedMap.put("pageSize", (Integer)map.get("pageSize"));
//		String workedList=workFlowFeignClient.pendingList(FlowUtil.generatorProcessMessage(workedMap));
//		Map workedListMap=MapUtils.strToMap(workedList);
//		if(null != workedListMap.get("traceList") && ((List)workedListMap.get("traceList")).size() > 0){
//			
//		}
//		return workedListMap; 
		
		return null;
	}
	
	/**
	 * 查询提示信息列表
	
	 * <p>Title: queryRemindInfoGroup</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public List queryRemindInfoGroup(Map map){
		//第一步 分页查询提示列表汇总
		List remindInfoList=workFlowMapper.queryRemindInfoGroup();
		String checkResult=checkRoleInfo();
		if("1".equals(checkResult)){//非客户经理
			workFlowMapper.countRemindInfoAdmin();
		}else{//客户经理
			workFlowMapper.countRemindInfo();
		}
		return remindInfoList; 
	}
	
	/**
	 * 角色检查判断
		返回是否客户经理标志
	 * <p>Title: checkRoleInfo</p>  
	
	 * <p>Description: </p>  
	
	 * @param roles
	 * @return
	 */
	public String checkRoleInfo() {
//		for (Role role : roles) {
//			if ("R1159".equals(role.getString("roleid")) || "R1147".equals(role.getString("roleid")) || "R1153".equals(role.getString("roleid")) || "R1006".equals(role.getString("roleid")) || "R1007".equals(role.getString("roleid")) || "R1002".equals(role.getString("roleid"))
//					|| "R1008".equals(role.getString("roleid"))) {
//				return "0";//客户经理
//			} else {
//				continue;
//			}
//		}
		return "1";
	}
	
	/**
	 * 根据返回实例信息创建流程公共表
	信贷创建业务成功后，调用流程管理中心服务 启动流程实例，信贷然后再插入tb_wfm_processinstance
	 * <p>Title: createCommonProcess</p>  
	
	 * <p>Description: </p>
	 */
	public void createCommonProcess(Map map){
		
		Map map1 = new HashMap();
        map1.put("processKey", "group_cust_biz_apply_pwfm");//由各个业务流程发起决定流程模板 也即是 key
        map1.put("userNo", "001");//当前操作员
        map1.put("businessKey", "YW001");//信贷系统生成的业务编号
        
        //本地测试先注释
//		String process=workFlowFeignClient.startProInst(FlowUtil.generatorProcessMessage(map1));
//		Map processMap=MapUtils.strToMap(process);
		
        //本地测试先增加
		String process="";
		
		Map<String, Object> pendingTaskMap = (Map<String, Object>)MapUtils.strToMap(process).get("pendingTask");
		String procInstId = (String)pendingTaskMap.get("procInstId");
		
		TbWfmProcessinstance processInstance=new TbWfmProcessinstance();
		processInstance.setProcessId("");//流程实例ID
		processInstance.setActivityName("");//
		processInstance.setAppointOrgCd("");//创建时默认分配机构为创建机构
		processInstance.setAppointOrgName("");//创建时默认分配机构为创建机构
		processInstance.setAppointUserName("");//创建时默认分配操作员为创建人，也即当前登录操作员
		processInstance.setAppointUserNum("");//创建时默认分配操作员为创建人，也即当前登录操作员
		processInstance.setBizStatus("");//
		processInstance.setCreateOrgName("");//创建机构名称
		processInstance.setCreateOrgNum("");//创建机构编号
		processInstance.setCreatePostCd("");//创建时 创建岗位默认登录人
		processInstance.setCreatePostName("");//创建时 创建岗位默认登录人
		processInstance.setCreateTime(new Date());
		processInstance.setCreateUserName("");//默认当前操作员
		processInstance.setCreateUserNum("");//默认当前操作员
		processInstance.setCusName("");//客户名称
		processInstance.setProcessStatus("run");//创建时默认就是 run
		processInstance.setProductCd("");//好像就是空的
		processInstance.setProductId("");//实测只有id有值
		processInstance.setProductName("");
		processInstance.setTemplateVersion("");
		processInstance.setProcessdefname("");//com.bos.bps.pay.payBiz_bcfm  即传入的processKey
		processInstance.setProcessinstancename("");//出账管理-出账申请
		processInstance.setLastupdatetime(new Date());//
		processInstance.setCustId("");//客户编号
		processInstance.setPostCd("");//感觉应该是当前待处理岗位  创建时还没提交就是空的
		workFlowMapper.insertProcessinstance(processInstance);
	}
	
	/**
	 * 待办工作列表点击执行
	插入 tb_wfm_workiteminstance
	创建岗位进来时点击执行 插入 记录
	流程中的岗位进来涉及执行或认领执行的问题
	执行，跟创建岗位执行一样的处理
	 * <p>Title: getWorItem</p>  
	
	 * <p>Description: </p>
	 */
	public void getWorkItem(Map map){
		//原系统有校验操作   chackProcessStatus  后面再检查
		
//		insertTbWfmWorkitemInstance
		
		//查询流程模板映射表  template_version 默认从列表带进来 
		TbWfmProcessmapping processmapping;
		List processmappingList=workFlowMapper.queryProcessmapping(map);
		if(processmappingList != null && processmappingList.size() > 0){
			processmapping=(TbWfmProcessmapping)processmappingList.get(0);//默认取第一条
		}
		
		List workitemmappingList=workFlowMapper.queryWorkitemmapping(map);
		TbWfmWorkitemmapping workitemmapping;
		if(null!=workitemmappingList && workitemmappingList.size() > 0){
			workitemmapping = (TbWfmWorkitemmapping)workitemmappingList.get(0);
		}
		
		
		
		map.put("status", "run");//程序默认给的是正在运行中
		int instanceCount=workFlowMapper.queryWorkiteminstance(map); //查询工作项
		if(instanceCount == 0){
			 
			//以前这里有一步查询流程库的数据判断是否应该执行插入，怎么替代？  暂时不考虑
			
			TbWfmWorkiteminstance workIteminstance=new TbWfmWorkiteminstance();
			workIteminstance.setWorkInstanceId(UUIDGenerator.getUUID());
			workIteminstance.setProcessId((String)map.get("processInstId"));
			workIteminstance.setActivityId("");
			workIteminstance.setActivityName("");
			workIteminstance.setUserName("");
			workIteminstance.setUserNum("");
			workIteminstance.setOrgName("");
			workIteminstance.setOrgNum("");
			workIteminstance.setPostName("");
			workIteminstance.setStatus("run");//默认插入的时候就是run
			workIteminstance.setPerformtime(new Date());
			workIteminstance.setTag("");//activityDefId
//			workIteminstance.setReceiveTime(receiveTime);
			workFlowMapper.insertWorkiteminstance(workIteminstance);
		}
		
		
	}
	
	/**
	 * 意见提交时候新增参与人表 参考普元EOS修改
		String users , String workitemId
		下一操作人     当前工作项ID
	 * <p>Title: addTbWfmParticipantByUsers</p>  
	
	 * <p>Description: 新增下一节点参与者结束</p>
	 */
	public void addTbWfmParticipantByUsers(String users,String workitemId){
		
		if(null!=users && !"".equals(users)&&!"null".equals(users)){
			
			if(users.indexOf(",")!=-1){
				String[] userArry = users.split(",");
				for (int i = 0; i < userArry.length; i++) {
					String string = userArry[i];
					TbWfmParticipant participant=new TbWfmParticipant();
					participant.setId(workitemId);
					participant.setpId(UUIDGenerator.getUUID());
					participant.setUserNum(string);
				}
			}else{
				TbWfmParticipant participant=new TbWfmParticipant();
				participant.setId(workitemId);
				participant.setpId(UUIDGenerator.getUUID());
				participant.setUserNum(users);
				
			}
		}
	}
	
	/**
	 * 目前没发现用处
	
	 * <p>Title: chengeWfModifySaveFlag</p>  
	
	 * <p>Description: </p>  
	
	 * @param viewUrl
	 * @param processInstId
	 */
	public static void chengeWfModifySaveFlag(String viewUrl, String processInstId) {
		
		
//		Map<String, Object> relaDatas = new HashMap<String, Object>();
//
//		// 截取页面类型
//		String pageType = viewUrl.substring(viewUrl.lastIndexOf("_") + 1, viewUrl.indexOf(".jsp"));
//		// 查看页面
//		if (FlowConstants.PAGETYPE_VIEW.equals(pageType)) {
//
//			relaDatas.put("wfModifySaveFlag", "true");
//
//			// 编辑页面
//		} else if (FlowConstants.PAGETYPE_EDIT.equals(pageType)) {
//
//			relaDatas.put("wfModifySaveFlag", "false");
//		} else {// 默认为true
//			relaDatas.put("wfModifySaveFlag", "true");
//		}
//
//		// 因为后续业务发展要求，虽然修改标志，暂时没用，但现在需要增加阅读标志记录。
//		relaDatas.put("wfReadStatus", "2");
//
//		RelativeDataManagerService.setRelativeDataBatch(Long.valueOf(processInstId), relaDatas);
		
	}
	
	/**
	 * 待办工作列表点击认领执行
	应该是如果查询结果包括分配给我的任务情况，则需要点击认领执行，然后再做相应的更新
	 * <p>Title: updateWorkItem</p>  
	
	 * <p>Description: </p>
	 */
	public void updateWorkItem(Map map){
		//assignWorkItemToSelf 认领执行  后 更新 tb_wfm_processinstan 更新  tb_wfm_workiteminstance
		map.put("appointOrgCd", "");//当前登录人机构
		map.put("appointOrgName", "");//当前登录人机构
		map.put("appointUserNum", "");//当前登录人编号
		map.put("appointUserName", "");//当前登录人名称
		workFlowMapper.updateProcessinstance(map);
		
	// 然后调用  getWorItem
		this.getWorkItem(map);
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
	 * 根据岗位ID查询
	
	 * <p>Title: getPositionCodeInfo</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public List getPositionCodeInfo(Map map){
		List empList=workFlowMapper.getPositionCodeInfo(Long.valueOf((String)map.get("positionId")));
		return empList;
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
	 * 
	
	 * <p>Title: taskCommit</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 */
	public void taskCommit(Map map){
		
		//queryEcifiNo 查询拦截和风险提示
		
		//datacheck 方法中的  sysParamCheck
		
		//submitProcessToNext  成功后执行 toProUpdateJJ  processInstId  实际应该根据流程模板类型来判断是否贷后信息变更 而不是所有的执行查询
		
		// 审批结论
		String conclusion = (String)map.get("conclusion");
		// 流程实例ID
		String processInstId = (String)map.get("processInstId");
		// 当前活动实例ID
		String currentActInstID = (String)map.get("activityInstId");
		// 当前活动定义ID
		String currentActDefId = (String)map.get("activityDefId");
		// 工作项实例ID
		String workItemId = (String)map.get("workItemId");
		// 活动图元类型
		String activityType = (String)map.get("activityType");
		
		if (null == conclusion || "".equals(conclusion)) {
			// 默认为同意
			conclusion = "1";
			map.put("conclusion", conclusion);
		}
		
		/**
		 * 退回操作或再议操作
		 */
		if (FlowConstants.APPROVE_99.equals(conclusion) || FlowConstants.APPROVE_997.equals(conclusion)) {
			
		}else if (FlowConstants.APPROVE_98.equals(conclusion)) {
			/**
			 * 补录材料:与退回操作相同，唯一不同的是，需要设置退回操作岗标识，用于补录完成后，直接提交至该岗
			 */
		}else if (FlowConstants.APPROVE_999.equals(conclusion) || FlowConstants.APPROVE_2.equals(conclusion)) {
			/**
			 * 结束流程操作：具有否决权限的岗位，其它选择不同意，则直接提交给下一岗。
			 */
		}else{
			/**
			 * 其它情况，不管选择同意，有条件同意，不同意等，都正常提交（需要特殊处理结束图元，如果是最后一岗时，回调结束业务函数）
			 * 对于补充材料后再提交的情况，需要设置默认线的值成立，并重新创建目标节点工作项
			 */
		}
		
		//调用流程管理提交方法
//		flowutil.submitProcessToNext
		//对于variables而言,
						Map variables=new HashMap<String,Object>();
						variables.put("loanAmt", "");//这个流程变量要根据实际业务动态设置
						variables.put("term","12");//
						map.put("nextTaskDefKey", "");//
						map.put("nodeType", "");//
						map.put("variables", variables);//流程变量
						map.put("assignee", "");//数组形式的json字符串    流程管理中心要转换成list
						map.put("agentPsersonNo", "");//代办人
						map.put("createUserNo", "");//代办创建人
						map.put("comment", "");//
						map.put("taskId", "");//
//						String taskCommitResult=workFlowFeignClient.taskCommit(FlowUtil.generatorProcessMessage(map));
		//提交后插入 tb_wfm_workiteminstance  更新tb_wfm_processinstance 要判断是否最后一个流程节点
		map.put("processStatus", "finish");
		map.put("appointOrgCd", "无");
		map.put("appointOrgName", "无");
		map.put("appoinUserNum", "无");
		map.put("appoinUserNum", "无");
		map.put("finishTime", new Date());
		map.put("lastupdatetime", new Date());
		workFlowMapper.updateProcessinstance(map);				
						
		//这里是toProUpdateJJ
		TbWfmProcessinstance processInst=workFlowMapper.findPro(map);
		if(null != processInst && StringUtils.isNotEmpty(processInst.getProductId())){//能够获取产品Id时
			TbConLoanChange loanChange=workFlowMapper.queryLoanChange(map);
			
			if(loanChange != null){
				TbLoanSummary loanSummary=loanSummaryMapper.selectByPrimaryKey(loanChange.getSummaryId());//先调用其他模块方法
				//调用singleDealAccount
				//CRED_RECOUNT 调用存储过程 更新授信额度 跟合同失效那里是一样的
			}
			
			
			
		}
		
		
		
	}
	
	/**
	 * 流程结束时调用 taskId taskId由我的工作列表点击执行时带入页面
	 * taskEnd 流程结束
	
	 * <p>Title: taskEnd</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public String taskEnd(Map map){
		map.put("taskId", "327504");
//		String taskEnd=workFlowFeignClient.taskEnd(FlowUtil.openTaskProcess(map));
		return "";
	}

	/**
	 * 流程撤销
	
	 * <p>Title: abortProcess</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public String abortProcess(Map map) throws Exception{
		
		//删除 tb_wfm_workiteminstance
		workFlowMapper.deleteProcessinstance((String)map.get("processInstId"));
		//删除tb_wfm_processinstance
		workFlowMapper.deleteWorkiteminstance((String)map.get("processInstId"));
		//回调各个模块的撤销功能
//		FlowUtil.callbankAfterAbortMetchod(processInstId, processDefName, activityDefId, templateVersion);
		callbankAfterAbortMetchod(map);
		//调用流程管理中心
		
		return "";
	}
	
	/**
	 * 流程撤销各个模块回调函数
		具体调用类写到各个模块里面
	 * <p>Title: callbankAfterAbortMetchod</p>  
	
	 * <p>Description: </p>  
	
	 * @param processInstId 流程实例ID
	 * @param processDefName 流程模板名称
	 * @param activityDefId 岗位ID
	 * @param templateVersion 版本号
	 * @throws Exception
	 */
	public void callbankAfterAbortMetchod(Map map) throws Exception {

		TbWfmWorkitemmapping itemmapping = getWorkItempMappingByVersion((String)map.get("processDefName"), (String)map.get("templateVersion"), (String)map.get("activityDefId"));
		String className = itemmapping.getDoUrl();//获取doUrl
		if (null != className && !"".equals(className)) {

			IBIZProcess bizpro = (IBIZProcess) Thread.currentThread().getContextClassLoader().loadClass(className).newInstance();
			bizpro.executeAfterAbort((String)map.get("processInstId"), null);
		}
	}
	
	/**
	 * 
	
	 * <p>Title: getWorkItempMappingByVersion</p>  
	
	 * <p>Description: </p>  
	
	 * @param processDefName 流程模板名称
	 * @param version  流程版本号
	 * @param activityDefId  岗位ID
	 * @return
	 */
	public TbWfmWorkitemmapping getWorkItempMappingByVersion(String processDefName,String version,String activityDefId){
		Map map=new HashMap();
		map.put("processDefName", processDefName);
		map.put("version", version);
		map.put("activityDefId", activityDefId);
		List processmappingList=workFlowMapper.queryProcessmapping(map);
		TbWfmProcessmapping processmapping;
		String processMappingId=null;
		if(null != processmappingList && processmappingList.size() > 0){
			processmapping=(TbWfmProcessmapping)processmappingList.get(0);
			processMappingId=processmapping.getProcessMappingId();
		}
		
//		wiTemplate.set("tbWfmProcessmapping/processMappingId", template.get("processMappingId"));
//		wiTemplate.set("activityDefId", activityDefId);
		
		map.put("processMappingId",processMappingId);
		TbWfmWorkitemmapping itemmapping=workFlowMapper.queryItemmapping(map);
		
		return itemmapping;
		
	}
	
}
