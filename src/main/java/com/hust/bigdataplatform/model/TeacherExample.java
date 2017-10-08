package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(String value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(String value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(String value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(String value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLike(String value) {
            addCriterion("teacher_id like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotLike(String value) {
            addCriterion("teacher_id not like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<String> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<String> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(String value1, String value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(String value1, String value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdIsNull() {
            addCriterion("teacher_pwd is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdIsNotNull() {
            addCriterion("teacher_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdEqualTo(String value) {
            addCriterion("teacher_pwd =", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdNotEqualTo(String value) {
            addCriterion("teacher_pwd <>", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdGreaterThan(String value) {
            addCriterion("teacher_pwd >", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_pwd >=", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdLessThan(String value) {
            addCriterion("teacher_pwd <", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdLessThanOrEqualTo(String value) {
            addCriterion("teacher_pwd <=", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdLike(String value) {
            addCriterion("teacher_pwd like", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdNotLike(String value) {
            addCriterion("teacher_pwd not like", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdIn(List<String> values) {
            addCriterion("teacher_pwd in", values, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdNotIn(List<String> values) {
            addCriterion("teacher_pwd not in", values, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdBetween(String value1, String value2) {
            addCriterion("teacher_pwd between", value1, value2, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdNotBetween(String value1, String value2) {
            addCriterion("teacher_pwd not between", value1, value2, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNull() {
            addCriterion("teacher_phone is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNotNull() {
            addCriterion("teacher_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneEqualTo(String value) {
            addCriterion("teacher_phone =", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotEqualTo(String value) {
            addCriterion("teacher_phone <>", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThan(String value) {
            addCriterion("teacher_phone >", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_phone >=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThan(String value) {
            addCriterion("teacher_phone <", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThanOrEqualTo(String value) {
            addCriterion("teacher_phone <=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLike(String value) {
            addCriterion("teacher_phone like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotLike(String value) {
            addCriterion("teacher_phone not like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIn(List<String> values) {
            addCriterion("teacher_phone in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotIn(List<String> values) {
            addCriterion("teacher_phone not in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneBetween(String value1, String value2) {
            addCriterion("teacher_phone between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotBetween(String value1, String value2) {
            addCriterion("teacher_phone not between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathIsNull() {
            addCriterion("techer_picturePath is null");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathIsNotNull() {
            addCriterion("techer_picturePath is not null");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathEqualTo(String value) {
            addCriterion("techer_picturePath =", value, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathNotEqualTo(String value) {
            addCriterion("techer_picturePath <>", value, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathGreaterThan(String value) {
            addCriterion("techer_picturePath >", value, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathGreaterThanOrEqualTo(String value) {
            addCriterion("techer_picturePath >=", value, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathLessThan(String value) {
            addCriterion("techer_picturePath <", value, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathLessThanOrEqualTo(String value) {
            addCriterion("techer_picturePath <=", value, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathLike(String value) {
            addCriterion("techer_picturePath like", value, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathNotLike(String value) {
            addCriterion("techer_picturePath not like", value, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathIn(List<String> values) {
            addCriterion("techer_picturePath in", values, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathNotIn(List<String> values) {
            addCriterion("techer_picturePath not in", values, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathBetween(String value1, String value2) {
            addCriterion("techer_picturePath between", value1, value2, "techerPicturepath");
            return (Criteria) this;
        }

        public Criteria andTecherPicturepathNotBetween(String value1, String value2) {
            addCriterion("techer_picturePath not between", value1, value2, "techerPicturepath");
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
        public Criterion(){
        	super();
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