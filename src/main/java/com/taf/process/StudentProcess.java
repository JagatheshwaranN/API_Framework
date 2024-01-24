package com.taf.process;

import com.google.gson.JsonObject;
import com.taf.config.PropertyFileReader;
import com.taf.config.TestConstant;
import com.taf.pojo.Student;
import com.taf.util.ResponseUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentProcess {

    private static final Logger log = LogManager.getFormatterLogger(StudentProcess.class);

    private static final String baseURL = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.BASE_URL.getValue());

    private static final String resource = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.RESOURCE.getValue());

    public static Student createStudentDetail(Student student) {
        String endPoint = baseURL + resource;
        log.info("Endpoint to hit : " + endPoint);
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(student)
                .post(endPoint);
        ResponseUtil.validateResponseStatusCode(response, TestConstant.POST.getValue());
        ResponseUtil.validateResponseStatusLine(response, TestConstant.POST.getValue());
        ResponseUtil.validateResponseContentType(response);
        ResponseUtil.validateResponseHeaders(response);
        ResponseUtil.validateResponseCookies(response);
        response.prettyPrint();
        return response.getBody().as(Student.class);
    }

    public static Student retrieveStudentDetail(int id) {
        String endPoint = baseURL + resource + "/" + id;
        log.info("Endpoint to hit : " + endPoint);
        Response response = RestAssured.given().get(endPoint);
        ResponseUtil.validateResponseStatusCode(response, TestConstant.GET.getValue());
        ResponseUtil.validateResponseStatusLine(response, TestConstant.GET.getValue());
        ResponseUtil.validateResponseContentType(response);
        ResponseUtil.validateResponseHeaders(response);
        ResponseUtil.validateResponseCookies(response);
        response.prettyPrint();
        return response.getBody().as(Student.class);
    }

    public static Student updateStudentDetail(int id, Student student) {
        String endPoint = baseURL + resource + "/" + id;
        log.info("Endpoint to hit : " + endPoint);
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(student)
                .put(endPoint);
        ResponseUtil.validateResponseStatusCode(response, TestConstant.PUT.getValue());
        ResponseUtil.validateResponseStatusLine(response, TestConstant.PUT.getValue());
        ResponseUtil.validateResponseContentType(response);
        ResponseUtil.validateResponseHeaders(response);
        ResponseUtil.validateResponseCookies(response);
        response.prettyPrint();
        return response.getBody().as(Student.class);
    }

    public static JsonObject deleteStudentDetail(int id) {
        String endPoint = baseURL + resource + "/" + id;
        log.info("Endpoint to hit : " + endPoint);
        Response response = RestAssured.given().delete(endPoint);
        ResponseUtil.validateResponseStatusCode(response, TestConstant.DELETE.getValue());
        ResponseUtil.validateResponseStatusLine(response, TestConstant.DELETE.getValue());
        ResponseUtil.validateResponseContentType(response);
        ResponseUtil.validateResponseHeaders(response);
        ResponseUtil.validateResponseCookies(response);
        response.prettyPrint();
        return response.getBody().as(JsonObject.class);
    }

}
