package com.cdgit.loan.csm.process.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.po.CsmTbBizProductInfoPo;

@Service
@Transactional
public class ProductUtil {
	
	@Autowired
	CsmProductMapper csmProductMapper;
	
	@SuppressWarnings("unchecked")
	public  String getEntityName(String productCd) {
		List<CsmTbBizProductInfoPo> datas = csmProductMapper.queryProductInfo(productCd);
		//Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.product.getProductInfo", productCd);
		if (datas == null || datas.size()== 0) {
			return null;
		}
		//return ((Map<String, String>) datas[0]).get("ENTITY_NAME");
		return datas.get(0).getEntityName();
	}
	
	
	@SuppressWarnings("unchecked")
	public  String getTableName(String productCd) {
		List<CsmTbBizProductInfoPo> datas = csmProductMapper.queryProductInfo(productCd);
		//Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.product.getProductInfo", productCd);
		if (datas == null || datas.size()== 0) {
			return null;
		}
		//return ((Map<String, String>) datas[0]).get("ENTITY_NAME");
		return datas.get(0).getTableName();
	}

}
