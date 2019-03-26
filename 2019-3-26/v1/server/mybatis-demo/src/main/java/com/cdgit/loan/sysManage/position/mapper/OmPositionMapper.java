package com.cdgit.loan.sysManage.position.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.sysManage.position.bean.OmPosition;

@Mapper
public interface OmPositionMapper {
    int deleteByPrimaryKey(Long positionid);

    int insert(OmPosition record);

    int insertSelective(OmPosition record);

    OmPosition selectByPrimaryKey(Long positionid);

    int updateByPrimaryKeySelective(OmPosition record);

    int updateByPrimaryKey(OmPosition record);
    
    List<OmPosition> queryPositionInfo(@Param("posiname") String posiname);
}