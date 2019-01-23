package com.cdgit.loan.contract.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.ConApvList;
import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.query.ConInfoHtXwQuery;

@Mapper
public interface TbConContractInfoMapper {
	
    /**
     * 根据contractId获取一条合同的详细信息
     * @param contractId
     * @return
     */
    TbConContractInfo queryOneConContractInfoByContractId(String contractId);
    
    /**
     * 查询我的业务之贷款合同主页面信息，map里面保存的是分页的参数
     * @param map
     * @return
     */
    List<ConApvList> queryConApvList(Map map);
    
    //测试
    List<ConApvList> queryConApvList1(Map map);
    
    /**
     * 根据合同编号查询一条明细信息，先这样写
     * @return
     */
    ConInfoHtXwQuery getConInfoByContractNum(Map map);
    
    /**
     * 根据旧合同id查询旧合同编号
     * @param contractNum
     * @return
     */
    String getOldContractNum(String oldContractId);
    
    /**
     * 根据合同id查询一条完整的信息，先这样写
     */
    ConInfoHtXwQuery queryContractBaseInfo(String contractId);
}