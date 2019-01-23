package com.cdgit.ledger.naturalperson.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.ledger.naturalperson.bean.GroupCorporationResult;
import com.cdgit.ledger.naturalperson.bean.GuarCustResult;
import com.cdgit.ledger.naturalperson.bean.InterbankCustResult;
import com.cdgit.ledger.naturalperson.bean.NaturealCust;
import com.cdgit.ledger.naturalperson.bean.PubCustResult;
import com.cdgit.ledger.naturalperson.bean.TbCsmFinancialInstitution;
import com.cdgit.ledger.naturalperson.bean.TbCsmParty;
import com.cdgit.ledger.naturalperson.bean.ThirdCustResult;
import com.cdgit.ledger.naturalperson.service.NaturalPersonMapperService;
import com.cdgit.loan.mycustomer.message.PageBean;
import com.cdgit.loan.mycustomer.message.ResponseMsg;
import com.github.pagehelper.PageInfo;
@CrossOrigin
@RestController
@RequestMapping("/natural")
public class ChNaturalPersonController {
	
	@Autowired
	NaturalPersonMapperService naturalPersonMapperService;
	
	//对公客户查询
	@GetMapping("/queryPubCust")
	public PageBean queryPubCust(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgname",required=false) String orgname, 
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="unifySocietyCreditNum",required=false) String unifySocietyCreditNum,
			@RequestParam(value="corpCustomerTypeCd",required=false) String corpCustomerTypeCd,
			@RequestParam(value="registrCd",required=false) String registrCd,
			@RequestParam(value="middleCode",required=false) String middleCode,
			@RequestParam(value="orgRegisterCd",required=false) String orgRegisterCd,
			@RequestParam(value="thirdCustTypeCd",required=false) String thirdCustTypeCd){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("orgname", orgname);
		map.put("partyName", partyName);	
		map.put("unifySocietyCreditNum", unifySocietyCreditNum);
		map.put("corpCustomerTypeCd", corpCustomerTypeCd);
		map.put("registrCd", registrCd);
		map.put("middleCode", middleCode);
		map.put("orgRegisterCd", orgRegisterCd);
		map.put("thirdCustTypeCd", thirdCustTypeCd);
		PageInfo<PubCustResult> pubCustResultList=naturalPersonMapperService.selectPubCust(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(pubCustResultList.getTotal());
		pageBean.setData(pubCustResultList.getList());
		return pageBean;
	}
	//自然人客户查询
	@GetMapping("/queryNaturalPerson")
	public PageBean queryNaturalPerson(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="curUserNum",required=false) String curUserNum, 
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="isFarmer",required=false) String isFarmer,
			@RequestParam(value="middleCode",required=false) String middleCode,
			@RequestParam(value="userNum",required=false) String userNum,
			@RequestParam(value="orgNum",required=false) String orgNum){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("curUserNum", curUserNum);
		map.put("partyName", partyName);	
		map.put("certNum", certNum);
		map.put("certType", certType);
		map.put("isFarmer", isFarmer);
		map.put("middleCode", middleCode);
		map.put("userNum", userNum);
		map.put("orgNum", orgNum);
		PageInfo<NaturealCust> userList=naturalPersonMapperService.selectNaturalPerson(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(userList.getTotal());
		pageBean.setData(userList.getList());
		return pageBean;
	}
	//联保客户查询
	@GetMapping("/querGuarCust")
	public PageBean querGuarCustInfo(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum, 
			@RequestParam(value="partyId",required=false) String partyId,
			@RequestParam(value="relatedCustPartyId",required=false) String relatedCustPartyId,
			@RequestParam(value="unifySocietyCreditNum",required=false) String unifySocietyCreditNum,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="middleCode",required=false) String middleCode,
			@RequestParam(value="registerCode",required=false) String registerCode,
			@RequestParam(value="orgRegisterCd",required=false) String orgRegisterCd
			){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("orgNum", orgNum);
		map.put("partyId", partyId);
		map.put("relatedCustPartyId", relatedCustPartyId);
		map.put("unifySocietyCreditNum", unifySocietyCreditNum);
		map.put("certType", certType);
		map.put("certNum", certNum);
		map.put("middleCode", middleCode);
		map.put("registerCode", registerCode);
		map.put("orgRegisterCd", orgRegisterCd);
		PageInfo<GuarCustResult> guarCustList=naturalPersonMapperService.selectGuarCustInfo(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(guarCustList.getTotal());
		pageBean.setData(guarCustList.getList());
		return pageBean;
	}
	//同业客户查询
	@GetMapping("/querySametradeCust")
	public PageBean querySametradeCust(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum, 
			@RequestParam(value="areaType",required=false) String areaType,
			@RequestParam(value="financeEnterpriseType",required=false) String financeEnterpriseType,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="unifySocietyCreditNum",required=false) String unifySocietyCreditNum,
			@RequestParam(value="registerCode",required=false) String registerCode,
			@RequestParam(value="orgRegisterCd",required=false) String orgRegisterCd,
			@RequestParam(value="swiftBicNum",required=false) String swiftBicNum){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("orgNum", orgNum);
		map.put("areaType", areaType);
		map.put("financeEnterpriseType", financeEnterpriseType);
		map.put("partyName", partyName);
		map.put("unifySocietyCreditNum", unifySocietyCreditNum);
		map.put("registerCode", registerCode);
		map.put("orgRegisterCd", orgRegisterCd);
		map.put("swiftBicNum", swiftBicNum);
		PageInfo<InterbankCustResult> interbankCustResultList=naturalPersonMapperService.selectSametradeCust(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(interbankCustResultList.getTotal());
		pageBean.setData(interbankCustResultList.getList());
		return pageBean;
	}
	//合作中介查询
	@GetMapping("/queryThirdCust")
	public PageBean queryThirdCust(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum, 
			@RequestParam(value="corpCustomerTypeCd",required=false) String corpCustomerTypeCd,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="unifySocietyCreditNum",required=false) String unifySocietyCreditNum,
			@RequestParam(value="registrCd",required=false) String registrCd,
			@RequestParam(value="orgRegisterCd",required=false) String orgRegisterCd,
			@RequestParam(value="middelCode",required=false) String middelCode){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("orgNum", orgNum);
		map.put("corpCustomerTypeCd", corpCustomerTypeCd);
		map.put("partyName", partyName);
		map.put("unifySocietyCreditNum", unifySocietyCreditNum);
		map.put("registrCd", registrCd);
		map.put("orgRegisterCd", orgRegisterCd);
		map.put("middelCode", middelCode);
		PageInfo<ThirdCustResult> thirdCustResultList=naturalPersonMapperService.selectThirdCust(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(thirdCustResultList.getTotal());
		pageBean.setData(thirdCustResultList.getList());
		return pageBean;
	}
	
	//合作中介查询
	@GetMapping("/queryGroupCorporation")
	public PageBean queryGroupCorporation(
			@RequestParam(value="pageNum",required=true) int pageNum,
			@RequestParam(value="pageSize",required=true) int pageSize,
			@RequestParam(value="orgNum",required=false) String orgNum, 
			@RequestParam(value="partyNum",required=false) String partyNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="memberNum",required=false) String memberNum,
			@RequestParam(value="memberName",required=false) String memberName,
			@RequestParam(value="memberCertType",required=false) String memberCertType,
			@RequestParam(value="memberCertNum",required=false) String memberCertNum,
			@RequestParam(value="memberMiddelCode",required=false) String memberMiddelCode,
			@RequestParam(value="memberRegistrCd",required=false) String memberRegistrCd,
			@RequestParam(value="memberOrgRegisterCd",required=false) String memberOrgRegisterCd,
			@RequestParam(value="userNum",required=false) String userNum){
		Map map=new HashMap<String,Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("orgNum", orgNum);
		map.put("partyName", partyName);
		map.put("partyNum", partyNum);
		map.put("memberNum", memberNum);
		map.put("memberName", memberName);
		map.put("memberCertType", memberCertType);
		map.put("memberCertNum", memberCertNum);
		map.put("memberMiddelCode", memberMiddelCode);
		map.put("memberRegistrCd", memberRegistrCd);
		map.put("memberOrgRegisterCd", memberOrgRegisterCd);
		map.put("userNum", userNum);
		PageInfo<GroupCorporationResult> groupCorporationResultList=naturalPersonMapperService.selectGroupCorporation(map);
		PageBean pageBean=new PageBean();
		pageBean.setTotal(groupCorporationResultList.getTotal());
		pageBean.setData(groupCorporationResultList.getList());
		return pageBean;
	}
	
}
