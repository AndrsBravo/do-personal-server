package com.personal.shared.query.select;

import java.util.HashMap;
import java.util.Map;

import com.personal.shared.query.select.join.JoinedTable;
import com.personal.shared.query.shared.QueryObject;
import com.personal.shared.query.shared.QueryTable;
import com.personal.shared.query.where.WhereBuilderResult;

public class SelectObject extends QueryObject {

    private JoinedTable joinedTable;
    private final Map<String, QueryTable> tables;

    public SelectObject(Map<String, String> fields, WhereBuilderResult where) {
        super(fields, where);
        this.tables = new HashMap<>();
    }

    @Override
    public void addTable(QueryTable table) {
        super.addTable(table);
        this.tables.put(table.getName(), table);
    }

    public JoinedTable JoinTable() {
        if (this.joinedTable == null) {
            this.joinedTable = new JoinedTable(this.tables);
        }
        return this.joinedTable;
    }

    public void Table(String tableName, String[] fieldsNames) {
        var table = new QueryTable(tableName, fieldsNames);
        this.addTable(table);

    }

    public String[] mapFieldList() {
        System.out.println("------   Map field Lists ------");
        var fieldString = this.tableList.stream().map(tableName -> this.tables.get(tableName).getFieldString()).toArray(String[]::new);
        return fieldString;
    }

    public String mapTableNames() {
        var table = this.tables.values().toArray(QueryTable[]::new)[0];
        return table.getName();
    }

    public String mapJoinedWhere() {
        var stringBuilder = new StringBuilder();

        var operators = this.where.getOperators();
        var connectors = this.where.getConnectors();

        this.tableList.forEach(tableName -> {

            var table = this.tables.get(tableName);

            operators.forEach((field, operator) -> {

                if (!this.fields.containsKey(field)) {
                    return;
                }
                if (!table.getFieldList().contains(field)) {
                    return;
                }
                if (!stringBuilder.isEmpty() && !connectors.containsKey(field)) {
                    return;
                }
                if (!stringBuilder.isEmpty() && connectors.containsKey(field)) {
                    stringBuilder.append(connectors.get(field));
                }

                stringBuilder.append(table.getTableAlias()).append(".").append(field).append(operators.get(field)).append(":").append(field);

            });

        });

        return stringBuilder.toString();
    }

}
