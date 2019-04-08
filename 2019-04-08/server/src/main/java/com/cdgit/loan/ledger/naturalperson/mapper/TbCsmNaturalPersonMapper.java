package com.cdgit.loan.ledger.naturalperson.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.ledger.naturalperson.bean.GroupCorporationResult;
import com.cdgit.loan.ledger.naturalperson.bean.GuarCustResult;
import com.cdgit.loan.ledger.naturalperson.bean.InterbankCustResult;
import com.cdgit.loan.ledger.naturalperson.bean.NaturealCust;
import com.cdgit.loan.ledger.naturalperson.bean.PubCustResult;
import com.cdgit.loan.ledger.naturalperson.bean.TbCsmFinancialInstitution;
import com.cdgit.loan.ledger.naturalperson.bean.TbCsmParty;
import com.cdgit.loan.ledger.naturalperson.bean.ThirdCustResult;
@Mapper
public interface TbCsmNaturalPersonMapper {
	
	//对公客户查询列表
	List<PubCustResult> selectPubCust(Map map);
	//自然人客户查询列表
	List<NaturealCust> selectNaturalPerson(Map map);
	//联保客户查询
	List<GuarCustResult> selectJoinGuarCust(Map map);
    //同业客户查询
	List<InterbankCustResult> selectSametradeCust(Map map);
	//合作中介客户查询
	List<ThirdCustResult> selectThirdCust(Map map);
	//集团客户查询
	List<GroupCorporationResult> selectGroupCorporation(Map map);
	
}