package com.personal.shared.query;

import java.util.Map;

public class JoinBuilder {

    private final Map<String, String> fields;
    private final JoinedTable joinTables;
    private WhereBuilder where;

    public JoinBuilder(Map<String, String> fields, JoinedTable joinTables) {
        this.fields = fields;
        this.joinTables = joinTables;
    }

    public OnBuilder On(String tableName, String fieldName) {
        this.joinTables.On(tableName, fieldName);
        var onBuilder = new OnBuilder(this.fields, this.joinTables);
        onBuilder.setWhere(this.where);
        return onBuilder;
    }

    public void setWhere(WhereBuilder where) {
        this.where = where;
    }
}
