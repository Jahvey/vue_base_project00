package com.cdgit.loan.customerManage.party.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.customerManage.party.bean.Party;
import com.cdgit.loan.customerManage.party.mapper.PartyMapper;

@Service
@Transactional
public class PartyServiceImpl {
	
	@Autowired
	PartyMapper partyMapper;
	
    /**
     * 
     * 保存参与人
     * 
     * */
    public Map<String, Object> addParty(Party party){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		party.setPartyTypeCd("02");
    		int back = partyMapper.insertSelective(party);
            if (back == 0) {
		        map.put("code", "201");
		        map.put("msg", "保存参与人失败!");
			}else {
			    map.put("code", "200");
		        map.put("msg", "保存参与人成功!");
			}
          	map.put("code", "200");
            map.put("msg", "保存参与人成功!");
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "保存参与人失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }

}
