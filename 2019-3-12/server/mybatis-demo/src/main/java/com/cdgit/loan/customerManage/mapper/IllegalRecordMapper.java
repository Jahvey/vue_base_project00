package com.cdgit.loan.customerManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.bean.IllegalRecord;
import com.cdgit.loan.customerManage.bean.IllegalRecordKey;

@Mapper
public interface IllegalRecordMapper {
    int deleteByPrimaryKey(IllegalRecordKey key);

    int insert(IllegalRecord record);

    int insertSelective(IllegalRecord record);

    IllegalRecord selectByPrimaryKey(IllegalRecordKey key);

    int updateByPrimaryKeySelective(IllegalRecord record);

    int updateByPrimaryKey(IllegalRecord record);

	List<IllegalRecord> illegalList(String partyId);
}