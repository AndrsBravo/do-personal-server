package com.personal.shared.query.select;

import com.personal.shared.query.select.join.JoinClausesBuilder;
import com.personal.shared.query.shared.QueryResult;
import com.personal.shared.query.where.WhereBuilderResult;

public class SelectBuilder extends JoinClausesBuilder implements QueryResult {

    public SelectBuilder(SelectObject query) {
        super(query);

    }

    @Override
    protected void setSelect() {
        super.setSelect();

        this.queryBuilder.append(" FROM ").append(this.query.mapTableNames());
    }

    public WhereBuilderResult Where() {

        this.query.Where().setQueryResult(this);
        return this.query.Where();
    }

    @Override
    public String Get() {

        this.setSelect();
        var where = this.query.mapWhere();
        if (!where.isEmpty()) {

            this.queryBuilder.append(" WHERE ").append(where);
        }

        return this.queryBuilder.toString();
    }

}
