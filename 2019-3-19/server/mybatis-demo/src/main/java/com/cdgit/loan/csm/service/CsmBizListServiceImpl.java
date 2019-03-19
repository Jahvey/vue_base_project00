/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.StringUtil;
import com.cdgit.loan.csm.bean.CsmBizListVo;
import com.cdgit.loan.csm.bean.CsmTbCrdApprove;
import com.cdgit.loan.csm.mapper.CsmBizListMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbCrdApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbCrdDetailApproveMapper;
import com.cdgit.loan.csm.po.TbBizApprovePo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmBizListServiceImpl {
	
	@Autowired
	CsmBizListMapper csmBizListMapper;
	@Autowired
	CsmTbCrdApproveMapper crdApproveMapper;
	@Autowired
	CsmTbBizApproveMapper csmTbBizApproveMapper;
	@Autowired
	CsmTbCrdDetailApproveMapper crdDetailApproveMapper;
	
	public Map<String, Object> getBizList(Integer pageNum, Integer pageSize, String partyId){
		Map<String, Object> map = new HashMap<>();
    	try {
    		PageHelper.startPage(pageNum,pageSize);
        	List<CsmBizListVo> list = csmBizListMapper.getBizList(partyId);
            PageInfo pageInfo = new PageInfo(list,pageSize);
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
	 * 重算额度
	 * 
	 * */
	public Map<String, Object> newly(String bizId) {
		Map<String, Object> map = new HashMap<>();
    	try {
    		CsmTbCrdApprove csmTbCrdApprove  = crdApproveMapper.getCrdCredit(bizId);
    		String statusCd;
    		if(csmTbCrdApprove!=null) {
    			statusCd = csmTbCrdApprove.getStatusCd();
    		}else {
    			statusCd = null;
    		}
    		if (statusCd == null) {
    			map.put("code", "201");
                map.put("msg", "statusCd为空，重算额度失败!");
    			return map;
    		}
    		if ("01".equals(statusCd)) {
    			updateCredit(bizId, csmTbCrdApprove);
    		} else {
    			abateCredit(bizId, statusCd);
    		}
          	map.put("code", "200");
            map.put("msg", "重算额度成功!");
		} catch (Exception e) {
			// TODO: handle exception
			map.put("code", "201");
            map.put("msg", "重算额度失败!");
            e.printStackTrace();
		} finally {
			return map; 
		}
	}
	
	public void updateCredit(String crdId, CsmTbCrdApprove csmTbCrdApprove) {
		String[] sonInfos = crdDetailApproveMapper.getCrdDtlIds(crdId);
		if (sonInfos != null && sonInfos.length > 0) {
			for (int i = 0; i < sonInfos.length; i++) {
				newly(sonInfos[i]);
			}
		}
		crdApproveMapper.updateCrdCredit(crdId);
		String[] bizIds = csmTbBizApproveMapper.getBizIds(crdId);
		if (bizIds != null && bizIds.length > 0) {
			for (int i = 0; i < bizIds.length; i++) {
				crdApproveMapper.updateCrdCredit(bizIds[i]);
			}
		}
	
	}

	public void abateCredit(String crdId, String statusCd) {
		if (statusCd == null ||StringUtil.contain(statusCd, new String[] { "01", "02", "03" })) {
			throw new RuntimeException("请传入正确的状态[" + statusCd + "]");
		}
		abateCreditMe(crdId, statusCd);
		String[] sonInfos = crdDetailApproveMapper.getCrdDtlIds(crdId);
		if (sonInfos == null || sonInfos.length == 0) {
			return;
		}
		// 半失效状态需要继续更新子节点数据
		// if (STATUS_ABATE.equals(statusCd)) {
		for (int i = 0; i < sonInfos.length; i++) {
			newly(sonInfos[i]);
		}
		String[] bizIds = csmTbBizApproveMapper.getBizIds(crdId);
		if (bizIds != null && bizIds.length > 0) {
			for (int i = 0; i < bizIds.length; i++) {
				// 额度明细会关联刷新用信明细状态，所以此处不需要级联刷新
				TbBizApprovePo biz = new TbBizApprovePo();
				biz.setApproveId(bizIds[i]);
				biz.setBecomeEffectiveMark(statusCd);
				csmTbBizApproveMapper.updateCsmTbBizApproveSelective(biz);
			}
		}
	}
	
	public void abateCreditMe(String crdId, String statusCd) {
		if (statusCd == null || "03".equals(statusCd)) {
			throw new RuntimeException("请传入正确的状态[" + statusCd + "]");
		}
		CsmTbCrdApprove crd = new CsmTbCrdApprove();
		crd.setCrdId(crdId);
		crd.setStatusCd(statusCd);
		crdApproveMapper.updateByPrimaryKeySelective(crd);
		// 总额度失效，级联失效明细额度
		String[] sonIds = crdDetailApproveMapper.getCrdDtlIds(crdId);
		for (int i = 0; i < sonIds.length; i++) {
			abateCredit(sonIds[i], statusCd);
		}
		// 存在一体化明细时，同时失效一体化明细
		String bizId = crdApproveMapper.getBizId(crdId);
		if (bizId != null) {
			abateCredit(bizId, statusCd); //失效
		}
	}
}
