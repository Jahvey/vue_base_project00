package com.cdgit.loan.common.util;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class FlowUtil {

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
	
}
