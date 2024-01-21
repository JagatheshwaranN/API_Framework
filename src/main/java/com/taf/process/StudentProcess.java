package com.taf.process;

import com.taf.config.PropertyFileReader;
import com.taf.config.TestConstant;
import com.taf.pojo.Student;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentProcess {

    private static final Logger log = LogManager.getFormatterLogger(StudentProcess.class);

    public static Student getStudentDetail(int id) {
        String baseURL = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.BASE_URL);
        String resource = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.RESOURCE);
        String endPoint = baseURL + resource + "/" + id;
        log.info("Endpoint to hit : " + endPoint);
        Response response = RestAssured.get(endPoint);
        return response.getBody().as(Student.class);
    }

}
