package com.msp.impulse.query;

import com.msp.impulse.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("根据userId对网关或传感器进行分页查询")
public class GateSenPageQuery extends BaseRequest {
    @ApiModelProperty(name = "userId", value = "用户id", example = "用户id", required = true)
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
