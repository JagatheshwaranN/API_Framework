package com.taf.testcases;

import com.taf.data.APITestData;
import com.taf.data.TestDataSupplier;
import com.taf.pojo.Student;
import com.taf.process.StudentProcess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SingleStudentTest {

    private static final Logger logger = LogManager.getLogger(SingleStudentTest.class);

    @Test(dataProvider = "test_data_supplier", dataProviderClass = TestDataSupplier.class)
    public void testSingleStudentCase1(int id) {
        System.out.println("Arguments: " + id);
        Student student = StudentProcess.getStudentDetail(id);
        logger.info(student);
        Assert.assertEquals(student.getId(), id);
        Assert.assertEquals(student.getName(), "John Doe");
        Assert.assertEquals(student.getLocation(), "New York");
        Assert.assertEquals(student.getPhone(), "123-456-7890");
        Assert.assertEquals(student.getCourses(), List.of("Mathematics", "History", "Science"));
    }
}
