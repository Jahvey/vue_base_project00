package com.cdgit.loan.contract.gitUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdgit.loan.contract.bean.CrtTbCsmCorporation;
import com.cdgit.loan.contract.bean.CrtTbLoanInfo;
import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.mapper.CrtTbCsmCorporationMapper;
import com.cdgit.loan.contract.mapper.CrtTbLoanInfoMapper;
import com.cdgit.loan.contract.mapper.TbConContractInfoMapper;

/**
 * 业务别的计算，业务别共7位
 * @author mch
 *
 */
@Component
public class LoanSubject {
	
	@Autowired	CrtTbLoanInfoMapper	loanInfoMapper;		//放款
	
	@Autowired	TbConContractInfoMapper contractInfoMapper;	//合同
	
	@Autowired	CrtTbCsmCorporationMapper corporationMapper;	//企业规模
	
	public String getDay(String beginDate, String endDate){
		Long begin=Long.parseLong(beginDate);
		Long end=Long.parseLong(endDate);
		Long days=end-begin;
		Integer day = (int) (days/(1000*60*60*24));
		return String.valueOf(day);
	}

	/**
	 *业务别规则（垫款除外）：
	 *1位：客户类型  1 对公 ， 2 对私
	 *2位：贷款类型  1自营贷款   ，2 委托贷款
	 *3,4位：产品类别  13 固定资产贷款、流动资金贷款，08 国内贸易融资，09 国际贸易融资 ，05经营性贷款 ，04 消费类贷款，01 一手房住房贷款，02 二手房住房贷款，03 商业住房贷款,06 单位委托贷款，07 个人委托贷款，10 公积金委托贷款
	 *5位：期限标志   1 短期，2 中长期，0 无效位（注：委托贷款为无效位0）
	 *6位：担保方式 1 信用，2 保证 ， 3 抵押 ， 4 质押 ，0 无效位（注：委托贷款为无效位0）
	 *7位：企业规模  1 大型，2 中型 ， 3 小型 ， 4 微型，0无效（注：委托贷款为无效位0）
	 */
	public String getLoanSubject(String loanId){
		CrtTbLoanInfo loanInfo = loanInfoMapper.selectLoanInfoByloanId(loanId);
		//第一位：客户类型
		String ls;
		String productType = loanInfo.getProductType();
		if("01".equals(productType.substring(0, 2))){// 1 对公 ， 2 对私
			ls="1";
		}else{
			ls="2";
		}
		//第二位：贷款类型
		String ls2;
		if("02005".equals(productType.substring(0, 5)) || "01013".equals(productType.substring(0, 5))){//1自营贷款   ，2 委托贷款
			ls2 = "2";
		}else{
			ls2 = "1";
		}
		//第三、四位：产品类型
		String ls3="";
		if("01001".equals(productType.substring(0, 5)) || "01003".equals(productType.substring(0, 5))){//13固定资产贷款、流动资金贷款
			ls3 = "13";
		}else if("01007".equals(productType.substring(0, 5))){//09 国际贸易融资
			ls3 = "09";
		}else if("01004".equals(productType.substring(0, 5)) || "01009".equals(productType.substring(0, 5))
				|| "01008".equals(productType.substring(0, 5)) || "01006".equals(productType.substring(0, 5))){//08 国内贸易融资
			ls3 = "08";
		}else if("02001".equals(productType.substring(0, 5))){//05经营性贷款
			ls3 = "05";
		}else if("02003".equals(productType.substring(0, 5))){//04 消费类贷款
			ls3 = "04";
		}else if("02002005".equals(productType)||"02002010".equals(productType)){//01 一手房住房贷款
			ls3 = "01";
		}else if("02002003".equals(productType)){//02 二手房住房贷款  
			ls3 = "02";
		}else if("02002004".equals(productType)||"02002011".equals(productType) || "02002006".equals(productType)){//03 商业住房贷款  06 二手房商用房按揭贷款
			ls3 = "03";
		}else if("02005001".equals(productType)){//10 公积金委托贷款
			ls3 = "10";
		}else if("02005".equals(productType.substring(0, 5))){//07 个人委托贷款
			ls3 = "07";
		}else if("01013".equals(productType.substring(0, 5))){//06 单位委托贷款
			ls3 = "06";
		}
		String ls4="";
		String ls5="";
		String ls6="";
		if("02005".equals(productType.substring(0, 5)) || "01013".equals(productType.substring(0, 5))){
			ls4="0";
			ls5="0";
			ls6="0";
		}else{
			//第五位：期限标志1 短期，2中长期
			String loanTerm = loanInfo.getLoanTerm().toString();//期限-按天计算
			String beginDate = dateFormat(loanInfo.getBeginDate());//开始时间
			String endDate = dateFormat(loanInfo.getEndDate());//结束时间
			if(null != loanTerm){
				int day = Integer.valueOf(loanTerm);
				int byear = Integer.valueOf(beginDate.substring(0, 4));
				int eyear = Integer.valueOf(endDate.substring(0, 4));
				boolean b = isLeapYear(byear);
				boolean e = isLeapYear(eyear);
				if(b || e){
					if(day>366){
						ls4 = "2";
					}else{
						ls4 = "1";
					}
				}else{
					if(day>365){
						ls4 = "2";
					}else{
						ls4 = "1";
					}
				}
			}
			//第六位：担保方式
			String contractId = loanInfo.getContractId();
			TbConContractInfo contractInfo = contractInfoMapper.queryOneConContractInfoByContractId(contractId);
			String mainGuarantyType = contractInfo.getMainGuarantyType();//主担保方式
			if ("01".equals(mainGuarantyType)) {//1-信用
				ls5 = "1";
			} else if ("02".equals(mainGuarantyType)) {//3-抵押
				ls5 = "3";
			} else if ("03".equals(mainGuarantyType)) {//4-质押
				ls5 = "4";
			} else if ("04".equals(mainGuarantyType)) {//2-保证
				ls5 = "2";
			}else{//0 无效位
				ls5 = "0";
			}
			//第七位：企业规模
			String enterpriseScaleGx = "";
			CrtTbCsmCorporation corporation= corporationMapper.selectCsmCorporationByPrimaryKey(loanInfo.getPartyId());
			if(corporation != null){
				enterpriseScaleGx = corporation.getBankScaleIdentify();
			}
			
			if("1".equals(enterpriseScaleGx)){//1 大型
				ls6 = "1";
			}else if("2".equals(enterpriseScaleGx)){//2 中型
				ls6 = "2";
			}else if("3".equals(enterpriseScaleGx)){// 3 小型
				ls6 = "3";
			}else if("4".equals(enterpriseScaleGx)){//4 微型
				ls6 = "4";
			}else{//0无效
				ls6 = "0";
			}
		}
		ls = ls+ls2+ls3+ls4+ls5+ls6;
		if(ls.length() !=7){
			throw new RuntimeException("业务别创建失败!");
		}
		return ls;
	}
		
	public boolean isLeapYear(int year){
		if(year % 100 == 0){
			if(year % 400 ==0){
				return true;
			}
		}else {
			if(year % 4 == 0){
				return true;
			}
		}
		return false;
	}
	
	public String dateFormat(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(date);
		return format;
	}
		
}
