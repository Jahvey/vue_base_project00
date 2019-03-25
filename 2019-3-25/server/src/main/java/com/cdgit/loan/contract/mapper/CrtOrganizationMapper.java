package com.cdgit.loan.contract.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbOrgAccRel;

/**
 * 	组织机构相关的mapper
 * @author Administrator
 *
 */
@Mapper
public interface CrtOrganizationMapper {

	//经办机构与会计机构相关
    List<CrtTbOrgAccRel> searchOrgAccRelList(Map map);

}