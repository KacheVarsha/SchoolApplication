package com.school.SchoolApplication.service;

import com.school.SchoolApplication.entity.Student;
import com.school.SchoolApplication.entity.Teacher;
import com.school.SchoolApplication.repository.IStudentRepository;
import com.school.SchoolApplication.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private ITeacherRepository teacherRepository;

    public Optional<Teacher> getTeacherById(Long teacherId){
        return teacherRepository.findById(teacherId);
    }

    public Teacher saveTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public void deleteTeacherById(Long teacherId){
        teacherRepository.deleteById(teacherId);
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
}
