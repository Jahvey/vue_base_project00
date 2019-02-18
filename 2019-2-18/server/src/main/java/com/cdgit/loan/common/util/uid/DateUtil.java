package com.cdgit.loan.common.util.uid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import com.google.common.collect.Lists;

/**
 * 时间工具类
 * 
 *
 */

public class DateUtil extends DateUtils {

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
