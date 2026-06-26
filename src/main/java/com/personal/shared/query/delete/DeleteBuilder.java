package com.personal.shared.query.delete;

import com.personal.shared.query.shared.QueryResult;
import com.personal.shared.query.where.WhereBuilderResult;

public class DeleteBuilder implements QueryResult {

    private final StringBuilder keyPair;
    private final DeleteObject deleteObject;

    public DeleteBuilder(DeleteObject deleteObject) {
        this.deleteObject = deleteObject;
        this.keyPair = new StringBuilder();

    }

    public WhereBuilderResult Where() {

        this.deleteObject.Where().setQueryResult(this);
        return this.deleteObject.Where();
    }

    @Override
    public String Get() {

        var queryBuilder = this.deleteObject.buildQuery();
        if (queryBuilder.isEmpty()) {
            return "";
        }

        var where = this.deleteObject.mapWhere();
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
