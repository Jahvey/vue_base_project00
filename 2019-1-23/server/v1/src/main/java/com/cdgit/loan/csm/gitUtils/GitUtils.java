package com.cdgit.loan.csm.gitUtils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GitUtils {
	
	public static String DATE_FORMAT = "yyyy-MM-dd";
	public static String TIME_FORMAT = "HH:mm:ss ";

	private static final int TIME_CACHE = 20;

	public static Calendar previousDate = null; // 日期缓存

	private static long previousDateGet = -1;// 上次设置日期缓存的时间

	private static Object timeLock = new Object();
	
	@Autowired
	CsmGitUtilsMapper csmGitUtilsMapper;
	
	
	//初始化营业日期缓存
	public  java.sql.Timestamp getBusiTimestamp() {

		Date previousDate = csmGitUtilsMapper.queryInitBusiDate();
		Calendar now = Calendar.getInstance();
		if (null == previousDate) {// 如果配置表没有信息，那么把当前系统时间赋值进去
			new Timestamp(now.getTimeInMillis());
		}

		return new Timestamp(previousDate.getTime());
	}
	
	
	
	//获取业务时间
	public  Date getBusiDate() {
		return csmGitUtilsMapper.queryInitBusiDate();
	}
	
	
	
	
	public static boolean contain(Object key, Object[] keys) {
		if (keys == null || keys.length == 0) {
			return false;
		}
		boolean isNull = key == null;
		boolean isStr = !isNull && key instanceof String;
		for (int i = 0; i < keys.length; i++) {
			if (key == keys[i]) {
				return true;
			} else if ((keys[i] == null) != isNull) {
				// 空与非空不需要比较，都是空的下直接返回
				continue;
			} else if (isNull) {
				return true;
			} else if (key.equals(keys[i])) {
				return true;
			} else if (isStr && key.equals(keys[i].toString())) {
				return true;
			}
		}
		return false;
	}

}
