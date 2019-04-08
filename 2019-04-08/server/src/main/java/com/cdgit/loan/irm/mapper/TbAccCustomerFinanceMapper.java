package com.cdgit.loan.irm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.irm.bean.IrmCriteria;
import com.cdgit.loan.irm.bean.IrmInfoBean;
import com.cdgit.loan.irm.bean.TbAccCustomerFinance;

@Mapper
public interface TbAccCustomerFinanceMapper {

	List<TbAccCustomerFinance> queryTbAccCustomerFinanceMapperByParams(TbAccCustomerFinance finance);
}
