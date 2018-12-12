/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.ApproveConsVo;

/**
 * @author cwalk
 * @createTime 2018年12月11日
 * mybatis-demo
 * com.cdgit.loan.csm.mapper
 * conApplyMapper.java
 */
@Mapper
public interface ConApplyMapper {
	
	//使用requestParam方式请求
	List<ApproveConsVo> getApproveCons(Map map);
	
	//使用了实体类的方式请求
	List<ApproveConsVo> getApproveCons1(Map map);
	
	

}
