package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeIsNull() {
            addCriterion("course_beginTime is null");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeIsNotNull() {
            addCriterion("course_beginTime is not null");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeEqualTo(Date value) {
            addCriterion("course_beginTime =", value, "courseBegintime");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeNotEqualTo(Date value) {
            addCriterion("course_beginTime <>", value, "courseBegintime");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeGreaterThan(Date value) {
            addCriterion("course_beginTime >", value, "courseBegintime");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("course_beginTime >=", value, "courseBegintime");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeLessThan(Date value) {
            addCriterion("course_beginTime <", value, "courseBegintime");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeLessThanOrEqualTo(Date value) {
            addCriterion("course_beginTime <=", value, "courseBegintime");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeIn(List<Date> values) {
            addCriterion("course_beginTime in", values, "courseBegintime");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeNotIn(List<Date> values) {
            addCriterion("course_beginTime not in", values, "courseBegintime");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeBetween(Date value1, Date value2) {
            addCriterion("course_beginTime between", value1, value2, "courseBegintime");
            return (Criteria) this;
        }

        public Criteria andCourseBegintimeNotBetween(Date value1, Date value2) {
            addCriterion("course_beginTime not between", value1, value2, "courseBegintime");
            return (Criteria) this;
        }

        public Criteria andCourseCreditIsNull() {
            addCriterion("course_credit is null");
            return (Criteria) this;
        }

        public Criteria andCourseCreditIsNotNull() {
            addCriterion("course_credit is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCreditEqualTo(Integer value) {
            addCriterion("course_credit =", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditNotEqualTo(Integer value) {
            addCriterion("course_credit <>", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditGreaterThan(Integer value) {
            addCriterion("course_credit >", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_credit >=", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditLessThan(Integer value) {
            addCriterion("course_credit <", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditLessThanOrEqualTo(Integer value) {
            addCriterion("course_credit <=", value, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditIn(List<Integer> values) {
            addCriterion("course_credit in", values, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditNotIn(List<Integer> values) {
            addCriterion("course_credit not in", values, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditBetween(Integer value1, Integer value2) {
            addCriterion("course_credit between", value1, value2, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCourseCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("course_credit not between", value1, value2, "courseCredit");
            return (Criteria) this;
        }

        public Criteria andCoursePathIsNull() {
            addCriterion("course_path is null");
            return (Criteria) this;
        }

        public Criteria andCoursePathIsNotNull() {
            addCriterion("course_path is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePathEqualTo(String value) {
            addCriterion("course_path =", value, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathNotEqualTo(String value) {
            addCriterion("course_path <>", value, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathGreaterThan(String value) {
            addCriterion("course_path >", value, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathGreaterThanOrEqualTo(String value) {
            addCriterion("course_path >=", value, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathLessThan(String value) {
            addCriterion("course_path <", value, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathLessThanOrEqualTo(String value) {
            addCriterion("course_path <=", value, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathLike(String value) {
            addCriterion("course_path like", value, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathNotLike(String value) {
            addCriterion("course_path not like", value, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathIn(List<String> values) {
            addCriterion("course_path in", values, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathNotIn(List<String> values) {
            addCriterion("course_path not in", values, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathBetween(String value1, String value2) {
            addCriterion("course_path between", value1, value2, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCoursePathNotBetween(String value1, String value2) {
            addCriterion("course_path not between", value1, value2, "coursePath");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleIsNull() {
            addCriterion("course_UsualGradesScale is null");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleIsNotNull() {
            addCriterion("course_UsualGradesScale is not null");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleEqualTo(Float value) {
            addCriterion("course_UsualGradesScale =", value, "courseUsualgradesscale");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleNotEqualTo(Float value) {
            addCriterion("course_UsualGradesScale <>", value, "courseUsualgradesscale");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleGreaterThan(Float value) {
            addCriterion("course_UsualGradesScale >", value, "courseUsualgradesscale");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleGreaterThanOrEqualTo(Float value) {
            addCriterion("course_UsualGradesScale >=", value, "courseUsualgradesscale");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleLessThan(Float value) {
            addCriterion("course_UsualGradesScale <", value, "courseUsualgradesscale");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleLessThanOrEqualTo(Float value) {
            addCriterion("course_UsualGradesScale <=", value, "courseUsualgradesscale");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleIn(List<Float> values) {
            addCriterion("course_UsualGradesScale in", values, "courseUsualgradesscale");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleNotIn(List<Float> values) {
            addCriterion("course_UsualGradesScale not in", values, "courseUsualgradesscale");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleBetween(Float value1, Float value2) {
            addCriterion("course_UsualGradesScale between", value1, value2, "courseUsualgradesscale");
            return (Criteria) this;
        }

        public Criteria andCourseUsualgradesscaleNotBetween(Float value1, Float value2) {
            addCriterion("course_UsualGradesScale not between", value1, value2, "courseUsualgradesscale");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathIsNull() {
            addCriterion("course_videoPath is null");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathIsNotNull() {
            addCriterion("course_videoPath is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathEqualTo(String value) {
            addCriterion("course_videoPath =", value, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathNotEqualTo(String value) {
            addCriterion("course_videoPath <>", value, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathGreaterThan(String value) {
            addCriterion("course_videoPath >", value, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathGreaterThanOrEqualTo(String value) {
            addCriterion("course_videoPath >=", value, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathLessThan(String value) {
            addCriterion("course_videoPath <", value, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathLessThanOrEqualTo(String value) {
            addCriterion("course_videoPath <=", value, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathLike(String value) {
            addCriterion("course_videoPath like", value, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathNotLike(String value) {
            addCriterion("course_videoPath not like", value, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathIn(List<String> values) {
            addCriterion("course_videoPath in", values, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathNotIn(List<String> values) {
            addCriterion("course_videoPath not in", values, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathBetween(String value1, String value2) {
            addCriterion("course_videoPath between", value1, value2, "courseVideopath");
            return (Criteria) this;
        }

        public Criteria andCourseVideopathNotBetween(String value1, String value2) {
            addCriterion("course_videoPath not between", value1, value2, "courseVideopath");
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