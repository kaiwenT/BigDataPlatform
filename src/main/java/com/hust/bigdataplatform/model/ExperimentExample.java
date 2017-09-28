package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExperimentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExperimentExample() {
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

        public Criteria andExperimentNameIsNull() {
            addCriterion("experiment_name is null");
            return (Criteria) this;
        }

        public Criteria andExperimentNameIsNotNull() {
            addCriterion("experiment_name is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentNameEqualTo(String value) {
            addCriterion("experiment_name =", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameNotEqualTo(String value) {
            addCriterion("experiment_name <>", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameGreaterThan(String value) {
            addCriterion("experiment_name >", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameGreaterThanOrEqualTo(String value) {
            addCriterion("experiment_name >=", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameLessThan(String value) {
            addCriterion("experiment_name <", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameLessThanOrEqualTo(String value) {
            addCriterion("experiment_name <=", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameLike(String value) {
            addCriterion("experiment_name like", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameNotLike(String value) {
            addCriterion("experiment_name not like", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameIn(List<String> values) {
            addCriterion("experiment_name in", values, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameNotIn(List<String> values) {
            addCriterion("experiment_name not in", values, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameBetween(String value1, String value2) {
            addCriterion("experiment_name between", value1, value2, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameNotBetween(String value1, String value2) {
            addCriterion("experiment_name not between", value1, value2, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeIsNull() {
            addCriterion("experiment_createTime is null");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeIsNotNull() {
            addCriterion("experiment_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeEqualTo(Date value) {
            addCriterion("experiment_createTime =", value, "experimentCreatetime");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeNotEqualTo(Date value) {
            addCriterion("experiment_createTime <>", value, "experimentCreatetime");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeGreaterThan(Date value) {
            addCriterion("experiment_createTime >", value, "experimentCreatetime");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("experiment_createTime >=", value, "experimentCreatetime");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeLessThan(Date value) {
            addCriterion("experiment_createTime <", value, "experimentCreatetime");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("experiment_createTime <=", value, "experimentCreatetime");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeIn(List<Date> values) {
            addCriterion("experiment_createTime in", values, "experimentCreatetime");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeNotIn(List<Date> values) {
            addCriterion("experiment_createTime not in", values, "experimentCreatetime");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeBetween(Date value1, Date value2) {
            addCriterion("experiment_createTime between", value1, value2, "experimentCreatetime");
            return (Criteria) this;
        }

        public Criteria andExperimentCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("experiment_createTime not between", value1, value2, "experimentCreatetime");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineIsNull() {
            addCriterion("experiment_deadline is null");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineIsNotNull() {
            addCriterion("experiment_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineEqualTo(Date value) {
            addCriterion("experiment_deadline =", value, "experimentDeadline");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineNotEqualTo(Date value) {
            addCriterion("experiment_deadline <>", value, "experimentDeadline");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineGreaterThan(Date value) {
            addCriterion("experiment_deadline >", value, "experimentDeadline");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("experiment_deadline >=", value, "experimentDeadline");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineLessThan(Date value) {
            addCriterion("experiment_deadline <", value, "experimentDeadline");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("experiment_deadline <=", value, "experimentDeadline");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineIn(List<Date> values) {
            addCriterion("experiment_deadline in", values, "experimentDeadline");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineNotIn(List<Date> values) {
            addCriterion("experiment_deadline not in", values, "experimentDeadline");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineBetween(Date value1, Date value2) {
            addCriterion("experiment_deadline between", value1, value2, "experimentDeadline");
            return (Criteria) this;
        }

        public Criteria andExperimentDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("experiment_deadline not between", value1, value2, "experimentDeadline");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandIsNull() {
            addCriterion("experiment_submitDemand is null");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandIsNotNull() {
            addCriterion("experiment_submitDemand is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandEqualTo(String value) {
            addCriterion("experiment_submitDemand =", value, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandNotEqualTo(String value) {
            addCriterion("experiment_submitDemand <>", value, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandGreaterThan(String value) {
            addCriterion("experiment_submitDemand >", value, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandGreaterThanOrEqualTo(String value) {
            addCriterion("experiment_submitDemand >=", value, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandLessThan(String value) {
            addCriterion("experiment_submitDemand <", value, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandLessThanOrEqualTo(String value) {
            addCriterion("experiment_submitDemand <=", value, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandLike(String value) {
            addCriterion("experiment_submitDemand like", value, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandNotLike(String value) {
            addCriterion("experiment_submitDemand not like", value, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandIn(List<String> values) {
            addCriterion("experiment_submitDemand in", values, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandNotIn(List<String> values) {
            addCriterion("experiment_submitDemand not in", values, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandBetween(String value1, String value2) {
            addCriterion("experiment_submitDemand between", value1, value2, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentSubmitdemandNotBetween(String value1, String value2) {
            addCriterion("experiment_submitDemand not between", value1, value2, "experimentSubmitdemand");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathIsNull() {
            addCriterion("experiment_manualPath is null");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathIsNotNull() {
            addCriterion("experiment_manualPath is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathEqualTo(String value) {
            addCriterion("experiment_manualPath =", value, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathNotEqualTo(String value) {
            addCriterion("experiment_manualPath <>", value, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathGreaterThan(String value) {
            addCriterion("experiment_manualPath >", value, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathGreaterThanOrEqualTo(String value) {
            addCriterion("experiment_manualPath >=", value, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathLessThan(String value) {
            addCriterion("experiment_manualPath <", value, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathLessThanOrEqualTo(String value) {
            addCriterion("experiment_manualPath <=", value, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathLike(String value) {
            addCriterion("experiment_manualPath like", value, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathNotLike(String value) {
            addCriterion("experiment_manualPath not like", value, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathIn(List<String> values) {
            addCriterion("experiment_manualPath in", values, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathNotIn(List<String> values) {
            addCriterion("experiment_manualPath not in", values, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathBetween(String value1, String value2) {
            addCriterion("experiment_manualPath between", value1, value2, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentManualpathNotBetween(String value1, String value2) {
            addCriterion("experiment_manualPath not between", value1, value2, "experimentManualpath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathIsNull() {
            addCriterion("experiment_resultsPath is null");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathIsNotNull() {
            addCriterion("experiment_resultsPath is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathEqualTo(String value) {
            addCriterion("experiment_resultsPath =", value, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathNotEqualTo(String value) {
            addCriterion("experiment_resultsPath <>", value, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathGreaterThan(String value) {
            addCriterion("experiment_resultsPath >", value, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathGreaterThanOrEqualTo(String value) {
            addCriterion("experiment_resultsPath >=", value, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathLessThan(String value) {
            addCriterion("experiment_resultsPath <", value, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathLessThanOrEqualTo(String value) {
            addCriterion("experiment_resultsPath <=", value, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathLike(String value) {
            addCriterion("experiment_resultsPath like", value, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathNotLike(String value) {
            addCriterion("experiment_resultsPath not like", value, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathIn(List<String> values) {
            addCriterion("experiment_resultsPath in", values, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathNotIn(List<String> values) {
            addCriterion("experiment_resultsPath not in", values, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathBetween(String value1, String value2) {
            addCriterion("experiment_resultsPath between", value1, value2, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentResultspathNotBetween(String value1, String value2) {
            addCriterion("experiment_resultsPath not between", value1, value2, "experimentResultspath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathIsNull() {
            addCriterion("experiment_reportPath is null");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathIsNotNull() {
            addCriterion("experiment_reportPath is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathEqualTo(String value) {
            addCriterion("experiment_reportPath =", value, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathNotEqualTo(String value) {
            addCriterion("experiment_reportPath <>", value, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathGreaterThan(String value) {
            addCriterion("experiment_reportPath >", value, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathGreaterThanOrEqualTo(String value) {
            addCriterion("experiment_reportPath >=", value, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathLessThan(String value) {
            addCriterion("experiment_reportPath <", value, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathLessThanOrEqualTo(String value) {
            addCriterion("experiment_reportPath <=", value, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathLike(String value) {
            addCriterion("experiment_reportPath like", value, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathNotLike(String value) {
            addCriterion("experiment_reportPath not like", value, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathIn(List<String> values) {
            addCriterion("experiment_reportPath in", values, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathNotIn(List<String> values) {
            addCriterion("experiment_reportPath not in", values, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathBetween(String value1, String value2) {
            addCriterion("experiment_reportPath between", value1, value2, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentReportpathNotBetween(String value1, String value2) {
            addCriterion("experiment_reportPath not between", value1, value2, "experimentReportpath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathIsNull() {
            addCriterion("experiment_videoPath is null");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathIsNotNull() {
            addCriterion("experiment_videoPath is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathEqualTo(String value) {
            addCriterion("experiment_videoPath =", value, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathNotEqualTo(String value) {
            addCriterion("experiment_videoPath <>", value, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathGreaterThan(String value) {
            addCriterion("experiment_videoPath >", value, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathGreaterThanOrEqualTo(String value) {
            addCriterion("experiment_videoPath >=", value, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathLessThan(String value) {
            addCriterion("experiment_videoPath <", value, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathLessThanOrEqualTo(String value) {
            addCriterion("experiment_videoPath <=", value, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathLike(String value) {
            addCriterion("experiment_videoPath like", value, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathNotLike(String value) {
            addCriterion("experiment_videoPath not like", value, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathIn(List<String> values) {
            addCriterion("experiment_videoPath in", values, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathNotIn(List<String> values) {
            addCriterion("experiment_videoPath not in", values, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathBetween(String value1, String value2) {
            addCriterion("experiment_videoPath between", value1, value2, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentVideopathNotBetween(String value1, String value2) {
            addCriterion("experiment_videoPath not between", value1, value2, "experimentVideopath");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleIsNull() {
            addCriterion("experiment_scale is null");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleIsNotNull() {
            addCriterion("experiment_scale is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleEqualTo(Float value) {
            addCriterion("experiment_scale =", value, "experimentScale");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleNotEqualTo(Float value) {
            addCriterion("experiment_scale <>", value, "experimentScale");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleGreaterThan(Float value) {
            addCriterion("experiment_scale >", value, "experimentScale");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleGreaterThanOrEqualTo(Float value) {
            addCriterion("experiment_scale >=", value, "experimentScale");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleLessThan(Float value) {
            addCriterion("experiment_scale <", value, "experimentScale");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleLessThanOrEqualTo(Float value) {
            addCriterion("experiment_scale <=", value, "experimentScale");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleIn(List<Float> values) {
            addCriterion("experiment_scale in", values, "experimentScale");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleNotIn(List<Float> values) {
            addCriterion("experiment_scale not in", values, "experimentScale");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleBetween(Float value1, Float value2) {
            addCriterion("experiment_scale between", value1, value2, "experimentScale");
            return (Criteria) this;
        }

        public Criteria andExperimentScaleNotBetween(Float value1, Float value2) {
            addCriterion("experiment_scale not between", value1, value2, "experimentScale");
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