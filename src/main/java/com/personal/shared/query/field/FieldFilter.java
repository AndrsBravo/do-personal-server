package com.personal.shared.query.field;

public class FieldFilter<T> extends Field<T> {

    private String operator;

    public FieldFilter() {
        super();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
