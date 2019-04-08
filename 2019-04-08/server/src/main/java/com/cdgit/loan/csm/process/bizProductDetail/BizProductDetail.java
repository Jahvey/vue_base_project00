/**
 * 
 */
package com.cdgit.loan.csm.process.bizProductDetail;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmTbBizAmountDetailApply;
import com.cdgit.loan.csm.bean.CsmTbBizAmoutApply;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmoutApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizMyhtxxApplyPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizProductInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConGjInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbCsmPartyPoMapper;
import com.cdgit.loan.csm.po.CsmTbBizMyhtxxApplyPo;
import com.cdgit.loan.csm.po.CsmTbBizProductInfoPo;
import com.cdgit.loan.csm.po.CsmTbConGjInfoPo;
import com.cdgit.loan.csm.po.CsmTbCsmPartyPo;
import com.cdgit.loan.csm.pub.gitUtils.GitUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class BizProductDetail {
	
	@Autowired
	CsmTbBizProductInfoPoMapper csmTbBizProductInfoPoMapper;
	
	@Autowired
	CsmTbBizMyhtxxApplyPoMapper csmTbBizMyhtxxApplyPoMapper;
	
	@Autowired
	CsmTbBizAmoutApplyMapper csmTbBizAmoutApplyMapper;
	
	@Autowired
	CsmTbBizAmountDetailApplyMapper csmTbBizAmountDetailApplyMapper;
	
	@Autowired
	CsmTbCsmPartyPoMapper csmTbCsmPartyPoMapper;
	
	@Autowired
	CsmTbConGjInfoPoMapper csmTbConGjInfoPoMapper;
	
	
	@Autowired
	GitUtils gitUtils;
	
	
	/**
	 * 查询品种配置信息
	 * @param productCd
	 * @return
	 */
	public CsmTbBizProductInfoPo getProductInfo(String productCd){	
		return csmTbBizProductInfoPoMapper.queryByProductType(productCd);

	}
	
	/**
	 * TODO 贸易融资的业务在做申请的时候 需要调用国结的接口校验业务编号
	 * 
	 * @param map
	 * @return
	 */
	public HashMap<String, Object> checkYwbh(HashMap<String, Object> map){
		System.out.println("[checkYwbh] 接受到的参数"+map);
		String amountDetailId=(String)map.get("amountDetailId");
		String productType=(String)map.get("productType");
		String ywbh=(String)map.get("ywbh");
		String cpzlx=(String)map.get("cpzlx");
		String contractId=(String)map.get("contractId");
		
		String isVaild="";//业务编号是否合法
		String msg="";//返回信息
		String bz="";//国结返回的放款币种
		String je="";//国结返回的放款金额
		String fkqx="";//国结返回的放款期限
		String gjyj="";//国结返回的国结意见
		
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		Date createDate = gitUtils.getBusiDate();
		CsmTbBizAmountDetailApply bizAmountDetailApply = csmTbBizAmountDetailApplyMapper.selectByPrimaryKey(amountDetailId);
		
		CsmTbBizAmoutApply bizAmountApply = csmTbBizAmoutApplyMapper.selectByPrimaryKey(bizAmountDetailApply.getAmountId());
		
		CsmTbCsmPartyPo party = csmTbCsmPartyPoMapper.selectByPrimaryKey(bizAmountApply.getPartyId());
		
		System.out.println("调用验证接口......");
		
		if(msg.equals("")){//如果校验通过
			isVaild="1";
			CsmTbConGjInfoPo csmTbConGjInfoPo = new CsmTbConGjInfoPo();
			csmTbConGjInfoPo.setContractId(contractId);
			csmTbConGjInfoPo.setCreateTime(createDate);
			csmTbConGjInfoPo.setUpdateTime(createDate);
			csmTbConGjInfoPo.setYwbh(ywbh);
			
			try {
				csmTbConGjInfoPoMapper.insertSelective(csmTbConGjInfoPo);
				System.out.println("保存国结信息成功！");
			} catch (Exception e) {
				msg="数据库异常";
				isVaild="0";	
				
				throw new RuntimeException(e);
				//e.printStackTrace();
			}
	
			
		}else{
			msg="校验没有通过";
			isVaild="0";
			
		}
		
		hashMap.put("isVaild", isVaild);
		hashMap.put("msg", msg);
		hashMap.put("bz", bz);
		hashMap.put("je", je);
		hashMap.put("fkqx", fkqx);
		hashMap.put("gjyj", gjyj);
		return hashMap;
		
	}
	
	/**
	 * 根据contractId查询贸易合同信息
	 * @param contractId
	 * @return
	 */
	public PageInfo<CsmTbBizMyhtxxApplyPo> queryMyhtxx(Map map)
	{
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));

		
		String contractId=(String) map.get("contractId");
		List<CsmTbBizMyhtxxApplyPo> BizMyhtxxApplyPoQuery = csmTbBizMyhtxxApplyPoMapper.queryListByAmtDetailId(contractId);
		PageInfo pageInfo=new PageInfo(BizMyhtxxApplyPoQuery,(Integer)map.get("pageSize"));
		return pageInfo;
	}
	

	
}
