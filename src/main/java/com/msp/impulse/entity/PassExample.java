package com.msp.impulse.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PassExample() {
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

        public Criteria andPassNoIsNull() {
            addCriterion("pass_no is null");
            return (Criteria) this;
        }

        public Criteria andPassNoIsNotNull() {
            addCriterion("pass_no is not null");
            return (Criteria) this;
        }

        public Criteria andPassNoEqualTo(Integer value) {
            addCriterion("pass_no =", value, "passNo");
            return (Criteria) this;
        }

        public Criteria andPassNoNotEqualTo(Integer value) {
            addCriterion("pass_no <>", value, "passNo");
            return (Criteria) this;
        }

        public Criteria andPassNoGreaterThan(Integer value) {
            addCriterion("pass_no >", value, "passNo");
            return (Criteria) this;
        }

        public Criteria andPassNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("pass_no >=", value, "passNo");
            return (Criteria) this;
        }

        public Criteria andPassNoLessThan(Integer value) {
            addCriterion("pass_no <", value, "passNo");
            return (Criteria) this;
        }

        public Criteria andPassNoLessThanOrEqualTo(Integer value) {
            addCriterion("pass_no <=", value, "passNo");
            return (Criteria) this;
        }

        public Criteria andPassNoIn(List<Integer> values) {
            addCriterion("pass_no in", values, "passNo");
            return (Criteria) this;
        }

        public Criteria andPassNoNotIn(List<Integer> values) {
            addCriterion("pass_no not in", values, "passNo");
            return (Criteria) this;
        }

        public Criteria andPassNoBetween(Integer value1, Integer value2) {
            addCriterion("pass_no between", value1, value2, "passNo");
            return (Criteria) this;
        }

        public Criteria andPassNoNotBetween(Integer value1, Integer value2) {
            addCriterion("pass_no not between", value1, value2, "passNo");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilIsNull() {
            addCriterion("alarm_ceil is null");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilIsNotNull() {
            addCriterion("alarm_ceil is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilEqualTo(String value) {
            addCriterion("alarm_ceil =", value, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilNotEqualTo(String value) {
            addCriterion("alarm_ceil <>", value, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilGreaterThan(String value) {
            addCriterion("alarm_ceil >", value, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_ceil >=", value, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilLessThan(String value) {
            addCriterion("alarm_ceil <", value, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilLessThanOrEqualTo(String value) {
            addCriterion("alarm_ceil <=", value, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilLike(String value) {
            addCriterion("alarm_ceil like", value, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilNotLike(String value) {
            addCriterion("alarm_ceil not like", value, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilIn(List<String> values) {
            addCriterion("alarm_ceil in", values, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilNotIn(List<String> values) {
            addCriterion("alarm_ceil not in", values, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilBetween(String value1, String value2) {
            addCriterion("alarm_ceil between", value1, value2, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmCeilNotBetween(String value1, String value2) {
            addCriterion("alarm_ceil not between", value1, value2, "alarmCeil");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorIsNull() {
            addCriterion("alarm_floor is null");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorIsNotNull() {
            addCriterion("alarm_floor is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorEqualTo(String value) {
            addCriterion("alarm_floor =", value, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorNotEqualTo(String value) {
            addCriterion("alarm_floor <>", value, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorGreaterThan(String value) {
            addCriterion("alarm_floor >", value, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_floor >=", value, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorLessThan(String value) {
            addCriterion("alarm_floor <", value, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorLessThanOrEqualTo(String value) {
            addCriterion("alarm_floor <=", value, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorLike(String value) {
            addCriterion("alarm_floor like", value, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorNotLike(String value) {
            addCriterion("alarm_floor not like", value, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorIn(List<String> values) {
            addCriterion("alarm_floor in", values, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorNotIn(List<String> values) {
            addCriterion("alarm_floor not in", values, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorBetween(String value1, String value2) {
            addCriterion("alarm_floor between", value1, value2, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andAlarmFloorNotBetween(String value1, String value2) {
            addCriterion("alarm_floor not between", value1, value2, "alarmFloor");
            return (Criteria) this;
        }

        public Criteria andCeilStatusIsNull() {
            addCriterion("ceil_status is null");
            return (Criteria) this;
        }

        public Criteria andCeilStatusIsNotNull() {
            addCriterion("ceil_status is not null");
            return (Criteria) this;
        }

        public Criteria andCeilStatusEqualTo(String value) {
            addCriterion("ceil_status =", value, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusNotEqualTo(String value) {
            addCriterion("ceil_status <>", value, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusGreaterThan(String value) {
            addCriterion("ceil_status >", value, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ceil_status >=", value, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusLessThan(String value) {
            addCriterion("ceil_status <", value, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusLessThanOrEqualTo(String value) {
            addCriterion("ceil_status <=", value, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusLike(String value) {
            addCriterion("ceil_status like", value, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusNotLike(String value) {
            addCriterion("ceil_status not like", value, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusIn(List<String> values) {
            addCriterion("ceil_status in", values, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusNotIn(List<String> values) {
            addCriterion("ceil_status not in", values, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusBetween(String value1, String value2) {
            addCriterion("ceil_status between", value1, value2, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andCeilStatusNotBetween(String value1, String value2) {
            addCriterion("ceil_status not between", value1, value2, "ceilStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusIsNull() {
            addCriterion("floor_status is null");
            return (Criteria) this;
        }

        public Criteria andFloorStatusIsNotNull() {
            addCriterion("floor_status is not null");
            return (Criteria) this;
        }

        public Criteria andFloorStatusEqualTo(String value) {
            addCriterion("floor_status =", value, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusNotEqualTo(String value) {
            addCriterion("floor_status <>", value, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusGreaterThan(String value) {
            addCriterion("floor_status >", value, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusGreaterThanOrEqualTo(String value) {
            addCriterion("floor_status >=", value, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusLessThan(String value) {
            addCriterion("floor_status <", value, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusLessThanOrEqualTo(String value) {
            addCriterion("floor_status <=", value, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusLike(String value) {
            addCriterion("floor_status like", value, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusNotLike(String value) {
            addCriterion("floor_status not like", value, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusIn(List<String> values) {
            addCriterion("floor_status in", values, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusNotIn(List<String> values) {
            addCriterion("floor_status not in", values, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusBetween(String value1, String value2) {
            addCriterion("floor_status between", value1, value2, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andFloorStatusNotBetween(String value1, String value2) {
            addCriterion("floor_status not between", value1, value2, "floorStatus");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroIsNull() {
            addCriterion("analog_zero is null");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroIsNotNull() {
            addCriterion("analog_zero is not null");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroEqualTo(String value) {
            addCriterion("analog_zero =", value, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroNotEqualTo(String value) {
            addCriterion("analog_zero <>", value, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroGreaterThan(String value) {
            addCriterion("analog_zero >", value, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroGreaterThanOrEqualTo(String value) {
            addCriterion("analog_zero >=", value, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroLessThan(String value) {
            addCriterion("analog_zero <", value, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroLessThanOrEqualTo(String value) {
            addCriterion("analog_zero <=", value, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroLike(String value) {
            addCriterion("analog_zero like", value, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroNotLike(String value) {
            addCriterion("analog_zero not like", value, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroIn(List<String> values) {
            addCriterion("analog_zero in", values, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroNotIn(List<String> values) {
            addCriterion("analog_zero not in", values, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroBetween(String value1, String value2) {
            addCriterion("analog_zero between", value1, value2, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogZeroNotBetween(String value1, String value2) {
            addCriterion("analog_zero not between", value1, value2, "analogZero");
            return (Criteria) this;
        }

        public Criteria andAnalogFullIsNull() {
            addCriterion("analog_full is null");
            return (Criteria) this;
        }

        public Criteria andAnalogFullIsNotNull() {
            addCriterion("analog_full is not null");
            return (Criteria) this;
        }

        public Criteria andAnalogFullEqualTo(String value) {
            addCriterion("analog_full =", value, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullNotEqualTo(String value) {
            addCriterion("analog_full <>", value, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullGreaterThan(String value) {
            addCriterion("analog_full >", value, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullGreaterThanOrEqualTo(String value) {
            addCriterion("analog_full >=", value, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullLessThan(String value) {
            addCriterion("analog_full <", value, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullLessThanOrEqualTo(String value) {
            addCriterion("analog_full <=", value, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullLike(String value) {
            addCriterion("analog_full like", value, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullNotLike(String value) {
            addCriterion("analog_full not like", value, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullIn(List<String> values) {
            addCriterion("analog_full in", values, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullNotIn(List<String> values) {
            addCriterion("analog_full not in", values, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullBetween(String value1, String value2) {
            addCriterion("analog_full between", value1, value2, "analogFull");
            return (Criteria) this;
        }

        public Criteria andAnalogFullNotBetween(String value1, String value2) {
            addCriterion("analog_full not between", value1, value2, "analogFull");
            return (Criteria) this;
        }

        public Criteria andSensorZeroIsNull() {
            addCriterion("sensor_zero is null");
            return (Criteria) this;
        }

        public Criteria andSensorZeroIsNotNull() {
            addCriterion("sensor_zero is not null");
            return (Criteria) this;
        }

        public Criteria andSensorZeroEqualTo(String value) {
            addCriterion("sensor_zero =", value, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroNotEqualTo(String value) {
            addCriterion("sensor_zero <>", value, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroGreaterThan(String value) {
            addCriterion("sensor_zero >", value, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_zero >=", value, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroLessThan(String value) {
            addCriterion("sensor_zero <", value, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroLessThanOrEqualTo(String value) {
            addCriterion("sensor_zero <=", value, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroLike(String value) {
            addCriterion("sensor_zero like", value, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroNotLike(String value) {
            addCriterion("sensor_zero not like", value, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroIn(List<String> values) {
            addCriterion("sensor_zero in", values, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroNotIn(List<String> values) {
            addCriterion("sensor_zero not in", values, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroBetween(String value1, String value2) {
            addCriterion("sensor_zero between", value1, value2, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorZeroNotBetween(String value1, String value2) {
            addCriterion("sensor_zero not between", value1, value2, "sensorZero");
            return (Criteria) this;
        }

        public Criteria andSensorFullIsNull() {
            addCriterion("sensor_full is null");
            return (Criteria) this;
        }

        public Criteria andSensorFullIsNotNull() {
            addCriterion("sensor_full is not null");
            return (Criteria) this;
        }

        public Criteria andSensorFullEqualTo(String value) {
            addCriterion("sensor_full =", value, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullNotEqualTo(String value) {
            addCriterion("sensor_full <>", value, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullGreaterThan(String value) {
            addCriterion("sensor_full >", value, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_full >=", value, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullLessThan(String value) {
            addCriterion("sensor_full <", value, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullLessThanOrEqualTo(String value) {
            addCriterion("sensor_full <=", value, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullLike(String value) {
            addCriterion("sensor_full like", value, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullNotLike(String value) {
            addCriterion("sensor_full not like", value, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullIn(List<String> values) {
            addCriterion("sensor_full in", values, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullNotIn(List<String> values) {
            addCriterion("sensor_full not in", values, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullBetween(String value1, String value2) {
            addCriterion("sensor_full between", value1, value2, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andSensorFullNotBetween(String value1, String value2) {
            addCriterion("sensor_full not between", value1, value2, "sensorFull");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesIsNull() {
            addCriterion("decimal_places is null");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesIsNotNull() {
            addCriterion("decimal_places is not null");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesEqualTo(String value) {
            addCriterion("decimal_places =", value, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesNotEqualTo(String value) {
            addCriterion("decimal_places <>", value, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesGreaterThan(String value) {
            addCriterion("decimal_places >", value, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesGreaterThanOrEqualTo(String value) {
            addCriterion("decimal_places >=", value, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesLessThan(String value) {
            addCriterion("decimal_places <", value, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesLessThanOrEqualTo(String value) {
            addCriterion("decimal_places <=", value, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesLike(String value) {
            addCriterion("decimal_places like", value, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesNotLike(String value) {
            addCriterion("decimal_places not like", value, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesIn(List<String> values) {
            addCriterion("decimal_places in", values, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesNotIn(List<String> values) {
            addCriterion("decimal_places not in", values, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesBetween(String value1, String value2) {
            addCriterion("decimal_places between", value1, value2, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andDecimalPlacesNotBetween(String value1, String value2) {
            addCriterion("decimal_places not between", value1, value2, "decimalPlaces");
            return (Criteria) this;
        }

        public Criteria andGatewayIdIsNull() {
            addCriterion("gateway_id is null");
            return (Criteria) this;
        }

        public Criteria andGatewayIdIsNotNull() {
            addCriterion("gateway_id is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayIdEqualTo(Integer value) {
            addCriterion("gateway_id =", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotEqualTo(Integer value) {
            addCriterion("gateway_id <>", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdGreaterThan(Integer value) {
            addCriterion("gateway_id >", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gateway_id >=", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdLessThan(Integer value) {
            addCriterion("gateway_id <", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdLessThanOrEqualTo(Integer value) {
            addCriterion("gateway_id <=", value, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdIn(List<Integer> values) {
            addCriterion("gateway_id in", values, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotIn(List<Integer> values) {
            addCriterion("gateway_id not in", values, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdBetween(Integer value1, Integer value2) {
            addCriterion("gateway_id between", value1, value2, "gatewayId");
            return (Criteria) this;
        }

        public Criteria andGatewayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gateway_id not between", value1, value2, "gatewayId");
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

        public Criteria andSensorIdIsNull() {
            addCriterion("sensor_id is null");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNotNull() {
            addCriterion("sensor_id is not null");
            return (Criteria) this;
        }

        public Criteria andSensorIdEqualTo(Integer value) {
            addCriterion("sensor_id =", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotEqualTo(Integer value) {
            addCriterion("sensor_id <>", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThan(Integer value) {
            addCriterion("sensor_id >", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sensor_id >=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThan(Integer value) {
            addCriterion("sensor_id <", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThanOrEqualTo(Integer value) {
            addCriterion("sensor_id <=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdIn(List<Integer> values) {
            addCriterion("sensor_id in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotIn(List<Integer> values) {
            addCriterion("sensor_id not in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdBetween(Integer value1, Integer value2) {
            addCriterion("sensor_id between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sensor_id not between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorNameIsNull() {
            addCriterion("sensor_name is null");
            return (Criteria) this;
        }

        public Criteria andSensorNameIsNotNull() {
            addCriterion("sensor_name is not null");
            return (Criteria) this;
        }

        public Criteria andSensorNameEqualTo(String value) {
            addCriterion("sensor_name =", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotEqualTo(String value) {
            addCriterion("sensor_name <>", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameGreaterThan(String value) {
            addCriterion("sensor_name >", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_name >=", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameLessThan(String value) {
            addCriterion("sensor_name <", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameLessThanOrEqualTo(String value) {
            addCriterion("sensor_name <=", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameLike(String value) {
            addCriterion("sensor_name like", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotLike(String value) {
            addCriterion("sensor_name not like", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameIn(List<String> values) {
            addCriterion("sensor_name in", values, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotIn(List<String> values) {
            addCriterion("sensor_name not in", values, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameBetween(String value1, String value2) {
            addCriterion("sensor_name between", value1, value2, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotBetween(String value1, String value2) {
            addCriterion("sensor_name not between", value1, value2, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensingTypeIsNull() {
            addCriterion("\"sensing type\" is null");
            return (Criteria) this;
        }

        public Criteria andSensingTypeIsNotNull() {
            addCriterion("\"sensing type\" is not null");
            return (Criteria) this;
        }

        public Criteria andSensingTypeEqualTo(String value) {
            addCriterion("\"sensing type\" =", value, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeNotEqualTo(String value) {
            addCriterion("\"sensing type\" <>", value, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeGreaterThan(String value) {
            addCriterion("\"sensing type\" >", value, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("\"sensing type\" >=", value, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeLessThan(String value) {
            addCriterion("\"sensing type\" <", value, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeLessThanOrEqualTo(String value) {
            addCriterion("\"sensing type\" <=", value, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeLike(String value) {
            addCriterion("\"sensing type\" like", value, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeNotLike(String value) {
            addCriterion("\"sensing type\" not like", value, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeIn(List<String> values) {
            addCriterion("\"sensing type\" in", values, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeNotIn(List<String> values) {
            addCriterion("\"sensing type\" not in", values, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeBetween(String value1, String value2) {
            addCriterion("\"sensing type\" between", value1, value2, "sensingType");
            return (Criteria) this;
        }

        public Criteria andSensingTypeNotBetween(String value1, String value2) {
            addCriterion("\"sensing type\" not between", value1, value2, "sensingType");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andExtPassIdIsNull() {
            addCriterion("ext_pass_id is null");
            return (Criteria) this;
        }

        public Criteria andExtPassIdIsNotNull() {
            addCriterion("ext_pass_id is not null");
            return (Criteria) this;
        }

        public Criteria andExtPassIdEqualTo(Integer value) {
            addCriterion("ext_pass_id =", value, "extPassId");
            return (Criteria) this;
        }

        public Criteria andExtPassIdNotEqualTo(Integer value) {
            addCriterion("ext_pass_id <>", value, "extPassId");
            return (Criteria) this;
        }

        public Criteria andExtPassIdGreaterThan(Integer value) {
            addCriterion("ext_pass_id >", value, "extPassId");
            return (Criteria) this;
        }

        public Criteria andExtPassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ext_pass_id >=", value, "extPassId");
            return (Criteria) this;
        }

        public Criteria andExtPassIdLessThan(Integer value) {
            addCriterion("ext_pass_id <", value, "extPassId");
            return (Criteria) this;
        }

        public Criteria andExtPassIdLessThanOrEqualTo(Integer value) {
            addCriterion("ext_pass_id <=", value, "extPassId");
            return (Criteria) this;
        }

        public Criteria andExtPassIdIn(List<Integer> values) {
            addCriterion("ext_pass_id in", values, "extPassId");
            return (Criteria) this;
        }

        public Criteria andExtPassIdNotIn(List<Integer> values) {
            addCriterion("ext_pass_id not in", values, "extPassId");
            return (Criteria) this;
        }

        public Criteria andExtPassIdBetween(Integer value1, Integer value2) {
            addCriterion("ext_pass_id between", value1, value2, "extPassId");
            return (Criteria) this;
        }

        public Criteria andExtPassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ext_pass_id not between", value1, value2, "extPassId");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagIsNull() {
            addCriterion("ext_pass_flag is null");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagIsNotNull() {
            addCriterion("ext_pass_flag is not null");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagEqualTo(String value) {
            addCriterion("ext_pass_flag =", value, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagNotEqualTo(String value) {
            addCriterion("ext_pass_flag <>", value, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagGreaterThan(String value) {
            addCriterion("ext_pass_flag >", value, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ext_pass_flag >=", value, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagLessThan(String value) {
            addCriterion("ext_pass_flag <", value, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagLessThanOrEqualTo(String value) {
            addCriterion("ext_pass_flag <=", value, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagLike(String value) {
            addCriterion("ext_pass_flag like", value, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagNotLike(String value) {
            addCriterion("ext_pass_flag not like", value, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagIn(List<String> values) {
            addCriterion("ext_pass_flag in", values, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagNotIn(List<String> values) {
            addCriterion("ext_pass_flag not in", values, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagBetween(String value1, String value2) {
            addCriterion("ext_pass_flag between", value1, value2, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassFlagNotBetween(String value1, String value2) {
            addCriterion("ext_pass_flag not between", value1, value2, "extPassFlag");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressIsNull() {
            addCriterion("ext_pass_address is null");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressIsNotNull() {
            addCriterion("ext_pass_address is not null");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressEqualTo(String value) {
            addCriterion("ext_pass_address =", value, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressNotEqualTo(String value) {
            addCriterion("ext_pass_address <>", value, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressGreaterThan(String value) {
            addCriterion("ext_pass_address >", value, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ext_pass_address >=", value, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressLessThan(String value) {
            addCriterion("ext_pass_address <", value, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressLessThanOrEqualTo(String value) {
            addCriterion("ext_pass_address <=", value, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressLike(String value) {
            addCriterion("ext_pass_address like", value, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressNotLike(String value) {
            addCriterion("ext_pass_address not like", value, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressIn(List<String> values) {
            addCriterion("ext_pass_address in", values, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressNotIn(List<String> values) {
            addCriterion("ext_pass_address not in", values, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressBetween(String value1, String value2) {
            addCriterion("ext_pass_address between", value1, value2, "extPassAddress");
            return (Criteria) this;
        }

        public Criteria andExtPassAddressNotBetween(String value1, String value2) {
            addCriterion("ext_pass_address not between", value1, value2, "extPassAddress");
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