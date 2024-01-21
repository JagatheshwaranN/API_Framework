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

public class StudentTest {

    private static final Logger log = LogManager.getFormatterLogger(StudentTest.class);

    @Test(dataProvider = "test_data_supplier", dataProviderClass = TestDataSupplier.class)
    public void testStudent(Map<String, Object> testData) {
        int id = (Integer) testData.get("id");
        Student student = StudentProcess.getStudentDetail(id);
        log.info(student);
        Assert.assertEquals(student.getId(), id);
        Assert.assertEquals(student.getName(), "John Doe");
        Assert.assertEquals(student.getLocation(), "New York");
        Assert.assertEquals(student.getPhone(), "123-456-7890");
        Assert.assertEquals(student.getCourses(), List.of("Mathematics", "History", "Science"));
    }

}
