package com.personal.shared.query;

import java.util.Map;

public class SelectBuilder {

    private WhereBuilder where;
    private final String tableName;
    private final String[] fieldsNames;
    private final Map<String, String> fields;
    private final StringBuilder queryBuilder;
    private JoinedTable joinTables;

    public SelectBuilder(String tableName, Map<String, String> fields, String... fieldsNames) {
        this.fields = fields;
        this.tableName = tableName;
        this.queryBuilder = new StringBuilder();
        this.fieldsNames = fieldsNames.length > 0 ? fieldsNames : fields.keySet().toArray(String[]::new);

    }

    private void setSelect() {
        this.queryBuilder.append("SELECT ");
        this.queryBuilder.append(String.join(", ", this.fieldsNames));
        this.queryBuilder.append(" FROM ").append(this.tableName);
    }

    private void joinTable(String tableName, String... fieldsNames) {
        if (this.joinTables == null) {
            this.joinTables = new JoinedTable(this.tableName, this.fieldsNames);
        }
        this.joinTables.joinTable(tableName, fieldsNames);
    }

    public JoinBuilder Join(String tableName, String... fieldsNames) {
        this.joinTable(tableName, fieldsNames);
        this.joinTables.Join(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder InnerJoin(String tableName, String... fieldsNames) {
        this.joinTable(tableName, fieldsNames);
        this.joinTables.InnerJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder LeftJoin(String tableName, String... fieldsNames) {
        this.joinTable(tableName, fieldsNames);
        this.joinTables.LeftJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder LeftOuterJoin(String tableName, String... fieldsNames) {
        this.joinTable(tableName, fieldsNames);
        this.joinTables.LeftOuterJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder RightJoin(String tableName, String... fieldsNames) {
        this.joinTable(tableName, fieldsNames);
        this.joinTables.RightJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder RightOuterJoin(String tableName, String... fieldsNames) {
        this.joinTable(tableName, fieldsNames);
        this.joinTables.RightOuterJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder FullOuterJoin(String tableName, String... fieldsNames) {
        this.joinTable(tableName, fieldsNames);
        this.joinTables.FullOuterJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder FullJoin(String tableName, String... fieldsNames) {
        this.joinTable(tableName, fieldsNames);
        this.joinTables.FullJoin(tableName);
        var innerJoinBuilder = new JoinBuilder(this.fields, this.joinTables);
        innerJoinBuilder.setWhere(this.where);
        return innerJoinBuilder;
    }

    public JoinBuilder CrossJoin(String tableName, String... fieldsNames) {
        this.joinTable(tableName, fieldsNames);
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
            this.where = new WhereBuilder(this.fields, this.queryBuilder);
        }
        this.setSelect();
        return this.where;
    }

    public String Get() {
        this.setSelect();
        var stringBuilder = new StringBuilder();
        stringBuilder.append(queryBuilder).append(this.where.Get());
        return stringBuilder.toString();
    }

}
