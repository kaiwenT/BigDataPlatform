package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("student_id like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("student_id not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNull() {
            addCriterion("student_name is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNotNull() {
            addCriterion("student_name is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String value) {
            addCriterion("student_name =", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotEqualTo(String value) {
            addCriterion("student_name <>", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThan(String value) {
            addCriterion("student_name >", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("student_name >=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThan(String value) {
            addCriterion("student_name <", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThanOrEqualTo(String value) {
            addCriterion("student_name <=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String value) {
            addCriterion("student_name like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotLike(String value) {
            addCriterion("student_name not like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIn(List<String> values) {
            addCriterion("student_name in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotIn(List<String> values) {
            addCriterion("student_name not in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameBetween(String value1, String value2) {
            addCriterion("student_name between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotBetween(String value1, String value2) {
            addCriterion("student_name not between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentPwdIsNull() {
            addCriterion("student_pwd is null");
            return (Criteria) this;
        }

        public Criteria andStudentPwdIsNotNull() {
            addCriterion("student_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andStudentPwdEqualTo(String value) {
            addCriterion("student_pwd =", value, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdNotEqualTo(String value) {
            addCriterion("student_pwd <>", value, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdGreaterThan(String value) {
            addCriterion("student_pwd >", value, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdGreaterThanOrEqualTo(String value) {
            addCriterion("student_pwd >=", value, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdLessThan(String value) {
            addCriterion("student_pwd <", value, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdLessThanOrEqualTo(String value) {
            addCriterion("student_pwd <=", value, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdLike(String value) {
            addCriterion("student_pwd like", value, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdNotLike(String value) {
            addCriterion("student_pwd not like", value, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdIn(List<String> values) {
            addCriterion("student_pwd in", values, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdNotIn(List<String> values) {
            addCriterion("student_pwd not in", values, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdBetween(String value1, String value2) {
            addCriterion("student_pwd between", value1, value2, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentPwdNotBetween(String value1, String value2) {
            addCriterion("student_pwd not between", value1, value2, "studentPwd");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyIsNull() {
            addCriterion("student_faculty is null");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyIsNotNull() {
            addCriterion("student_faculty is not null");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyEqualTo(String value) {
            addCriterion("student_faculty =", value, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyNotEqualTo(String value) {
            addCriterion("student_faculty <>", value, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyGreaterThan(String value) {
            addCriterion("student_faculty >", value, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyGreaterThanOrEqualTo(String value) {
            addCriterion("student_faculty >=", value, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyLessThan(String value) {
            addCriterion("student_faculty <", value, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyLessThanOrEqualTo(String value) {
            addCriterion("student_faculty <=", value, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyLike(String value) {
            addCriterion("student_faculty like", value, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyNotLike(String value) {
            addCriterion("student_faculty not like", value, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyIn(List<String> values) {
            addCriterion("student_faculty in", values, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyNotIn(List<String> values) {
            addCriterion("student_faculty not in", values, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyBetween(String value1, String value2) {
            addCriterion("student_faculty between", value1, value2, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentFacultyNotBetween(String value1, String value2) {
            addCriterion("student_faculty not between", value1, value2, "studentFaculty");
            return (Criteria) this;
        }

        public Criteria andStudentTeleIsNull() {
            addCriterion("student_tele is null");
            return (Criteria) this;
        }

        public Criteria andStudentTeleIsNotNull() {
            addCriterion("student_tele is not null");
            return (Criteria) this;
        }

        public Criteria andStudentTeleEqualTo(String value) {
            addCriterion("student_tele =", value, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleNotEqualTo(String value) {
            addCriterion("student_tele <>", value, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleGreaterThan(String value) {
            addCriterion("student_tele >", value, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleGreaterThanOrEqualTo(String value) {
            addCriterion("student_tele >=", value, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleLessThan(String value) {
            addCriterion("student_tele <", value, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleLessThanOrEqualTo(String value) {
            addCriterion("student_tele <=", value, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleLike(String value) {
            addCriterion("student_tele like", value, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleNotLike(String value) {
            addCriterion("student_tele not like", value, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleIn(List<String> values) {
            addCriterion("student_tele in", values, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleNotIn(List<String> values) {
            addCriterion("student_tele not in", values, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleBetween(String value1, String value2) {
            addCriterion("student_tele between", value1, value2, "studentTele");
            return (Criteria) this;
        }

        public Criteria andStudentTeleNotBetween(String value1, String value2) {
            addCriterion("student_tele not between", value1, value2, "studentTele");
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