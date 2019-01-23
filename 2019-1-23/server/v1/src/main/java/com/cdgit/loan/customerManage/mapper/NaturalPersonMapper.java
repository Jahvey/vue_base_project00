package com.cdgit.loan.customerManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.customerManage.bean.NaturalPerson;

/**
 * @MapperScan("com.springms.cloud.mapper.**") 或者在每个 Mapper 接口文件上添加 @Mapper 也可以；

* <p>Title: UserMapper</p>  

* <p>Description: </p>  

* @author yuanweixiao  

* @date 2018年12月5日
 */
@Mapper
public interface NaturalPersonMapper {
	
   List<NaturalPerson> naturalPersonList(@Param("partyNum") String partyNum, @Param("partyName")String partyName
		   ,@Param("certType")String certType,@Param("certNum") String certNum,@Param("isPotentialCust") String isPotentialCust
		   ,@Param("isFarmer")String isFarmer,@Param("phoneNumber") String phoneNumber,@Param("unitAdress") String unitAdress);
   
   int insertSelective(NaturalPerson naturalPerson);
   
   int updateByPrimaryKeySelective(NaturalPerson naturalPerson);
   
   NaturalPerson queryNaturalByPartyId(String partyId);
}