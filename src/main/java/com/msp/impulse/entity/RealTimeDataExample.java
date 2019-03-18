package com.msp.impulse.entity;

import java.util.ArrayList;
import java.util.List;

public class RealTimeDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RealTimeDataExample() {
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

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(String value) {
            addCriterion("deviceId =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(String value) {
            addCriterion("deviceId <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(String value) {
            addCriterion("deviceId >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(String value) {
            addCriterion("deviceId >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(String value) {
            addCriterion("deviceId <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(String value) {
            addCriterion("deviceId <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLike(String value) {
            addCriterion("deviceId like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotLike(String value) {
            addCriterion("deviceId not like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<String> values) {
            addCriterion("deviceId in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<String> values) {
            addCriterion("deviceId not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(String value1, String value2) {
            addCriterion("deviceId between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(String value1, String value2) {
            addCriterion("deviceId not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidIsNull() {
            addCriterion("serviceId is null");
            return (Criteria) this;
        }

        public Criteria andServiceidIsNotNull() {
            addCriterion("serviceId is not null");
            return (Criteria) this;
        }

        public Criteria andServiceidEqualTo(String value) {
            addCriterion("serviceId =", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotEqualTo(String value) {
            addCriterion("serviceId <>", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidGreaterThan(String value) {
            addCriterion("serviceId >", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidGreaterThanOrEqualTo(String value) {
            addCriterion("serviceId >=", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLessThan(String value) {
            addCriterion("serviceId <", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLessThanOrEqualTo(String value) {
            addCriterion("serviceId <=", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLike(String value) {
            addCriterion("serviceId like", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotLike(String value) {
            addCriterion("serviceId not like", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidIn(List<String> values) {
            addCriterion("serviceId in", values, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotIn(List<String> values) {
            addCriterion("serviceId not in", values, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidBetween(String value1, String value2) {
            addCriterion("serviceId between", value1, value2, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotBetween(String value1, String value2) {
            addCriterion("serviceId not between", value1, value2, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServicetypeIsNull() {
            addCriterion("serviceType is null");
            return (Criteria) this;
        }

        public Criteria andServicetypeIsNotNull() {
            addCriterion("serviceType is not null");
            return (Criteria) this;
        }

        public Criteria andServicetypeEqualTo(String value) {
            addCriterion("serviceType =", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotEqualTo(String value) {
            addCriterion("serviceType <>", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeGreaterThan(String value) {
            addCriterion("serviceType >", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeGreaterThanOrEqualTo(String value) {
            addCriterion("serviceType >=", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLessThan(String value) {
            addCriterion("serviceType <", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLessThanOrEqualTo(String value) {
            addCriterion("serviceType <=", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLike(String value) {
            addCriterion("serviceType like", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotLike(String value) {
            addCriterion("serviceType not like", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeIn(List<String> values) {
            addCriterion("serviceType in", values, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotIn(List<String> values) {
            addCriterion("serviceType not in", values, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeBetween(String value1, String value2) {
            addCriterion("serviceType between", value1, value2, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotBetween(String value1, String value2) {
            addCriterion("serviceType not between", value1, value2, "servicetype");
            return (Criteria) this;
        }

        public Criteria andEventtimeIsNull() {
            addCriterion("eventTime is null");
            return (Criteria) this;
        }

        public Criteria andEventtimeIsNotNull() {
            addCriterion("eventTime is not null");
            return (Criteria) this;
        }

        public Criteria andEventtimeEqualTo(String value) {
            addCriterion("eventTime =", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotEqualTo(String value) {
            addCriterion("eventTime <>", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeGreaterThan(String value) {
            addCriterion("eventTime >", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeGreaterThanOrEqualTo(String value) {
            addCriterion("eventTime >=", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeLessThan(String value) {
            addCriterion("eventTime <", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeLessThanOrEqualTo(String value) {
            addCriterion("eventTime <=", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeLike(String value) {
            addCriterion("eventTime like", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotLike(String value) {
            addCriterion("eventTime not like", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeIn(List<String> values) {
            addCriterion("eventTime in", values, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotIn(List<String> values) {
            addCriterion("eventTime not in", values, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeBetween(String value1, String value2) {
            addCriterion("eventTime between", value1, value2, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotBetween(String value1, String value2) {
            addCriterion("eventTime not between", value1, value2, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoIsNull() {
            addCriterion("equipmentNo is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoIsNotNull() {
            addCriterion("equipmentNo is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoEqualTo(String value) {
            addCriterion("equipmentNo =", value, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoNotEqualTo(String value) {
            addCriterion("equipmentNo <>", value, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoGreaterThan(String value) {
            addCriterion("equipmentNo >", value, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoGreaterThanOrEqualTo(String value) {
            addCriterion("equipmentNo >=", value, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoLessThan(String value) {
            addCriterion("equipmentNo <", value, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoLessThanOrEqualTo(String value) {
            addCriterion("equipmentNo <=", value, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoLike(String value) {
            addCriterion("equipmentNo like", value, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoNotLike(String value) {
            addCriterion("equipmentNo not like", value, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoIn(List<String> values) {
            addCriterion("equipmentNo in", values, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoNotIn(List<String> values) {
            addCriterion("equipmentNo not in", values, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoBetween(String value1, String value2) {
            addCriterion("equipmentNo between", value1, value2, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andEquipmentnoNotBetween(String value1, String value2) {
            addCriterion("equipmentNo not between", value1, value2, "equipmentno");
            return (Criteria) this;
        }

        public Criteria andDatakeynameIsNull() {
            addCriterion("dataKeyName is null");
            return (Criteria) this;
        }

        public Criteria andDatakeynameIsNotNull() {
            addCriterion("dataKeyName is not null");
            return (Criteria) this;
        }

        public Criteria andDatakeynameEqualTo(String value) {
            addCriterion("dataKeyName =", value, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameNotEqualTo(String value) {
            addCriterion("dataKeyName <>", value, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameGreaterThan(String value) {
            addCriterion("dataKeyName >", value, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameGreaterThanOrEqualTo(String value) {
            addCriterion("dataKeyName >=", value, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameLessThan(String value) {
            addCriterion("dataKeyName <", value, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameLessThanOrEqualTo(String value) {
            addCriterion("dataKeyName <=", value, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameLike(String value) {
            addCriterion("dataKeyName like", value, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameNotLike(String value) {
            addCriterion("dataKeyName not like", value, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameIn(List<String> values) {
            addCriterion("dataKeyName in", values, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameNotIn(List<String> values) {
            addCriterion("dataKeyName not in", values, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameBetween(String value1, String value2) {
            addCriterion("dataKeyName between", value1, value2, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeynameNotBetween(String value1, String value2) {
            addCriterion("dataKeyName not between", value1, value2, "datakeyname");
            return (Criteria) this;
        }

        public Criteria andDatakeyIsNull() {
            addCriterion("dataKey is null");
            return (Criteria) this;
        }

        public Criteria andDatakeyIsNotNull() {
            addCriterion("dataKey is not null");
            return (Criteria) this;
        }

        public Criteria andDatakeyEqualTo(String value) {
            addCriterion("dataKey =", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyNotEqualTo(String value) {
            addCriterion("dataKey <>", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyGreaterThan(String value) {
            addCriterion("dataKey >", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyGreaterThanOrEqualTo(String value) {
            addCriterion("dataKey >=", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyLessThan(String value) {
            addCriterion("dataKey <", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyLessThanOrEqualTo(String value) {
            addCriterion("dataKey <=", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyLike(String value) {
            addCriterion("dataKey like", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyNotLike(String value) {
            addCriterion("dataKey not like", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyIn(List<String> values) {
            addCriterion("dataKey in", values, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyNotIn(List<String> values) {
            addCriterion("dataKey not in", values, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyBetween(String value1, String value2) {
            addCriterion("dataKey between", value1, value2, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyNotBetween(String value1, String value2) {
            addCriterion("dataKey not between", value1, value2, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatavalueIsNull() {
            addCriterion("dataValue is null");
            return (Criteria) this;
        }

        public Criteria andDatavalueIsNotNull() {
            addCriterion("dataValue is not null");
            return (Criteria) this;
        }

        public Criteria andDatavalueEqualTo(String value) {
            addCriterion("dataValue =", value, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueNotEqualTo(String value) {
            addCriterion("dataValue <>", value, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueGreaterThan(String value) {
            addCriterion("dataValue >", value, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueGreaterThanOrEqualTo(String value) {
            addCriterion("dataValue >=", value, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueLessThan(String value) {
            addCriterion("dataValue <", value, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueLessThanOrEqualTo(String value) {
            addCriterion("dataValue <=", value, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueLike(String value) {
            addCriterion("dataValue like", value, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueNotLike(String value) {
            addCriterion("dataValue not like", value, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueIn(List<String> values) {
            addCriterion("dataValue in", values, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueNotIn(List<String> values) {
            addCriterion("dataValue not in", values, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueBetween(String value1, String value2) {
            addCriterion("dataValue between", value1, value2, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatavalueNotBetween(String value1, String value2) {
            addCriterion("dataValue not between", value1, value2, "datavalue");
            return (Criteria) this;
        }

        public Criteria andDatamarkIsNull() {
            addCriterion("dataMark is null");
            return (Criteria) this;
        }

        public Criteria andDatamarkIsNotNull() {
            addCriterion("dataMark is not null");
            return (Criteria) this;
        }

        public Criteria andDatamarkEqualTo(String value) {
            addCriterion("dataMark =", value, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkNotEqualTo(String value) {
            addCriterion("dataMark <>", value, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkGreaterThan(String value) {
            addCriterion("dataMark >", value, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkGreaterThanOrEqualTo(String value) {
            addCriterion("dataMark >=", value, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkLessThan(String value) {
            addCriterion("dataMark <", value, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkLessThanOrEqualTo(String value) {
            addCriterion("dataMark <=", value, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkLike(String value) {
            addCriterion("dataMark like", value, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkNotLike(String value) {
            addCriterion("dataMark not like", value, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkIn(List<String> values) {
            addCriterion("dataMark in", values, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkNotIn(List<String> values) {
            addCriterion("dataMark not in", values, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkBetween(String value1, String value2) {
            addCriterion("dataMark between", value1, value2, "datamark");
            return (Criteria) this;
        }

        public Criteria andDatamarkNotBetween(String value1, String value2) {
            addCriterion("dataMark not between", value1, value2, "datamark");
            return (Criteria) this;
        }

        public Criteria andSensornameIsNull() {
            addCriterion("sensorName is null");
            return (Criteria) this;
        }

        public Criteria andSensornameIsNotNull() {
            addCriterion("sensorName is not null");
            return (Criteria) this;
        }

        public Criteria andSensornameEqualTo(String value) {
            addCriterion("sensorName =", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameNotEqualTo(String value) {
            addCriterion("sensorName <>", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameGreaterThan(String value) {
            addCriterion("sensorName >", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameGreaterThanOrEqualTo(String value) {
            addCriterion("sensorName >=", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameLessThan(String value) {
            addCriterion("sensorName <", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameLessThanOrEqualTo(String value) {
            addCriterion("sensorName <=", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameLike(String value) {
            addCriterion("sensorName like", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameNotLike(String value) {
            addCriterion("sensorName not like", value, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameIn(List<String> values) {
            addCriterion("sensorName in", values, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameNotIn(List<String> values) {
            addCriterion("sensorName not in", values, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameBetween(String value1, String value2) {
            addCriterion("sensorName between", value1, value2, "sensorname");
            return (Criteria) this;
        }

        public Criteria andSensornameNotBetween(String value1, String value2) {
            addCriterion("sensorName not between", value1, value2, "sensorname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameIsNull() {
            addCriterion("gatewayName is null");
            return (Criteria) this;
        }

        public Criteria andGatewaynameIsNotNull() {
            addCriterion("gatewayName is not null");
            return (Criteria) this;
        }

        public Criteria andGatewaynameEqualTo(String value) {
            addCriterion("gatewayName =", value, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameNotEqualTo(String value) {
            addCriterion("gatewayName <>", value, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameGreaterThan(String value) {
            addCriterion("gatewayName >", value, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameGreaterThanOrEqualTo(String value) {
            addCriterion("gatewayName >=", value, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameLessThan(String value) {
            addCriterion("gatewayName <", value, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameLessThanOrEqualTo(String value) {
            addCriterion("gatewayName <=", value, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameLike(String value) {
            addCriterion("gatewayName like", value, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameNotLike(String value) {
            addCriterion("gatewayName not like", value, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameIn(List<String> values) {
            addCriterion("gatewayName in", values, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameNotIn(List<String> values) {
            addCriterion("gatewayName not in", values, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameBetween(String value1, String value2) {
            addCriterion("gatewayName between", value1, value2, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andGatewaynameNotBetween(String value1, String value2) {
            addCriterion("gatewayName not between", value1, value2, "gatewayname");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
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