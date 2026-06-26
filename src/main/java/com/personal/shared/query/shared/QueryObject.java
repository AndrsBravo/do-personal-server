package com.personal.shared.query.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.personal.shared.query.where.WhereBuilderResult;

public abstract class QueryObject {

    protected final List<String> tableList;
    protected final WhereBuilderResult where;
    protected final Map<String, String> fields;

    public QueryObject(Map<String, String> fields, WhereBuilderResult where) {
        this.where = where;
        this.fields = fields;
        this.tableList = new ArrayList<>();
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void addTable(QueryTable table) {
        this.tableList.add(table.getName());
    }

    public WhereBuilderResult Where() {

        return where;
    }

    public String mapWhere() {
        var stringBuilder = new StringBuilder();
        var fieldSet = this.where.getFieldList();
        var operators = this.where.getOperators();
        var connectors = this.where.getConnectors();

        fieldSet.forEach((field) -> {

            if (!this.fields.containsKey(field)) {
                return;
            }
            if (!stringBuilder.isEmpty() && connectors.containsKey(field)) {
                stringBuilder.append(connectors.get(field));
            }
            stringBuilder.append(field).append(operators.get(field)).append(":").append(field);

        });

        return stringBuilder.toString();
    }

}
