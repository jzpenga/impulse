package com.msp.impulse.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControlinstruExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ControlinstruExample() {
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

        public Criteria andDealStatusIsNull() {
            addCriterion("deal_status is null");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNotNull() {
            addCriterion("deal_status is not null");
            return (Criteria) this;
        }

        public Criteria andDealStatusEqualTo(String value) {
            addCriterion("deal_status =", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotEqualTo(String value) {
            addCriterion("deal_status <>", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThan(String value) {
            addCriterion("deal_status >", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThanOrEqualTo(String value) {
            addCriterion("deal_status >=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThan(String value) {
            addCriterion("deal_status <", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThanOrEqualTo(String value) {
            addCriterion("deal_status <=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLike(String value) {
            addCriterion("deal_status like", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotLike(String value) {
            addCriterion("deal_status not like", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusIn(List<String> values) {
            addCriterion("deal_status in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotIn(List<String> values) {
            addCriterion("deal_status not in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusBetween(String value1, String value2) {
            addCriterion("deal_status between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotBetween(String value1, String value2) {
            addCriterion("deal_status not between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNull() {
            addCriterion("return_status is null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNotNull() {
            addCriterion("return_status is not null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusEqualTo(String value) {
            addCriterion("return_status =", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotEqualTo(String value) {
            addCriterion("return_status <>", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThan(String value) {
            addCriterion("return_status >", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThanOrEqualTo(String value) {
            addCriterion("return_status >=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThan(String value) {
            addCriterion("return_status <", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThanOrEqualTo(String value) {
            addCriterion("return_status <=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLike(String value) {
            addCriterion("return_status like", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotLike(String value) {
            addCriterion("return_status not like", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIn(List<String> values) {
            addCriterion("return_status in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotIn(List<String> values) {
            addCriterion("return_status not in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusBetween(String value1, String value2) {
            addCriterion("return_status between", value1, value2, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotBetween(String value1, String value2) {
            addCriterion("return_status not between", value1, value2, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andDownTimeIsNull() {
            addCriterion("down_time is null");
            return (Criteria) this;
        }

        public Criteria andDownTimeIsNotNull() {
            addCriterion("down_time is not null");
            return (Criteria) this;
        }

        public Criteria andDownTimeEqualTo(Date value) {
            addCriterion("down_time =", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotEqualTo(Date value) {
            addCriterion("down_time <>", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeGreaterThan(Date value) {
            addCriterion("down_time >", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("down_time >=", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeLessThan(Date value) {
            addCriterion("down_time <", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeLessThanOrEqualTo(Date value) {
            addCriterion("down_time <=", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeIn(List<Date> values) {
            addCriterion("down_time in", values, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotIn(List<Date> values) {
            addCriterion("down_time not in", values, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeBetween(Date value1, Date value2) {
            addCriterion("down_time between", value1, value2, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotBetween(Date value1, Date value2) {
            addCriterion("down_time not between", value1, value2, "downTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIsNull() {
            addCriterion("execute_time is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIsNotNull() {
            addCriterion("execute_time is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeEqualTo(Date value) {
            addCriterion("execute_time =", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotEqualTo(Date value) {
            addCriterion("execute_time <>", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeGreaterThan(Date value) {
            addCriterion("execute_time >", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("execute_time >=", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeLessThan(Date value) {
            addCriterion("execute_time <", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeLessThanOrEqualTo(Date value) {
            addCriterion("execute_time <=", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIn(List<Date> values) {
            addCriterion("execute_time in", values, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotIn(List<Date> values) {
            addCriterion("execute_time not in", values, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeBetween(Date value1, Date value2) {
            addCriterion("execute_time between", value1, value2, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotBetween(Date value1, Date value2) {
            addCriterion("execute_time not between", value1, value2, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExtraMessageIsNull() {
            addCriterion("extra_message is null");
            return (Criteria) this;
        }

        public Criteria andExtraMessageIsNotNull() {
            addCriterion("extra_message is not null");
            return (Criteria) this;
        }

        public Criteria andExtraMessageEqualTo(String value) {
            addCriterion("extra_message =", value, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageNotEqualTo(String value) {
            addCriterion("extra_message <>", value, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageGreaterThan(String value) {
            addCriterion("extra_message >", value, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageGreaterThanOrEqualTo(String value) {
            addCriterion("extra_message >=", value, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageLessThan(String value) {
            addCriterion("extra_message <", value, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageLessThanOrEqualTo(String value) {
            addCriterion("extra_message <=", value, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageLike(String value) {
            addCriterion("extra_message like", value, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageNotLike(String value) {
            addCriterion("extra_message not like", value, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageIn(List<String> values) {
            addCriterion("extra_message in", values, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageNotIn(List<String> values) {
            addCriterion("extra_message not in", values, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageBetween(String value1, String value2) {
            addCriterion("extra_message between", value1, value2, "extraMessage");
            return (Criteria) this;
        }

        public Criteria andExtraMessageNotBetween(String value1, String value2) {
            addCriterion("extra_message not between", value1, value2, "extraMessage");
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

        public Criteria andWayNoIsNull() {
            addCriterion("way_no is null");
            return (Criteria) this;
        }

        public Criteria andWayNoIsNotNull() {
            addCriterion("way_no is not null");
            return (Criteria) this;
        }

        public Criteria andWayNoEqualTo(Integer value) {
            addCriterion("way_no =", value, "wayNo");
            return (Criteria) this;
        }

        public Criteria andWayNoNotEqualTo(Integer value) {
            addCriterion("way_no <>", value, "wayNo");
            return (Criteria) this;
        }

        public Criteria andWayNoGreaterThan(Integer value) {
            addCriterion("way_no >", value, "wayNo");
            return (Criteria) this;
        }

        public Criteria andWayNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("way_no >=", value, "wayNo");
            return (Criteria) this;
        }

        public Criteria andWayNoLessThan(Integer value) {
            addCriterion("way_no <", value, "wayNo");
            return (Criteria) this;
        }

        public Criteria andWayNoLessThanOrEqualTo(Integer value) {
            addCriterion("way_no <=", value, "wayNo");
            return (Criteria) this;
        }

        public Criteria andWayNoIn(List<Integer> values) {
            addCriterion("way_no in", values, "wayNo");
            return (Criteria) this;
        }

        public Criteria andWayNoNotIn(List<Integer> values) {
            addCriterion("way_no not in", values, "wayNo");
            return (Criteria) this;
        }

        public Criteria andWayNoBetween(Integer value1, Integer value2) {
            addCriterion("way_no between", value1, value2, "wayNo");
            return (Criteria) this;
        }

        public Criteria andWayNoNotBetween(Integer value1, Integer value2) {
            addCriterion("way_no not between", value1, value2, "wayNo");
            return (Criteria) this;
        }

        public Criteria andFinalStatusIsNull() {
            addCriterion("final_status is null");
            return (Criteria) this;
        }

        public Criteria andFinalStatusIsNotNull() {
            addCriterion("final_status is not null");
            return (Criteria) this;
        }

        public Criteria andFinalStatusEqualTo(String value) {
            addCriterion("final_status =", value, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusNotEqualTo(String value) {
            addCriterion("final_status <>", value, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusGreaterThan(String value) {
            addCriterion("final_status >", value, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("final_status >=", value, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusLessThan(String value) {
            addCriterion("final_status <", value, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusLessThanOrEqualTo(String value) {
            addCriterion("final_status <=", value, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusLike(String value) {
            addCriterion("final_status like", value, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusNotLike(String value) {
            addCriterion("final_status not like", value, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusIn(List<String> values) {
            addCriterion("final_status in", values, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusNotIn(List<String> values) {
            addCriterion("final_status not in", values, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusBetween(String value1, String value2) {
            addCriterion("final_status between", value1, value2, "finalStatus");
            return (Criteria) this;
        }

        public Criteria andFinalStatusNotBetween(String value1, String value2) {
            addCriterion("final_status not between", value1, value2, "finalStatus");
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

        public Criteria andRelayIdIsNull() {
            addCriterion("relay_id is null");
            return (Criteria) this;
        }

        public Criteria andRelayIdIsNotNull() {
            addCriterion("relay_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelayIdEqualTo(Integer value) {
            addCriterion("relay_id =", value, "relayId");
            return (Criteria) this;
        }

        public Criteria andRelayIdNotEqualTo(Integer value) {
            addCriterion("relay_id <>", value, "relayId");
            return (Criteria) this;
        }

        public Criteria andRelayIdGreaterThan(Integer value) {
            addCriterion("relay_id >", value, "relayId");
            return (Criteria) this;
        }

        public Criteria andRelayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("relay_id >=", value, "relayId");
            return (Criteria) this;
        }

        public Criteria andRelayIdLessThan(Integer value) {
            addCriterion("relay_id <", value, "relayId");
            return (Criteria) this;
        }

        public Criteria andRelayIdLessThanOrEqualTo(Integer value) {
            addCriterion("relay_id <=", value, "relayId");
            return (Criteria) this;
        }

        public Criteria andRelayIdIn(List<Integer> values) {
            addCriterion("relay_id in", values, "relayId");
            return (Criteria) this;
        }

        public Criteria andRelayIdNotIn(List<Integer> values) {
            addCriterion("relay_id not in", values, "relayId");
            return (Criteria) this;
        }

        public Criteria andRelayIdBetween(Integer value1, Integer value2) {
            addCriterion("relay_id between", value1, value2, "relayId");
            return (Criteria) this;
        }

        public Criteria andRelayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("relay_id not between", value1, value2, "relayId");
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