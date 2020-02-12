package com.dyc.pojo.sql;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "sql条件控制器", description = "sql条件控制器")
public class Instructions {
    @ApiModelProperty(value = "表名", name = "tabname", example = "person", required = true)
    private String tabname;
    // 数据
    @ApiModelProperty(value = "同一组的条件（）的意思", name = "同一组的条件（）的意思", example = "（name=黄小明）", required = true)
    private List<GroupRelationship> groupRelationships;
    @ApiModelProperty(value = "不同组之间的条件关系及顺序", name = "不同组之间的条件关系及顺序", example = "（name=黄小明） and (age>18 and age<30)", required = true)
    private List<ConditionRelationship> conditionRelationships;

    public String getTabname() {
        return tabname;
    }

    public void setTabname(String tabname) {
        this.tabname = tabname;
    }

    public List<GroupRelationship> getGroupRelationships() {
        return groupRelationships;
    }

    public void setGroupRelationships(List<GroupRelationship> groupRelationships) {
        this.groupRelationships = groupRelationships;
    }

    public List<ConditionRelationship> getConditionRelationships() {
        return conditionRelationships;
    }

    public void setConditionRelationships(List<ConditionRelationship> conditionRelationships) {
        this.conditionRelationships = conditionRelationships;
    }
}
