package com.personal.shared.query;

import java.util.Map;

public class InsertIntoBuilder {

    private final Map<String, String> fields;
    private final String tableName;
    private StringBuilder insertQueryBuilder;

    public InsertIntoBuilder(Map<String, String> fields, String tableName) {
        this.fields = fields;
        this.tableName = tableName;
        this.insertQueryBuilder = new StringBuilder();
        buildQuery();
    }

    public String Get() {
        return insertQueryBuilder.toString();
    }

    private void buildQuery() {
        if (fields.isEmpty()) {
            return;
        }

        var algo = fields.keySet().stream().map(key -> key).toArray(String[]::new);

        insertQueryBuilder.append("INSERT INTO ").append(tableName).append(" (");
        insertQueryBuilder.append(String.join(", ", algo));
        insertQueryBuilder.append(") VALUES (");
        insertQueryBuilder.append(":").append(String.join(", :", algo));
        insertQueryBuilder.append(")");

    }
}
