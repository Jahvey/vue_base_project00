/**
 * 
 */
package com.cdgit.loan.csm.pub;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class DateUtil {
	
	private  final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
	
	private  final Object object = new Object();
	
	/** 
	 * 获取SimpleDateFormat 
	 * @param pattern 日期格式 
	 * @return SimpleDateFormat对象 
	 * @throws RuntimeException 异常：非法日期格式 
	 */
	private  SimpleDateFormat getDateFormat(String pattern) throws RuntimeException {
		SimpleDateFormat dateFormat = threadLocal.get();
		if (dateFormat == null) {
			synchronized (object) {
				if (dateFormat == null) {
					dateFormat = new SimpleDateFormat(pattern);
					dateFormat.setLenient(false);
					threadLocal.set(dateFormat);
				}
			}
		}
		dateFormat.applyPattern(pattern);
		return dateFormat;
	}
	
	
	
	/** 
	 * 将日期字符串转化为日期。失败返回null。 
	 * @param date 日期字符串 
	 * @param pattern 日期格式 
	 * @return 日期 
	 */
	
	public  Date StringToDate(String date, String pattern) {
		Date myDate = null;
		if (date != null) {
			try {
				myDate = getDateFormat(pattern).parse(date);
			} catch (Exception e) {
				throw new RuntimeException("[StringToDate]将日期字符串转化为日期失败"+e);
			}
		}
		return myDate;
	}
	
	
    /**
     * 使用用户格式格式化日期
     * @param date
     * @param pattern
     * @return
     * @author LYF
     * @date 2017年7月14日 下午4:34:16
     */
    public  String format(Date date, String pattern) {
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}
}
