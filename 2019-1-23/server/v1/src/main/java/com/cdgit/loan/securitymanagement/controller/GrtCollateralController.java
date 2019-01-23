package com.cdgit.loan.securitymanagement.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.securitymanagement.bean.GrtBill;
import com.cdgit.loan.securitymanagement.bean.GrtBondPledge;
import com.cdgit.loan.securitymanagement.bean.GrtBuildingProject;
import com.cdgit.loan.securitymanagement.bean.GrtChargingRightMortgage;
import com.cdgit.loan.securitymanagement.bean.GrtCollateral;
import com.cdgit.loan.securitymanagement.bean.GrtDeposit;
import com.cdgit.loan.securitymanagement.bean.GrtEarningsAccount;
import com.cdgit.loan.securitymanagement.bean.GrtFund;
import com.cdgit.loan.securitymanagement.bean.GrtGuaranteeSlip;
import com.cdgit.loan.securitymanagement.bean.GrtIntellPropertyRights;
import com.cdgit.loan.securitymanagement.bean.GrtLandManagementRight;
import com.cdgit.loan.securitymanagement.bean.GrtLandUseRight;
import com.cdgit.loan.securitymanagement.bean.GrtMachineEquipment;
import com.cdgit.loan.securitymanagement.bean.GrtMerchandise;
import com.cdgit.loan.securitymanagement.bean.GrtRealEstateDetail;
import com.cdgit.loan.securitymanagement.bean.GrtRealEstateMortgage;
import com.cdgit.loan.securitymanagement.bean.GrtReceivable;
import com.cdgit.loan.securitymanagement.bean.GrtStandardDepotImpawn;
import com.cdgit.loan.securitymanagement.bean.GrtStockPledge;
import com.cdgit.loan.securitymanagement.bean.GrtStockWarrantAssets;
import com.cdgit.loan.securitymanagement.bean.GrtTrafficCar;
import com.cdgit.loan.securitymanagement.bean.GrtTrafficOthers;
import com.cdgit.loan.securitymanagement.bean.GrtTrafficShip;
import com.cdgit.loan.securitymanagement.bean.GrtVehicleTypeMortgage;
import com.cdgit.loan.securitymanagement.bean.GrtWoodlandProperty;
import com.cdgit.loan.securitymanagement.service.GrtCollateralServiceImpl;

/**
 * 抵质押物controller
 * 说明：saveGrtCollateral会保存基本抵质押品信息，详细信息(房地产，在建工程，保单等)添加
 * 都在此controller中完成
 * @author wuyong
 * @date 2018.12.25
 *
 */
@RestController
@RequestMapping("/grtCollateral")
@CrossOrigin
public class GrtCollateralController {
	@Autowired
	private GrtCollateralServiceImpl grtCollateralServiceImpl;
	
