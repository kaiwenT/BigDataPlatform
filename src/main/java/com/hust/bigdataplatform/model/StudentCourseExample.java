package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.List;

public class StudentCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentCourseExample() {
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("course_id like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("course_id not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidIsNull() {
            addCriterion("student_groupId is null");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidIsNotNull() {
            addCriterion("student_groupId is not null");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidEqualTo(String value) {
            addCriterion("student_groupId =", value, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidNotEqualTo(String value) {
            addCriterion("student_groupId <>", value, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidGreaterThan(String value) {
            addCriterion("student_groupId >", value, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidGreaterThanOrEqualTo(String value) {
            addCriterion("student_groupId >=", value, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidLessThan(String value) {
            addCriterion("student_groupId <", value, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidLessThanOrEqualTo(String value) {
            addCriterion("student_groupId <=", value, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidLike(String value) {
            addCriterion("student_groupId like", value, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidNotLike(String value) {
            addCriterion("student_groupId not like", value, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidIn(List<String> values) {
            addCriterion("student_groupId in", values, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidNotIn(List<String> values) {
            addCriterion("student_groupId not in", values, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidBetween(String value1, String value2) {
            addCriterion("student_groupId between", value1, value2, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andStudentGroupidNotBetween(String value1, String value2) {
            addCriterion("student_groupId not between", value1, value2, "studentGroupid");
            return (Criteria) this;
        }

        public Criteria andAttendancerateIsNull() {
            addCriterion("attendanceRate is null");
            return (Criteria) this;
        }

        public Criteria andAttendancerateIsNotNull() {
            addCriterion("attendanceRate is not null");
            return (Criteria) this;
        }

        public Criteria andAttendancerateEqualTo(Integer value) {
            addCriterion("attendanceRate =", value, "attendancerate");
            return (Criteria) this;
        }

        public Criteria andAttendancerateNotEqualTo(Integer value) {
            addCriterion("attendanceRate <>", value, "attendancerate");
            return (Criteria) this;
        }

        public Criteria andAttendancerateGreaterThan(Integer value) {
            addCriterion("attendanceRate >", value, "attendancerate");
            return (Criteria) this;
        }

        public Criteria andAttendancerateGreaterThanOrEqualTo(Integer value) {
            addCriterion("attendanceRate >=", value, "attendancerate");
            return (Criteria) this;
        }

        public Criteria andAttendancerateLessThan(Integer value) {
            addCriterion("attendanceRate <", value, "attendancerate");
            return (Criteria) this;
        }

        public Criteria andAttendancerateLessThanOrEqualTo(Integer value) {
            addCriterion("attendanceRate <=", value, "attendancerate");
            return (Criteria) this;
        }

        public Criteria andAttendancerateIn(List<Integer> values) {
            addCriterion("attendanceRate in", values, "attendancerate");
            return (Criteria) this;
        }

        public Criteria andAttendancerateNotIn(List<Integer> values) {
            addCriterion("attendanceRate not in", values, "attendancerate");
            return (Criteria) this;
        }

        public Criteria andAttendancerateBetween(Integer value1, Integer value2) {
            addCriterion("attendanceRate between", value1, value2, "attendancerate");
            return (Criteria) this;
        }

        public Criteria andAttendancerateNotBetween(Integer value1, Integer value2) {
            addCriterion("attendanceRate not between", value1, value2, "attendancerate");
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
		
		public Criterion(){
        	super();
        }

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