package com.cdgit.loan.csm.common;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cdgit.loan.securitymanagement.bean.GrtDeposit;

/**
 * bean工具类
 * @author wuyong
 * @date 2019.1.16
 *
 */
public class BeanUtils {
	/**
	 * 提取bean的属性和值返回Map对象
	 * @param objs
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> combineField(Object... objs) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (Object obj : objs) {
			Class<? extends Object> clazz = obj.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				Object value =null;
				if(fields[i].getGenericType().toString().equals("class java.util.Date")){
					if(fields[i].get(obj)!=null){
						value = format.format((Date)(fields[i].get(obj)));
					}
				} else{
					//获取的值
					if(fields[i].get(obj)!=null){
						value = fields[i].get(obj).toString();
					}
				}
				//获取属性
				String key = fields[i].getName();
				//存单currencyCd与抵质押品currencyCd属性重复情况
				if((obj instanceof GrtDeposit) && key.equals("currencyCd")){
					map.put("drCurrency", value);
					continue;
				}
				map.put(key, value);
			}
		}
		return map;
	}
	/***
	 * 下划线命名转为驼峰命名
	 * 
	 * @param para
	 *        下划线命名的字符串
	 */
    public static String UnderlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(String s:a){
            if(result.length()==0){
                result.append(s.toLowerCase());
            }else{
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
}
