package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.Date;

@ApiModel(value = "每日用户数量", description = "每日用户数量")
public class UserCountDaily {
    @Id
    @ApiModelProperty(name = "id", value = "每日用户数量id", example = "1")
    private String id;
    @ApiModelProperty(name = "count", value = "数量", example = "1", required = true)
    private String count;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;
    @ApiModelProperty(name = "updateTime", value = "更新时间", example = "2019-01-01 00:00:00", required = true)
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
