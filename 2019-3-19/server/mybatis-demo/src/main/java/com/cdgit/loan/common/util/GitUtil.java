package com.cdgit.loan.common.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdgit.loan.common.mapper.CommonUtilMapper;

public class GitUtil {

	@Autowired
	private static RedisUtils redisUtils;

	@Autowired
	static CommonUtilMapper commonUtilMapper;
	
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
	
	/**
	 * 获取营业时间
	
	 * <p>Title: getBusiTimestamp</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public  static Timestamp getBusiTimestamp() {
//		Calendar cal = (Calendar)redisUtils.get("bizDate");
//		Calendar cal = cache.get("bizDate");
		
		Calendar cal =Calendar.getInstance();
		cal.setTime(new java.util.Date());
		
		Calendar now = Calendar.getInstance();
		now.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		now.set(Calendar.MONTH, cal.get(Calendar.MONTH));
		now.set(Calendar.DATE, cal.get(Calendar.DATE));

		return new Timestamp(now.getTimeInMillis());
	}
	
	/**
	 * 以前是从session获取legorg标志
	
	 * <p>Title: getLegorg</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String getLegorg() {
		String legorg = "";
		// 获取session里的机构级别串
//		IUserObject user = CommonUtil.getIUserObject();
//		Map<String, Object> attmap = user.getAttributes();
//		legorg = (String) attmap.get("legorg");
		return legorg;
	}

	public static String getLegorgByOrgCd(String orgCd) {
		
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.organizationtree.getOrgLegorg", orgCd);
//		return datas.length > 0 ? (String) datas[0] : null;
		
		String legorg = commonUtilMapper.getLegorgByOrgCd(orgCd);
		return legorg;
	}

	/**
	 * 
	
	 * <p>Title: getLegorgByPartyId</p>  
	
	 * <p>Description: </p>  
	
	 * @param partyId
	 * @return
	 */
	public static String getLegorgByPartyId(String partyId) {
		String legorg = commonUtilMapper.getLegorgByPartyId(partyId);
		return legorg;
	}
	
	/**
	 * 
	获取业务时间
	 * <p>Title: getBusiDate1DayBeforStr</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String getBusiDate1DayBeforStr() {
		java.util.Date dateBusi = new Date(getBusiTimestamp().getTime());
		java.util.Date dateBusi1DayBefore = new Date(getBusiTimestamp().getTime());

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateBusi);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		dateBusi1DayBefore = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dateBusi1DayBefore);
	}

	/**
	 * 
	获取当前时间戳
	 * <p>Title: currDateTime</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static Timestamp currDateTime() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

	/**
	 * 获取当前时间
	
	 * <p>Title: getCurrDate</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static java.util.Date getCurrDate() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 
	获取业务日期字符串yyyy-MM-dd
	 * <p>Title: getBusiDateStr</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String getBusiDateStr() {
		return new SimpleDateFormat("yyyy-MM-dd").format(getBusiTimestamp());
	}

	/**
	 * @param datestr
	 *            yyyy-M-dd格式的字符串
	 * @return
	 * @author 王世春
	 */
	public static java.util.Date toDate(String datestr) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(datestr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param datestr
	 *            根据日期格式的字符串，转换成日期
	 * @return
	 * @author 王世春
	 */
	public static java.util.Date toDate(String datestr, String style) {
		try {
			return new SimpleDateFormat(style).parse(datestr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return
	 */
	public Date getBusiDate() {
		return new java.sql.Date(getBusiTimestamp().getTime());
	}
	
	/**
	 * 
	获取当前机构编号
	 * <p>Title: getCurrentOrgCd</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String getCurrentOrgCd() {
//		String id = DataContextUtil.getString("m:userObject/attributes/orgcode");
//		return id;
		return "";
	}

	/**
	 * 
	获取当前机构ID
	 * <p>Title: getCurrentOrgId</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String getCurrentOrgId() {
//		String id = DataContextUtil.getString("m:userObject/userOrgId");
//		return id;
		return "";
	}

	/**
	 * 
	获取当前用户ID
	 * <p>Title: getCurrentUserId</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String getCurrentUserId() {
//		String id = DataContextUtil.getString("m:userObject/userId");
//		// String id = DataContextUtil
//		// .getString("m:userObject/attributes/operatorid");
//		return id;
		return "";
	}

	/**
	 * 
	获取当前用户岗位编号
	 * <p>Title: getCurrentPositionCode</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String getCurrentPositionCode() {
//		String id = DataContextUtil.getString("m:userObject/attributes/posicode");
//		return id;
		return "";
	}

	/**
	 * 
	getCurrentPositionName
	 * <p>Title: getCurrentPositionName</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public static String getCurrentPositionName() {
//		String id = DataContextUtil.getString("m:userObject/attributes/posiname");
//		return id;
		return "";
	}
	
}
