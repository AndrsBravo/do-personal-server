package com.personal.shared.query;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Query {

    private WhereBuilder where;
    private UpdateBuilder updateBuilder;
    private DeleteBuilder deleteBuilder;
    private final StringBuilder keyPair;
    private final Map<String, String> fields;
    private final Set<String> setFields;

    public Query() {
        this.fields = new HashMap<>();
        this.setFields = new HashSet<>();
        this.keyPair = new StringBuilder();
    }

    public WhereBuilder Where() {
        if (this.where == null) {
            this.where = new WhereBuilder(this.fields);
        }

        return where;
    }

    public UpdateBuilder Update(String tableName) {
        if (this.updateBuilder == null) {
            this.updateBuilder = new UpdateBuilder(tableName, this.fields);
        }
        if (!setFields.isEmpty()) {
            this.setFields.forEach(this.updateBuilder::Set);
        }
        if (this.where != null) {
            this.updateBuilder.setWhere(this.where);
        }
        return this.updateBuilder;
    }

    public DeleteBuilder Delete(String tableName) {
        if (this.deleteBuilder == null) {
            this.deleteBuilder = new DeleteBuilder(tableName, this.fields);
        }
        if (this.where != null) {
            this.deleteBuilder.setWhere(this.where);
        }
        return this.deleteBuilder;
    }

    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public void Set(String key, String value) {
        Field(key, value);
        this.setFields.add(key);
    }

    public void Field(String key, String value) {
        this.fields.put(key, value);
        this.keyPair.append(key).append(":").append(value).append(";");
    }

    public Map<String, String> getParams() {
        return fields;
    }

    public String getKeyPair() {
        return keyPair.toString();
    }

    public InsertIntoBuilder InsertInto(String user_types) {
        return new InsertIntoBuilder(this.fields, user_types);
    }

    public SelectBuilder Select(String tableName, String... fieldsNames) {

        SelectBuilder select = null;

        if (fieldsNames.length > 0) {
            select = new SelectBuilder(tableName, this.fields, fieldsNames);
        }

        if (select == null) {
            select = new SelectBuilder(tableName, this.fields, "*");
        }
        if (where != null) {
            select.setWhere(where);
        }
        return select;
    }

}
