package com.cdgit.loan.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.user.bean.TbCsmCorporation;
import com.cdgit.loan.user.mapper.TbCsmCorporationMapper;

@Service
public class CsmCorporationServiceImpl {

	@Autowired TbCsmCorporationMapper bbCsmCorporationMapper;
	
	public TbCsmCorporation getPartyById(String partyId){
		TbCsmCorporation tbCsmCorporation = null;
		try {
			tbCsmCorporation = bbCsmCorporationMapper.selectByPrimaryKey(partyId);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			return tbCsmCorporation;
		}
	}
}
