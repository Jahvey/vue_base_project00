package com.cdgit.loan.securitymanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.common.constants.Constant;
import com.cdgit.loan.common.util.BeanUtils;
import com.cdgit.loan.securitymanagement.bean.GrtBill;
import com.cdgit.loan.securitymanagement.bean.GrtBondPledge;
import com.cdgit.loan.securitymanagement.bean.GrtBuildingProject;
import com.cdgit.loan.securitymanagement.bean.GrtChargingRightMortgage;
import com.cdgit.loan.securitymanagement.bean.GrtCollateral;
import com.cdgit.loan.securitymanagement.bean.GrtCollateralInsurance;
import com.cdgit.loan.securitymanagement.bean.GrtCurrentAssets;
import com.cdgit.loan.securitymanagement.bean.GrtDeposit;
import com.cdgit.loan.securitymanagement.bean.GrtEarningsAccount;
import com.cdgit.loan.securitymanagement.bean.GrtFund;
import com.cdgit.loan.securitymanagement.bean.GrtGuaranteeSlip;
import com.cdgit.loan.securitymanagement.bean.GrtIntangibleAssets;
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
import com.cdgit.loan.securitymanagement.mapper.GrtBillMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtBondPledgeMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtBuildingProjectMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtChargingRightMortgageMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtCollateralMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtCurrentAssetsMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtDepositMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtEarningsAccountMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtFundMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtGuaranteeSlipMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtIntangibleAssetsMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtIntellPropertyRightsMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtLandManagementRightMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtLandUseRightMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtMachineEquipmentMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtMerchandiseMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtRealEstateDetailMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtRealEstateMortgageMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtReceivableMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtStandardDepotImpawnMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtStockPledgeMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtStockRightAssetsMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtStockWarrantAssetsMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtTrafficCarMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtTrafficOthersMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtTrafficShipMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtVehicleTypeMortgageMapper;
import com.cdgit.loan.securitymanagement.mapper.GrtWoodlandPropertyMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class GrtCollateralServiceImpl {
	@Autowired
    private GrtCollateralMapper grtCollateralMapper;
	@Autowired
    private GrtDepositMapper grtDepositMapper;
	@Autowired
    private GrtIntangibleAssetsMapper grtIntangibleAssetsMapper;
	@Autowired
	private GrtRealEstateMortgageMapper grtRealEstateMortgageMapper;
	@Autowired
	private GrtBuildingProjectMapper grtBuildingProjectMapper;
	@Autowired
	private GrtTrafficCarMapper grtTrafficCarMapper;
	@Autowired
	private GrtVehicleTypeMortgageMapper grtVehicleTypeMortgageMapper;
	@Autowired
	private GrtRealEstateDetailMapper grtRealEstateDetailMapper;
	@Autowired
	private GrtTrafficShipMapper grtTrafficShipMapper;
	@Autowired
	private GrtLandUseRightMapper grtLandUseRightMapper;
	@Autowired
	private GrtEarningsAccountMapper grtEarningsAccountMapper;
	@Autowired
	private GrtLandManagementRightMapper grtLandManagementRightMapper;
	@Autowired
	private GrtMerchandiseMapper grtMerchandiseMapper;
	@Autowired
	private GrtCurrentAssetsMapper grtCurrentAssetsMapper;
	@Autowired
	private GrtChargingRightMortgageMapper grtChargingRightMortgageMapper;
	@Autowired
	private GrtBondPledgeMapper grtBondPledgeMapper;
	@Autowired
	private GrtWoodlandPropertyMapper grtWoodlandPropertyMapper;
	@Autowired
	private GrtIntellPropertyRightsMapper grtIntellPropertyRightsMapper;
	@Autowired
	private GrtReceivableMapper grtReceivableMapper;
	@Autowired
	private GrtStockPledgeMapper grtStockPledgeMapper;
	@Autowired
	private GrtFundMapper grtFundMapper;
	@Autowired
	private GrtStockRightAssetsMapper grtStockRightAssetsMapper;
	@Autowired
	private GrtStockWarrantAssetsMapper grtStockWarrantAssetsMapper;
	@Autowired
	private GrtBillMapper grtBillMapper;
	@Autowired
	private GrtStandardDepotImpawnMapper grtStandardDepotImpawnMapper;
	@Autowired
	private GrtGuaranteeSlipMapper grtGuaranteeSlipMapper;
	@Autowired
	private GrtMachineEquipmentMapper grtMachineEquipmentMapper;
	@Autowired
	private GrtTrafficOthersMapper grtTrafficOthersMapper;
	public Map<String, Object> saveGrtCollateral(GrtCollateral grtCollateral) throws JsonProcessingException{
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.insertSelective(grtCollateral);
		if(i>0){
			//根据类型插入
			if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_FDC)){//房地产
				GrtRealEstateMortgage grtRealEstateMortgage = new GrtRealEstateMortgage();
				grtRealEstateMortgage.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtRealEstateMortgageMapper.insertSelective(grtRealEstateMortgage);
				if(i>0){
					GrtRealEstateDetail grtRealEstateDetail = new GrtRealEstateDetail();
					grtRealEstateDetail.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtRealEstateDetailMapper.insertSelective(grtRealEstateDetail);
					if(i>0){
					
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入房产地产表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入房产类型表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_ZJGC)){//在建工程
				GrtRealEstateMortgage grtRealEstateMortgage = new GrtRealEstateMortgage();
				grtRealEstateMortgage.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtRealEstateMortgageMapper.insertSelective(grtRealEstateMortgage);
				if(i>0){
					GrtBuildingProject grtBuildingProject = new GrtBuildingProject();
					grtBuildingProject.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtBuildingProjectMapper.insertSelective(grtBuildingProject);
					if(i>0){
					
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入在建工程表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入房产类型表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_TDCBJYQ)){//土地承包经营权
				//插入无形资产表
				GrtIntangibleAssets grtIntangibleAssets = new GrtIntangibleAssets();
				grtIntangibleAssets.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtIntangibleAssetsMapper.insertSelective(grtIntangibleAssets);
				if(i>0){
					GrtLandManagementRight grtLandManagementRight = new GrtLandManagementRight();
					grtLandManagementRight.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtLandManagementRightMapper.insertSelective(grtLandManagementRight);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入土地承包经营权失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入流动资产表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_TDSYQ)){//土地使用权
				//插入无形资产表
				GrtIntangibleAssets grtIntangibleAssets = new GrtIntangibleAssets();
				grtIntangibleAssets.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtIntangibleAssetsMapper.insertSelective(grtIntangibleAssets);
				if(i>0){
					GrtLandUseRight grtLandUseRight = new GrtLandUseRight();
					grtLandUseRight.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtLandUseRightMapper.insertSelective(grtLandUseRight);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入土地使用权表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入无形资产表失败");
				}
				
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_CB)){//船舶
				GrtVehicleTypeMortgage grtVehicleTypeMortgage = new GrtVehicleTypeMortgage();
				grtVehicleTypeMortgage.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtVehicleTypeMortgageMapper.insertSelective(grtVehicleTypeMortgage);
				if(i>0){
					GrtTrafficShip grtTrafficShip = new GrtTrafficShip();
					grtTrafficShip.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtTrafficShipMapper.insertSelective(grtTrafficShip);
					if(i>0){
					
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入船舶表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入交通运输设备表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_LQ)){//林权
				GrtWoodlandProperty grtWoodlandProperty = new GrtWoodlandProperty();
				grtWoodlandProperty.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtWoodlandPropertyMapper.insertSelective(grtWoodlandProperty);
				if(i>0){
					
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入林权表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_CH)){//存货
				//插入流动资产表
				GrtCurrentAssets grtCurrentAssets = new GrtCurrentAssets();
				grtCurrentAssets.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtCurrentAssetsMapper.insertSelective(grtCurrentAssets);
				if(i>0){
					GrtMerchandise grtMerchandise = new GrtMerchandise();
					grtMerchandise.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtMerchandiseMapper.insertSelective(grtMerchandise);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入存货表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入流动资产表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_ZSCQ)){//知识产权
				//插入无形资产表
				GrtIntangibleAssets grtIntangibleAssets = new GrtIntangibleAssets();
				grtIntangibleAssets.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtIntangibleAssetsMapper.insertSelective(grtIntangibleAssets);
				if(i>0){
					GrtIntellPropertyRights grtIntellPropertyRights = new GrtIntellPropertyRights();
					grtIntellPropertyRights.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtIntellPropertyRightsMapper.insertSelective(grtIntellPropertyRights);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入知识产权表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入无形资产表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_YSZK)){//应收账款
				//插入无形资产表
				GrtIntangibleAssets grtIntangibleAssets = new GrtIntangibleAssets();
				grtIntangibleAssets.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtIntangibleAssetsMapper.insertSelective(grtIntangibleAssets);
				if(i>0){
					GrtReceivable grtReceivable = new GrtReceivable();
					grtReceivable.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtReceivableMapper.insertSelective(grtReceivable);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入应收账款表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入无形资产表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_JJ)){//基金
				//插入公共表
				GrtStockPledge grtStockPledge = new GrtStockPledge();
				grtStockPledge.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtStockPledgeMapper.insertSelective(grtStockPledge);
				if(i>0){
					GrtFund grtFund = new GrtFund();
					grtFund.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtFundMapper.insertSelective(grtFund);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入基金表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入股权、股票、基金公共信息表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_GQ)){//股权
				//插入公共表
				GrtStockPledge grtStockPledge = new GrtStockPledge();
				grtStockPledge.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtStockPledgeMapper.insertSelective(grtStockPledge);
				if(i>0){
					GrtStockWarrantAssets grtStockWarrantAssets = new GrtStockWarrantAssets();
					grtStockWarrantAssets.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtStockWarrantAssetsMapper.insertSelective(grtStockWarrantAssets);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入股权表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入股权、股票、基金公共信息表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_CD)){//存单
				//插入无形资产表
				GrtIntangibleAssets grtIntangibleAssets = new GrtIntangibleAssets();
				grtIntangibleAssets.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtIntangibleAssetsMapper.insertSelective(grtIntangibleAssets);
				if(i>0){
					GrtDeposit grtDeposit = new GrtDeposit();
					grtDeposit.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtDepositMapper.insertSelective(grtDeposit);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入存单表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入无形资产表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_GZZH)){//工资账户
				//插入无形资产表
				GrtIntangibleAssets grtIntangibleAssets = new GrtIntangibleAssets();
				grtIntangibleAssets.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtIntangibleAssetsMapper.insertSelective(grtIntangibleAssets);
				if(i>0){
					GrtEarningsAccount grtEarningsAccount = new GrtEarningsAccount();
					grtEarningsAccount.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtEarningsAccountMapper.insertSelective(grtEarningsAccount);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入工资账户表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入无形资产表失败");
				}
				
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_ZJ)){//债券
				GrtBondPledge grtBondPledge = new GrtBondPledge();
				grtBondPledge.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtBondPledgeMapper.insertSelective(grtBondPledge);
				if(i>0){
					
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入债券表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_SFQ)){//收费权
				GrtChargingRightMortgage grtChargingRightMortgage = new GrtChargingRightMortgage();
				grtChargingRightMortgage.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtChargingRightMortgageMapper.insertSelective(grtChargingRightMortgage);
				if(i>0){
					
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入收费权表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_PJ)){//票据
				GrtBill grtBill = new GrtBill();
				grtBill.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtBillMapper.insertSelective(grtBill);
				if(i>0){
					
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入票据表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_CANGD)){//仓单
				//插入流动资产表
				GrtCurrentAssets grtCurrentAssets = new GrtCurrentAssets();
				grtCurrentAssets.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtCurrentAssetsMapper.insertSelective(grtCurrentAssets);
				if(i>0){
					GrtStandardDepotImpawn grtStandardDepotImpawn = new GrtStandardDepotImpawn();
					grtStandardDepotImpawn.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtStandardDepotImpawnMapper.insertSelective(grtStandardDepotImpawn);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入仓单表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入流动资产表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_BD)){//保单
				//插入流动资产表
				GrtCurrentAssets grtCurrentAssets = new GrtCurrentAssets();
				grtCurrentAssets.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtCurrentAssetsMapper.insertSelective(grtCurrentAssets);
				if(i>0){
					GrtGuaranteeSlip grtGuaranteeSlip = new GrtGuaranteeSlip();
					grtGuaranteeSlip.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtGuaranteeSlipMapper.insertSelective(grtGuaranteeSlip);
					if(i>0){
						
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入保单表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入流动资产表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_JQSB)){//机器设备
				GrtMachineEquipment grtMachineEquipment = new GrtMachineEquipment();
				grtMachineEquipment.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtMachineEquipmentMapper.insertSelective(grtMachineEquipment);
				if(i>0){
					
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入机器设备表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_JTYSGJ)){//交通运输工具
				GrtVehicleTypeMortgage grtVehicleTypeMortgage = new GrtVehicleTypeMortgage();
				grtVehicleTypeMortgage.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtVehicleTypeMortgageMapper.insertSelective(grtVehicleTypeMortgage);
				if(i>0){
					GrtTrafficOthers grtTrafficOthers = new GrtTrafficOthers();
					grtTrafficOthers.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtTrafficOthersMapper.insertSelective(grtTrafficOthers);
					if(i>0){
					
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入交通运输工具(其他交通工具)信息表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入交通运输设备表失败");
				}
			}else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_JDC) || 
					grtCollateral.getCollateralTypeCd().equals(Constant.GC_NJJ) ){//机动车或者农机具
				GrtVehicleTypeMortgage grtVehicleTypeMortgage = new GrtVehicleTypeMortgage();
				grtVehicleTypeMortgage.setGuarantyId(grtCollateral.getGuarantyId());
				i = grtVehicleTypeMortgageMapper.insertSelective(grtVehicleTypeMortgage);
				if(i>0){
					GrtTrafficCar grtTrafficCar = new GrtTrafficCar();
					grtTrafficCar.setGuarantyId(grtCollateral.getGuarantyId());
					i = grtTrafficCarMapper.insertSelective(grtTrafficCar);
					if(i>0){
					
					} else{
						map.put("flag", "false");
						map.put("message", "操作失败!");
						throw new RuntimeException("插入机动车(农机具)表失败");
					}
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("插入交通运输设备表失败");
				}
				
			}/*else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_NJJ)){//农机具
				
			}*/else if(grtCollateral.getCollateralTypeCd().equals(Constant.GC_QT)){//其他
				//其他信息没有单独的表，就一张抵质押品表
			}
			map.put("grtCollateral", grtCollateral);
			map.put("flag", "true");
			map.put("message", "操作成功!");
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("插入抵质押品表失败");
		}
		return map;
	}
	public Map<String, Object> updateGrtDepositAndGrtCollateral(GrtCollateral grtCollateral, GrtDeposit grtDeposit) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtDepositMapper.updateByPrimaryKeySelective(grtDeposit);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新存单表失败");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押物表发生异常");
		}
		return map;
	}
	public Map<String, Object> updateBuildingProjectAndGrtCollateral(GrtCollateral grtCollateral,
			GrtRealEstateMortgage grtRealEstateMortgage, GrtBuildingProject grtBuildingProject) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtRealEstateMortgageMapper.updateByPrimaryKeySelective(grtRealEstateMortgage);
			if(i>0){
				i = grtBuildingProjectMapper.updateByPrimaryKeySelective(grtBuildingProject);
				if(i>0){
					map.put("flag", "true");
					map.put("message", "操作成功!");
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("更新在建工程表发生异常");
				}
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新房产类型抵押表发生异常");
			}
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押物表发生异常");
		}
		return map;
	}
	public Map<String, Object> updateRealEstateAndGrtCollateral(GrtCollateral grtCollateral,
			GrtRealEstateMortgage grtRealEstateMortgage, GrtRealEstateDetail grtRealEstateDetail) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtRealEstateMortgageMapper.updateByPrimaryKeySelective(grtRealEstateMortgage);
			if(i>0){
				i = grtRealEstateDetailMapper.updateByPrimaryKeySelective(grtRealEstateDetail);
				if(i>0){
					map.put("flag", "true");
					map.put("message", "操作成功!");
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("更新房产其他信息表发生异常");
				}
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新房产类型抵押表发生异常");
			}
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押物表发生异常");
		}
		return map;
	}
	public Map<String, Object> updateTrafficCarAndGrtCollateral(GrtCollateral grtCollateral,
			GrtVehicleTypeMortgage grtVehicleTypeMortgage, GrtTrafficCar grtTrafficCar) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtVehicleTypeMortgageMapper.updateByPrimaryKeySelective(grtVehicleTypeMortgage);
			if(i>0){
				i = grtTrafficCarMapper.updateByPrimaryKeySelective(grtTrafficCar);
				if(i>0){
					map.put("flag", "true");
					map.put("message", "操作成功!");
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("更新机动车或者农机具信息表发生异常");
				}
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新交通运输设备表发生异常");
			}
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押物表发生异常");
		}
		return map;
	}
	public Map<String, Object> updateShipAndGrtCollateral(GrtCollateral grtCollateral,
			GrtVehicleTypeMortgage grtVehicleTypeMortgage, GrtTrafficShip grtTrafficShip) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtVehicleTypeMortgageMapper.updateByPrimaryKeySelective(grtVehicleTypeMortgage);
			if(i>0){
				i = grtTrafficShipMapper.updateByPrimaryKeySelective(grtTrafficShip);
				if(i>0){
					map.put("flag", "true");
					map.put("message", "操作成功!");
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("更新船舶信息表发生异常");
				}
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新交通运输设备表发生异常");
			}
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押物表发生异常");
		}
		return map;
	}
	public Map<String, Object> updateLandUseRightAndGrtCollateral(GrtCollateral grtCollateral,
			GrtLandUseRight grtLandUseRight) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtLandUseRightMapper.updateByPrimaryKeySelective(grtLandUseRight);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新土地使用权表失败了");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateEarningsAccountAndGrtCollateral(GrtCollateral grtCollateral,
			GrtEarningsAccount grtEarningsAccount) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtEarningsAccountMapper.updateByPrimaryKeySelective(grtEarningsAccount);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新工资账户表失败了");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateOtherAndGrtCollateral(GrtCollateral grtCollateral) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			map.put("flag", "true");
			map.put("message", "操作成功!");
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateLandManagementRightAndGrtCollateral(GrtCollateral grtCollateral,
			GrtLandManagementRight grtLandManagementRight) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtLandManagementRightMapper.updateByPrimaryKeySelective(grtLandManagementRight);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新土地承包经营权表失败了");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateMerchandiseAndGrtCollateral(GrtCollateral grtCollateral,
			GrtMerchandise grtMerchandise) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtMerchandiseMapper.updateByPrimaryKeySelective(grtMerchandise);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新存货表失败");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateChargingRightMortgageAndGrtCollateral(GrtCollateral grtCollateral,
			GrtChargingRightMortgage grtChargingRightMortgage) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtChargingRightMortgageMapper.updateByPrimaryKeySelective(grtChargingRightMortgage);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新收费权表失败");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateBondPledgeAndGrtCollateral(GrtCollateral grtCollateral,
			GrtBondPledge grtBondPledge) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtBondPledgeMapper.updateByPrimaryKeySelective(grtBondPledge);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新债券表失败");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateWoodlandPropertyAndGrtCollateral(GrtCollateral grtCollateral,
			GrtWoodlandProperty grtWoodlandProperty) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtWoodlandPropertyMapper.updateByPrimaryKeySelective(grtWoodlandProperty);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新林权表失败");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateIntellPropertyRightsAndGrtCollateral(GrtCollateral grtCollateral,
			GrtIntellPropertyRights grtIntellPropertyRights) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtIntellPropertyRightsMapper.updateByPrimaryKeySelective(grtIntellPropertyRights);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新知识产权表失败");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateReceivableAndGrtCollateral(GrtCollateral grtCollateral,
			GrtReceivable grtReceivable) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtReceivableMapper.updateByPrimaryKeySelective(grtReceivable);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新应收账款失败");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateStockWarrantAssetsAndGrtCollateral(GrtCollateral grtCollateral,
			GrtStockPledge grtStockPledge, GrtStockWarrantAssets grtStockWarrantAssets) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtStockPledgeMapper.updateByPrimaryKeySelective(grtStockPledge);
			if(i>0){
				i = grtStockWarrantAssetsMapper.updateByPrimaryKeySelective(grtStockWarrantAssets);
				if(i>0){
					map.put("flag", "true");
					map.put("message", "操作成功!");
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("更新股权表发生异常");
				}
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新股权、股票、基金公共信息表表发生异常");
			}
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押物表发生异常");
		}
		return map;
	}
	public Map<String, Object> updateFundAndGrtCollateral(GrtCollateral grtCollateral, GrtStockPledge grtStockPledge,
			GrtFund grtFund) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtStockPledgeMapper.updateByPrimaryKeySelective(grtStockPledge);
			if(i>0){
				i = grtFundMapper.updateByPrimaryKeySelective(grtFund);
				if(i>0){
					map.put("flag", "true");
					map.put("message", "操作成功!");
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("更新基金表发生异常");
				}
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新股权、股票、基金公共信息表表发生异常");
			}
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押物表发生异常");
		}
		return map;
	}
	public Map<String, Object> updateBillAndGrtCollateral(GrtCollateral grtCollateral, GrtBill grtBill) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtBillMapper.updateByPrimaryKeySelective(grtBill);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新票据失败");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateStandardDepotImpawnAndGrtCollateral(GrtCollateral grtCollateral,
			GrtStandardDepotImpawn grtStandardDepotImpawn) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtStandardDepotImpawnMapper.updateByPrimaryKeySelective(grtStandardDepotImpawn);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新仓单失败了");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateGuaranteeSlipAndGrtCollateral(GrtCollateral grtCollateral,
			GrtGuaranteeSlip grtGuaranteeSlip) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtGuaranteeSlipMapper.updateByPrimaryKeySelective(grtGuaranteeSlip);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新保单失败了");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateMachineEquipmentAndGrtCollateral(GrtCollateral grtCollateral,
			GrtMachineEquipment grtMachineEquipment) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtMachineEquipmentMapper.updateByPrimaryKeySelective(grtMachineEquipment);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新机器设备表失败了");
			}
		}else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押品表失败了！");
		}
		return map;
	}
	public Map<String, Object> updateTrafficOthersAndGrtCollateral(GrtCollateral grtCollateral,
			GrtVehicleTypeMortgage grtVehicleTypeMortgage, GrtTrafficOthers grtTrafficOthers) {
		Map<String, Object> map = new HashMap<>();
		int i = grtCollateralMapper.updateByPrimaryKeySelective(grtCollateral);
		if(i>0){
			i = grtVehicleTypeMortgageMapper.updateByPrimaryKeySelective(grtVehicleTypeMortgage);
			if(i>0){
				i = grtTrafficOthersMapper.updateByPrimaryKeySelective(grtTrafficOthers);
				if(i>0){
					map.put("flag", "true");
					map.put("message", "操作成功!");
				} else{
					map.put("flag", "false");
					map.put("message", "操作失败!");
					throw new RuntimeException("更新交通运输工具(其他交通工具)信息表发生异常");
				}
			} else{
				map.put("flag", "false");
				map.put("message", "操作失败!");
				throw new RuntimeException("更新交通运输设备表发生异常");
			}
		} else{
			map.put("flag", "false");
			map.put("message", "操作失败!");
			throw new RuntimeException("更新抵质押物表发生异常");
		}
		return map;
	}
	public Map<String, Object> selectGrtCollateralAll(Integer pageNum, Integer pageSize,
			String userNum, String orgNum,
			String orderField, String sort,
			String customerType, String partyNum, String partyName, String certType, String certNum,
			String collateralTypeCd, String collateralName, String isFarmer, String phoneNumber) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(pageNum,pageSize);
		List list = null;
		if(customerType.equals(Constant.CUSTOMER_TYPE_NATURAL_PERSON)){//自然人客户
			list = grtCollateralMapper.selectNaturalPersonCollateralAll(userNum,
					orgNum,orderField,sort,customerType,partyNum,partyName,certType,certNum,collateralTypeCd,
					collateralName,isFarmer,phoneNumber);
		} else {//法人客户
			map.put("flag", "false");
			map.put("message", "自然人以外的客户类型未开发！");
		}
		PageInfo<GrtCollateral> pageInfo = new PageInfo<>(list, pageSize);
		map.put("data", pageInfo);
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> deleteGrtCollateralById(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		//删除之前的判断
		//1.是否已经关联合同，关联不能删除
		//2.删除子表信息，担保品共有人、保险、登记、公证、意外不是级联删除
		Map<String, Object> m = grtCollateralMapper.selectBandRelationResult(guarantyId);
		Integer TOGETHER = Integer.parseInt(m.get("TOGETHER").toString());
		Integer INSURANCE =Integer.parseInt(m.get("INSURANCE").toString());
		Integer REGISTRATION =Integer.parseInt(m.get("REGISTRATION").toString());
		Integer NOTARIZATION = Integer.parseInt(m.get("NOTARIZATION").toString());
		Integer ACCIDENT = Integer.parseInt(m.get("ACCIDENT").toString());
		if(TOGETHER>0 || INSURANCE>0 || REGISTRATION>0 || NOTARIZATION>0 || ACCIDENT>0){
			StringBuilder sb = new StringBuilder();
			sb.append("请先删除该抵质押品关联的以下信息:");
			if(TOGETHER>0){
				sb.append("共有人信息,");
			}
			if(INSURANCE>0){
				sb.append("保险信息,");
			}
			if(REGISTRATION>0){
				sb.append("登记信息,");
			}
			if(NOTARIZATION>0){
				sb.append("公证信息,");
			}
			if(ACCIDENT>0){
				sb.append("意外信息,");
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			map.put("flag", "false");
			map.put("message", sb.toString());
		} else{
			//直接删除
			int i = grtCollateralMapper.deleteByPrimaryKey(guarantyId);
			if(i>0){
				map.put("flag", "true");
				map.put("message", "操作成功!");
			} else{
				map.put("flag", "false");
				map.put("message", "删除失败！");
			}
		}
		return map;
	}
	public Map<String, Object> deleteGrtCollateralBatch(String[] ids) {
		Map<String, Object> map = new HashMap<>();
		
		return map;
	}
	public Map<String, Object> selectAgricultureToolByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtVehicleTypeMortgage mortgage = grtVehicleTypeMortgageMapper.selectByPrimaryKey(guarantyId);
		GrtTrafficCar trafficCar = grtTrafficCarMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(trafficCar,mortgage,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectBillByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtBill grtBill = grtBillMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtBill,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectBondPledgeByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtBondPledge grtBondPledge = grtBondPledgeMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtBondPledge,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectBuildingProjectByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtRealEstateMortgage grtRealEstateMortgage = grtRealEstateMortgageMapper.selectByPrimaryKey(guarantyId);
		GrtBuildingProject grtBuildingProject = grtBuildingProjectMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtBuildingProject,grtRealEstateMortgage,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectChargingRightMortgageByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtChargingRightMortgage grtChargingRightMortgage = grtChargingRightMortgageMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtChargingRightMortgage,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectGrtDepositByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtDeposit grtDeposit = grtDepositMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtDeposit,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectWoodlandPropertyByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtWoodlandProperty grtWoodlandProperty = grtWoodlandPropertyMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtWoodlandProperty,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectFundByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtStockPledge grtStockPledge = grtStockPledgeMapper.selectByPrimaryKey(guarantyId);
		GrtFund grtFund = grtFundMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtFund,grtStockPledge,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectReceivableByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtReceivable grtReceivable = grtReceivableMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtReceivable,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectIntellPropertyRightsByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtIntellPropertyRights grtIntellPropertyRights = grtIntellPropertyRightsMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtIntellPropertyRights,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectLandManagementRightByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtLandManagementRight grtLandManagementRight = grtLandManagementRightMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtLandManagementRight,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectLandUseRightByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtLandUseRight grtLandUseRight = grtLandUseRightMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtLandUseRight,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectMachineEquipmentByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtMachineEquipment grtMachineEquipment = grtMachineEquipmentMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtMachineEquipment,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectTrafficCarByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtTrafficCar grtTrafficCar = grtTrafficCarMapper.selectByPrimaryKey(guarantyId);
		GrtVehicleTypeMortgage grtVehicleTypeMortgage = grtVehicleTypeMortgageMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtTrafficCar,grtVehicleTypeMortgage,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectOtherByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectEarningsAccountByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtEarningsAccount grtEarningsAccount = grtEarningsAccountMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtEarningsAccount,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectShipByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtVehicleTypeMortgage grtVehicleTypeMortgage = grtVehicleTypeMortgageMapper.selectByPrimaryKey(guarantyId);
		GrtTrafficShip grtTrafficShip = grtTrafficShipMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtTrafficShip,grtVehicleTypeMortgage,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectMerchandiseByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtMerchandise grtMerchandise = grtMerchandiseMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtMerchandise,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectStockWarrantAssetsByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtStockPledge grtStockPledge = grtStockPledgeMapper.selectByPrimaryKey(guarantyId);
		GrtStockWarrantAssets grtStockWarrantAssets = grtStockWarrantAssetsMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtStockWarrantAssets,grtStockPledge,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectTrafficOthersByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtVehicleTypeMortgage grtVehicleTypeMortgage = grtVehicleTypeMortgageMapper.selectByPrimaryKey(guarantyId);
		GrtTrafficOthers grtTrafficOthers = grtTrafficOthersMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtTrafficOthers,grtVehicleTypeMortgage,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectStandardDepotImpawnByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtStandardDepotImpawn grtStandardDepotImpawn = grtStandardDepotImpawnMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtStandardDepotImpawn,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectGuaranteeSlipByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtGuaranteeSlip grtGuaranteeSlip = grtGuaranteeSlipMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtGuaranteeSlip,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
	public Map<String, Object> selectRealEstateByGuarantyId(String guarantyId) {
		Map<String, Object> map = new HashMap<>();
		GrtCollateral grtCollateral = grtCollateralMapper.selectByPrimaryKey(guarantyId);
		GrtRealEstateMortgage grtRealEstateMortgage = grtRealEstateMortgageMapper.selectByPrimaryKey(guarantyId);
		GrtRealEstateDetail grtRealEstateDetail = grtRealEstateDetailMapper.selectByPrimaryKey(guarantyId);
		try {
			map.put("data", BeanUtils.combineField(grtRealEstateDetail,grtRealEstateMortgage,grtCollateral));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("message", "删除失败！");
			throw new RuntimeException("合并bean属性异常："+e.getMessage());
		}
		map.put("flag", "true");
		map.put("message", "操作成功!");
		return map;
	}
}
