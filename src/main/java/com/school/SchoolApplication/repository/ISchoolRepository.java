package com.school.SchoolApplication.repository;

import com.school.SchoolApplication.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISchoolRepository extends JpaRepository<School, Long> {

}
