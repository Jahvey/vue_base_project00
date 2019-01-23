package com.cdgit.loan.customerManage.impornantEvent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.impornantEvent.bean.ImpornantEvent;

@Mapper
public interface ImpornantEventMapper {
    int deleteByPrimaryKey(String importantEventId);

    int insert(ImpornantEvent record);

    int insertSelective(ImpornantEvent record);

    ImpornantEvent selectByPrimaryKey(String importantEventId);

    int updateByPrimaryKeySelective(ImpornantEvent record);

    int updateByPrimaryKey(ImpornantEvent record);

	List<ImpornantEvent> selectByPartyId(String partyId);
}