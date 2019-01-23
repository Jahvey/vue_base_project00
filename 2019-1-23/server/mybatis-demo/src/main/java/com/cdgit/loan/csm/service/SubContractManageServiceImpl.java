package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.OldContractListVo;
import com.cdgit.loan.csm.bean.OldDbListVo;
import com.cdgit.loan.csm.bean.CsmSubContractListVo;
import com.cdgit.loan.csm.mapper.SubContractManageMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class SubContractManageServiceImpl {

	@Autowired
	SubContractManageMapper subContractManageMapper;

	// 查询所有担保合同列表
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmSubContractListVo> findSubContractList(Map map) {
		// 引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
		List<CsmSubContractListVo> SubContractListVoQuery = subContractManageMapper.findSubContractList(map);
		PageInfo pageInfo = new PageInfo(SubContractListVoQuery, (Integer) map.get("pageSize"));

		return pageInfo;
	}

	// 获取原担保合同中 对应的押品信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<OldDbListVo> findOldDbList(Map map) {
		// 引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
		List<OldDbListVo> OldDbListVoQuery = subContractManageMapper.findOldDbList(map);
		PageInfo pageInfo = new PageInfo(OldDbListVoQuery, (Integer) map.get("pageSize"));

		return pageInfo;
	}

	// 查找原担保合同对应的主合同信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<OldContractListVo> findOldContractList(Map map) {
		// 引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
		List<OldContractListVo> OldContractListVoQuery = subContractManageMapper.findOldContractList(map);
		PageInfo pageInfo = new PageInfo(OldContractListVoQuery, (Integer) map.get("pageSize"));

		return pageInfo;
	}

}
