package com.cdgit.loan.sysManage.login.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.sysManage.empManage.bean.AcOperator;
import com.cdgit.loan.sysManage.empManage.bean.OmEmployee;
import com.cdgit.loan.sysManage.login.bean.RoleBean;

@Mapper
public interface LoginMapper {

	AcOperator getOperatorByAccount(String userid);
	
	int loginFailProcess(AcOperator acOperator);
	
	OmEmployee getUserInfoByUserId(String userId);
	
	List<RoleBean> getRoleListByUserId(String userId);
}
