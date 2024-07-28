package com.school.SchoolApplication.service;

import com.school.SchoolApplication.entity.Registration;
import com.school.SchoolApplication.repository.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private IRegistrationRepository repository;

    public Registration saveRegistrationDetails(Registration registration){
        return repository.save(registration);
    }


}
