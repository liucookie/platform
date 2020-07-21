package com.hangyu.platform.web.backBusiness.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BmSystemitemTblExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BmSystemitemTblExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andItemidIsNull() {
            addCriterion("ItemID is null");
            return (Criteria) this;
        }

        public Criteria andItemidIsNotNull() {
            addCriterion("ItemID is not null");
            return (Criteria) this;
        }

        public Criteria andItemidEqualTo(String value) {
            addCriterion("ItemID =", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotEqualTo(String value) {
            addCriterion("ItemID <>", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThan(String value) {
            addCriterion("ItemID >", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThanOrEqualTo(String value) {
            addCriterion("ItemID >=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThan(String value) {
            addCriterion("ItemID <", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThanOrEqualTo(String value) {
            addCriterion("ItemID <=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLike(String value) {
            addCriterion("ItemID like", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotLike(String value) {
            addCriterion("ItemID not like", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidIn(List<String> values) {
            addCriterion("ItemID in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotIn(List<String> values) {
            addCriterion("ItemID not in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidBetween(String value1, String value2) {
            addCriterion("ItemID between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotBetween(String value1, String value2) {
            addCriterion("ItemID not between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andSysidIsNull() {
            addCriterion("SysID is null");
            return (Criteria) this;
        }

        public Criteria andSysidIsNotNull() {
            addCriterion("SysID is not null");
            return (Criteria) this;
        }

        public Criteria andSysidEqualTo(String value) {
            addCriterion("SysID =", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidNotEqualTo(String value) {
            addCriterion("SysID <>", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidGreaterThan(String value) {
            addCriterion("SysID >", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidGreaterThanOrEqualTo(String value) {
            addCriterion("SysID >=", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidLessThan(String value) {
            addCriterion("SysID <", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidLessThanOrEqualTo(String value) {
            addCriterion("SysID <=", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidLike(String value) {
            addCriterion("SysID like", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidNotLike(String value) {
            addCriterion("SysID not like", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidIn(List<String> values) {
            addCriterion("SysID in", values, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidNotIn(List<String> values) {
            addCriterion("SysID not in", values, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidBetween(String value1, String value2) {
            addCriterion("SysID between", value1, value2, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidNotBetween(String value1, String value2) {
            addCriterion("SysID not between", value1, value2, "sysid");
            return (Criteria) this;
        }

        public Criteria andDscoreIsNull() {
            addCriterion("DScore is null");
            return (Criteria) this;
        }

        public Criteria andDscoreIsNotNull() {
            addCriterion("DScore is not null");
            return (Criteria) this;
        }

        public Criteria andDscoreEqualTo(Integer value) {
            addCriterion("DScore =", value, "dscore");
            return (Criteria) this;
        }

        public Criteria andDscoreNotEqualTo(Integer value) {
            addCriterion("DScore <>", value, "dscore");
            return (Criteria) this;
        }

        public Criteria andDscoreGreaterThan(Integer value) {
            addCriterion("DScore >", value, "dscore");
            return (Criteria) this;
        }

        public Criteria andDscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("DScore >=", value, "dscore");
            return (Criteria) this;
        }

        public Criteria andDscoreLessThan(Integer value) {
            addCriterion("DScore <", value, "dscore");
            return (Criteria) this;
        }

        public Criteria andDscoreLessThanOrEqualTo(Integer value) {
            addCriterion("DScore <=", value, "dscore");
            return (Criteria) this;
        }

        public Criteria andDscoreIn(List<Integer> values) {
            addCriterion("DScore in", values, "dscore");
            return (Criteria) this;
        }

        public Criteria andDscoreNotIn(List<Integer> values) {
            addCriterion("DScore not in", values, "dscore");
            return (Criteria) this;
        }

        public Criteria andDscoreBetween(Integer value1, Integer value2) {
            addCriterion("DScore between", value1, value2, "dscore");
            return (Criteria) this;
        }

        public Criteria andDscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("DScore not between", value1, value2, "dscore");
            return (Criteria) this;
        }

        public Criteria andDconsubIsNull() {
            addCriterion("DConSub is null");
            return (Criteria) this;
        }

        public Criteria andDconsubIsNotNull() {
            addCriterion("DConSub is not null");
            return (Criteria) this;
        }

        public Criteria andDconsubEqualTo(Integer value) {
            addCriterion("DConSub =", value, "dconsub");
            return (Criteria) this;
        }

        public Criteria andDconsubNotEqualTo(Integer value) {
            addCriterion("DConSub <>", value, "dconsub");
            return (Criteria) this;
        }

        public Criteria andDconsubGreaterThan(Integer value) {
            addCriterion("DConSub >", value, "dconsub");
            return (Criteria) this;
        }

        public Criteria andDconsubGreaterThanOrEqualTo(Integer value) {
            addCriterion("DConSub >=", value, "dconsub");
            return (Criteria) this;
        }

        public Criteria andDconsubLessThan(Integer value) {
            addCriterion("DConSub <", value, "dconsub");
            return (Criteria) this;
        }

        public Criteria andDconsubLessThanOrEqualTo(Integer value) {
            addCriterion("DConSub <=", value, "dconsub");
            return (Criteria) this;
        }

        public Criteria andDconsubIn(List<Integer> values) {
            addCriterion("DConSub in", values, "dconsub");
            return (Criteria) this;
        }

        public Criteria andDconsubNotIn(List<Integer> values) {
            addCriterion("DConSub not in", values, "dconsub");
            return (Criteria) this;
        }

        public Criteria andDconsubBetween(Integer value1, Integer value2) {
            addCriterion("DConSub between", value1, value2, "dconsub");
            return (Criteria) this;
        }

        public Criteria andDconsubNotBetween(Integer value1, Integer value2) {
            addCriterion("DConSub not between", value1, value2, "dconsub");
            return (Criteria) this;
        }

        public Criteria andDwagesIsNull() {
            addCriterion("Dwages is null");
            return (Criteria) this;
        }

        public Criteria andDwagesIsNotNull() {
            addCriterion("Dwages is not null");
            return (Criteria) this;
        }

        public Criteria andDwagesEqualTo(Integer value) {
            addCriterion("Dwages =", value, "dwages");
            return (Criteria) this;
        }

        public Criteria andDwagesNotEqualTo(Integer value) {
            addCriterion("Dwages <>", value, "dwages");
            return (Criteria) this;
        }

        public Criteria andDwagesGreaterThan(Integer value) {
            addCriterion("Dwages >", value, "dwages");
            return (Criteria) this;
        }

        public Criteria andDwagesGreaterThanOrEqualTo(Integer value) {
            addCriterion("Dwages >=", value, "dwages");
            return (Criteria) this;
        }

        public Criteria andDwagesLessThan(Integer value) {
            addCriterion("Dwages <", value, "dwages");
            return (Criteria) this;
        }

        public Criteria andDwagesLessThanOrEqualTo(Integer value) {
            addCriterion("Dwages <=", value, "dwages");
            return (Criteria) this;
        }

        public Criteria andDwagesIn(List<Integer> values) {
            addCriterion("Dwages in", values, "dwages");
            return (Criteria) this;
        }

        public Criteria andDwagesNotIn(List<Integer> values) {
            addCriterion("Dwages not in", values, "dwages");
            return (Criteria) this;
        }

        public Criteria andDwagesBetween(Integer value1, Integer value2) {
            addCriterion("Dwages between", value1, value2, "dwages");
            return (Criteria) this;
        }

        public Criteria andDwagesNotBetween(Integer value1, Integer value2) {
            addCriterion("Dwages not between", value1, value2, "dwages");
            return (Criteria) this;
        }

        public Criteria andSortorderIsNull() {
            addCriterion("SortOrder is null");
            return (Criteria) this;
        }

        public Criteria andSortorderIsNotNull() {
            addCriterion("SortOrder is not null");
            return (Criteria) this;
        }

        public Criteria andSortorderEqualTo(Integer value) {
            addCriterion("SortOrder =", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderNotEqualTo(Integer value) {
            addCriterion("SortOrder <>", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderGreaterThan(Integer value) {
            addCriterion("SortOrder >", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("SortOrder >=", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderLessThan(Integer value) {
            addCriterion("SortOrder <", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderLessThanOrEqualTo(Integer value) {
            addCriterion("SortOrder <=", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderIn(List<Integer> values) {
            addCriterion("SortOrder in", values, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderNotIn(List<Integer> values) {
            addCriterion("SortOrder not in", values, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderBetween(Integer value1, Integer value2) {
            addCriterion("SortOrder between", value1, value2, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderNotBetween(Integer value1, Integer value2) {
            addCriterion("SortOrder not between", value1, value2, "sortorder");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("IsDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("IsDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("IsDelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("IsDelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("IsDelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsDelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("IsDelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("IsDelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("IsDelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("IsDelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("IsDelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("IsDelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIshistoryIsNull() {
            addCriterion("IsHistory is null");
            return (Criteria) this;
        }

        public Criteria andIshistoryIsNotNull() {
            addCriterion("IsHistory is not null");
            return (Criteria) this;
        }

        public Criteria andIshistoryEqualTo(Integer value) {
            addCriterion("IsHistory =", value, "ishistory");
            return (Criteria) this;
        }

        public Criteria andIshistoryNotEqualTo(Integer value) {
            addCriterion("IsHistory <>", value, "ishistory");
            return (Criteria) this;
        }

        public Criteria andIshistoryGreaterThan(Integer value) {
            addCriterion("IsHistory >", value, "ishistory");
            return (Criteria) this;
        }

        public Criteria andIshistoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsHistory >=", value, "ishistory");
            return (Criteria) this;
        }

        public Criteria andIshistoryLessThan(Integer value) {
            addCriterion("IsHistory <", value, "ishistory");
            return (Criteria) this;
        }

        public Criteria andIshistoryLessThanOrEqualTo(Integer value) {
            addCriterion("IsHistory <=", value, "ishistory");
            return (Criteria) this;
        }

        public Criteria andIshistoryIn(List<Integer> values) {
            addCriterion("IsHistory in", values, "ishistory");
            return (Criteria) this;
        }

        public Criteria andIshistoryNotIn(List<Integer> values) {
            addCriterion("IsHistory not in", values, "ishistory");
            return (Criteria) this;
        }

        public Criteria andIshistoryBetween(Integer value1, Integer value2) {
            addCriterion("IsHistory between", value1, value2, "ishistory");
            return (Criteria) this;
        }

        public Criteria andIshistoryNotBetween(Integer value1, Integer value2) {
            addCriterion("IsHistory not between", value1, value2, "ishistory");
            return (Criteria) this;
        }

        public Criteria andCreateridIsNull() {
            addCriterion("CreaterID is null");
            return (Criteria) this;
        }

        public Criteria andCreateridIsNotNull() {
            addCriterion("CreaterID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateridEqualTo(String value) {
            addCriterion("CreaterID =", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotEqualTo(String value) {
            addCriterion("CreaterID <>", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridGreaterThan(String value) {
            addCriterion("CreaterID >", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridGreaterThanOrEqualTo(String value) {
            addCriterion("CreaterID >=", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridLessThan(String value) {
            addCriterion("CreaterID <", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridLessThanOrEqualTo(String value) {
            addCriterion("CreaterID <=", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridLike(String value) {
            addCriterion("CreaterID like", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotLike(String value) {
            addCriterion("CreaterID not like", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridIn(List<String> values) {
            addCriterion("CreaterID in", values, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotIn(List<String> values) {
            addCriterion("CreaterID not in", values, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridBetween(String value1, String value2) {
            addCriterion("CreaterID between", value1, value2, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotBetween(String value1, String value2) {
            addCriterion("CreaterID not between", value1, value2, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andOldidIsNull() {
            addCriterion("OldId is null");
            return (Criteria) this;
        }

        public Criteria andOldidIsNotNull() {
            addCriterion("OldId is not null");
            return (Criteria) this;
        }

        public Criteria andOldidEqualTo(Integer value) {
            addCriterion("OldId =", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidNotEqualTo(Integer value) {
            addCriterion("OldId <>", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidGreaterThan(Integer value) {
            addCriterion("OldId >", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OldId >=", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidLessThan(Integer value) {
            addCriterion("OldId <", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidLessThanOrEqualTo(Integer value) {
            addCriterion("OldId <=", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidIn(List<Integer> values) {
            addCriterion("OldId in", values, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidNotIn(List<Integer> values) {
            addCriterion("OldId not in", values, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidBetween(Integer value1, Integer value2) {
            addCriterion("OldId between", value1, value2, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidNotBetween(Integer value1, Integer value2) {
            addCriterion("OldId not between", value1, value2, "oldid");
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