	/**
	 * 保存基本的抵质押物信息
	 * @param params
	 * @return
	 */
	@PostMapping("/saveGrtCollateral")
	public Map<String, Object> saveGrtCollateral(
/*			@RequestParam(value="customerType",required=true)String customerType,
			@RequestParam(value="partyTypeCd",required=true)String partyTypeCd,
			@RequestParam(value="customerNum",required=true)String customerNum,
			@RequestParam(value="collateralName",required=true)String collateralName,
			@RequestParam(value="collateralTypeCd",required=true)String collateralTypeCd*/
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("customerType") ==null || m.get("partyTypeCd") ==null ||m.get("customerNum") ==null
						|| m.get("collateralName") ==null || m.get("collateralTypeCd") ==null
						|| m.get("dataCreatUserNum") ==null || m.get("dataCreatorOrgCd") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String customerType = m.get("customerType").toString();
				String partyTypeCd = m.get("partyTypeCd").toString();
				String customerNum = m.get("customerNum").toString();
				String collateralName = m.get("collateralName").toString();
				String collateralTypeCd = m.get("collateralTypeCd").toString();
				String dataCreatUserNum = m.get("dataCreatUserNum").toString();
				String dataCreatorOrgCd = m.get("dataCreatorOrgCd").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				GrtCollateral grtCollateral = new GrtCollateral();
				grtCollateral.setCustomerType(customerType);
				grtCollateral.setPartyTypeCd(partyTypeCd);
				grtCollateral.setCustomerNum(customerNum);
				grtCollateral.setCollateralName(collateralName);
				grtCollateral.setCollateralTypeCd(collateralTypeCd);
				grtCollateral.setDataCreatorOrgCd(dataCreatorOrgCd);
				grtCollateral.setDataCreatUserNum(dataCreatUserNum);
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setTimeMark(new Date());
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCollateralNum(UUIDGenerator.getUUID(10));
				grtCollateral.setGuarantyId(UUIDGenerator.getUUID());
				map = grtCollateralServiceImpl.saveGrtCollateral(grtCollateral);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	
	/**
	 * 查询的抵质押品信息所有
	 * @param params
	 * @return
	 */
	@GetMapping("/selectGrtCollateralAll")
	public Map<String, Object> selectGrtCollateralAll(
			@RequestParam(value="pageNum",required=true) Integer pageNum,
			@RequestParam(value="pageSize",required=true) Integer pageSize,
			@RequestParam(value="curUserNum",required=true) String userNum,
			@RequestParam(value="orgcode",required=true) String orgNum,
			@RequestParam(value="orderField",required=false) String orderField,
			@RequestParam(value="sort",required=false) String sort,
			@RequestParam(value="customerType",required=true) String customerType,
			@RequestParam(value="partyNum",required=false) String partyNum,
			@RequestParam(value="partyName",required=false) String partyName,
			@RequestParam(value="certType",required=false) String certType,
			@RequestParam(value="certNum",required=false) String certNum,
			@RequestParam(value="collateralTypeCd",required=false) String collateralTypeCd,
			@RequestParam(value="collateralName",required=false) String collateralName,
			@RequestParam(value="isFarmer",required=false) String isFarmer,
			@RequestParam(value="phoneNumber",required=false) String phoneNumber
			){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			map=grtCollateralServiceImpl.selectGrtCollateralAll(pageNum,pageSize,userNum,orgNum,orderField,sort
					,customerType,partyNum,partyName,certType,certNum,collateralTypeCd,collateralName,isFarmer,phoneNumber);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "服务器出错啦，请联系开发者!");
			System.out.println(e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 通过主键删除抵质押品信息
	 * @param params
	 * @return
	 */
	@GetMapping("/deleteGrtCollateralById")
	public Map<String, Object> deleteGrtCollateralById(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			map=grtCollateralServiceImpl.deleteGrtCollateralById(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "服务器出错啦，请联系开发者!");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 通过批量删除抵质押品信息 
	 * TODO 未完成
	 * @param params
	 * @return
	 */
	@GetMapping("/deleteGrtCollateralBatch")
	public Map<String, Object> deleteGrtCollateralBatch(
			@RequestParam(required=true) String[] ids
			){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			/*for (String string : guarantyId) {
				System.out.println(string);
			}*/
			map=grtCollateralServiceImpl.deleteGrtCollateralBatch(ids);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "服务器出错啦，请联系开发者!");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 更新存单以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateGrtDepositAndGrtCollateral")
	public Map<String, Object> updateGrtDepositAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						|| m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("depositReceiptNum") ==null || m.get("depositType") ==null
						|| m.get("drCurrency") ==null || m.get("amt") ==null
						|| m.get("accountNum") ==null || m.get("depositTerm") ==null
						|| m.get("startDate") ==null || m.get("expireDate") ==null
						|| m.get("openBank") ==null || m.get("stopPaymentInd") ==null
						|| m.get("commonAssetsInd") ==null || m.get("otherNote") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				String guarantyId = m.get("guarantyId").toString();
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String otherNote = m.get("otherNote").toString();
				String depositReceiptNum = m.get("depositReceiptNum").toString();
				String depositType = m.get("depositType").toString();
				String drCurrency = m.get("drCurrency").toString();
				String amt = m.get("amt").toString();
				String accountNum = m.get("accountNum").toString();
				String depositTerm = m.get("depositTerm").toString();
				String startDate = m.get("startDate").toString();
				String expireDate = m.get("expireDate").toString();
				String openBank = m.get("openBank").toString();
				String stopPaymentInd = m.get("stopPaymentInd").toString();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//创建抵质押物
				GrtCollateral grtCollateral = new GrtCollateral();
				grtCollateral.setGuarantyId(guarantyId);
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//创建存单
				GrtDeposit grtDeposit = new GrtDeposit();
				grtDeposit.setGuarantyId(guarantyId);
				grtDeposit.setDepositReceiptNum(depositReceiptNum);
				grtDeposit.setAmt(new BigDecimal(amt));
				grtDeposit.setDepositTerm(new BigDecimal(depositTerm));
				grtDeposit.setDepositType(depositType);
				grtDeposit.setCurrencyCd(drCurrency);
				grtDeposit.setAccountNum(accountNum);
				grtDeposit.setStartDate(format.parse(startDate));
				grtDeposit.setExpireDate(format.parse(expireDate));
				grtDeposit.setOpenBank(openBank);
				grtDeposit.setStopPaymentInd(stopPaymentInd);
				
				map = grtCollateralServiceImpl.updateGrtDepositAndGrtCollateral(grtCollateral,grtDeposit);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	/**
	 * 更新在建工程以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateBuildingProjectAndGrtCollateral")
	public Map<String, Object> updateBuildingProjectAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						|| m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null 
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//房地产类型信息
						|| m.get("utilizationType") ==null || m.get("cityLocationInd") ==null
						|| m.get("buildingLocation") ==null || m.get("cashCapacity") ==null
						|| m.get("totleFloor") ==null || m.get("landArea") ==null
						|| m.get("constructedDate") ==null || m.get("landAcquiringWayCd") ==null
						|| m.get("houseLicenseInd") ==null || m.get("landLicenseInd") ==null
						|| m.get("buildingStructure") ==null 
						//在建工程信息
						|| m.get("projectPurpose") ==null || m.get("buildedArea") ==null
						|| m.get("investBudget") ==null || m.get("proOriDesignSizeCd") ==null
						|| m.get("mortgageArea") ==null || m.get("proProcess") ==null
						|| m.get("finishedMoney") ==null || m.get("projectPresentStatus") ==null
						|| m.get("isPaymentArrears") ==null || m.get("isPaymentArrears") ==null
						|| m.get("isHasLandLicense") ==null || m.get("buildUnit") ==null
						|| m.get("startWorkLicInd") ==null || m.get("isPaymentLandTransfer") ==null
						|| m.get("proPlanLicInd") ==null
						
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				//创建抵质押物  也是公共信息
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//房产类型信息
				GrtRealEstateMortgage grtRealEstateMortgage = new GrtRealEstateMortgage();
				String utilizationType = m.get("utilizationType").toString();
				String cityLocationInd = m.get("cityLocationInd").toString();
				String buildingLocation = m.get("buildingLocation").toString();
				String cashCapacity = m.get("cashCapacity").toString();
				String totleFloor = m.get("totleFloor").toString();
				String landArea = m.get("landArea").toString();
				String constructedDate = m.get("constructedDate").toString();
				String landAcquiringWayCd = m.get("landAcquiringWayCd").toString();
				String houseLicenseInd = m.get("houseLicenseInd").toString();
				String landLicenseInd = m.get("landLicenseInd").toString();
				String buildingStructure = m.get("buildingStructure").toString();
				String houseLicenseType = m.get("houseLicenseType")==null ? null : m.get("houseLicenseType").toString();
				String houseLicenseNum = m.get("houseLicenseNum")==null ? null : m.get("houseLicenseNum").toString();
				String houseLicenseOwner = m.get("houseLicenseOwner")==null ? null : m.get("houseLicenseOwner").toString();
				String landLicenseDate = m.get("landLicenseDate")==null ? null : m.get("landLicenseDate").toString();
				String landLicenseType = m.get("landLicenseType")==null ? null : m.get("landLicenseType").toString();
				String landLicenseNum = m.get("landLicenseNum")==null ? null : m.get("landLicenseNum").toString();
				String landLicenseOwner = m.get("landLicenseOwner")==null ? null : m.get("landLicenseOwner").toString();
				String landCharacter = m.get("landCharacter")==null ? null : m.get("landCharacter").toString();
				String landUseType = m.get("landUseType")==null ? null : m.get("landUseType").toString();
				grtRealEstateMortgage.setBuildingStructure(buildingStructure);
				grtRealEstateMortgage.setUtilizationType(utilizationType);
				grtRealEstateMortgage.setCityLocationInd(cityLocationInd);
				grtRealEstateMortgage.setBuildingLocation(buildingLocation);
				grtRealEstateMortgage.setCashCapacity(cashCapacity);
				grtRealEstateMortgage.setTotleFloor(new BigDecimal(totleFloor));
				grtRealEstateMortgage.setLandArea(new BigDecimal(landArea));
				grtRealEstateMortgage.setConstructedDate(format.parse(constructedDate));
				grtRealEstateMortgage.setLandAcquiringWayCd(landAcquiringWayCd);
				grtRealEstateMortgage.setHouseLicenseInd(houseLicenseInd);
				grtRealEstateMortgage.setLandLicenseInd(landLicenseInd);
				grtRealEstateMortgage.setHouseLicenseType(houseLicenseType);
				grtRealEstateMortgage.setHouseLicenseNum(houseLicenseNum);
				grtRealEstateMortgage.setHouseLicenseOwner(houseLicenseOwner);
				if(landLicenseDate!=null && !landLicenseDate.equals("")){
					grtRealEstateMortgage.setLandLicenseDate(format.parse(landLicenseDate));
				}
				grtRealEstateMortgage.setLandLicenseType(landLicenseType);
				grtRealEstateMortgage.setLandLicenseNum(landLicenseNum);
				grtRealEstateMortgage.setLandLicenseOwner(landLicenseOwner);
				grtRealEstateMortgage.setLandCharacter(landCharacter);
				grtRealEstateMortgage.setLandUseType(landUseType);
				grtRealEstateMortgage.setGuarantyId(guarantyId);
				//在建工程信息
				GrtBuildingProject grtBuildingProject = new GrtBuildingProject();
				String projectPurpose = m.get("projectPurpose").toString();
				String buildedArea = m.get("buildedArea").toString();
				String investBudget = m.get("investBudget").toString();
				String proOriDesignSizeCd = m.get("proOriDesignSizeCd").toString();
				String mortgageArea = m.get("mortgageArea").toString();
				String proProcess = m.get("proProcess").toString();
				String finishedMoney = m.get("finishedMoney").toString();
				String projectPresentStatus = m.get("projectPresentStatus").toString();
				String isPaymentArrears = m.get("isPaymentArrears").toString();
				String isHasLandLicense = m.get("isHasLandLicense").toString();
				String buildUnit = m.get("buildUnit").toString();
				String startWorkLicInd = m.get("startWorkLicInd").toString();
				String proPlanLicInd = m.get("proPlanLicInd").toString();
				String isPaymentLandTransfer = m.get("isPaymentLandTransfer").toString();
				String arrearsAmt = m.get("arrearsAmt")==null ? null : m.get("arrearsAmt").toString();
				grtBuildingProject.setProjectPurpose(projectPurpose);
				grtBuildingProject.setBuildedArea(new BigDecimal(buildedArea));
				grtBuildingProject.setInvestBudget(new BigDecimal(investBudget));
				grtBuildingProject.setProOriDesignSizeCd(proOriDesignSizeCd);
				grtBuildingProject.setMortgageArea(new BigDecimal(mortgageArea));
				grtBuildingProject.setProProcess(proProcess);
				grtBuildingProject.setFinishedMoney(new BigDecimal(finishedMoney));
				grtBuildingProject.setProjectPresentStatus(projectPresentStatus);
				grtBuildingProject.setIsPaymentArrears(isPaymentArrears);
				grtBuildingProject.setIsHasLandLicense(isHasLandLicense);
				grtBuildingProject.setBuildUnit(buildUnit);
				grtBuildingProject.setStartWorkLicInd(startWorkLicInd);
				grtBuildingProject.setIsPaymentLandTransfer(isPaymentLandTransfer);
				grtBuildingProject.setGuarantyId(guarantyId);
				grtBuildingProject.setProPlanLicInd(proPlanLicInd);
				if(arrearsAmt!=null && !arrearsAmt.equals("")){
					grtBuildingProject.setArrearsAmt(new BigDecimal(arrearsAmt));
				}
				map = grtCollateralServiceImpl.updateBuildingProjectAndGrtCollateral(grtCollateral,grtRealEstateMortgage,grtBuildingProject);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	/**
	 * 更新房地产以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateRealEstateAndGrtCollateral")
	public Map<String, Object> updateRealEstateAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null 
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//房地产类型信息
						|| m.get("utilizationType") ==null || m.get("cityLocationInd") ==null
						|| m.get("buildingLocation") ==null || m.get("cashCapacity") ==null
						|| m.get("totleFloor") ==null || m.get("landArea") ==null
						|| m.get("constructedDate") ==null || m.get("landAcquiringWayCd") ==null
						|| m.get("houseLicenseInd") ==null || m.get("landLicenseInd") ==null
						|| m.get("buildAllArea") ==null || m.get("isLandMortgage") ==null
						//房地产信息
						|| m.get("floor") ==null 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				//创建抵质押物  也是公共信息
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//房产类型信息
				GrtRealEstateMortgage grtRealEstateMortgage = new GrtRealEstateMortgage();
				String utilizationType = m.get("utilizationType").toString();
				String cityLocationInd = m.get("cityLocationInd").toString();
				String buildingLocation = m.get("buildingLocation").toString();
				String cashCapacity = m.get("cashCapacity").toString();
				String totleFloor = m.get("totleFloor").toString();
				String landArea = m.get("landArea").toString();
				String constructedDate = m.get("constructedDate").toString();
				String landAcquiringWayCd = m.get("landAcquiringWayCd").toString();
				String houseLicenseInd = m.get("houseLicenseInd").toString();
				String landLicenseInd = m.get("landLicenseInd").toString();
				String buildAllArea = m.get("buildAllArea").toString();
				String isLandMortgage = m.get("isLandMortgage").toString();
				String houseLicenseType = m.get("houseLicenseType")==null ? null : m.get("houseLicenseType").toString();
				String houseLicenseNum = m.get("houseLicenseNum")==null ? null : m.get("houseLicenseNum").toString();
				String houseLicenseOwner = m.get("houseLicenseOwner")==null ? null : m.get("houseLicenseOwner").toString();
				String landLicenseDate = m.get("landLicenseDate")==null ? null : m.get("landLicenseDate").toString();
				String landLicenseType = m.get("landLicenseType")==null ? null : m.get("landLicenseType").toString();
				String landLicenseNum = m.get("landLicenseNum")==null ? null : m.get("landLicenseNum").toString();
				String landLicenseOwner = m.get("landLicenseOwner")==null ? null : m.get("landLicenseOwner").toString();
				String landCharacter = m.get("landCharacter")==null ? null : m.get("landCharacter").toString();
				String landUseType = m.get("landUseType")==null ? null : m.get("landUseType").toString();
				String buildingStructure = m.get("buildingStructure")==null ? null : m.get("buildingStructure").toString();
				String assetLife = m.get("assetLife")==null ? null : m.get("assetLife").toString();
				grtRealEstateMortgage.setBuildingStructure(buildingStructure);
				grtRealEstateMortgage.setUtilizationType(utilizationType);
				grtRealEstateMortgage.setCityLocationInd(cityLocationInd);
				grtRealEstateMortgage.setBuildingLocation(buildingLocation);
				grtRealEstateMortgage.setCashCapacity(cashCapacity);
				grtRealEstateMortgage.setTotleFloor(new BigDecimal(totleFloor));
				grtRealEstateMortgage.setLandArea(new BigDecimal(landArea));
				grtRealEstateMortgage.setConstructedDate(format.parse(constructedDate));
				grtRealEstateMortgage.setLandAcquiringWayCd(landAcquiringWayCd);
				grtRealEstateMortgage.setHouseLicenseInd(houseLicenseInd);
				grtRealEstateMortgage.setLandLicenseInd(landLicenseInd);
				grtRealEstateMortgage.setHouseLicenseType(houseLicenseType);
				grtRealEstateMortgage.setHouseLicenseNum(houseLicenseNum);
				grtRealEstateMortgage.setHouseLicenseOwner(houseLicenseOwner);
				if(landLicenseDate!=null && !landLicenseDate.equals("")){
					grtRealEstateMortgage.setLandLicenseDate(format.parse(landLicenseDate));
				}
				grtRealEstateMortgage.setLandLicenseType(landLicenseType);
				grtRealEstateMortgage.setLandLicenseNum(landLicenseNum);
				grtRealEstateMortgage.setLandLicenseOwner(landLicenseOwner);
				grtRealEstateMortgage.setLandCharacter(landCharacter);
				grtRealEstateMortgage.setLandUseType(landUseType);
				grtRealEstateMortgage.setGuarantyId(guarantyId);
				grtRealEstateMortgage.setBuildAllArea(new BigDecimal(buildAllArea));
				grtRealEstateMortgage.setAssetLife(new BigDecimal(assetLife));
				grtRealEstateMortgage.setIsLandMortgage(isLandMortgage);
				//房产其他信息
				GrtRealEstateDetail grtRealEstateDetail = new GrtRealEstateDetail();
				String floor = m.get("floor").toString();
				String buildingNum = m.get("buildingNum")==null ? null : m.get("buildingNum").toString();
				String roomNum = m.get("roomNum")==null ? null : m.get("roomNum").toString();
				String floorHeight = m.get("floorHeight")==null ? null : m.get("floorHeight").toString();
				String courtArea = m.get("courtArea")==null ? null : m.get("courtArea").toString();
				String manageStatus = m.get("manageStatus")==null ? null : m.get("manageStatus").toString();
				String roomUser = m.get("roomUser")==null ? null : m.get("roomUser").toString();
				String direction = m.get("direction")==null ? null : m.get("direction").toString();
				String houseModel = m.get("houseModel")==null ? null : m.get("houseModel").toString();
				String fitmentDegree = m.get("fitmentDegree")==null ? null : m.get("fitmentDegree").toString();
				String selfCarbarnInd = m.get("selfCarbarnInd")==null ? null : m.get("selfCarbarnInd").toString();
				grtRealEstateDetail.setFloor(floor);
				grtRealEstateDetail.setBuildingNum(buildingNum);
				grtRealEstateDetail.setRoomNum(roomNum);
				grtRealEstateDetail.setFloorHeight(new BigDecimal(floorHeight));
				grtRealEstateDetail.setCourtArea(new BigDecimal(courtArea));
				grtRealEstateDetail.setManageStatus(manageStatus);
				grtRealEstateDetail.setRoomUser(roomUser);
				grtRealEstateDetail.setDirection(direction);
				grtRealEstateDetail.setHouseModel(houseModel);
				grtRealEstateDetail.setFitmentDegree(fitmentDegree);
				grtRealEstateDetail.setSelfCarbarnInd(selfCarbarnInd);
				grtRealEstateDetail.setGuarantyId(guarantyId);
				map = grtCollateralServiceImpl.updateRealEstateAndGrtCollateral(grtCollateral,grtRealEstateMortgage,grtRealEstateDetail);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	
	/**
	 * 更新机动车以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateTrafficCarAndGrtCollateral")
	public Map<String, Object> updateTrafficCarAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//机动车信息
						|| m.get("vehicleName") ==null || m.get("carCardNum") ==null
						|| m.get("engineNum") ==null || m.get("frameworkNum") ==null
						|| m.get("oriPurchasePrice") ==null || m.get("dirverLicenseInd") ==null
						|| m.get("hangDate") ==null || m.get("usedYear") ==null
						|| m.get("trafficCurrencyCd") ==null || m.get("carBrand") ==null
						|| m.get("carType") ==null || m.get("producedDate") ==null
						|| m.get("purchaseYear") ==null || m.get("carAge") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//机动车信息 保存了两张表，一张机动车表，一张交通运输设备表
				//机动车信息
				GrtTrafficCar grtTrafficCar = new GrtTrafficCar();
				String carCardNum = m.get("carCardNum").toString();
				String frameworkNum = m.get("frameworkNum").toString();
				String oriPurchasePrice = m.get("oriPurchasePrice").toString();
				String dirverLicenseInd = m.get("dirverLicenseInd").toString();
				String hangDate = m.get("hangDate").toString();
				String carType = m.get("carType").toString();
				String producedDate = m.get("producedDate").toString();
				String color = m.get("color")==null ? null : m.get("color").toString();
				String fuel = m.get("fuel")==null ? null : m.get("fuel").toString();
				String licenseNum = m.get("licenseNum")==null ? null : m.get("licenseNum").toString();
				String licenseDepartment = m.get("licenseDepartment")==null ? null : m.get("licenseDepartment").toString();
				String runnedKm = m.get("runnedKm")==null ? null : m.get("runnedKm").toString();
				String registerAddress = m.get("registerAddress")==null ? null : m.get("registerAddress").toString();
				String licenseOwner = m.get("licenseOwner")==null ? null : m.get("licenseOwner").toString();
				String coverChargeCertInd = m.get("coverChargeCertInd")==null ? null : m.get("coverChargeCertInd").toString();
				String carryLicenseInd = m.get("carryLicenseInd")==null ? null : m.get("carryLicenseInd").toString();
				String invoiceNo = m.get("invoiceNo")==null ? null : m.get("invoiceNo").toString();
				grtTrafficCar.setGuarantyId(guarantyId);
				grtTrafficCar.setCarCardNum(carCardNum);
				grtTrafficCar.setFrameworkNum(frameworkNum);
				grtTrafficCar.setOriPurchasePrice(new BigDecimal(oriPurchasePrice));
				grtTrafficCar.setDirverLicenseInd(dirverLicenseInd);
				grtTrafficCar.setHangDate(format.parse(hangDate));
				grtTrafficCar.setCarType(carType);
				grtTrafficCar.setProducedDate(format.parse(producedDate));
				grtTrafficCar.setColor(color);
				grtTrafficCar.setFuel(fuel);
				grtTrafficCar.setLicenseNum(licenseNum);
				grtTrafficCar.setLicenseDepartment(licenseDepartment);
				if(runnedKm!=null){
					grtTrafficCar.setRunnedKm(new BigDecimal(runnedKm));
				}
				grtTrafficCar.setRegisterAddress(registerAddress);
				grtTrafficCar.setLicenseOwner(licenseOwner);
				grtTrafficCar.setCoverChargeCertInd(coverChargeCertInd);
				grtTrafficCar.setInvoiceNo(invoiceNo);
				grtTrafficCar.setCarryLicenseInd(carryLicenseInd);
				//交通运输设备信息
				GrtVehicleTypeMortgage grtVehicleTypeMortgage = new GrtVehicleTypeMortgage();
				String vehicleName = m.get("vehicleName").toString();
				String engineNum = m.get("engineNum").toString();
				String trafficCurrencyCd = m.get("trafficCurrencyCd").toString();
				String usedYear = m.get("usedYear").toString();
				String carBrand = m.get("carBrand").toString();
				String purchaseYear = m.get("purchaseYear").toString();
				String carAge = m.get("carAge").toString();
				String manufacturingCompany = m.get("manufacturingCompany")==null ? null : m.get("manufacturingCompany").toString();
				String rejectYear = m.get("rejectYear")==null ? null : m.get("rejectYear").toString();
				String troubleRecords = m.get("troubleRecords")==null ? null : m.get("troubleRecords").toString();
				grtVehicleTypeMortgage.setGuarantyId(guarantyId);
				grtVehicleTypeMortgage.setVehicleName(vehicleName);
				grtVehicleTypeMortgage.setEngineNum(engineNum);
				grtVehicleTypeMortgage.setTrafficCurrencyCd(trafficCurrencyCd);
				grtVehicleTypeMortgage.setUsedYear(new BigDecimal(usedYear));
				grtVehicleTypeMortgage.setCarBrand(carBrand);
				grtVehicleTypeMortgage.setPurchaseYear(format.parse(purchaseYear));
				grtVehicleTypeMortgage.setCarAge(new BigDecimal(carAge));
				grtVehicleTypeMortgage.setManufacturingCompany(manufacturingCompany);
				grtVehicleTypeMortgage.setCarType(carType);
				if(rejectYear!=null && !rejectYear.equals("")){
					grtVehicleTypeMortgage.setRejectYear(format.parse(rejectYear));
				}
				grtVehicleTypeMortgage.setTroubleRecords(troubleRecords);
				map = grtCollateralServiceImpl.updateTrafficCarAndGrtCollateral(grtCollateral,grtVehicleTypeMortgage,grtTrafficCar);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	/**
	 * 更新船舶以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateShipAndGrtCollateral")
	public Map<String, Object> updateShipAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						|| m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//船舶信息
						|| m.get("manufacturingCompany") ==null || m.get("manufacturingYear") ==null
						|| m.get("modelStyle") ==null || m.get("displacement") ==null
						|| m.get("seaworthinessCertificateInd") ==null 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				String manufacturingCompany =  m.get("manufacturingCompany").toString();
				String vehicleName = m.get("vehicleName")==null ? null : m.get("vehicleName").toString();
				String troubleRecords = m.get("troubleRecords")==null ? null : m.get("troubleRecords").toString();
				String manufacturingYear =  m.get("manufacturingYear").toString();
				String modelStyle =  m.get("modelStyle").toString();
				String vehicleLicenseNum = m.get("vehicleLicenseNum")==null ? null : m.get("vehicleLicenseNum").toString();
				String carryingCapacity = m.get("carryingCapacity")==null ? null : m.get("carryingCapacity").toString();
				String power = m.get("power")==null ? null : m.get("power").toString();
				String powerUnitCd = m.get("powerUnitCd")==null ? null : m.get("powerUnitCd").toString();
				String manufacturingPlace = m.get("manufacturingPlace")==null ? null : m.get("manufacturingPlace").toString();
				String bigRepairTimes = m.get("bigRepairTimes")==null ? null : m.get("bigRepairTimes").toString();
				String usedYears = m.get("usedYears")==null ? null : m.get("usedYears").toString();
				//-------------------------ship字段
				String displacement =  m.get("displacement").toString();
				String seaworthinessCertificateInd =  m.get("seaworthinessCertificateInd").toString();
				String shipNum = m.get("shipNum")==null ? null : m.get("shipNum").toString();
				String engineType = m.get("engineType")==null ? null : m.get("engineType").toString();
				String fuel = m.get("fuel")==null ? null : m.get("fuel").toString();
				String fuelLabelNo = m.get("fuelLabelNo")==null ? null : m.get("fuelLabelNo").toString();
				String totalTon = m.get("totalTon")==null ? null : m.get("totalTon").toString();
				String seaworthinessCertificateNum = m.get("seaworthinessCertificateNum")==null ? null : m.get("seaworthinessCertificateNum").toString();
				String seaworthinessCertificateDate = m.get("seaworthinessCertificateDate")==null ? null : m.get("seaworthinessCertificateDate").toString();
				String registerAddress = m.get("registerAddress")==null ? null : m.get("registerAddress").toString();
				String insuranceDate = m.get("insuranceDate")==null ? null : m.get("insuranceDate").toString();
				String oriShipOwner = m.get("oriShipOwner")==null ? null : m.get("oriShipOwner").toString();
				String oriPurchasePrice = m.get("oriPurchasePrice")==null ? null : m.get("oriPurchasePrice").toString();
				String runnedKm = m.get("runnedKm")==null ? null : m.get("runnedKm").toString();
				
				GrtVehicleTypeMortgage grtVehicleTypeMortgage = new GrtVehicleTypeMortgage();
				grtVehicleTypeMortgage.setGuarantyId(guarantyId);
				grtVehicleTypeMortgage.setVehicleName(vehicleName);
				grtVehicleTypeMortgage.setManufacturingCompany(manufacturingCompany);
				grtVehicleTypeMortgage.setTroubleRecords(troubleRecords);
				grtVehicleTypeMortgage.setManufacturingYear(manufacturingYear);
				grtVehicleTypeMortgage.setModelStyle(modelStyle);
				grtVehicleTypeMortgage.setVehicleLicenseNum(vehicleLicenseNum);
				if(carryingCapacity!=null && !carryingCapacity.equals("")){
					grtVehicleTypeMortgage.setCarryingCapacity(new BigDecimal(carryingCapacity));
				}
				if(power!=null && !power.equals("")){
					grtVehicleTypeMortgage.setPower(new BigDecimal(power));
				}
				grtVehicleTypeMortgage.setPowerUnitCd(powerUnitCd);
				grtVehicleTypeMortgage.setManufacturingPlace(manufacturingPlace);
				grtVehicleTypeMortgage.setBigRepairTimes(bigRepairTimes);
				if(usedYears!=null && !usedYears.equals("")){
					grtVehicleTypeMortgage.setUsedYear(new BigDecimal(usedYears));
				}
				//船舶表
				GrtTrafficShip grtTrafficShip = new GrtTrafficShip();
				grtTrafficShip.setGuarantyId(guarantyId);
				if(displacement!=null && !displacement.equals("")){
					grtTrafficShip.setDisplacement(new BigDecimal(displacement));
				}
				grtTrafficShip.setSeaworthinessCertificateInd(seaworthinessCertificateInd);
				grtTrafficShip.setSeaworthinessCertificateNum(seaworthinessCertificateNum);
				if(seaworthinessCertificateDate!=null && !seaworthinessCertificateDate.equals("")){
					grtTrafficShip.setSeaworthinessCertificateDate(format.parse(seaworthinessCertificateDate));
				}
				grtTrafficShip.setShipNum(shipNum);
				grtTrafficShip.setFuel(fuel);
				grtTrafficShip.setFuelLabelNo(fuelLabelNo);
				grtTrafficShip.setRegisterAddress(registerAddress);
				if(runnedKm!=null && !runnedKm.equals("")){
					grtTrafficShip.setRunnedKm(new BigDecimal(runnedKm));
				}
				if(totalTon!=null && !totalTon.equals("")){
					grtTrafficShip.setTotalTon(new BigDecimal(totalTon));
				}
				grtTrafficShip.setEngineType(engineType);
				grtTrafficShip.setOriShipOwner(oriShipOwner);
				if(oriPurchasePrice!=null && !oriPurchasePrice.equals("")){
					grtTrafficShip.setOriPurchasePrice(new BigDecimal(oriPurchasePrice));
				}
				if(insuranceDate!=null && !insuranceDate.equals("")){
					grtTrafficShip.setInsuranceDate(format.parse(insuranceDate));
				}
				map = grtCollateralServiceImpl.updateShipAndGrtCollateral(grtCollateral,grtVehicleTypeMortgage,grtTrafficShip);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新土地使用权以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateLandUseRightAndGrtCollateral")
	public Map<String, Object> updateLandUseRightAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						|| m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//土地使用权信息
						|| m.get("landAcreage") ==null || m.get("landUtilizationPurpose") ==null
						|| m.get("landAcquiringWayCd") ==null || m.get("rawDegree") ==null
						|| m.get("landLicenseOwner") ==null || m.get("landLicenseNum") ==null
						|| m.get("licenseDate") ==null || m.get("useYears") ==null
						|| m.get("landCharacter") ==null || m.get("groundRemiseCd") ==null
						|| m.get("landUserType") ==null 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//土地使用权信息
				String landAcreage = m.get("landAcreage").toString();
				String landUtilizationPurpose = m.get("landUtilizationPurpose").toString();
				String landAcquiringWayCd = m.get("landAcquiringWayCd").toString();
				String rawDegree = m.get("rawDegree").toString();
				String landLicenseOwner = m.get("landLicenseOwner").toString();
				String landLicenseNum = m.get("landLicenseNum").toString();
				String licenseDate = m.get("licenseDate").toString();
				String useYears = m.get("useYears").toString();
				String landCharacter = m.get("landCharacter").toString();
				String landUserType = m.get("landUserType").toString();
				String groundRemiseCd = m.get("groundRemiseCd").toString();
				String cityLocationInd = m.get("cityLocationInd")==null ? null : m.get("cityLocationInd").toString();
				String circleStatus = m.get("circleStatus")==null ? null : m.get("circleStatus").toString();
				String landNum = m.get("landNum")==null ? null : m.get("landNum").toString();
				String patchLandMoney = m.get("patchLandMoney")==null ? null : m.get("patchLandMoney").toString();
				String signDesc = m.get("signDesc")==null ? null : m.get("signDesc").toString();
				GrtLandUseRight grtLandUseRight = new GrtLandUseRight();
				grtLandUseRight.setLandAcreage(new BigDecimal(landAcreage));
				grtLandUseRight.setGuarantyId(guarantyId);
				grtLandUseRight.setLandUtilizationPurpose(landUtilizationPurpose);
				grtLandUseRight.setLandAcquiringWayCd(landAcquiringWayCd);
				grtLandUseRight.setRawDegree(rawDegree);
				grtLandUseRight.setLandLicenseOwner(landLicenseOwner);
				grtLandUseRight.setLandLicenseNum(landLicenseNum);
				grtLandUseRight.setLicenseDate(format.parse(licenseDate));
				grtLandUseRight.setUseYears(new BigDecimal(useYears));
				grtLandUseRight.setLandCharacter(landCharacter);
				grtLandUseRight.setLandUserType(landUserType);
				grtLandUseRight.setGroundRemiseCd(groundRemiseCd);
				grtLandUseRight.setCityLocationInd(cityLocationInd);
				grtLandUseRight.setCircleStatus(circleStatus);
				grtLandUseRight.setLandNum(landNum);
				if(patchLandMoney!=null && !patchLandMoney.equals("")){
					grtLandUseRight.setPatchLandMoney(new BigDecimal(patchLandMoney));
				}
				grtLandUseRight.setSignDesc(signDesc);
				map = grtCollateralServiceImpl.updateLandUseRightAndGrtCollateral(grtCollateral,grtLandUseRight);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	/**
	 * 更新工资账户以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateEarningsAccountAndGrtCollateral")
	public Map<String, Object> updateEarningsAccountAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						|| m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//工资账户信息
						|| m.get("personalSettlementAccount") ==null || m.get("currencySpecies") ==null
						|| m.get("monthSendEarnings") ==null || m.get("openBankAccount") ==null
						|| m.get("isPayment") ==null || m.get("isCommonPerson") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				//工资账户信息
				GrtEarningsAccount grtEarningsAccount = new GrtEarningsAccount();
				String personalSettlementAccount = m.get("personalSettlementAccount").toString();
				String currencySpecies = m.get("currencySpecies").toString();
				String monthSendEarnings = m.get("monthSendEarnings").toString();
				String openBankAccount = m.get("openBankAccount").toString();
				String isPayment = m.get("isPayment").toString();
				String isCommonPerson = m.get("isCommonPerson").toString();
				String otherExplain = m.get("otherExplain")==null ? null : m.get("otherExplain").toString();
				grtEarningsAccount.setPersonalSettlementAccount(personalSettlementAccount);
				grtEarningsAccount.setCurrencySpecies(currencySpecies);
				grtEarningsAccount.setMonthSendEarnings(new BigDecimal(monthSendEarnings));
				grtEarningsAccount.setOpenBankAccount(openBankAccount);
				grtEarningsAccount.setIsPayment(isPayment);
				grtEarningsAccount.setIsCommonPerson(isCommonPerson);
				grtEarningsAccount.setOtherExplain(otherExplain);
				grtEarningsAccount.setGuarantyId(guarantyId);
				map = grtCollateralServiceImpl.updateEarningsAccountAndGrtCollateral(grtCollateral,grtEarningsAccount);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	/**
	 * 更新其他抵质押信息  
	 * 说明：此信息没有单独的表，抵质押信息表中默认存在的字段
	 * @param params
	 * @return
	 */
	@PostMapping("/updateOtherAndGrtCollateral")
	public Map<String, Object> updateOtherAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						|| m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null 
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//其他信息
						|| m.get("collateralName") ==null || m.get("impawnAmount") ==null
						|| m.get("impawnAmountCd") ==null || m.get("impawnGetDate") ==null
						|| m.get("impawnExpireDate") ==null || m.get("registerInd") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				String collateralName = m.get("collateralName").toString();
				String impawnAmount = m.get("impawnAmount").toString();
				String impawnAmountCd = m.get("impawnAmountCd").toString();
				String impawnGetDate = m.get("impawnGetDate").toString();
				String impawnExpireDate = m.get("impawnExpireDate").toString();
				String registerInd = m.get("registerInd").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setCollateralName(collateralName);
				grtCollateral.setImpawnAmount(new BigDecimal(impawnAmount));
				grtCollateral.setImpawnAmountCd(impawnAmountCd);
				grtCollateral.setImpawnExpireDate(format.parse(impawnExpireDate));
				grtCollateral.setImpawnGetDate(format.parse(impawnGetDate));
				grtCollateral.setRegisterInd(registerInd);
				grtCollateral.setOtherNote(otherNote);
				map = grtCollateralServiceImpl.updateOtherAndGrtCollateral(grtCollateral);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	
	/**
	 * 更新土地经营权权以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateLandManagementRightAndGrtCollateral")
	public Map<String, Object> updateLandManagementRightAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null 
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//土地经营权信息
						|| m.get("licenseOwner") ==null || m.get("landBusinessNature") ==null
						|| m.get("contractStartDate") ==null || m.get("contractEndDate") ==null
						|| m.get("annualCharge") ==null || m.get("contractFeesPayMethod") ==null
						|| m.get("contractFeesDueDate") ==null || m.get("expirateDate") ==null
						|| m.get("landUseStatus") ==null || m.get("landAcreage") ==null
						|| m.get("landUseNature") ==null || m.get("landUtilizationPurpose") ==null 
						|| m.get("landAcquiringWayCd") ==null 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//土地承包经营信息
				GrtLandManagementRight grtLandManagementRight = new GrtLandManagementRight();
				String licenseOwner = m.get("licenseOwner").toString();
				String landBusinessNature = m.get("landBusinessNature").toString();
				String contractEndDate = m.get("contractEndDate").toString();
				String contractStartDate = m.get("contractStartDate").toString();
				String annualCharge = m.get("annualCharge").toString();
				String contractFeesPayMethod = m.get("contractFeesPayMethod").toString();
				String contractFeesDueDate = m.get("contractFeesDueDate").toString();
				String expirateDate = m.get("expirateDate").toString();
				String landUseStatus = m.get("landUseStatus").toString();
				String landAcreage = m.get("landAcreage").toString();
				String landUseNature = m.get("landUseNature").toString();
				String landUtilizationPurpose = m.get("landUtilizationPurpose").toString();
				String landAcquiringWayCd = m.get("landAcquiringWayCd").toString();
				String managementTypeCd = m.get("managementTypeCd")==null ? null : m.get("managementTypeCd").toString();
				String managementSizeCd = m.get("managementSizeCd")==null ? null : m.get("managementSizeCd").toString();
				String circleStatus = m.get("circleStatus")==null ? null : m.get("circleStatus").toString();
				String groundRemiseCd = m.get("groundRemiseCd")==null ? null : m.get("groundRemiseCd").toString();
				String contractFeesPaySituation = m.get("contractFeesPaySituation")==null ? null : m.get("contractFeesPaySituation").toString();
				String signDesc = m.get("signDesc")==null ? null : m.get("signDesc").toString();
				grtLandManagementRight.setLicenseOwner(licenseOwner);
				grtLandManagementRight.setLandBusinessNature(landBusinessNature);
				grtLandManagementRight.setContractEndDate(format.parse(contractEndDate));
				grtLandManagementRight.setContractStartDate(format.parse(contractStartDate));
				grtLandManagementRight.setAnnualCharge(new BigDecimal(annualCharge));
				grtLandManagementRight.setContractFeesPayMethod(contractFeesPayMethod);
				grtLandManagementRight.setContractFeesDueDate(format.parse(contractFeesDueDate));
				grtLandManagementRight.setExpirateDate(format.parse(expirateDate));
				grtLandManagementRight.setLandUseStatus(landUseStatus);
				grtLandManagementRight.setLandAcreage(new BigDecimal(landAcreage));
				grtLandManagementRight.setLandUseNature(landUseNature);
				grtLandManagementRight.setLandUtilizationPurpose(landUtilizationPurpose);
				grtLandManagementRight.setLandAcquiringWayCd(landAcquiringWayCd);
				grtLandManagementRight.setManagementTypeCd(managementTypeCd);
				grtLandManagementRight.setManagementSizeCd(managementSizeCd);
				grtLandManagementRight.setCircleStatus(circleStatus);
				grtLandManagementRight.setGroundRemiseCd(groundRemiseCd);
				grtLandManagementRight.setContractFeesPaySituation(contractFeesPaySituation);
				grtLandManagementRight.setSignDesc(signDesc);
				grtLandManagementRight.setGuarantyId(guarantyId);
				map = grtCollateralServiceImpl.updateLandManagementRightAndGrtCollateral(grtCollateral,grtLandManagementRight);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新存货以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateMerchandiseAndGrtCollateral")
	public Map<String, Object> updateMerchandiseAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//存货
						|| m.get("merchandiseTypeCd") ==null || m.get("merchandiseName") ==null
						|| m.get("amount") ==null || m.get("unit") ==null
						|| m.get("rightPledgeNum") ==null || m.get("storePlace") ==null
						|| m.get("storePlace") ==null || m.get("registOrg") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				//存货信息
				GrtMerchandise grtMerchandise = new GrtMerchandise();
				String merchandiseTypeCd = m.get("merchandiseTypeCd").toString();
				String merchandiseName = m.get("merchandiseName").toString();
				String amount = m.get("amount").toString();
				String unit = m.get("unit").toString();
				String price = m.get("price").toString();
				String rightPledgeNum = m.get("rightPledgeNum").toString();
				String storePlace = m.get("storePlace").toString();
				String registOrg = m.get("registOrg").toString();
				String storeStartDate = m.get("storeStartDate")==null ? null : m.get("storeStartDate").toString();
				String storeManager = m.get("storeManager")==null ? null : m.get("storeManager").toString();
				String storeStutas = m.get("storeStutas")==null ? null : m.get("storeStutas").toString();
				grtMerchandise.setGuarantyId(guarantyId);
				grtMerchandise.setMerchandiseTypeCd(merchandiseTypeCd);
				grtMerchandise.setMerchandiseName(merchandiseName);
				grtMerchandise.setAmount(new BigDecimal(amount));
				grtMerchandise.setUnit(unit);
				grtMerchandise.setPrice(new BigDecimal(price));
				grtMerchandise.setRightPledgeNum(rightPledgeNum);
				grtMerchandise.setStorePlace(storePlace);
				grtMerchandise.setRegistOrg(registOrg);
				grtMerchandise.setStoreManager(storeManager);
				grtMerchandise.setStoreStutas(storeStutas);
				if(storeStartDate!=null && !storeStartDate.equals("")){
					grtMerchandise.setStoreStartDate(format.parse(storeStartDate));
				}
				map = grtCollateralServiceImpl.updateMerchandiseAndGrtCollateral(grtCollateral,grtMerchandise);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新收费权信息以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateChargingRightMortgageAndGrtCollateral")
	public Map<String, Object> updateChargingRightMortgageAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//收费权信息
						|| m.get("chargingRightName") ==null || m.get("chargingRightStander") ==null
						|| m.get("approveOrg") ==null || m.get("chargingRightFileName") ==null
						|| m.get("approveDocumentNum") ==null || m.get("chargeRepaymentRate") ==null
						|| m.get("collectionAccount") ==null || m.get("openBank") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setOtherNote(otherNote);
				//收费权信息
				String chargingRightName = m.get("chargingRightName").toString();
				String chargingRightStander = m.get("chargingRightStander").toString();
				String approveOrg = m.get("approveOrg").toString();
				String chargingRightFileName = m.get("chargingRightFileName").toString();
				String approveDocumentNum = m.get("approveDocumentNum").toString();
				String chargeRepaymentRate = m.get("chargeRepaymentRate").toString();
				String collectionAccount = m.get("collectionAccount").toString();
				String openBank = m.get("openBank").toString();
				String chargeRightCashflowAnalysis = m.get("chargeRightCashflowAnalysis")==null ? null : m.get("chargeRightCashflowAnalysis").toString();
				String chargesLicenseNum = m.get("chargesLicenseNum")==null ? null : m.get("chargesLicenseNum").toString();
				GrtChargingRightMortgage grtChargingRightMortgage = new GrtChargingRightMortgage();
				grtChargingRightMortgage.setChargingRightName(chargingRightName);
				grtChargingRightMortgage.setChargingRightStander(chargingRightStander);
				grtChargingRightMortgage.setApproveOrg(approveOrg);
				grtChargingRightMortgage.setChargingRightFileName(chargingRightFileName);
				grtChargingRightMortgage.setApproveDocumentNum(approveDocumentNum);
				grtChargingRightMortgage.setChargeRepaymentRate(new BigDecimal(chargeRepaymentRate));
				grtChargingRightMortgage.setCollectionAccount(collectionAccount);
				grtChargingRightMortgage.setOpenBank(openBank);
				grtChargingRightMortgage.setChargeRightCashflowAnalysis(chargeRightCashflowAnalysis);
				grtChargingRightMortgage.setChargesLicenseNum(chargesLicenseNum);
				grtChargingRightMortgage.setGuarantyId(guarantyId);
				map = grtCollateralServiceImpl.updateChargingRightMortgageAndGrtCollateral(grtCollateral,grtChargingRightMortgage);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新债券以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateBondPledgeAndGrtCollateral")
	public Map<String, Object> updateBondPledgeAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//债券信息
						|| m.get("issuePersName") ==null || m.get("bondLevelType") ==null
						|| m.get("k71zqzl") ==null || m.get("registerOrgName") ==null
						|| m.get("bondValue") ==null || m.get("bondValueCurrencyCd") ==null
						|| m.get("bondType") ==null || m.get("signCompanyStatus") ==null
						
						|| m.get("signCompanyType") ==null || m.get("agencyMan") ==null
						|| m.get("creditorName") ==null || m.get("bondSingedType") ==null
						|| m.get("bondMaturity") ==null || m.get("bondInterestPayType") ==null
						|| m.get("bondInterestPayMode") ==null || m.get("bondTerm") ==null
						|| m.get("bondTermUnitCd") ==null || m.get("bondAnnualRate") ==null
						|| m.get("signBondInd") ==null 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setOtherNote(otherNote);
				//债券信息
				String issuePersName = m.get("issuePersName").toString();
				String bondLevelType = m.get("bondLevelType").toString();
				String k71zqzl = m.get("k71zqzl").toString();
				String registerOrgName = m.get("registerOrgName").toString();
				String bondValue = m.get("bondValue").toString();
				String bondValueCurrencyCd = m.get("bondValueCurrencyCd").toString();
				String bondType = m.get("bondType").toString();
				String signCompanyStatus = m.get("signCompanyStatus").toString();
				String signCompanyType = m.get("signCompanyType").toString();
				String agencyMan = m.get("agencyMan").toString();
				String creditorName = m.get("creditorName").toString();
				String bondSingedType = m.get("bondSingedType").toString();
				String bondMaturity = m.get("bondMaturity").toString();
				String bondInterestPayType = m.get("bondInterestPayType").toString();
				String bondInterestPayMode = m.get("bondInterestPayMode").toString();
				String bondTerm = m.get("bondTerm").toString();
				String bondTermUnitCd = m.get("bondTermUnitCd").toString();
				String bondAnnualRate = m.get("bondAnnualRate").toString();
				String signBondInd = m.get("signBondInd").toString();
				GrtBondPledge grtBondPledge = new GrtBondPledge();
				grtBondPledge.setIssuePersName(issuePersName);
				grtBondPledge.setBondLevelType(bondLevelType);
				grtBondPledge.setK71zqzl(k71zqzl);
				grtBondPledge.setRegisterOrgName(registerOrgName);
				grtBondPledge.setBondValue(new BigDecimal(bondValue));
				grtBondPledge.setBondValueCurrencyCd(bondValueCurrencyCd);
				grtBondPledge.setBondType(bondType);
				grtBondPledge.setSignCompanyStatus(signCompanyStatus);
				grtBondPledge.setSignCompanyType(signCompanyType);
				grtBondPledge.setAgencyMan(agencyMan);
				grtBondPledge.setCreditorName(creditorName);
				grtBondPledge.setBondSingedType(bondSingedType);
				grtBondPledge.setBondMaturity(format.parse(bondMaturity));
				grtBondPledge.setBondInterestPayMode(bondInterestPayMode);
				grtBondPledge.setBondInterestPayType(bondInterestPayType);
				grtBondPledge.setBondTerm(new BigDecimal(bondTerm));
				grtBondPledge.setBondTermUnitCd(bondTermUnitCd);
				grtBondPledge.setBondAnnualRate(new BigDecimal(bondAnnualRate));
				grtBondPledge.setSignBondInd(signBondInd);
				grtBondPledge.setGuarantyId(guarantyId);
				map = grtCollateralServiceImpl.updateBondPledgeAndGrtCollateral(grtCollateral,grtBondPledge);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新林权权以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateWoodlandPropertyAndGrtCollateral")
	public Map<String, Object> updateWoodlandPropertyAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//林权信息
						|| m.get("woodlandPropertyTypeCd") ==null || m.get("woodlandPropertyNum") ==null
						|| m.get("woodlandType") ==null || m.get("woodlandArea") ==null
						|| m.get("woodsTypeCd") ==null || m.get("treeKind") ==null
						|| m.get("treeYears") ==null || m.get("treeNumber") ==null
						|| m.get("woodlandTerraTypeCd") ==null || m.get("remainAvailabilityTerm") ==null
						|| m.get("woodlandBorderline") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//林权信息
				GrtWoodlandProperty grtWoodlandProperty = new GrtWoodlandProperty();
				String woodlandPropertyTypeCd = m.get("woodlandPropertyTypeCd").toString();
				String woodlandPropertyNum = m.get("woodlandPropertyNum").toString();
				String woodlandType = m.get("woodlandType").toString();
				String woodlandArea = m.get("woodlandArea").toString();
				String woodsTypeCd = m.get("woodsTypeCd").toString();
				String treeKind = m.get("treeKind").toString();
				String treeYears = m.get("treeYears").toString();
				String treeNumber = m.get("treeNumber").toString();
				String woodlandTerraTypeCd = m.get("woodlandTerraTypeCd").toString();
				String remainAvailabilityTerm = m.get("remainAvailabilityTerm").toString();
				String woodlandBorderline = m.get("woodlandBorderline").toString();
				grtWoodlandProperty.setWoodlandTerraTypeCd(woodlandTerraTypeCd);
				grtWoodlandProperty.setWoodlandPropertyNum(woodlandPropertyNum);
				grtWoodlandProperty.setWoodlandType(woodlandType);
				grtWoodlandProperty.setWoodlandArea(woodlandArea);
				grtWoodlandProperty.setWoodsTypeCd(woodsTypeCd);
				grtWoodlandProperty.setWoodlandPropertyTypeCd(woodlandPropertyTypeCd);
				grtWoodlandProperty.setTreeKind(treeKind);
				grtWoodlandProperty.setTreeYears(treeYears);
				grtWoodlandProperty.setTreeNumber(new BigDecimal(treeNumber));
				grtWoodlandProperty.setRemainAvailabilityTerm(remainAvailabilityTerm);
				grtWoodlandProperty.setWoodlandBorderline(woodlandBorderline);
				grtWoodlandProperty.setGuarantyId(guarantyId);
				map = grtCollateralServiceImpl.updateWoodlandPropertyAndGrtCollateral(grtCollateral,grtWoodlandProperty);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新知识产权以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateIntellPropertyRightsAndGrtCollateral")
	public Map<String, Object> updateIntellPropertyRightsAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null 
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//知识产权信息
						|| m.get("licenseName") ==null || m.get("licenseNum") ==null
						|| m.get("licenseDepartment") ==null || m.get("licenseOwner") ==null
						|| m.get("publishedYear") ==null || m.get("procetedDate") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//知识产权信息
				GrtIntellPropertyRights grtIntellPropertyRights = new GrtIntellPropertyRights();
				String licenseName = m.get("licenseName").toString();
				String licenseNum = m.get("licenseNum").toString();
				String licenseDepartment = m.get("licenseDepartment").toString();
				String licenseOwner = m.get("licenseOwner").toString();
				String publishedYear = m.get("publishedYear").toString();
				String procetedDate = m.get("procetedDate").toString();
				String propertyRightNature = m.get("propertyRightNature")==null ? null : m.get("propertyRightNature").toString();
				String brandType = m.get("brandType")==null ? null : m.get("brandType").toString();
				String productClass = m.get("productClass")==null ? null : m.get("productClass").toString();
				String patentType = m.get("patentType")==null ? null : m.get("patentType").toString();
				String patentPurpose = m.get("patentPurpose")==null ? null : m.get("patentPurpose").toString();
				String productionType = m.get("productionType")==null ? null : m.get("productionType").toString();
				String checkedDate = m.get("checkedDate")==null ? null : m.get("checkedDate").toString();
				grtIntellPropertyRights.setLicenseName(licenseName);
				grtIntellPropertyRights.setLicenseNum(licenseNum);
				grtIntellPropertyRights.setLicenseDepartment(licenseDepartment);
				grtIntellPropertyRights.setLicenseOwner(licenseOwner);
				grtIntellPropertyRights.setPublishedYear(publishedYear);
				grtIntellPropertyRights.setProcetedDate(format.parse(procetedDate));
				grtIntellPropertyRights.setPropertyRightNature(propertyRightNature);
				grtIntellPropertyRights.setBrandType(brandType);
				grtIntellPropertyRights.setProductClass(productClass);
				grtIntellPropertyRights.setPatentType(patentType);
				grtIntellPropertyRights.setPatentPurpose(patentPurpose);
				grtIntellPropertyRights.setProductionType(productionType);
				grtIntellPropertyRights.setGuarantyId(guarantyId);
				if(checkedDate!=null && !checkedDate.equals("")){
					grtIntellPropertyRights.setCheckedDate(format.parse(checkedDate));
				}
				map = grtCollateralServiceImpl.updateIntellPropertyRightsAndGrtCollateral(grtCollateral,grtIntellPropertyRights);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新应收账款信息以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateReceivableAndGrtCollateral")
	public Map<String, Object> updateReceivableAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//应收账款信息
						|| m.get("paymentPersName") ==null || m.get("receiveAmtType") ==null
						|| m.get("currencyCs") ==null || m.get("amt") ==null
						|| m.get("accountYears") ==null || m.get("accounYearsUnitCd") ==null
						|| m.get("receivableCartNum") ==null || m.get("agreementAmtDate") ==null
						|| m.get("receivableContractNum") ==null || m.get("receivableAccountDate") ==null
						|| m.get("receivableCheckStutas") ==null 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setOtherNote(otherNote);
				//应收账款信息
				GrtReceivable grtReceivable = new GrtReceivable();
				String paymentPersName = m.get("paymentPersName").toString();
				String receiveAmtType = m.get("receiveAmtType").toString();
				String currencyCs = m.get("currencyCs").toString();
				String amt = m.get("amt").toString();
				String accountYears = m.get("accountYears").toString();
				String accounYearsUnitCd = m.get("accounYearsUnitCd").toString();
				String receivableCartNum = m.get("receivableCartNum").toString();
				String agreementAmtDate = m.get("agreementAmtDate").toString();
				String receivableContractNum = m.get("receivableContractNum").toString();
				String receivableAccountDate = m.get("receivableAccountDate").toString();
				String receivableCheckStutas = m.get("receivableCheckStutas").toString();
				grtReceivable.setPaymentPersName(paymentPersName);
				grtReceivable.setReceiveAmtType(receiveAmtType);
				grtReceivable.setCurrencyCs(currencyCs);
				grtReceivable.setAmt(new BigDecimal(amt));
				grtReceivable.setAccountYears(new BigDecimal(accountYears));
				grtReceivable.setAccounYearsUnitCd(accounYearsUnitCd);
				grtReceivable.setReceivableCartNum(receivableCartNum);
				grtReceivable.setAgreementAmtDate(format.parse(agreementAmtDate));
				grtReceivable.setReceivableContractNum(receivableContractNum);
				grtReceivable.setReceivableAccountDate(format.parse(receivableAccountDate));
				grtReceivable.setReceivableCheckStutas(receivableCheckStutas);
				grtReceivable.setGuarantyId(guarantyId);
				map = grtCollateralServiceImpl.updateReceivableAndGrtCollateral(grtCollateral,grtReceivable);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新股权信息以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateStockWarrantAssetsAndGrtCollateral")
	public Map<String, Object> updateStockWarrantAssetsAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//股权信息
						|| m.get("controlCount") ==null || m.get("stockCount") ==null
						|| m.get("netValuePerStock") ==null || m.get("netValueCurrencyCd") ==null
						|| m.get("stockCharacter") ==null || m.get("controledCompanyName") ==null
						|| m.get("controledCompanyType") ==null || m.get("companyHoldBiz") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setOtherNote(otherNote);
				//股权公共信息
				String stockCount = m.get("stockCount").toString();
				String netValuePerStock = m.get("netValuePerStock").toString();
				String netValueCurrencyCd = m.get("netValueCurrencyCd").toString();
				String stockCharacter = m.get("stockCharacter").toString();
				String stockName = m.get("stockName")==null ? null : m.get("stockName").toString();
				String marketCompanyName = m.get("marketCompanyName")==null ? null : m.get("marketCompanyName").toString();
				String stockIssueTypeCd = m.get("stockIssueTypeCd")==null ? null : m.get("stockIssueTypeCd").toString();
				String marketPlace = m.get("marketPlace")==null ? null : m.get("marketPlace").toString();
				String marketCompanyTypeCd = m.get("marketCompanyTypeCd")==null ? null : m.get("marketCompanyTypeCd").toString();
				String stockRegistrationOrg = m.get("stockRegistrationOrg")==null ? null : m.get("stockRegistrationOrg").toString();
				String stockListedInd = m.get("stockListedInd")==null ? null : m.get("stockListedInd").toString();
				String averagePriceLatestDay = m.get("averagePriceLatestDay")==null ? null : m.get("averagePriceLatestDay").toString();
				String averagePriceLatestYear = m.get("averagePriceLatestYear")==null ? null : m.get("averagePriceLatestYear").toString();
				String marketCompanyOperStatus = m.get("marketCompanyOperStatus")==null ? null : m.get("marketCompanyOperStatus").toString();
				GrtStockPledge grtStockPledge = new GrtStockPledge();
				grtStockPledge.setStockCharacter(stockCharacter);
				grtStockPledge.setStockCount(new BigDecimal(stockCount));
				grtStockPledge.setNetValuePerStock(new BigDecimal(netValuePerStock));
				grtStockPledge.setNetValueCurrencyCd(netValueCurrencyCd);
				grtStockPledge.setMarketCompanyName(marketCompanyName);
				grtStockPledge.setStockName(stockName);
				grtStockPledge.setStockIssueTypeCd(stockIssueTypeCd);
				grtStockPledge.setMarketPlace(marketPlace);
				grtStockPledge.setMarketCompanyTypeCd(marketCompanyTypeCd);
				grtStockPledge.setStockRegistrationOrg(stockRegistrationOrg);
				grtStockPledge.setStockListedInd(stockListedInd);
				if(averagePriceLatestDay!=null && !averagePriceLatestDay.equals("")){
					grtStockPledge.setAveragePriceLatestDay(new BigDecimal(averagePriceLatestDay));
				}
				if(averagePriceLatestYear!=null && !averagePriceLatestYear.equals("")){
					grtStockPledge.setAveragePriceLatestYear(new BigDecimal(averagePriceLatestYear));
				}
				grtStockPledge.setMarketCompanyOperStatus(marketCompanyOperStatus);
				grtStockPledge.setGuarantyId(guarantyId);
				//股权信息
				GrtStockWarrantAssets grtStockWarrantAssets = new GrtStockWarrantAssets();
				String companyHoldBiz = m.get("companyHoldBiz").toString();
				String controlCount = m.get("controlCount").toString();
				String controledCompanyName = m.get("controledCompanyName").toString();
				String controledCompanyType = m.get("controledCompanyType").toString();
				String stockEquityNoticeNum = m.get("stockEquityNoticeNum")==null ? null : m.get("stockEquityNoticeNum").toString();
				grtStockWarrantAssets.setCompanyHoldBiz(companyHoldBiz);
				grtStockWarrantAssets.setControlCount(new BigDecimal(controlCount));
				grtStockWarrantAssets.setControledCompanyName(controledCompanyName);
				grtStockWarrantAssets.setControledCompanyType(controledCompanyType);
				grtStockWarrantAssets.setGuarantyId(guarantyId);
				grtStockWarrantAssets.setStockEquityNoticeNum(stockEquityNoticeNum);
				map = grtCollateralServiceImpl.updateStockWarrantAssetsAndGrtCollateral(grtCollateral,grtStockPledge,grtStockWarrantAssets);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新基金信息以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateFundAndGrtCollateral")
	public Map<String, Object> updateFundAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//基金信息
						|| m.get("stockCount") ==null || m.get("controlPercentage") ==null
						|| m.get("netValuePerStock") ==null || m.get("netValueCurrencyCd") ==null
						//基金基本信息
						|| m.get("fundCd") ==null || m.get("fundCorpName") ==null
						|| m.get("fundTypeCd") ==null || m.get("stockHolderCd") ==null
						|| m.get("seatCd") ==null 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setOtherNote(otherNote);
				//基金公共信息
				String stockCount = m.get("stockCount").toString();
				String controlPercentage = m.get("controlPercentage").toString();
				String netValuePerStock = m.get("netValuePerStock").toString();
				String netValueCurrencyCd = m.get("netValueCurrencyCd").toString();
				String stockCharacter = m.get("stockCharacter")==null ? null : m.get("stockCharacter").toString();
				String stockName = m.get("stockName")==null ? null : m.get("stockName").toString();
				String marketCompanyName = m.get("marketCompanyName")==null ? null : m.get("marketCompanyName").toString();
				String stockIssueTypeCd = m.get("stockIssueTypeCd")==null ? null : m.get("stockIssueTypeCd").toString();
				String marketPlace = m.get("marketPlace")==null ? null : m.get("marketPlace").toString();
				String marketCompanyTypeCd = m.get("marketCompanyTypeCd")==null ? null : m.get("marketCompanyTypeCd").toString();
				String stockRegistrationOrg = m.get("stockRegistrationOrg")==null ? null : m.get("stockRegistrationOrg").toString();
				String stockListedInd = m.get("stockListedInd")==null ? null : m.get("stockListedInd").toString();
				String averagePriceLatestDay = m.get("averagePriceLatestDay")==null ? null : m.get("averagePriceLatestDay").toString();
				String averagePriceLatestYear = m.get("averagePriceLatestYear")==null ? null : m.get("averagePriceLatestYear").toString();
				String marketCompanyOperStatus = m.get("marketCompanyOperStatus")==null ? null : m.get("marketCompanyOperStatus").toString();
				GrtStockPledge grtStockPledge = new GrtStockPledge();
				grtStockPledge.setControlPercentage(new BigDecimal(controlPercentage));
				grtStockPledge.setStockCharacter(stockCharacter);
				grtStockPledge.setStockCount(new BigDecimal(stockCount));
				grtStockPledge.setNetValuePerStock(new BigDecimal(netValuePerStock));
				grtStockPledge.setNetValueCurrencyCd(netValueCurrencyCd);
				grtStockPledge.setMarketCompanyName(marketCompanyName);
				grtStockPledge.setStockName(stockName);
				grtStockPledge.setStockIssueTypeCd(stockIssueTypeCd);
				grtStockPledge.setMarketPlace(marketPlace);
				grtStockPledge.setMarketCompanyTypeCd(marketCompanyTypeCd);
				grtStockPledge.setStockRegistrationOrg(stockRegistrationOrg);
				grtStockPledge.setStockListedInd(stockListedInd);
				if(averagePriceLatestDay!=null && !averagePriceLatestDay.equals("")){
					grtStockPledge.setAveragePriceLatestDay(new BigDecimal(averagePriceLatestDay));
				}
				if(averagePriceLatestYear!=null && !averagePriceLatestYear.equals("")){
					grtStockPledge.setAveragePriceLatestYear(new BigDecimal(averagePriceLatestYear));
				}
				grtStockPledge.setMarketCompanyOperStatus(marketCompanyOperStatus);
				grtStockPledge.setGuarantyId(guarantyId);
				//基金基本信息
				GrtFund grtFund = new GrtFund();
				String fundCd = m.get("fundCd").toString();
				String fundCorpName = m.get("fundCorpName").toString();
				String fundTypeCd = m.get("fundTypeCd").toString();
				String stockHolderCd = m.get("stockHolderCd").toString();
				String seatCd = m.get("seatCd").toString();
				grtFund.setGuarantyId(guarantyId);
				grtFund.setFundCd(fundCd);
				grtFund.setFundCorpName(fundCorpName);
				grtFund.setFundTypeCd(fundTypeCd);
				grtFund.setStockHolderCd(stockHolderCd);
				grtFund.setSeatCd(seatCd);
				map = grtCollateralServiceImpl.updateFundAndGrtCollateral(grtCollateral,grtStockPledge,grtFund);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新票据以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateBillAndGrtCollateral")
	public Map<String, Object> updateBillAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//票据信息
						|| m.get("billType") ==null || m.get("billNum") ==null
						|| m.get("billCurrencyCd") ==null || m.get("billAmt") ==null
						|| m.get("billSignupDate") ==null || m.get("billExpireDate") ==null 
						|| m.get("billTerm") ==null 
						|| m.get("billType").equals("")|| m.get("billNum").equals("")
						|| m.get("billCurrencyCd").equals("")|| m.get("billAmt").equals("")
						|| m.get("billSignupDate").equals("")|| m.get("billExpireDate").equals("")
						|| m.get("billTerm").equals("")
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setOtherNote(otherNote);
				//票据信息
				String billType = m.get("billType").toString();
				String billNum = m.get("billNum").toString();
				String billCurrencyCd = m.get("billCurrencyCd").toString();
				String billAmt = m.get("billAmt").toString();
				String billSignupDate = m.get("billSignupDate").toString();
				String billExpireDate = m.get("billExpireDate").toString();
				String billTerm = m.get("billTerm").toString();
				String remitterName = m.get("remitterName")==null ? null : m.get("remitterName").toString();
				String remitterAccount = m.get("remitterAccount")==null ? null : m.get("remitterAccount").toString();
				String remitterBank = m.get("remitterBank")==null ? null : m.get("remitterBank").toString();
				String payeeName = m.get("payeeName")==null ? null : m.get("payeeName").toString();
				String payeeAccount = m.get("payeeAccount")==null ? null : m.get("payeeAccount").toString();
				String payeeBank = m.get("payeeBank")==null ? null : m.get("payeeBank").toString();
				String searchResult = m.get("searchResult")==null ? null : m.get("searchResult").toString();
				String acceptorBank = m.get("acceptorBank")==null ? null : m.get("acceptorBank").toString();
				GrtBill grtBill = new GrtBill();
				grtBill.setBillType(billType);
				grtBill.setBillNum(billNum);
				grtBill.setBillCurrencyCd(billCurrencyCd);
				grtBill.setBillAmt(new BigDecimal(billAmt));
				grtBill.setBillSignupDate(format.parse(billSignupDate));
				grtBill.setBillExpireDate(format.parse(billExpireDate));
				grtBill.setBillTerm(new BigDecimal(billTerm));
				grtBill.setRemitterName(remitterName);
				grtBill.setRemitterAccount(remitterAccount);
				grtBill.setRemitterBank(remitterBank);
				grtBill.setPayeeAccount(payeeAccount);
				grtBill.setPayeeBank(payeeBank);
				grtBill.setPayeeName(payeeName);
				grtBill.setSearchResult(searchResult);
				grtBill.setAcceptorBank(acceptorBank);
				grtBill.setGuarantyId(guarantyId);
				map = grtCollateralServiceImpl.updateBillAndGrtCollateral(grtCollateral,grtBill);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新仓单以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateStandardDepotImpawnAndGrtCollateral")
	public Map<String, Object> updateStandardDepotImpawnAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//仓单信息
						|| m.get("breed") ==null || m.get("amount") ==null
						|| m.get("availabilityExpirationDate") ==null || m.get("depotName") ==null
						|| m.get("warehouseAddress") ==null || m.get("consignorName") ==null 
						|| m.get("goodsName") ==null || m.get("enterDepotDate") ==null
						|| m.get("custodyFee") ==null || m.get("isPayCustodyFee") ==null
						|| m.get("ccbAssessedValue") ==null || m.get("depotTypeCd") ==null
						|| m.get("depotImpawnApplyUser") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setOtherNote(otherNote);
				//仓单信息
				String ccbAssessedValue = m.get("ccbAssessedValue").toString();
				grtCollateral.setCcbAssessedValue(new BigDecimal(ccbAssessedValue));
				GrtStandardDepotImpawn grtStandardDepotImpawn = new GrtStandardDepotImpawn();
				String breed = m.get("breed").toString();
				String amount = m.get("amount").toString();
				String availabilityExpirationDate = m.get("availabilityExpirationDate").toString();
				String depotName = m.get("depotName").toString();
				String warehouseAddress = m.get("warehouseAddress").toString();
				String consignorName = m.get("consignorName").toString();
				String goodsName = m.get("goodsName").toString();
				String enterDepotDate = m.get("enterDepotDate").toString();
				String custodyFee = m.get("custodyFee").toString();
				String isPayCustodyFee = m.get("isPayCustodyFee").toString();
				String depotTypeCd = m.get("depotTypeCd").toString();
				String depotImpawnApplyUser = m.get("depotImpawnApplyUser").toString();
				String logo = m.get("logo")==null ? null : m.get("logo").toString();
				String rank = m.get("rank")==null ? null : m.get("rank").toString();
				String depotImpawnSort = m.get("depotImpawnSort")==null ? null : m.get("depotImpawnSort").toString();
				String enterDepotApplyUser = m.get("enterDepotApplyUser")==null ? null : m.get("enterDepotApplyUser").toString();
				String enterDepotApproveUser = m.get("enterDepotApproveUser")==null ? null : m.get("enterDepotApproveUser").toString();
				grtStandardDepotImpawn.setGuarantyId(guarantyId);
				grtStandardDepotImpawn.setOtherNote(otherNote);
				grtStandardDepotImpawn.setBreed(breed);
				grtStandardDepotImpawn.setAmount(amount);
				grtStandardDepotImpawn.setAvailabilityExpirationDate(format.parse(availabilityExpirationDate));
				grtStandardDepotImpawn.setDepotName(depotName);
				grtStandardDepotImpawn.setWarehouseAddress(warehouseAddress);
				grtStandardDepotImpawn.setConsignorName(consignorName);
				grtStandardDepotImpawn.setGoodsName(goodsName);
				grtStandardDepotImpawn.setEnterDepotDate(format.parse(enterDepotDate));
				grtStandardDepotImpawn.setCustodyFee(new BigDecimal(custodyFee));
				grtStandardDepotImpawn.setIsPayCustodyFee(isPayCustodyFee);
				grtStandardDepotImpawn.setDepotTypeCd(depotTypeCd);
				grtStandardDepotImpawn.setEnterDepotApplyUser(enterDepotApplyUser);
				grtStandardDepotImpawn.setDepotImpawnApplyUser(depotImpawnApplyUser);
				grtStandardDepotImpawn.setLogo(logo);
				grtStandardDepotImpawn.setRank(rank);
				grtStandardDepotImpawn.setDepotImpawnSort(depotImpawnSort);
				grtStandardDepotImpawn.setEnterDepotApproveUser(enterDepotApproveUser);
				map = grtCollateralServiceImpl.updateStandardDepotImpawnAndGrtCollateral(grtCollateral,grtStandardDepotImpawn);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新保单以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateGuaranteeSlipAndGrtCollateral")
	public Map<String, Object> updateGuaranteeSlipAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//保单信息
						|| m.get("k68bdh") ==null || m.get("k68bdzl") ==null
						|| m.get("k68bdje") ==null || m.get("k68bddqr") ==null
						|| m.get("k68grsj") ==null || m.get("k68dbr") ==null 
						|| m.get("k68syr") ==null || m.get("k68tbje") ==null
						|| m.get("k68bxgsmc") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setOtherNote(otherNote);
				//保单信息
				String k68bdh = m.get("k68bdh").toString();
				String k68bdzl = m.get("k68bdzl").toString();
				String k68bdje = m.get("k68bdje").toString();
				String k68bddqr = m.get("k68bddqr").toString();
				String k68grsj = m.get("k68grsj").toString();
				String k68dbr = m.get("k68dbr").toString();
				String k68syr = m.get("k68syr").toString();
				String k68tbje = m.get("k68tbje").toString();
				String k68bxgsmc = m.get("k68bxgsmc").toString();
				GrtGuaranteeSlip grtGuaranteeSlip = new GrtGuaranteeSlip();
				grtGuaranteeSlip.setGuarantyId(guarantyId);
				grtGuaranteeSlip.setK68bddqr(format.parse(k68bddqr));
				grtGuaranteeSlip.setK68bdh(k68bdh);
				grtGuaranteeSlip.setK68bdzl(k68bdzl);
				grtGuaranteeSlip.setK68tbje(new BigDecimal(k68tbje));
				grtGuaranteeSlip.setK68bdje(new BigDecimal(k68bdje));
				grtGuaranteeSlip.setK68grsj(format.parse(k68grsj));
				grtGuaranteeSlip.setK68bxgsmc(k68bxgsmc);
				grtGuaranteeSlip.setK68dbr(k68dbr);
				grtGuaranteeSlip.setK68syr(k68syr);
				map = grtCollateralServiceImpl.updateGuaranteeSlipAndGrtCollateral(grtCollateral,grtGuaranteeSlip);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新机器设备以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateMachineEquipmentAndGrtCollateral")
	public Map<String, Object> updateMachineEquipmentAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//机器设备信息
						|| m.get("equipmentName") ==null || m.get("equipmentType") ==null
						|| m.get("useType") ==null || m.get("modelType") ==null
						|| m.get("power") ==null || m.get("powerUnitCd") ==null
						|| m.get("manufactureDate") ==null || m.get("utilizedYears") ==null
						|| m.get("purpose") ==null || m.get("equipMount") ==null
						|| m.get("fireCheckInd") ==null || m.get("oriPurPrice") ==null
						|| m.get("obtainMode") ==null 
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//机器设备信息 
				GrtMachineEquipment grtMachineEquipment = new GrtMachineEquipment();
				String equipmentName = m.get("equipmentName").toString();
				String equipmentType = m.get("equipmentType").toString();
				String useType = m.get("useType").toString();
				String modelType = m.get("modelType").toString();
				String power = m.get("power").toString();
				String powerUnitCd = m.get("powerUnitCd").toString();
				String manufactureDate = m.get("manufactureDate").toString();
				String utilizedYears = m.get("utilizedYears").toString();
				String purpose = m.get("purpose").toString();
				String equipMount = m.get("equipMount").toString();
				String fireCheckInd = m.get("fireCheckInd").toString();
				String oriPurPrice = m.get("oriPurPrice").toString();
				String obtainMode = m.get("obtainMode").toString();
				String newRate = m.get("newRate")==null ? null : m.get("newRate").toString();
				String fuel = m.get("fuel")==null ? null : m.get("fuel").toString();
				String equipMountUnitCd = m.get("equipMountUnitCd")==null ? null : m.get("equipMountUnitCd").toString();
				String manufacture = m.get("manufacture")==null ? null : m.get("manufacture").toString();
				String produceArea = m.get("produceArea")==null ? null : m.get("produceArea").toString();
				String eliLicenseInd = m.get("eliLicenseInd")==null ? null : m.get("eliLicenseInd").toString();
				String safeCheckInd = m.get("safeCheckInd")==null ? null : m.get("safeCheckInd").toString();
				String deviceUseLife = m.get("deviceUseLife")==null ? null : m.get("deviceUseLife").toString();
				grtMachineEquipment.setGuarantyId(guarantyId);
				grtMachineEquipment.setEquipmentType(equipmentType);
				grtMachineEquipment.setEquipmentName(equipmentName);
				grtMachineEquipment.setUseType(useType);
				grtMachineEquipment.setModelType(modelType);
				grtMachineEquipment.setPower(new BigDecimal(power));
				grtMachineEquipment.setPowerUnitCd(powerUnitCd);
				grtMachineEquipment.setManufacture(manufacture);
				grtMachineEquipment.setManufactureDate(format.parse(manufactureDate));
				grtMachineEquipment.setUtilizedYears(new BigDecimal(utilizedYears));
				grtMachineEquipment.setPurpose(purpose);
				grtMachineEquipment.setEquipMount(new BigDecimal(equipMount));
				grtMachineEquipment.setFireCheckInd(fireCheckInd);
				grtMachineEquipment.setOriPurPrice(new BigDecimal(oriPurPrice));
				grtMachineEquipment.setObtainMode(obtainMode);
				grtMachineEquipment.setFuel(fuel);
				grtMachineEquipment.setEquipMountUnitCd(equipMountUnitCd);
				grtMachineEquipment.setProduceArea(produceArea);
				grtMachineEquipment.setEliLicenseInd(eliLicenseInd);
				grtMachineEquipment.setSafeCheckInd(safeCheckInd);
				if(deviceUseLife!=null && !deviceUseLife.equals("")){
					grtMachineEquipment.setDeviceUseLife(new BigDecimal(deviceUseLife));
				}
				if(newRate!=null && !newRate.equals("")){
					grtMachineEquipment.setNewRate(new BigDecimal(newRate));
				}
				map = grtCollateralServiceImpl.updateMachineEquipmentAndGrtCollateral(grtCollateral,grtMachineEquipment);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新交通运输工具(其他交通工具表)以及抵质押信息
	 * @param params
	 * @return
	 */
	@PostMapping("/updateTrafficOthersAndGrtCollateral")
	public Map<String, Object> updateTrafficOthersAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//交通运输工具信息
						|| m.get("vehicleType") ==null || m.get("manufacturingYear") ==null
						|| m.get("carBrand") ==null || m.get("modelStyle") ==null
						|| m.get("usedYear") ==null || m.get("purchaseYear") ==null
						|| m.get("depreciationRestValue") ==null || m.get("ownerLicenseInd") ==null
						|| m.get("hasOperationCertificate") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//交通运输设备表
				//其他交通工具表
				String vehicleType = m.get("vehicleType").toString();
				String rejectYear = m.get("rejectYear")==null ? null : m.get("rejectYear").toString();
				String producedDate = m.get("producedDate")==null ? null : m.get("producedDate").toString();
				String oriPurchasePrice = m.get("oriPurchasePrice")==null ? null : m.get("oriPurchasePrice").toString();
				String ownerLicenseNum = m.get("ownerLicenseNum")==null ? null : m.get("ownerLicenseNum").toString();
				String ownerName = m.get("ownerName")==null ? null : m.get("ownerName").toString();
				String operationCertificateOrg = m.get("operationCertificateOrg")==null ? null : m.get("operationCertificateOrg").toString();
				String vehicleLicenseNum = m.get("vehicleLicenseNum")==null ? null : m.get("vehicleLicenseNum").toString();
				String engineNum = m.get("engineNum")==null ? null : m.get("engineNum").toString();
				String numberPlate = m.get("numberPlate")==null ? null : m.get("numberPlate").toString();
				String troubleRecords = m.get("troubleRecords")==null ? null : m.get("troubleRecords").toString();
				String manufacturingYear = m.get("manufacturingYear").toString();
				String carBrand = m.get("carBrand").toString();
				String modelStyle = m.get("modelStyle").toString();
				String usedYear = m.get("usedYear").toString();
				String purchaseYear = m.get("purchaseYear").toString();
				String depreciationRestValue = m.get("depreciationRestValue").toString();
				String ownerLicenseInd = m.get("ownerLicenseInd").toString();
				String hasOperationCertificate = m.get("hasOperationCertificate").toString();
				String vehicleName = m.get("vehicleName")==null ? null : m.get("vehicleName").toString();
				String bearAbility = m.get("bearAbility")==null ? null : m.get("bearAbility").toString();
				String manufacturingPlace = m.get("manufacturingPlace")==null ? null : m.get("manufacturingPlace").toString();
				//其他交通工具
				GrtTrafficOthers grtTrafficOthers = new GrtTrafficOthers();
				grtTrafficOthers.setGuarantyId(guarantyId);
				grtTrafficOthers.setOwnerLicenseInd(ownerLicenseInd);
				grtTrafficOthers.setOwnerLicenseNum(ownerLicenseNum);
				grtTrafficOthers.setOwnerName(ownerName);
				grtTrafficOthers.setDestroyYears(rejectYear);
				if(producedDate!=null && !producedDate.equals("")){
					grtTrafficOthers.setProducedDate(format.parse(producedDate));
				}
				grtTrafficOthers.setNumberPlate(numberPlate);
				if(oriPurchasePrice!=null && !oriPurchasePrice.equals("")){
					grtTrafficOthers.setOriPurchasePrice(new BigDecimal(oriPurchasePrice));
				}
				//交通工具广公共表
				GrtVehicleTypeMortgage grtVehicleTypeMortgage = new GrtVehicleTypeMortgage();
				grtVehicleTypeMortgage.setGuarantyId(guarantyId);
				grtVehicleTypeMortgage.setVehicleType(vehicleType);
				grtVehicleTypeMortgage.setTroubleRecords(troubleRecords);
				grtVehicleTypeMortgage.setEngineNum(engineNum);
				grtVehicleTypeMortgage.setVehicleLicenseNum(vehicleLicenseNum);
				grtVehicleTypeMortgage.setOperationCertificateOrg(operationCertificateOrg);
				grtVehicleTypeMortgage.setBearAbility(bearAbility);
				grtVehicleTypeMortgage.setManufacturingPlace(manufacturingPlace);
				grtVehicleTypeMortgage.setVehicleName(vehicleName);
				grtVehicleTypeMortgage.setHasOperationCertificate(hasOperationCertificate);
				grtVehicleTypeMortgage.setDepreciationRestValue(new BigDecimal(depreciationRestValue));
				grtVehicleTypeMortgage.setPurchaseYear(format.parse(purchaseYear));
				grtVehicleTypeMortgage.setUsedYear(new BigDecimal(usedYear));
				grtVehicleTypeMortgage.setModelStyle(modelStyle);
				grtVehicleTypeMortgage.setManufacturingYear(manufacturingYear);
				grtVehicleTypeMortgage.setCarBrand(carBrand);
				map = grtCollateralServiceImpl.updateTrafficOthersAndGrtCollateral(grtCollateral,grtVehicleTypeMortgage,grtTrafficOthers);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}

	/**
	 * 更新农机具以及抵质押信息
	 * 说明：与机动车是一张表
	 * @param params
	 * @return
	 */
	@PostMapping("/updateAgricultureToolAndGrtCollateral")
	public Map<String, Object> updateAgricultureToolAndGrtCollateral(
			@RequestBody Map<String, Object> params
			){
		Map<String, Object> map = new HashMap<>();
		if(params.get("params")!=null){
			try {
				@SuppressWarnings("unchecked")
				Map<String, Object> m = (Map<String, Object>)params.get("params");
				if(m.get("guarantyId") ==null || m.get("guarantyId").equals("") || m.get("currencyCd") ==null ||m.get("marketValue") ==null
						 || m.get("assetStatus") ==null
						|| m.get("evaluateDate") ==null || m.get("submittingDate") ==null
						|| m.get("lastUpdateUserNum") ==null || m.get("lastUpdateOrgCd") ==null
						//抵质押物基本信息
						|| m.get("nationalityCd") ==null || m.get("provinceCd") ==null
						|| m.get("cityCd") ==null || m.get("districtCd") ==null
						|| m.get("streetAddress") ==null || m.get("acquireWayOfCollateralCd") ==null
						|| m.get("wayGuarantyEffectiveCd") ==null || m.get("commonAssetsInd") ==null
						|| m.get("rightCertTypeCd") ==null
						|| m.get("handoverDate") ==null || m.get("collateralCardDepartment") ==null
						//抵质押物状态信息
						|| m.get("takeoverInd") ==null || m.get("allPledgeInd") ==null
						|| m.get("rentedLicensedInd") ==null || m.get("nationalisationInd") ==null
						|| m.get("forbidCirculateInd") ==null || m.get("propertyDisputedInd") ==null
						|| m.get("invalidInd") ==null || m.get("blemishInd") ==null
						//机动车信息
						|| m.get("vehicleName") ==null || m.get("carCardNum") ==null
						|| m.get("frameworkNum") ==null || m.get("coverChargeCertInd") ==null
						|| m.get("oriPurchasePrice") ==null || m.get("carryLicenseInd") ==null
						|| m.get("hangDate") ==null || m.get("usedYear") ==null
						|| m.get("vehiclesNature") ==null || m.get("carBrand") ==null
						|| m.get("carType") ==null || m.get("producedDate") ==null
						|| m.get("purchaseYear") ==null || m.get("carAge") ==null
						){
					map.put("flag", "error");
					map.put("message", "非法数据访问");
					return map;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//价值信息  也是公共信息
				GrtCollateral grtCollateral = new GrtCollateral();
				String guarantyId = m.get("guarantyId").toString();
				grtCollateral.setGuarantyId(guarantyId);
				String currencyCd = m.get("currencyCd").toString();
				String marketValue = m.get("marketValue").toString();
				String assetStatus = m.get("assetStatus").toString();
				String evaluateDate = m.get("evaluateDate").toString();
				String submittingDate = m.get("submittingDate").toString();
				String lastUpdateUserNum = m.get("lastUpdateUserNum").toString();
				String lastUpdateOrgCd = m.get("lastUpdateOrgCd").toString();
				//抵质押物基本信息  也是公共信息
				String nationalityCd = m.get("nationalityCd").toString();
				String provinceCd = m.get("provinceCd").toString();
				String cityCd = m.get("cityCd").toString();
				String districtCd = m.get("districtCd").toString();
				String streetAddress = m.get("streetAddress").toString();
				String acquireWayOfCollateralCd = m.get("acquireWayOfCollateralCd").toString();
				String wayGuarantyEffectiveCd = m.get("wayGuarantyEffectiveCd").toString();
				String commonAssetsInd = m.get("commonAssetsInd").toString();
				String rightCertTypeCd = m.get("rightCertTypeCd").toString();
				String rightCertificationNum = m.get("rightCertificationNum")==null ? null : m.get("rightCertificationNum").toString();
				String handoverDate = m.get("handoverDate").toString();
				String collateralCardDepartment = m.get("collateralCardDepartment").toString();
				String commonOwnerName = m.get("commonOwnerName")==null ? null : m.get("commonOwnerName").toString();
				grtCollateral.setNationalityCd(nationalityCd);
				grtCollateral.setProvinceCd(provinceCd);
				grtCollateral.setCityCd(cityCd);
				grtCollateral.setDistrictCd(districtCd);
				grtCollateral.setStreetAddress(streetAddress);
				grtCollateral.setAcquireWayOfCollateralCd(acquireWayOfCollateralCd);
				grtCollateral.setWayGuarantyEffectiveCd(wayGuarantyEffectiveCd);
				grtCollateral.setRightCertTypeCd(rightCertTypeCd);
				grtCollateral.setRightCertificationNum(rightCertificationNum);
				grtCollateral.setHandoverDate(format.parse(handoverDate));
				grtCollateral.setCollateralCardDepartment(collateralCardDepartment);
				grtCollateral.setCommonOwnerName(commonOwnerName);
				//抵质押品状态信息  也是公共信息
				String takeoverInd = m.get("takeoverInd").toString();
				String allPledgeInd = m.get("allPledgeInd").toString();
				String rentedLicensedInd = m.get("rentedLicensedInd").toString();
				String nationalisationInd = m.get("nationalisationInd").toString();
				String forbidCirculateInd = m.get("forbidCirculateInd").toString();
				String propertyDisputedInd = m.get("propertyDisputedInd").toString();
				String invalidInd = m.get("invalidInd").toString();
				String blemishInd = m.get("blemishInd").toString();
				String renterName = m.get("renterName")==null ? null : m.get("renterName").toString();
				String leaseExpirationDate = m.get("leaseExpirationDate")==null ? null : m.get("leaseExpirationDate").toString();
				String isStateSectorApproval = m.get("isStateSectorApproval")==null ? null : m.get("isStateSectorApproval").toString();
				String blemishNote = m.get("blemishNote")==null ? null : m.get("blemishNote").toString();
				String otherNote = m.get("otherNote")==null ? null : m.get("otherNote").toString();
				grtCollateral.setTakeoverInd(takeoverInd);
				grtCollateral.setAllPledgeInd(allPledgeInd);
				grtCollateral.setRentedLicensedInd(rentedLicensedInd);
				grtCollateral.setNationalisationInd(nationalisationInd);
				grtCollateral.setForbidCirculateInd(forbidCirculateInd);
				grtCollateral.setPropertyDisputedInd(propertyDisputedInd);
				grtCollateral.setInvalidInd(invalidInd);
				grtCollateral.setBlemishInd(blemishInd);
				grtCollateral.setRenterName(renterName);
				if(leaseExpirationDate!=null && !leaseExpirationDate.equals("")){
					grtCollateral.setLeaseExpirationDate(format.parse(leaseExpirationDate));
				}
				grtCollateral.setIsStateSectorApproval(isStateSectorApproval);
				grtCollateral.setBlemishNote(blemishNote);
				grtCollateral.setCurrencyCd(currencyCd);
				grtCollateral.setMarketValue(new BigDecimal(marketValue));
				String bookValue = m.get("bookValue")==null ? null : m.get("bookValue").toString();
				if(bookValue!=null && !bookValue.equals("")){
					grtCollateral.setBookValue(new BigDecimal(bookValue));
				}
				grtCollateral.setAssetStatus(assetStatus);
				grtCollateral.setEvaluateDate(format.parse(evaluateDate));
				grtCollateral.setSubmittingDate(format.parse(submittingDate));
				grtCollateral.setLastUpdateOrgCd(lastUpdateOrgCd);
				grtCollateral.setLastUpdateUserNum(lastUpdateUserNum);
				grtCollateral.setSysUpdateTime(new Date());
				grtCollateral.setCommonAssetsInd(commonAssetsInd);
				grtCollateral.setOtherNote(otherNote);
				//机动车信息 保存了两张表，一张机动车表，一张交通运输设备表
				//机动车信息
				GrtTrafficCar grtTrafficCar = new GrtTrafficCar();
				String carCardNum = m.get("carCardNum").toString();
				String frameworkNum = m.get("frameworkNum").toString();
				String oriPurchasePrice = m.get("oriPurchasePrice").toString();
				String dirverLicenseInd = m.get("dirverLicenseInd")==null ? null : m.get("dirverLicenseInd").toString();
				String hangDate = m.get("hangDate").toString();
				String carType = m.get("carType").toString();
				String producedDate = m.get("producedDate").toString();
				String vehiclesNature = m.get("vehiclesNature").toString();
				String color = m.get("color")==null ? null : m.get("color").toString();
				String fuel = m.get("fuel")==null ? null : m.get("fuel").toString();
				String licenseNum = m.get("licenseNum")==null ? null : m.get("licenseNum").toString();
				String licenseDepartment = m.get("licenseDepartment")==null ? null : m.get("licenseDepartment").toString();
				String runnedKm = m.get("runnedKm")==null ? null : m.get("runnedKm").toString();
				String registerAddress = m.get("registerAddress")==null ? null : m.get("registerAddress").toString();
				String licenseOwner = m.get("licenseOwner")==null ? null : m.get("licenseOwner").toString();
				String coverChargeCertInd = m.get("coverChargeCertInd")==null ? null : m.get("coverChargeCertInd").toString();
				String carryLicenseInd = m.get("carryLicenseInd")==null ? null : m.get("carryLicenseInd").toString();
				String invoiceNo = m.get("invoiceNo")==null ? null : m.get("invoiceNo").toString();
				grtTrafficCar.setGuarantyId(guarantyId);
				grtTrafficCar.setCarCardNum(carCardNum);
				grtTrafficCar.setFrameworkNum(frameworkNum);
				grtTrafficCar.setOriPurchasePrice(new BigDecimal(oriPurchasePrice));
				grtTrafficCar.setDirverLicenseInd(dirverLicenseInd);
				grtTrafficCar.setHangDate(format.parse(hangDate));
				grtTrafficCar.setCarType(carType);
				grtTrafficCar.setProducedDate(format.parse(producedDate));
				grtTrafficCar.setColor(color);
				grtTrafficCar.setFuel(fuel);
				grtTrafficCar.setLicenseNum(licenseNum);
				grtTrafficCar.setVehiclesNature(vehiclesNature);
				grtTrafficCar.setLicenseDepartment(licenseDepartment);
				if(runnedKm!=null && !runnedKm.equals("")){
					grtTrafficCar.setRunnedKm(new BigDecimal(runnedKm));
				}
				grtTrafficCar.setRegisterAddress(registerAddress);
				grtTrafficCar.setLicenseOwner(licenseOwner);
				grtTrafficCar.setCoverChargeCertInd(coverChargeCertInd);
				grtTrafficCar.setInvoiceNo(invoiceNo);
				grtTrafficCar.setCarryLicenseInd(carryLicenseInd);
				//交通运输设备信息
				GrtVehicleTypeMortgage grtVehicleTypeMortgage = new GrtVehicleTypeMortgage();
				String vehicleName = m.get("vehicleName").toString();
				String engineNum = m.get("engineNum")==null ? null : m.get("engineNum").toString();
				String usedYear = m.get("usedYear").toString();
				String carBrand = m.get("carBrand").toString();
				String purchaseYear = m.get("purchaseYear").toString();
				String carAge = m.get("carAge").toString();
				String manufacturingCompany = m.get("manufacturingCompany")==null ? null : m.get("manufacturingCompany").toString();
				String rejectYear = m.get("rejectYear")==null ? null : m.get("rejectYear").toString();
				String troubleRecords = m.get("troubleRecords")==null ? null : m.get("troubleRecords").toString();
				grtVehicleTypeMortgage.setGuarantyId(guarantyId);
				grtVehicleTypeMortgage.setVehicleName(vehicleName);
				grtVehicleTypeMortgage.setEngineNum(engineNum);
				grtVehicleTypeMortgage.setUsedYear(new BigDecimal(usedYear));
				grtVehicleTypeMortgage.setCarBrand(carBrand);
				grtVehicleTypeMortgage.setPurchaseYear(format.parse(purchaseYear));
				grtVehicleTypeMortgage.setCarAge(new BigDecimal(carAge));
				grtVehicleTypeMortgage.setManufacturingCompany(manufacturingCompany);
				grtVehicleTypeMortgage.setCarType(carType);
				if(rejectYear!=null && !rejectYear.equals("")){
					grtVehicleTypeMortgage.setRejectYear(format.parse(rejectYear));
				}
				grtVehicleTypeMortgage.setTroubleRecords(troubleRecords);
				map = grtCollateralServiceImpl.updateTrafficCarAndGrtCollateral(grtCollateral,grtVehicleTypeMortgage,grtTrafficCar);
			} catch (Exception e) {
				map.put("flag", "error");
				map.put("message", "服务器出错啦，请联系开发者!");
				System.out.println(e.getMessage());
			}
		} else{
			map.put("flag", "error");
			map.put("message", "非法数据访问");
		}
		return map;
	}
	/**
	 * 根据guarantyId查询农机具信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectAgricultureToolByGuarantyId")
	public Map<String, Object> selectAgricultureToolByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectAgricultureToolByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询票据信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectBillByGuarantyId")
	public Map<String, Object> selectBillByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectBillByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询债券信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectBondPledgeByGuarantyId")
	public Map<String, Object> selectBondPledgeByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectBondPledgeByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询在建工程信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectBuildingProjectByGuarantyId")
	public Map<String, Object> selectBuildingProjectByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectBuildingProjectByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询收费权信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectChargingRightMortgageByGuarantyId")
	public Map<String, Object> selectChargingRightMortgageByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectChargingRightMortgageByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询存单信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectGrtDepositByGuarantyId")
	public Map<String, Object> selectGrtDepositByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectGrtDepositByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询林权信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectWoodlandPropertyByGuarantyId")
	public Map<String, Object> selectWoodlandPropertyByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectWoodlandPropertyByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询基金信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectFundByGuarantyId")
	public Map<String, Object> selectFundByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectFundByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询应收账款信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectReceivableByGuarantyId")
	public Map<String, Object> selectReceivableByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectReceivableByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询知识产权信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectIntellPropertyRightsByGuarantyId")
	public Map<String, Object> selectIntellPropertyRightsByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectIntellPropertyRightsByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询土地承包经营信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectLandManagementRightByGuarantyId")
	public Map<String, Object> selectLandManagementRightByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectLandManagementRightByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询土地使用权信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectLandUseRightByGuarantyId")
	public Map<String, Object> selectLandUseRightByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectLandUseRightByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询机器设备信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectMachineEquipmentByGuarantyId")
	public Map<String, Object> selectMachineEquipmentByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectMachineEquipmentByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询机动车信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectTrafficCarByGuarantyId")
	public Map<String, Object> selectTrafficCarByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectTrafficCarByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询其他抵质押信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectOtherByGuarantyId")
	public Map<String, Object> selectOtherByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectOtherByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询工资账户信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectEarningsAccountByGuarantyId")
	public Map<String, Object> selectEarningsAccountByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectEarningsAccountByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询船舶信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectShipByGuarantyId")
	public Map<String, Object> selectShipByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectShipByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询存货信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectMerchandiseByGuarantyId")
	public Map<String, Object> selectMerchandiseByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectMerchandiseByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询股权信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectStockWarrantAssetsByGuarantyId")
	public Map<String, Object> selectStockWarrantAssetsByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectStockWarrantAssetsByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询交通运输工具信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectTrafficOthersByGuarantyId")
	public Map<String, Object> selectTrafficOthersByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectTrafficOthersByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询仓单信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectStandardDepotImpawnByGuarantyId")
	public Map<String, Object> selectStandardDepotImpawnByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectStandardDepotImpawnByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询保单信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectGuaranteeSlipByGuarantyId")
	public Map<String, Object> selectGuaranteeSlipByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectGuaranteeSlipByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * 根据guarantyId查询房地产信息
	 * @param guarantyId
	 * @return
	 */
	@GetMapping("/selectRealEstateByGuarantyId")
	public Map<String, Object> selectRealEstateByGuarantyId(
			@RequestParam(value="guarantyId",required=true) String guarantyId
			){
		Map<String, Object> map = new HashMap<>();
		try {
			map = grtCollateralServiceImpl.selectRealEstateByGuarantyId(guarantyId);
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("message", "操作失败啦！");
			System.out.println(e.getMessage());
		}
		return map;
	}
}
