package com.school.SchoolApplication.repository;

import com.school.SchoolApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

   /* @Query(value = "SELECT s.* FROM Student s WHERE s.school_fk in (SELECT s1.schoolId FROM School s1 WHERE s1.name = :studentName)", nativeQuery = true)
    Optional<List<Student>> findAllStudentsBySchoolName(@Param("studentName") String studentName);*/
}
