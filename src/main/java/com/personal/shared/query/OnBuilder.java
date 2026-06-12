package com.personal.shared.query;

import java.util.Map;

public class OnBuilder {

    private final Map<String, String> fields;
    private final JoinedTable joinTables;
    private WhereBuilder where;

    public OnBuilder(Map<String, String> fields, JoinedTable joinTables) {
        this.fields = fields;
        this.joinTables = joinTables;

    }

    public OnClausesBuilder Equ(String tableName, String fieldName) {
        this.joinTables.Equ(tableName, fieldName);
        var onClausesBuilder = new OnClausesBuilder(fields, joinTables);
        onClausesBuilder.setWhere(this.where);
        return onClausesBuilder;
    }

    public void setWhere(WhereBuilder where) {
        this.where = where;
    }

}
