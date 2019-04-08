package com.cdgit.loan.common.util;

import java.util.Map;


public abstract class ABIZProcess implements IBIZProcess, ProcessInitParam {

	/**
	 * 
	 * @Title: executeAfterCreateFlow
	 * @Description: TODO(用于创建流程成功后更新业务表数据)
	 * @param processInstId
	 *            流程实例ID号
	 * @return void 返回类型
	 * @throws
	 */
	public void executeAfterCreateFlow(String processInstId, Map<String, Object> workitem) throws Exception {
	}

	/**
	 * 
	 * @Title: executeBeforeSubmit
	 * @Description: TODO(用于审批同意流程提交前业务逻辑)
	 * @param processInstId
	 *            流程实例ID号
	 * @return void 返回类型
	 * @throws
	 */
	public void executeBeforeSubmit(String processInstId, Map<String, Object> workitem) throws Exception {
		try {
			submitBefore(processInstId, workitem);
		} catch (Exception e) {
			throw e;
		}
	}

	public void submitBefore(String processInstId, Map<String, Object> workitem) throws Exception {
		throw new RuntimeException("该流程未实现方法[executeBeforeSubmit]");
	}

	/**
	 * 
	 * @Title: executeBeforeIntegration
	 * @Description: TODO(用于与外围系统交互前业务逻辑)
	 * @param processInstId
	 *            流程实例ID号
	 * @return void 返回类型
	 * @throws
	 */
	public void executeBeforeIntegration(String processInstId, Map<String, Object> workitem) throws Exception {
		throw new RuntimeException("该流程未实现方法[executeBeforeIntegration]");
	}

	/**
	 * 
	 * @Title: executeBeforeTerminate
	 * @Description: TODO(用于普通流程结束前业务逻辑)
	 * @param processInstId
	 *            流程实例ID号
	 * @return void 返回类型
	 * @throws
	 */
	public void executeBeforeTerminate(String processInstId, Map<String, Object> workitem) throws Exception {
		try {
			terminateBefore(processInstId, workitem);
		} catch (Exception e) {
			throw e;
		}
	}

	public void terminateBefore(String processInstId, Map<String, Object> workitem) throws Exception {
		throw new RuntimeException("该流程未实现方法[executeBeforeTerminate]");
	}

	/**
	 * 
	 * @Title: executeBeforeUntread
	 * @Description: TODO(用于审批退回前业务逻辑)
	 * @param processInstId
	 *            流程实例ID号
	 * @return void 返回类型
	 * @throws
	 */
	public void executeBeforeUntread(String processInstId, Map<String, Object> workitem) throws Exception {
		
		try {
			untreadBefore(processInstId, workitem);
			
		} catch (Exception e) {
			
			throw e;
		}
	}

	public void untreadBefore(String processInstId, Map<String, Object> workitem) throws Exception {
		throw new RuntimeException("该流程未实现方法[executeBeforeUntread]");
	}

	/**
	 * 
	 * @Title: executeBeforeReject
	 * @Description: TODO(用于审批否决前业务逻辑)
	 * @param processInstId
	 *            流程实例ID号
	 * @return void 返回类型
	 * @throws
	 */
	public void executeBeforeReject(String processInstId, Map<String, Object> workitem) throws Exception {
		
		try {
			rejectBefore(processInstId, workitem);
			
		} catch (Exception e) {
			
			throw e;
		}
	}

	public void rejectBefore(String processInstId, Map<String, Object> workitem) throws Exception {
		throw new RuntimeException("该流程未实现方法[executeBeforeReject]");
	}

	/**
	 * 
	 * @Title: executeBeforeReject
	 * @Description: TODO(用于撤销流程后业务逻辑)
	 * @param processInstId
	 *            流程实例ID号
	 * @return void 返回类型
	 * @throws
	 */
	public void executeAfterAbort(String processInstId, Map<String, Object> workitem) throws Exception {
		
		try {
			abortAfter(processInstId, workitem);
			
		} catch (Exception e) {
			
			throw e;
		}

	}

	public void abortAfter(String processInstId, Map<String, Object> workitem) throws Exception {
		throw new RuntimeException("该流程未实现方法[executeAfterAbort]");
	}

	/**
	 * 
	 * @Title: executeDataCheck
	 * @Description: TODO(用于校验数据是否完整正确)
	 * @param processInstId
	 *            流程实例ID号
	 * @return Map 返回类型 返回 null 则通过，或者给key设值
	 *         errorNum=1通过errorNum=2不通过errorNum=3询问是否通过
	 *         ，errorCode提示码，errorContent提示内容
	 * @throws
	 */
	public Map<String, String> executeDataCheck(String processInstId, Map<String, Object> workitem) throws Exception {
		return null;
	}

//	public Map<String, Object> executeInitParam(String processInstId, Map<String, Object> workitem) {
//		Map<String, Object> paramMap = initParam(processInstId);
//		if (paramMap == null || paramMap.isEmpty()) {
//			return paramMap;
//		}
//		try {
//			RelativeDataManagerService.setRelativeDataBatch(Long.valueOf(processInstId), paramMap);
//		} catch (WFServiceException e) {
//			throw new RuntimeException("初始化流程参数失败", e);
//		} catch (NumberFormatException e) {
//			throw new RuntimeException("初始化流程参数失败：错误的流程编号[processInstId=" + processInstId + "]", e);
//		}
//		return paramMap;
//	}

	@Override
	public Map<String, Object> initParam(String processId) {
		return null;
	}
}
