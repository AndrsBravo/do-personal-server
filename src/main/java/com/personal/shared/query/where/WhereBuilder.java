package com.personal.shared.query.where;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.personal.shared.query.field.FieldFilter;
import com.personal.shared.query.shared.QueryResult;

public class WhereBuilder {

    protected QueryResult queryResult;
    protected final List<String> fieldList;
    protected final Map<String, String> operators;
    protected final Map<String, String> connectors;
    private Map<String, Consumer<String>> commands;

    public WhereBuilder() {
        this.operators = new HashMap<>();
        this.connectors = new HashMap<>();
        this.fieldList = new ArrayList<>();
        this.setIt();
    }

    private void setIt() {
        this.commands = new HashMap<>();
        this.commands.put("equ", this::Equ);
        this.commands.put("notequ", this::NotEqu);
        this.commands.put("lessthan", this::LessThan);
        this.commands.put("lessorequ", this::LessOrEqu);
        this.commands.put("greaterthan", this::GreaterThan);
        this.commands.put("greaterorequ", this::GreaterOrEqu);
        this.commands.put("like", this::Like);
        this.commands.put("andlike", this::AndLike);
        this.commands.put("andlike", this::OrLike);
        this.commands.put("andequ", this::AndEqu);
        this.commands.put("andnotequ", this::AndNotEqu);
        this.commands.put("orequ", this::OrEqu);
        this.commands.put("ornotequ", this::OrNotEqu);

        this.commands.put("andlessthan", this::AndLessThan);
        this.commands.put("andlessorequ", this::AndLessOrEqu);
        this.commands.put("andgreaterthan", this::AndGreaterThan);
        this.commands.put("andgreaterorequ", this::AndGreaterOrEqu);

        this.commands.put("orlessthan", this::OrLessThan);
        this.commands.put("orlessorequ", this::OrLessOrEqu);
        this.commands.put("orgreaterthan", this::OrGreaterThan);
        this.commands.put("orgreaterorequ", this::OrGreaterOrEqu);
    }

    private void addOperator(String field, String operator) {
        if (!this.fieldList.contains(field)) {
            this.fieldList.add(field);
        }
        this.operators.put(field, operator);
    }

    private void And(String field) {

        this.connectors.put(field, " AND ");

    }

    private void Or(String field) {

        this.connectors.put(field, " OR ");

    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public WhereBuilder Field(String filed, FieldFilter filter) {
        var command = this.commands.containsKey(filter.getOperator()) ? this.commands.get(filter.getOperator()) : this.commands.get("andequ");

        command.accept(filed);
        return this;
    }

    public WhereBuilder Equ(String field) {

        this.addOperator(field, " = ");
        return this;
    }

    public WhereBuilder NotEqu(String field) {

        this.addOperator(field, " <> ");
        return this;
    }

    public WhereBuilder LessThan(String field) {

        this.addOperator(field, " < ");
        return this;
    }

    public WhereBuilder GreaterThan(String field) {

        this.addOperator(field, " > ");
        return this;
    }

    public WhereBuilder LessOrEqu(String field) {

        this.addOperator(field, " <= ");
        return this;
    }

    public WhereBuilder GreaterOrEqu(String field) {

        this.addOperator(field, " >= ");
        return this;
    }

    public WhereBuilder Like(String field) {

        this.addOperator(field, " LIKE ");
        return this;
    }

    public WhereBuilder AndLike(String field) {

        this.And(field);
        return Like(field);

    }

    public WhereBuilder OrLike(String field) {

        this.Or(field);
        return Like(field);

    }

    public WhereBuilder AndEqu(String field) {

        this.And(field);
        return Equ(field);

    }

    public WhereBuilder AndNotEqu(String field) {

        this.And(field);
        return NotEqu(field);

    }

    public WhereBuilder AndGreaterThan(String field) {

        this.And(field);
        return GreaterThan(field);

    }

    public WhereBuilder AndGreaterOrEqu(String field) {

        this.And(field);
        return GreaterOrEqu(field);

    }

    public WhereBuilder AndLessThan(String field) {

        this.And(field);
        return LessThan(field);

    }

    public WhereBuilder AndLessOrEqu(String field) {

        this.And(field);
        return LessOrEqu(field);

    }

    public WhereBuilder OrEqu(String field) {

        this.Or(field);
        return Equ(field);

    }

    public WhereBuilder OrNotEqu(String field) {

        this.Or(field);
        return NotEqu(field);

    }

    public WhereBuilder OrLessThan(String field) {

        this.Or(field);
        return LessThan(field);

    }

    public WhereBuilder OrLessOrEqu(String field) {

        this.Or(field);
        return LessOrEqu(field);

    }

    public WhereBuilder OrGreaterThan(String field) {

        this.Or(field);
        return GreaterThan(field);

    }

    public WhereBuilder OrGreaterOrEqu(String field) {

        this.Or(field);
        return GreaterOrEqu(field);

    }

    public String Get() {
        return queryResult.Get();
    }
}
