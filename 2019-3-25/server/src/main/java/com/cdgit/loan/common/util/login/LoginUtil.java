package com.cdgit.loan.common.util.login;

import org.apache.commons.codec.digest.DigestUtils;

public class LoginUtil {

	public static String md5(){
		return md5("000000");
	}
	public static String md5(String key){
		return md5("gitLoan",md5("gitLoan",md5("gitLoan",key)));
	}
	
	public static String md5(String text,String key){
		String encodingString = DigestUtils.md5Hex(text + key);
		return encodingString;
	}
}
