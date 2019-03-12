package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbBizProductInfo;

/**
 * Tb_Biz_Product_Info：产品信息表
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbBizProductInfoMapper {

	//根据产品类型查询多条符合条件的产品信息出来
	List<CrtTbBizProductInfo> selectBizProductInfoByProductCd(String productCd);
	
    void insertBizProductInfoSelective(CrtTbBizProductInfo record);

    CrtTbBizProductInfo selectBizProductInfoByPrimaryKey(String id);

    void updateBizProductInfoByPrimaryKeySelective(CrtTbBizProductInfo record);

}