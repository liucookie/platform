package com.hangyu.platform.web.backBusiness.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblTestExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTestcontentIsNull() {
            addCriterion("testContent is null");
            return (Criteria) this;
        }

        public Criteria andTestcontentIsNotNull() {
            addCriterion("testContent is not null");
            return (Criteria) this;
        }

        public Criteria andTestcontentEqualTo(String value) {
            addCriterion("testContent =", value, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentNotEqualTo(String value) {
            addCriterion("testContent <>", value, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentGreaterThan(String value) {
            addCriterion("testContent >", value, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentGreaterThanOrEqualTo(String value) {
            addCriterion("testContent >=", value, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentLessThan(String value) {
            addCriterion("testContent <", value, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentLessThanOrEqualTo(String value) {
            addCriterion("testContent <=", value, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentLike(String value) {
            addCriterion("testContent like", value, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentNotLike(String value) {
            addCriterion("testContent not like", value, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentIn(List<String> values) {
            addCriterion("testContent in", values, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentNotIn(List<String> values) {
            addCriterion("testContent not in", values, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentBetween(String value1, String value2) {
            addCriterion("testContent between", value1, value2, "testcontent");
            return (Criteria) this;
        }

        public Criteria andTestcontentNotBetween(String value1, String value2) {
            addCriterion("testContent not between", value1, value2, "testcontent");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andForanswersIsNull() {
            addCriterion("foranswers is null");
            return (Criteria) this;
        }

        public Criteria andForanswersIsNotNull() {
            addCriterion("foranswers is not null");
            return (Criteria) this;
        }

        public Criteria andForanswersEqualTo(String value) {
            addCriterion("foranswers =", value, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersNotEqualTo(String value) {
            addCriterion("foranswers <>", value, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersGreaterThan(String value) {
            addCriterion("foranswers >", value, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersGreaterThanOrEqualTo(String value) {
            addCriterion("foranswers >=", value, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersLessThan(String value) {
            addCriterion("foranswers <", value, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersLessThanOrEqualTo(String value) {
            addCriterion("foranswers <=", value, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersLike(String value) {
            addCriterion("foranswers like", value, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersNotLike(String value) {
            addCriterion("foranswers not like", value, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersIn(List<String> values) {
            addCriterion("foranswers in", values, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersNotIn(List<String> values) {
            addCriterion("foranswers not in", values, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersBetween(String value1, String value2) {
            addCriterion("foranswers between", value1, value2, "foranswers");
            return (Criteria) this;
        }

        public Criteria andForanswersNotBetween(String value1, String value2) {
            addCriterion("foranswers not between", value1, value2, "foranswers");
            return (Criteria) this;
        }

        public Criteria andRightanswerIsNull() {
            addCriterion("rightanswer is null");
            return (Criteria) this;
        }

        public Criteria andRightanswerIsNotNull() {
            addCriterion("rightanswer is not null");
            return (Criteria) this;
        }

        public Criteria andRightanswerEqualTo(String value) {
            addCriterion("rightanswer =", value, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerNotEqualTo(String value) {
            addCriterion("rightanswer <>", value, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerGreaterThan(String value) {
            addCriterion("rightanswer >", value, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerGreaterThanOrEqualTo(String value) {
            addCriterion("rightanswer >=", value, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerLessThan(String value) {
            addCriterion("rightanswer <", value, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerLessThanOrEqualTo(String value) {
            addCriterion("rightanswer <=", value, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerLike(String value) {
            addCriterion("rightanswer like", value, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerNotLike(String value) {
            addCriterion("rightanswer not like", value, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerIn(List<String> values) {
            addCriterion("rightanswer in", values, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerNotIn(List<String> values) {
            addCriterion("rightanswer not in", values, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerBetween(String value1, String value2) {
            addCriterion("rightanswer between", value1, value2, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andRightanswerNotBetween(String value1, String value2) {
            addCriterion("rightanswer not between", value1, value2, "rightanswer");
            return (Criteria) this;
        }

        public Criteria andUsecountIsNull() {
            addCriterion("useCount is null");
            return (Criteria) this;
        }

        public Criteria andUsecountIsNotNull() {
            addCriterion("useCount is not null");
            return (Criteria) this;
        }

        public Criteria andUsecountEqualTo(Integer value) {
            addCriterion("useCount =", value, "usecount");
            return (Criteria) this;
        }

        public Criteria andUsecountNotEqualTo(Integer value) {
            addCriterion("useCount <>", value, "usecount");
            return (Criteria) this;
        }

        public Criteria andUsecountGreaterThan(Integer value) {
            addCriterion("useCount >", value, "usecount");
            return (Criteria) this;
        }

        public Criteria andUsecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("useCount >=", value, "usecount");
            return (Criteria) this;
        }

        public Criteria andUsecountLessThan(Integer value) {
            addCriterion("useCount <", value, "usecount");
            return (Criteria) this;
        }

        public Criteria andUsecountLessThanOrEqualTo(Integer value) {
            addCriterion("useCount <=", value, "usecount");
            return (Criteria) this;
        }

        public Criteria andUsecountIn(List<Integer> values) {
            addCriterion("useCount in", values, "usecount");
            return (Criteria) this;
        }

        public Criteria andUsecountNotIn(List<Integer> values) {
            addCriterion("useCount not in", values, "usecount");
            return (Criteria) this;
        }

        public Criteria andUsecountBetween(Integer value1, Integer value2) {
            addCriterion("useCount between", value1, value2, "usecount");
            return (Criteria) this;
        }

        public Criteria andUsecountNotBetween(Integer value1, Integer value2) {
            addCriterion("useCount not between", value1, value2, "usecount");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isDelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isDelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isDelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isDelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isDelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isDelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isDelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isDelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isDelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isDelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andOriginalIsNull() {
            addCriterion("original is null");
            return (Criteria) this;
        }

        public Criteria andOriginalIsNotNull() {
            addCriterion("original is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalEqualTo(Integer value) {
            addCriterion("original =", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotEqualTo(Integer value) {
            addCriterion("original <>", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalGreaterThan(Integer value) {
            addCriterion("original >", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalGreaterThanOrEqualTo(Integer value) {
            addCriterion("original >=", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalLessThan(Integer value) {
            addCriterion("original <", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalLessThanOrEqualTo(Integer value) {
            addCriterion("original <=", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalIn(List<Integer> values) {
            addCriterion("original in", values, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotIn(List<Integer> values) {
            addCriterion("original not in", values, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalBetween(Integer value1, Integer value2) {
            addCriterion("original between", value1, value2, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotBetween(Integer value1, Integer value2) {
            addCriterion("original not between", value1, value2, "original");
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