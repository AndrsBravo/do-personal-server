package com.personal.shared.query;

import java.util.Map;

public class FromBuilder {

    private Map<String, String> fields;
    private StringBuilder queryBuilder;
    private String tableName;

    public FromBuilder(Map<String, String> fields, StringBuilder queryBuilder, String tableName) {
        this.fields = fields;
        this.queryBuilder = queryBuilder;
        this.tableName = tableName;
    }

    public WhereBuilder Where() {

        this.queryBuilder.append(" FROM ").append(tableName);
        return new WhereBuilder(this.fields, this.queryBuilder);
    }

}
