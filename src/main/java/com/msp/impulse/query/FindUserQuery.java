package com.msp.impulse.query;

import com.msp.impulse.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户查询")
public class FindUserQuery extends BaseRequest {
    @ApiModelProperty(name = "companyName", value = "公司名称", example = "殷继彤的海鲜公司", required = true)
    private String companyName;
    @ApiModelProperty(name = "province", value = "省/市", example = "河北", required = true)
    private String province;
    @ApiModelProperty(name = "city", value = "市/区", example = "唐山", required = true)
    private String city;
    @ApiModelProperty(name = "loginName", value = "登录名", example = "殷继彤的海鲜公司", required = true)
    private String loginName;
    @ApiModelProperty(name = "name", value = "姓名", example = "殷继彤", required = true)
    private String name;
    @ApiModelProperty(name = "phoneNo", value = "手机号", example = "13333333333", required = true)
    private  String phoneNo;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
