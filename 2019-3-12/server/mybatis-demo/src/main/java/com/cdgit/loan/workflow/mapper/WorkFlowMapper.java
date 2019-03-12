package com.cdgit.loan.workflow.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.TbLoanSummary;
import com.cdgit.loan.workflow.bean.TbConLoanChange;
import com.cdgit.loan.workflow.bean.TbWfmProcessinstance;
import com.cdgit.loan.workflow.bean.TbWfmProcessmapping;
import com.cdgit.loan.workflow.bean.TbWfmWorkiteminstance;
import com.cdgit.loan.workflow.bean.TbWfmWorkitemmapping;
import com.cdgit.loan.workflow.bean.WorkFlowVO;

@Mapper
public interface WorkFlowMapper {

	List<WorkFlowVO> queryWorkingList();//查询待办工作列表
//	
	List<WorkFlowVO> queryWorkedList();//查询跟踪列表
	
	List queryRemindInfoGroup();//查询提示列表
	
	int countRemindInfoAdmin();//非客户经理 查询所属机构查询提示列表统计
	
	int countRemindInfo();//客户经理查询本身
	
	void insertProcessinstance(TbWfmProcessinstance processInstance);//创建流程实例时 插入 流程实例表
	
	void insertWorkiteminstance(TbWfmWorkiteminstance workIteminstance);//创建流程实例时 插入 流程实例表
	
//	TbWfmWorkiteminstance queryWorkiteminstance(Map map);//查询是否已存在工作项
	
//	int query_canaction(Map map);//原程序是返回string  原来是查询的流程库 现在该如何处理
	
	int queryWorkiteminstance(Map map);//查询是否已存在工作项
	
	List queryProcessmapping(Map map);//查询是否存在流程模板信息 默认取第一条
	
	List queryWorkitemmapping(Map map);//查询节点配置信息
	
	void updateProcessinstance(Map map);//认领执行时更新
	
	TbWfmProcessinstance findPro(Map map);//根据流程实例ID查询流程实例信息
	
	TbConLoanChange queryLoanChange(Map map);//根据id查询贷后变更信息
	
	TbLoanSummary loanSummary(Map map);//放款信息
	
	List queryLoanInfo();//DealAccount
	
	List queryDebtInfo();//DealAccount
	
	List getPositionCodeInfo(Long positionId);//根据岗位ID查询人员
	
	void deleteWorkiteminstance(String processId);//删除工作项实例
	
	void deleteProcessinstance(String processId);//删除流程实例
	
	TbWfmProcessmapping queryWfmProcessmapping(Map map);
	
	TbWfmWorkitemmapping queryItemmapping(Map map);
	
}
