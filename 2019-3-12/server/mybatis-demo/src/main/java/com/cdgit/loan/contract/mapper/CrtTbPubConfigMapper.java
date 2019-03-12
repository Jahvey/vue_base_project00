package com.cdgit.loan.contract.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbPubConfig;

@Mapper
public interface CrtTbPubConfigMapper {

	/**
	 * 获取配置表值
	 * @param map
	 * @return
	 */
	CrtTbPubConfig queryPubConfig(Map map);
}
