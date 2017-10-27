package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.List;

public class CourseScaleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseScaleExample() {
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

        public Criteria andAttendanceRateIsNull() {
            addCriterion("attendance_rate is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateIsNotNull() {
            addCriterion("attendance_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateEqualTo(Float value) {
            addCriterion("attendance_rate =", value, "attendanceRate");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateNotEqualTo(Float value) {
            addCriterion("attendance_rate <>", value, "attendanceRate");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateGreaterThan(Float value) {
            addCriterion("attendance_rate >", value, "attendanceRate");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateGreaterThanOrEqualTo(Float value) {
            addCriterion("attendance_rate >=", value, "attendanceRate");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateLessThan(Float value) {
            addCriterion("attendance_rate <", value, "attendanceRate");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateLessThanOrEqualTo(Float value) {
            addCriterion("attendance_rate <=", value, "attendanceRate");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateIn(List<Float> values) {
            addCriterion("attendance_rate in", values, "attendanceRate");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateNotIn(List<Float> values) {
            addCriterion("attendance_rate not in", values, "attendanceRate");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateBetween(Float value1, Float value2) {
            addCriterion("attendance_rate between", value1, value2, "attendanceRate");
            return (Criteria) this;
        }

        public Criteria andAttendanceRateNotBetween(Float value1, Float value2) {
            addCriterion("attendance_rate not between", value1, value2, "attendanceRate");
            return (Criteria) this;
        }

        public Criteria andExerciseRateIsNull() {
            addCriterion("exercise_rate is null");
            return (Criteria) this;
        }

        public Criteria andExerciseRateIsNotNull() {
            addCriterion("exercise_rate is not null");
            return (Criteria) this;
        }

        public Criteria andExerciseRateEqualTo(Float value) {
            addCriterion("exercise_rate =", value, "exerciseRate");
            return (Criteria) this;
        }

        public Criteria andExerciseRateNotEqualTo(Float value) {
            addCriterion("exercise_rate <>", value, "exerciseRate");
            return (Criteria) this;
        }

        public Criteria andExerciseRateGreaterThan(Float value) {
            addCriterion("exercise_rate >", value, "exerciseRate");
            return (Criteria) this;
        }

        public Criteria andExerciseRateGreaterThanOrEqualTo(Float value) {
            addCriterion("exercise_rate >=", value, "exerciseRate");
            return (Criteria) this;
        }

        public Criteria andExerciseRateLessThan(Float value) {
            addCriterion("exercise_rate <", value, "exerciseRate");
            return (Criteria) this;
        }

        public Criteria andExerciseRateLessThanOrEqualTo(Float value) {
            addCriterion("exercise_rate <=", value, "exerciseRate");
            return (Criteria) this;
        }

        public Criteria andExerciseRateIn(List<Float> values) {
            addCriterion("exercise_rate in", values, "exerciseRate");
            return (Criteria) this;
        }

        public Criteria andExerciseRateNotIn(List<Float> values) {
            addCriterion("exercise_rate not in", values, "exerciseRate");
            return (Criteria) this;
        }

        public Criteria andExerciseRateBetween(Float value1, Float value2) {
            addCriterion("exercise_rate between", value1, value2, "exerciseRate");
            return (Criteria) this;
        }

        public Criteria andExerciseRateNotBetween(Float value1, Float value2) {
            addCriterion("exercise_rate not between", value1, value2, "exerciseRate");
            return (Criteria) this;
        }

        public Criteria andExperimentRateIsNull() {
            addCriterion("experiment_rate is null");
            return (Criteria) this;
        }

        public Criteria andExperimentRateIsNotNull() {
            addCriterion("experiment_rate is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentRateEqualTo(Float value) {
            addCriterion("experiment_rate =", value, "experimentRate");
            return (Criteria) this;
        }

        public Criteria andExperimentRateNotEqualTo(Float value) {
            addCriterion("experiment_rate <>", value, "experimentRate");
            return (Criteria) this;
        }

        public Criteria andExperimentRateGreaterThan(Float value) {
            addCriterion("experiment_rate >", value, "experimentRate");
            return (Criteria) this;
        }

        public Criteria andExperimentRateGreaterThanOrEqualTo(Float value) {
            addCriterion("experiment_rate >=", value, "experimentRate");
            return (Criteria) this;
        }

        public Criteria andExperimentRateLessThan(Float value) {
            addCriterion("experiment_rate <", value, "experimentRate");
            return (Criteria) this;
        }

        public Criteria andExperimentRateLessThanOrEqualTo(Float value) {
            addCriterion("experiment_rate <=", value, "experimentRate");
            return (Criteria) this;
        }

        public Criteria andExperimentRateIn(List<Float> values) {
            addCriterion("experiment_rate in", values, "experimentRate");
            return (Criteria) this;
        }

        public Criteria andExperimentRateNotIn(List<Float> values) {
            addCriterion("experiment_rate not in", values, "experimentRate");
            return (Criteria) this;
        }

        public Criteria andExperimentRateBetween(Float value1, Float value2) {
            addCriterion("experiment_rate between", value1, value2, "experimentRate");
            return (Criteria) this;
        }

        public Criteria andExperimentRateNotBetween(Float value1, Float value2) {
            addCriterion("experiment_rate not between", value1, value2, "experimentRate");
            return (Criteria) this;
        }

        public Criteria andExpReportRateIsNull() {
            addCriterion("exp_report_rate is null");
            return (Criteria) this;
        }

        public Criteria andExpReportRateIsNotNull() {
            addCriterion("exp_report_rate is not null");
            return (Criteria) this;
        }

        public Criteria andExpReportRateEqualTo(Float value) {
            addCriterion("exp_report_rate =", value, "expReportRate");
            return (Criteria) this;
        }

        public Criteria andExpReportRateNotEqualTo(Float value) {
            addCriterion("exp_report_rate <>", value, "expReportRate");
            return (Criteria) this;
        }

        public Criteria andExpReportRateGreaterThan(Float value) {
            addCriterion("exp_report_rate >", value, "expReportRate");
            return (Criteria) this;
        }

        public Criteria andExpReportRateGreaterThanOrEqualTo(Float value) {
            addCriterion("exp_report_rate >=", value, "expReportRate");
            return (Criteria) this;
        }

        public Criteria andExpReportRateLessThan(Float value) {
            addCriterion("exp_report_rate <", value, "expReportRate");
            return (Criteria) this;
        }

        public Criteria andExpReportRateLessThanOrEqualTo(Float value) {
            addCriterion("exp_report_rate <=", value, "expReportRate");
            return (Criteria) this;
        }

        public Criteria andExpReportRateIn(List<Float> values) {
            addCriterion("exp_report_rate in", values, "expReportRate");
            return (Criteria) this;
        }

        public Criteria andExpReportRateNotIn(List<Float> values) {
            addCriterion("exp_report_rate not in", values, "expReportRate");
            return (Criteria) this;
        }

        public Criteria andExpReportRateBetween(Float value1, Float value2) {
            addCriterion("exp_report_rate between", value1, value2, "expReportRate");
            return (Criteria) this;
        }

        public Criteria andExpReportRateNotBetween(Float value1, Float value2) {
            addCriterion("exp_report_rate not between", value1, value2, "expReportRate");
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