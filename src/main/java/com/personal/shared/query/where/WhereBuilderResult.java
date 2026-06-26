package com.personal.shared.query.where;

import java.util.Map;

import com.personal.shared.query.shared.QueryResult;

public class WhereBuilderResult extends WhereBuilder {

    public void setQueryResult(QueryResult queryResult) {
        this.queryResult = queryResult;
    }

    public Map<String, String> getConnectors() {
        return connectors;
    }

    public Map<String, String> getOperators() {
        return operators;
    }

}
