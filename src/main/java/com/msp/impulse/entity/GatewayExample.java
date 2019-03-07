package com.msp.impulse.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GatewayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GatewayExample() {
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

        public Criteria andGatewayNameIsNull() {
            addCriterion("gateway_name is null");
            return (Criteria) this;
        }

        public Criteria andGatewayNameIsNotNull() {
            addCriterion("gateway_name is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayNameEqualTo(String value) {
            addCriterion("gateway_name =", value, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameNotEqualTo(String value) {
            addCriterion("gateway_name <>", value, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameGreaterThan(String value) {
            addCriterion("gateway_name >", value, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameGreaterThanOrEqualTo(String value) {
            addCriterion("gateway_name >=", value, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameLessThan(String value) {
            addCriterion("gateway_name <", value, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameLessThanOrEqualTo(String value) {
            addCriterion("gateway_name <=", value, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameLike(String value) {
            addCriterion("gateway_name like", value, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameNotLike(String value) {
            addCriterion("gateway_name not like", value, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameIn(List<String> values) {
            addCriterion("gateway_name in", values, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameNotIn(List<String> values) {
            addCriterion("gateway_name not in", values, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameBetween(String value1, String value2) {
            addCriterion("gateway_name between", value1, value2, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNameNotBetween(String value1, String value2) {
            addCriterion("gateway_name not between", value1, value2, "gatewayName");
            return (Criteria) this;
        }

        public Criteria andGatewayNoIsNull() {
            addCriterion("gateway_no is null");
            return (Criteria) this;
        }

        public Criteria andGatewayNoIsNotNull() {
            addCriterion("gateway_no is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayNoEqualTo(Integer value) {
            addCriterion("gateway_no =", value, "gatewayNo");
            return (Criteria) this;
        }

        public Criteria andGatewayNoNotEqualTo(Integer value) {
            addCriterion("gateway_no <>", value, "gatewayNo");
            return (Criteria) this;
        }

        public Criteria andGatewayNoGreaterThan(Integer value) {
            addCriterion("gateway_no >", value, "gatewayNo");
            return (Criteria) this;
        }

        public Criteria andGatewayNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("gateway_no >=", value, "gatewayNo");
            return (Criteria) this;
        }

        public Criteria andGatewayNoLessThan(Integer value) {
            addCriterion("gateway_no <", value, "gatewayNo");
            return (Criteria) this;
        }

        public Criteria andGatewayNoLessThanOrEqualTo(Integer value) {
            addCriterion("gateway_no <=", value, "gatewayNo");
            return (Criteria) this;
        }

        public Criteria andGatewayNoIn(List<Integer> values) {
            addCriterion("gateway_no in", values, "gatewayNo");
            return (Criteria) this;
        }

        public Criteria andGatewayNoNotIn(List<Integer> values) {
            addCriterion("gateway_no not in", values, "gatewayNo");
            return (Criteria) this;
        }

        public Criteria andGatewayNoBetween(Integer value1, Integer value2) {
            addCriterion("gateway_no between", value1, value2, "gatewayNo");
            return (Criteria) this;
        }

        public Criteria andGatewayNoNotBetween(Integer value1, Integer value2) {
            addCriterion("gateway_no not between", value1, value2, "gatewayNo");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeIsNull() {
            addCriterion("gateway_type is null");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeIsNotNull() {
            addCriterion("gateway_type is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeEqualTo(String value) {
            addCriterion("gateway_type =", value, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeNotEqualTo(String value) {
            addCriterion("gateway_type <>", value, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeGreaterThan(String value) {
            addCriterion("gateway_type >", value, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("gateway_type >=", value, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeLessThan(String value) {
            addCriterion("gateway_type <", value, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeLessThanOrEqualTo(String value) {
            addCriterion("gateway_type <=", value, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeLike(String value) {
            addCriterion("gateway_type like", value, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeNotLike(String value) {
            addCriterion("gateway_type not like", value, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeIn(List<String> values) {
            addCriterion("gateway_type in", values, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeNotIn(List<String> values) {
            addCriterion("gateway_type not in", values, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeBetween(String value1, String value2) {
            addCriterion("gateway_type between", value1, value2, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayTypeNotBetween(String value1, String value2) {
            addCriterion("gateway_type not between", value1, value2, "gatewayType");
            return (Criteria) this;
        }

        public Criteria andGatewayModelIsNull() {
            addCriterion("gateway_model is null");
            return (Criteria) this;
        }

        public Criteria andGatewayModelIsNotNull() {
            addCriterion("gateway_model is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayModelEqualTo(String value) {
            addCriterion("gateway_model =", value, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelNotEqualTo(String value) {
            addCriterion("gateway_model <>", value, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelGreaterThan(String value) {
            addCriterion("gateway_model >", value, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelGreaterThanOrEqualTo(String value) {
            addCriterion("gateway_model >=", value, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelLessThan(String value) {
            addCriterion("gateway_model <", value, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelLessThanOrEqualTo(String value) {
            addCriterion("gateway_model <=", value, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelLike(String value) {
            addCriterion("gateway_model like", value, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelNotLike(String value) {
            addCriterion("gateway_model not like", value, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelIn(List<String> values) {
            addCriterion("gateway_model in", values, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelNotIn(List<String> values) {
            addCriterion("gateway_model not in", values, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelBetween(String value1, String value2) {
            addCriterion("gateway_model between", value1, value2, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andGatewayModelNotBetween(String value1, String value2) {
            addCriterion("gateway_model not between", value1, value2, "gatewayModel");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andWorkModelIsNull() {
            addCriterion("work_model is null");
            return (Criteria) this;
        }

        public Criteria andWorkModelIsNotNull() {
            addCriterion("work_model is not null");
            return (Criteria) this;
        }

        public Criteria andWorkModelEqualTo(String value) {
            addCriterion("work_model =", value, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelNotEqualTo(String value) {
            addCriterion("work_model <>", value, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelGreaterThan(String value) {
            addCriterion("work_model >", value, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelGreaterThanOrEqualTo(String value) {
            addCriterion("work_model >=", value, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelLessThan(String value) {
            addCriterion("work_model <", value, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelLessThanOrEqualTo(String value) {
            addCriterion("work_model <=", value, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelLike(String value) {
            addCriterion("work_model like", value, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelNotLike(String value) {
            addCriterion("work_model not like", value, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelIn(List<String> values) {
            addCriterion("work_model in", values, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelNotIn(List<String> values) {
            addCriterion("work_model not in", values, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelBetween(String value1, String value2) {
            addCriterion("work_model between", value1, value2, "workModel");
            return (Criteria) this;
        }

        public Criteria andWorkModelNotBetween(String value1, String value2) {
            addCriterion("work_model not between", value1, value2, "workModel");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPollPeriodIsNull() {
            addCriterion("poll_period is null");
            return (Criteria) this;
        }

        public Criteria andPollPeriodIsNotNull() {
            addCriterion("poll_period is not null");
            return (Criteria) this;
        }

        public Criteria andPollPeriodEqualTo(String value) {
            addCriterion("poll_period =", value, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodNotEqualTo(String value) {
            addCriterion("poll_period <>", value, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodGreaterThan(String value) {
            addCriterion("poll_period >", value, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("poll_period >=", value, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodLessThan(String value) {
            addCriterion("poll_period <", value, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodLessThanOrEqualTo(String value) {
            addCriterion("poll_period <=", value, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodLike(String value) {
            addCriterion("poll_period like", value, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodNotLike(String value) {
            addCriterion("poll_period not like", value, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodIn(List<String> values) {
            addCriterion("poll_period in", values, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodNotIn(List<String> values) {
            addCriterion("poll_period not in", values, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodBetween(String value1, String value2) {
            addCriterion("poll_period between", value1, value2, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andPollPeriodNotBetween(String value1, String value2) {
            addCriterion("poll_period not between", value1, value2, "pollPeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodIsNull() {
            addCriterion("overtime_period is null");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodIsNotNull() {
            addCriterion("overtime_period is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodEqualTo(String value) {
            addCriterion("overtime_period =", value, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodNotEqualTo(String value) {
            addCriterion("overtime_period <>", value, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodGreaterThan(String value) {
            addCriterion("overtime_period >", value, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodGreaterThanOrEqualTo(String value) {
            addCriterion("overtime_period >=", value, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodLessThan(String value) {
            addCriterion("overtime_period <", value, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodLessThanOrEqualTo(String value) {
            addCriterion("overtime_period <=", value, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodLike(String value) {
            addCriterion("overtime_period like", value, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodNotLike(String value) {
            addCriterion("overtime_period not like", value, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodIn(List<String> values) {
            addCriterion("overtime_period in", values, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodNotIn(List<String> values) {
            addCriterion("overtime_period not in", values, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodBetween(String value1, String value2) {
            addCriterion("overtime_period between", value1, value2, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andOvertimePeriodNotBetween(String value1, String value2) {
            addCriterion("overtime_period not between", value1, value2, "overtimePeriod");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNull() {
            addCriterion("work_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNotNull() {
            addCriterion("work_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusEqualTo(String value) {
            addCriterion("work_status =", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotEqualTo(String value) {
            addCriterion("work_status <>", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThan(String value) {
            addCriterion("work_status >", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThanOrEqualTo(String value) {
            addCriterion("work_status >=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThan(String value) {
            addCriterion("work_status <", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThanOrEqualTo(String value) {
            addCriterion("work_status <=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLike(String value) {
            addCriterion("work_status like", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotLike(String value) {
            addCriterion("work_status not like", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIn(List<String> values) {
            addCriterion("work_status in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotIn(List<String> values) {
            addCriterion("work_status not in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusBetween(String value1, String value2) {
            addCriterion("work_status between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotBetween(String value1, String value2) {
            addCriterion("work_status not between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNull() {
            addCriterion("login_name is null");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNotNull() {
            addCriterion("login_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNameEqualTo(String value) {
            addCriterion("login_name =", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotEqualTo(String value) {
            addCriterion("login_name <>", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThan(String value) {
            addCriterion("login_name >", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("login_name >=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThan(String value) {
            addCriterion("login_name <", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("login_name <=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLike(String value) {
            addCriterion("login_name like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotLike(String value) {
            addCriterion("login_name not like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameIn(List<String> values) {
            addCriterion("login_name in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotIn(List<String> values) {
            addCriterion("login_name not in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameBetween(String value1, String value2) {
            addCriterion("login_name between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotBetween(String value1, String value2) {
            addCriterion("login_name not between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Integer value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Integer value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Integer value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Integer value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Integer value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Integer> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Integer> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Integer value1, Integer value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Integer value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Integer value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Integer value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Integer value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Integer value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Integer> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Integer> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Integer value1, Integer value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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