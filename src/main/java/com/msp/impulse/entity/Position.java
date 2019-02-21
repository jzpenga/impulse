package com.msp.impulse.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "经纬度", description = "经纬度")
public class Position {
    @ApiModelProperty(name = "longitude", value = "经度", example = "1")
    private String longitude;
    @ApiModelProperty(name = "latitude", value = "纬度", example = "1")
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
