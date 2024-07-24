package com.school.SchoolApplication;

import com.school.SchoolApplication.controller.StudentController;
import com.school.SchoolApplication.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentControllerTests {

    private Student student;

    @Autowired
    private StudentController studentController;
}
