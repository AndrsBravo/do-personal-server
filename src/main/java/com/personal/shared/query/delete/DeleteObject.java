package com.personal.shared.query.delete;

import java.util.Map;

import com.personal.shared.query.shared.QueryObject;
import com.personal.shared.query.where.WhereBuilderResult;

public class DeleteObject extends QueryObject {

    private final StringBuilder deleteQuery;

    public DeleteObject(Map<String, String> fields, WhereBuilderResult where, String tableName) {
        super(fields, where);
        this.Table(tableName);
        this.deleteQuery = new StringBuilder("DELETE FROM ");
    }

    public void Table(String tableName) {
        this.tableList.add(tableName);
    }

    public StringBuilder buildQuery() {
        if (this.tableList.size() < 1) {
            return new StringBuilder();
        }
        this.deleteQuery.append(this.tableList.get(0));
        return this.deleteQuery;
    }

}
