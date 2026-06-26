package com.personal.shared.query.select.join;

import com.personal.shared.query.select.SelectObject;

public class JoinBuilder {

    private final SelectObject query;

    public JoinBuilder(SelectObject query) {
        this.query = query;
    }

    public OnBuilder On(String tableName, String fieldName) {
        this.query.JoinTable().On(tableName, fieldName);
        return new OnBuilder(this.query);
    }

}
