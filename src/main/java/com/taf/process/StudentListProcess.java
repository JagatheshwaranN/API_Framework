package com.taf.process;

import com.taf.config.PropertyFileReader;
import com.taf.pojo.Student;
import com.taf.pojo.StudentCollection;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class StudentListProcess {

    private static final Logger logger = LogManager.getLogger(StudentListProcess.class);

    public static StudentCollection getAllStudentDetail() {
        String baseURL = PropertyFileReader.getPropertyData().getApi().get("baseURL");
        String resource = PropertyFileReader.getPropertyData().getApi().get("resource");
        String endPoint = baseURL + resource;
        logger.info("Endpoint to hit : " + endPoint);
        Response response = RestAssured.get(endPoint);
        List<Student> studentList = Collections.singletonList(response.getBody().as(Student.class));
        StudentCollection studentCollection = new StudentCollection();
        studentCollection.setStudentList(studentList);
        return studentCollection;
    }
}
