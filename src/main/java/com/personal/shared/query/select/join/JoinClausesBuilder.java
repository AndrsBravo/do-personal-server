package com.personal.shared.query.select.join;

import com.personal.shared.query.select.SelectObject;
import com.personal.shared.query.shared.QueryTable;

public class JoinClausesBuilder {

    protected final StringBuilder queryBuilder;
    protected final SelectObject query;

    public JoinClausesBuilder(SelectObject query) {
        this.query = query;
        this.queryBuilder = new StringBuilder();
    }

    protected void setSelect() {

        this.queryBuilder.append("SELECT ");
        this.queryBuilder.append(String.join(", ", this.query.mapFieldList()));
    }

    private QueryTable queryTable(String tableName, String... fieldsNames) {

        var table = new QueryTable(tableName, fieldsNames);
        this.query.addTable(table);
        // table.setFields(this.fields);
        // table.setWhere(this.where);

        return table;
    }

    public JoinBuilder Join(String tableName, String... fieldsNames) {
        this.query.JoinTable().Join(this.queryTable(tableName, fieldsNames));
        return new JoinBuilder(this.query);

    }

    public JoinBuilder InnerJoin(String tableName, String... fieldsNames) {

        this.query.JoinTable().InnerJoin(this.queryTable(tableName, fieldsNames));
        return new JoinBuilder(this.query);

    }

    public JoinBuilder LeftJoin(String tableName, String... fieldsNames) {

        this.query.JoinTable().LeftJoin(this.queryTable(tableName, fieldsNames));
        return new JoinBuilder(this.query);

    }

    public JoinBuilder LeftOuterJoin(String tableName, String... fieldsNames) {

        this.query.JoinTable().LeftOuterJoin(this.queryTable(tableName, fieldsNames));
        return new JoinBuilder(this.query);

    }

    public JoinBuilder RightJoin(String tableName, String... fieldsNames) {

        this.query.JoinTable().RightJoin(this.queryTable(tableName, fieldsNames));
        return new JoinBuilder(this.query);

    }

    public JoinBuilder RightOuterJoin(String tableName, String... fieldsNames) {

        this.query.JoinTable().RightOuterJoin(this.queryTable(tableName, fieldsNames));
        return new JoinBuilder(this.query);

    }

    public JoinBuilder FullOuterJoin(String tableName, String... fieldsNames) {

        this.query.JoinTable().FullOuterJoin(this.queryTable(tableName, fieldsNames));
        return new JoinBuilder(this.query);

    }

    public JoinBuilder FullJoin(String tableName, String... fieldsNames) {

        this.query.JoinTable().FullJoin(this.queryTable(tableName, fieldsNames));
        return new JoinBuilder(this.query);

    }

    public JoinBuilder CrossJoin(String tableName, String... fieldsNames) {

        this.query.JoinTable().CrossJoin(this.queryTable(tableName, fieldsNames));
        return new JoinBuilder(this.query);

    }

}
