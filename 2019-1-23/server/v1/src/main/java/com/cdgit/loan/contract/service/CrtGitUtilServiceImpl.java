package com.cdgit.loan.contract.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.mapper.CrtGitUtilMapper;

/**
 * 获取营业时间：如果tb_pub_date表里面没有数据，那么返回当前系统时间
 * 
 * @author Administrator
 *
 */

@Service
@org.springframework.transaction.annotation.Transactional
public class CrtGitUtilServiceImpl {

	@Autowired
	CrtGitUtilMapper crtGitUtilMapper;

	// 获得营业时间
	public String getBusiDate() {
		String previousDate = crtGitUtilMapper.queryOperatingDate();
		if (null == previousDate) {// 如果配置表没有信息，那么把当前系统时间赋值进去
			Date currentDate = Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			previousDate = sdf.format(currentDate);
		}
		return previousDate;
	}

	//查询序列号
	public String getSeqNo(String sqeName, String orgNum) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("seqname", "SEQ_" + sqeName + "_NO.NEXTVAL");
		String sequence = crtGitUtilMapper.selectSeqByName(map);	//返回查询到的序列号
		StringBuilder sb = new StringBuilder(sqeName + orgNum);
		sb.append(getBusiDate().replaceAll("-", ""));
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
	
}
