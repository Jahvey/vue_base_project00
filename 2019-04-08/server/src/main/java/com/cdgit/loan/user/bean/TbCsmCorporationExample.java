package com.cdgit.loan.user.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbCsmCorporationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCsmCorporationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPartyIdIsNull() {
            addCriterion("PARTY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPartyIdIsNotNull() {
            addCriterion("PARTY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPartyIdEqualTo(String value) {
            addCriterion("PARTY_ID =", value, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdNotEqualTo(String value) {
            addCriterion("PARTY_ID <>", value, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdGreaterThan(String value) {
            addCriterion("PARTY_ID >", value, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARTY_ID >=", value, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdLessThan(String value) {
            addCriterion("PARTY_ID <", value, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdLessThanOrEqualTo(String value) {
            addCriterion("PARTY_ID <=", value, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdLike(String value) {
            addCriterion("PARTY_ID like", value, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdNotLike(String value) {
            addCriterion("PARTY_ID not like", value, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdIn(List<String> values) {
            addCriterion("PARTY_ID in", values, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdNotIn(List<String> values) {
            addCriterion("PARTY_ID not in", values, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdBetween(String value1, String value2) {
            addCriterion("PARTY_ID between", value1, value2, "partyId");
            return (Criteria) this;
        }

        public Criteria andPartyIdNotBetween(String value1, String value2) {
            addCriterion("PARTY_ID not between", value1, value2, "partyId");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdIsNull() {
            addCriterion("CORP_CUSTOMER_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdIsNotNull() {
            addCriterion("CORP_CUSTOMER_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdEqualTo(String value) {
            addCriterion("CORP_CUSTOMER_TYPE_CD =", value, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdNotEqualTo(String value) {
            addCriterion("CORP_CUSTOMER_TYPE_CD <>", value, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdGreaterThan(String value) {
            addCriterion("CORP_CUSTOMER_TYPE_CD >", value, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdGreaterThanOrEqualTo(String value) {
            addCriterion("CORP_CUSTOMER_TYPE_CD >=", value, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdLessThan(String value) {
            addCriterion("CORP_CUSTOMER_TYPE_CD <", value, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdLessThanOrEqualTo(String value) {
            addCriterion("CORP_CUSTOMER_TYPE_CD <=", value, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdLike(String value) {
            addCriterion("CORP_CUSTOMER_TYPE_CD like", value, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdNotLike(String value) {
            addCriterion("CORP_CUSTOMER_TYPE_CD not like", value, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdIn(List<String> values) {
            addCriterion("CORP_CUSTOMER_TYPE_CD in", values, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdNotIn(List<String> values) {
            addCriterion("CORP_CUSTOMER_TYPE_CD not in", values, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdBetween(String value1, String value2) {
            addCriterion("CORP_CUSTOMER_TYPE_CD between", value1, value2, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andCorpCustomerTypeCdNotBetween(String value1, String value2) {
            addCriterion("CORP_CUSTOMER_TYPE_CD not between", value1, value2, "corpCustomerTypeCd");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNull() {
            addCriterion("ENGLISH_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNotNull() {
            addCriterion("ENGLISH_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameEqualTo(String value) {
            addCriterion("ENGLISH_NAME =", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotEqualTo(String value) {
            addCriterion("ENGLISH_NAME <>", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThan(String value) {
            addCriterion("ENGLISH_NAME >", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENGLISH_NAME >=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThan(String value) {
            addCriterion("ENGLISH_NAME <", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("ENGLISH_NAME <=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLike(String value) {
            addCriterion("ENGLISH_NAME like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotLike(String value) {
            addCriterion("ENGLISH_NAME not like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIn(List<String> values) {
            addCriterion("ENGLISH_NAME in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotIn(List<String> values) {
            addCriterion("ENGLISH_NAME not in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameBetween(String value1, String value2) {
            addCriterion("ENGLISH_NAME between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotBetween(String value1, String value2) {
            addCriterion("ENGLISH_NAME not between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeIsNull() {
            addCriterion("ECONOMIC_SECTOR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeIsNotNull() {
            addCriterion("ECONOMIC_SECTOR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeEqualTo(String value) {
            addCriterion("ECONOMIC_SECTOR_CODE =", value, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeNotEqualTo(String value) {
            addCriterion("ECONOMIC_SECTOR_CODE <>", value, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeGreaterThan(String value) {
            addCriterion("ECONOMIC_SECTOR_CODE >", value, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ECONOMIC_SECTOR_CODE >=", value, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeLessThan(String value) {
            addCriterion("ECONOMIC_SECTOR_CODE <", value, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeLessThanOrEqualTo(String value) {
            addCriterion("ECONOMIC_SECTOR_CODE <=", value, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeLike(String value) {
            addCriterion("ECONOMIC_SECTOR_CODE like", value, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeNotLike(String value) {
            addCriterion("ECONOMIC_SECTOR_CODE not like", value, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeIn(List<String> values) {
            addCriterion("ECONOMIC_SECTOR_CODE in", values, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeNotIn(List<String> values) {
            addCriterion("ECONOMIC_SECTOR_CODE not in", values, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeBetween(String value1, String value2) {
            addCriterion("ECONOMIC_SECTOR_CODE between", value1, value2, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andEconomicSectorCodeNotBetween(String value1, String value2) {
            addCriterion("ECONOMIC_SECTOR_CODE not between", value1, value2, "economicSectorCode");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdIsNull() {
            addCriterion("INDUSTRIAL_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdIsNotNull() {
            addCriterion("INDUSTRIAL_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_CD =", value, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdNotEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_CD <>", value, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdGreaterThan(String value) {
            addCriterion("INDUSTRIAL_TYPE_CD >", value, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_CD >=", value, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdLessThan(String value) {
            addCriterion("INDUSTRIAL_TYPE_CD <", value, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_CD <=", value, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdLike(String value) {
            addCriterion("INDUSTRIAL_TYPE_CD like", value, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdNotLike(String value) {
            addCriterion("INDUSTRIAL_TYPE_CD not like", value, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdIn(List<String> values) {
            addCriterion("INDUSTRIAL_TYPE_CD in", values, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdNotIn(List<String> values) {
            addCriterion("INDUSTRIAL_TYPE_CD not in", values, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdBetween(String value1, String value2) {
            addCriterion("INDUSTRIAL_TYPE_CD between", value1, value2, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeCdNotBetween(String value1, String value2) {
            addCriterion("INDUSTRIAL_TYPE_CD not between", value1, value2, "industrialTypeCd");
            return (Criteria) this;
        }

        public Criteria andListingCorporationIsNull() {
            addCriterion("LISTING_CORPORATION is null");
            return (Criteria) this;
        }

        public Criteria andListingCorporationIsNotNull() {
            addCriterion("LISTING_CORPORATION is not null");
            return (Criteria) this;
        }

        public Criteria andListingCorporationEqualTo(String value) {
            addCriterion("LISTING_CORPORATION =", value, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationNotEqualTo(String value) {
            addCriterion("LISTING_CORPORATION <>", value, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationGreaterThan(String value) {
            addCriterion("LISTING_CORPORATION >", value, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationGreaterThanOrEqualTo(String value) {
            addCriterion("LISTING_CORPORATION >=", value, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationLessThan(String value) {
            addCriterion("LISTING_CORPORATION <", value, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationLessThanOrEqualTo(String value) {
            addCriterion("LISTING_CORPORATION <=", value, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationLike(String value) {
            addCriterion("LISTING_CORPORATION like", value, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationNotLike(String value) {
            addCriterion("LISTING_CORPORATION not like", value, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationIn(List<String> values) {
            addCriterion("LISTING_CORPORATION in", values, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationNotIn(List<String> values) {
            addCriterion("LISTING_CORPORATION not in", values, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationBetween(String value1, String value2) {
            addCriterion("LISTING_CORPORATION between", value1, value2, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andListingCorporationNotBetween(String value1, String value2) {
            addCriterion("LISTING_CORPORATION not between", value1, value2, "listingCorporation");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsIsNull() {
            addCriterion("REGISTER_ASSETS is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsIsNotNull() {
            addCriterion("REGISTER_ASSETS is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsEqualTo(BigDecimal value) {
            addCriterion("REGISTER_ASSETS =", value, "registerAssets");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsNotEqualTo(BigDecimal value) {
            addCriterion("REGISTER_ASSETS <>", value, "registerAssets");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsGreaterThan(BigDecimal value) {
            addCriterion("REGISTER_ASSETS >", value, "registerAssets");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REGISTER_ASSETS >=", value, "registerAssets");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsLessThan(BigDecimal value) {
            addCriterion("REGISTER_ASSETS <", value, "registerAssets");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REGISTER_ASSETS <=", value, "registerAssets");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsIn(List<BigDecimal> values) {
            addCriterion("REGISTER_ASSETS in", values, "registerAssets");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsNotIn(List<BigDecimal> values) {
            addCriterion("REGISTER_ASSETS not in", values, "registerAssets");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REGISTER_ASSETS between", value1, value2, "registerAssets");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REGISTER_ASSETS not between", value1, value2, "registerAssets");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdIsNull() {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdIsNotNull() {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdEqualTo(String value) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD =", value, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdNotEqualTo(String value) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD <>", value, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdGreaterThan(String value) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD >", value, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD >=", value, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdLessThan(String value) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD <", value, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdLessThanOrEqualTo(String value) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD <=", value, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdLike(String value) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD like", value, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdNotLike(String value) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD not like", value, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdIn(List<String> values) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD in", values, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdNotIn(List<String> values) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD not in", values, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdBetween(String value1, String value2) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD between", value1, value2, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andRegisterAssetsCurrencyCdNotBetween(String value1, String value2) {
            addCriterion("REGISTER_ASSETS_CURRENCY_CD not between", value1, value2, "registerAssetsCurrencyCd");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberIsNull() {
            addCriterion("EMPLOYEES_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberIsNotNull() {
            addCriterion("EMPLOYEES_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberEqualTo(Long value) {
            addCriterion("EMPLOYEES_NUMBER =", value, "employeesNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberNotEqualTo(Long value) {
            addCriterion("EMPLOYEES_NUMBER <>", value, "employeesNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberGreaterThan(Long value) {
            addCriterion("EMPLOYEES_NUMBER >", value, "employeesNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("EMPLOYEES_NUMBER >=", value, "employeesNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberLessThan(Long value) {
            addCriterion("EMPLOYEES_NUMBER <", value, "employeesNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberLessThanOrEqualTo(Long value) {
            addCriterion("EMPLOYEES_NUMBER <=", value, "employeesNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberIn(List<Long> values) {
            addCriterion("EMPLOYEES_NUMBER in", values, "employeesNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberNotIn(List<Long> values) {
            addCriterion("EMPLOYEES_NUMBER not in", values, "employeesNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberBetween(Long value1, Long value2) {
            addCriterion("EMPLOYEES_NUMBER between", value1, value2, "employeesNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeesNumberNotBetween(Long value1, Long value2) {
            addCriterion("EMPLOYEES_NUMBER not between", value1, value2, "employeesNumber");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoIsNull() {
            addCriterion("GOVERNMENT_TENT_NO is null");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoIsNotNull() {
            addCriterion("GOVERNMENT_TENT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoEqualTo(String value) {
            addCriterion("GOVERNMENT_TENT_NO =", value, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoNotEqualTo(String value) {
            addCriterion("GOVERNMENT_TENT_NO <>", value, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoGreaterThan(String value) {
            addCriterion("GOVERNMENT_TENT_NO >", value, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoGreaterThanOrEqualTo(String value) {
            addCriterion("GOVERNMENT_TENT_NO >=", value, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoLessThan(String value) {
            addCriterion("GOVERNMENT_TENT_NO <", value, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoLessThanOrEqualTo(String value) {
            addCriterion("GOVERNMENT_TENT_NO <=", value, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoLike(String value) {
            addCriterion("GOVERNMENT_TENT_NO like", value, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoNotLike(String value) {
            addCriterion("GOVERNMENT_TENT_NO not like", value, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoIn(List<String> values) {
            addCriterion("GOVERNMENT_TENT_NO in", values, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoNotIn(List<String> values) {
            addCriterion("GOVERNMENT_TENT_NO not in", values, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoBetween(String value1, String value2) {
            addCriterion("GOVERNMENT_TENT_NO between", value1, value2, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andGovernmentTentNoNotBetween(String value1, String value2) {
            addCriterion("GOVERNMENT_TENT_NO not between", value1, value2, "governmentTentNo");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeIsNull() {
            addCriterion("CREDIT_RELATIONSHIP_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeIsNotNull() {
            addCriterion("CREDIT_RELATIONSHIP_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeEqualTo(Date value) {
            addCriterion("CREDIT_RELATIONSHIP_TIME =", value, "creditRelationshipTime");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeNotEqualTo(Date value) {
            addCriterion("CREDIT_RELATIONSHIP_TIME <>", value, "creditRelationshipTime");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeGreaterThan(Date value) {
            addCriterion("CREDIT_RELATIONSHIP_TIME >", value, "creditRelationshipTime");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREDIT_RELATIONSHIP_TIME >=", value, "creditRelationshipTime");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeLessThan(Date value) {
            addCriterion("CREDIT_RELATIONSHIP_TIME <", value, "creditRelationshipTime");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREDIT_RELATIONSHIP_TIME <=", value, "creditRelationshipTime");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeIn(List<Date> values) {
            addCriterion("CREDIT_RELATIONSHIP_TIME in", values, "creditRelationshipTime");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeNotIn(List<Date> values) {
            addCriterion("CREDIT_RELATIONSHIP_TIME not in", values, "creditRelationshipTime");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeBetween(Date value1, Date value2) {
            addCriterion("CREDIT_RELATIONSHIP_TIME between", value1, value2, "creditRelationshipTime");
            return (Criteria) this;
        }

        public Criteria andCreditRelationshipTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREDIT_RELATIONSHIP_TIME not between", value1, value2, "creditRelationshipTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNull() {
            addCriterion("REGISTER_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNotNull() {
            addCriterion("REGISTER_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateEqualTo(Date value) {
            addCriterion("REGISTER_DATE =", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotEqualTo(Date value) {
            addCriterion("REGISTER_DATE <>", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThan(Date value) {
            addCriterion("REGISTER_DATE >", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThanOrEqualTo(Date value) {
            addCriterion("REGISTER_DATE >=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThan(Date value) {
            addCriterion("REGISTER_DATE <", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThanOrEqualTo(Date value) {
            addCriterion("REGISTER_DATE <=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIn(List<Date> values) {
            addCriterion("REGISTER_DATE in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotIn(List<Date> values) {
            addCriterion("REGISTER_DATE not in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateBetween(Date value1, Date value2) {
            addCriterion("REGISTER_DATE between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotBetween(Date value1, Date value2) {
            addCriterion("REGISTER_DATE not between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoIsNull() {
            addCriterion("LEGAL_CERTIFICATE_NO is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoIsNotNull() {
            addCriterion("LEGAL_CERTIFICATE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoEqualTo(String value) {
            addCriterion("LEGAL_CERTIFICATE_NO =", value, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoNotEqualTo(String value) {
            addCriterion("LEGAL_CERTIFICATE_NO <>", value, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoGreaterThan(String value) {
            addCriterion("LEGAL_CERTIFICATE_NO >", value, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL_CERTIFICATE_NO >=", value, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoLessThan(String value) {
            addCriterion("LEGAL_CERTIFICATE_NO <", value, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoLessThanOrEqualTo(String value) {
            addCriterion("LEGAL_CERTIFICATE_NO <=", value, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoLike(String value) {
            addCriterion("LEGAL_CERTIFICATE_NO like", value, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoNotLike(String value) {
            addCriterion("LEGAL_CERTIFICATE_NO not like", value, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoIn(List<String> values) {
            addCriterion("LEGAL_CERTIFICATE_NO in", values, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoNotIn(List<String> values) {
            addCriterion("LEGAL_CERTIFICATE_NO not in", values, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoBetween(String value1, String value2) {
            addCriterion("LEGAL_CERTIFICATE_NO between", value1, value2, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateNoNotBetween(String value1, String value2) {
            addCriterion("LEGAL_CERTIFICATE_NO not between", value1, value2, "legalCertificateNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateIsNull() {
            addCriterion("LEGAL_CERTIFICATE_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateIsNotNull() {
            addCriterion("LEGAL_CERTIFICATE_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateEqualTo(Date value) {
            addCriterion("LEGAL_CERTIFICATE_END_DATE =", value, "legalCertificateEndDate");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateNotEqualTo(Date value) {
            addCriterion("LEGAL_CERTIFICATE_END_DATE <>", value, "legalCertificateEndDate");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateGreaterThan(Date value) {
            addCriterion("LEGAL_CERTIFICATE_END_DATE >", value, "legalCertificateEndDate");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LEGAL_CERTIFICATE_END_DATE >=", value, "legalCertificateEndDate");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateLessThan(Date value) {
            addCriterion("LEGAL_CERTIFICATE_END_DATE <", value, "legalCertificateEndDate");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateLessThanOrEqualTo(Date value) {
            addCriterion("LEGAL_CERTIFICATE_END_DATE <=", value, "legalCertificateEndDate");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateIn(List<Date> values) {
            addCriterion("LEGAL_CERTIFICATE_END_DATE in", values, "legalCertificateEndDate");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateNotIn(List<Date> values) {
            addCriterion("LEGAL_CERTIFICATE_END_DATE not in", values, "legalCertificateEndDate");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateBetween(Date value1, Date value2) {
            addCriterion("LEGAL_CERTIFICATE_END_DATE between", value1, value2, "legalCertificateEndDate");
            return (Criteria) this;
        }

        public Criteria andLegalCertificateEndDateNotBetween(Date value1, Date value2) {
            addCriterion("LEGAL_CERTIFICATE_END_DATE not between", value1, value2, "legalCertificateEndDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeIsNull() {
            addCriterion("REGISTRATION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeIsNotNull() {
            addCriterion("REGISTRATION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeEqualTo(String value) {
            addCriterion("REGISTRATION_TYPE =", value, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeNotEqualTo(String value) {
            addCriterion("REGISTRATION_TYPE <>", value, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeGreaterThan(String value) {
            addCriterion("REGISTRATION_TYPE >", value, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTRATION_TYPE >=", value, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeLessThan(String value) {
            addCriterion("REGISTRATION_TYPE <", value, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeLessThanOrEqualTo(String value) {
            addCriterion("REGISTRATION_TYPE <=", value, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeLike(String value) {
            addCriterion("REGISTRATION_TYPE like", value, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeNotLike(String value) {
            addCriterion("REGISTRATION_TYPE not like", value, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeIn(List<String> values) {
            addCriterion("REGISTRATION_TYPE in", values, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeNotIn(List<String> values) {
            addCriterion("REGISTRATION_TYPE not in", values, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeBetween(String value1, String value2) {
            addCriterion("REGISTRATION_TYPE between", value1, value2, "registrationType");
            return (Criteria) this;
        }

        public Criteria andRegistrationTypeNotBetween(String value1, String value2) {
            addCriterion("REGISTRATION_TYPE not between", value1, value2, "registrationType");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumIsNull() {
            addCriterion("UPDATE_USER_NUM is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumIsNotNull() {
            addCriterion("UPDATE_USER_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumEqualTo(String value) {
            addCriterion("UPDATE_USER_NUM =", value, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumNotEqualTo(String value) {
            addCriterion("UPDATE_USER_NUM <>", value, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumGreaterThan(String value) {
            addCriterion("UPDATE_USER_NUM >", value, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER_NUM >=", value, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumLessThan(String value) {
            addCriterion("UPDATE_USER_NUM <", value, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER_NUM <=", value, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumLike(String value) {
            addCriterion("UPDATE_USER_NUM like", value, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumNotLike(String value) {
            addCriterion("UPDATE_USER_NUM not like", value, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumIn(List<String> values) {
            addCriterion("UPDATE_USER_NUM in", values, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumNotIn(List<String> values) {
            addCriterion("UPDATE_USER_NUM not in", values, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumBetween(String value1, String value2) {
            addCriterion("UPDATE_USER_NUM between", value1, value2, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNumNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER_NUM not between", value1, value2, "updateUserNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumIsNull() {
            addCriterion("UPDATE_ORG_NUM is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumIsNotNull() {
            addCriterion("UPDATE_ORG_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumEqualTo(String value) {
            addCriterion("UPDATE_ORG_NUM =", value, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumNotEqualTo(String value) {
            addCriterion("UPDATE_ORG_NUM <>", value, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumGreaterThan(String value) {
            addCriterion("UPDATE_ORG_NUM >", value, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_ORG_NUM >=", value, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumLessThan(String value) {
            addCriterion("UPDATE_ORG_NUM <", value, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_ORG_NUM <=", value, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumLike(String value) {
            addCriterion("UPDATE_ORG_NUM like", value, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumNotLike(String value) {
            addCriterion("UPDATE_ORG_NUM not like", value, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumIn(List<String> values) {
            addCriterion("UPDATE_ORG_NUM in", values, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumNotIn(List<String> values) {
            addCriterion("UPDATE_ORG_NUM not in", values, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumBetween(String value1, String value2) {
            addCriterion("UPDATE_ORG_NUM between", value1, value2, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateOrgNumNotBetween(String value1, String value2) {
            addCriterion("UPDATE_ORG_NUM not between", value1, value2, "updateOrgNum");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andAreaTypeIsNull() {
            addCriterion("AREA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAreaTypeIsNotNull() {
            addCriterion("AREA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAreaTypeEqualTo(String value) {
            addCriterion("AREA_TYPE =", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotEqualTo(String value) {
            addCriterion("AREA_TYPE <>", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeGreaterThan(String value) {
            addCriterion("AREA_TYPE >", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("AREA_TYPE >=", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeLessThan(String value) {
            addCriterion("AREA_TYPE <", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeLessThanOrEqualTo(String value) {
            addCriterion("AREA_TYPE <=", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeLike(String value) {
            addCriterion("AREA_TYPE like", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotLike(String value) {
            addCriterion("AREA_TYPE not like", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeIn(List<String> values) {
            addCriterion("AREA_TYPE in", values, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotIn(List<String> values) {
            addCriterion("AREA_TYPE not in", values, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeBetween(String value1, String value2) {
            addCriterion("AREA_TYPE between", value1, value2, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotBetween(String value1, String value2) {
            addCriterion("AREA_TYPE not between", value1, value2, "areaType");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdIsNull() {
            addCriterion("CONTRY_REGION_CD is null");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdIsNotNull() {
            addCriterion("CONTRY_REGION_CD is not null");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdEqualTo(String value) {
            addCriterion("CONTRY_REGION_CD =", value, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdNotEqualTo(String value) {
            addCriterion("CONTRY_REGION_CD <>", value, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdGreaterThan(String value) {
            addCriterion("CONTRY_REGION_CD >", value, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRY_REGION_CD >=", value, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdLessThan(String value) {
            addCriterion("CONTRY_REGION_CD <", value, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdLessThanOrEqualTo(String value) {
            addCriterion("CONTRY_REGION_CD <=", value, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdLike(String value) {
            addCriterion("CONTRY_REGION_CD like", value, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdNotLike(String value) {
            addCriterion("CONTRY_REGION_CD not like", value, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdIn(List<String> values) {
            addCriterion("CONTRY_REGION_CD in", values, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdNotIn(List<String> values) {
            addCriterion("CONTRY_REGION_CD not in", values, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdBetween(String value1, String value2) {
            addCriterion("CONTRY_REGION_CD between", value1, value2, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andContryRegionCdNotBetween(String value1, String value2) {
            addCriterion("CONTRY_REGION_CD not between", value1, value2, "contryRegionCd");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNull() {
            addCriterion("LEGAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNotNull() {
            addCriterion("LEGAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLegalNameEqualTo(String value) {
            addCriterion("LEGAL_NAME =", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotEqualTo(String value) {
            addCriterion("LEGAL_NAME <>", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThan(String value) {
            addCriterion("LEGAL_NAME >", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL_NAME >=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThan(String value) {
            addCriterion("LEGAL_NAME <", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThanOrEqualTo(String value) {
            addCriterion("LEGAL_NAME <=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLike(String value) {
            addCriterion("LEGAL_NAME like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotLike(String value) {
            addCriterion("LEGAL_NAME not like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameIn(List<String> values) {
            addCriterion("LEGAL_NAME in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotIn(List<String> values) {
            addCriterion("LEGAL_NAME not in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameBetween(String value1, String value2) {
            addCriterion("LEGAL_NAME between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotBetween(String value1, String value2) {
            addCriterion("LEGAL_NAME not between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeIsNull() {
            addCriterion("LEGAL_CERT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeIsNotNull() {
            addCriterion("LEGAL_CERT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeEqualTo(String value) {
            addCriterion("LEGAL_CERT_TYPE =", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotEqualTo(String value) {
            addCriterion("LEGAL_CERT_TYPE <>", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeGreaterThan(String value) {
            addCriterion("LEGAL_CERT_TYPE >", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL_CERT_TYPE >=", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeLessThan(String value) {
            addCriterion("LEGAL_CERT_TYPE <", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeLessThanOrEqualTo(String value) {
            addCriterion("LEGAL_CERT_TYPE <=", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeLike(String value) {
            addCriterion("LEGAL_CERT_TYPE like", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotLike(String value) {
            addCriterion("LEGAL_CERT_TYPE not like", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeIn(List<String> values) {
            addCriterion("LEGAL_CERT_TYPE in", values, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotIn(List<String> values) {
            addCriterion("LEGAL_CERT_TYPE not in", values, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeBetween(String value1, String value2) {
            addCriterion("LEGAL_CERT_TYPE between", value1, value2, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotBetween(String value1, String value2) {
            addCriterion("LEGAL_CERT_TYPE not between", value1, value2, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andRegistrCdIsNull() {
            addCriterion("REGISTR_CD is null");
            return (Criteria) this;
        }

        public Criteria andRegistrCdIsNotNull() {
            addCriterion("REGISTR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrCdEqualTo(String value) {
            addCriterion("REGISTR_CD =", value, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdNotEqualTo(String value) {
            addCriterion("REGISTR_CD <>", value, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdGreaterThan(String value) {
            addCriterion("REGISTR_CD >", value, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTR_CD >=", value, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdLessThan(String value) {
            addCriterion("REGISTR_CD <", value, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdLessThanOrEqualTo(String value) {
            addCriterion("REGISTR_CD <=", value, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdLike(String value) {
            addCriterion("REGISTR_CD like", value, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdNotLike(String value) {
            addCriterion("REGISTR_CD not like", value, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdIn(List<String> values) {
            addCriterion("REGISTR_CD in", values, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdNotIn(List<String> values) {
            addCriterion("REGISTR_CD not in", values, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdBetween(String value1, String value2) {
            addCriterion("REGISTR_CD between", value1, value2, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegistrCdNotBetween(String value1, String value2) {
            addCriterion("REGISTR_CD not between", value1, value2, "registrCd");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateIsNull() {
            addCriterion("REGISTER_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateIsNotNull() {
            addCriterion("REGISTER_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateEqualTo(Date value) {
            addCriterion("REGISTER_END_DATE =", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateNotEqualTo(Date value) {
            addCriterion("REGISTER_END_DATE <>", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateGreaterThan(Date value) {
            addCriterion("REGISTER_END_DATE >", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("REGISTER_END_DATE >=", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateLessThan(Date value) {
            addCriterion("REGISTER_END_DATE <", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateLessThanOrEqualTo(Date value) {
            addCriterion("REGISTER_END_DATE <=", value, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateIn(List<Date> values) {
            addCriterion("REGISTER_END_DATE in", values, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateNotIn(List<Date> values) {
            addCriterion("REGISTER_END_DATE not in", values, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateBetween(Date value1, Date value2) {
            addCriterion("REGISTER_END_DATE between", value1, value2, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andRegisterEndDateNotBetween(Date value1, Date value2) {
            addCriterion("REGISTER_END_DATE not between", value1, value2, "registerEndDate");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("BUSINESS_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("BUSINESS_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("BUSINESS_SCOPE >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("BUSINESS_SCOPE <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("BUSINESS_SCOPE like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("BUSINESS_SCOPE not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("BUSINESS_SCOPE in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("BUSINESS_SCOPE not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCOPE between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCOPE not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdIsNull() {
            addCriterion("ORG_REGISTER_CD is null");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdIsNotNull() {
            addCriterion("ORG_REGISTER_CD is not null");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdEqualTo(String value) {
            addCriterion("ORG_REGISTER_CD =", value, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdNotEqualTo(String value) {
            addCriterion("ORG_REGISTER_CD <>", value, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdGreaterThan(String value) {
            addCriterion("ORG_REGISTER_CD >", value, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_REGISTER_CD >=", value, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdLessThan(String value) {
            addCriterion("ORG_REGISTER_CD <", value, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdLessThanOrEqualTo(String value) {
            addCriterion("ORG_REGISTER_CD <=", value, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdLike(String value) {
            addCriterion("ORG_REGISTER_CD like", value, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdNotLike(String value) {
            addCriterion("ORG_REGISTER_CD not like", value, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdIn(List<String> values) {
            addCriterion("ORG_REGISTER_CD in", values, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdNotIn(List<String> values) {
            addCriterion("ORG_REGISTER_CD not in", values, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdBetween(String value1, String value2) {
            addCriterion("ORG_REGISTER_CD between", value1, value2, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterCdNotBetween(String value1, String value2) {
            addCriterion("ORG_REGISTER_CD not between", value1, value2, "orgRegisterCd");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateIsNull() {
            addCriterion("ORG_REGISTER_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateIsNotNull() {
            addCriterion("ORG_REGISTER_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateEqualTo(Date value) {
            addCriterion("ORG_REGISTER_END_DATE =", value, "orgRegisterEndDate");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateNotEqualTo(Date value) {
            addCriterion("ORG_REGISTER_END_DATE <>", value, "orgRegisterEndDate");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateGreaterThan(Date value) {
            addCriterion("ORG_REGISTER_END_DATE >", value, "orgRegisterEndDate");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ORG_REGISTER_END_DATE >=", value, "orgRegisterEndDate");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateLessThan(Date value) {
            addCriterion("ORG_REGISTER_END_DATE <", value, "orgRegisterEndDate");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateLessThanOrEqualTo(Date value) {
            addCriterion("ORG_REGISTER_END_DATE <=", value, "orgRegisterEndDate");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateIn(List<Date> values) {
            addCriterion("ORG_REGISTER_END_DATE in", values, "orgRegisterEndDate");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateNotIn(List<Date> values) {
            addCriterion("ORG_REGISTER_END_DATE not in", values, "orgRegisterEndDate");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateBetween(Date value1, Date value2) {
            addCriterion("ORG_REGISTER_END_DATE between", value1, value2, "orgRegisterEndDate");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterEndDateNotBetween(Date value1, Date value2) {
            addCriterion("ORG_REGISTER_END_DATE not between", value1, value2, "orgRegisterEndDate");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeIsNull() {
            addCriterion("MIDDEL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeIsNotNull() {
            addCriterion("MIDDEL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeEqualTo(String value) {
            addCriterion("MIDDEL_CODE =", value, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeNotEqualTo(String value) {
            addCriterion("MIDDEL_CODE <>", value, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeGreaterThan(String value) {
            addCriterion("MIDDEL_CODE >", value, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MIDDEL_CODE >=", value, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeLessThan(String value) {
            addCriterion("MIDDEL_CODE <", value, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeLessThanOrEqualTo(String value) {
            addCriterion("MIDDEL_CODE <=", value, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeLike(String value) {
            addCriterion("MIDDEL_CODE like", value, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeNotLike(String value) {
            addCriterion("MIDDEL_CODE not like", value, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeIn(List<String> values) {
            addCriterion("MIDDEL_CODE in", values, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeNotIn(List<String> values) {
            addCriterion("MIDDEL_CODE not in", values, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeBetween(String value1, String value2) {
            addCriterion("MIDDEL_CODE between", value1, value2, "middelCode");
            return (Criteria) this;
        }

        public Criteria andMiddelCodeNotBetween(String value1, String value2) {
            addCriterion("MIDDEL_CODE not between", value1, value2, "middelCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeIsNull() {
            addCriterion("ORG_CREDIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeIsNotNull() {
            addCriterion("ORG_CREDIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeEqualTo(String value) {
            addCriterion("ORG_CREDIT_CODE =", value, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeNotEqualTo(String value) {
            addCriterion("ORG_CREDIT_CODE <>", value, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeGreaterThan(String value) {
            addCriterion("ORG_CREDIT_CODE >", value, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_CREDIT_CODE >=", value, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeLessThan(String value) {
            addCriterion("ORG_CREDIT_CODE <", value, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("ORG_CREDIT_CODE <=", value, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeLike(String value) {
            addCriterion("ORG_CREDIT_CODE like", value, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeNotLike(String value) {
            addCriterion("ORG_CREDIT_CODE not like", value, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeIn(List<String> values) {
            addCriterion("ORG_CREDIT_CODE in", values, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeNotIn(List<String> values) {
            addCriterion("ORG_CREDIT_CODE not in", values, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeBetween(String value1, String value2) {
            addCriterion("ORG_CREDIT_CODE between", value1, value2, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andOrgCreditCodeNotBetween(String value1, String value2) {
            addCriterion("ORG_CREDIT_CODE not between", value1, value2, "orgCreditCode");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoIsNull() {
            addCriterion("NATIONAL_TAX_NO is null");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoIsNotNull() {
            addCriterion("NATIONAL_TAX_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoEqualTo(String value) {
            addCriterion("NATIONAL_TAX_NO =", value, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoNotEqualTo(String value) {
            addCriterion("NATIONAL_TAX_NO <>", value, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoGreaterThan(String value) {
            addCriterion("NATIONAL_TAX_NO >", value, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoGreaterThanOrEqualTo(String value) {
            addCriterion("NATIONAL_TAX_NO >=", value, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoLessThan(String value) {
            addCriterion("NATIONAL_TAX_NO <", value, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoLessThanOrEqualTo(String value) {
            addCriterion("NATIONAL_TAX_NO <=", value, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoLike(String value) {
            addCriterion("NATIONAL_TAX_NO like", value, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoNotLike(String value) {
            addCriterion("NATIONAL_TAX_NO not like", value, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoIn(List<String> values) {
            addCriterion("NATIONAL_TAX_NO in", values, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoNotIn(List<String> values) {
            addCriterion("NATIONAL_TAX_NO not in", values, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoBetween(String value1, String value2) {
            addCriterion("NATIONAL_TAX_NO between", value1, value2, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNoNotBetween(String value1, String value2) {
            addCriterion("NATIONAL_TAX_NO not between", value1, value2, "nationalTaxNo");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdIsNull() {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdIsNotNull() {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD =", value, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdNotEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD <>", value, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdGreaterThan(String value) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD >", value, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD >=", value, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdLessThan(String value) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD <", value, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD <=", value, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdLike(String value) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD like", value, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdNotLike(String value) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD not like", value, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdIn(List<String> values) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD in", values, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdNotIn(List<String> values) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD not in", values, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdBetween(String value1, String value2) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD between", value1, value2, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeBigCdNotBetween(String value1, String value2) {
            addCriterion("INDUSTRIAL_TYPE_BIG_CD not between", value1, value2, "industrialTypeBigCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdIsNull() {
            addCriterion("INDUSTRIAL_TYPE_MID_CD is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdIsNotNull() {
            addCriterion("INDUSTRIAL_TYPE_MID_CD is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD =", value, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdNotEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD <>", value, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdGreaterThan(String value) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD >", value, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD >=", value, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdLessThan(String value) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD <", value, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD <=", value, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdLike(String value) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD like", value, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdNotLike(String value) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD not like", value, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdIn(List<String> values) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD in", values, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdNotIn(List<String> values) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD not in", values, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdBetween(String value1, String value2) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD between", value1, value2, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeMidCdNotBetween(String value1, String value2) {
            addCriterion("INDUSTRIAL_TYPE_MID_CD not between", value1, value2, "industrialTypeMidCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdIsNull() {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdIsNotNull() {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD =", value, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdNotEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD <>", value, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdGreaterThan(String value) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD >", value, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD >=", value, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdLessThan(String value) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD <", value, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD <=", value, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdLike(String value) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD like", value, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdNotLike(String value) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD not like", value, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdIn(List<String> values) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD in", values, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdNotIn(List<String> values) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD not in", values, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdBetween(String value1, String value2) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD between", value1, value2, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andIndustrialTypeSamllCdNotBetween(String value1, String value2) {
            addCriterion("INDUSTRIAL_TYPE_SAMLL_CD not between", value1, value2, "industrialTypeSamllCd");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxIsNull() {
            addCriterion("ENTERPRISE_SCALE_GX is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxIsNotNull() {
            addCriterion("ENTERPRISE_SCALE_GX is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxEqualTo(String value) {
            addCriterion("ENTERPRISE_SCALE_GX =", value, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxNotEqualTo(String value) {
            addCriterion("ENTERPRISE_SCALE_GX <>", value, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxGreaterThan(String value) {
            addCriterion("ENTERPRISE_SCALE_GX >", value, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_SCALE_GX >=", value, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxLessThan(String value) {
            addCriterion("ENTERPRISE_SCALE_GX <", value, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_SCALE_GX <=", value, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxLike(String value) {
            addCriterion("ENTERPRISE_SCALE_GX like", value, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxNotLike(String value) {
            addCriterion("ENTERPRISE_SCALE_GX not like", value, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxIn(List<String> values) {
            addCriterion("ENTERPRISE_SCALE_GX in", values, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxNotIn(List<String> values) {
            addCriterion("ENTERPRISE_SCALE_GX not in", values, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_SCALE_GX between", value1, value2, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGxNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_SCALE_GX not between", value1, value2, "enterpriseScaleGx");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleIsNull() {
            addCriterion("COUNT_BORE_ENTER_SCALE is null");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleIsNotNull() {
            addCriterion("COUNT_BORE_ENTER_SCALE is not null");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleEqualTo(String value) {
            addCriterion("COUNT_BORE_ENTER_SCALE =", value, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleNotEqualTo(String value) {
            addCriterion("COUNT_BORE_ENTER_SCALE <>", value, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleGreaterThan(String value) {
            addCriterion("COUNT_BORE_ENTER_SCALE >", value, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleGreaterThanOrEqualTo(String value) {
            addCriterion("COUNT_BORE_ENTER_SCALE >=", value, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleLessThan(String value) {
            addCriterion("COUNT_BORE_ENTER_SCALE <", value, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleLessThanOrEqualTo(String value) {
            addCriterion("COUNT_BORE_ENTER_SCALE <=", value, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleLike(String value) {
            addCriterion("COUNT_BORE_ENTER_SCALE like", value, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleNotLike(String value) {
            addCriterion("COUNT_BORE_ENTER_SCALE not like", value, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleIn(List<String> values) {
            addCriterion("COUNT_BORE_ENTER_SCALE in", values, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleNotIn(List<String> values) {
            addCriterion("COUNT_BORE_ENTER_SCALE not in", values, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleBetween(String value1, String value2) {
            addCriterion("COUNT_BORE_ENTER_SCALE between", value1, value2, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andCountBoreEnterScaleNotBetween(String value1, String value2) {
            addCriterion("COUNT_BORE_ENTER_SCALE not between", value1, value2, "countBoreEnterScale");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustIsNull() {
            addCriterion("IS_GROUP_CUST is null");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustIsNotNull() {
            addCriterion("IS_GROUP_CUST is not null");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustEqualTo(String value) {
            addCriterion("IS_GROUP_CUST =", value, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustNotEqualTo(String value) {
            addCriterion("IS_GROUP_CUST <>", value, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustGreaterThan(String value) {
            addCriterion("IS_GROUP_CUST >", value, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustGreaterThanOrEqualTo(String value) {
            addCriterion("IS_GROUP_CUST >=", value, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustLessThan(String value) {
            addCriterion("IS_GROUP_CUST <", value, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustLessThanOrEqualTo(String value) {
            addCriterion("IS_GROUP_CUST <=", value, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustLike(String value) {
            addCriterion("IS_GROUP_CUST like", value, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustNotLike(String value) {
            addCriterion("IS_GROUP_CUST not like", value, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustIn(List<String> values) {
            addCriterion("IS_GROUP_CUST in", values, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustNotIn(List<String> values) {
            addCriterion("IS_GROUP_CUST not in", values, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustBetween(String value1, String value2) {
            addCriterion("IS_GROUP_CUST between", value1, value2, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andIsGroupCustNotBetween(String value1, String value2) {
            addCriterion("IS_GROUP_CUST not between", value1, value2, "isGroupCust");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameIsNull() {
            addCriterion("ATTACH_GROUP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameIsNotNull() {
            addCriterion("ATTACH_GROUP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameEqualTo(String value) {
            addCriterion("ATTACH_GROUP_NAME =", value, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameNotEqualTo(String value) {
            addCriterion("ATTACH_GROUP_NAME <>", value, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameGreaterThan(String value) {
            addCriterion("ATTACH_GROUP_NAME >", value, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("ATTACH_GROUP_NAME >=", value, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameLessThan(String value) {
            addCriterion("ATTACH_GROUP_NAME <", value, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameLessThanOrEqualTo(String value) {
            addCriterion("ATTACH_GROUP_NAME <=", value, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameLike(String value) {
            addCriterion("ATTACH_GROUP_NAME like", value, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameNotLike(String value) {
            addCriterion("ATTACH_GROUP_NAME not like", value, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameIn(List<String> values) {
            addCriterion("ATTACH_GROUP_NAME in", values, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameNotIn(List<String> values) {
            addCriterion("ATTACH_GROUP_NAME not in", values, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameBetween(String value1, String value2) {
            addCriterion("ATTACH_GROUP_NAME between", value1, value2, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andAttachGroupNameNotBetween(String value1, String value2) {
            addCriterion("ATTACH_GROUP_NAME not between", value1, value2, "attachGroupName");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpIsNull() {
            addCriterion("WHETHER_IMP_EXP is null");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpIsNotNull() {
            addCriterion("WHETHER_IMP_EXP is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpEqualTo(String value) {
            addCriterion("WHETHER_IMP_EXP =", value, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpNotEqualTo(String value) {
            addCriterion("WHETHER_IMP_EXP <>", value, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpGreaterThan(String value) {
            addCriterion("WHETHER_IMP_EXP >", value, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_IMP_EXP >=", value, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpLessThan(String value) {
            addCriterion("WHETHER_IMP_EXP <", value, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_IMP_EXP <=", value, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpLike(String value) {
            addCriterion("WHETHER_IMP_EXP like", value, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpNotLike(String value) {
            addCriterion("WHETHER_IMP_EXP not like", value, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpIn(List<String> values) {
            addCriterion("WHETHER_IMP_EXP in", values, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpNotIn(List<String> values) {
            addCriterion("WHETHER_IMP_EXP not in", values, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpBetween(String value1, String value2) {
            addCriterion("WHETHER_IMP_EXP between", value1, value2, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andWhetherImpExpNotBetween(String value1, String value2) {
            addCriterion("WHETHER_IMP_EXP not between", value1, value2, "whetherImpExp");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankIsNull() {
            addCriterion("STOCKHOLDER_OF_BANK is null");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankIsNotNull() {
            addCriterion("STOCKHOLDER_OF_BANK is not null");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankEqualTo(String value) {
            addCriterion("STOCKHOLDER_OF_BANK =", value, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankNotEqualTo(String value) {
            addCriterion("STOCKHOLDER_OF_BANK <>", value, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankGreaterThan(String value) {
            addCriterion("STOCKHOLDER_OF_BANK >", value, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankGreaterThanOrEqualTo(String value) {
            addCriterion("STOCKHOLDER_OF_BANK >=", value, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankLessThan(String value) {
            addCriterion("STOCKHOLDER_OF_BANK <", value, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankLessThanOrEqualTo(String value) {
            addCriterion("STOCKHOLDER_OF_BANK <=", value, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankLike(String value) {
            addCriterion("STOCKHOLDER_OF_BANK like", value, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankNotLike(String value) {
            addCriterion("STOCKHOLDER_OF_BANK not like", value, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankIn(List<String> values) {
            addCriterion("STOCKHOLDER_OF_BANK in", values, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankNotIn(List<String> values) {
            addCriterion("STOCKHOLDER_OF_BANK not in", values, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankBetween(String value1, String value2) {
            addCriterion("STOCKHOLDER_OF_BANK between", value1, value2, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andStockholderOfBankNotBetween(String value1, String value2) {
            addCriterion("STOCKHOLDER_OF_BANK not between", value1, value2, "stockholderOfBank");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeIsNull() {
            addCriterion("JOINT_GUARANTEE is null");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeIsNotNull() {
            addCriterion("JOINT_GUARANTEE is not null");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeEqualTo(String value) {
            addCriterion("JOINT_GUARANTEE =", value, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeNotEqualTo(String value) {
            addCriterion("JOINT_GUARANTEE <>", value, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeGreaterThan(String value) {
            addCriterion("JOINT_GUARANTEE >", value, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeGreaterThanOrEqualTo(String value) {
            addCriterion("JOINT_GUARANTEE >=", value, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeLessThan(String value) {
            addCriterion("JOINT_GUARANTEE <", value, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeLessThanOrEqualTo(String value) {
            addCriterion("JOINT_GUARANTEE <=", value, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeLike(String value) {
            addCriterion("JOINT_GUARANTEE like", value, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeNotLike(String value) {
            addCriterion("JOINT_GUARANTEE not like", value, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeIn(List<String> values) {
            addCriterion("JOINT_GUARANTEE in", values, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeNotIn(List<String> values) {
            addCriterion("JOINT_GUARANTEE not in", values, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeBetween(String value1, String value2) {
            addCriterion("JOINT_GUARANTEE between", value1, value2, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andJointGuaranteeNotBetween(String value1, String value2) {
            addCriterion("JOINT_GUARANTEE not between", value1, value2, "jointGuarantee");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseIsNull() {
            addCriterion("FAMILY_ENTERPRISE is null");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseIsNotNull() {
            addCriterion("FAMILY_ENTERPRISE is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseEqualTo(String value) {
            addCriterion("FAMILY_ENTERPRISE =", value, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseNotEqualTo(String value) {
            addCriterion("FAMILY_ENTERPRISE <>", value, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseGreaterThan(String value) {
            addCriterion("FAMILY_ENTERPRISE >", value, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseGreaterThanOrEqualTo(String value) {
            addCriterion("FAMILY_ENTERPRISE >=", value, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseLessThan(String value) {
            addCriterion("FAMILY_ENTERPRISE <", value, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseLessThanOrEqualTo(String value) {
            addCriterion("FAMILY_ENTERPRISE <=", value, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseLike(String value) {
            addCriterion("FAMILY_ENTERPRISE like", value, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseNotLike(String value) {
            addCriterion("FAMILY_ENTERPRISE not like", value, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseIn(List<String> values) {
            addCriterion("FAMILY_ENTERPRISE in", values, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseNotIn(List<String> values) {
            addCriterion("FAMILY_ENTERPRISE not in", values, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseBetween(String value1, String value2) {
            addCriterion("FAMILY_ENTERPRISE between", value1, value2, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andFamilyEnterpriseNotBetween(String value1, String value2) {
            addCriterion("FAMILY_ENTERPRISE not between", value1, value2, "familyEnterprise");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorIsNull() {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR is null");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorIsNotNull() {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorEqualTo(String value) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR =", value, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorNotEqualTo(String value) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR <>", value, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorGreaterThan(String value) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR >", value, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR >=", value, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorLessThan(String value) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR <", value, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR <=", value, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorLike(String value) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR like", value, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorNotLike(String value) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR not like", value, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorIn(List<String> values) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR in", values, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorNotIn(List<String> values) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR not in", values, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorBetween(String value1, String value2) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR between", value1, value2, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andWhetherGovernmentFinanceCorNotBetween(String value1, String value2) {
            addCriterion("WHETHER_GOVERNMENT_FINANCE_COR not between", value1, value2, "whetherGovernmentFinanceCor");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseIsNull() {
            addCriterion("COUNTRYSIDE_ENTERPRISE is null");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseIsNotNull() {
            addCriterion("COUNTRYSIDE_ENTERPRISE is not null");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseEqualTo(String value) {
            addCriterion("COUNTRYSIDE_ENTERPRISE =", value, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseNotEqualTo(String value) {
            addCriterion("COUNTRYSIDE_ENTERPRISE <>", value, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseGreaterThan(String value) {
            addCriterion("COUNTRYSIDE_ENTERPRISE >", value, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTRYSIDE_ENTERPRISE >=", value, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseLessThan(String value) {
            addCriterion("COUNTRYSIDE_ENTERPRISE <", value, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseLessThanOrEqualTo(String value) {
            addCriterion("COUNTRYSIDE_ENTERPRISE <=", value, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseLike(String value) {
            addCriterion("COUNTRYSIDE_ENTERPRISE like", value, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseNotLike(String value) {
            addCriterion("COUNTRYSIDE_ENTERPRISE not like", value, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseIn(List<String> values) {
            addCriterion("COUNTRYSIDE_ENTERPRISE in", values, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseNotIn(List<String> values) {
            addCriterion("COUNTRYSIDE_ENTERPRISE not in", values, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseBetween(String value1, String value2) {
            addCriterion("COUNTRYSIDE_ENTERPRISE between", value1, value2, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andCountrysideEnterpriseNotBetween(String value1, String value2) {
            addCriterion("COUNTRYSIDE_ENTERPRISE not between", value1, value2, "countrysideEnterprise");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListIsNull() {
            addCriterion("WHETHER_BLACK_LIST is null");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListIsNotNull() {
            addCriterion("WHETHER_BLACK_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListEqualTo(String value) {
            addCriterion("WHETHER_BLACK_LIST =", value, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListNotEqualTo(String value) {
            addCriterion("WHETHER_BLACK_LIST <>", value, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListGreaterThan(String value) {
            addCriterion("WHETHER_BLACK_LIST >", value, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_BLACK_LIST >=", value, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListLessThan(String value) {
            addCriterion("WHETHER_BLACK_LIST <", value, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_BLACK_LIST <=", value, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListLike(String value) {
            addCriterion("WHETHER_BLACK_LIST like", value, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListNotLike(String value) {
            addCriterion("WHETHER_BLACK_LIST not like", value, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListIn(List<String> values) {
            addCriterion("WHETHER_BLACK_LIST in", values, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListNotIn(List<String> values) {
            addCriterion("WHETHER_BLACK_LIST not in", values, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListBetween(String value1, String value2) {
            addCriterion("WHETHER_BLACK_LIST between", value1, value2, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andWhetherBlackListNotBetween(String value1, String value2) {
            addCriterion("WHETHER_BLACK_LIST not between", value1, value2, "whetherBlackList");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerIsNull() {
            addCriterion("FOCUS_CUSTOMER is null");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerIsNotNull() {
            addCriterion("FOCUS_CUSTOMER is not null");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerEqualTo(String value) {
            addCriterion("FOCUS_CUSTOMER =", value, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerNotEqualTo(String value) {
            addCriterion("FOCUS_CUSTOMER <>", value, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerGreaterThan(String value) {
            addCriterion("FOCUS_CUSTOMER >", value, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("FOCUS_CUSTOMER >=", value, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerLessThan(String value) {
            addCriterion("FOCUS_CUSTOMER <", value, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerLessThanOrEqualTo(String value) {
            addCriterion("FOCUS_CUSTOMER <=", value, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerLike(String value) {
            addCriterion("FOCUS_CUSTOMER like", value, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerNotLike(String value) {
            addCriterion("FOCUS_CUSTOMER not like", value, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerIn(List<String> values) {
            addCriterion("FOCUS_CUSTOMER in", values, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerNotIn(List<String> values) {
            addCriterion("FOCUS_CUSTOMER not in", values, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerBetween(String value1, String value2) {
            addCriterion("FOCUS_CUSTOMER between", value1, value2, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andFocusCustomerNotBetween(String value1, String value2) {
            addCriterion("FOCUS_CUSTOMER not between", value1, value2, "focusCustomer");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevIsNull() {
            addCriterion("IS_REAL_ESTATE_DEV is null");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevIsNotNull() {
            addCriterion("IS_REAL_ESTATE_DEV is not null");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevEqualTo(String value) {
            addCriterion("IS_REAL_ESTATE_DEV =", value, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevNotEqualTo(String value) {
            addCriterion("IS_REAL_ESTATE_DEV <>", value, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevGreaterThan(String value) {
            addCriterion("IS_REAL_ESTATE_DEV >", value, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevGreaterThanOrEqualTo(String value) {
            addCriterion("IS_REAL_ESTATE_DEV >=", value, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevLessThan(String value) {
            addCriterion("IS_REAL_ESTATE_DEV <", value, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevLessThanOrEqualTo(String value) {
            addCriterion("IS_REAL_ESTATE_DEV <=", value, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevLike(String value) {
            addCriterion("IS_REAL_ESTATE_DEV like", value, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevNotLike(String value) {
            addCriterion("IS_REAL_ESTATE_DEV not like", value, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevIn(List<String> values) {
            addCriterion("IS_REAL_ESTATE_DEV in", values, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevNotIn(List<String> values) {
            addCriterion("IS_REAL_ESTATE_DEV not in", values, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevBetween(String value1, String value2) {
            addCriterion("IS_REAL_ESTATE_DEV between", value1, value2, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andIsRealEstateDevNotBetween(String value1, String value2) {
            addCriterion("IS_REAL_ESTATE_DEV not between", value1, value2, "isRealEstateDev");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andFundSrcIsNull() {
            addCriterion("FUND_SRC is null");
            return (Criteria) this;
        }

        public Criteria andFundSrcIsNotNull() {
            addCriterion("FUND_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andFundSrcEqualTo(String value) {
            addCriterion("FUND_SRC =", value, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcNotEqualTo(String value) {
            addCriterion("FUND_SRC <>", value, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcGreaterThan(String value) {
            addCriterion("FUND_SRC >", value, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcGreaterThanOrEqualTo(String value) {
            addCriterion("FUND_SRC >=", value, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcLessThan(String value) {
            addCriterion("FUND_SRC <", value, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcLessThanOrEqualTo(String value) {
            addCriterion("FUND_SRC <=", value, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcLike(String value) {
            addCriterion("FUND_SRC like", value, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcNotLike(String value) {
            addCriterion("FUND_SRC not like", value, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcIn(List<String> values) {
            addCriterion("FUND_SRC in", values, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcNotIn(List<String> values) {
            addCriterion("FUND_SRC not in", values, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcBetween(String value1, String value2) {
            addCriterion("FUND_SRC between", value1, value2, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andFundSrcNotBetween(String value1, String value2) {
            addCriterion("FUND_SRC not between", value1, value2, "fundSrc");
            return (Criteria) this;
        }

        public Criteria andOpenFundIsNull() {
            addCriterion("OPEN_FUND is null");
            return (Criteria) this;
        }

        public Criteria andOpenFundIsNotNull() {
            addCriterion("OPEN_FUND is not null");
            return (Criteria) this;
        }

        public Criteria andOpenFundEqualTo(BigDecimal value) {
            addCriterion("OPEN_FUND =", value, "openFund");
            return (Criteria) this;
        }

        public Criteria andOpenFundNotEqualTo(BigDecimal value) {
            addCriterion("OPEN_FUND <>", value, "openFund");
            return (Criteria) this;
        }

        public Criteria andOpenFundGreaterThan(BigDecimal value) {
            addCriterion("OPEN_FUND >", value, "openFund");
            return (Criteria) this;
        }

        public Criteria andOpenFundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OPEN_FUND >=", value, "openFund");
            return (Criteria) this;
        }

        public Criteria andOpenFundLessThan(BigDecimal value) {
            addCriterion("OPEN_FUND <", value, "openFund");
            return (Criteria) this;
        }

        public Criteria andOpenFundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OPEN_FUND <=", value, "openFund");
            return (Criteria) this;
        }

        public Criteria andOpenFundIn(List<BigDecimal> values) {
            addCriterion("OPEN_FUND in", values, "openFund");
            return (Criteria) this;
        }

        public Criteria andOpenFundNotIn(List<BigDecimal> values) {
            addCriterion("OPEN_FUND not in", values, "openFund");
            return (Criteria) this;
        }

        public Criteria andOpenFundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPEN_FUND between", value1, value2, "openFund");
            return (Criteria) this;
        }

        public Criteria andOpenFundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPEN_FUND not between", value1, value2, "openFund");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustIsNull() {
            addCriterion("IS_BASEBANK_RELA_CUST is null");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustIsNotNull() {
            addCriterion("IS_BASEBANK_RELA_CUST is not null");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustEqualTo(String value) {
            addCriterion("IS_BASEBANK_RELA_CUST =", value, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustNotEqualTo(String value) {
            addCriterion("IS_BASEBANK_RELA_CUST <>", value, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustGreaterThan(String value) {
            addCriterion("IS_BASEBANK_RELA_CUST >", value, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustGreaterThanOrEqualTo(String value) {
            addCriterion("IS_BASEBANK_RELA_CUST >=", value, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustLessThan(String value) {
            addCriterion("IS_BASEBANK_RELA_CUST <", value, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustLessThanOrEqualTo(String value) {
            addCriterion("IS_BASEBANK_RELA_CUST <=", value, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustLike(String value) {
            addCriterion("IS_BASEBANK_RELA_CUST like", value, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustNotLike(String value) {
            addCriterion("IS_BASEBANK_RELA_CUST not like", value, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustIn(List<String> values) {
            addCriterion("IS_BASEBANK_RELA_CUST in", values, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustNotIn(List<String> values) {
            addCriterion("IS_BASEBANK_RELA_CUST not in", values, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustBetween(String value1, String value2) {
            addCriterion("IS_BASEBANK_RELA_CUST between", value1, value2, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andIsBasebankRelaCustNotBetween(String value1, String value2) {
            addCriterion("IS_BASEBANK_RELA_CUST not between", value1, value2, "isBasebankRelaCust");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdIsNull() {
            addCriterion("THIRD_CUST_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdIsNotNull() {
            addCriterion("THIRD_CUST_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdEqualTo(String value) {
            addCriterion("THIRD_CUST_TYPE_CD =", value, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdNotEqualTo(String value) {
            addCriterion("THIRD_CUST_TYPE_CD <>", value, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdGreaterThan(String value) {
            addCriterion("THIRD_CUST_TYPE_CD >", value, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdGreaterThanOrEqualTo(String value) {
            addCriterion("THIRD_CUST_TYPE_CD >=", value, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdLessThan(String value) {
            addCriterion("THIRD_CUST_TYPE_CD <", value, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdLessThanOrEqualTo(String value) {
            addCriterion("THIRD_CUST_TYPE_CD <=", value, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdLike(String value) {
            addCriterion("THIRD_CUST_TYPE_CD like", value, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdNotLike(String value) {
            addCriterion("THIRD_CUST_TYPE_CD not like", value, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdIn(List<String> values) {
            addCriterion("THIRD_CUST_TYPE_CD in", values, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdNotIn(List<String> values) {
            addCriterion("THIRD_CUST_TYPE_CD not in", values, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdBetween(String value1, String value2) {
            addCriterion("THIRD_CUST_TYPE_CD between", value1, value2, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andThirdCustTypeCdNotBetween(String value1, String value2) {
            addCriterion("THIRD_CUST_TYPE_CD not between", value1, value2, "thirdCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustIsNull() {
            addCriterion("IS_THIRD_CUST is null");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustIsNotNull() {
            addCriterion("IS_THIRD_CUST is not null");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustEqualTo(String value) {
            addCriterion("IS_THIRD_CUST =", value, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustNotEqualTo(String value) {
            addCriterion("IS_THIRD_CUST <>", value, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustGreaterThan(String value) {
            addCriterion("IS_THIRD_CUST >", value, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustGreaterThanOrEqualTo(String value) {
            addCriterion("IS_THIRD_CUST >=", value, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustLessThan(String value) {
            addCriterion("IS_THIRD_CUST <", value, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustLessThanOrEqualTo(String value) {
            addCriterion("IS_THIRD_CUST <=", value, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustLike(String value) {
            addCriterion("IS_THIRD_CUST like", value, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustNotLike(String value) {
            addCriterion("IS_THIRD_CUST not like", value, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustIn(List<String> values) {
            addCriterion("IS_THIRD_CUST in", values, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustNotIn(List<String> values) {
            addCriterion("IS_THIRD_CUST not in", values, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustBetween(String value1, String value2) {
            addCriterion("IS_THIRD_CUST between", value1, value2, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andIsThirdCustNotBetween(String value1, String value2) {
            addCriterion("IS_THIRD_CUST not between", value1, value2, "isThirdCust");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateIsNull() {
            addCriterion("ENTERPRISE_CERT_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateIsNotNull() {
            addCriterion("ENTERPRISE_CERT_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateEqualTo(Date value) {
            addCriterion("ENTERPRISE_CERT_END_DATE =", value, "enterpriseCertEndDate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateNotEqualTo(Date value) {
            addCriterion("ENTERPRISE_CERT_END_DATE <>", value, "enterpriseCertEndDate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateGreaterThan(Date value) {
            addCriterion("ENTERPRISE_CERT_END_DATE >", value, "enterpriseCertEndDate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ENTERPRISE_CERT_END_DATE >=", value, "enterpriseCertEndDate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateLessThan(Date value) {
            addCriterion("ENTERPRISE_CERT_END_DATE <", value, "enterpriseCertEndDate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateLessThanOrEqualTo(Date value) {
            addCriterion("ENTERPRISE_CERT_END_DATE <=", value, "enterpriseCertEndDate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateIn(List<Date> values) {
            addCriterion("ENTERPRISE_CERT_END_DATE in", values, "enterpriseCertEndDate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateNotIn(List<Date> values) {
            addCriterion("ENTERPRISE_CERT_END_DATE not in", values, "enterpriseCertEndDate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateBetween(Date value1, Date value2) {
            addCriterion("ENTERPRISE_CERT_END_DATE between", value1, value2, "enterpriseCertEndDate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertEndDateNotBetween(Date value1, Date value2) {
            addCriterion("ENTERPRISE_CERT_END_DATE not between", value1, value2, "enterpriseCertEndDate");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumIsNull() {
            addCriterion("ENTERPRISE_CERT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumIsNotNull() {
            addCriterion("ENTERPRISE_CERT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumEqualTo(String value) {
            addCriterion("ENTERPRISE_CERT_NUM =", value, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumNotEqualTo(String value) {
            addCriterion("ENTERPRISE_CERT_NUM <>", value, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumGreaterThan(String value) {
            addCriterion("ENTERPRISE_CERT_NUM >", value, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_CERT_NUM >=", value, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumLessThan(String value) {
            addCriterion("ENTERPRISE_CERT_NUM <", value, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_CERT_NUM <=", value, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumLike(String value) {
            addCriterion("ENTERPRISE_CERT_NUM like", value, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumNotLike(String value) {
            addCriterion("ENTERPRISE_CERT_NUM not like", value, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumIn(List<String> values) {
            addCriterion("ENTERPRISE_CERT_NUM in", values, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumNotIn(List<String> values) {
            addCriterion("ENTERPRISE_CERT_NUM not in", values, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_CERT_NUM between", value1, value2, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCertNumNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_CERT_NUM not between", value1, value2, "enterpriseCertNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumIsNull() {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumIsNotNull() {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumEqualTo(String value) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM =", value, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumNotEqualTo(String value) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM <>", value, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumGreaterThan(String value) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM >", value, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumGreaterThanOrEqualTo(String value) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM >=", value, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumLessThan(String value) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM <", value, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumLessThanOrEqualTo(String value) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM <=", value, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumLike(String value) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM like", value, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumNotLike(String value) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM not like", value, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumIn(List<String> values) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM in", values, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumNotIn(List<String> values) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM not in", values, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumBetween(String value1, String value2) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM between", value1, value2, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andUnifySocietyCreditNumNotBetween(String value1, String value2) {
            addCriterion("UNIFY_SOCIETY_CREDIT_NUM not between", value1, value2, "unifySocietyCreditNum");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndIsNull() {
            addCriterion("SINGLE_LP_CUST_IND is null");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndIsNotNull() {
            addCriterion("SINGLE_LP_CUST_IND is not null");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndEqualTo(String value) {
            addCriterion("SINGLE_LP_CUST_IND =", value, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndNotEqualTo(String value) {
            addCriterion("SINGLE_LP_CUST_IND <>", value, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndGreaterThan(String value) {
            addCriterion("SINGLE_LP_CUST_IND >", value, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndGreaterThanOrEqualTo(String value) {
            addCriterion("SINGLE_LP_CUST_IND >=", value, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndLessThan(String value) {
            addCriterion("SINGLE_LP_CUST_IND <", value, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndLessThanOrEqualTo(String value) {
            addCriterion("SINGLE_LP_CUST_IND <=", value, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndLike(String value) {
            addCriterion("SINGLE_LP_CUST_IND like", value, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndNotLike(String value) {
            addCriterion("SINGLE_LP_CUST_IND not like", value, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndIn(List<String> values) {
            addCriterion("SINGLE_LP_CUST_IND in", values, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndNotIn(List<String> values) {
            addCriterion("SINGLE_LP_CUST_IND not in", values, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndBetween(String value1, String value2) {
            addCriterion("SINGLE_LP_CUST_IND between", value1, value2, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andSingleLpCustIndNotBetween(String value1, String value2) {
            addCriterion("SINGLE_LP_CUST_IND not between", value1, value2, "singleLpCustInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndIsNull() {
            addCriterion("STOP_CORP_IND is null");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndIsNotNull() {
            addCriterion("STOP_CORP_IND is not null");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndEqualTo(String value) {
            addCriterion("STOP_CORP_IND =", value, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndNotEqualTo(String value) {
            addCriterion("STOP_CORP_IND <>", value, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndGreaterThan(String value) {
            addCriterion("STOP_CORP_IND >", value, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndGreaterThanOrEqualTo(String value) {
            addCriterion("STOP_CORP_IND >=", value, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndLessThan(String value) {
            addCriterion("STOP_CORP_IND <", value, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndLessThanOrEqualTo(String value) {
            addCriterion("STOP_CORP_IND <=", value, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndLike(String value) {
            addCriterion("STOP_CORP_IND like", value, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndNotLike(String value) {
            addCriterion("STOP_CORP_IND not like", value, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndIn(List<String> values) {
            addCriterion("STOP_CORP_IND in", values, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndNotIn(List<String> values) {
            addCriterion("STOP_CORP_IND not in", values, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndBetween(String value1, String value2) {
            addCriterion("STOP_CORP_IND between", value1, value2, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andStopCorpIndNotBetween(String value1, String value2) {
            addCriterion("STOP_CORP_IND not between", value1, value2, "stopCorpInd");
            return (Criteria) this;
        }

        public Criteria andLegalContryIsNull() {
            addCriterion("LEGAL_CONTRY is null");
            return (Criteria) this;
        }

        public Criteria andLegalContryIsNotNull() {
            addCriterion("LEGAL_CONTRY is not null");
            return (Criteria) this;
        }

        public Criteria andLegalContryEqualTo(String value) {
            addCriterion("LEGAL_CONTRY =", value, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryNotEqualTo(String value) {
            addCriterion("LEGAL_CONTRY <>", value, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryGreaterThan(String value) {
            addCriterion("LEGAL_CONTRY >", value, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL_CONTRY >=", value, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryLessThan(String value) {
            addCriterion("LEGAL_CONTRY <", value, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryLessThanOrEqualTo(String value) {
            addCriterion("LEGAL_CONTRY <=", value, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryLike(String value) {
            addCriterion("LEGAL_CONTRY like", value, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryNotLike(String value) {
            addCriterion("LEGAL_CONTRY not like", value, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryIn(List<String> values) {
            addCriterion("LEGAL_CONTRY in", values, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryNotIn(List<String> values) {
            addCriterion("LEGAL_CONTRY not in", values, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryBetween(String value1, String value2) {
            addCriterion("LEGAL_CONTRY between", value1, value2, "legalContry");
            return (Criteria) this;
        }

        public Criteria andLegalContryNotBetween(String value1, String value2) {
            addCriterion("LEGAL_CONTRY not between", value1, value2, "legalContry");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyIsNull() {
            addCriterion("BANK_SCALE_IDENTIFY is null");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyIsNotNull() {
            addCriterion("BANK_SCALE_IDENTIFY is not null");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyEqualTo(String value) {
            addCriterion("BANK_SCALE_IDENTIFY =", value, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyNotEqualTo(String value) {
            addCriterion("BANK_SCALE_IDENTIFY <>", value, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyGreaterThan(String value) {
            addCriterion("BANK_SCALE_IDENTIFY >", value, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_SCALE_IDENTIFY >=", value, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyLessThan(String value) {
            addCriterion("BANK_SCALE_IDENTIFY <", value, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyLessThanOrEqualTo(String value) {
            addCriterion("BANK_SCALE_IDENTIFY <=", value, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyLike(String value) {
            addCriterion("BANK_SCALE_IDENTIFY like", value, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyNotLike(String value) {
            addCriterion("BANK_SCALE_IDENTIFY not like", value, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyIn(List<String> values) {
            addCriterion("BANK_SCALE_IDENTIFY in", values, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyNotIn(List<String> values) {
            addCriterion("BANK_SCALE_IDENTIFY not in", values, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyBetween(String value1, String value2) {
            addCriterion("BANK_SCALE_IDENTIFY between", value1, value2, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andBankScaleIdentifyNotBetween(String value1, String value2) {
            addCriterion("BANK_SCALE_IDENTIFY not between", value1, value2, "bankScaleIdentify");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberIsNull() {
            addCriterion("LEGAL_PHONE_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberIsNotNull() {
            addCriterion("LEGAL_PHONE_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberEqualTo(String value) {
            addCriterion("LEGAL_PHONE_NUMBER =", value, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberNotEqualTo(String value) {
            addCriterion("LEGAL_PHONE_NUMBER <>", value, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberGreaterThan(String value) {
            addCriterion("LEGAL_PHONE_NUMBER >", value, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL_PHONE_NUMBER >=", value, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberLessThan(String value) {
            addCriterion("LEGAL_PHONE_NUMBER <", value, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("LEGAL_PHONE_NUMBER <=", value, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberLike(String value) {
            addCriterion("LEGAL_PHONE_NUMBER like", value, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberNotLike(String value) {
            addCriterion("LEGAL_PHONE_NUMBER not like", value, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberIn(List<String> values) {
            addCriterion("LEGAL_PHONE_NUMBER in", values, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberNotIn(List<String> values) {
            addCriterion("LEGAL_PHONE_NUMBER not in", values, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberBetween(String value1, String value2) {
            addCriterion("LEGAL_PHONE_NUMBER between", value1, value2, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("LEGAL_PHONE_NUMBER not between", value1, value2, "legalPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateIsNull() {
            addCriterion("LEGAL_REGIST_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateIsNotNull() {
            addCriterion("LEGAL_REGIST_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateEqualTo(Date value) {
            addCriterion("LEGAL_REGIST_DATE =", value, "legalRegistDate");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateNotEqualTo(Date value) {
            addCriterion("LEGAL_REGIST_DATE <>", value, "legalRegistDate");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateGreaterThan(Date value) {
            addCriterion("LEGAL_REGIST_DATE >", value, "legalRegistDate");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LEGAL_REGIST_DATE >=", value, "legalRegistDate");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateLessThan(Date value) {
            addCriterion("LEGAL_REGIST_DATE <", value, "legalRegistDate");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateLessThanOrEqualTo(Date value) {
            addCriterion("LEGAL_REGIST_DATE <=", value, "legalRegistDate");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateIn(List<Date> values) {
            addCriterion("LEGAL_REGIST_DATE in", values, "legalRegistDate");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateNotIn(List<Date> values) {
            addCriterion("LEGAL_REGIST_DATE not in", values, "legalRegistDate");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateBetween(Date value1, Date value2) {
            addCriterion("LEGAL_REGIST_DATE between", value1, value2, "legalRegistDate");
            return (Criteria) this;
        }

        public Criteria andLegalRegistDateNotBetween(Date value1, Date value2) {
            addCriterion("LEGAL_REGIST_DATE not between", value1, value2, "legalRegistDate");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignIsNull() {
            addCriterion("LEGAL_CONTRY_SIGN is null");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignIsNotNull() {
            addCriterion("LEGAL_CONTRY_SIGN is not null");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignEqualTo(String value) {
            addCriterion("LEGAL_CONTRY_SIGN =", value, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignNotEqualTo(String value) {
            addCriterion("LEGAL_CONTRY_SIGN <>", value, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignGreaterThan(String value) {
            addCriterion("LEGAL_CONTRY_SIGN >", value, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL_CONTRY_SIGN >=", value, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignLessThan(String value) {
            addCriterion("LEGAL_CONTRY_SIGN <", value, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignLessThanOrEqualTo(String value) {
            addCriterion("LEGAL_CONTRY_SIGN <=", value, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignLike(String value) {
            addCriterion("LEGAL_CONTRY_SIGN like", value, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignNotLike(String value) {
            addCriterion("LEGAL_CONTRY_SIGN not like", value, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignIn(List<String> values) {
            addCriterion("LEGAL_CONTRY_SIGN in", values, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignNotIn(List<String> values) {
            addCriterion("LEGAL_CONTRY_SIGN not in", values, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignBetween(String value1, String value2) {
            addCriterion("LEGAL_CONTRY_SIGN between", value1, value2, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andLegalContrySignNotBetween(String value1, String value2) {
            addCriterion("LEGAL_CONTRY_SIGN not between", value1, value2, "legalContrySign");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicIsNull() {
            addCriterion("WHETHER_TECHNIC is null");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicIsNotNull() {
            addCriterion("WHETHER_TECHNIC is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicEqualTo(String value) {
            addCriterion("WHETHER_TECHNIC =", value, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicNotEqualTo(String value) {
            addCriterion("WHETHER_TECHNIC <>", value, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicGreaterThan(String value) {
            addCriterion("WHETHER_TECHNIC >", value, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_TECHNIC >=", value, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicLessThan(String value) {
            addCriterion("WHETHER_TECHNIC <", value, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_TECHNIC <=", value, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicLike(String value) {
            addCriterion("WHETHER_TECHNIC like", value, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicNotLike(String value) {
            addCriterion("WHETHER_TECHNIC not like", value, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicIn(List<String> values) {
            addCriterion("WHETHER_TECHNIC in", values, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicNotIn(List<String> values) {
            addCriterion("WHETHER_TECHNIC not in", values, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicBetween(String value1, String value2) {
            addCriterion("WHETHER_TECHNIC between", value1, value2, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherTechnicNotBetween(String value1, String value2) {
            addCriterion("WHETHER_TECHNIC not between", value1, value2, "whetherTechnic");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupIsNull() {
            addCriterion("WHETHER_GREEN_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupIsNotNull() {
            addCriterion("WHETHER_GREEN_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupEqualTo(String value) {
            addCriterion("WHETHER_GREEN_GROUP =", value, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupNotEqualTo(String value) {
            addCriterion("WHETHER_GREEN_GROUP <>", value, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupGreaterThan(String value) {
            addCriterion("WHETHER_GREEN_GROUP >", value, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_GREEN_GROUP >=", value, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupLessThan(String value) {
            addCriterion("WHETHER_GREEN_GROUP <", value, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_GREEN_GROUP <=", value, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupLike(String value) {
            addCriterion("WHETHER_GREEN_GROUP like", value, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupNotLike(String value) {
            addCriterion("WHETHER_GREEN_GROUP not like", value, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupIn(List<String> values) {
            addCriterion("WHETHER_GREEN_GROUP in", values, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupNotIn(List<String> values) {
            addCriterion("WHETHER_GREEN_GROUP not in", values, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupBetween(String value1, String value2) {
            addCriterion("WHETHER_GREEN_GROUP between", value1, value2, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherGreenGroupNotBetween(String value1, String value2) {
            addCriterion("WHETHER_GREEN_GROUP not between", value1, value2, "whetherGreenGroup");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhIsNull() {
            addCriterion("WHETHER_JMRH is null");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhIsNotNull() {
            addCriterion("WHETHER_JMRH is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhEqualTo(String value) {
            addCriterion("WHETHER_JMRH =", value, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhNotEqualTo(String value) {
            addCriterion("WHETHER_JMRH <>", value, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhGreaterThan(String value) {
            addCriterion("WHETHER_JMRH >", value, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_JMRH >=", value, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhLessThan(String value) {
            addCriterion("WHETHER_JMRH <", value, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_JMRH <=", value, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhLike(String value) {
            addCriterion("WHETHER_JMRH like", value, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhNotLike(String value) {
            addCriterion("WHETHER_JMRH not like", value, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhIn(List<String> values) {
            addCriterion("WHETHER_JMRH in", values, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhNotIn(List<String> values) {
            addCriterion("WHETHER_JMRH not in", values, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhBetween(String value1, String value2) {
            addCriterion("WHETHER_JMRH between", value1, value2, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherJmrhNotBetween(String value1, String value2) {
            addCriterion("WHETHER_JMRH not between", value1, value2, "whetherJmrh");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedIsNull() {
            addCriterion("WHETHER_ARG_RELATED is null");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedIsNotNull() {
            addCriterion("WHETHER_ARG_RELATED is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedEqualTo(String value) {
            addCriterion("WHETHER_ARG_RELATED =", value, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedNotEqualTo(String value) {
            addCriterion("WHETHER_ARG_RELATED <>", value, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedGreaterThan(String value) {
            addCriterion("WHETHER_ARG_RELATED >", value, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_ARG_RELATED >=", value, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedLessThan(String value) {
            addCriterion("WHETHER_ARG_RELATED <", value, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_ARG_RELATED <=", value, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedLike(String value) {
            addCriterion("WHETHER_ARG_RELATED like", value, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedNotLike(String value) {
            addCriterion("WHETHER_ARG_RELATED not like", value, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedIn(List<String> values) {
            addCriterion("WHETHER_ARG_RELATED in", values, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedNotIn(List<String> values) {
            addCriterion("WHETHER_ARG_RELATED not in", values, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedBetween(String value1, String value2) {
            addCriterion("WHETHER_ARG_RELATED between", value1, value2, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherArgRelatedNotBetween(String value1, String value2) {
            addCriterion("WHETHER_ARG_RELATED not between", value1, value2, "whetherArgRelated");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctIsNull() {
            addCriterion("WHETHER_OPEN_ACCT is null");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctIsNotNull() {
            addCriterion("WHETHER_OPEN_ACCT is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctEqualTo(String value) {
            addCriterion("WHETHER_OPEN_ACCT =", value, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctNotEqualTo(String value) {
            addCriterion("WHETHER_OPEN_ACCT <>", value, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctGreaterThan(String value) {
            addCriterion("WHETHER_OPEN_ACCT >", value, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_OPEN_ACCT >=", value, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctLessThan(String value) {
            addCriterion("WHETHER_OPEN_ACCT <", value, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_OPEN_ACCT <=", value, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctLike(String value) {
            addCriterion("WHETHER_OPEN_ACCT like", value, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctNotLike(String value) {
            addCriterion("WHETHER_OPEN_ACCT not like", value, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctIn(List<String> values) {
            addCriterion("WHETHER_OPEN_ACCT in", values, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctNotIn(List<String> values) {
            addCriterion("WHETHER_OPEN_ACCT not in", values, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctBetween(String value1, String value2) {
            addCriterion("WHETHER_OPEN_ACCT between", value1, value2, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherOpenAcctNotBetween(String value1, String value2) {
            addCriterion("WHETHER_OPEN_ACCT not between", value1, value2, "whetherOpenAcct");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddIsNull() {
            addCriterion("WHETHER_POVERTY_ADD is null");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddIsNotNull() {
            addCriterion("WHETHER_POVERTY_ADD is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddEqualTo(String value) {
            addCriterion("WHETHER_POVERTY_ADD =", value, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddNotEqualTo(String value) {
            addCriterion("WHETHER_POVERTY_ADD <>", value, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddGreaterThan(String value) {
            addCriterion("WHETHER_POVERTY_ADD >", value, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_POVERTY_ADD >=", value, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddLessThan(String value) {
            addCriterion("WHETHER_POVERTY_ADD <", value, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_POVERTY_ADD <=", value, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddLike(String value) {
            addCriterion("WHETHER_POVERTY_ADD like", value, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddNotLike(String value) {
            addCriterion("WHETHER_POVERTY_ADD not like", value, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddIn(List<String> values) {
            addCriterion("WHETHER_POVERTY_ADD in", values, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddNotIn(List<String> values) {
            addCriterion("WHETHER_POVERTY_ADD not in", values, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddBetween(String value1, String value2) {
            addCriterion("WHETHER_POVERTY_ADD between", value1, value2, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andWhetherPovertyAddNotBetween(String value1, String value2) {
            addCriterion("WHETHER_POVERTY_ADD not between", value1, value2, "whetherPovertyAdd");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("AREA is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("AREA is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("AREA =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("AREA <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("AREA >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("AREA >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("AREA <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("AREA <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("AREA like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("AREA not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("AREA in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("AREA not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("AREA between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("AREA not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("OWNER is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("OWNER =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("OWNER <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("OWNER >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("OWNER >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("OWNER <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("OWNER <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("OWNER like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("OWNER not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("OWNER in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("OWNER not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("OWNER between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("OWNER not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeIsNull() {
            addCriterion("NATIONAL_ECONOMY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeIsNotNull() {
            addCriterion("NATIONAL_ECONOMY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeEqualTo(String value) {
            addCriterion("NATIONAL_ECONOMY_TYPE =", value, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeNotEqualTo(String value) {
            addCriterion("NATIONAL_ECONOMY_TYPE <>", value, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeGreaterThan(String value) {
            addCriterion("NATIONAL_ECONOMY_TYPE >", value, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("NATIONAL_ECONOMY_TYPE >=", value, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeLessThan(String value) {
            addCriterion("NATIONAL_ECONOMY_TYPE <", value, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeLessThanOrEqualTo(String value) {
            addCriterion("NATIONAL_ECONOMY_TYPE <=", value, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeLike(String value) {
            addCriterion("NATIONAL_ECONOMY_TYPE like", value, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeNotLike(String value) {
            addCriterion("NATIONAL_ECONOMY_TYPE not like", value, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeIn(List<String> values) {
            addCriterion("NATIONAL_ECONOMY_TYPE in", values, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeNotIn(List<String> values) {
            addCriterion("NATIONAL_ECONOMY_TYPE not in", values, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeBetween(String value1, String value2) {
            addCriterion("NATIONAL_ECONOMY_TYPE between", value1, value2, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andNationalEconomyTypeNotBetween(String value1, String value2) {
            addCriterion("NATIONAL_ECONOMY_TYPE not between", value1, value2, "nationalEconomyType");
            return (Criteria) this;
        }

        public Criteria andChainSignIsNull() {
            addCriterion("CHAIN_SIGN is null");
            return (Criteria) this;
        }

        public Criteria andChainSignIsNotNull() {
            addCriterion("CHAIN_SIGN is not null");
            return (Criteria) this;
        }

        public Criteria andChainSignEqualTo(String value) {
            addCriterion("CHAIN_SIGN =", value, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignNotEqualTo(String value) {
            addCriterion("CHAIN_SIGN <>", value, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignGreaterThan(String value) {
            addCriterion("CHAIN_SIGN >", value, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignGreaterThanOrEqualTo(String value) {
            addCriterion("CHAIN_SIGN >=", value, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignLessThan(String value) {
            addCriterion("CHAIN_SIGN <", value, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignLessThanOrEqualTo(String value) {
            addCriterion("CHAIN_SIGN <=", value, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignLike(String value) {
            addCriterion("CHAIN_SIGN like", value, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignNotLike(String value) {
            addCriterion("CHAIN_SIGN not like", value, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignIn(List<String> values) {
            addCriterion("CHAIN_SIGN in", values, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignNotIn(List<String> values) {
            addCriterion("CHAIN_SIGN not in", values, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignBetween(String value1, String value2) {
            addCriterion("CHAIN_SIGN between", value1, value2, "chainSign");
            return (Criteria) this;
        }

        public Criteria andChainSignNotBetween(String value1, String value2) {
            addCriterion("CHAIN_SIGN not between", value1, value2, "chainSign");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdIsNull() {
            addCriterion("MAIN_CUST_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdIsNotNull() {
            addCriterion("MAIN_CUST_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdEqualTo(String value) {
            addCriterion("MAIN_CUST_TYPE_CD =", value, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdNotEqualTo(String value) {
            addCriterion("MAIN_CUST_TYPE_CD <>", value, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdGreaterThan(String value) {
            addCriterion("MAIN_CUST_TYPE_CD >", value, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdGreaterThanOrEqualTo(String value) {
            addCriterion("MAIN_CUST_TYPE_CD >=", value, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdLessThan(String value) {
            addCriterion("MAIN_CUST_TYPE_CD <", value, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdLessThanOrEqualTo(String value) {
            addCriterion("MAIN_CUST_TYPE_CD <=", value, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdLike(String value) {
            addCriterion("MAIN_CUST_TYPE_CD like", value, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdNotLike(String value) {
            addCriterion("MAIN_CUST_TYPE_CD not like", value, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdIn(List<String> values) {
            addCriterion("MAIN_CUST_TYPE_CD in", values, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdNotIn(List<String> values) {
            addCriterion("MAIN_CUST_TYPE_CD not in", values, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdBetween(String value1, String value2) {
            addCriterion("MAIN_CUST_TYPE_CD between", value1, value2, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andMainCustTypeCdNotBetween(String value1, String value2) {
            addCriterion("MAIN_CUST_TYPE_CD not between", value1, value2, "mainCustTypeCd");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIsNull() {
            addCriterion("ORG_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIsNotNull() {
            addCriterion("ORG_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOrgStatusEqualTo(String value) {
            addCriterion("ORG_STATUS =", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotEqualTo(String value) {
            addCriterion("ORG_STATUS <>", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusGreaterThan(String value) {
            addCriterion("ORG_STATUS >", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_STATUS >=", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLessThan(String value) {
            addCriterion("ORG_STATUS <", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLessThanOrEqualTo(String value) {
            addCriterion("ORG_STATUS <=", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLike(String value) {
            addCriterion("ORG_STATUS like", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotLike(String value) {
            addCriterion("ORG_STATUS not like", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIn(List<String> values) {
            addCriterion("ORG_STATUS in", values, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotIn(List<String> values) {
            addCriterion("ORG_STATUS not in", values, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusBetween(String value1, String value2) {
            addCriterion("ORG_STATUS between", value1, value2, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotBetween(String value1, String value2) {
            addCriterion("ORG_STATUS not between", value1, value2, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andIfCsyIsNull() {
            addCriterion("IF_CSY is null");
            return (Criteria) this;
        }

        public Criteria andIfCsyIsNotNull() {
            addCriterion("IF_CSY is not null");
            return (Criteria) this;
        }

        public Criteria andIfCsyEqualTo(String value) {
            addCriterion("IF_CSY =", value, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyNotEqualTo(String value) {
            addCriterion("IF_CSY <>", value, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyGreaterThan(String value) {
            addCriterion("IF_CSY >", value, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyGreaterThanOrEqualTo(String value) {
            addCriterion("IF_CSY >=", value, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyLessThan(String value) {
            addCriterion("IF_CSY <", value, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyLessThanOrEqualTo(String value) {
            addCriterion("IF_CSY <=", value, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyLike(String value) {
            addCriterion("IF_CSY like", value, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyNotLike(String value) {
            addCriterion("IF_CSY not like", value, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyIn(List<String> values) {
            addCriterion("IF_CSY in", values, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyNotIn(List<String> values) {
            addCriterion("IF_CSY not in", values, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyBetween(String value1, String value2) {
            addCriterion("IF_CSY between", value1, value2, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andIfCsyNotBetween(String value1, String value2) {
            addCriterion("IF_CSY not between", value1, value2, "ifCsy");
            return (Criteria) this;
        }

        public Criteria andLoanTurnIsNull() {
            addCriterion("LOAN_TURN is null");
            return (Criteria) this;
        }

        public Criteria andLoanTurnIsNotNull() {
            addCriterion("LOAN_TURN is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTurnEqualTo(String value) {
            addCriterion("LOAN_TURN =", value, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnNotEqualTo(String value) {
            addCriterion("LOAN_TURN <>", value, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnGreaterThan(String value) {
            addCriterion("LOAN_TURN >", value, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_TURN >=", value, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnLessThan(String value) {
            addCriterion("LOAN_TURN <", value, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnLessThanOrEqualTo(String value) {
            addCriterion("LOAN_TURN <=", value, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnLike(String value) {
            addCriterion("LOAN_TURN like", value, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnNotLike(String value) {
            addCriterion("LOAN_TURN not like", value, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnIn(List<String> values) {
            addCriterion("LOAN_TURN in", values, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnNotIn(List<String> values) {
            addCriterion("LOAN_TURN not in", values, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnBetween(String value1, String value2) {
            addCriterion("LOAN_TURN between", value1, value2, "loanTurn");
            return (Criteria) this;
        }

        public Criteria andLoanTurnNotBetween(String value1, String value2) {
            addCriterion("LOAN_TURN not between", value1, value2, "loanTurn");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}