package com.cdgit.loan.contract.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 存单相关
 * @author Administrator
 *
 */
@Mapper
public interface CrtCdzykhMapper {

	List<Integer> queryPostNum(String userNum);

}