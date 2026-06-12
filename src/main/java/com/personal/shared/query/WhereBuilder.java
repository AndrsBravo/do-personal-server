package com.personal.shared.query;

import java.util.Map;

public class WhereBuilder {

    private final Map<String, String> params;
    private final StringBuilder paramBuilder;
    private StringBuilder previousBuilder;

    public WhereBuilder(Map<String, String> params) {
        this.params = params;
        this.paramBuilder = new StringBuilder();
        this.previousBuilder = new StringBuilder();
    }

    public WhereBuilder(Map<String, String> fields, StringBuilder previousBuilder) {
        this.params = fields;
        this.paramBuilder = new StringBuilder();
        this.previousBuilder = previousBuilder;
    }

    private void And() {
        if (!this.paramBuilder.isEmpty()) {
            this.paramBuilder.append(" AND ");
        }
    }

    private void Or() {
        if (!this.paramBuilder.isEmpty()) {
            this.paramBuilder.append(" OR ");
        }
    }

    public String Get() {
        var stringBuilder = new StringBuilder();
        var query = stringBuilder.append(previousBuilder).append(" WHERE ").append(paramBuilder).toString();
        return query;
    }

    public WhereBuilder Empty(String key) {
        this.paramBuilder.append(key).append(" = ''");
        return this;
    }

    public WhereBuilder AndEmpty(String key) {
        this.And();
        this.paramBuilder.append(key).append(" = ''");
        return this;
    }

    public WhereBuilder OrEmpty(String key) {
        this.Or();
        this.paramBuilder.append(key).append(" = ''");
        return this;
    }

    public WhereBuilder NotEmpty(String key) {
        this.paramBuilder.append(key).append(" <> ''");
        return this;
    }

    public WhereBuilder AndNotEmpty(String key) {
        this.And();
        this.paramBuilder.append(key).append(" <> ''");
        return this;
    }

    public WhereBuilder OrNotEmpty(String key) {
        this.Or();
        this.paramBuilder.append(key).append(" <> ''");
        return this;
    }

    public WhereBuilder Equ(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.paramBuilder.append(key).append(" = :").append(key);
        return this;
    }

    public WhereBuilder Equ(String field, String param) {
        this.paramBuilder.append(field).append(" = :").append(param);
        return this;
    }

    public WhereBuilder NotEqu(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.paramBuilder.append(key).append(" <> :").append(key);
        return this;
    }

    public WhereBuilder NotEqu(String field, String param) {

        this.paramBuilder.append(field).append(" <> :").append(param);
        return this;
    }

    public WhereBuilder LessThan(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.paramBuilder.append(key).append(" < :").append(key);
        return this;
    }

    public WhereBuilder LessThan(String field, String param) {
        this.paramBuilder.append(field).append(" < :").append(param);
        return this;
    }

    public WhereBuilder GreaterThan(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.paramBuilder.append(key).append(" > :").append(key);
        return this;
    }

    public WhereBuilder GreaterThan(String field, String param) {
        this.paramBuilder.append(field).append(" > :").append(param);
        return this;
    }

    public WhereBuilder Like(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.paramBuilder.append(key).append(" LIKE :").append(key);
        return this;
    }

    public WhereBuilder Like(String field, String param) {
        this.paramBuilder.append(field).append(" LIKE :").append(param);
        return this;
    }

    public WhereBuilder AndLike(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.And();
        return Like(key);

    }

    public WhereBuilder AndLike(String field, String param) {
        this.And();
        return Like(field, param);

    }

    public WhereBuilder AndEqu(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.And();
        return Equ(key);

    }

    public WhereBuilder AndEqu(String field, String param) {
        this.And();
        return Equ(field, param);
    }

    public WhereBuilder AndNotEqu(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.And();
        return NotEqu(key);

    }

    public WhereBuilder AndNotEqu(String field, String param) {

        this.And();
        return NotEqu(field, param);

    }

    public WhereBuilder AndGreaterThan(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.And();
        return GreaterThan(key);

    }

    public WhereBuilder AndGreaterThan(String field, String param) {
        this.And();
        return GreaterThan(field, param);

    }

    public WhereBuilder AndLessThan(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.And();
        return LessThan(key);

    }

    public WhereBuilder AndLessThan(String field, String param) {
        this.And();
        return LessThan(field, param);

    }

    public WhereBuilder OrEqu(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.Or();
        return Equ(key);

    }

    public WhereBuilder OrEqu(String field, String param) {

        this.Or();
        return Equ(field, param);

    }

    public WhereBuilder OrNotEqu(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.Or();
        return NotEqu(key);

    }

    public WhereBuilder OrNotEqu(String field, String param) {

        this.Or();
        return NotEqu(field, param);

    }

    public WhereBuilder OrLessThan(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.Or();
        return LessThan(key);

    }

    public WhereBuilder OrLessThan(String field, String param) {

        this.Or();
        return LessThan(field, param);

    }

    public WhereBuilder OrGreaterThan(String key) {
        if (!this.params.containsKey(key)) {
            return this;
        }
        this.Or();
        return GreaterThan(key);

    }

    public WhereBuilder OrGreaterThan(String field, String param) {

        this.Or();
        return GreaterThan(field, param);

    }
}
