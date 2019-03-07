package com.msp.impulse.query;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.Linkman;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增用户数据")
public class SaveUserQuery {
    @ApiModelProperty(name = "company", value = "公司", example = "")
    private Company company;
    @ApiModelProperty(name = "linkman", value = "联系人", example = "")
    private Linkman linkman;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Linkman getLinkman() {
        return linkman;
    }

    public void setLinkman(Linkman linkman) {
        this.linkman = linkman;
    }
}
