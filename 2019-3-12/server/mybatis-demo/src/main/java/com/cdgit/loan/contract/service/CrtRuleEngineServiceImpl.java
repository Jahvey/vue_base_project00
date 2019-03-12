package com.cdgit.loan.contract.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.TbConContractInfo;
import com.cdgit.loan.contract.mapper.CrtJustServiceMapper;
import com.cdgit.loan.contract.mapper.CrtRuleEngineMapper;
import com.cdgit.loan.contract.mapper.TbConContractInfoMapper;

@Service
@org.springframework.transaction.annotation.Transactional
public class CrtRuleEngineServiceImpl {

	@Autowired
	CrtRuleEngineMapper ruleEngineMapper;
	
	@Autowired
	TbConContractInfoMapper conContractInfoMapper;
	
	@Autowired
	CrtJustServiceMapper justServiceMapper;
	
	/**
	 * 执行规则校验
	 * @param map
	 * @return
	 */
	public HashMap<String,Integer> checkRuleEngines(HashMap<String,String> map){
		String contractId = map.get("contractId");
		String amountDetailId = map.get("amountDetailId");
		
		Integer RLON_0001 = ruleEngineMapper.checkRLON_0001(contractId);
		Integer RCON_0027 = ruleEngineMapper.checkRCON_0027(contractId);
		Integer XFE_0004 = ruleEngineMapper.checkXFE_0004(contractId);
		Integer RCON_0014 = ruleEngineMapper.checkRCON_0014(contractId);
		Integer RCON_0026 = ruleEngineMapper.checkRCON_0026(amountDetailId);
		Integer RLON_0008 = ruleEngineMapper.checkRLON_0008(contractId);
		Integer RLON_0036 = ruleEngineMapper.checkRLON_0036(contractId);
		Integer RLON_0035 = ruleEngineMapper.checkRLON_0035(contractId);
		Integer RLON_0201 = ruleEngineMapper.checkRLON_0201(contractId);
		Integer RLON_0034 = ruleEngineMapper.checkRLON_0034(contractId);//targetDataList="1"
		Integer RLON_0028 = ruleEngineMapper.checkRLON_0028(contractId);
		Integer RLON_0033 = ruleEngineMapper.checkRLON_0033(contractId);
		
		HashMap<String,Integer> hashMap = new HashMap<>();
		
		hashMap.put("RLON_0001", RLON_0001);
		hashMap.put("RCON_0027", RCON_0027);
		hashMap.put("XFE_0004", XFE_0004);
		hashMap.put("RCON_0014", RCON_0014);
		hashMap.put("RCON_0026", RCON_0026);
		hashMap.put("RLON_0008", RLON_0008);
		hashMap.put("RLON_0036", RLON_0036);
		hashMap.put("RLON_0035", RLON_0035);
		hashMap.put("RLON_0201", RLON_0201);
		hashMap.put("RLON_0034", RLON_0034);
		hashMap.put("RLON_0028", RLON_0028);
		hashMap.put("RLON_0033", RLON_0033);
		
		return hashMap;
	}
	
	public String checkAnjie(String contractId){	//检查按揭
		
		String msg = "1";
		try {
			TbConContractInfo contractInfo = conContractInfoMapper.queryOneConContractInfoByContractId(contractId);
			//'02005001': '公积金委托贷款'
			if("02005001".equals(contractInfo.getProductType()) &&
				"02".equals(contractInfo.getGuarantyType()) ||
				"02,04".equals(contractInfo.getGuarantyType()) ||
				"04,02".equals(contractInfo.getGuarantyType())
					){
				msg = "0";//校验 36	RLON_0036？？？按揭存在未入库的押品？？
			}
			//个贷：'02002004': '个人商用房按揭贷款'
			if("02002004".equals(contractInfo.getProductType()) || 
					"02002005".equals(contractInfo.getProductType()) && 
					!"04,02".equals(contractInfo.getGuarantyType()) && 
					!"02,04".equals(contractInfo.getGuarantyType())
				){
				msg = "0";//校验 36
			}
			//二手房按揭贷款资金监管
			if("02002003".equals(contractInfo.getProductType())){
				String amountDetailId = contractInfo.getAmountDetailId();
				Map<String,String> map = new HashMap<>();
				map.put("contractId", contractId);
				map.put("amountDetailId", amountDetailId);
				List<HashMap<String,String>> list = justServiceMapper.getConXwAmountId(map);
				if(list != null && list.size() >0){
					HashMap<String,String> hashMap = list.get(0);
					String checkFlg = hashMap.get("CHECK_FLG");
					if("1".equals(checkFlg)){//校验存量房资金监管
						msg = "2";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
}
