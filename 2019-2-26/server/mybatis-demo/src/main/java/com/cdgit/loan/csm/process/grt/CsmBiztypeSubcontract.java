/**
 * 
 */
package com.cdgit.loan.csm.process.grt;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.mapper.CsmBizApplyMapper;


/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("BiztypeSubcontract")
public class CsmBiztypeSubcontract {
	
	
	@Autowired
	CsmBizApplyMapper csmBizApplyMapper;

	
	
	
	
	
	
	
	
	
	//担保合同调整查询业务性质
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryBiztypeSubcontract")
	public String queryBiztypeSubcontract(String subcontractId){

		String bizType = null;
		String bizty = null;
		
//		Object[] bizDataObject = DatabaseExt.queryByNamedSql(GitUtil.DEFAULT_DS_NAME, "com.bos.bizApply.bizApply.queryBiztypeSubcontract", subcontractId);
//		if (null != bizDataObject && bizDataObject.length > 0) {
//			DataObject bizData = (DataObject) bizDataObject[0];
//			bizType = bizData.getString("BIZ_TYPE");
//		}
		List<HashMap<String, String>> bizDataObject = csmBizApplyMapper.queryBiztypeSubcontract(subcontractId);
		if (null != bizDataObject && bizDataObject.size() > 0) {
			HashMap<String,String> bizData =  bizDataObject.get(0);
			bizType = bizData.get("BIZ_TYPE");
		}
		if("01".equals(bizType)||"04".equals(bizType)){//单笔、个人
			bizty = "1";
		}else if("02".equals(bizType)){//综合授信
			bizty = "2";
		}
		return bizty;
		
		
	}
	

}
