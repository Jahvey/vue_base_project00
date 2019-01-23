package com.cdgit.loan.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.product.bean.TbSysProduct;
import com.cdgit.loan.product.mapper.TbSysProductMapper;

@Service
public class ProductServiceImpl<T> {

	@Autowired
	private TbSysProductMapper productMapper;
	
	
	/**
	 * 后期考虑传入顶层节点而从某一节点开始展现树结构
	  参数一 parentId  参数二  List
	 * <p>Title: queryProductByAuth</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	public List queryProductByAuth(Map map){
		
		List productList=productMapper.queryProductByAuth(map);
		
		List resultList=new ArrayList();//所有顶层节点   ProductCategoryBean
		
		Map<Object,Object> treeMap=new HashMap<>();//所有节点数据
		
		TbSysProduct tmp;
		
		if(productList != null && productList.size() > 0){
			for(int i = 0;i < productList.size();++i){
				treeMap.put(((TbSysProduct) productList.get(i)).getProductCd(), productList.get(i));
				if(StringUtils.isEmpty(((TbSysProduct) productList.get(i)).getSuperiorId())){
					resultList.add(productList.get(i));//将顶层节点放入集合中
				}
			}
		}
		
		for(int i=0; i< productList.size();++i){
			if(StringUtils.isNotEmpty(((TbSysProduct)productList.get(i)).getSuperiorId())){//遍历父节点不为空的数据 并找出他们的父节点  判断该父节点有无child 没有先分配，有则直接添加
				TbSysProduct product = (TbSysProduct) treeMap.get(((TbSysProduct)productList.get(i)).getSuperiorId());
				if(product != null) {
					if(product.getChildList()==null){//第一步 说明当前节点父节点还没有创建子节点对象  new
						product.setChildList(new ArrayList());
					}
					product.getChildList().add(productList.get(i));
					treeMap.put(((TbSysProduct)productList.get(i)).getSuperiorId(), product);//将当前节点父节点数据更新，下次遇到父节点相同时不用再重新new
				}
				
				
			}
		}
		
		
		return resultList;
	}
	
	/**
	 * 查询机构未有角色
		区分有父机构和无父机构的情况
	 * <p>Title: orgRoleAllowAdd</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public List orgRoleAllowAdd(Map map){
		List resultList=productMapper.orgRoleAllowAdd(map);//所有顶层节点   ProductCategoryBean
		return resultList;
	}
	
	/**
	 * 查询机构已有角色
	        应该是所有角色 未有角色一起返回
	 * <p>Title: queryPartyRole</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 */
	public Map queryPartyRole(Map map){
		List resultList=productMapper.queryPartyRole(map);//所有顶层节点   ProductCategoryBean
//		String[] rightData=new String[resultList.size()];
		List<String> rightDataList=new ArrayList();
		Map returnMap=new HashMap<String,Object>();
		if(null != resultList && resultList.size() > 0){
			
			for(int i=0;i<resultList.size();++i){
				Map tmp1=(Map)resultList.get(i);
				if("0".equals((String)tmp1.get("EXIST"))){
					rightDataList.add((String)tmp1.get("ROLEID"));
				}
			}
		}
		returnMap.put("totalData", resultList);
		returnMap.put("rightData", rightDataList.toArray());//只是已有的数组数据
		
		
		return returnMap;
	}
	
}
