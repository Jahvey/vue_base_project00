package com.cdgit.loan.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;

import freemarker.template.Template;

/**
 * 字符处理工具类
 * 
 * 
 *
 */

public class StringUtil extends StringUtils {

	public static final String EMPTY = "";
	private static final char SEPARATOR = '_';
	/** double验证 */
	private static final String DOUBLE_MONEY = "^\\d+(\\.\\d?\\d?)?$";
	
	public static final String PHONE_REG = "^[1][3,4,5,7,8][0-9]{9}$";
	private static String[] chineseArr = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
	private static String[] unitArr = { "十", "百", "千", "万", "十", "白", "千", "亿", "十", "百", "千" };
	
	public static String encryptPhone(String phone){
		if(isNotBlank(phone) && phone.matches(PHONE_REG)){
			return phone.substring(0,3)+"****"+phone.substring(7);
		}
		return phone;
	}

	/**
	 * 判断输入是否double类型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMoney(String str) {
		Pattern pattern = Pattern.compile(DOUBLE_MONEY);
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 检查字符是不是为空（包括空字符）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || "".equals(str.trim()) || str.length() == 0 || "null".equals(str.trim()))
			return true;
		else
			return false;
	}
	
	/**
	 * 检查字符是否有值
	 * @param str
	 * @return
	 */
	public static boolean hasLength(String str){
		return !isNullOrEmpty(str);
	}

	/**
	 * 取得带参服务器调用地址 传入参数为name,value键值对的多组或0组数据
	 * 
	 * @Example : getRequestGetUrl(request, "username",username) 或
	 *          getRequestGetUrl(request,
	 *          "username",username,"userpass",userpass);
	 * @param req
	 * @param obj
	 * @return
	 */
	public static String getRequestGetUrl(HttpServletRequest req, Object... obj) {
		if (obj == null || obj.length == 0)
			return "";
		if (obj.length % 2 != 0)
			throw new RuntimeException("传入参数长度不正确");
		// String url = "http://" + req.getServerName() // 服务器地址
		// + ":" + req.getServerPort() // 端口号
		// + req.getContextPath() // 项目名称
		// + req.getServletPath();
		String url = req.getContextPath() + req.getServletPath();
		// 每次执行取两个数字，所以
		for (int i = 0; i < obj.length; i += 2) {
			if (obj[i + 1] != null) {
				if (url.indexOf("?") == -1) {
					url += "?";
				}
				if (i != obj.length - 2) {
					url += obj[i] + "=" + obj[i + 1] + "&";
				} else {
					url += obj[i] + "=" + obj[i + 1];
				}
			}
		}
		return url;
	}

	/**
	 * 将金额增加逗号分隔符
	 * 
	 * @param d
	 * @return
	 */
	public static String amountAddcomma(double d) {
		NumberFormat nf = NumberFormat.getInstance();
		return nf.format(d);
	}

	public static String getCode() {
		return checkCode((int) (Math.random() * 1000000) + "");
	}

	// 检查并修正验证码
	private static String checkCode(String code) {
		if (code.length() == 6) {
			return code;
		} else if (code.length() > 6) {
			return code.substring(0, 6);
		} else {
			String str = (int) (Math.random() * 10) + "";
			return checkCode(code + str);
		}
	}

	/**
	 * InputStream转String
	 * 
	 * @param is
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String convertStreamToString(InputStream is) throws UnsupportedEncodingException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

	public static String toJson(Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		if (object == null)
			return "";
		try {
			String returnStr = objectMapper.writeValueAsString(object);
			return returnStr.replaceAll(":null", ":\"\"");
		} catch (JsonProcessingException ex) {
			throw Throwables.propagate(ex);
		}
	}

	/**
	 * 获取字符串中的数字
	 * 
	 * @param str
	 * @return
	 */
	public static double getNumber(String str) {
		String regEx = "(^\\d+\\.?\\d*+)?.*";
		Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		String number_str = m.replaceAll("$1");
		if (StringUtils.isNotEmpty(number_str)) {
			return Double.parseDouble(number_str);
		} else {
			return 0;
		}
	}
	
	public static String getNumberStr(String str) {
		String regEx = "(^\\d+\\.?\\d*+)?.*";
		Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		String number_str = m.replaceAll("$1");
		if (StringUtils.isNotEmpty(number_str)) {
			return number_str;
		} else {
			return "";
		}
	}

	public static String getUnit(String str) {
		if (str == null) {
			return "-";
		}
		String regEx = "(^\\d+\\.?\\d*+)?";
		Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		String unit = m.replaceAll("");
		return unit;
	}

