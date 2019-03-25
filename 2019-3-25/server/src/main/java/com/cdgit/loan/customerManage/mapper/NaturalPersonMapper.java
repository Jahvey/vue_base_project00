package com.cdgit.loan.customerManage.mapper;

import java.util.List;
import java.util.Map;

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
   /**
    * 查询根据partyId查询客户（包括所有客户）
    * @param partyId
    * @return
    */
   Map<String, Object> findByPartyId(@Param("partyId")String partyId);
	/**
	 * 查询对公客户---借款人为自然人
	 * @param certType
	 * @param certNum
	 * @param partyName
	 * @param orgRegisterCd
	 * @param registrCd
	 * @param unifySocietyCreditNum
	 * @param legOrg
	 * @return
	 */
	List<Map<String, Object>> importbzrComCus(
			@Param("certType")String certType, 
			@Param("certNum")String certNum, 
			@Param("partyName")String partyName,
			@Param("orgRegisterCd")String orgRegisterCd,
			@Param("registrCd")String registrCd,
			@Param("unifySocietyCreditNum")String unifySocietyCreditNum, 
			@Param("legOrg")String legOrg);
	/**
	 * 查询自然人客户---借款人为自然人
	 * @param certType
	 * @param certNum
	 * @param partyName
	 * @param legOrg
	 * @return
	 */
	List<Map<String, Object>> importbzrNatureCus(@Param("certType")String certType, 
			@Param("certNum")String certNum,
			@Param("partyName")String partyName,
			@Param("legOrg")String legOrg);
	
}