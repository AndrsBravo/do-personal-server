package com.personal.shared.query;

import java.util.Map;

public class OnClausesBuilder {

    private final Map<String, String> fields;
    private final JoinedTable joinTables;
    private WhereBuilder where;

    public OnClausesBuilder(Map<String, String> fields, JoinedTable joinTables) {
        this.fields = fields;
        this.joinTables = joinTables;

    }

    public JoinBuilder Join(String tableName, String... fieldsNames) {
        this.joinTables.joinTable(tableName, fieldsNames);
        this.joinTables.Join(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder InnerJoin(String tableName, String... fieldsNames) {
        this.joinTables.joinTable(tableName, fieldsNames);
        this.joinTables.InnerJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder LeftJoin(String tableName, String... fieldsNames) {
        this.joinTables.joinTable(tableName, fieldsNames);
        this.joinTables.LeftJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder LeftOuterJoin(String tableName, String... fieldsNames) {
        this.joinTables.joinTable(tableName, fieldsNames);
        this.joinTables.LeftOuterJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder RightJoin(String tableName, String... fieldsNames) {
        this.joinTables.joinTable(tableName, fieldsNames);
        this.joinTables.RightJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder RightOuterJoin(String tableName, String... fieldsNames) {
        this.joinTables.joinTable(tableName, fieldsNames);
        this.joinTables.RightOuterJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder FullOuterJoin(String tableName, String... fieldsNames) {
        this.joinTables.joinTable(tableName, fieldsNames);
        this.joinTables.FullOuterJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder FullJoin(String tableName, String... fieldsNames) {
        this.joinTables.joinTable(tableName, fieldsNames);
        this.joinTables.FullJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder CrossJoin(String tableName, String... fieldsNames) {
        this.joinTables.joinTable(tableName, fieldsNames);
        this.joinTables.CrossJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public void setWhere(WhereBuilder where) {
        this.where = where;
    }

    public WhereBuilder Where() {
        if (this.where == null) {
            this.where = new WhereBuilder(this.fields, this.joinTables.GetStringBuilder());
        }
        return this.where;
    }

    public String Get() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append(joinTables.GetStringBuilder()).append(this.where.Get());
        return stringBuilder.toString();
    }

}
