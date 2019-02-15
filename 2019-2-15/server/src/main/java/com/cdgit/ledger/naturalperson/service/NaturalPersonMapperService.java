package com.cdgit.ledger.naturalperson.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.ledger.naturalperson.bean.GroupCorporationResult;
import com.cdgit.ledger.naturalperson.bean.GuarCustResult;
import com.cdgit.ledger.naturalperson.bean.InterbankCustResult;
import com.cdgit.ledger.naturalperson.bean.NaturealCust;
import com.cdgit.ledger.naturalperson.bean.PubCustResult;
import com.cdgit.ledger.naturalperson.bean.TbCsmFinancialInstitution;
import com.cdgit.ledger.naturalperson.bean.TbCsmParty;
import com.cdgit.ledger.naturalperson.bean.ThirdCustResult;
import com.cdgit.ledger.naturalperson.mapper.TbCsmNaturalPersonMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class NaturalPersonMapperService {
	
	@Autowired
	TbCsmNaturalPersonMapper tbCsmNaturalPersonMapper;
	//对公客户查询
	public PageInfo<PubCustResult> selectPubCust(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<PubCustResult> pubCustResultList = tbCsmNaturalPersonMapper.selectPubCust(map);
		PageInfo pageInfo = new PageInfo<>(pubCustResultList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//自然人客户查询
	public PageInfo<NaturealCust> selectNaturalPerson(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<NaturealCust> naturList = tbCsmNaturalPersonMapper.selectNaturalPerson(map);
		PageInfo pageInfo = new PageInfo<>(naturList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//联保客户查询
	public PageInfo<GuarCustResult> selectGuarCustInfo(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<GuarCustResult> guarCustList = tbCsmNaturalPersonMapper.selectJoinGuarCust(map);
		PageInfo pageInfo = new PageInfo<>(guarCustList, (Integer)map.get("pageSize"));
		return pageInfo;
	}
	//同业客户查询
	public PageInfo<InterbankCustResult> selectSametradeCust(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<InterbankCustResult> interbankCustResultList = tbCsmNaturalPersonMapper.selectSametradeCust(map);
		PageInfo pageInfo = new PageInfo<>(interbankCustResultList, (Integer)map.get("pageSize"));
		return pageInfo;	
	}
	
	//合作中介客户查询
	public PageInfo<ThirdCustResult> selectThirdCust(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ThirdCustResult> thirdCustResultList = tbCsmNaturalPersonMapper.selectThirdCust(map);
		PageInfo pageInfo = new PageInfo<>(thirdCustResultList, (Integer)map.get("pageSize"));
		return pageInfo;	
	}
	//集团客户查询
	public PageInfo<GroupCorporationResult> selectGroupCorporation(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<GroupCorporationResult> groupCorporationResultList = tbCsmNaturalPersonMapper.selectGroupCorporation(map);
		PageInfo pageInfo = new PageInfo<>(groupCorporationResultList, (Integer)map.get("pageSize"));
		return pageInfo;	
	}
}
