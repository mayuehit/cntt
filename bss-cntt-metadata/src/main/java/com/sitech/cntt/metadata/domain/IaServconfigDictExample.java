package com.sitech.cntt.metadata.domain;

import java.util.ArrayList;
import java.util.List;

public class IaServconfigDictExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    public IaServconfigDictExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
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

        public Criteria andServIdIsNull() {
            addCriterion("SERV_ID is null");
            return (Criteria) this;
        }

        public Criteria andServIdIsNotNull() {
            addCriterion("SERV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServIdEqualTo(Long value) {
            addCriterion("SERV_ID =", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotEqualTo(Long value) {
            addCriterion("SERV_ID <>", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdGreaterThan(Long value) {
            addCriterion("SERV_ID >", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SERV_ID >=", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLessThan(Long value) {
            addCriterion("SERV_ID <", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLessThanOrEqualTo(Long value) {
            addCriterion("SERV_ID <=", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdIn(List<Long> values) {
            addCriterion("SERV_ID in", values, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotIn(List<Long> values) {
            addCriterion("SERV_ID not in", values, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdBetween(Long value1, Long value2) {
            addCriterion("SERV_ID between", value1, value2, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotBetween(Long value1, Long value2) {
            addCriterion("SERV_ID not between", value1, value2, "servId");
            return (Criteria) this;
        }

        public Criteria andAppCodeIsNull() {
            addCriterion("APP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAppCodeIsNotNull() {
            addCriterion("APP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAppCodeEqualTo(String value) {
            addCriterion("APP_CODE =", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotEqualTo(String value) {
            addCriterion("APP_CODE <>", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeGreaterThan(String value) {
            addCriterion("APP_CODE >", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeGreaterThanOrEqualTo(String value) {
            addCriterion("APP_CODE >=", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeLessThan(String value) {
            addCriterion("APP_CODE <", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeLessThanOrEqualTo(String value) {
            addCriterion("APP_CODE <=", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeLike(String value) {
            addCriterion("APP_CODE like", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotLike(String value) {
            addCriterion("APP_CODE not like", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeIn(List<String> values) {
            addCriterion("APP_CODE in", values, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotIn(List<String> values) {
            addCriterion("APP_CODE not in", values, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeBetween(String value1, String value2) {
            addCriterion("APP_CODE between", value1, value2, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotBetween(String value1, String value2) {
            addCriterion("APP_CODE not between", value1, value2, "appCode");
            return (Criteria) this;
        }

        public Criteria andServCodeIsNull() {
            addCriterion("SERV_CODE is null");
            return (Criteria) this;
        }

        public Criteria andServCodeIsNotNull() {
            addCriterion("SERV_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andServCodeEqualTo(String value) {
            addCriterion("SERV_CODE =", value, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeNotEqualTo(String value) {
            addCriterion("SERV_CODE <>", value, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeGreaterThan(String value) {
            addCriterion("SERV_CODE >", value, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_CODE >=", value, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeLessThan(String value) {
            addCriterion("SERV_CODE <", value, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeLessThanOrEqualTo(String value) {
            addCriterion("SERV_CODE <=", value, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeLike(String value) {
            addCriterion("SERV_CODE like", value, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeNotLike(String value) {
            addCriterion("SERV_CODE not like", value, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeIn(List<String> values) {
            addCriterion("SERV_CODE in", values, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeNotIn(List<String> values) {
            addCriterion("SERV_CODE not in", values, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeBetween(String value1, String value2) {
            addCriterion("SERV_CODE between", value1, value2, "servCode");
            return (Criteria) this;
        }

        public Criteria andServCodeNotBetween(String value1, String value2) {
            addCriterion("SERV_CODE not between", value1, value2, "servCode");
            return (Criteria) this;
        }

        public Criteria andServNameIsNull() {
            addCriterion("SERV_NAME is null");
            return (Criteria) this;
        }

        public Criteria andServNameIsNotNull() {
            addCriterion("SERV_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andServNameEqualTo(String value) {
            addCriterion("SERV_NAME =", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameNotEqualTo(String value) {
            addCriterion("SERV_NAME <>", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameGreaterThan(String value) {
            addCriterion("SERV_NAME >", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_NAME >=", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameLessThan(String value) {
            addCriterion("SERV_NAME <", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameLessThanOrEqualTo(String value) {
            addCriterion("SERV_NAME <=", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameLike(String value) {
            addCriterion("SERV_NAME like", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameNotLike(String value) {
            addCriterion("SERV_NAME not like", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameIn(List<String> values) {
            addCriterion("SERV_NAME in", values, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameNotIn(List<String> values) {
            addCriterion("SERV_NAME not in", values, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameBetween(String value1, String value2) {
            addCriterion("SERV_NAME between", value1, value2, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameNotBetween(String value1, String value2) {
            addCriterion("SERV_NAME not between", value1, value2, "servName");
            return (Criteria) this;
        }

        public Criteria andServTypeIsNull() {
            addCriterion("SERV_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andServTypeIsNotNull() {
            addCriterion("SERV_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServTypeEqualTo(String value) {
            addCriterion("SERV_TYPE =", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotEqualTo(String value) {
            addCriterion("SERV_TYPE <>", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeGreaterThan(String value) {
            addCriterion("SERV_TYPE >", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_TYPE >=", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeLessThan(String value) {
            addCriterion("SERV_TYPE <", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeLessThanOrEqualTo(String value) {
            addCriterion("SERV_TYPE <=", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeLike(String value) {
            addCriterion("SERV_TYPE like", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotLike(String value) {
            addCriterion("SERV_TYPE not like", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeIn(List<String> values) {
            addCriterion("SERV_TYPE in", values, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotIn(List<String> values) {
            addCriterion("SERV_TYPE not in", values, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeBetween(String value1, String value2) {
            addCriterion("SERV_TYPE between", value1, value2, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotBetween(String value1, String value2) {
            addCriterion("SERV_TYPE not between", value1, value2, "servType");
            return (Criteria) this;
        }

        public Criteria andChnCodesIsNull() {
            addCriterion("CHN_CODES is null");
            return (Criteria) this;
        }

        public Criteria andChnCodesIsNotNull() {
            addCriterion("CHN_CODES is not null");
            return (Criteria) this;
        }

        public Criteria andChnCodesEqualTo(String value) {
            addCriterion("CHN_CODES =", value, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesNotEqualTo(String value) {
            addCriterion("CHN_CODES <>", value, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesGreaterThan(String value) {
            addCriterion("CHN_CODES >", value, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesGreaterThanOrEqualTo(String value) {
            addCriterion("CHN_CODES >=", value, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesLessThan(String value) {
            addCriterion("CHN_CODES <", value, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesLessThanOrEqualTo(String value) {
            addCriterion("CHN_CODES <=", value, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesLike(String value) {
            addCriterion("CHN_CODES like", value, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesNotLike(String value) {
            addCriterion("CHN_CODES not like", value, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesIn(List<String> values) {
            addCriterion("CHN_CODES in", values, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesNotIn(List<String> values) {
            addCriterion("CHN_CODES not in", values, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesBetween(String value1, String value2) {
            addCriterion("CHN_CODES between", value1, value2, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andChnCodesNotBetween(String value1, String value2) {
            addCriterion("CHN_CODES not between", value1, value2, "chnCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesIsNull() {
            addCriterion("FUNC_CODES is null");
            return (Criteria) this;
        }

        public Criteria andFuncCodesIsNotNull() {
            addCriterion("FUNC_CODES is not null");
            return (Criteria) this;
        }

        public Criteria andFuncCodesEqualTo(String value) {
            addCriterion("FUNC_CODES =", value, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesNotEqualTo(String value) {
            addCriterion("FUNC_CODES <>", value, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesGreaterThan(String value) {
            addCriterion("FUNC_CODES >", value, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_CODES >=", value, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesLessThan(String value) {
            addCriterion("FUNC_CODES <", value, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesLessThanOrEqualTo(String value) {
            addCriterion("FUNC_CODES <=", value, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesLike(String value) {
            addCriterion("FUNC_CODES like", value, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesNotLike(String value) {
            addCriterion("FUNC_CODES not like", value, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesIn(List<String> values) {
            addCriterion("FUNC_CODES in", values, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesNotIn(List<String> values) {
            addCriterion("FUNC_CODES not in", values, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesBetween(String value1, String value2) {
            addCriterion("FUNC_CODES between", value1, value2, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andFuncCodesNotBetween(String value1, String value2) {
            addCriterion("FUNC_CODES not between", value1, value2, "funcCodes");
            return (Criteria) this;
        }

        public Criteria andServPathIsNull() {
            addCriterion("SERV_PATH is null");
            return (Criteria) this;
        }

        public Criteria andServPathIsNotNull() {
            addCriterion("SERV_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andServPathEqualTo(String value) {
            addCriterion("SERV_PATH =", value, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathNotEqualTo(String value) {
            addCriterion("SERV_PATH <>", value, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathGreaterThan(String value) {
            addCriterion("SERV_PATH >", value, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PATH >=", value, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathLessThan(String value) {
            addCriterion("SERV_PATH <", value, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathLessThanOrEqualTo(String value) {
            addCriterion("SERV_PATH <=", value, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathLike(String value) {
            addCriterion("SERV_PATH like", value, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathNotLike(String value) {
            addCriterion("SERV_PATH not like", value, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathIn(List<String> values) {
            addCriterion("SERV_PATH in", values, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathNotIn(List<String> values) {
            addCriterion("SERV_PATH not in", values, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathBetween(String value1, String value2) {
            addCriterion("SERV_PATH between", value1, value2, "servPath");
            return (Criteria) this;
        }

        public Criteria andServPathNotBetween(String value1, String value2) {
            addCriterion("SERV_PATH not between", value1, value2, "servPath");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table IA_SERVCONFIG_DICT
     *
     * @mbggenerated
     */
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