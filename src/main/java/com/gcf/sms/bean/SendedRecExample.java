package com.gcf.sms.bean;

import java.util.ArrayList;
import java.util.List;

public class SendedRecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SendedRecExample() {
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

        public Criteria andSrecordIdIsNull() {
            addCriterion("SRecord_id is null");
            return (Criteria) this;
        }

        public Criteria andSrecordIdIsNotNull() {
            addCriterion("SRecord_id is not null");
            return (Criteria) this;
        }

        public Criteria andSrecordIdEqualTo(Integer value) {
            addCriterion("SRecord_id =", value, "srecordId");
            return (Criteria) this;
        }

        public Criteria andSrecordIdNotEqualTo(Integer value) {
            addCriterion("SRecord_id <>", value, "srecordId");
            return (Criteria) this;
        }

        public Criteria andSrecordIdGreaterThan(Integer value) {
            addCriterion("SRecord_id >", value, "srecordId");
            return (Criteria) this;
        }

        public Criteria andSrecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SRecord_id >=", value, "srecordId");
            return (Criteria) this;
        }

        public Criteria andSrecordIdLessThan(Integer value) {
            addCriterion("SRecord_id <", value, "srecordId");
            return (Criteria) this;
        }

        public Criteria andSrecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("SRecord_id <=", value, "srecordId");
            return (Criteria) this;
        }

        public Criteria andSrecordIdIn(List<Integer> values) {
            addCriterion("SRecord_id in", values, "srecordId");
            return (Criteria) this;
        }

        public Criteria andSrecordIdNotIn(List<Integer> values) {
            addCriterion("SRecord_id not in", values, "srecordId");
            return (Criteria) this;
        }

        public Criteria andSrecordIdBetween(Integer value1, Integer value2) {
            addCriterion("SRecord_id between", value1, value2, "srecordId");
            return (Criteria) this;
        }

        public Criteria andSrecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SRecord_id not between", value1, value2, "srecordId");
            return (Criteria) this;
        }

        public Criteria andRececompanyidIsNull() {
            addCriterion("receCompanyId is null");
            return (Criteria) this;
        }

        public Criteria andRececompanyidIsNotNull() {
            addCriterion("receCompanyId is not null");
            return (Criteria) this;
        }

        public Criteria andRececompanyidEqualTo(Integer value) {
            addCriterion("receCompanyId =", value, "rececompanyid");
            return (Criteria) this;
        }

        public Criteria andRececompanyidNotEqualTo(Integer value) {
            addCriterion("receCompanyId <>", value, "rececompanyid");
            return (Criteria) this;
        }

        public Criteria andRececompanyidGreaterThan(Integer value) {
            addCriterion("receCompanyId >", value, "rececompanyid");
            return (Criteria) this;
        }

        public Criteria andRececompanyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("receCompanyId >=", value, "rececompanyid");
            return (Criteria) this;
        }

        public Criteria andRececompanyidLessThan(Integer value) {
            addCriterion("receCompanyId <", value, "rececompanyid");
            return (Criteria) this;
        }

        public Criteria andRececompanyidLessThanOrEqualTo(Integer value) {
            addCriterion("receCompanyId <=", value, "rececompanyid");
            return (Criteria) this;
        }

        public Criteria andRececompanyidIn(List<Integer> values) {
            addCriterion("receCompanyId in", values, "rececompanyid");
            return (Criteria) this;
        }

        public Criteria andRececompanyidNotIn(List<Integer> values) {
            addCriterion("receCompanyId not in", values, "rececompanyid");
            return (Criteria) this;
        }

        public Criteria andRececompanyidBetween(Integer value1, Integer value2) {
            addCriterion("receCompanyId between", value1, value2, "rececompanyid");
            return (Criteria) this;
        }

        public Criteria andRececompanyidNotBetween(Integer value1, Integer value2) {
            addCriterion("receCompanyId not between", value1, value2, "rececompanyid");
            return (Criteria) this;
        }

        public Criteria andTopicIsNull() {
            addCriterion("topic is null");
            return (Criteria) this;
        }

        public Criteria andTopicIsNotNull() {
            addCriterion("topic is not null");
            return (Criteria) this;
        }

        public Criteria andTopicEqualTo(String value) {
            addCriterion("topic =", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotEqualTo(String value) {
            addCriterion("topic <>", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThan(String value) {
            addCriterion("topic >", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThanOrEqualTo(String value) {
            addCriterion("topic >=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThan(String value) {
            addCriterion("topic <", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThanOrEqualTo(String value) {
            addCriterion("topic <=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLike(String value) {
            addCriterion("topic like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotLike(String value) {
            addCriterion("topic not like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicIn(List<String> values) {
            addCriterion("topic in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotIn(List<String> values) {
            addCriterion("topic not in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicBetween(String value1, String value2) {
            addCriterion("topic between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotBetween(String value1, String value2) {
            addCriterion("topic not between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNull() {
            addCriterion("describe is null");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("describe is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("describe =", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("describe <>", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThan(String value) {
            addCriterion("describe >", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("describe >=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThan(String value) {
            addCriterion("describe <", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThanOrEqualTo(String value) {
            addCriterion("describe <=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLike(String value) {
            addCriterion("describe like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("describe not like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("describe in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("describe not in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("describe between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("describe not between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(Integer value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(Integer value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(Integer value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(Integer value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<Integer> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<Integer> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(Integer value1, Integer value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andMasstypeIsNull() {
            addCriterion("massType is null");
            return (Criteria) this;
        }

        public Criteria andMasstypeIsNotNull() {
            addCriterion("massType is not null");
            return (Criteria) this;
        }

        public Criteria andMasstypeEqualTo(Integer value) {
            addCriterion("massType =", value, "masstype");
            return (Criteria) this;
        }

        public Criteria andMasstypeNotEqualTo(Integer value) {
            addCriterion("massType <>", value, "masstype");
            return (Criteria) this;
        }

        public Criteria andMasstypeGreaterThan(Integer value) {
            addCriterion("massType >", value, "masstype");
            return (Criteria) this;
        }

        public Criteria andMasstypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("massType >=", value, "masstype");
            return (Criteria) this;
        }

        public Criteria andMasstypeLessThan(Integer value) {
            addCriterion("massType <", value, "masstype");
            return (Criteria) this;
        }

        public Criteria andMasstypeLessThanOrEqualTo(Integer value) {
            addCriterion("massType <=", value, "masstype");
            return (Criteria) this;
        }

        public Criteria andMasstypeIn(List<Integer> values) {
            addCriterion("massType in", values, "masstype");
            return (Criteria) this;
        }

        public Criteria andMasstypeNotIn(List<Integer> values) {
            addCriterion("massType not in", values, "masstype");
            return (Criteria) this;
        }

        public Criteria andMasstypeBetween(Integer value1, Integer value2) {
            addCriterion("massType between", value1, value2, "masstype");
            return (Criteria) this;
        }

        public Criteria andMasstypeNotBetween(Integer value1, Integer value2) {
            addCriterion("massType not between", value1, value2, "masstype");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createTime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createTime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andReservetimeIsNull() {
            addCriterion("reserveTime is null");
            return (Criteria) this;
        }

        public Criteria andReservetimeIsNotNull() {
            addCriterion("reserveTime is not null");
            return (Criteria) this;
        }

        public Criteria andReservetimeEqualTo(String value) {
            addCriterion("reserveTime =", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeNotEqualTo(String value) {
            addCriterion("reserveTime <>", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeGreaterThan(String value) {
            addCriterion("reserveTime >", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeGreaterThanOrEqualTo(String value) {
            addCriterion("reserveTime >=", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeLessThan(String value) {
            addCriterion("reserveTime <", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeLessThanOrEqualTo(String value) {
            addCriterion("reserveTime <=", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeLike(String value) {
            addCriterion("reserveTime like", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeNotLike(String value) {
            addCriterion("reserveTime not like", value, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeIn(List<String> values) {
            addCriterion("reserveTime in", values, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeNotIn(List<String> values) {
            addCriterion("reserveTime not in", values, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeBetween(String value1, String value2) {
            addCriterion("reserveTime between", value1, value2, "reservetime");
            return (Criteria) this;
        }

        public Criteria andReservetimeNotBetween(String value1, String value2) {
            addCriterion("reserveTime not between", value1, value2, "reservetime");
            return (Criteria) this;
        }

        public Criteria andSmsconIsNull() {
            addCriterion("smsCon is null");
            return (Criteria) this;
        }

        public Criteria andSmsconIsNotNull() {
            addCriterion("smsCon is not null");
            return (Criteria) this;
        }

        public Criteria andSmsconEqualTo(String value) {
            addCriterion("smsCon =", value, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconNotEqualTo(String value) {
            addCriterion("smsCon <>", value, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconGreaterThan(String value) {
            addCriterion("smsCon >", value, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconGreaterThanOrEqualTo(String value) {
            addCriterion("smsCon >=", value, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconLessThan(String value) {
            addCriterion("smsCon <", value, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconLessThanOrEqualTo(String value) {
            addCriterion("smsCon <=", value, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconLike(String value) {
            addCriterion("smsCon like", value, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconNotLike(String value) {
            addCriterion("smsCon not like", value, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconIn(List<String> values) {
            addCriterion("smsCon in", values, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconNotIn(List<String> values) {
            addCriterion("smsCon not in", values, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconBetween(String value1, String value2) {
            addCriterion("smsCon between", value1, value2, "smscon");
            return (Criteria) this;
        }

        public Criteria andSmsconNotBetween(String value1, String value2) {
            addCriterion("smsCon not between", value1, value2, "smscon");
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