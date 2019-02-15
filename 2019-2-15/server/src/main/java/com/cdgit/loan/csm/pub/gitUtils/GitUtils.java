package com.cdgit.loan.csm.pub.gitUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

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
	
	
	public  String getLegorg() {
		String legorg = "";
		// 获取session里的机构级别串
//		IUserObject user = CommonUtil.getIUserObject();
//		Map<String, Object> attmap = user.getAttributes();
//		legorg = (String) attmap.get("legorg");
		return legorg;
	}
	
	
	
	
	//获取当前时间
	public  java.util.Date getCurrDate() {
		return Calendar.getInstance().getTime();
	}
	
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
	public   Date getBusiDate() {
		Date previousDate = csmGitUtilsMapper.queryInitBusiDate();
		if(previousDate==null){// 如果配置表没有信息，那么把当前系统时间赋值进去
			Date currentDate = Calendar.getInstance().getTime();
			return currentDate;
		}
		return previousDate;
	}
	
	
	
	//"获取业务日期字符串yyyy-MM-dd"
	public  String getBusiDateStr() {
		return new SimpleDateFormat("yyyy-MM-dd").format(getBusiDate());
	}
	
	//查询序列号
	public  String getSeqNo(String sqeName, String orgNum) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("seqname", "SEQ_" + sqeName + "_NO.NEXTVAL");
		String sequence = csmGitUtilsMapper.querySeqByName(map);	//返回查询到的序列号
		StringBuilder sb = new StringBuilder(sqeName + orgNum);
		sb.append(getBusiDateStr().replaceAll("-", ""));
		StringBuilder seqno = new StringBuilder(sequence);
		while (seqno.length() < 6) {
			seqno.insert(0, '0');		//把0插入到字符串初始位置
		}
		if (seqno.length() > 6) {
			seqno.substring(seqno.length() - 6);//字符长度-6的位置开始截取直到最后
		}
		sb.append(seqno);
		return sb.toString();
	}
	
	
	
	
	//获取当前机构编号
	public  String getCurrentOrgCd() {
		//String id = DataContextUtil.getString("m:userObject/attributes/orgcode");
		String id="0700";
		return id;
	}
	
	
	//"获取当前机构ID"
	public  String getCurrentOrgId() {
		//String id = DataContextUtil.getString("m:userObject/userOrgId");
		String id ="200555";
		return id;
	}

	//"获取当前用户ID"
	public  String getCurrentUserId() {
		//String id = DataContextUtil.getString("m:userObject/userId");
		String id ="200555";
		return id;
	}
	
	
	public  boolean contain(Object key, Object[] keys) {
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
