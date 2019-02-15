package com.cdgit.loan.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.product.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	/**
	 * 根据权限查询机构树方法 用于dialog展示机构列表
	
	 * <p>Title: queryProductByAuth</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/queryProductByAuth",method=RequestMethod.POST)
	public List<?> queryProductByAuth(@RequestBody Map map){
		return productServiceImpl.queryProductByAuth(map);
	}
	
	@RequestMapping(value="/queryPartyRole",method=RequestMethod.POST)
	public Map queryPartyRole(@RequestBody Map map){
		return productServiceImpl.queryPartyRole(map);
	}
	
	@RequestMapping(value="/orgRoleAllowAdd",method=RequestMethod.POST)
	public List orgRoleAllowAdd(@RequestBody Map map){
		return productServiceImpl.orgRoleAllowAdd(map);
	}
	
}
