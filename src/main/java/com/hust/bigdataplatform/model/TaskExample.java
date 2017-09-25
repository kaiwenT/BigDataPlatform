package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
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

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineIsNull() {
            addCriterion("task_deadline is null");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineIsNotNull() {
            addCriterion("task_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineEqualTo(Date value) {
            addCriterion("task_deadline =", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineNotEqualTo(Date value) {
            addCriterion("task_deadline <>", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineGreaterThan(Date value) {
            addCriterion("task_deadline >", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("task_deadline >=", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineLessThan(Date value) {
            addCriterion("task_deadline <", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("task_deadline <=", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineIn(List<Date> values) {
            addCriterion("task_deadline in", values, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineNotIn(List<Date> values) {
            addCriterion("task_deadline not in", values, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineBetween(Date value1, Date value2) {
            addCriterion("task_deadline between", value1, value2, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("task_deadline not between", value1, value2, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathIsNull() {
            addCriterion("task_coursewarePath is null");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathIsNotNull() {
            addCriterion("task_coursewarePath is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathEqualTo(String value) {
            addCriterion("task_coursewarePath =", value, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathNotEqualTo(String value) {
            addCriterion("task_coursewarePath <>", value, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathGreaterThan(String value) {
            addCriterion("task_coursewarePath >", value, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathGreaterThanOrEqualTo(String value) {
            addCriterion("task_coursewarePath >=", value, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathLessThan(String value) {
            addCriterion("task_coursewarePath <", value, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathLessThanOrEqualTo(String value) {
            addCriterion("task_coursewarePath <=", value, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathLike(String value) {
            addCriterion("task_coursewarePath like", value, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathNotLike(String value) {
            addCriterion("task_coursewarePath not like", value, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathIn(List<String> values) {
            addCriterion("task_coursewarePath in", values, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathNotIn(List<String> values) {
            addCriterion("task_coursewarePath not in", values, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathBetween(String value1, String value2) {
            addCriterion("task_coursewarePath between", value1, value2, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskCoursewarepathNotBetween(String value1, String value2) {
            addCriterion("task_coursewarePath not between", value1, value2, "taskCoursewarepath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathIsNull() {
            addCriterion("task_submitPath is null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathIsNotNull() {
            addCriterion("task_submitPath is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathEqualTo(String value) {
            addCriterion("task_submitPath =", value, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathNotEqualTo(String value) {
            addCriterion("task_submitPath <>", value, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathGreaterThan(String value) {
            addCriterion("task_submitPath >", value, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathGreaterThanOrEqualTo(String value) {
            addCriterion("task_submitPath >=", value, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathLessThan(String value) {
            addCriterion("task_submitPath <", value, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathLessThanOrEqualTo(String value) {
            addCriterion("task_submitPath <=", value, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathLike(String value) {
            addCriterion("task_submitPath like", value, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathNotLike(String value) {
            addCriterion("task_submitPath not like", value, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathIn(List<String> values) {
            addCriterion("task_submitPath in", values, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathNotIn(List<String> values) {
            addCriterion("task_submitPath not in", values, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathBetween(String value1, String value2) {
            addCriterion("task_submitPath between", value1, value2, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitpathNotBetween(String value1, String value2) {
            addCriterion("task_submitPath not between", value1, value2, "taskSubmitpath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathIsNull() {
            addCriterion("task_videoPath is null");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathIsNotNull() {
            addCriterion("task_videoPath is not null");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathEqualTo(String value) {
            addCriterion("task_videoPath =", value, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathNotEqualTo(String value) {
            addCriterion("task_videoPath <>", value, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathGreaterThan(String value) {
            addCriterion("task_videoPath >", value, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathGreaterThanOrEqualTo(String value) {
            addCriterion("task_videoPath >=", value, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathLessThan(String value) {
            addCriterion("task_videoPath <", value, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathLessThanOrEqualTo(String value) {
            addCriterion("task_videoPath <=", value, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathLike(String value) {
            addCriterion("task_videoPath like", value, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathNotLike(String value) {
            addCriterion("task_videoPath not like", value, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathIn(List<String> values) {
            addCriterion("task_videoPath in", values, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathNotIn(List<String> values) {
            addCriterion("task_videoPath not in", values, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathBetween(String value1, String value2) {
            addCriterion("task_videoPath between", value1, value2, "taskVideopath");
            return (Criteria) this;
        }

        public Criteria andTaskVideopathNotBetween(String value1, String value2) {
            addCriterion("task_videoPath not between", value1, value2, "taskVideopath");
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