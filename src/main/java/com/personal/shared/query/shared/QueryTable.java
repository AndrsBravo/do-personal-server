package com.personal.shared.query.shared;

import java.util.List;

public class QueryTable {

    private char alias;
    private String fieldString;
    private final String tableName;
    private final List<String> fieldList;

    public QueryTable(String tableName, String... fieldsNames) {
        this.tableName = tableName;
        this.fieldList = List.of(fieldsNames);
        setFieldString();
    }

    private void setFieldString() {
        var prefix = "";
        if (this.alias != 0) {
            prefix = this.alias + ".";
        }
        this.fieldString = prefix + String.join(", " + prefix, fieldList);
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public String getFieldString() {

        return fieldString;
    }

    public void setTableAlias(char alias) {

        this.alias = alias;
        setFieldString();
    }

    public char getTableAlias() {
        return alias;
    }

    public String getName() {
        return tableName;
    }

    public String getTableQueryName() {
        return tableName + " " + this.alias;
    }

}
