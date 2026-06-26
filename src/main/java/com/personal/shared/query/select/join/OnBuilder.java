package com.personal.shared.query.select.join;

import com.personal.shared.query.select.SelectObject;

public class OnBuilder {

    private final SelectObject query;

    public OnBuilder(SelectObject query) {
        this.query = query;

    }

    public JoinResultBuilder Equ(String tableName, String fieldName) {
        this.query.JoinTable().Equ(tableName, fieldName);
        return new JoinResultBuilder(this.query);
    }

}
