package com.cdgit.loan.common.bean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cdgit.loan.common.util.StringUtil;
import com.cdgit.loan.csm.po.TbSysApplyDaoConfigPo;


public class ApplyDaoParam implements Cloneable {
	private String phase;
	private String code;
	private String legOrg;
	private String orgCode;
	private String partyType;
	private String product;

	public ApplyDaoParam() {

	}

	public ApplyDaoParam(String phase) {
		this.phase = phase;
	}

	public ApplyDaoParam(String phase, String code) {
		this.phase = phase;
		this.code = code;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getLegOrg() {
		return legOrg;
	}

	public void setLegOrg(String legOrg) {
		this.legOrg = legOrg;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getId() {
		String[][] fields = getFields();
		String[] ids = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			ids[i] = fields[i][0] + fields[i][1];
		}
		String id = StringUtil.joinStr(ids, "_");
		if (id.isEmpty()) {
			throw new RuntimeException("获取ApplyDao配置失败：" + this);
		}
		return id;
	}

	private String[][] getFields() {
		return new String[][] { { "", phase }, { "", code }//
				, { "LEG", legOrg == null ? "" : legOrg }//
				, { "ORG", orgCode == null ? "" : orgCode }//
				, { "PT", partyType == null ? "" : partyType }//
				, { "P", product == null ? "" : product } //
		};
	}

	public String getMatchId() {
		return phase;
	}

	public String getMatch() {
		String[][] fields = getFields();
		String[] ids = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			ids[i] = fields[i][1].isEmpty() ? (fields[i][0] + "(.)*") : (fields[i][0] + fields[i][1]);
		}
		return StringUtil.joinStr(ids, "_");
	}

	
	public static ApplyDaoParam getParam(TbSysApplyDaoConfigPo obj) {
		ApplyDaoParam param = new ApplyDaoParam(obj.getPhase(), obj.getCode());
		param.setLegOrg(obj.getLegOrg());
		param.setOrgCode(obj.getOrgNum());//以前是orgcode
		param.setPartyType(obj.getPartyType());
		param.setProduct(obj.getProductCd());
		return param;
	}

	public static void sort(List<Object[]> list) {
		Collections.sort(list, new Comparator<Object[]>() {

			@Override
			public int compare(Object[] o1, Object[] o2) {
				return compare((String) o1[0], (String) o2[0]);
			};

			public int compare(String str1, String str2) {
				int size = Math.min(str1.length(), str2.length());
				int index = 0;
				while (index < size && str1.charAt(index) == str2.charAt(index)) {
					index++;
				}
				if (index == size) {
					return str1.length() - str2.length();
				} else if (!Character.isLetterOrDigit(str1.charAt(index))) {
					return 1;
				} else if (!Character.isLetterOrDigit(str2.charAt(index))) {
					return -1;
				} else {
					return (str1.charAt(index)) - (str2.charAt(index));
				}
			}
		});
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		ApplyDaoParam param = new ApplyDaoParam();
		param.setCode(code);
		param.setLegOrg(legOrg);
		param.setOrgCode(orgCode);
		param.setPartyType(partyType);
		param.setPhase(phase);
		param.setProduct(product);
		return param;
	}

	@Override
	public String toString() {
		return getId();
	}
}
