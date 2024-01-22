package com.taf.util;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    private static final int PASS_STATUS_CODE = 200;

    private static final String PASS_STATUS_LINE = "HTTP/1.1 200 OK";

    private static final String CONTENT_TYPE = "application/json; charset=utf-8";

    private static final Map<String, String> COOKIES = new HashMap<>();

    public static void validateResponseStatusCode(Response response){
        Assert.assertEquals(response.getStatusCode(), PASS_STATUS_CODE);
    }

    public static void validateResponseStatusLine(Response response){
        // System.out.println(response.getStatusLine());
        Assert.assertEquals(response.getStatusLine(), PASS_STATUS_LINE);
    }

    public static void validateResponseContentType(Response response){
        // System.out.println(response.getContentType());
        Assert.assertEquals(response.getContentType(), CONTENT_TYPE);
    }

    public static void validateResponseHeaders(Response response){
        System.out.println(response.getHeaders());
        // Assert.assertEquals(response.getStatusLine(), PASS_STATUS_LINE);
    }

    public static void validateResponseCookies(Response response){
        // System.out.println(response.getCookies());
        Assert.assertEquals(response.getCookies(), COOKIES);
    }

}
