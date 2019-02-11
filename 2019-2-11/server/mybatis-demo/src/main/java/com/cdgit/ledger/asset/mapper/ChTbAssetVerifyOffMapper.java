package com.cdgit.ledger.asset.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.ledger.asset.bean.ChSelectWriteOffResult;
import com.cdgit.ledger.asset.bean.ChTbAssetVerifyOff;
@Mapper
public interface ChTbAssetVerifyOffMapper {
    
	//1.核销查询 2.不良资产处置
    List<ChSelectWriteOffResult> selectWriteOff(Map map);

    
}