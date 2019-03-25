package com.cdgit.loan.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdgit.loan.user.mapper.UserMapper;

/**
 * 各类编号的生成器
 * @author 王世春
 * @date 2014-02-26 15:48:52
 * @description 各类编号的生成
 */

public class BizNumGenerator {

	@Autowired
	static UserMapper userMapper;
	
	/**
	 * 生成客户编号
	 * @return
	 * @author 王世春
	 */
	
	public String genCustomerNum() {
//		String date = new SimpleDateFormat("yyyyMMdd").format(GitUtil
//				.getBusiTimestamp());
		String date = new SimpleDateFormat("yyMMdd").format(new Date());
		return date + getNextSequence("SEQ_CRT_KH");
	}
	
	public String nowString() {
//		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(GitUtil
//				.getBusiTimestamp());
		String date = new SimpleDateFormat("yyMMdd").format(new Date());
//	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
//    String dateStr=df.format(new Date());// new Date()为获取当前系统时间
    String transNO=date+getNextSequence("SEQ_CRT_FK")+".I01.S64.167";
     return transNO;
	}
	/**
	 * @return
	 * @author 王世春
	 */
	public String genEvalNum() {
//		String date = new SimpleDateFormat("yyMMdd").format(GitUtil
//				.getBusiTimestamp());
		String date = new SimpleDateFormat("yyMMdd").format(new Date());
		return date + getNextSequence("SEQ_CRT_PJ");
	}

	/**
	 * 生成业务编号
	 * @return
	 * @author 王世春
	 */
	public String genBizNum() {
		

//		String date = new SimpleDateFormat("yyMMdd").format(GitUtil
//				.getBusiTimestamp());
		String date = new SimpleDateFormat("yyMMdd").format(new Date());
		return date + getNextSequence("SEQ_CRT_YW");
	}

	/**
	 * 生成合同编号
	 * @return
	 * con:合同数  今天
	 * isCon:是否综合授信合同
	 * appDtlNum:综合授信分项下批复合同数
	 * isConX:是否综合授信协议
	 * @author 王世春  
	 */
	public String genConctractNum(Integer con,String isCon,Integer appDtlNum,Integer isConX,String ConNum,String ConNums) {
//		String date = new SimpleDateFormat("yyyyMMdd").format(GitUtil
//				.getBusiTimestamp());
		String date = new SimpleDateFormat("yyMMdd").format(new Date());
		String strCon = "CON"+date+getNextSequence("SEQ_CRT_HT");
		con = con+1;
		String str = con.toString();
		if(ConNums != null && ConNums.length()>17){
			Integer ing = Integer.parseInt(ConNums.substring(17))+1;
			str = ing.toString();
		}
		String appStr = "0";
		if(isCon.equals("02") && (ConNum != null && ConNum != "" && ConNum != "null")){
			appDtlNum = appDtlNum+1;
			appStr = appDtlNum.toString();
			strCon = ConNum.substring(0,11)+getNextSequence("SEQ_CRT_HT")+ConNum.substring(15)+"-"+appStr;
			return strCon; 
		}
		if(str.length() == 1){
			strCon += "000" + Integer.parseInt(str);
		}if(str.length() == 2){
			strCon += "00" + Integer.parseInt(str);
		}if(str.length() == 3){
			strCon += "0" + Integer.parseInt(str);
		}
		
		return strCon;
	}
	
	public String genConctractNum(String strCon,Integer len){
		strCon = strCon.substring(0,16);
		strCon = strCon + len.toString();
		return strCon;
	}

	/**
	 * @return
	 * @author 王世春
	 */
	public String genPayNum() {
//				String date = new SimpleDateFormat("yyMMdd").format(GitUtil
//						.getBusiTimestamp());
				String date = new SimpleDateFormat("yyMMdd").format(new Date());
				return date + getNextSequence("SEQ_CRT_FK");
	}
	
	public String getCrdNum(String edString){
//		String date = new SimpleDateFormat("yyMMdd").format(GitUtil
//				.getBusiTimestamp());
		String date = new SimpleDateFormat("yyMMdd").format(new Date());
		return edString + date + getNextSequence("SEQ_CRT_ED");
	}
	
	public String getLcsStan(){
		return getNextSequence("SEQ_LCS_STAN");
	}
	
	private static String getNextSequence(String seqName){
		String num = null;
		try {
			num = String.valueOf(userMapper.getNextVal1(seqName+".nextval"));
				if(seqName.equals("SEQ_CRT_KH")||seqName.equals("SEQ_BIZ_PF")||seqName.equals("SEQ_CON_XY")||seqName.equals("SEQ_CON_JK")||seqName.equals("SEQ_CON_SUB")||seqName.equals("SEQ_PAY_JJ")){
					return StringUtils.leftPad(num, 6, '0');
				}else if("SEQ_LCS_STAN".equals(seqName) || "SEQ_SYS_TRC_NO".equals(seqName)){
					return StringUtils.leftPad(num, 8,'0');
				}else{
					return StringUtils.leftPad(num, 4, '0');
				}
		} catch (Exception e) {
			// TODO 自动生成 catch 块
//			LogUtil.logError("查询sequence时出错："+seqName, e, new Object[0]);
			return null;
		}
	}
	
	/**
	 * @return String
	 * @author 甘泉
	 */
	public String genGuarGroupNum() {
		String num_str = "LB";
		return num_str + StringUtils.leftPad(getNextSequence("SEQ_CSM_LB"), 6, '0');
	}
	
	/**
	 * @return String
	 * @author 甘泉
	 */
	public String genGroupCompanyNum() {
		String num_str = "JT";
		return num_str + StringUtils.leftPad(getNextSequence("SEQ_CSM_JT"), 6, '0');
	}
	
	/**
	 * @return String
	 * @author xiaoxia
	 */
	public String genAftCheckNum() {
		String str = "JCBH";
//		String date = new SimpleDateFormat("yyMMdd").format(GitUtil.getBusiTimestamp());
		String date = new SimpleDateFormat("yyMMdd").format(new Date());
		return str + date + StringUtils.leftPad(getNextSequence("SEQ_AFT_JC"), 6, '0');
	}
	
	/**
	 * @return String
	 * @author xiaoxia
	 */
	public String genLoanChangeNum() {
		String str = "BGBH";
//		String date = new SimpleDateFormat("yyMMdd").format(GitUtil.getBusiTimestamp());
		String date = new SimpleDateFormat("yyMMdd").format(new Date());
		return str + date + StringUtils.leftPad(getNextSequence("SEQ_AFT_BG"), 6, '0');
	}
	
	/**
	 * @return String
	 * @author zhaochunming
	 */
	public String genSysTrcNo() {
		return getNextSequenceByName("SEQ_SYS_TRC_NO");
	}
	
	/**
	 * 根据sequence名字取出下一个值
	
	 * <p>Title: getNextSequenceByName</p>  
	
	 * <p>Description: </p>  
	
	 * @param seqName
	 * @return
	 */
	private String getNextSequenceByName(String seqName){
		Map seqMap=new HashMap();
		seqMap.put("sequenceName", seqName+".nextval");
		String ret = "0";
		ret=String.valueOf(userMapper.getNextVal(seqMap));
		return ret;
	}
	
	/**
	 * 获取业务编号
	 * BY 3231
	 * */
	public static String getBizNum(String seqName){
//		String date = new SimpleDateFormat("yyMMdd").format(GitUtil
//				.getBusiTimestamp());
		String date = new SimpleDateFormat("yyMMdd").format(new Date());
		return date + getNextSequence(seqName);
	}
}
