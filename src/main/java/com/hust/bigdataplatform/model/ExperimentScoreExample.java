package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.List;

public class ExperimentScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExperimentScoreExample() {
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

        public Criteria andExperimentIdIsNull() {
            addCriterion("experiment_id is null");
            return (Criteria) this;
        }

        public Criteria andExperimentIdIsNotNull() {
            addCriterion("experiment_id is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentIdEqualTo(String value) {
            addCriterion("experiment_id =", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdNotEqualTo(String value) {
            addCriterion("experiment_id <>", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdGreaterThan(String value) {
            addCriterion("experiment_id >", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdGreaterThanOrEqualTo(String value) {
            addCriterion("experiment_id >=", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdLessThan(String value) {
            addCriterion("experiment_id <", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdLessThanOrEqualTo(String value) {
            addCriterion("experiment_id <=", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdLike(String value) {
            addCriterion("experiment_id like", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdNotLike(String value) {
            addCriterion("experiment_id not like", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdIn(List<String> values) {
            addCriterion("experiment_id in", values, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdNotIn(List<String> values) {
            addCriterion("experiment_id not in", values, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdBetween(String value1, String value2) {
            addCriterion("experiment_id between", value1, value2, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdNotBetween(String value1, String value2) {
            addCriterion("experiment_id not between", value1, value2, "experimentId");
            return (Criteria) this;
        }

        public Criteria andResultsscoreIsNull() {
            addCriterion("resultsScore is null");
            return (Criteria) this;
        }

        public Criteria andResultsscoreIsNotNull() {
            addCriterion("resultsScore is not null");
            return (Criteria) this;
        }

        public Criteria andResultsscoreEqualTo(Integer value) {
            addCriterion("resultsScore =", value, "resultsscore");
            return (Criteria) this;
        }

        public Criteria andResultsscoreNotEqualTo(Integer value) {
            addCriterion("resultsScore <>", value, "resultsscore");
            return (Criteria) this;
        }

        public Criteria andResultsscoreGreaterThan(Integer value) {
            addCriterion("resultsScore >", value, "resultsscore");
            return (Criteria) this;
        }

        public Criteria andResultsscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("resultsScore >=", value, "resultsscore");
            return (Criteria) this;
        }

        public Criteria andResultsscoreLessThan(Integer value) {
            addCriterion("resultsScore <", value, "resultsscore");
            return (Criteria) this;
        }

        public Criteria andResultsscoreLessThanOrEqualTo(Integer value) {
            addCriterion("resultsScore <=", value, "resultsscore");
            return (Criteria) this;
        }

        public Criteria andResultsscoreIn(List<Integer> values) {
            addCriterion("resultsScore in", values, "resultsscore");
            return (Criteria) this;
        }

        public Criteria andResultsscoreNotIn(List<Integer> values) {
            addCriterion("resultsScore not in", values, "resultsscore");
            return (Criteria) this;
        }

        public Criteria andResultsscoreBetween(Integer value1, Integer value2) {
            addCriterion("resultsScore between", value1, value2, "resultsscore");
            return (Criteria) this;
        }

        public Criteria andResultsscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("resultsScore not between", value1, value2, "resultsscore");
            return (Criteria) this;
        }

        public Criteria andReportscoreIsNull() {
            addCriterion("reportScore is null");
            return (Criteria) this;
        }

        public Criteria andReportscoreIsNotNull() {
            addCriterion("reportScore is not null");
            return (Criteria) this;
        }

        public Criteria andReportscoreEqualTo(Integer value) {
            addCriterion("reportScore =", value, "reportscore");
            return (Criteria) this;
        }

        public Criteria andReportscoreNotEqualTo(Integer value) {
            addCriterion("reportScore <>", value, "reportscore");
            return (Criteria) this;
        }

        public Criteria andReportscoreGreaterThan(Integer value) {
            addCriterion("reportScore >", value, "reportscore");
            return (Criteria) this;
        }

        public Criteria andReportscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("reportScore >=", value, "reportscore");
            return (Criteria) this;
        }

        public Criteria andReportscoreLessThan(Integer value) {
            addCriterion("reportScore <", value, "reportscore");
            return (Criteria) this;
        }

        public Criteria andReportscoreLessThanOrEqualTo(Integer value) {
            addCriterion("reportScore <=", value, "reportscore");
            return (Criteria) this;
        }

        public Criteria andReportscoreIn(List<Integer> values) {
            addCriterion("reportScore in", values, "reportscore");
            return (Criteria) this;
        }

        public Criteria andReportscoreNotIn(List<Integer> values) {
            addCriterion("reportScore not in", values, "reportscore");
            return (Criteria) this;
        }

        public Criteria andReportscoreBetween(Integer value1, Integer value2) {
            addCriterion("reportScore between", value1, value2, "reportscore");
            return (Criteria) this;
        }

        public Criteria andReportscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("reportScore not between", value1, value2, "reportscore");
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