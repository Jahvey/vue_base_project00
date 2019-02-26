package com.cdgit.loan.customerManage.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.constants.Constant;
import com.cdgit.loan.common.util.DateUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.customerManage.bean.ManagementTeam;
import com.cdgit.loan.customerManage.bean.NaturalPerson;
import com.cdgit.loan.customerManage.bean.Party;
import com.cdgit.loan.customerManage.mapper.ManagementTeamMapper;
import com.cdgit.loan.customerManage.mapper.NaturalPersonMapper;
import com.cdgit.loan.customerManage.mapper.PartyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class NaturalPersonServiceImpl {
	
	@Autowired
	NaturalPersonMapper naturalPersonMapper;
	@Autowired
	PartyMapper partyMapper;
	@Autowired
	ManagementTeamMapper managementTeamMapper;
	
	private Date now = DateUtil.StrToDate(DateUtil.formatDateTime(new Date()));
	
	/**
     * 方法一  查询返回分页对象
     * <p>Title: findUser</p>  
     	第一个参数从第几页开始  第二个参数每页显示数量
     * <p>Description: </p>  
    
     * @return
     */
    public Map<String, Object> naturalPersonList(Integer pageNum, Integer pageSize,String partyNum, String partyName, String certType
        , String certNum, String isPotentialCust, String isFarmer, String phoneNumber, String unitAdress){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		PageHelper.startPage(pageNum,pageSize);
        	List<NaturalPerson> npList = naturalPersonMapper.naturalPersonList(partyNum, partyName, certType, certNum, isPotentialCust
        			, isFarmer, phoneNumber, unitAdress);
            PageInfo pageInfo = new PageInfo(npList,pageSize);
          	map.put("code", "200");
            map.put("msg", "查询成功!");
            map.put("data", pageInfo);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "查询失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    /**
     * 
     * 保存新增自然人
     * 
     * */
    public Map<String, Object> addNatural(NaturalPerson naturalPerson){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		//TODO 获取当前用户机构并保存  当前用户userNum和机构号码orgNum到管理团队   当前机构leg_org到party
    		//保存自然人信息
    		naturalPerson.setPartyId(UUIDGenerator.getUUID());
    		naturalPerson.setGenderCd(certNum(naturalPerson.getCertNum()).get("gender"));
    		naturalPerson.setBirthday(DateUtil.convertString2Date(certNum(naturalPerson.getCertNum()).get("birthday"), "yyyyMMdd"));
    		int back = naturalPersonMapper.insertSelective(naturalPerson);
            //保存参与人信息
            Party party = new Party();
            party.setPartyId(naturalPerson.getPartyId());
            party.setPartyNum(naturalPerson.getEcifPartyNum());
            party.setPartyTypeCd("02");
            party.setEcifPartyNum(naturalPerson.getEcifPartyNum());
            party.setIsPotentialCust(naturalPerson.getIsPotentialCust());
            party.setPartyName(naturalPerson.getPartyName());
            party.setCreateTime(now);
            int back2 =  partyMapper.insertSelective(party);
            ManagementTeam managementTeam = new ManagementTeam();
            managementTeam.setManagementTeamId(UUIDGenerator.getUUID());
            managementTeam.setUserNum("");
            managementTeam.setOrgNum("");
            managementTeam.setUserPlacingCd("01");
            managementTeam.setStatus("01");
            managementTeam.setPartyId(naturalPerson.getPartyId());
            managementTeam.setCreateTime(now);
            managementTeam.setUpdateTime(now);
            managementTeam.setPartyType("");
            int back3 = managementTeamMapper.insertSelective(managementTeam);
            if (back == 0 || back2 == 0 || back3==0) {
		        map.put("code", "201");
		        map.put("msg", "保存失败!");
			}else {
			    map.put("code", "200");
		        map.put("msg", "保存成功!");
		        map.put("partyId", naturalPerson.getPartyId());
			}
            //TODO 根据获取当前用户经办人及其所属管理团队 将该用户保存到该管理团队下
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "新增失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    /**
     * 根据partyId查询自然人及参与人信息
     * 
     * */
    public Map<String, Object> queryNaturalByPartyId(String partyId){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		NaturalPerson data = naturalPersonMapper.queryNaturalByPartyId(partyId);
		    map.put("code", "200");
	        map.put("msg", "查询成功!");
	        map.put("data", data);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "查询失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    /**
     * 更新自然人信息
     * 
     * */
    public Map<String, Object> editNatural(NaturalPerson naturalPerson){
    	Map<String, Object> map = new HashMap<>();
    	try {
    		naturalPerson.setUpdateTime(now);
    		int back = naturalPersonMapper.updateByPrimaryKeySelective(naturalPerson);
            //更新参与人信息
            Party party = new Party();
            party.setPartyId(naturalPerson.getPartyId());
            party.setPartyNum(naturalPerson.getEcifPartyNum());
            party.setPartyTypeCd("02");
            party.setEcifPartyNum(naturalPerson.getEcifPartyNum());
            party.setIsPotentialCust(naturalPerson.getIsPotentialCust());
            party.setPartyName(naturalPerson.getPartyName());
            party.setUpdateTime(now);;
            int back2 = partyMapper.updateByPrimaryKeySelective(party);
            ManagementTeam managementTeam = new ManagementTeam();
            managementTeam.setPartyId(naturalPerson.getPartyId());
            managementTeam.setUserNum("");
            managementTeam.setOrgNum("");     
            managementTeam.setUpdateTime(now);
            int back3 = managementTeamMapper.updateByPartyId(managementTeam);
            if (back == 0 || back2 == 0 || back3 == 0) {
		        map.put("code", "201");
		        map.put("msg", "修改失败!");
			}else {
			    map.put("code", "200");
		        map.put("msg", "修改成功!");
			}
            //TODO 根据获取当前用户经办人及其所属管理团队 将该用户保存到该管理团队下
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "修改失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
    }
    
    /**
     * 通过身份证号码，返回生日性别。
     * 
     * */
    public Map<String, String> certNum(String certNum){
		if (certNum.length() == 18) {
			Map<String, String> map = new HashMap<String, String>();
			String birthday = certNum.substring(6, 14);
			String gender = certNum.substring(14, 17);
			if (Integer.parseInt(gender) % 2 == 0) {
				gender = "2";
			} else {
				gender = "1";
			}
			map.put("birthday", birthday);
			map.put("gender", gender);
			return map;
		} else {
			Map<String, String> map = new HashMap<String, String>();
			String birthday = certNum.substring(6, 12);
			String gender = certNum.substring(12, 15);
			if (Integer.parseInt(gender) % 2 == 0) {
				gender = "2";
			} else {
				gender = "1";
			}
			map.put("birthday", DateUtil.convertDate2String(DateUtil.convertString2Date(birthday, "yyMMdd"), "yyyyMMdd"));
			map.put("gender", gender);
			return map;
		}

	}

	public Map<String, Object> selectCustomerAllByPartyTypeCd(Integer pageNum,Integer pageSize,
			String legOrg ,
			String partyTypeCd,String certType, 
			String certNum, String partyName,
			String orgRegisterCd, String registrCd, String unifySocietyCreditNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(partyTypeCd.equals(Constant.CUSTOMER_TYPE_NATURAL_PERSON)){//自然人
			PageHelper.startPage(pageNum,pageSize);
			List<Map<String, Object>> list = naturalPersonMapper.importbzrNatureCus(certType,certNum,partyName,legOrg);
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
			map.put("data", pageInfo);
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{//公司客户
			PageHelper.startPage(pageNum,pageSize);
			List<Map<String, Object>> list = naturalPersonMapper.importbzrComCus(certType,certNum,partyName,orgRegisterCd,registrCd,unifySocietyCreditNum,legOrg);
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list, pageSize);
			map.put("data", pageInfo);
			map.put("flag", "true");
			map.put("message", "操作成功!");
		}

		return map;
	}



}
