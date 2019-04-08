package com.cdgit.loan.creditLimit.service;

import java.math.BigDecimal;
import java.util.Map;


public interface ICreditReckon {
	public static final String CYCLE = "1";
	/**
	 * 针对 creditStatus字段设置，定义[01]为有效状态
	 */
	public static final String STATUS_DO = "01";
	/**
	 * 半失效状态，只失效自己
	 */
	public static final String STATUS_ABATE = "59";

	/**
	 * 实时校验可用额度是否覆盖
	 * 
	 * @param bizId
	 * @param appAmt
	 */
	public BigDecimal validBoUse(String bizId, BigDecimal appAmt);

	public BigDecimal validNoUse(String bizId, BigDecimal appAmt);

	/**
	 * 获取申请金额
	 * 
	 * @param bizId
	 * @return
	 */
	public BigDecimal getRmbAmt(String bizId);

	/**
	 * 获取敞口额度
	 * 
	 * @param bizId
	 * @return
	 */
	public BigDecimal getOpenGob(String bizId);

	public BigDecimal getOpenGob(Map<String, Object> dataMap);

	public BigDecimal getOpenGob(Object bizObj);

	public BigDecimal getOpenGob(BigDecimal amt, BigDecimal assurePer, String productType);

	/**
	 * 获取当前可用额度
	 * 
	 * @param bizId
	 * @return
	 */
	public BigDecimal getBoUse(String bizId);

	/**
	 * 获取冻结金额
	 * 
	 * @param bizId
	 * @param amount
	 */
	public BigDecimal getNoUse(String bizId);

	/**
	 * 查询额度信息
	 * 
	 * @param bizId
	 * @return
	 */
	public Map<String, Object> getCreditMap(String bizId);

	/**
	 * 是否敞口产品
	 * 
	 * @param product
	 * @return
	 */
	public boolean isOpenGobProduct(String productCd);

	/**
	 * 刷新额度数据
	 * 
	 * @param bizId
	 */
	public void refurbish(String bizId);

	/**
	 * 重算额度数据
	 * 
	 * @param bizId
	 */
	public void newly(String bizId);

	/**
	 * 失效额度
	 * 
	 * @param bizId
	 * @param statusCd
	 */
	public void abateCredit(String bizId, String statusCd);

}
