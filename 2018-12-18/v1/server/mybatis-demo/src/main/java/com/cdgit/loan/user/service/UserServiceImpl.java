package com.cdgit.loan.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.user.bean.UserInfo;
import com.cdgit.loan.user.bean.UserInfoCriteria;
import com.cdgit.loan.user.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class UserServiceImpl{
	
	@Autowired
    private UserMapper userMapper;

    public UserInfo findByUserName(UserInfoCriteria userInfoCriteria) {
        return userMapper.findByUserName(userInfoCriteria);
    }
    
    public List<UserInfo> getAll(UserInfoCriteria userInfoCriteria){
    	return userMapper.getAll(userInfoCriteria);
    }
    /**
     * 方法一  查询返回分页对象
     * <p>Title: findUser</p>  
     	第一个参数从第几页开始  第二个参数每页显示数量
     * <p>Description: </p>  
    
     * @param userInfoCriteria
     * @return
     */
    public PageInfo<UserInfo> findUser(){
    	PageHelper.startPage(1,4);
    	List<UserInfo> userList=userMapper.findUser();
        PageInfo pageInfo=new PageInfo(userList,4);
    	return pageInfo;
    }
    
    public UserInfo getOne(Long id){
    	return userMapper.getOne(id);
    }
	 
	 public void delete(Long id){
		 userMapper.delete(id);
	 }
	 
	 public void insert(UserInfo user){
		 System.out.println("打印信息:"+user.getId());
		 userMapper.insert(user);
	 }

	 public void update(UserInfo user){
		 userMapper.update(user);
	 }
	 
	 public void updateUser(String remark,String englishName){
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("remark", remark);
		 map.put("englishName", englishName);
		 userMapper.updateUser(map);
	 }
	 
}
