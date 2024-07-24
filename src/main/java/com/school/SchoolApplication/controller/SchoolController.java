package com.school.SchoolApplication.controller;

import com.school.SchoolApplication.entity.School;
import com.school.SchoolApplication.entity.Student;
import com.school.SchoolApplication.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school")
public class  SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/{schoolId}")
    public ResponseEntity<Optional<School>> getSchoolById(@PathVariable Long schoolId){
        return ResponseEntity.ok(schoolService.getSchoolById(schoolId));
    }

    @PostMapping
    public ResponseEntity<School> saveStudent(@RequestBody School school){
        School result = schoolService.saveSchool(school);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{schoolId}")
    public ResponseEntity<String> deleteSchoolById(@PathVariable Long schoolId){
        schoolService.deleteSchoolById(schoolId);
        return ResponseEntity.ok("Id with "+ schoolId + "deleted successfully");
    }

    @GetMapping("/allSchools")
    public ResponseEntity<List<School>> getAllSchools(){
        List<School> result = schoolService.getAllSchools();
        return ResponseEntity.ok(result);
    }
}
