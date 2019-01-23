package com.cdgit.loan.customerManage.naturalSchool.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.naturalSchool.bean.NaturalSchool;

@Mapper
public interface NaturalSchoolMapper {
    int deleteByPrimaryKey(String schoolId);

    int insert(NaturalSchool record);

    int insertSelective(NaturalSchool record);

    NaturalSchool selectByPrimaryKey(String schoolId);

    int updateByPrimaryKeySelective(NaturalSchool record);

    int updateByPrimaryKey(NaturalSchool record);

	List<NaturalSchool> selectByPartyId(String partyId);
}