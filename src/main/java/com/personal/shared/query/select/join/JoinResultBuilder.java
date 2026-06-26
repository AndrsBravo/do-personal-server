package com.personal.shared.query.select.join;

import com.personal.shared.query.select.SelectObject;
import com.personal.shared.query.shared.QueryResult;
import com.personal.shared.query.where.WhereBuilder;

public class JoinResultBuilder extends JoinClausesBuilder implements QueryResult {

    public JoinResultBuilder(SelectObject query) {
        super(query);

    }

    public WhereBuilder Where() {
        this.query.Where().setQueryResult(this);
        return this.query.Where();
    }

    @Override
    protected void setSelect() {
        super.setSelect();
        this.queryBuilder.append(this.query.JoinTable().GetStringBuilder());
    }

    @Override
    public String Get() {
        this.setSelect();
        var builder = new StringBuilder();

        var where = this.query.mapJoinedWhere();
        if (!where.isEmpty()) {

            builder.append(" WHERE ").append(where);
        }

        return this.queryBuilder.append(builder).toString();
    }

}
