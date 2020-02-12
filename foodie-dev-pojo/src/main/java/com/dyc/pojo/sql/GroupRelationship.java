package com.dyc.pojo.sql;

import java.util.List;

public class GroupRelationship {
    private String id;
    private List<Condition> conditions;
    private List<ConditionRelationship> conditionRelationships;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<ConditionRelationship> getConditionRelationships() {
        return conditionRelationships;
    }

    public void setConditionRelationships(List<ConditionRelationship> conditionRelationships) {
        this.conditionRelationships = conditionRelationships;
    }
}
