package com.gcf.sms.bean;

import java.util.ArrayList;
import java.util.List;

public class FestivalTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FestivalTempExample() {
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

        public Criteria andFestivalIdIsNull() {
            addCriterion("festival_id is null");
            return (Criteria) this;
        }

        public Criteria andFestivalIdIsNotNull() {
            addCriterion("festival_id is not null");
            return (Criteria) this;
        }

        public Criteria andFestivalIdEqualTo(Integer value) {
            addCriterion("festival_id =", value, "festivalId");
            return (Criteria) this;
        }

        public Criteria andFestivalIdNotEqualTo(Integer value) {
            addCriterion("festival_id <>", value, "festivalId");
            return (Criteria) this;
        }

        public Criteria andFestivalIdGreaterThan(Integer value) {
            addCriterion("festival_id >", value, "festivalId");
            return (Criteria) this;
        }

        public Criteria andFestivalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("festival_id >=", value, "festivalId");
            return (Criteria) this;
        }

        public Criteria andFestivalIdLessThan(Integer value) {
            addCriterion("festival_id <", value, "festivalId");
            return (Criteria) this;
        }

        public Criteria andFestivalIdLessThanOrEqualTo(Integer value) {
            addCriterion("festival_id <=", value, "festivalId");
            return (Criteria) this;
        }

        public Criteria andFestivalIdIn(List<Integer> values) {
            addCriterion("festival_id in", values, "festivalId");
            return (Criteria) this;
        }

        public Criteria andFestivalIdNotIn(List<Integer> values) {
            addCriterion("festival_id not in", values, "festivalId");
            return (Criteria) this;
        }

        public Criteria andFestivalIdBetween(Integer value1, Integer value2) {
            addCriterion("festival_id between", value1, value2, "festivalId");
            return (Criteria) this;
        }

        public Criteria andFestivalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("festival_id not between", value1, value2, "festivalId");
            return (Criteria) this;
        }

        public Criteria andFestivalNameIsNull() {
            addCriterion("festival_name is null");
            return (Criteria) this;
        }

        public Criteria andFestivalNameIsNotNull() {
            addCriterion("festival_name is not null");
            return (Criteria) this;
        }

        public Criteria andFestivalNameEqualTo(String value) {
            addCriterion("festival_name =", value, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameNotEqualTo(String value) {
            addCriterion("festival_name <>", value, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameGreaterThan(String value) {
            addCriterion("festival_name >", value, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameGreaterThanOrEqualTo(String value) {
            addCriterion("festival_name >=", value, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameLessThan(String value) {
            addCriterion("festival_name <", value, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameLessThanOrEqualTo(String value) {
            addCriterion("festival_name <=", value, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameLike(String value) {
            addCriterion("festival_name like", value, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameNotLike(String value) {
            addCriterion("festival_name not like", value, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameIn(List<String> values) {
            addCriterion("festival_name in", values, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameNotIn(List<String> values) {
            addCriterion("festival_name not in", values, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameBetween(String value1, String value2) {
            addCriterion("festival_name between", value1, value2, "festivalName");
            return (Criteria) this;
        }

        public Criteria andFestivalNameNotBetween(String value1, String value2) {
            addCriterion("festival_name not between", value1, value2, "festivalName");
            return (Criteria) this;
        }

        public Criteria andTemplateconIsNull() {
            addCriterion("templateCon is null");
            return (Criteria) this;
        }

        public Criteria andTemplateconIsNotNull() {
            addCriterion("templateCon is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateconEqualTo(String value) {
            addCriterion("templateCon =", value, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconNotEqualTo(String value) {
            addCriterion("templateCon <>", value, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconGreaterThan(String value) {
            addCriterion("templateCon >", value, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconGreaterThanOrEqualTo(String value) {
            addCriterion("templateCon >=", value, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconLessThan(String value) {
            addCriterion("templateCon <", value, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconLessThanOrEqualTo(String value) {
            addCriterion("templateCon <=", value, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconLike(String value) {
            addCriterion("templateCon like", value, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconNotLike(String value) {
            addCriterion("templateCon not like", value, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconIn(List<String> values) {
            addCriterion("templateCon in", values, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconNotIn(List<String> values) {
            addCriterion("templateCon not in", values, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconBetween(String value1, String value2) {
            addCriterion("templateCon between", value1, value2, "templatecon");
            return (Criteria) this;
        }

        public Criteria andTemplateconNotBetween(String value1, String value2) {
            addCriterion("templateCon not between", value1, value2, "templatecon");
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