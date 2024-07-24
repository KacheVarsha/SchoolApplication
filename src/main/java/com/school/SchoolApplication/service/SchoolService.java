package com.school.SchoolApplication.service;

import com.school.SchoolApplication.entity.School;
import com.school.SchoolApplication.repository.ISchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    private ISchoolRepository schoolRepository;

    public Optional<School> getSchoolById(Long schoolId){
        return schoolRepository.findById(schoolId);
    }

    public School saveSchool(School school){
        return schoolRepository.save(school);
    }
    public void deleteSchoolById(Long schoolId){
        schoolRepository.deleteById(schoolId);
    }

    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }
}
