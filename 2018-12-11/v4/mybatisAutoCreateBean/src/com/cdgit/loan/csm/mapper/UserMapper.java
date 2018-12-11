package com.cdgit.loan.csm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.UserInfo;
import com.cdgit.loan.csm.bean.UserInfoCriteria;

/**
 * @MapperScan("com.springms.cloud.mapper.**") 或者在每个 Mapper 接口文件上添加 @Mapper 也可以；

* <p>Title: UserMapper</p>  

* <p>Description: </p>  

* @author xujianming  

* @date 2018年10月26日
 */
@Mapper
public interface UserMapper {

	 UserInfo findByUserName(UserInfoCriteria userInfoCriteria);
	 
	 List<UserInfo> getAll(UserInfoCriteria userInfoCriteria);

	 List<UserInfo> findUser();
	 
	 UserInfo getOne(Long id);
	 
	 void delete(Long id);
	 
	 void insert(UserInfo user);

	 void update(UserInfo user);
	 
	 void updateUser(Map map);
	 
}
