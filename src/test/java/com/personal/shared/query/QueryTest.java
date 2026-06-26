package com.personal.shared.query;

import org.junit.Assert;
import org.junit.Test;

public class QueryTest {

    public QueryTest() {
    }

    @Test
    public void testUpdateQuery() {
        var query = new Query();

        query.Field("id", "abcd");
        query.Field("us_email", "hubravo13@gmail.com");
        query.Field("user_name", "hubravo13");

        var updateQuery = query.Update("users")
                .Set("us_email")
                .Set("user_name")
                .Where()
                .Equ("id")
                .Get();

        var queryString = "UPDATE users SET us_email = :us_email, user_name = :user_name WHERE id = :id";
        Assert.assertEquals(queryString, updateQuery);

    }

    @Test
    public void testUpdateStepByStepQuery() {
        var query = new Query();

        query.Field("id", "abcd");
        query.Where().AndEqu("id");

        query.Set("user_name", "hubravo13");
        query.Set("us_email", "hubravo13@gmail.com");

        query.Where().AndEqu("us_email");

        var updateQuery = query.Update("users").Get();

        System.out.println(updateQuery);
        var queryString = "UPDATE users SET user_name = :user_name, us_email = :us_email WHERE id = :id AND us_email = :us_email";
        Assert.assertEquals(queryString, updateQuery);

    }

    @Test
    public void testInsertQuery() {

        var query = new Query();

        query.Field("id", "abcd");
        query.Field("ust_type", "Admin");
        query.Field("ust_description", "Administrador del sistema");
        query.Field("ust_created_at", "2024-06-01T12:00:00");
        query.Field("ust_updated_at", "2024-06-01T12:00:00");
        query.Field("ust_created_by", "hubravo13");

        var insertQuery = query.InsertInto("user_types").Get();
        var queryString = "INSERT INTO user_types (ust_updated_at, ust_type, ust_description, ust_created_at, id, ust_created_by) VALUES (:ust_updated_at, :ust_type, :ust_description, :ust_created_at, :id, :ust_created_by)";
        Assert.assertEquals(insertQuery, queryString);

    }

    @Test
    public void testSelectQuery() {

        var query = new Query();

        query.Field("id", "abcd");
        query.Field("us_email", "hubravo13@gmail.com");

        /*  var queryAll = "SELECT id, us_email FROM users WHERE id = :id AND us_email = :us_email";
        var selectQueryAll = query.Select("users", "id", "us_email")
                .Where()
                .Equ("id")
                .AndEqu("us_email")
                .Get();

        System.out.println(selectQueryAll);
        System.out.println(queryAll);
        Assert.assertEquals(selectQueryAll, queryAll);
         */
        var queryString = "SELECT id, ust_type, ust_description, ust_updated_at, ust_created_at, ust_created_by FROM user_types WHERE id = :id AND us_email = :us_email";

        var selectQuery = query.Select("user_types", "id", "ust_type", "ust_description", "ust_updated_at", "ust_created_at", "ust_created_by")
                .Where().Equ("id")
                .AndEqu("us_email")
                .Get();

        System.out.println(selectQuery);
        System.out.println(queryString);
        Assert.assertEquals(selectQuery, queryString);

    }

    @Test
    public void testSelectQueryStepByStep() {

        var select = new Query();

        select.Field("id", "abcd");
        select.Where().AndEqu("id");
        select.Field("us_email", "hubravo13@gmail.com");
        select.Where().AndEqu("us_email");

        var queryAll = "SELECT id, us_email FROM users WHERE id = :id AND us_email = :us_email";
        var selectQueryAll = select.Select("users", "id", "us_email").Get();

        System.out.println(selectQueryAll);
        Assert.assertEquals(queryAll, selectQueryAll);

        var query = new Query();

        query.Field("id", "abcd");
        query.Where().AndEqu("id");
        query.Field("ust_type", "dgrnoyte");
        query.Where().AndEqu("ust_type");

        var queryString = "SELECT id, ust_type, ust_description, ust_updated_at, ust_created_at, ust_created_by FROM user_types WHERE id = :id AND ust_type = :ust_type";

        var selectQuery = query.Select("user_types", "id", "ust_type", "ust_description", "ust_updated_at", "ust_created_at", "ust_created_by")
                .Get();

        System.out.println(selectQuery);
        Assert.assertEquals(selectQuery, queryString);

    }

    @Test
    public void testSelectAndJoinQuery() {

        var query = new Query();

        query.Field("id", "abcd");
        query.Field("us_email", "hubravo13@gmail.com");

        var queryAll = "SELECT a.id, a.us_email, a.us_type_id, b.id, c.id FROM users a INNER JOIN user_types b ON a.us_type_id = b.id INNER JOIN user_category c ON a.us_category_id = c.id WHERE a.id = :id AND a.us_email = :us_email";
        var selectQueryAll = query.Select("users", "id", "us_email", "us_type_id")
                .InnerJoin("user_types", "id")
                .On("users", "us_type_id")
                .Equ("user_types", "id")
                .InnerJoin("user_category", "id")
                .On("users", "us_category_id")
                .Equ("user_category", "id")
                .Where().Equ("id")
                .AndEqu("us_email")
                .Get();

        System.out.println(selectQueryAll);
        Assert.assertEquals(selectQueryAll, queryAll);

    }

    @Test
    public void testSelectAndJoinQueryStepByStep() {

        var query = new Query();

        query.Field("id", "abcd");
        query.Where().Equ("id");
        query.Field("us_email", "hubravo13@gmail.com");
        query.Where().AndEqu("us_email");

        var queryAll = "SELECT a.id, a.us_email, a.us_type_id, b.id, c.id FROM users a INNER JOIN user_types b ON a.us_type_id = b.id JOIN user_category c ON a.us_category_id = c.id WHERE a.id = :id AND a.us_email = :us_email";
        var selectQueryAll = query.Select("users", "id", "us_email", "us_type_id")
                .InnerJoin("user_types", "id")
                .On("users", "us_type_id")
                .Equ("user_types", "id")
                .Join("user_category", "id")
                .On("users", "us_category_id")
                .Equ("user_category", "id")
                .Get();

        System.out.println(selectQueryAll);
        Assert.assertEquals(selectQueryAll, queryAll);

    }

    @Test
    public void testDeleteQuery() {
        var query = new Query();

        query.Field("id", "abcd");
        query.Field("ust_type", "Admin");

        var updateQuery = query.Delete("user_types")
                .Where().AndEqu("id")
                .AndEqu("ust_type").Get();

        System.out.println(updateQuery);
        var queryString = "DELETE FROM user_types WHERE id = :id AND ust_type = :ust_type";
        Assert.assertEquals(queryString, updateQuery);

    }

    @Test
    public void testDeleteStepByStepQuery() {
        var query = new Query();

        query.Field("id", "abcd");
        query.Where().AndEqu("id");
        query.Field("ust_type", "Admin");

        query.Where().AndEqu("ust_type");

        var updateQuery = query.Delete("user_types").Get();

        System.out.println(updateQuery);
        var queryString = "DELETE FROM user_types WHERE id = :id AND ust_type = :ust_type";
        Assert.assertEquals(queryString, updateQuery);

    }

}
