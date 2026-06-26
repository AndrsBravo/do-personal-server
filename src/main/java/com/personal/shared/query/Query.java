package com.personal.shared.query;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.personal.shared.query.delete.DeleteBuilder;
import com.personal.shared.query.delete.DeleteObject;
import com.personal.shared.query.field.Field;
import com.personal.shared.query.insert.InsertIntoBuilder;
import com.personal.shared.query.select.SelectBuilder;
import com.personal.shared.query.select.SelectObject;
import com.personal.shared.query.update.UpdateBuilder;
import com.personal.shared.query.update.UpdateObject;
import com.personal.shared.query.where.WhereBuilder;
import com.personal.shared.query.where.WhereBuilderResult;

public class Query {

    private WhereBuilderResult where;
    private UpdateBuilder updateBuilder;
    private DeleteBuilder deleteBuilder;
    private final StringBuilder keyPair;
    private final Set<String> setFields;
    private final Map<String, String> fields;

    public Query() {
        this.fields = new HashMap<>();
        this.setFields = new HashSet<>();
        this.keyPair = new StringBuilder();
    }

    public void Field(String key, String value) {
        this.fields.put(key, value);
        this.keyPair.append(key).append(":").append(value).append(";");
    }

    public <E> void Field(String key, Field<E> value) {
        this.fields.put(key, value.getValue().toString());
        this.keyPair.append(key).append(":").append(value).append(";");
    }

    public void Set(String key, String value) {
        this.Field(key, value);
        this.setFields.add(key);
    }

    public WhereBuilder Where() {
        if (this.where == null) {
            this.where = new WhereBuilderResult();
        }

        return where;
    }

    public InsertIntoBuilder InsertInto(String tableName) {
        return new InsertIntoBuilder(this.fields, tableName);
    }

    public SelectBuilder Select(String tableName, String... fieldsNames) {

        //Llamar el Where para que se cree si no esta creado.
        this.Where();
        var queryObject = new SelectObject(this.fields, this.where);
        queryObject.Table(tableName, fieldsNames);

        SelectBuilder select = new SelectBuilder(queryObject);

        return select;
    }

    public UpdateBuilder Update(String tableName) {
        this.Where();
        this.updateBuilder = new UpdateBuilder(new UpdateObject(this.fields, this.where, tableName, setFields));

        return this.updateBuilder;
    }

    public DeleteBuilder Delete(String tableName) {
        this.Where();
        this.deleteBuilder = new DeleteBuilder(new DeleteObject(this.fields, this.where, tableName));

        return this.deleteBuilder;
    }

    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public Map<String, String> getParams() {
        return fields;
    }

    public String getKeyPair() {
        return keyPair.toString();
    }

}
