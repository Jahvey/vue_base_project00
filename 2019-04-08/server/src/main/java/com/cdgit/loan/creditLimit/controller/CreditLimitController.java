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

import com.cdgit.loan.common.bean.ApplyDaoParam;
import com.cdgit.loan.common.bean.PageBean;
import com.cdgit.loan.common.service.ApplyDaoEos;
import com.cdgit.loan.creditLimit.bean.TbCrdThirdPartyLimit;
import com.cdgit.loan.creditLimit.mapper.CreditLimitMapper;
import com.cdgit.loan.creditLimit.service.CreditLimitImpl;
import com.cdgit.loan.workflow.service.WorkFlowServiceImpl;
import com.github.pagehelper.PageInfo;
import com.netflix.governator.annotations.binding.Request;

@RestController
@RequestMapping("/creditLimit")
public class CreditLimitController {

	@Autowired
	CreditLimitImpl creditLimitImpl;
	
	@Autowired
	WorkFlowServiceImpl workFlowServiceImpl;
	
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
	@RequestMapping(value="/getAccInfoList",method=RequestMethod.GET)
	public PageBean getAccInfoList(@RequestParam Map map){
		PageInfo pageInfo=creditLimitImpl.getAccInfoList(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setData(pageInfo.getList());
		return pageBean;
	}
	
	@RequestMapping(value="/getThirdPartyCrdByLimitId",method=RequestMethod.GET)
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
	
	/**
	 * 
		创建额度申请
	 * <p>Title: createCreditLimit</p>  
	
	 * <p>Description: </p>  
	
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping(value="/createCreditLimit",method=RequestMethod.POST)
	public String createCreditLimit(@RequestBody Map map) throws Throwable{
		Map paramMap=(Map)map.get("param");
		ApplyDaoParam param=new ApplyDaoParam((String)paramMap.get("phase"),(String)paramMap.get("code"));
		ApplyDaoEos.create(param, (Map)map.get("data"));
		return "";
	}
	
	/**
	 * 
		返回值要么放到Map 里面 要么定义一个对象放到里面
	 * <p>Title: getCrdInfo</p>  
	
	 * <p>Description: </p>  
		两个参数 qcsm 创建授信申请的时候没有传递  crdId  applyId
		第一次创建成功进去的时候没有传递qcsm=1 ，如果是点击左侧树节点会传递 qcsm=1
	 * @return
	 */
	@RequestMapping(value="/getCrdInfo",method=RequestMethod.POST)
	public Map getCrdInfo(@RequestParam Map map){
	
		map=creditLimitImpl.getCrdInfo(map);
		
		return map;
	}
	
	/**
	 * 
	
	 * <p>Title: getCreditLineMea</p>  
	
	 * <p>Description: </p>  
	
	 * @param map
	 */
	@RequestMapping(value="/getCreditLineMea",method=RequestMethod.POST)
	public Map getCreditLineMea(@RequestParam Map map){
		return creditLimitImpl.getCreditLineMea(map);
	}
	
}
