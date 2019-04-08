/**
 * 
 */
package com.cdgit.loan.csm.process.bizApply;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbSysBasicRatePoMapper;
import com.cdgit.loan.csm.po.CsmTbSysBasicRatePo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class getBasicRate {
	
	@Autowired
	CsmTbSysBasicRatePoMapper csmTbSysBasicRatePoMapper;

	public BigDecimal getBasicrate(int loanlength, String rateType) {
		System.out.println("[getBasicrate]loanlength:"+loanlength+",rateType"+rateType);
		BigDecimal basicrate = new BigDecimal("0");
//		DataObject rate = DataObjectUtil
//				.createDataObject("com.bos.dataset.sys.TbSysBasicRate");
		CsmTbSysBasicRatePo rate = new CsmTbSysBasicRatePo();
		rate.setStatus("1");
	
		if (rateType.equals("1")) {//普通人民币
			if (loanlength <= 6) {
				rate.setIntRateCd("1");
			} else if (loanlength > 6 && loanlength <= 12) {
				rate.setIntRateCd("2");
			} else if (loanlength > 12 && loanlength <= 36) {
				rate.setIntRateCd("3");
			} else if (loanlength > 36 && loanlength <= 60) {
				rate.setIntRateCd("4");
			} else if (loanlength > 60) {
				rate.setIntRateCd("5");;
			}
		} else if (rateType.equals("2")) {//公积金
			if (loanlength <= 60) {
				rate.setIntRateCd("6");
			} else if (loanlength > 60) {
				rate.setIntRateCd("7");
			}
		}
		rate=csmTbSysBasicRatePoMapper.selectByIntRateCd(rate.getIntRateCd());
		basicrate =  rate.getIntRate();
		return basicrate;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
