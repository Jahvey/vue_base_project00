package com.cdgit.loan.contract.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.CrtTbPubConfig;
import com.cdgit.loan.contract.mapper.CrtTbPubConfigMapper;

@Service
@org.springframework.transaction.annotation.Transactional
public class CrtTbPubConfigServiceImpl {

	@Autowired
	CrtTbPubConfigMapper configMapper;
	
	public CrtTbPubConfig queryPubConfig(String cfgGroup, String cfgKey){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cfgGroup", cfgGroup);
		map.put("cfgKey", cfgKey);
		return configMapper.queryPubConfig(map);
	}
	
}
