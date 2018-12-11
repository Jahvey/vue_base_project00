package com.cdgit.loan.contract.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.ConApvList;
import com.cdgit.loan.contract.bean.TbConContractInfo;

@Mapper
public interface TbConContractInfoMapper {
	
    void insert(TbConContractInfo record);

//    void insertSelective(TbConContractInfo record);
    /**
     * 测试：根据合同ID获取合同的详细信息
     * @param contractId
     * @return
     */
    TbConContractInfo getTbConContractInfoById(String contractId);
    
    /**
     * 查询我的业务之贷款合同主页面信息，map里面保存的是分页的参数
     * @param map
     * @return
     */
    List<ConApvList> queryConApvList(Map map);
}