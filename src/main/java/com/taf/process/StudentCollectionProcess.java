package com.taf.process;

import com.taf.config.PropertyFileReader;
import com.taf.config.TestConstant;
import com.taf.pojo.Student;
import com.taf.pojo.StudentCollection;
import com.taf.util.ResponseUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class StudentCollectionProcess {

    private static final Logger log = LogManager.getFormatterLogger(StudentCollectionProcess.class);

    public static StudentCollection getAllStudentDetail() {
        String baseURL = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.BASE_URL.getValue());
        String resource = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.RESOURCE.getValue());
        String endPoint = baseURL + resource;
        log.info("Endpoint to hit : " + endPoint);
        Response response = RestAssured.get(endPoint);
        List<Student> studentList = Arrays.asList(response.getBody().as(Student[].class));
        ResponseUtil.validateResponseStatusCode(response, TestConstant.GET.getValue());
        ResponseUtil.validateResponseStatusLine(response, TestConstant.GET.getValue());
        ResponseUtil.validateResponseContentType(response);
        ResponseUtil.validateResponseHeaders(response);
        ResponseUtil.validateResponseCookies(response);
        StudentCollection studentCollection = new StudentCollection();
        studentCollection.setStudentList(studentList);
        return studentCollection;
    }

}
