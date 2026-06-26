package com.personal.shared.query.select.join;

import java.util.HashMap;
import java.util.Map;

import com.personal.shared.query.shared.QueryTable;

public class JoinedTable {

    private char tableChar;
    private final QueryTable table;
    private final StringBuilder queryBuilder;
    private final Map<String, Character> alias;
    private final Map<String, QueryTable> tables;

    public JoinedTable(Map<String, QueryTable> tables) {
        this.tableChar = 'a';
        this.tables = tables;
        this.alias = new HashMap<>();
        this.joinTable(tables);
        this.table = tables.values().toArray(QueryTable[]::new)[0];
        this.queryBuilder = new StringBuilder();
        this.setSelect();

    }

    private void setSelect() {
        this.queryBuilder.append(" FROM ").append(this.table.getTableQueryName());
    }

    private void joinTable(Map<String, QueryTable> tables) {
        tables.values().forEach(this::joinTable);
    }

    private void joinTable(QueryTable table) {
        table.setTableAlias(this.tableChar);
        this.alias.put(table.getName(), this.tableChar);
        this.tableChar++;

    }

    public Map<String, QueryTable> getTables() {
        return tables;
    }

    private void Join(QueryTable table, String join) {
        this.queryBuilder.append(join).append(table.getTableQueryName());
    }

    public void Join(QueryTable table) {
        this.joinTable(table);
        this.Join(table, " JOIN ");
    }

    public void InnerJoin(QueryTable table) {
        this.joinTable(table);
        this.Join(table, " INNER JOIN ");
    }

    public void LeftJoin(QueryTable table) {
        this.joinTable(table);
        this.Join(table, " LEFT JOIN ");
    }

    public void LeftOuterJoin(QueryTable table) {
        this.joinTable(table);
        this.Join(table, " LEFT OUTER JOIN ");
    }

    public void RightJoin(QueryTable table) {
        this.joinTable(table);
        this.Join(table, " RIGHT JOIN ");
    }

    public void RightOuterJoin(QueryTable table) {
        this.joinTable(table);
        this.Join(table, " RIGHT OUTER JOIN ");
    }

    public void FullJoin(QueryTable table) {
        this.joinTable(table);
        this.Join(table, " FULL JOIN ");
    }

    public void FullOuterJoin(QueryTable table) {
        this.joinTable(table);
        this.Join(table, " FULL OUTER JOIN ");
    }

    public void CrossJoin(QueryTable table) {
        this.joinTable(table);
        this.Join(table, " CROSS JOIN ");
    }

    public void On(String tableName, String fieldName) {
        this.queryBuilder.append(" ON ").append(this.alias.get(tableName)).append(".").append(fieldName);
    }

    public void Equ(String tableName, String fieldName) {
        this.queryBuilder.append(" = ").append(this.alias.get(tableName)).append(".").append(fieldName);
    }

    public StringBuilder GetStringBuilder() {
        return this.queryBuilder;
    }
}
