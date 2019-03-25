package com.cdgit.loan.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import com.cdgit.loan.common.bean.DateStyle;
import com.cdgit.loan.common.bean.Week;
import com.google.common.collect.Lists;

/**
 * 时间工具类
 * 
 *
 */

public class DateUtil extends DateUtils {

	private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();

	private static final Object object = new Object();

	/** 
	 * 获取SimpleDateFormat 
	 * @param pattern 日期格式 
	 * @return SimpleDateFormat对象 
	 * @throws RuntimeException 异常：非法日期格式 
	 */
	private static SimpleDateFormat getDateFormat(String pattern) throws RuntimeException {
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
	 * 获取日期中的某数值。如获取月份 
	 * @param date 日期 
	 * @param dateType 日期格式 
	 * @return 数值 
	 */
	private static int getInteger(Date date, int dateType) {
		int num = 0;
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
			num = calendar.get(dateType);
		}
		return num;
	}

	/** 
	 * 增加日期中某类型的某数值。如增加日期 
	 * @param date 日期字符串 
	 * @param dateType 类型 
	 * @param amount 数值 
	 * @return 计算后日期字符串 
	 */
	private static String addInteger(String date, int dateType, int amount) {
		String dateString = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = StringToDate(date, dateStyle);
			myDate = addInteger(myDate, dateType, amount);
			dateString = DateToString(myDate, dateStyle);
		}
		return dateString;
	}

	/** 
	 * 增加日期中某类型的某数值。如增加日期 
	 * @param date 日期 
	 * @param dateType 类型 
	 * @param amount 数值 
	 * @return 计算后日期 
	 */
	private static Date addInteger(Date date, int dateType, int amount) {
		Date myDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(dateType, amount);
			myDate = calendar.getTime();
		}
		return myDate;
	}

	/** 
	 * 获取精确的日期 
	 * @param timestamps 时间long集合 
	 * @return 日期 
	 */
	private static Date getAccurateDate(List<Long> timestamps) {
		Date date = null;
		long timestamp = 0;
		Map<Long, long[]> map = new HashMap<Long, long[]>();
		List<Long> absoluteValues = new ArrayList<Long>();

		if (timestamps != null && timestamps.size() > 0) {
			if (timestamps.size() > 1) {
				for (int i = 0; i < timestamps.size(); i++) {
					for (int j = i + 1; j < timestamps.size(); j++) {
						long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));
						absoluteValues.add(absoluteValue);
						long[] timestampTmp = { timestamps.get(i), timestamps.get(j) };
						map.put(absoluteValue, timestampTmp);
					}
				}

				// 有可能有相等的情况。如2012-11和2012-11-01。时间戳是相等的。此时minAbsoluteValue为0
				// 因此不能将minAbsoluteValue取默认值0
				long minAbsoluteValue = -1;
				if (!absoluteValues.isEmpty()) {
					minAbsoluteValue = absoluteValues.get(0);
					for (int i = 1; i < absoluteValues.size(); i++) {
						if (minAbsoluteValue > absoluteValues.get(i)) {
							minAbsoluteValue = absoluteValues.get(i);
						}
					}
				}

				if (minAbsoluteValue != -1) {
					long[] timestampsLastTmp = map.get(minAbsoluteValue);

					if (timestampsLastTmp.length == 2) {
						long dateOne = timestampsLastTmp[0];
						long dateTwo = timestampsLastTmp[1];
						timestamp = Math.abs(dateOne) < Math.abs(dateTwo) ? dateOne : dateTwo;
					}
				}
			} else {
				timestamp = timestamps.get(0);
			}
		}

		if (timestamp != 0) {
			date = new Date(timestamp);
		}
		return date;
	}

	/** 
	 * 判断字符串是否为日期字符串 
	 * @param date 日期字符串 
	 * @return true or false 
	 */
	public static boolean isDate(String date) {
		boolean isDate = false;
		if (date != null) {
			if (getDateStyle(date) != null) {
				isDate = true;
			}
		}
		return isDate;
	}

	/** 
	 * 获取日期字符串的日期风格。失敗返回null。 
	 * @param date 日期字符串 
	 * @return 日期风格 
	 */
	public static DateStyle getDateStyle(String date) {
		DateStyle dateStyle = null;
		Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();
		List<Long> timestamps = new ArrayList<Long>();
		for (DateStyle style : DateStyle.values()) {
			if (style.isShowOnly()) {
				continue;
			}
			Date dateTmp = null;
			if (date != null) {
				try {
					ParsePosition pos = new ParsePosition(0);
					dateTmp = getDateFormat(style.getValue()).parse(date, pos);
					if (pos.getIndex() != date.length()) {
						dateTmp = null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (dateTmp != null) {
				timestamps.add(dateTmp.getTime());
				map.put(dateTmp.getTime(), style);
			}
		}
		Date accurateDate = getAccurateDate(timestamps);
		if (accurateDate != null) {
			dateStyle = map.get(accurateDate.getTime());
		} else {
			System.out.println("【" + date + "】日期格式非法！");
		}
		return dateStyle;
	}

	/** 
	 * 将日期字符串转化为日期。失败返回null。 
	 * @param date 日期字符串 
	 * @return 日期 
	 */
	public static Date StringToDate(String date) {
		DateStyle dateStyle = getDateStyle(date);
		return StringToDate(date, dateStyle);
	}

	/** 
	 * 将日期字符串转化为日期。失败返回null。 
	 * @param date 日期字符串 
	 * @param pattern 日期格式 
	 * @return 日期 
	 */
	public static Date StringToDate(String date, String pattern) {
		Date myDate = null;
		if (date != null) {
			try {
				myDate = getDateFormat(pattern).parse(date);
			} catch (Exception e) {
			}
		}
		return myDate;
	}

	/** 
	 * 将日期字符串转化为日期。失败返回null。 
	 * @param date 日期字符串 
	 * @param dateStyle 日期风格 
	 * @return 日期 
	 */
	public static Date StringToDate(String date, DateStyle dateStyle) {
		Date myDate = null;
		if (dateStyle != null) {
			myDate = StringToDate(date, dateStyle.getValue());
		}
		return myDate;
	}

	/** 
	 * 将日期转化为日期字符串。失败返回null。 
	 * @param date 日期 
	 * @param pattern 日期格式 
	 * @return 日期字符串 
	 */
	public static String DateToString(Date date, String pattern) {
		String dateString = null;
		if (date != null) {
			try {
				dateString = getDateFormat(pattern).format(date);
			} catch (Exception e) {
			}
		}
		return dateString;
	}

	/** 
	 * 将日期转化为日期字符串。失败返回null。 
	 * @param date 日期 
	 * @param dateStyle 日期风格 
	 * @return 日期字符串 
	 */
	public static String DateToString(Date date, DateStyle dateStyle) {
		String dateString = null;
		if (dateStyle != null) {
			dateString = DateToString(date, dateStyle.getValue());
		}
		return dateString;
	}

	/** 
	 * 将日期字符串转化为另一日期字符串。失败返回null。 
	 * @param date 旧日期字符串 
	 * @param newPattern 新日期格式 
	 * @return 新日期字符串 
	 */
	public static String StringToString(String date, String newPattern) {
		DateStyle oldDateStyle = getDateStyle(date);
		return StringToString(date, oldDateStyle, newPattern);
	}

	/** 
	 * 将日期字符串转化为另一日期字符串。失败返回null。 
	 * @param date 旧日期字符串 
	 * @param newDateStyle 新日期风格 
	 * @return 新日期字符串 
	 */
	public static String StringToString(String date, DateStyle newDateStyle) {
		DateStyle oldDateStyle = getDateStyle(date);
		return StringToString(date, oldDateStyle, newDateStyle);
	}

	/** 
	 * 将日期字符串转化为另一日期字符串。失败返回null。 
	 * @param date 旧日期字符串 
	 * @param olddPattern 旧日期格式 
	 * @param newPattern 新日期格式 
	 * @return 新日期字符串 
	 */
	public static String StringToString(String date, String olddPattern, String newPattern) {
		return DateToString(StringToDate(date, olddPattern), newPattern);
	}

	/** 
	 * 将日期字符串转化为另一日期字符串。失败返回null。 
	 * @param date 旧日期字符串 
	 * @param olddDteStyle 旧日期风格 
	 * @param newParttern 新日期格式 
	 * @return 新日期字符串 
	 */
	public static String StringToString(String date, DateStyle olddDteStyle, String newParttern) {
		String dateString = null;
		if (olddDteStyle != null) {
			dateString = StringToString(date, olddDteStyle.getValue(), newParttern);
		}
		return dateString;
	}

	/** 
	 * 将日期字符串转化为另一日期字符串。失败返回null。 
	 * @param date 旧日期字符串 
	 * @param olddPattern 旧日期格式 
	 * @param newDateStyle 新日期风格 
	 * @return 新日期字符串 
	 */
	public static String StringToString(String date, String olddPattern, DateStyle newDateStyle) {
		String dateString = null;
		if (newDateStyle != null) {
			dateString = StringToString(date, olddPattern, newDateStyle.getValue());
		}
		return dateString;
	}

	/** 
	 * 将日期字符串转化为另一日期字符串。失败返回null。 
	 * @param date 旧日期字符串 
	 * @param olddDteStyle 旧日期风格 
	 * @param newDateStyle 新日期风格 
	 * @return 新日期字符串 
	 */
	public static String StringToString(String date, DateStyle olddDteStyle, DateStyle newDateStyle) {
		String dateString = null;
		if (olddDteStyle != null && newDateStyle != null) {
			dateString = StringToString(date, olddDteStyle.getValue(), newDateStyle.getValue());
		}
		return dateString;
	}

	/** 
	 * 增加日期的年份。失败返回null。 
	 * @param date 日期 
	 * @param yearAmount 增加数量。可为负数 
	 * @return 增加年份后的日期字符串 
	 */
	public static String addYear(String date, int yearAmount) {
		return addInteger(date, Calendar.YEAR, yearAmount);
	}

	/** 
	 * 增加日期的年份。失败返回null。 
	 * @param date 日期 
	 * @param yearAmount 增加数量。可为负数 
	 * @return 增加年份后的日期 
	 */
	public static Date addYear(Date date, int yearAmount) {
		return addInteger(date, Calendar.YEAR, yearAmount);
	}

	/** 
	 * 增加日期的月份。失败返回null。 
	 * @param date 日期 
	 * @param monthAmount 增加数量。可为负数 
	 * @return 增加月份后的日期字符串 
	 */
	public static String addMonth(String date, int monthAmount) {
		return addInteger(date, Calendar.MONTH, monthAmount);
	}

	/** 
	 * 增加日期的月份。失败返回null。 
	 * @param date 日期 
	 * @param monthAmount 增加数量。可为负数 
	 * @return 增加月份后的日期 
	 */
	public static Date addMonth(Date date, int monthAmount) {
		return addInteger(date, Calendar.MONTH, monthAmount);
	}

	/** 
	 * 增加日期的天数。失败返回null。 
	 * @param date 日期字符串 
	 * @param dayAmount 增加数量。可为负数 
	 * @return 增加天数后的日期字符串 
	 */
	public static String addDay(String date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}

	/** 
	 * 增加日期的天数。失败返回null。 
	 * @param date 日期 
	 * @param dayAmount 增加数量。可为负数 
	 * @return 增加天数后的日期 
	 */
	public static Date addDay(Date date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}

	/** 
	 * 增加日期的小时。失败返回null。 
	 * @param date 日期字符串 
	 * @param hourAmount 增加数量。可为负数 
	 * @return 增加小时后的日期字符串 
	 */
	public static String addHour(String date, int hourAmount) {
		return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
	}

	/** 
	 * 增加日期的小时。失败返回null。 
	 * @param date 日期 
	 * @param hourAmount 增加数量。可为负数 
	 * @return 增加小时后的日期 
	 */
	public static Date addHour(Date date, int hourAmount) {
		return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
	}

	/** 
	 * 增加日期的分钟。失败返回null。 
	 * @param date 日期字符串 
	 * @param minuteAmount 增加数量。可为负数 
	 * @return 增加分钟后的日期字符串 
	 */
	public static String addMinute(String date, int minuteAmount) {
		return addInteger(date, Calendar.MINUTE, minuteAmount);
	}

	/** 
	 * 增加日期的分钟。失败返回null。 
	 * @param date 日期 
	 * @param dayAmount 增加数量。可为负数 
	 * @return 增加分钟后的日期 
	 */
	public static Date addMinute(Date date, int minuteAmount) {
		return addInteger(date, Calendar.MINUTE, minuteAmount);
	}

	/** 
	 * 增加日期的秒钟。失败返回null。 
	 * @param date 日期字符串 
	 * @param dayAmount 增加数量。可为负数 
	 * @return 增加秒钟后的日期字符串 
	 */
	public static String addSecond(String date, int secondAmount) {
		return addInteger(date, Calendar.SECOND, secondAmount);
	}

	/** 
	 * 增加日期的秒钟。失败返回null。 
	 * @param date 日期 
	 * @param dayAmount 增加数量。可为负数 
	 * @return 增加秒钟后的日期 
	 */
	public static Date addSecond(Date date, int secondAmount) {
		return addInteger(date, Calendar.SECOND, secondAmount);
	}

	/** 
	 * 获取日期的年份。失败返回0。 
	 * @param date 日期字符串 
	 * @return 年份 
	 */
	public static int getYear(String date) {
		return getYear(StringToDate(date));
	}

	/** 
	 * 获取日期的年份。失败返回0。 
	 * @param date 日期 
	 * @return 年份 
	 */
	public static int getYear(Date date) {
		return getInteger(date, Calendar.YEAR);
	}

	/** 
	 * 获取日期的月份。失败返回0。 
	 * @param date 日期字符串 
	 * @return 月份 
	 */
	public static int getMonth(String date) {
		return getMonth(StringToDate(date));
	}

	/** 
	 * 获取日期的月份。失败返回0。 
	 * @param date 日期 
	 * @return 月份 
	 */
	public static int getMonth(Date date) {
		return getInteger(date, Calendar.MONTH) + 1;
	}

	/** 
	 * 获取日期的天数。失败返回0。 
	 * @param date 日期字符串 
	 * @return 天 
	 */
	public static int getDay(String date) {
		return getDay(StringToDate(date));
	}

	/** 
	 * 获取日期的天数。失败返回0。 
	 * @param date 日期 
	 * @return 天 
	 */
	public static int getDay(Date date) {
		return getInteger(date, Calendar.DATE);
	}

	/** 
	 * 获取日期的小时。失败返回0。 
	 * @param date 日期字符串 
	 * @return 小时 
	 */
	public static int getHour(String date) {
		return getHour(StringToDate(date));
	}

	/** 
	 * 获取日期的小时。失败返回0。 
	 * @param date 日期 
	 * @return 小时 
	 */
	public static int getHour(Date date) {
		return getInteger(date, Calendar.HOUR_OF_DAY);
	}

	/** 
	 * 获取日期的分钟。失败返回0。 
	 * @param date 日期字符串 
	 * @return 分钟 
	 */
	public static int getMinute(String date) {
		return getMinute(StringToDate(date));
	}

	/** 
	 * 获取日期的分钟。失败返回0。 
	 * @param date 日期 
	 * @return 分钟 
	 */
	public static int getMinute(Date date) {
		return getInteger(date, Calendar.MINUTE);
	}

	/** 
	 * 获取日期的秒钟。失败返回0。 
	 * @param date 日期字符串 
	 * @return 秒钟 
	 */
	public static int getSecond(String date) {
		return getSecond(StringToDate(date));
	}

	/** 
	 * 获取日期的秒钟。失败返回0。 
	 * @param date 日期 
	 * @return 秒钟 
	 */
	public static int getSecond(Date date) {
		return getInteger(date, Calendar.SECOND);
	}

	/** 
	 * 获取当前操作系统日期 。默认yyyy-MM-dd HH:mm:ss格式。失败返回null。 
	 * @return 日期 
	 */
//	public static String getDate() {
//		Date date = Calendar.getInstance().getTime();
//		return DateToString(date, DateStyle.YYYY_MM_DD_HH_MM_SS);
//	}
	
	/** 
	 * 获取工作日期 。yyyy-MM-dd
	 * @return 日期 
	 */
	public static Date getWorkDate() {
		Date date = new Date(GitUtil.getBusiTimestamp().getTime());
		date = StringToDate(getDate(date));
		return date;
	}
	
	/** 
	 * 获取工作日时间。yyyy-MM-dd HH:mm:ss
	 * @return 日期 
	 */
	public static Date getWorkTime() {
		Date date = new Date(GitUtil.getBusiTimestamp().getTime());
		return date;
	}
	
	/** 
	 * 获取当前操作系统日期 。失败返回null。 
	 * @param style 日期风格
	 * @return 日期 
	 */
	public static String getDate(DateStyle style) {
		Date date = Calendar.getInstance().getTime();
		return DateToString(date, style);
	}

	/** 
	 * 获取日期 。默认yyyy-MM-dd格式。失败返回null。 
	 * @param date 日期字符串 
	 * @return 日期 
	 */
//	public static String getDate(String date) {
//		return StringToString(date, DateStyle.YYYY_MM_DD);
//	}

	/** 
	 * 获取日期。默认yyyy-MM-dd格式。失败返回null。 
	 * @param date 日期 
	 * @return 日期 
	 */
	public static String getDate(Date date) {
		return DateToString(date, DateStyle.YYYY_MM_DD);
	}

	/** 
	 * 获取日期的时间。默认HH:mm:ss格式。失败返回null。 
	 * @param date 日期字符串 
	 * @return 时间 
	 */
	public static String getTime(String date) {
		return StringToString(date, DateStyle.HH_MM_SS);
	}

	/** 
	 * 获取日期的时间。默认HH:mm:ss格式。失败返回null。 
	 * @param date 日期 
	 * @return 时间 
	 */
	public static String getTime(Date date) {
		return DateToString(date, DateStyle.HH_MM_SS);
	}

	/** 
	 * 获取日期的星期。失败返回null。 
	 * @param date 日期字符串 
	 * @return 星期 
	 */
	public static Week getWeek(String date) {
		Week week = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = StringToDate(date, dateStyle);
			week = getWeek(myDate);
		}
		return week;
	}

	/** 
	 * 获取日期的星期。失败返回null。 
	 * @param date 日期 
	 * @return 星期 
	 */
	public static Week getWeek(Date date) {
		Week week = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekNumber) {
		case 0:
			week = Week.SUNDAY;
			break;
		case 1:
			week = Week.MONDAY;
			break;
		case 2:
			week = Week.TUESDAY;
			break;
		case 3:
			week = Week.WEDNESDAY;
			break;
		case 4:
			week = Week.THURSDAY;
			break;
		case 5:
			week = Week.FRIDAY;
			break;
		case 6:
			week = Week.SATURDAY;
			break;
		}
		return week;
	}

	/** 
	 * 获取两个日期相差的月数(忽略天)
	 * @param date 日期字符串 
	 * @param otherDate 另一个日期字符串 
	 * @return 相差月数。
	 */
	public static double getIntervalMonths(Date date, Date otherDate) {
		int r = getMonth(date) - getMonth(otherDate) + (getYear(date) - getYear(otherDate)) * 12;
		return Math.abs(r);
	}
	
	/** 
	 * 获取两个日期相差的周数
	 * @param date 日期字符串 
	 * @param otherDate 另一个日期字符串 
	 * @return 相差周数。
	 */
	public static double getIntervalWeeks(Date date, Date otherDate) {
		return getInterval(date, otherDate, "W");
	}

	/** 
	 * 获取两个日期相差的天数 
	 * @param date 日期字符串 
	 * @param otherDate 另一个日期字符串 
	 * @return 相差天数。如果失败则返回-1 
	 */
	public static double getIntervalDays(String date, String otherDate) {
		return getIntervalDays(StringToDate(date), StringToDate(otherDate));
	}

	/** 
	 *  获取两个日期相差的天数 
	 * @param date 日期 
	 * @param otherDate 另一个日期 
	 * @return 相差天数。如果失败则返回-1 
	 */
	public static double getIntervalDays(Date date, Date otherDate) {
		return getInterval(date, otherDate, "D");
	}
	
	/** 
	 *  获取两个日期相差的天数 
	 * @param beginDate 日期 
	 * @param endDate 另一个日期 
	 * @return 相差天数。如果失败则返回-1 
	 * 可能为负数
	 */
	public static double getDiffDays(Date beginDate, Date endDate) {
		return getInterval(beginDate, endDate, "D", false);
	}

	/** 
	 *  获取两个日期相差的小时数 
	 * @param date 日期 
	 * @param otherDate 另一个日期 
	 * @return 相差小时。如果失败则返回-1 
	 */
	public static double getIntervalHours(Date date, Date otherDate) {
		return getInterval(date, otherDate, "H");
	}

	/** 
	 *  获取两个日期相差的分钟数 
	 * @param date 日期 
	 * @param otherDate 另一个日期 
	 * @return 相差分钟。如果失败则返回-1 
	 */
	public static double getIntervalMinutes(Date date, Date otherDate) {
		return getInterval(date, otherDate, "M");
	}

	/** 
	 *  获取两个日期相差的秒数 
	 * @param date 日期 
	 * @param otherDate 另一个日期 
	 * @return 相差秒钟。如果失败则返回-1 
	 */
	public static double getIntervalSeconds(Date date, Date otherDate) {
		return getInterval(date, otherDate, "S");
	}

	/** 
	 * @param date 日期 
	 * @param otherDate 另一个日期 
	 * @param diffType 差额类型：周-W 日-D 时-H 分-M 秒-S
	 * @return 相差数。如果失败则返回-1 
	 */
	public static double getInterval(Date date, Date otherDate, String diffType) {
		return getInterval(date, otherDate, diffType, true);
	}
	
	/** 
	 * @param date 日期 
	 * @param otherDate 另一个日期 
	 * @param diffType 差额类型：周-W 日-D 时-H 分-M 秒-S
	 * @param isAbs 是否绝对值
	 * @return 相差数。如果失败则返回-1 
	 */
	public static double getInterval(Date beginDate, Date endDate, String diffType, boolean isAbs) {
		double num = -1;
		if (beginDate != null && endDate != null) {
			long time = endDate.getTime() - beginDate.getTime();
			if(isAbs){
				time = Math.abs(time);
			}
			double divisor = -1;
			if ("W".equals(diffType.toUpperCase())) {
				divisor = 7 * 24 * 60 * 60 * 1000;
			} else if ("D".equals(diffType.toUpperCase())) {
				divisor = 24 * 60 * 60 * 1000;
			} else if ("H".equals(diffType.toUpperCase())) {
				divisor = 60 * 60 * 1000;
			} else if ("M".equals(diffType.toUpperCase())) {
				divisor = 60 * 1000;
			} else if ("S".equals(diffType.toUpperCase())) {
				divisor = 1000;
			}
			num = time / divisor;
			num = BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
		}
		return num;
	}

	/**
	 * 根据日期取得对应周周一日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMondayOfWeek(Date date) {
		Calendar monday = Calendar.getInstance();
		monday.setTime(date);
		monday.setFirstDayOfWeek(Calendar.MONDAY);
		monday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return monday.getTime();
	}

	/**
	 * 根据日期取得对应周周日日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getSundayOfWeek(Date date) {
		Calendar sunday = Calendar.getInstance();
		sunday.setTime(date);
		sunday.setFirstDayOfWeek(Calendar.MONDAY);
		sunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return sunday.getTime();
	}

	/**
	 * 取得月的剩余天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getRemainDaysOfMonth(Date date) {
		int dayOfMonth = getDaysOfMonth(date);
		int day = getPassDaysOfMonth(date);
		return dayOfMonth - day;
	}

	/**
	 * 取得月已经过的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getPassDaysOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得月天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得月第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 取得月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 取得季度第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfSeason(Date date) {
		return getFirstDateOfMonth(getSeasonDate(date)[0]);
	}

	/**
	 * 取得季度最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfSeason(Date date) {
		return getLastDateOfMonth(getSeasonDate(date)[2]);
	}

	/**
	 * 取得季度天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDaysOfSeason(Date date) {
		int day = 0;
		Date[] seasonDates = getSeasonDate(date);
		for (Date date2 : seasonDates) {
			day += getDaysOfMonth(date2);
		}
		return day;
	}

	/**
	 * 取得季度剩余天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getRemainDaysOfSeason(Date date) {
		return getDaysOfSeason(date) - getPassDaysOfSeason(date);
	}

	/**
	 * 取得季度已过天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getPassDaysOfSeason(Date date) {
		int day = 0;

		Date[] seasonDates = getSeasonDate(date);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);

		if (month == Calendar.JANUARY || month == Calendar.APRIL || month == Calendar.JULY || month == Calendar.OCTOBER) {// 季度第一个月
			day = getPassDaysOfMonth(seasonDates[0]);
		} else if (month == Calendar.FEBRUARY || month == Calendar.MAY || month == Calendar.AUGUST || month == Calendar.NOVEMBER) {// 季度第二个月
			day = getDaysOfMonth(seasonDates[0]) + getPassDaysOfMonth(seasonDates[1]);
		} else if (month == Calendar.MARCH || month == Calendar.JUNE || month == Calendar.SEPTEMBER || month == Calendar.DECEMBER) {// 季度第三个月
			day = getDaysOfMonth(seasonDates[0]) + getDaysOfMonth(seasonDates[1]) + getPassDaysOfMonth(seasonDates[2]);
		}
		return day;
	}

	/**
	 * 取得季度月
	 * 
	 * @param date
	 * @return
	 */
	public static Date[] getSeasonDate(Date date) {
		Date[] season = new Date[3];

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int nSeason = getSeason(date);
		if (nSeason == 1) {// 第一季度
			c.set(Calendar.MONTH, Calendar.JANUARY);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.FEBRUARY);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.MARCH);
			season[2] = c.getTime();
		} else if (nSeason == 2) {// 第二季度
			c.set(Calendar.MONTH, Calendar.APRIL);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.MAY);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.JUNE);
			season[2] = c.getTime();
		} else if (nSeason == 3) {// 第三季度
			c.set(Calendar.MONTH, Calendar.JULY);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.AUGUST);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.SEPTEMBER);
			season[2] = c.getTime();
		} else if (nSeason == 4) {// 第四季度
			c.set(Calendar.MONTH, Calendar.OCTOBER);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.NOVEMBER);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			season[2] = c.getTime();
		}
		return season;
	}

	/**
	 * 
	 * 1 第一季度 2 第二季度 3 第三季度 4 第四季度
	 * 
	 * @param date
	 * @return
	 */
	public static int getSeason(Date date) {

		int season = 0;

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		switch (month) {
		case Calendar.JANUARY:
		case Calendar.FEBRUARY:
		case Calendar.MARCH:
			season = 1;
			break;
		case Calendar.APRIL:
		case Calendar.MAY:
		case Calendar.JUNE:
			season = 2;
			break;
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.SEPTEMBER:
			season = 3;
			break;
		case Calendar.OCTOBER:
		case Calendar.NOVEMBER:
		case Calendar.DECEMBER:
			season = 4;
			break;
		default:
			break;
		}
		return season;
	}
	
	/**
	 * 获得指定
	 * 
	 * @param day
	 *            整数，指定一月中的某天，正数为未来某天时间，负数为过去某天时间
	 * @param hour
	 *            正整数，一天当中的指定小时数
	 * @param minute
	 *            正整数，指定分钟数
	 * @param second
	 *            正整数，指定秒数
	 * @return
	 */
	public static Date getSpecifiedDay(int day, int hour, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取当前月第一天
	 * 
	 * @return
	 */
	public static Date getCurrentMonthFirstDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		// System.out.println("===============first:"+first+" 00:00:00");
		// return first+" 00:00:00";
		return StrToDate(first + " 00:00:00");
	}

	/**
	 * 获取当天的时间
	 * 
	 * @return
	 */
	public static Date getCurrentDay() {
		String str = getDate();
		return StrToDate(str + " 00:00:00");
	}

	/**
	 * 输入增加的天数
	 * 
	 * @param days
	 * @return
	 */
	public static String getDateAddDay(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currtime = formatter.format(cal.getTime());
		return currtime;
	}

	/**
	 * 输入增加的天数
	 * 
	 * @param days
	 * @return
	 */
	public static String getDateAddDay(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currtime = formatter.format(cal.getTime());
		return currtime;
	}

	/**
	 * 输入增加的天数
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date dateAddDay(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param str
	 * @return date
	 */
	public static Date StrToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date StrToDate(String str, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 得到某年某月的第一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getFirstDayOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getMinimum(Calendar.DATE));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取指定年月的最后一天
	 * 
	 * @param year
	 * @param mounth
	 *            月份
	 * @return <Date> foramat:yyyy-MM-dd 23:59:59
	 */
	public static Date getLastDayOfMonth(int year, int mounth) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, mounth);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期的最后时刻
	 * 
	 * @param date
	 * @return <Date> foramat:yyyy-MM-dd 23:59:59
	 */
	public static Date getEndTimeOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取指定年月的最后一天
	 * 
	 * @param year
	 * @param mounth
	 *            月份
	 * @return <Calendar> foramat:yyyy-MM-dd 23:59:59
	 */
	public static Calendar getLastDayCalendarOfMonth(int year, int mounth) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, mounth);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar;
	}

	// public static void main(String[] args) {
	// Date time = getLastDayOfMonth(2017, 0);
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// System.out.println(sdf.format(time));
	// }

	/**
	 * 获取当前月的最后一天（最后一秒）
	 * 
	 * @return
	 */
	public static Date getCurrentMonthLastDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		// System.out.println("===============last:"+last+" 59:59:59");
		return StrToDate(last + " 23:59:59");
	}

	/**
	 * 得到最后一秒的时间(返回字符串)。
	 * 
	 * @return Date
	 */
	public static String dayEnd(Date date) {
		Date date_r = getDayEnd(date);
		if (date_r == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		return sdf.format(date_r);
	}

	/**
	 * 得到最后一秒的时间(返回date)。
	 * 
	 * @return Date
	 */
	public static Date getDayEnd(Date date) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 获取当前时间的年月
	 * 
	 * @return
	 */
	public static String getYearAndMonth() {
		Calendar calendar = Calendar.getInstance();
		// int day = calendar.get(Calendar.DATE); //日
		int month = calendar.get(Calendar.MONTH) + 1;// 月
		int year = calendar.get(Calendar.YEAR); // 年
		return String.valueOf(year) + String.valueOf(month < 10 ? "0" + month : month);
	}

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
			"yyyy.MM.dd HH:mm", "yyyy.MM" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}
	
	/**
	 * 获取前一年年
	 * @return
	 */
	public static String getPrevYear() {
		return String.valueOf(Integer.parseInt(formatDate(new Date(), "yyyy"))-1);
	}
	
	/**
	 * 获取前一年今天
	 * @return
	 */
	public static String getPrevYearDate() {
		return getPrevYear()+"-"+getMonth()+"-"+getDay();
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
	 * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 计算两个日期相差天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static int getDaysOfTwoDate(Date before, Date after) {
		return (int) ((after.getTime() - before.getTime()) / 3600000 / 24 + 1);
	}

	/**
	 * 获取两个日期的月数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static int getMonthOfTwoDate(Date before, Date after) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String start_date = sdf.format(before);
		String end_date = sdf.format(after);
		String startTime[] = start_date.split("-");
		String endTime[] = end_date.split("-");

		int year_start = Integer.parseInt(startTime[0]), month_start = Integer.parseInt(startTime[1]),
				day_start = Integer.parseInt(startTime[2]), year_end = Integer.parseInt(endTime[0]),
				month_end = Integer.parseInt(endTime[1]), day_end = Integer.parseInt(endTime[2]),
				months = (year_end - year_start) * 12 + (month_end - month_start);
		if (day_end - day_start > 25) {
			months = months + 1;
		} else if (day_end - day_start < -25) {
			months = months - 1;
		}
		if (months < 1) {
			months = 1;
		}
		return months;
	}

	/**
	 * 添加时间（分钟）
	 * 
	 * @param minute
	 * @return
	 */
	public static Date DateAddMinute(int minute) {
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.MINUTE, minute);
		return nowTime.getTime();
	}
	
	/**
	 * 添加时间（分钟）
	 * 
	 * @param minute
	 * @return
	 * @throws ParseException 
	 */
	public static String DateAddMinute(String time, int minute) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(time));
		calendar.add(Calendar.MINUTE, minute);
		return sdf.format(calendar.getTime());
	}

	/**
	 * 时间转换
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormatTime(Date date, String format) {
		if (date == null) {
			return "";
		}
		if (format == null) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 讲年月转换为mysql需要的年月(yyyyMM形式) 数据库存的形式为 201607 mysql转换的数据为 20167
	 * 
	 * @param date
	 * @return
	 */
	public static String sqlDate(String date) {
		if (StringUtil.isNullOrEmpty(date)) {
			return "";
		}
		if (date.length() < 6) {
			return date;
		}
		if (date.length() == 6) {
			if (date.split("")[5].equals("0")) {
				return (date.substring(0, 4) + date.substring(5, 6));
			}
		}
		return date;
	}

	/**
	 * 获取两个月份之间的月份
	 * 
	 * @param startMonth
	 *            开始月份
	 * @param endMonth
	 *            结束月份
	 * @return
	 */
	public static List<String> getMonthList(String startMonth, String endMonth) {
		List<String> monthList = Lists.newArrayList();
		if (StringUtil.isNullOrEmpty(startMonth) || StringUtil.isNullOrEmpty(endMonth)) {
			if (StringUtil.isNullOrEmpty(startMonth) && StringUtil.isNullOrEmpty(endMonth)) {
				monthList.add(getYearAndMonth());
			} else {
				monthList.add(StringUtil.isNullOrEmpty(startMonth) ? endMonth : startMonth);
			}
		} else {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
				Calendar min = Calendar.getInstance();
				Calendar max = Calendar.getInstance();
				min.setTime(sdf.parse(startMonth));
				min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
				max.setTime(sdf.parse(endMonth));
				max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
				Calendar curr = min;
				while (curr.before(max)) {
					monthList.add(sdf.format(curr.getTime()));
					curr.add(Calendar.MONTH, 1);
				}
			} catch (ParseException e) {
				throw new RuntimeException("日期转换出错，请检查");
			}
		}
		return monthList;
	}

	/**
	 * 
	 * 时间转换成指定格式字符串
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * @param format
	 * 
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 获取今天开始时间
	 * 
	 * @see yyyy-MM-dd 00:00:00
	 * @return
	 */
	public static Date getTodayStartTime() {
		return getCustDayStartTime(new Date());
	}

	/**
	 * 获取指定天的开始日
	 * 
	 * @param time
	 * @return
	 */
	public static Date getCustDayStartTime(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取指定天的结束日期
	 * 
	 * @param time
	 * @return yyyy-MM-dd 23:59:59
	 */
	public static Date getCustDayEndTime(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 获取今天结束时间
	 * 
	 * @return
	 */
	public static Date getTodayEndTime() {
		return getCustDayEndTime(new Date());
	}

	/**
	 * 
	 * 获取今年指定月份开始时间
	 * 
	 * 
	 * 
	 * @param month
	 * 
	 *            月份
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public static Date getMonthFirstTime(int month) throws Exception {
		if (month < 1 || month > 12)
			throw new Exception("月份参数输入错误");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 
	 * 获取当年指定月份结束时间
	 * 
	 * 
	 * 
	 * @param month
	 * 
	 *            月份
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public static Date getMonthEndTime(int month) throws Exception {
		if (month < 1 || month > 12)
			throw new Exception("月份参数输入错误");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 
	 * 获取本周开始时间
	 * 
	 * 
	 * 
	 * @param month
	 * 
	 *            当月
	 * 
	 * @param dateOfWeek
	 * 
	 *            一周的第
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public static Date getWeekStartTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 
	 * 获取上周开始时间
	 * 
	 * 
	 * 
	 * @return
	 */
	public static Date getPreWeekStartTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) - 1);
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 
	 * 获取上周结束时间
	 * 
	 * 
	 * 
	 * @return
	 */
	public static Date getPreWeekEndTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) - 1);
		calendar.set(Calendar.DAY_OF_WEEK, 7);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 
	 * 获得10位时间戳
	 * 
	 * 
	 * 
	 * @return
	 */
	public static long getStartTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1970, 1, 1, 0, 0, 0);
		return calendar.getTime().getTime();
	}

	/**
	 * 忽略毫秒值对比日期大小
	 * 
	 * @param date1
	 * @param date2
	 * @return <int>1：date1>date2 0:date1=date2 -1:date1<date2
	 */
	public static int compare(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		calendar1.set(Calendar.MILLISECOND, 0);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		calendar2.set(Calendar.MILLISECOND, 0);
		return calendar1.compareTo(calendar2);
	}

	/**
	 * 两个日期相差月数
	 * 
	 * @param start
	 *            开始时间
	 * 
	 * @param end
	 *            结止时间
	 * @return int 相差值【如果开始时间大于结束时间，则返回负数，否则返回正数】
	 * 
	 * @info 以整月进行计算，例1：2017-06-01~2017-07-30，返回值为2；例2：2017-06-20~2017-07-02，
	 *       返回值为2；例3：2017-06-20~2017-06-30，返回1；例4：2017-06-20~2017-05-25，返回-2；
	 */
	public static int getApartOfMonth(Date start, Date end) {
		Calendar bef = Calendar.getInstance();
		Calendar aft = Calendar.getInstance();
		bef.setTime(start);
		aft.setTime(end);
		int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
		int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
		int days = aft.get(Calendar.DAY_OF_MONTH) - bef.get(Calendar.DAY_OF_MONTH);
		if (days > 0) {
			result++;
		}
		return Math.abs(month + result);
	}

	/**
	 * 获得指定日期相加指定月份数后得到的新日期
	 * 
	 * @param calendar
	 * @param month
	 * @return
	 */
	public static Calendar getCustTimeAfterMonthTime(Calendar calendar, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(calendar.getTime());
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + month);
		return cal;
	}
	

	/**
	 * 判断两个日期是否为一个连续月份
	 * 
	 * @param date1
	 *            时间1
	 * @param date2
	 *            时间2
	 * @return 当date1的下一月为date2的当前月，则返回true;否则返回false
	 */
	public static boolean checkTwoDateIsSameMonth(Date date1, Date date2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);
		c1.set(Calendar.MONTH, c1.get(Calendar.MONTH) + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(c1.get(Calendar.MONTH));
		System.out.println(c2.get(Calendar.MONTH));
		System.out.println(sdf.format(c1.getTime()));
		System.out.println(sdf.format(c2.getTime()));
		return (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR));
	}
	
	/**
	 * *******************************
	 * @Description: 概述：获取当前月第一天<br/>
	 * @MethodName getMothFirstDay
	 * @author WangJia
	 * @date 2017年6月29日 下午4:15:16
	 * @version v1.0
	 * @return
	 *********************************
	 */
	public static String getMothFirstDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当前月第一天：
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		return first;
	}
	/**
	 * *******************************
	 * @Description: 概述：当前月最后一天<br/>
	 * @MethodName getMothLastDay
	 * @author WangJia
	 * @date 2017年3月1日 下午3:57:02
	 * @return
	 *********************************
	 */
	public static String getMothLastDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		  ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		return format.format(ca.getTime());
	}
	 /** 
     * 获取当年的第一天 
     * @param year 
     * @return 
     */  
    public static String getCurrYearFirst(){ 
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR);  
        return format.format(getYearFirst(currentYear));
    }  
      
    /** 
     * 获取当年的最后一天 
     * @param year 
     * @return 
     */  
    public static String getCurrYearLast(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR);  
        return format.format(getYearLast(currentYear));
    } 
    /** 
     * 获取某年第一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getYearFirst(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        Date currYearFirst = calendar.getTime();  
        return currYearFirst;  
    } 
    /** 
     * 获取某年最后一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getYearLast(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        Date currYearLast = calendar.getTime();  
          
        return currYearLast;  
    }  
    
    /**
     * 使用用户格式格式化日期
     * @param date
     * @param pattern
     * @return
     * @author LYF
     * @date 2017年7月14日 下午4:34:16
     */
    public static String format(Date date, String pattern) {
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}
    
    /**
     * 获取两个日期之间天List
     * @param start
     * @param end
     * @return
     */
    public static List<String> getDaysList(String start, String end){
    	List<String> list = Lists.newArrayList();  
    	if(StringUtil.isNullOrEmpty(start) && StringUtil.isNullOrEmpty(end)){
    		return list;
    	} else if(StringUtil.isNullOrEmpty(start) || StringUtil.isNullOrEmpty(end)){
    		list.add(StringUtil.isNullOrEmpty(start)?end:start);
    		return list;
    	}
    	Calendar calStart = Calendar.getInstance(); 
    	Calendar calEnd = Calendar.getInstance();
    	// 使用给定的 Date 设置此 Calendar 的时间  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date ds;
    	Date de;
		try {
			ds = sdf.parse(start);
			de = sdf.parse(end);
		} catch (ParseException e) {
			throw new RuntimeException("时间格式错误！");
		}
		calEnd.setTime(de);
    	if(ds.after(calEnd.getTime())){
    		Date temp = ds;
    		ds = de;
    		de = temp;
    	}
    	calStart.setTime(ds); 
    	while (de.after(calStart.getTime()) || de.equals(calStart.getTime()))  
    	  {  
    		list.add(sdf.format(calStart.getTime()));
    		calStart.add(Calendar.DATE, 1); 
    	  } 
    	return list;
    }
    
    /**
	 * 将日期转换成指定格式的字符串
	 * @param date - 要转换的日期
	 * @param dateFormat - 日期格式
	 * @return String 日期对应的字符串
	 */
	public static String convertDate2String(Date date, String dateFormat) {
		SimpleDateFormat sdf = null;
		if (dateFormat != null && !dateFormat.equals("")) {
			try {
				sdf = new SimpleDateFormat(dateFormat);
			}
			catch (Exception e) {
				e.printStackTrace();
				sdf = new SimpleDateFormat("yyyy-MM-dd");
			}
		}
		else {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		return sdf.format(date);
	}
	
	/**
	 * 将字符串转换成指定格式日期
	 * @param stringDate - 要转换的字符串格式的日期
	 * @param dateFormat - 要转换的字符串对应的日期格式
	 * @return Date 字符串对应的日期
	 */
	public static Date convertString2Date(String stringDate, String dateFormat) {
		SimpleDateFormat sdf = null;
		if (dateFormat != null && !dateFormat.equals("")) {
			try {
				sdf = new SimpleDateFormat(dateFormat);
			}
			catch (Exception e) {
				e.printStackTrace();
				sdf = new SimpleDateFormat("yyyy-MM-dd");
			}
		}
		else {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		try {
			return sdf.parse(stringDate);
		}
		catch (ParseException pe) {
			pe.printStackTrace();
			return new Date(System.currentTimeMillis());
		}
	}
	
    
    public static void main(String[] args) throws ParseException {
//    	System.out.println(DateAddMinute("2017-01-01 00:00:00", 10));
    	List<String> list = getDaysList("", "");
    	System.out.println("+++++++++  " + list.size());
    	for(String s : list){
    		System.out.println("+++++++++  " + s);
    	}
	}
}
