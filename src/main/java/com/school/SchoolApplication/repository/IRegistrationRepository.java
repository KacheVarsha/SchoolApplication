package com.school.SchoolApplication.repository;

import com.school.SchoolApplication.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrationRepository extends JpaRepository<Registration, Integer> {
}
