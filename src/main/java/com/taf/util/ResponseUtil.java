package com.taf.util;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    private static final int PASS_STATUS_CODE = 200;

    private static final int POST_STATUS_CODE = 201;

    // private static final int DEL_STATUS_CODE = 204;

    private static final String PASS_STATUS_LINE = "HTTP/1.1 200 OK";

    private static final String POST_STATUS_LINE = "HTTP/1.1 201 Created";

    // private static final String DEL_STATUS_LINE = "HTTP/1.1 204 No Content";

    private static final String CONTENT_TYPE = "application/json; charset=utf-8";

    private static final Map<String, String> COOKIES = new HashMap<>();

    public static void validateResponseStatusCode(Response response, String reqType) {
        // System.out.println(response.getStatusCode());
        if (reqType.equalsIgnoreCase("GET") || reqType.equalsIgnoreCase("PUT") || reqType.equalsIgnoreCase("DELETE")) {
            Assert.assertEquals(response.getStatusCode(), PASS_STATUS_CODE);
        } else {
            Assert.assertEquals(response.getStatusCode(), POST_STATUS_CODE);
        }
    }

    public static void validateResponseStatusLine(Response response, String reqType) {
        // System.out.println(response.getStatusLine());
        if (reqType.equalsIgnoreCase("GET") || reqType.equalsIgnoreCase("PUT") || reqType.equalsIgnoreCase("DELETE")) {
            Assert.assertEquals(response.getStatusLine(), PASS_STATUS_LINE);
        } else {
            Assert.assertEquals(response.getStatusLine(), POST_STATUS_LINE);
        }
    }

    public static void validateResponseContentType(Response response) {
        // System.out.println(response.getContentType());
        Assert.assertEquals(response.getContentType(), CONTENT_TYPE);
    }

    public static void validateResponseHeaders(Response response) {
        // System.out.println(response.getHeaders());
        // Assert.assertEquals(response.getStatusLine(), PASS_STATUS_LINE);
    }

    public static void validateResponseCookies(Response response) {
        // System.out.println(response.getCookies());
        // Assert.assertEquals(response.getCookies(), COOKIES);
    }

}
