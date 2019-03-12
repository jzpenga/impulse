package com.msp.impulse.query;

import com.msp.impulse.base.BaseRequest;
import io.swagger.annotations.ApiModel;

@ApiModel("系统码表查询")
public class DicQuery extends BaseRequest {
    private String dicName;
    private  String dicCode;

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }
}
