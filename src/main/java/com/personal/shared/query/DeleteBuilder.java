package com.personal.shared.query;

import java.util.Map;

public class DeleteBuilder {

    private WhereBuilder where;
    private final StringBuilder keyPair;
    private final StringBuilder updateQuery;
    private final Map<String, String> fields;
    private String tableName;

    public DeleteBuilder(String tableName, Map<String, String> fields) {
        this.fields = fields;
        this.keyPair = new StringBuilder();
        this.updateQuery = new StringBuilder();
        this.tableName = "DELETE FROM " + tableName;
    }

    public void setWhere(WhereBuilder where) {

        this.where = where;
    }

    public WhereBuilder Where() {

        if (this.where == null) {
            this.updateQuery.insert(0, this.tableName);
            this.where = new WhereBuilder(this.fields, this.updateQuery);
        }

        return this.where;
    }

    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public String Get() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append(this.tableName).append(this.updateQuery);

        if (this.where != null) {
            stringBuilder.append(" ").append(this.where.Get().trim());
        }

        return stringBuilder.toString();
    }

    public String getKeyPair() {
        return keyPair.toString();
    }

}
