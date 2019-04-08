package com.cdgit.loan.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cdgit.loan.workflow.bean.TbWfmProcessmapping;
import com.cdgit.loan.workflow.bean.TbWfmWorkitemmapping;
import com.cdgit.loan.workflow.mapper.WorkFlowMapper;


public class FlowUtil {

	@Autowired
	WorkFlowMapper workFlowMapper;
	
	/**
	 * 传入参数生成创建流程请求json字符串
	  暂时定为传入Map 参数
	 * <p>Title: generatorProcess</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String generatorStartProcess(Map map){
		
		String requestBodyContent=JSONObject.toJSONString(map);
		
//		String str1 = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue);//把值为null的序列化出来
//		String str2 = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty); // 把值为null的序列化为""
		String starPronInst1="{\"RequestBody\":"+requestBodyContent+"}";
		
		return starPronInst1;
	}
	
	/**
	 * 生成获取下一岗位流程请求报文
	  opentask
	 * <p>Title: getNextPosition</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public static String getNextPositionProcess(Map map){
		
//		String str = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
		
		String requestBodyContent=JSONObject.toJSONString(map);
		
		String getNextPositionProcess="{\"RequestBody\":"+requestBodyContent+"}";
		
		return getNextPositionProcess;
	}
	
	/**
	 * 生成获取下一岗位流程请求报文
	
	 * <p>Title: getNextPosition</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public static String openTaskProcess(Map map){
		
//		String str = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
		
		String requestBodyContent=JSONObject.toJSONString(map);
		
		String openTaskProcess="{\"RequestBody\":"+requestBodyContent+"}";
		
		return openTaskProcess;
	}
	
	/**
	 * 生成内层variables
	
	 * <p>Title: inlineProcess</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String getInlineProcessMessage(Map map){
		String requestBodyContent=JSONObject.toJSONString(map);
		return requestBodyContent;
	}
	
	/**
	 * 生成流程请求报文
	   2018-12-17
	 * <p>Title: inlineProcess</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String generatorProcessMessage(Map map){
//		String str = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
		
		String requestBodyContent=JSONObject.toJSONString(map);
		
		String generatorProcessMessage="{\"RequestBody\":"+requestBodyContent+"}";
		
		return generatorProcessMessage;
	}
	
	/**
	 * 
	回调流程结束前的方法
	 * <p>Title: callbankBeforeTerminateMetchod</p>  
	
	 * <p>Description: </p>  
	
	 * @param className
	 * @param processInstId
	 * @param workitem
	 * @throws Exception
	 */
	public static void callbankBeforeTerminateMetchod(String className, String processInstId, Map workitem) throws Exception {

		if (null != className && !"".equals(className)) {

			IBIZProcess bizpro = (IBIZProcess) Thread.currentThread().getContextClassLoader().loadClass(className).newInstance();
			bizpro.executeBeforeTerminate(processInstId, workitem);
		}
	}
	
	/**
	 * 回调流程退回前的方法
	
	 * <p>Title: callbankBeforeUntreadMetchod</p>  
	
	 * <p>Description: </p>  
	
	 * @param className
	 * @param processInstId
	 * @param workitem
	 * @throws Exception
	 */
	public static void callbankBeforeUntreadMetchod(String className, String processInstId, Map workitem) throws Exception {

		if (null != className && !"".equals(className)) {

			IBIZProcess bizpro = (IBIZProcess) Thread.currentThread().getContextClassLoader().loadClass(className).newInstance();
			bizpro.executeBeforeUntread(processInstId, workitem);
		}
	}
	
	/**
	 * 
	回调提交流程前的方法
	 * <p>Title: callbankBeforeSubmitMetchod</p>  
	
	 * <p>Description: </p>  
	
	 * @param className
	 * @param processInstId
	 * @param workitem
	 * @throws Exception
	 */
	public static void callbankBeforeSubmitMetchod(String className, String processInstId, Map workitem) throws Exception {

		if (null != className && !"".equals(className)) {

			IBIZProcess bizpro = (IBIZProcess) Thread.currentThread().getContextClassLoader().loadClass(className).newInstance();
			bizpro.executeBeforeSubmit(processInstId, workitem);
		}
	}
	
	/**
	 * 
	回调创建流程后的方法
	 * <p>Title: callbankAfterCreateMetchod</p>  
	
	 * <p>Description: </p>  
	
	 * @param processInstId
	 * @param processDefName
	 * @throws Exception
	 */
	public  void callbankAfterCreateMetchod(long processInstId, String processDefName,String activityDefId) throws Exception {

//		// 获取流程实例ID
//		WFActivityInst ait = ActivityInstManagerService.getCurrentActivityInstByProcessInstID(processInstId);
//		String activityDefId = ait.getActivityDefID();
		// 获取流程节点配置信息
//		DataObject data = WorkItemMappingDAO.getWorkItemMapping(processDefName, activityDefId);
//		String className = data.getString("doUrl");
		TbWfmWorkitemmapping itemmapping=getWorkItemMapping(processDefName,activityDefId);
		String className = itemmapping.getDoUrl();//获取doUrl
		if (null != className && !"".equals(className)) {

			IBIZProcess bizpro = (IBIZProcess) Thread.currentThread().getContextClassLoader().loadClass(className).newInstance();
			bizpro.executeAfterCreateFlow(String.valueOf(processInstId), null);
		}

	}
	
	/**
	 * 流程撤销各个模块回调函数
		具体调用类写到各个模块里面
	 * <p>Title: callbankAfterAbortMetchod</p>  
	
	 * <p>Description: </p>  
	
	 * @param processInstId
	 * @param processDefName
	 * @param activityDefId
	 * @param templateVersion
	 * @throws Exception
	 */
	public void callbankAfterAbortMetchod(String processInstId, String processDefName, String activityDefId, String templateVersion) throws Exception {

		TbWfmWorkitemmapping itemmapping = getWorkItempMappingByVersion(processDefName, templateVersion, activityDefId);
		String className = itemmapping.getDoUrl();//获取doUrl
		if (null != className && !"".equals(className)) {

			IBIZProcess bizpro = (IBIZProcess) Thread.currentThread().getContextClassLoader().loadClass(className).newInstance();
			bizpro.executeAfterAbort(processInstId, null);
		}
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
	
	 * <p>Title: getWorkItemMapping</p>  
	
	 * <p>Description: </p>  
	
	 * @param processDefName
	 * @param activityDefId
	 * @return
	 */
	public  TbWfmWorkitemmapping getWorkItemMapping(String processDefName,String activityDefId){
		Map map=new HashMap();
		map.put("processDefName", processDefName);
		map.put("versionStatus", "1");
		map.put("activityDefId", activityDefId);
		List processmappingList=workFlowMapper.queryProcessmapping(map);
		TbWfmProcessmapping processmapping=null;
		if(null != processmappingList && processmappingList.size() > 0){
			processmapping=(TbWfmProcessmapping)processmappingList.get(0);
		}
		
		map.put("processMappingId", processmapping);
		
		TbWfmWorkitemmapping itemmapping=workFlowMapper.queryItemmapping(map);
		
		return itemmapping;
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
		TbWfmProcessmapping processmapping=null;
		if(null != processmappingList && processmappingList.size() > 0){
			processmapping=(TbWfmProcessmapping)processmappingList.get(0);
		}
		
		map.put("processMappingId", processmapping);
		
		TbWfmWorkitemmapping itemmapping=workFlowMapper.queryItemmapping(map);
		
		return itemmapping;
		
	}
	
}
