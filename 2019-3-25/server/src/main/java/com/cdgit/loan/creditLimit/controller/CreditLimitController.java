package com.cdgit.loan.creditLimit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.bean.PageBean;
import com.cdgit.loan.creditLimit.bean.TbCrdThirdPartyLimit;
import com.cdgit.loan.creditLimit.service.CreditLimitImpl;
import com.github.pagehelper.PageInfo;
import com.netflix.governator.annotations.binding.Request;

@RestController
@RequestMapping("/creditLimit")
public class CreditLimitController {

	@Autowired
	CreditLimitImpl creditLimitImpl;
	
	@RequestMapping(value="/queryThirdHis_protocol",method=RequestMethod.POST)
	public PageBean queryThirdHis_protocol(@RequestBody Map map){
		PageInfo pageInfo=creditLimitImpl.queryThirdHis_protocol(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setData(pageInfo.getList());
		return pageBean;
	}
	
	@RequestMapping(value="/queryThirdHis_corp",method=RequestMethod.POST)
	public PageBean queryThirdHis_corp(@RequestBody Map map){
		PageInfo pageInfo=creditLimitImpl.queryThirdHis_corp(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setData(pageInfo.getList());
		return pageBean;
	}
	
	/**
	 * 创建担保公司额度调整
	
	 * <p>Title: createPartyCrd</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 */
	@RequestMapping(value="/createPartyCrd",method=RequestMethod.POST)
	public Map createPartyCrd(@RequestBody Map map){
		Map resultMap = creditLimitImpl.createPartyCrd(map);
		return resultMap;
	}
	
	/**
	 * 查询担保账户列表
	
	 * <p>Title: getAccInfoList</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 * @return
	 */
	@RequestMapping(value="getAccInfoList",method=RequestMethod.GET)
	public PageBean getAccInfoList(@RequestParam Map map){
		PageInfo pageInfo=creditLimitImpl.getAccInfoList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setData(pageInfo.getList());
		return pageBean;
	}
	
	@RequestMapping(value="getThirdPartyCrdByLimitId",method=RequestMethod.GET)
	public TbCrdThirdPartyLimit getThirdPartyCrdByLimitId(@RequestParam Map map){
		return creditLimitImpl.getThirdPartyCrdByLimitId(map);
	}
	
	@RequestMapping(value="createDbht",method=RequestMethod.POST)
	public Map createDbht(@RequestBody Map map){
		Map resultMap=creditLimitImpl.createDbht(map);
		return resultMap;
	}
	
//	@RequestMapping(value = "userinfo/get")
//    @ResponseBody
//    public Message getUserInfo(Long userId) {
//        LOGGER.info("测试redis");
//        String redisSet = "hello";
//        redisTemplate.opsForValue().set("redisSet",redisSet);
//        UserInfo user = new UserInfo();
//        user.setUserId(userId);
//        ResponseEntity<UserInfo> entity = restTemplate.postForEntity("http://JINZHU-SERVICE-PRODUCER/userinfo/get", user, UserInfo.class, new Object[]{});
//        SuccessMessage message = new SuccessMessage();
//        UserInfo userInfo = entity.getBody();
//        Object obj = redisTemplate.opsForValue().get("redisSet");
//        userInfo.setUserName(obj.toString());
//        message.setData(userInfo);
//        return message;
//    }
	
}
