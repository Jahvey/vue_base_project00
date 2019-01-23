package com.cdgit.loan.csm.gitUtils;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmCsmPubConfigMapper;
import com.cdgit.loan.csm.po.CsmPubConfigPo;

@Service
@Transactional
public class CommonUtils {
	
	@Autowired
	CsmCsmPubConfigMapper csmCsmPubConfigMapper;
	
	//获取配置表值
	public  String getDBConfigVal(String cfgGroup, String cfgKey) {
		String cfgValue = null;
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("cfgGroup", cfgGroup);
		hm.put("cfgKey", cfgKey);
		//TODO Object[] confs = DatabaseExt.queryByNamedSql(GitUtil.DEFAULT_DS_NAME, "com.bos.pub.common.queryPubConfig", hm);
		List<CsmPubConfigPo> confs=csmCsmPubConfigMapper.queryCsmPubConfig(hm);
		if (confs.size()== 1) {
			//hm = (HashMap<String, String>) confs[0];
			//cfgValue = hm.get("CFG_VALUE");
			cfgValue=confs.get(0).getCfgValue();
			System.err.println(">>【" + cfgGroup + "】配置参数表【" + cfgKey + "】值为【" + cfgValue + "】！");
		}
		if (confs.size() == 0 || cfgValue == null) {
			throw new RuntimeException("获取配置表值失败！【" + cfgGroup + "】【" + cfgKey + "】");
		}
		return cfgValue;
	}
	

}
