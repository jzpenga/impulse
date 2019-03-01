package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.Date;

@ApiModel(value = "数据字典", description = "数据字典")
public class DataDictionary {
    @Id
    @ApiModelProperty(name = "id", value = "id", example = "id", required = true)
    private String id;
    @ApiModelProperty(name = "groupCode", value = "分组代码", example = "sensor_type", required = true)
    private String groupCode;
    @ApiModelProperty(name = "groupName", value = "分组名称", example = "01", required = true)
    private String groupName;
    @ApiModelProperty(name = "dicCode", value = "字典编码", example = "temperature", required = true)
    private String dicCode;
    @ApiModelProperty(name = "dicName", value = "字典说明", example = "网关类型", required = true)
    private String dicName;
    @ApiModelProperty(name = "dicValue", value = "字典值", example = "01", required = true)
    private String dicValue;
    @ApiModelProperty(name = "parentGroupCode", value = "父级分组编码", example = "01", required = true)
    private String parentGroupCode;
    @ApiModelProperty(name = "hierarchy", value = "层级", example = "1", required = true)
    private String hierarchy;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public String getParentGroupCode() {
        return parentGroupCode;
    }

    public void setParentGroupCode(String parentGroupCode) {
        this.parentGroupCode = parentGroupCode;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
