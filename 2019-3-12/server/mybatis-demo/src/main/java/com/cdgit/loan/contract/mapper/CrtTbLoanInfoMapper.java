package com.cdgit.loan.contract.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbLoanInfo;

@Mapper
public interface CrtTbLoanInfoMapper {

	//根据主键查询一条放款信息
	CrtTbLoanInfo selectLoanInfoByloanId(String loanId);
    
    //根据其他查询一条放款信息
	CrtTbLoanInfo selectLoanInfoByOther(Map map);
    
    //查询多条放款信息，条件暂时不写
    List<CrtTbLoanInfo> selectAll();
    
    //选择添加一条放款信息
    void insertLoanInfoSelective(CrtTbLoanInfo loanInfo);
    
    //选择修改一条放款信息
    void updateLoanInfoBySelect(CrtTbLoanInfo loanInfo);

}