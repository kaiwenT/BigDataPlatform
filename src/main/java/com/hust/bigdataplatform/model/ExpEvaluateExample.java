package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.List;

public class ExpEvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpEvaluateExample() {
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

        public Criteria andEvaluatorIsNull() {
            addCriterion("evaluator is null");
            return (Criteria) this;
        }

        public Criteria andEvaluatorIsNotNull() {
            addCriterion("evaluator is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluatorEqualTo(String value) {
            addCriterion("evaluator =", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorNotEqualTo(String value) {
            addCriterion("evaluator <>", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorGreaterThan(String value) {
            addCriterion("evaluator >", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorGreaterThanOrEqualTo(String value) {
            addCriterion("evaluator >=", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorLessThan(String value) {
            addCriterion("evaluator <", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorLessThanOrEqualTo(String value) {
            addCriterion("evaluator <=", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorLike(String value) {
            addCriterion("evaluator like", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorNotLike(String value) {
            addCriterion("evaluator not like", value, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorIn(List<String> values) {
            addCriterion("evaluator in", values, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorNotIn(List<String> values) {
            addCriterion("evaluator not in", values, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorBetween(String value1, String value2) {
            addCriterion("evaluator between", value1, value2, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatorNotBetween(String value1, String value2) {
            addCriterion("evaluator not between", value1, value2, "evaluator");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreIsNull() {
            addCriterion("evaluateSore is null");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreIsNotNull() {
            addCriterion("evaluateSore is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreEqualTo(Integer value) {
            addCriterion("evaluateSore =", value, "evaluatesore");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreNotEqualTo(Integer value) {
            addCriterion("evaluateSore <>", value, "evaluatesore");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreGreaterThan(Integer value) {
            addCriterion("evaluateSore >", value, "evaluatesore");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluateSore >=", value, "evaluatesore");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreLessThan(Integer value) {
            addCriterion("evaluateSore <", value, "evaluatesore");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreLessThanOrEqualTo(Integer value) {
            addCriterion("evaluateSore <=", value, "evaluatesore");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreIn(List<Integer> values) {
            addCriterion("evaluateSore in", values, "evaluatesore");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreNotIn(List<Integer> values) {
            addCriterion("evaluateSore not in", values, "evaluatesore");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreBetween(Integer value1, Integer value2) {
            addCriterion("evaluateSore between", value1, value2, "evaluatesore");
            return (Criteria) this;
        }

        public Criteria andEvaluatesoreNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluateSore not between", value1, value2, "evaluatesore");
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