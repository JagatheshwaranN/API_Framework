package com.taf.process;

import com.taf.config.PropertyFileReader;
import com.taf.pojo.Student;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentProcess {

    private static final Logger logger = LogManager.getLogger(StudentProcess.class);

    public static Student getStudentDetail(int id) {
        String baseURL = PropertyFileReader.getPropertyData().getApi().get("baseURL");
        String resource = PropertyFileReader.getPropertyData().getApi().get("resource");
        String endPoint = baseURL + resource + "/" + id;
        logger.info("Endpoint to hit : " + endPoint);
        Response response = RestAssured.get(endPoint);
        return response.getBody().as(Student.class);
    }
}
