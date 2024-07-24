package com.school.SchoolApplication.controller;

import com.school.SchoolApplication.entity.School;
import com.school.SchoolApplication.entity.Student;
import com.school.SchoolApplication.service.SchoolService;
import com.school.SchoolApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{studentId}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long studentId){
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student result = studentService.saveStudent(student);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
        return ResponseEntity.ok("Id with "+ studentId + "deleted successfully");
    }

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> result = studentService.getAllStudents();
        return ResponseEntity.ok(result);
    }
}
