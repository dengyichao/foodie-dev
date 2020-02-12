package com.dyc.pojo.sql;

public class ConditionRelationship {
    private String id;
    private String condition_one_id;
    private String condition_two_id;
    //  区间、与、或
    private String relation;
    private Integer group;

    public ConditionRelationship() {
    }

    public ConditionRelationship(String id, String condition_one_id, String condition_two_id, String relation) {
        this.id = id;
        this.condition_one_id = condition_one_id;
        this.condition_two_id = condition_two_id;
        this.relation = relation;
        this.group = group;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCondition_one_id() {
        return condition_one_id;
    }

    public void setCondition_one_id(String condition_one_id) {
        this.condition_one_id = condition_one_id;
    }

    public String getCondition_two_id() {
        return condition_two_id;
    }

    public void setCondition_two_id(String condition_two_id) {
        this.condition_two_id = condition_two_id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
