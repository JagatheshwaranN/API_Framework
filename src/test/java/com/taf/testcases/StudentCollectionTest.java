package com.taf.testcases;

import com.taf.pojo.Student;
import com.taf.pojo.StudentCollection;
import com.taf.process.StudentCollectionProcess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class StudentCollectionTest {

    private static final Logger log = LogManager.getFormatterLogger(StudentCollectionTest.class);

    @Test(enabled = false)
    public void testStudentCollection() {
        StudentCollection studentCollection = StudentCollectionProcess.getAllStudentDetail();
        log.info(studentCollection);
        List<Student> studentList = studentCollection.getStudentList();
        Assert.assertEquals(studentList.size(), 3);
    }

    @Test(enabled = false)
    public void testCourseOfStudentCollection() {
        StudentCollection studentCollection = StudentCollectionProcess.getAllStudentDetail();
        log.info(studentCollection);
        List<Student> studentList = studentCollection.getStudentList();
        Assert.assertEquals(studentList.size(), 3);
        for (Student student : studentList) {
            List<String> courses = student.getCourses();
            System.out.println(student.getName() + "'s Courses are " + courses);
        }

        /*
            Traditional Approach
            ====================
            List<List<String>> coursesPerStudent = studentList.stream()
                .map(Student::getCourses)
                .toList();
            for (int i = 0; i < studentList.size(); i++) {
                Student student = studentList.get(i);
                List<String> courses = coursesPerStudent.get(i);
                System.out.println(student.getName() + "'s Courses: " + courses);
            }

            To get List of Courses
            ======================
            List<String> allCourses = studentList.stream().flatMap(student -> student.getCourses().stream())
                .toList();
        */
    }

    @Test
    public void testPhoneOfStudentCollection() {
        StudentCollection studentCollection = StudentCollectionProcess.getAllStudentDetail();
        log.info(studentCollection);
        List<Student> studentList = studentCollection.getStudentList();
        Assert.assertEquals(studentList.size(), 3);
        for (Student student : studentList) {
            String mobile = student.getPhone();
            System.out.println(student.getName() + "'s Phone Number is " + mobile);
        }
    }

}
