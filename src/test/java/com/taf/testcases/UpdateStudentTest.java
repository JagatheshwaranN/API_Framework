package com.taf.testcases;

import com.taf.data.TestDataSupplier;
import com.taf.pojo.Student;
import com.taf.process.StudentProcess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class UpdateStudentTest {

    private static final Logger log = LogManager.getFormatterLogger(UpdateStudentTest.class);

    @SuppressWarnings("unchecked")
    @Test(dataProvider = "test_data_supplier", dataProviderClass = TestDataSupplier.class)
    public void testUpdateStudent(Map<String, Object> testData) {
        int id = (Integer) testData.get("id");
        Student studentData = new Student();
        studentData.setName((String) testData.get("name"));
        studentData.setLocation((String) testData.get("location"));
        studentData.setPhone((String) testData.get("phone"));
        studentData.setCourses((List<String>) testData.get("courses"));
        Student student = StudentProcess.updateStudentDetail(id, studentData);
        log.info(student);
        Assert.assertEquals(student.getId(), id);
        Assert.assertEquals(student.getName(), testData.get("name"));
        Assert.assertEquals(student.getLocation(), testData.get("location"));
        Assert.assertEquals(student.getPhone(), testData.get("phone"));
        Assert.assertEquals(student.getCourses(), testData.get("courses"));
    }

}
