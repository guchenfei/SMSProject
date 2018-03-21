package com.gcf.sms.bean;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserpassIsNull() {
            addCriterion("userPass is null");
            return (Criteria) this;
        }

        public Criteria andUserpassIsNotNull() {
            addCriterion("userPass is not null");
            return (Criteria) this;
        }

        public Criteria andUserpassEqualTo(String value) {
            addCriterion("userPass =", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotEqualTo(String value) {
            addCriterion("userPass <>", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassGreaterThan(String value) {
            addCriterion("userPass >", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassGreaterThanOrEqualTo(String value) {
            addCriterion("userPass >=", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassLessThan(String value) {
            addCriterion("userPass <", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassLessThanOrEqualTo(String value) {
            addCriterion("userPass <=", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassLike(String value) {
            addCriterion("userPass like", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotLike(String value) {
            addCriterion("userPass not like", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassIn(List<String> values) {
            addCriterion("userPass in", values, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotIn(List<String> values) {
            addCriterion("userPass not in", values, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassBetween(String value1, String value2) {
            addCriterion("userPass between", value1, value2, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotBetween(String value1, String value2) {
            addCriterion("userPass not between", value1, value2, "userpass");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNull() {
            addCriterion("userSex is null");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNotNull() {
            addCriterion("userSex is not null");
            return (Criteria) this;
        }

        public Criteria andUsersexEqualTo(Integer value) {
            addCriterion("userSex =", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotEqualTo(Integer value) {
            addCriterion("userSex <>", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThan(Integer value) {
            addCriterion("userSex >", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThanOrEqualTo(Integer value) {
            addCriterion("userSex >=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThan(Integer value) {
            addCriterion("userSex <", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThanOrEqualTo(Integer value) {
            addCriterion("userSex <=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexIn(List<Integer> values) {
            addCriterion("userSex in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotIn(List<Integer> values) {
            addCriterion("userSex not in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexBetween(Integer value1, Integer value2) {
            addCriterion("userSex between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotBetween(Integer value1, Integer value2) {
            addCriterion("userSex not between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayIsNull() {
            addCriterion("userBirthday is null");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayIsNotNull() {
            addCriterion("userBirthday is not null");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayEqualTo(String value) {
            addCriterion("userBirthday =", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayNotEqualTo(String value) {
            addCriterion("userBirthday <>", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayGreaterThan(String value) {
            addCriterion("userBirthday >", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("userBirthday >=", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayLessThan(String value) {
            addCriterion("userBirthday <", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayLessThanOrEqualTo(String value) {
            addCriterion("userBirthday <=", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayLike(String value) {
            addCriterion("userBirthday like", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayNotLike(String value) {
            addCriterion("userBirthday not like", value, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayIn(List<String> values) {
            addCriterion("userBirthday in", values, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayNotIn(List<String> values) {
            addCriterion("userBirthday not in", values, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayBetween(String value1, String value2) {
            addCriterion("userBirthday between", value1, value2, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserbirthdayNotBetween(String value1, String value2) {
            addCriterion("userBirthday not between", value1, value2, "userbirthday");
            return (Criteria) this;
        }

        public Criteria andUserpnumIsNull() {
            addCriterion("userPNum is null");
            return (Criteria) this;
        }

        public Criteria andUserpnumIsNotNull() {
            addCriterion("userPNum is not null");
            return (Criteria) this;
        }

        public Criteria andUserpnumEqualTo(String value) {
            addCriterion("userPNum =", value, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumNotEqualTo(String value) {
            addCriterion("userPNum <>", value, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumGreaterThan(String value) {
            addCriterion("userPNum >", value, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumGreaterThanOrEqualTo(String value) {
            addCriterion("userPNum >=", value, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumLessThan(String value) {
            addCriterion("userPNum <", value, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumLessThanOrEqualTo(String value) {
            addCriterion("userPNum <=", value, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumLike(String value) {
            addCriterion("userPNum like", value, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumNotLike(String value) {
            addCriterion("userPNum not like", value, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumIn(List<String> values) {
            addCriterion("userPNum in", values, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumNotIn(List<String> values) {
            addCriterion("userPNum not in", values, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumBetween(String value1, String value2) {
            addCriterion("userPNum between", value1, value2, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUserpnumNotBetween(String value1, String value2) {
            addCriterion("userPNum not between", value1, value2, "userpnum");
            return (Criteria) this;
        }

        public Criteria andUseraddressIsNull() {
            addCriterion("userAddress is null");
            return (Criteria) this;
        }

        public Criteria andUseraddressIsNotNull() {
            addCriterion("userAddress is not null");
            return (Criteria) this;
        }

        public Criteria andUseraddressEqualTo(String value) {
            addCriterion("userAddress =", value, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressNotEqualTo(String value) {
            addCriterion("userAddress <>", value, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressGreaterThan(String value) {
            addCriterion("userAddress >", value, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressGreaterThanOrEqualTo(String value) {
            addCriterion("userAddress >=", value, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressLessThan(String value) {
            addCriterion("userAddress <", value, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressLessThanOrEqualTo(String value) {
            addCriterion("userAddress <=", value, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressLike(String value) {
            addCriterion("userAddress like", value, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressNotLike(String value) {
            addCriterion("userAddress not like", value, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressIn(List<String> values) {
            addCriterion("userAddress in", values, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressNotIn(List<String> values) {
            addCriterion("userAddress not in", values, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressBetween(String value1, String value2) {
            addCriterion("userAddress between", value1, value2, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseraddressNotBetween(String value1, String value2) {
            addCriterion("userAddress not between", value1, value2, "useraddress");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNull() {
            addCriterion("userEmail is null");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNotNull() {
            addCriterion("userEmail is not null");
            return (Criteria) this;
        }

        public Criteria andUseremailEqualTo(String value) {
            addCriterion("userEmail =", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotEqualTo(String value) {
            addCriterion("userEmail <>", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThan(String value) {
            addCriterion("userEmail >", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThanOrEqualTo(String value) {
            addCriterion("userEmail >=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThan(String value) {
            addCriterion("userEmail <", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThanOrEqualTo(String value) {
            addCriterion("userEmail <=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLike(String value) {
            addCriterion("userEmail like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotLike(String value) {
            addCriterion("userEmail not like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailIn(List<String> values) {
            addCriterion("userEmail in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotIn(List<String> values) {
            addCriterion("userEmail not in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailBetween(String value1, String value2) {
            addCriterion("userEmail between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotBetween(String value1, String value2) {
            addCriterion("userEmail not between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("userType is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("userType is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Integer value) {
            addCriterion("userType =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Integer value) {
            addCriterion("userType <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Integer value) {
            addCriterion("userType >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("userType >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Integer value) {
            addCriterion("userType <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Integer value) {
            addCriterion("userType <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Integer> values) {
            addCriterion("userType in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Integer> values) {
            addCriterion("userType not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Integer value1, Integer value2) {
            addCriterion("userType between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("userType not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andCpyIdIsNull() {
            addCriterion("cpy_id is null");
            return (Criteria) this;
        }

        public Criteria andCpyIdIsNotNull() {
            addCriterion("cpy_id is not null");
            return (Criteria) this;
        }

        public Criteria andCpyIdEqualTo(Integer value) {
            addCriterion("cpy_id =", value, "cpyId");
            return (Criteria) this;
        }

        public Criteria andCpyIdNotEqualTo(Integer value) {
            addCriterion("cpy_id <>", value, "cpyId");
            return (Criteria) this;
        }

        public Criteria andCpyIdGreaterThan(Integer value) {
            addCriterion("cpy_id >", value, "cpyId");
            return (Criteria) this;
        }

        public Criteria andCpyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpy_id >=", value, "cpyId");
            return (Criteria) this;
        }

        public Criteria andCpyIdLessThan(Integer value) {
            addCriterion("cpy_id <", value, "cpyId");
            return (Criteria) this;
        }

        public Criteria andCpyIdLessThanOrEqualTo(Integer value) {
            addCriterion("cpy_id <=", value, "cpyId");
            return (Criteria) this;
        }

        public Criteria andCpyIdIn(List<Integer> values) {
            addCriterion("cpy_id in", values, "cpyId");
            return (Criteria) this;
        }

        public Criteria andCpyIdNotIn(List<Integer> values) {
            addCriterion("cpy_id not in", values, "cpyId");
            return (Criteria) this;
        }

        public Criteria andCpyIdBetween(Integer value1, Integer value2) {
            addCriterion("cpy_id between", value1, value2, "cpyId");
            return (Criteria) this;
        }

        public Criteria andCpyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cpy_id not between", value1, value2, "cpyId");
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