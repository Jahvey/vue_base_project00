package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.TbLoanSummary;

@Mapper
public interface TbLoanSummaryMapper {
	
	/**
	 * 根据传入的借据id删除一条记录，暂时不需要返回值
	 * @param summaryId
	 */
    void deleteByPrimaryKey(String summaryId);

    /**
     * 插入一条数据，暂时不需要返回值
     * @param record
     */
    void insert(TbLoanSummary record);

    /**
     * 插入多条返回的数据，可以写一个返回值，有需要再修改
     * @param record
     * @return
     */
    void insertSelective(TbLoanSummary record);

    /**
     * 根据主键查询一条数据
     * @param summaryId
     * @return
     */
    TbLoanSummary selectByPrimaryKey(String summaryId);
    
    /**
     * 	查询多条信息，mapper里面还有没有写
     * @return
     */
    List<TbLoanSummary> selectTbLoanSummaryList();
    
    /**
     * 修改选中的信息
     * @param record
     * @return
     */
    void updateByPrimaryKeySelective(TbLoanSummary record);

    /**
     * 
     * @param record
     */
    void updateByPrimaryKey(TbLoanSummary record);
}