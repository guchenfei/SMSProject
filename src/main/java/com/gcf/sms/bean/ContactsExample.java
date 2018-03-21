package com.gcf.sms.bean;

import java.util.ArrayList;
import java.util.List;

public class ContactsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContactsExample() {
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

        public Criteria andContactIdIsNull() {
            addCriterion("contact_id is null");
            return (Criteria) this;
        }

        public Criteria andContactIdIsNotNull() {
            addCriterion("contact_id is not null");
            return (Criteria) this;
        }

        public Criteria andContactIdEqualTo(Integer value) {
            addCriterion("contact_id =", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotEqualTo(Integer value) {
            addCriterion("contact_id <>", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdGreaterThan(Integer value) {
            addCriterion("contact_id >", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contact_id >=", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdLessThan(Integer value) {
            addCriterion("contact_id <", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdLessThanOrEqualTo(Integer value) {
            addCriterion("contact_id <=", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdIn(List<Integer> values) {
            addCriterion("contact_id in", values, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotIn(List<Integer> values) {
            addCriterion("contact_id not in", values, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdBetween(Integer value1, Integer value2) {
            addCriterion("contact_id between", value1, value2, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contact_id not between", value1, value2, "contactId");
            return (Criteria) this;
        }

        public Criteria andConnameIsNull() {
            addCriterion("conName is null");
            return (Criteria) this;
        }

        public Criteria andConnameIsNotNull() {
            addCriterion("conName is not null");
            return (Criteria) this;
        }

        public Criteria andConnameEqualTo(String value) {
            addCriterion("conName =", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotEqualTo(String value) {
            addCriterion("conName <>", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameGreaterThan(String value) {
            addCriterion("conName >", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameGreaterThanOrEqualTo(String value) {
            addCriterion("conName >=", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLessThan(String value) {
            addCriterion("conName <", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLessThanOrEqualTo(String value) {
            addCriterion("conName <=", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLike(String value) {
            addCriterion("conName like", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotLike(String value) {
            addCriterion("conName not like", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameIn(List<String> values) {
            addCriterion("conName in", values, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotIn(List<String> values) {
            addCriterion("conName not in", values, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameBetween(String value1, String value2) {
            addCriterion("conName between", value1, value2, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotBetween(String value1, String value2) {
            addCriterion("conName not between", value1, value2, "conname");
            return (Criteria) this;
        }

        public Criteria andConsexIsNull() {
            addCriterion("conSex is null");
            return (Criteria) this;
        }

        public Criteria andConsexIsNotNull() {
            addCriterion("conSex is not null");
            return (Criteria) this;
        }

        public Criteria andConsexEqualTo(Integer value) {
            addCriterion("conSex =", value, "consex");
            return (Criteria) this;
        }

        public Criteria andConsexNotEqualTo(Integer value) {
            addCriterion("conSex <>", value, "consex");
            return (Criteria) this;
        }

        public Criteria andConsexGreaterThan(Integer value) {
            addCriterion("conSex >", value, "consex");
            return (Criteria) this;
        }

        public Criteria andConsexGreaterThanOrEqualTo(Integer value) {
            addCriterion("conSex >=", value, "consex");
            return (Criteria) this;
        }

        public Criteria andConsexLessThan(Integer value) {
            addCriterion("conSex <", value, "consex");
            return (Criteria) this;
        }

        public Criteria andConsexLessThanOrEqualTo(Integer value) {
            addCriterion("conSex <=", value, "consex");
            return (Criteria) this;
        }

        public Criteria andConsexIn(List<Integer> values) {
            addCriterion("conSex in", values, "consex");
            return (Criteria) this;
        }

        public Criteria andConsexNotIn(List<Integer> values) {
            addCriterion("conSex not in", values, "consex");
            return (Criteria) this;
        }

        public Criteria andConsexBetween(Integer value1, Integer value2) {
            addCriterion("conSex between", value1, value2, "consex");
            return (Criteria) this;
        }

        public Criteria andConsexNotBetween(Integer value1, Integer value2) {
            addCriterion("conSex not between", value1, value2, "consex");
            return (Criteria) this;
        }

        public Criteria andConbirthdayIsNull() {
            addCriterion("conBirthday is null");
            return (Criteria) this;
        }

        public Criteria andConbirthdayIsNotNull() {
            addCriterion("conBirthday is not null");
            return (Criteria) this;
        }

        public Criteria andConbirthdayEqualTo(String value) {
            addCriterion("conBirthday =", value, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayNotEqualTo(String value) {
            addCriterion("conBirthday <>", value, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayGreaterThan(String value) {
            addCriterion("conBirthday >", value, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("conBirthday >=", value, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayLessThan(String value) {
            addCriterion("conBirthday <", value, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayLessThanOrEqualTo(String value) {
            addCriterion("conBirthday <=", value, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayLike(String value) {
            addCriterion("conBirthday like", value, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayNotLike(String value) {
            addCriterion("conBirthday not like", value, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayIn(List<String> values) {
            addCriterion("conBirthday in", values, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayNotIn(List<String> values) {
            addCriterion("conBirthday not in", values, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayBetween(String value1, String value2) {
            addCriterion("conBirthday between", value1, value2, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConbirthdayNotBetween(String value1, String value2) {
            addCriterion("conBirthday not between", value1, value2, "conbirthday");
            return (Criteria) this;
        }

        public Criteria andConphonenumIsNull() {
            addCriterion("conPhoneNum is null");
            return (Criteria) this;
        }

        public Criteria andConphonenumIsNotNull() {
            addCriterion("conPhoneNum is not null");
            return (Criteria) this;
        }

        public Criteria andConphonenumEqualTo(String value) {
            addCriterion("conPhoneNum =", value, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumNotEqualTo(String value) {
            addCriterion("conPhoneNum <>", value, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumGreaterThan(String value) {
            addCriterion("conPhoneNum >", value, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumGreaterThanOrEqualTo(String value) {
            addCriterion("conPhoneNum >=", value, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumLessThan(String value) {
            addCriterion("conPhoneNum <", value, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumLessThanOrEqualTo(String value) {
            addCriterion("conPhoneNum <=", value, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumLike(String value) {
            addCriterion("conPhoneNum like", value, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumNotLike(String value) {
            addCriterion("conPhoneNum not like", value, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumIn(List<String> values) {
            addCriterion("conPhoneNum in", values, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumNotIn(List<String> values) {
            addCriterion("conPhoneNum not in", values, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumBetween(String value1, String value2) {
            addCriterion("conPhoneNum between", value1, value2, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConphonenumNotBetween(String value1, String value2) {
            addCriterion("conPhoneNum not between", value1, value2, "conphonenum");
            return (Criteria) this;
        }

        public Criteria andConaddressIsNull() {
            addCriterion("conAddress is null");
            return (Criteria) this;
        }

        public Criteria andConaddressIsNotNull() {
            addCriterion("conAddress is not null");
            return (Criteria) this;
        }

        public Criteria andConaddressEqualTo(String value) {
            addCriterion("conAddress =", value, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressNotEqualTo(String value) {
            addCriterion("conAddress <>", value, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressGreaterThan(String value) {
            addCriterion("conAddress >", value, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressGreaterThanOrEqualTo(String value) {
            addCriterion("conAddress >=", value, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressLessThan(String value) {
            addCriterion("conAddress <", value, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressLessThanOrEqualTo(String value) {
            addCriterion("conAddress <=", value, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressLike(String value) {
            addCriterion("conAddress like", value, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressNotLike(String value) {
            addCriterion("conAddress not like", value, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressIn(List<String> values) {
            addCriterion("conAddress in", values, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressNotIn(List<String> values) {
            addCriterion("conAddress not in", values, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressBetween(String value1, String value2) {
            addCriterion("conAddress between", value1, value2, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConaddressNotBetween(String value1, String value2) {
            addCriterion("conAddress not between", value1, value2, "conaddress");
            return (Criteria) this;
        }

        public Criteria andConemailIsNull() {
            addCriterion("conEmail is null");
            return (Criteria) this;
        }

        public Criteria andConemailIsNotNull() {
            addCriterion("conEmail is not null");
            return (Criteria) this;
        }

        public Criteria andConemailEqualTo(String value) {
            addCriterion("conEmail =", value, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailNotEqualTo(String value) {
            addCriterion("conEmail <>", value, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailGreaterThan(String value) {
            addCriterion("conEmail >", value, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailGreaterThanOrEqualTo(String value) {
            addCriterion("conEmail >=", value, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailLessThan(String value) {
            addCriterion("conEmail <", value, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailLessThanOrEqualTo(String value) {
            addCriterion("conEmail <=", value, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailLike(String value) {
            addCriterion("conEmail like", value, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailNotLike(String value) {
            addCriterion("conEmail not like", value, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailIn(List<String> values) {
            addCriterion("conEmail in", values, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailNotIn(List<String> values) {
            addCriterion("conEmail not in", values, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailBetween(String value1, String value2) {
            addCriterion("conEmail between", value1, value2, "conemail");
            return (Criteria) this;
        }

        public Criteria andConemailNotBetween(String value1, String value2) {
            addCriterion("conEmail not between", value1, value2, "conemail");
            return (Criteria) this;
        }

        public Criteria andConcompanyIsNull() {
            addCriterion("conCompany is null");
            return (Criteria) this;
        }

        public Criteria andConcompanyIsNotNull() {
            addCriterion("conCompany is not null");
            return (Criteria) this;
        }

        public Criteria andConcompanyEqualTo(Integer value) {
            addCriterion("conCompany =", value, "concompany");
            return (Criteria) this;
        }

        public Criteria andConcompanyNotEqualTo(Integer value) {
            addCriterion("conCompany <>", value, "concompany");
            return (Criteria) this;
        }

        public Criteria andConcompanyGreaterThan(Integer value) {
            addCriterion("conCompany >", value, "concompany");
            return (Criteria) this;
        }

        public Criteria andConcompanyGreaterThanOrEqualTo(Integer value) {
            addCriterion("conCompany >=", value, "concompany");
            return (Criteria) this;
        }

        public Criteria andConcompanyLessThan(Integer value) {
            addCriterion("conCompany <", value, "concompany");
            return (Criteria) this;
        }

        public Criteria andConcompanyLessThanOrEqualTo(Integer value) {
            addCriterion("conCompany <=", value, "concompany");
            return (Criteria) this;
        }

        public Criteria andConcompanyIn(List<Integer> values) {
            addCriterion("conCompany in", values, "concompany");
            return (Criteria) this;
        }

        public Criteria andConcompanyNotIn(List<Integer> values) {
            addCriterion("conCompany not in", values, "concompany");
            return (Criteria) this;
        }

        public Criteria andConcompanyBetween(Integer value1, Integer value2) {
            addCriterion("conCompany between", value1, value2, "concompany");
            return (Criteria) this;
        }

        public Criteria andConcompanyNotBetween(Integer value1, Integer value2) {
            addCriterion("conCompany not between", value1, value2, "concompany");
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