	/**
	 * 缩略字符串（不区分中英文字符）
	 * 
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		String str_before = replaceHtml(str);
		String str_after = "";
		try {
			str_after = subbyte(str_before, length);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return str.replace(str_before, str_after);
		// try {
		// StringBuilder sb = new StringBuilder();
		// int currentLength = 0;
		// for (char c :
		// replaceHtml(StringEscapeUtils.unescapeHtml(str)).toCharArray()) {
		// currentLength += String.valueOf(c).getBytes("UTF-8").length;
		// if (currentLength <= length - 3) {
		// sb.append(c);
		// } else {
		// sb.append("...");
		// break;
		// }
		// }
		// return sb.toString();
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// return "";
	}

	/**
	 * 按字节截取字符串 重写subbyte 每个汉字按一个字算，标题中数字和字母都按半个字符计算
	 * 
	 * @param title
	 * @return
	 */
	public static String subbyte(String str, int end) throws UnsupportedEncodingException {
		if (str == null) {
			return "";
		}
		int ends = end * 2;
		int length = str.getBytes("GBK").length / 2;

		String resStr = "";
		String str1 = str;
		int subint = 0;
		if (str != null && !"".equals(str)) {
			if (end > 0 && end < length) {
				StringBuffer buff = new StringBuffer();
				int i = 0;
				while (subint < ends) {
					buff.append(str1.charAt(i));
					if (isChineseChar(str1.charAt(i))) {
						subint++;
						subint++;
					} else {
						subint++;
					}

					/*
					 * System.out.println(str1.charAt(i)+"  在"+i+"位置  "+str);
					 * System.out.println("subint:: "+subint+" ends:: "+ends);
					 */

					if (subint == ends - 1) {
						if (isChineseChar(str1.charAt(i + 1))) {
							break;
						}
					}
					i++;
				}
				resStr = buff.toString() + "...";
			} else {
				resStr = str;
			}
		}
		/* System.out.println("最终截取字符串：：" +resStr+" 长度 "+end+" 字符串:" +str); */
		return resStr;
	}

	/**
	 * 判断是否是汉字
	 * 
	 * @param c
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static boolean isChineseChar(char c) throws UnsupportedEncodingException {
		// 如果字节数大于1，是汉字
		return String.valueOf(c).getBytes("GBK").length > 1;
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)) {
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val) {
		if (val == null) {
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val) {
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val) {
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val) {
		return toLong(val).intValue();
	}

	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String ipAddress = null;
		// ipAddress = request.getRemoteAddr();
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}

		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	/**
	 * 驼峰命名法工具
	 * 
	 * @return toCamelCase("hello_world") == "helloWorld"
	 *         toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 *         toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCamelCase(String s) {
		if (s == null) {
			return null;
		}
		s = s.toLowerCase();
		StringBuilder sb = new StringBuilder(s.length());
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == SEPARATOR) {
				upperCase = true;
			} else if (upperCase) {
				sb.append(Character.toUpperCase(c));
				upperCase = false;
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 驼峰命名法工具
	 * 
	 * @return toCamelCase("hello_world") == "helloWorld"
	 *         toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 *         toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCapitalizeCamelCase(String s) {
		if (s == null) {
			return null;
		}
		s = toCamelCase(s);
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
	 * 驼峰命名法工具
	 * 
	 * @return toCamelCase("hello_world") == "helloWorld"
	 *         toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 *         toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toUnderScoreCase(String s) {
		if (s == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			boolean nextUpperCase = true;
			if (i < (s.length() - 1)) {
				nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
			}
			if ((i > 0) && Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					if (s.charAt(i - 1) != SEPARATOR) {
						sb.append(SEPARATOR);
					}
				}
				upperCase = true;
			} else {
				upperCase = false;
			}
			sb.append(Character.toLowerCase(c));
		}
		return sb.toString();
	}

	/**
	 * 生成随机数
	 * 
	 * @param size
	 * @return
	 */
	public static String random(int size) {
		java.util.Random r = new java.util.Random();
		String rs = String.valueOf(r.nextLong());
		return rs.substring(1, size);
	}

