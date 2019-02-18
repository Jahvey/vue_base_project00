package com.cdgit.feignconsumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("workflow-client")
public interface WorkFlowFeignClient {
	
	@RequestMapping(value="/workflow/startProInst",method=RequestMethod.POST)
	String startProInst(@RequestBody String RequestBody);
	
	@RequestMapping(value="/workflow/getNextNodeInfo",method=RequestMethod.POST)
	String getNextNodeInfo(@RequestBody String RequestBody);
	
	@RequestMapping(value="/workflow/getTaskagencyConfig",method=RequestMethod.POST)
	String getTaskagencyConfig(@RequestBody String RequestBody);
	
	@RequestMapping(value="/workflow/taskCommit",method=RequestMethod.POST)
	String taskCommit(@RequestBody String RequestBody);
	
	@RequestMapping(value="/workflow/taskEnd",method=RequestMethod.POST)
	String taskEnd(@RequestBody String RequestBody);
	
}
