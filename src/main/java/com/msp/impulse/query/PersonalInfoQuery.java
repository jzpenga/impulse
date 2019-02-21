package com.msp.impulse.query;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("个人信息")
public class PersonalInfoQuery {

    //公司信息
    @ApiModelProperty(name = "company", value = "公司", example = "")
    private Company company;
    //个人信息
    @ApiModelProperty(name = "user", value = "个人", example = "")
    private User user;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
