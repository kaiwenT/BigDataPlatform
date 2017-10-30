package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.List;

public class StudentScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentScoreExample() {
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

        public Criteria andUsualgradesIsNull() {
            addCriterion("usualGrades is null");
            return (Criteria) this;
        }

        public Criteria andUsualgradesIsNotNull() {
            addCriterion("usualGrades is not null");
            return (Criteria) this;
        }

        public Criteria andUsualgradesEqualTo(Integer value) {
            addCriterion("usualGrades =", value, "usualgrades");
            return (Criteria) this;
        }

        public Criteria andUsualgradesNotEqualTo(Integer value) {
            addCriterion("usualGrades <>", value, "usualgrades");
            return (Criteria) this;
        }

        public Criteria andUsualgradesGreaterThan(Integer value) {
            addCriterion("usualGrades >", value, "usualgrades");
            return (Criteria) this;
        }

        public Criteria andUsualgradesGreaterThanOrEqualTo(Integer value) {
            addCriterion("usualGrades >=", value, "usualgrades");
            return (Criteria) this;
        }

        public Criteria andUsualgradesLessThan(Integer value) {
            addCriterion("usualGrades <", value, "usualgrades");
            return (Criteria) this;
        }

        public Criteria andUsualgradesLessThanOrEqualTo(Integer value) {
            addCriterion("usualGrades <=", value, "usualgrades");
            return (Criteria) this;
        }

        public Criteria andUsualgradesIn(List<Integer> values) {
            addCriterion("usualGrades in", values, "usualgrades");
            return (Criteria) this;
        }

        public Criteria andUsualgradesNotIn(List<Integer> values) {
            addCriterion("usualGrades not in", values, "usualgrades");
            return (Criteria) this;
        }

        public Criteria andUsualgradesBetween(Integer value1, Integer value2) {
            addCriterion("usualGrades between", value1, value2, "usualgrades");
            return (Criteria) this;
        }

        public Criteria andUsualgradesNotBetween(Integer value1, Integer value2) {
            addCriterion("usualGrades not between", value1, value2, "usualgrades");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreIsNull() {
            addCriterion("exp_finalScore is null");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreIsNotNull() {
            addCriterion("exp_finalScore is not null");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreEqualTo(Integer value) {
            addCriterion("exp_finalScore =", value, "expFinalscore");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreNotEqualTo(Integer value) {
            addCriterion("exp_finalScore <>", value, "expFinalscore");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreGreaterThan(Integer value) {
            addCriterion("exp_finalScore >", value, "expFinalscore");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("exp_finalScore >=", value, "expFinalscore");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreLessThan(Integer value) {
            addCriterion("exp_finalScore <", value, "expFinalscore");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreLessThanOrEqualTo(Integer value) {
            addCriterion("exp_finalScore <=", value, "expFinalscore");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreIn(List<Integer> values) {
            addCriterion("exp_finalScore in", values, "expFinalscore");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreNotIn(List<Integer> values) {
            addCriterion("exp_finalScore not in", values, "expFinalscore");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreBetween(Integer value1, Integer value2) {
            addCriterion("exp_finalScore between", value1, value2, "expFinalscore");
            return (Criteria) this;
        }

        public Criteria andExpFinalscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("exp_finalScore not between", value1, value2, "expFinalscore");
            return (Criteria) this;
        }

        public Criteria andTestResultsIsNull() {
            addCriterion("test_results is null");
            return (Criteria) this;
        }

        public Criteria andTestResultsIsNotNull() {
            addCriterion("test_results is not null");
            return (Criteria) this;
        }

        public Criteria andTestResultsEqualTo(Integer value) {
            addCriterion("test_results =", value, "testResults");
            return (Criteria) this;
        }

        public Criteria andTestResultsNotEqualTo(Integer value) {
            addCriterion("test_results <>", value, "testResults");
            return (Criteria) this;
        }

        public Criteria andTestResultsGreaterThan(Integer value) {
            addCriterion("test_results >", value, "testResults");
            return (Criteria) this;
        }

        public Criteria andTestResultsGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_results >=", value, "testResults");
            return (Criteria) this;
        }

        public Criteria andTestResultsLessThan(Integer value) {
            addCriterion("test_results <", value, "testResults");
            return (Criteria) this;
        }

        public Criteria andTestResultsLessThanOrEqualTo(Integer value) {
            addCriterion("test_results <=", value, "testResults");
            return (Criteria) this;
        }

        public Criteria andTestResultsIn(List<Integer> values) {
            addCriterion("test_results in", values, "testResults");
            return (Criteria) this;
        }

        public Criteria andTestResultsNotIn(List<Integer> values) {
            addCriterion("test_results not in", values, "testResults");
            return (Criteria) this;
        }

        public Criteria andTestResultsBetween(Integer value1, Integer value2) {
            addCriterion("test_results between", value1, value2, "testResults");
            return (Criteria) this;
        }

        public Criteria andTestResultsNotBetween(Integer value1, Integer value2) {
            addCriterion("test_results not between", value1, value2, "testResults");
            return (Criteria) this;
        }

        public Criteria andFinalscoreIsNull() {
            addCriterion("finalScore is null");
            return (Criteria) this;
        }

        public Criteria andFinalscoreIsNotNull() {
            addCriterion("finalScore is not null");
            return (Criteria) this;
        }

        public Criteria andFinalscoreEqualTo(Integer value) {
            addCriterion("finalScore =", value, "finalscore");
            return (Criteria) this;
        }

        public Criteria andFinalscoreNotEqualTo(Integer value) {
            addCriterion("finalScore <>", value, "finalscore");
            return (Criteria) this;
        }

        public Criteria andFinalscoreGreaterThan(Integer value) {
            addCriterion("finalScore >", value, "finalscore");
            return (Criteria) this;
        }

        public Criteria andFinalscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("finalScore >=", value, "finalscore");
            return (Criteria) this;
        }

        public Criteria andFinalscoreLessThan(Integer value) {
            addCriterion("finalScore <", value, "finalscore");
            return (Criteria) this;
        }

        public Criteria andFinalscoreLessThanOrEqualTo(Integer value) {
            addCriterion("finalScore <=", value, "finalscore");
            return (Criteria) this;
        }

        public Criteria andFinalscoreIn(List<Integer> values) {
            addCriterion("finalScore in", values, "finalscore");
            return (Criteria) this;
        }

        public Criteria andFinalscoreNotIn(List<Integer> values) {
            addCriterion("finalScore not in", values, "finalscore");
            return (Criteria) this;
        }

        public Criteria andFinalscoreBetween(Integer value1, Integer value2) {
            addCriterion("finalScore between", value1, value2, "finalscore");
            return (Criteria) this;
        }

        public Criteria andFinalscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("finalScore not between", value1, value2, "finalscore");
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