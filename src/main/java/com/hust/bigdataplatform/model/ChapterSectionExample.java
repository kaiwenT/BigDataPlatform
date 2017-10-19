package com.hust.bigdataplatform.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChapterSectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChapterSectionExample() {
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

        public Criteria andSectionidIsNull() {
            addCriterion("sectionId is null");
            return (Criteria) this;
        }

        public Criteria andSectionidIsNotNull() {
            addCriterion("sectionId is not null");
            return (Criteria) this;
        }

        public Criteria andSectionidEqualTo(String value) {
            addCriterion("sectionId =", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotEqualTo(String value) {
            addCriterion("sectionId <>", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidGreaterThan(String value) {
            addCriterion("sectionId >", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidGreaterThanOrEqualTo(String value) {
            addCriterion("sectionId >=", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLessThan(String value) {
            addCriterion("sectionId <", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLessThanOrEqualTo(String value) {
            addCriterion("sectionId <=", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLike(String value) {
            addCriterion("sectionId like", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotLike(String value) {
            addCriterion("sectionId not like", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidIn(List<String> values) {
            addCriterion("sectionId in", values, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotIn(List<String> values) {
            addCriterion("sectionId not in", values, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidBetween(String value1, String value2) {
            addCriterion("sectionId between", value1, value2, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotBetween(String value1, String value2) {
            addCriterion("sectionId not between", value1, value2, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionnameIsNull() {
            addCriterion("sectionName is null");
            return (Criteria) this;
        }

        public Criteria andSectionnameIsNotNull() {
            addCriterion("sectionName is not null");
            return (Criteria) this;
        }

        public Criteria andSectionnameEqualTo(String value) {
            addCriterion("sectionName =", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameNotEqualTo(String value) {
            addCriterion("sectionName <>", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameGreaterThan(String value) {
            addCriterion("sectionName >", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameGreaterThanOrEqualTo(String value) {
            addCriterion("sectionName >=", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameLessThan(String value) {
            addCriterion("sectionName <", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameLessThanOrEqualTo(String value) {
            addCriterion("sectionName <=", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameLike(String value) {
            addCriterion("sectionName like", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameNotLike(String value) {
            addCriterion("sectionName not like", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameIn(List<String> values) {
            addCriterion("sectionName in", values, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameNotIn(List<String> values) {
            addCriterion("sectionName not in", values, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameBetween(String value1, String value2) {
            addCriterion("sectionName between", value1, value2, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameNotBetween(String value1, String value2) {
            addCriterion("sectionName not between", value1, value2, "sectionname");
            return (Criteria) this;
        }

        public Criteria andChapterIdIsNull() {
            addCriterion("chapter_id is null");
            return (Criteria) this;
        }

        public Criteria andChapterIdIsNotNull() {
            addCriterion("chapter_id is not null");
            return (Criteria) this;
        }

        public Criteria andChapterIdEqualTo(String value) {
            addCriterion("chapter_id =", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotEqualTo(String value) {
            addCriterion("chapter_id <>", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThan(String value) {
            addCriterion("chapter_id >", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThanOrEqualTo(String value) {
            addCriterion("chapter_id >=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThan(String value) {
            addCriterion("chapter_id <", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThanOrEqualTo(String value) {
            addCriterion("chapter_id <=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLike(String value) {
            addCriterion("chapter_id like", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotLike(String value) {
            addCriterion("chapter_id not like", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdIn(List<String> values) {
            addCriterion("chapter_id in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotIn(List<String> values) {
            addCriterion("chapter_id not in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdBetween(String value1, String value2) {
            addCriterion("chapter_id between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotBetween(String value1, String value2) {
            addCriterion("chapter_id not between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
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