	/**
	 * double转换
	 * 
	 * @param str
	 * @return
	 */
	public static Double parseDouble(Object str) {
		if (str == null) {
			return 0.00;
		}
		Double num = Double.parseDouble(str.toString());
		
		DecimalFormat df = new DecimalFormat("0.############");  
		return Double.valueOf(df.format(num)); 
//		BigDecimal bg = new BigDecimal(num);
//		return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 判断是否图片
	 * 
	 * @param url
	 * @return
	 */
	public static boolean isimg(String url) {
		if (isNullOrEmpty(url)) {
			return false;
		}
		if (url.endsWith(".jpg") || url.endsWith(".bmp") || url.endsWith(".jpeg") || url.endsWith(".gig")
				|| url.endsWith(".gif") || url.endsWith(".png") || url.endsWith(".tif") || url.endsWith(".rgb")
				|| url.endsWith(".dib") || url.endsWith(".eps") || url.endsWith(".jpe") || url.endsWith(".pcx")
				|| url.endsWith(".bmp")) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否图片
	 * 
	 * @param url
	 * @return
	 */
	public static boolean isvideo(String url) {
		if (isNullOrEmpty(url)) {
			return false;
		}
		if (url.endsWith(".mp4") || url.endsWith(".3gp") || url.endsWith(".rm") || url.endsWith(".rmvb")
				|| url.endsWith(".avi") || url.endsWith(".wmv") || url.endsWith(".ogg") || url.endsWith(".webm")
				|| url.endsWith(".flv")) {
			return true;
		}
		return false;
	}

	/**
	 * 获取排序加一，用于树的排序
	 * 
	 * @return
	 */
	public static String getSortAddOne(String code) {
		if (isNullOrEmpty(code)) {
			return "00";
		}
		int length = code.length();
		int codenum = Integer.parseInt(code);
		int codeAfter = codenum + 1;
		String trturnStr = String.valueOf(codeAfter);
		int lengthAfter = trturnStr.length();
		if (length > lengthAfter) {
			String str = ""; // 多余位在前面补0
			for (int i = 0; i < length - lengthAfter; i++) {
				str += "0";
			}
			return str + trturnStr;
		} else {
			return trturnStr;
		}
	}

	/**
	 * 生成编码
	 * 
	 * @param code
	 * @return
	 */
	public static String getCodeAddOne(String code) {
		if (isNullOrEmpty(code)) {
			return "01";
		} else {
			String returnStr = "";
			int codenum = Integer.parseInt(code);
			codenum += 1;
			if (codenum < 10) {
				returnStr = "0" + codenum;
			} else {
				returnStr = String.valueOf(codenum);
			}
			return returnStr;
		}
	}

	/**
	 * 判断两个字符串是否相等
	 * 
	 * @param str
	 * @param str1
	 * @return
	 */
	public static boolean isEquals(String str, String str1) {
		if (str == null && str1 == null) {
			return true;
		} else if (str == null && str1 != null) {
			return false;
		} else if (str != null && str1 == null) {
			return false;
		} else if (str != null && str1 != null && str.equals(str1)) {
			return true;
		}
		return false;
	}

	/**
	 * 根据传入的key取map中对应的值
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Object getFromMap(Map map, String key) {
		if (map == null) {
			return null;
		}
		return map.get(key);
	}

	/**
	 * 单位换算为万
	 * 
	 * @param value
	 * @return
	 */
	public static String formatterValue(Long value) {
		DecimalFormat df = new DecimalFormat("#0.00");
		if (value == null || value == 0) {
			return "0";
		}
		return df.format((double) value / 10000);
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile(DOUBLE_MONEY);
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 数字转拼音
	 * 
	 * @param number
	 * @return
	 */
	public static String numberToChinese(Integer number) {
		if (number == null) {
			return "";
		}
		String numStr = number + "";
		String result = "";
		int numLen = numStr.length();
		for (int i = 0; i < numLen; i++) {
			int num = numStr.charAt(i) - 48;
			if (i != numLen - 1 && num != 0) {
				result += chineseArr[num] + unitArr[numLen - 2 - i];
				if (number >= 10 && number < 20) {
					result = result.substring(1);
				}
			} else {
				if (!(number >= 10 && number % 10 == 0)) {
					result += chineseArr[num];
				}
			}
		}
		return result;
	}

	/**
	 * 去除最后一位
	 * 
	 * @param str
	 * @return
	 */
	public static String removeTail(String str) {
		if (isNullOrEmpty(str)) {
			return "";
		} else {
			return str.substring(0, str.length() - 1);
		}
	}

	/**
	 * 替换字符模版内容
	 * 
	 * @param code
	 * @param content
	 * @param params
	 * @return
	 */
	public static String handdleStringTemplate(String code, String content, Map<String, String> params) {
		StringWriter result = new StringWriter();
		Template t;
		try {
			t = new Template(code, new StringReader(content), null);
			t.process(params, result);
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param regex
	 *            正则表达式字符串
	 * @param str
	 *            要匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回
	 *         false;如果传入的正则为空，则视为不需要验证，直接返回true
	 */
	public static boolean match(String regex, String str) {
		if (isBlank(regex)) {
			// 如果传入的正则为空，则视为不需要验证
			return true;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 验证手机格式是否正确
	 * 
	 * @param phone
	 *            手机号码
	 * @return
	 */
	public static boolean matchPhone(String phone) {
		String regex = "^(((19[0-9])|16[0-9])|(17[0-9])|(13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\\d{8}$";
		return match(regex, phone);
	}
	
	
	public static String getHostAndPort(String str) {
		URI uri = URI.create(str);
		URI effectiveURI = null;
		try {
			effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(),
					uri.getHost(), uri.getPort(), null, null, null);
		} catch (Throwable var4) {
			effectiveURI = null;
		}
		if(effectiveURI == null){
			return "";
		}
		return effectiveURI.toString();
	}

	
	public  static String joinStr(String[] strs, String space) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (space == null) {
			space = "";
		}
		StringBuilder sb = new StringBuilder(strs.length * 30);
		sb.append(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			sb.append(space).append(strs[i]);
		}
		return sb.toString();
	}
	
	
	public static boolean isNull(String str) {
		return !isNotNull(str);
	}

	public static boolean isNotNull(String str) {
		String temp;
		if (str == null || (temp = str.trim()).isEmpty()) {
			return false;
		}
		if (temp.equalsIgnoreCase("null") || temp.equalsIgnoreCase("undefined")) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(encryptPhone("18810014426"));
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
