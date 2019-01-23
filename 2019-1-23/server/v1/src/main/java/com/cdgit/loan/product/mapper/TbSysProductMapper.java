package com.cdgit.loan.product.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.product.bean.TbSysProduct;

/**
 * 

* <p>Title: ProductMapper</p>  

* <p>Description: </p>  

* @author xujianming  
 * @param <T>

* @date 2018年12月25日
 */
@Mapper
public interface TbSysProductMapper {

	List queryProductByAuth(Map map);
	
	List queryPartyRole(Map map);
	
	List orgRoleAllowAdd(Map map);
	
}
