package com.msp.impulse.query;

import com.msp.impulse.entity.Pass;
import com.msp.impulse.entity.Sensor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("新增传感器")
public class SensorAddQuery {
    @ApiModelProperty(name = "sensor", value = "传感器", example = "")
    private Sensor sensor;
    @ApiModelProperty(name = "passList", value = "通道list", example = "")
    private List<Pass> passList;

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public List<Pass> getPassList() {
        return passList;
    }

    public void setPassList(List<Pass> passList) {
        this.passList = passList;
    }
}
