package com.cdgit.loan.sysManage.login.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.util.login.LoginUtil;
import com.cdgit.loan.sysManage.empManage.bean.AcOperator;
import com.cdgit.loan.sysManage.empManage.bean.OmEmployee;
import com.cdgit.loan.sysManage.login.bean.RoleBean;
import com.cdgit.loan.sysManage.login.service.LoginServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginServiceImpl loginService;
	
	@PostMapping("/userLogin")
	@ResponseBody
	public Map<String, Object> userLogin(HttpSession session,@RequestBody Map<String, Object> params){
		Map<String, Object> result = new HashMap<String, Object>();
		
		String account = params.get("account").toString();//登录用户
		String password = params.get("password").toString();//密码
		if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){//判断用户、密码是否为空
			result.put("code", "201");
			result.put("msg", "用户名、密码必须输入值");
			return result;
		}
		try {
			//用户名获取用户对象
			AcOperator  acOperator = loginService.getOperatorByAccount(account);
			
			if(null == acOperator){//为空说明用户名不存在
				result.put("code", "201");
				result.put("msg", "用户不存在，请重新输入");
				return result;
			}
			if(null != acOperator.getUnlocktime()){
				Date now = new Date();
				long nowTime = now.getTime();
				long lock = acOperator.getUnlocktime().getTime();
				long releas = lock - nowTime;
				if(releas > 0){
					result.put("code", "201");
					result.put("msg", "账户被锁定，剩余锁定时间："+releas/1000+"秒");
					return result;
				}
				
			}
			
			//验证密码
			String db_psw = acOperator.getPassword();//数据库密文
			String input_psw = LoginUtil.md5(password);//明文转密文
			if(!db_psw.equals(input_psw)){//密码错误
				acOperator.setErrcount(acOperator.getErrcount()+1);
				int times = 5-acOperator.getErrcount();//剩余可登录次数
				if(acOperator.getErrcount() == 5){//连续错误5次 则锁定30分钟
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date now = new Date();
					String time = sdf.format(new Date(now.getTime() + 30 * 60 * 1000));
					acOperator.setUnlocktime(sdf.parse(time));//设置锁定时间30分钟
					acOperator.setErrcount(0);
				}
				loginService.loginFailProcess(acOperator);
				result.put("code", "201");
				result.put("msg", "密码不正确，请重新输入，连续输入5次将锁定账户，还可输入 "+times+"次。");
				return result;
			}
			//验证通过，开始进行登录成功后的处理
			//1:创建token，并插入到session 并返回前端
			Map<String, Object> data = new HashMap<String, Object>();
			String token = UUID.randomUUID().toString().substring(0,16);
			session.setAttribute("token", token);
			data.put("token", token);
			//2：用户基本信息
			OmEmployee omEmployee = loginService.getUserInfoByUserId(account);
			if(omEmployee == null){
				result.put("code", "201");
				result.put("msg", "登录成功后获取用户基本信息失败");
				return result;
			}
			data.put("userInfo", omEmployee);
			//3:角色信息
			List<RoleBean> roles = loginService.getRoleListByUserId(account);
			data.put("roles", roles);
			result.put("code", "200");
			result.put("msg", "登录成功");
			result.put("data", data);
		} catch (Exception e) {
			result.put("code", "201");
			result.put("msg", "登录异常，异常信息：" + e.getStackTrace());
			// TODO: handle exception
		} finally{
			return result;
		}
		
		
	}
}
