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
		String legorg = "9999";   //TODO 默认写死是绵阳商行的法人代表   ORG_MCCB = "9999";
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
	
	
	/**
	 * 按期限单位计算起始日期加到期限，得到到期日期
	 * 
	 * @param qxdw
	 *            期限单位（Y 年,J 季,M 月,D 天）
	 * @param qx
	 *            期限
	 * @param rq
	 *            起始日期 yyyy-mm-dd
	 * @return 到期日期 yyyy-mm-dd
	 * @throws Exception
	 */
	//"日期函数加法，返回日期"
	public  String addDate(String qxdw, int qx, String rq) throws Exception{
		Calendar cl = Calendar.getInstance();
		cl.set(Integer.parseInt(rq.substring(0, 4)), (Integer.parseInt(rq.substring(5, 7)) - 1), Integer.parseInt(rq.substring(8, 10)));
		if ("Y".equals(qxdw)) {
			cl.add(Calendar.YEAR, qx);
		} else if ("J".equals(qxdw)) {
			cl.add(Calendar.MONTH, qx * 3);
		} else if ("M".equals(qxdw)) {
			cl.add(Calendar.MONTH, qx);
		} else if ("D".equals(qxdw)) {
			cl.add(Calendar.DAY_OF_MONTH, qx);
		} else {
			return "";
		}
		return cl.get(Calendar.YEAR) + "-" + (cl.get(Calendar.MONTH) < 9 ? "0" : "") + (cl.get(Calendar.MONTH) + 1) + "-" + (cl.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "") + cl.get(Calendar.DAY_OF_MONTH);
	}
	
	
	
	
	
	/**
	 * 按期限单位计算两日期间期限
	 * 
	 * @param qxdw
	 *            期限单位（Y 年,M 月,D 天）
	 * @param qsrq
	 *            起始日期 yyyy-mm-dd
	 * @param dqrq
	 *            到期日期 yyyy-mm-dd
	 * @return 期限
	 * @throws Exception
	 */
	//"两日期函数计算期限，返回期限"
	public  int retDateTerm(String qxdw, String qsrq, String dqrq) throws Exception {
		int a = 0;
		if ("Y".equals(qxdw)) {
			a = accountDateYear(qsrq, dqrq);
		} else if ("M".equals(qxdw)) {
			a = accountDateMoth(qsrq, dqrq);
		} else if ("D".equals(qxdw)) {
			a = (int) getDistDates(qsrq, dqrq);
		}
		return a;
	}

	/**
	 * 两日期间计算天数
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public  long getDistDates(String start, String end) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date startDate = sdf.parse(start);
		java.util.Date endDate = sdf.parse(end);
		return getDistDates(startDate, endDate);
	}

	/**
	 * 两日期间计算天数
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public  long getDistDates(java.util.Date startDate, java.util.Date endDate) {
		long totalDate = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeend = calendar.getTimeInMillis();
		totalDate = Math.abs((timeend - timestart)) / (1000 * 60 * 60 * 24);
		return totalDate;
	}

	/**
	 * 日期差值计算 月
	 * 
	 * @param qsrq
	 *            起始日期 YYYY-MM-DD
	 * @param bjrq
	 *            到期日期 YYYY-MM-DD
	 * @return
	 * @throws Exception
	 */
	public  int accountDateMoth(String qsrq, String bjrq) throws Exception {

		String[] s1 = qsrq.split("-");
		String[] s2 = bjrq.split("-");
		int year1 = Integer.parseInt(s1[0]);
		int year2 = Integer.parseInt(s2[0]);
		if (year2 - year1 < 0) {
			throw new Exception("输入的终止日期年份小于起始日期的年份");
		}
		int a = 12 * (year2 - year1);
		int month1 = Integer.parseInt(s1[1]);
		int month2 = Integer.parseInt(s2[1]);
		int b = month2 - month1;
		int day1 = Integer.parseInt(s1[2]);
		int day2 = Integer.parseInt(s2[2]);
		int c = a + b;
		if (day2 - day1 > 0) {
			c = a + b + 1;
		}
		return c;

	}

	/**
	 * 日期差值计算 年
	 * 
	 * @param qsrq
	 *            起始日期 YYYY-MM-DD
	 * @param bjrq
	 *            到期日期 YYYY-MM-DD
	 * @return
	 * @throws Exception
	 */
	public  int accountDateYear(String qsrq, String bjrq) throws Exception {
		double a = accountDateMoth(qsrq, bjrq);
		double c = a / 12;
		return (int) Math.ceil(c);
	}
	
	
	
	

}
