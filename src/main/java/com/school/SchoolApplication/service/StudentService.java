package com.school.SchoolApplication.service;

import com.school.SchoolApplication.entity.Student;
import com.school.SchoolApplication.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private IStudentRepository studentRepository;

    public Optional<Student> getStudentById(Long studentId){
        return studentRepository.findById(studentId);
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public void deleteStudentById(Long studentId){
        studentRepository.deleteById(studentId);
    }

    public List< Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
