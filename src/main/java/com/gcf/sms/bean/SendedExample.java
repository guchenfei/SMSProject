package com.gcf.sms.bean;

import java.util.ArrayList;
import java.util.List;

public class SendedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SendedExample() {
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

        public Criteria andAdIdIsNull() {
            addCriterion("ad_id is null");
            return (Criteria) this;
        }

        public Criteria andAdIdIsNotNull() {
            addCriterion("ad_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdIdEqualTo(Integer value) {
            addCriterion("ad_id =", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotEqualTo(Integer value) {
            addCriterion("ad_id <>", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThan(Integer value) {
            addCriterion("ad_id >", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_id >=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThan(Integer value) {
            addCriterion("ad_id <", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThanOrEqualTo(Integer value) {
            addCriterion("ad_id <=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdIn(List<Integer> values) {
            addCriterion("ad_id in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotIn(List<Integer> values) {
            addCriterion("ad_id not in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdBetween(Integer value1, Integer value2) {
            addCriterion("ad_id between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_id not between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andReceivephoneIsNull() {
            addCriterion("receivePhone is null");
            return (Criteria) this;
        }

        public Criteria andReceivephoneIsNotNull() {
            addCriterion("receivePhone is not null");
            return (Criteria) this;
        }

        public Criteria andReceivephoneEqualTo(String value) {
            addCriterion("receivePhone =", value, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneNotEqualTo(String value) {
            addCriterion("receivePhone <>", value, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneGreaterThan(String value) {
            addCriterion("receivePhone >", value, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneGreaterThanOrEqualTo(String value) {
            addCriterion("receivePhone >=", value, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneLessThan(String value) {
            addCriterion("receivePhone <", value, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneLessThanOrEqualTo(String value) {
            addCriterion("receivePhone <=", value, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneLike(String value) {
            addCriterion("receivePhone like", value, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneNotLike(String value) {
            addCriterion("receivePhone not like", value, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneIn(List<String> values) {
            addCriterion("receivePhone in", values, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneNotIn(List<String> values) {
            addCriterion("receivePhone not in", values, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneBetween(String value1, String value2) {
            addCriterion("receivePhone between", value1, value2, "receivephone");
            return (Criteria) this;
        }

        public Criteria andReceivephoneNotBetween(String value1, String value2) {
            addCriterion("receivePhone not between", value1, value2, "receivephone");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusIsNull() {
            addCriterion("deliveryStatus is null");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusIsNotNull() {
            addCriterion("deliveryStatus is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusEqualTo(Integer value) {
            addCriterion("deliveryStatus =", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusNotEqualTo(Integer value) {
            addCriterion("deliveryStatus <>", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusGreaterThan(Integer value) {
            addCriterion("deliveryStatus >", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("deliveryStatus >=", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusLessThan(Integer value) {
            addCriterion("deliveryStatus <", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusLessThanOrEqualTo(Integer value) {
            addCriterion("deliveryStatus <=", value, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusIn(List<Integer> values) {
            addCriterion("deliveryStatus in", values, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusNotIn(List<Integer> values) {
            addCriterion("deliveryStatus not in", values, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusBetween(Integer value1, Integer value2) {
            addCriterion("deliveryStatus between", value1, value2, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andDeliverystatusNotBetween(Integer value1, Integer value2) {
            addCriterion("deliveryStatus not between", value1, value2, "deliverystatus");
            return (Criteria) this;
        }

        public Criteria andErrorinfoIsNull() {
            addCriterion("errorInfo is null");
            return (Criteria) this;
        }

        public Criteria andErrorinfoIsNotNull() {
            addCriterion("errorInfo is not null");
            return (Criteria) this;
        }

        public Criteria andErrorinfoEqualTo(String value) {
            addCriterion("errorInfo =", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotEqualTo(String value) {
            addCriterion("errorInfo <>", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoGreaterThan(String value) {
            addCriterion("errorInfo >", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoGreaterThanOrEqualTo(String value) {
            addCriterion("errorInfo >=", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoLessThan(String value) {
            addCriterion("errorInfo <", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoLessThanOrEqualTo(String value) {
            addCriterion("errorInfo <=", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoLike(String value) {
            addCriterion("errorInfo like", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotLike(String value) {
            addCriterion("errorInfo not like", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoIn(List<String> values) {
            addCriterion("errorInfo in", values, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotIn(List<String> values) {
            addCriterion("errorInfo not in", values, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoBetween(String value1, String value2) {
            addCriterion("errorInfo between", value1, value2, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotBetween(String value1, String value2) {
            addCriterion("errorInfo not between", value1, value2, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andSmscontentIsNull() {
            addCriterion("smsContent is null");
            return (Criteria) this;
        }

        public Criteria andSmscontentIsNotNull() {
            addCriterion("smsContent is not null");
            return (Criteria) this;
        }

        public Criteria andSmscontentEqualTo(String value) {
            addCriterion("smsContent =", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentNotEqualTo(String value) {
            addCriterion("smsContent <>", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentGreaterThan(String value) {
            addCriterion("smsContent >", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentGreaterThanOrEqualTo(String value) {
            addCriterion("smsContent >=", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentLessThan(String value) {
            addCriterion("smsContent <", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentLessThanOrEqualTo(String value) {
            addCriterion("smsContent <=", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentLike(String value) {
            addCriterion("smsContent like", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentNotLike(String value) {
            addCriterion("smsContent not like", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentIn(List<String> values) {
            addCriterion("smsContent in", values, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentNotIn(List<String> values) {
            addCriterion("smsContent not in", values, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentBetween(String value1, String value2) {
            addCriterion("smsContent between", value1, value2, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentNotBetween(String value1, String value2) {
            addCriterion("smsContent not between", value1, value2, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendTime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendTime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(String value) {
            addCriterion("sendTime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(String value) {
            addCriterion("sendTime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(String value) {
            addCriterion("sendTime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("sendTime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(String value) {
            addCriterion("sendTime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(String value) {
            addCriterion("sendTime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLike(String value) {
            addCriterion("sendTime like", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotLike(String value) {
            addCriterion("sendTime not like", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<String> values) {
            addCriterion("sendTime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<String> values) {
            addCriterion("sendTime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(String value1, String value2) {
            addCriterion("sendTime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(String value1, String value2) {
            addCriterion("sendTime not between", value1, value2, "sendtime");
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