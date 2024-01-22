package com.taf.process;

import com.taf.config.PropertyFileReader;
import com.taf.config.TestConstant;
import com.taf.pojo.Student;
import com.taf.util.ResponseUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentProcess {

    private static final Logger log = LogManager.getFormatterLogger(StudentProcess.class);

    public static Student getStudentDetail(int id) {
        String baseURL = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.BASE_URL.getValue());
        String resource = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.RESOURCE.getValue());
        String endPoint = baseURL + resource + "/" + id;
        log.info("Endpoint to hit : " + endPoint);
        Response response = RestAssured.get(endPoint);
        ResponseUtil.validateResponseStatusCode(response);
        ResponseUtil.validateResponseStatusLine(response);
        ResponseUtil.validateResponseContentType(response);
        ResponseUtil.validateResponseHeaders(response);
        ResponseUtil.validateResponseCookies(response);
        return response.getBody().as(Student.class);
    }

    public static Student postStudentDetail(Student student) {
        String baseURL = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.BASE_URL.getValue());
        String resource = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.RESOURCE.getValue());
        String endPoint = baseURL + resource;
        log.info("Endpoint to hit : " + endPoint);
        Response response = RestAssured.post(endPoint);
//        ResponseUtil.validateResponseStatusCode(response);
//        ResponseUtil.validateResponseStatusLine(response);
//        ResponseUtil.validateResponseContentType(response);
//        ResponseUtil.validateResponseHeaders(response);
//        ResponseUtil.validateResponseCookies(response);
        return response.getBody().as(Student.class);
    }

}
