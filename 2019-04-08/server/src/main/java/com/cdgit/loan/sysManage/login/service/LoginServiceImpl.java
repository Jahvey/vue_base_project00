package com.cdgit.loan.sysManage.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.sysManage.acRole.bean.AcRole;
import com.cdgit.loan.sysManage.empManage.bean.AcOperator;
import com.cdgit.loan.sysManage.empManage.bean.OmEmployee;
import com.cdgit.loan.sysManage.login.bean.RoleBean;
import com.cdgit.loan.sysManage.login.mapper.LoginMapper;

@Service
@Transactional
public class LoginServiceImpl {

	@Autowired
	LoginMapper loginMapper;
	/**
	 * 验证用户名
	 * */
	public AcOperator getOperatorByAccount(String account){
		AcOperator acOperator= null;
		try {
			acOperator = loginMapper.getOperatorByAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			return acOperator;
		}
		
	}
	
	/**
	 * 登录失败处理，记录失败次数，锁定时间
	 * */
	public int loginFailProcess(AcOperator acOperator){
		int result = 0;
		try {
			result = loginMapper.loginFailProcess(acOperator);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			return result;
		}
	}
	
	public OmEmployee getUserInfoByUserId(String userId){
		OmEmployee omEmployee = null;
		try {
			omEmployee = loginMapper.getUserInfoByUserId(userId);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			return omEmployee;
		}
	}
	
	public List<RoleBean> getRoleListByUserId(String userId){
		List<RoleBean> result = new ArrayList<RoleBean>();
		try {
			result = loginMapper.getRoleListByUserId(userId);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			return result;
		}
	}
}
