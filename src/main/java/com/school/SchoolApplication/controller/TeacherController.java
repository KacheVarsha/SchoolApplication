package com.school.SchoolApplication.controller;

import com.school.SchoolApplication.entity.School;
import com.school.SchoolApplication.entity.Student;
import com.school.SchoolApplication.entity.Teacher;
import com.school.SchoolApplication.service.StudentService;
import com.school.SchoolApplication.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{teacherId}")
    public ResponseEntity<Optional<Teacher>> getTeacherById(@PathVariable Long teacherId){
        return ResponseEntity.ok(teacherService.getTeacherById(teacherId));
    }

    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
        Teacher result = teacherService.saveTeacher(teacher);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{teacherId}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable Long teacherId){
        teacherService.deleteTeacherById(teacherId);
        return ResponseEntity.ok("Id with "+ teacherId + "deleted successfully");
    }
    @GetMapping("/allTeachers")
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        List<Teacher> result = teacherService.getAllTeachers();
        return ResponseEntity.ok(result);
    }
}
