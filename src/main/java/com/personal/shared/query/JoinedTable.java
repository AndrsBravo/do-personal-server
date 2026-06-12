package com.personal.shared.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoinedTable {

    private char tableChar;
    private final StringBuilder queryBuilder;
    private final Map<String, String[]> fields;
    private Map<String, Character> alias;
    private final String tableName;
    private final List<String> fieldList;

    public JoinedTable(String tableName, String... fieldsNames) {
        this.tableName = tableName;
        this.tableChar = 'a';
        this.fieldList = new ArrayList<>();
        this.fields = new HashMap<>();
        this.alias = new HashMap<>();
        this.joinTable(tableName, fieldsNames);
        this.queryBuilder = new StringBuilder();
        this.setSelect();

    }

    private void setSelect() {
        this.queryBuilder.append(" FROM ").append(this.tableName).append(" ").append(this.alias.get(this.tableName));
    }

    public void joinTable(String tableName, String[] fieldsNames) {
        this.alias.put(tableName, this.tableChar);
        String b = " " + tableChar + ".";
        String[] value = fieldsNames.length > 0 ? (tableChar + "." + String.join(b, fieldsNames)).split(" ") : new String[0];
        fields.put(tableName, value);
        this.fieldList.add(String.join(", ", value));
        this.tableChar++;
    }

    private void Join(String tableName, String join) {
        this.queryBuilder.append(join).append(tableName).append(" ").append(this.alias.get(tableName));
    }

    public void Join(String tableName) {
        this.Join(tableName, " JOIN ");
    }

    public void InnerJoin(String tableName) {
        this.Join(tableName, " INNER JOIN ");
    }

    public void LeftJoin(String tableName) {
        this.Join(tableName, " LEFT JOIN ");
    }

    public void LeftOuterJoin(String tableName) {
        this.Join(tableName, " LEFT OUTER JOIN ");
    }

    public void RightJoin(String tableName) {
        this.Join(tableName, " RIGHT JOIN ");
    }

    public void RightOuterJoin(String tableName) {
        this.Join(tableName, " RIGHT OUTER JOIN ");
    }

    public void FullJoin(String tableName) {
        this.Join(tableName, " FULL JOIN ");
    }

    public void FullOuterJoin(String tableName) {
        this.Join(tableName, " FULL OUTER JOIN ");
    }

    public void CrossJoin(String tableName) {
        this.Join(tableName, " CROSS JOIN ");
    }

    public void On(String tableName, String fieldName) {
        this.queryBuilder.append(" ON ").append(this.alias.get(this.tableName)).append(".").append(fieldName);
    }

    public void Equ(String tableName, String fieldName) {
        this.queryBuilder.append(" = ").append(this.alias.get(tableName)).append(".").append(fieldName);
    }

    private StringBuilder buildQuery() {
        var stringBuilder = new StringBuilder();

        stringBuilder.append(String.join(", ", this.fieldList));

        stringBuilder.insert(0, "SELECT ");
        return stringBuilder;
    }

    public String Get() {

        return this.buildQuery().append(this.queryBuilder).toString();
    }

    public StringBuilder GetStringBuilder() {
        return this.buildQuery().append(this.queryBuilder);
    }
}
