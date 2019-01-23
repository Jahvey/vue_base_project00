package com.cdgit.loan.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapUtils {
	public static <E> Map<String, E> strToMap(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, E> retMap = new HashMap<String, E>();
		try {
			retMap = mapper.readValue(json, retMap.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMap;
	}
	
	public static <E> List<E> strToList(String json) {
		String[] values = json.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "").split(",");
		StringBuffer appendVal = new StringBuffer("[");
		int maxNo = values.length - 1;
		int startNo = 0;
		for(String tempVal:values) {
			if (tempVal.startsWith("{") && tempVal.endsWith("}")) {
				tempVal = tempVal.replaceAll("\\{", "\\{\"").replaceAll("=", "\":\"").replaceAll(",", "\",\"").replaceAll("\\}", "\"}");
			}else {
				tempVal = "\"" + tempVal + "\"";
			}
			if(startNo == maxNo) {
				appendVal.append(tempVal + "]");
			}else {
				appendVal.append(tempVal + ",");
			}
			startNo++;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		List<E> retList = new ArrayList<E>();
		try {
			retList = mapper.readValue(appendVal.toString(), retList.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retList;		
	}
	
}
