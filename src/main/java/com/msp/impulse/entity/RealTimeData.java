package com.msp.impulse.entity;

import java.io.Serializable;

public class RealTimeData implements Serializable {
    private Integer id;

    private String deviceid;

    private String serviceid;

    private String servicetype;

    private String eventtime;

    private String equipmentno;

    private String datakeyname;

    private String datakey;

    private String datavalue;

    private String datamark;

    private String sensorname;

    private String gatewayname;

    private Integer userid;

    private String username;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid == null ? null : deviceid.trim();
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid == null ? null : serviceid.trim();
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype == null ? null : servicetype.trim();
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime == null ? null : eventtime.trim();
    }

    public String getEquipmentno() {
        return equipmentno;
    }

    public void setEquipmentno(String equipmentno) {
        this.equipmentno = equipmentno == null ? null : equipmentno.trim();
    }

    public String getDatakeyname() {
        return datakeyname;
    }

    public void setDatakeyname(String datakeyname) {
        this.datakeyname = datakeyname == null ? null : datakeyname.trim();
    }

    public String getDatakey() {
        return datakey;
    }

    public void setDatakey(String datakey) {
        this.datakey = datakey == null ? null : datakey.trim();
    }

    public String getDatavalue() {
        return datavalue;
    }

    public void setDatavalue(String datavalue) {
        this.datavalue = datavalue == null ? null : datavalue.trim();
    }

    public String getDatamark() {
        return datamark;
    }

    public void setDatamark(String datamark) {
        this.datamark = datamark == null ? null : datamark.trim();
    }

    public String getSensorname() {
        return sensorname;
    }

    public void setSensorname(String sensorname) {
        this.sensorname = sensorname == null ? null : sensorname.trim();
    }

    public String getGatewayname() {
        return gatewayname;
    }

    public void setGatewayname(String gatewayname) {
        this.gatewayname = gatewayname == null ? null : gatewayname.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}