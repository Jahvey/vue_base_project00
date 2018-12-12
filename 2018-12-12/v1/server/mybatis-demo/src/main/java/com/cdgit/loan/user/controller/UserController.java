package com.cdgit.loan.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.user.bean.UserInfo;
import com.cdgit.loan.user.bean.UserInfoCriteria;
import com.cdgit.loan.user.service.UserServiceImpl;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@RequestMapping("/findByUserName")
	public UserInfo findByUserName(@RequestBody UserInfoCriteria userInfoCriteria) {
		return userService.findByUserName(userInfoCriteria);
	}

	@GetMapping("/getAll")
	public List<UserInfo> getAll(@RequestBody UserInfoCriteria userInfoCriteria) {
		return userService.getAll(userInfoCriteria);
	}

	@GetMapping("/getOne")
	public UserInfo getOne(@RequestParam("id") Long id) {
		return userService.getOne(id);
	}

	@PostMapping("/delete")
	public void delete(@RequestParam("id") Long id) {
		userService.delete(id);
	}

	@PostMapping("/insert")
	public void insert(@RequestBody UserInfo user) {
        userService.insert(user);
	}

	@PostMapping("/update")
	public void update(@RequestBody UserInfo user) {
		userService.update(user);
	}

	@PostMapping("/updateUser")
	public void updateUser(@RequestParam("remark") String remark,@RequestParam("englishName") String englishName) {
		userService.updateUser(remark,englishName);
	}
	
	/**
	 * 
	 *startPgae(页码，每页几条数据)
	 *@ResponseBody()将返回的page转换为json对象由页面的js进行解析
	
	 * <p>Title: findUser</p>  
	
	 * <p>Description: </p>  
	
	 * @param userInfoCriteria
	 * @return
	 */
	@GetMapping("/findUser")
	@ResponseBody
	public PageInfo<UserInfo> findUser(){
		return userService.findUser();
	}
	
}
