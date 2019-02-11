package com.cdgit.loan.contract.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.CrtTbBizPjxxApply;

/**
 * TB_BIZ_PJXX_APPLY:票据申请表
 * @author Administrator
 *
 */
@Mapper
public interface CrtTbBizPjxxApplyMapper {

	//根据条件查询多条票据信息
    List<CrtTbBizPjxxApply> queryPJXX(Map map);
    
    //批量更新票据申请表
    void updateAcceptorbank(List<CrtTbBizPjxxApply> list);

}