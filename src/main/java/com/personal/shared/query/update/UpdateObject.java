package com.personal.shared.query.update;

import java.util.Map;
import java.util.Set;

import com.personal.shared.query.shared.QueryObject;
import com.personal.shared.query.where.WhereBuilderResult;

public class UpdateObject extends QueryObject {

    private final StringBuilder updateQuery;
    private final Set<String> setFields;

    public UpdateObject(Map<String, String> fields, WhereBuilderResult where, String tableName, Set<String> setFields) {
        super(fields, where);
        this.Table(tableName);
        this.setFields = setFields;
        this.updateQuery = new StringBuilder("UPDATE " + tableName + " SET ");
    }

    public Set<String> FieldSet() {
        return setFields;
    }

    public void Table(String tableName) {
        this.tableList.add(tableName);
    }

    public StringBuilder buildQuery() {
        var params = !this.setFields.isEmpty() ? this.setFields : this.fields.keySet();
        if (params.size() < 1) {
            return new StringBuilder();
        }
        var a = params.stream().map(field -> field + " = :" + field).toList();
        this.updateQuery.append(String.join(", ", a));
        return this.updateQuery;
    }

}
