package com.personal.shared.query.update;

import com.personal.shared.query.shared.QueryResult;
import com.personal.shared.query.where.WhereBuilderResult;

public class UpdateBuilder implements QueryResult {

    private final StringBuilder keyPair;
    private final UpdateObject updateObject;

    public UpdateBuilder(UpdateObject updateObject) {
        this.updateObject = updateObject;
        this.keyPair = new StringBuilder();
    }

    public WhereBuilderResult Where() {

        this.updateObject.Where().setQueryResult(this);
        return this.updateObject.Where();
    }

    public UpdateBuilder Set(String field) {
        this.updateObject.FieldSet().add(field);
        return this;
    }

    @Override
    public String Get() {

        var queryBuilder = this.updateObject.buildQuery();
        if (queryBuilder.isEmpty()) {
            return "";
        }

        var where = this.updateObject.mapWhere();
        if (where.isEmpty()) {
            return "";
        }

        queryBuilder.append(" WHERE ").append(where);
        return queryBuilder.toString();
    }

    public String getKeyPair() {
        return keyPair.toString();
    }

}
