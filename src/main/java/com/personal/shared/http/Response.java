package com.personal.shared.http;

public record Response<T>(String status, String statusCode, String text, T data) {

    public static <T> Response<T> success(T data) {
        return new Response<>("success", "200", "Success", data);
    }

    public static <T> Response<T> created(T data) {
        return new Response<>("created", "201", "Created", data);
    }

    public static <T> Response<T> error(String statusCode, T data) {
        return new Response<>("error", statusCode, "Error", data);
    }

}
