package com.school.SchoolApplication.controller;

import com.school.SchoolApplication.entity.Registration;
import com.school.SchoolApplication.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

                                                                             // BindingResult : holds the result of a validation and binding and contains errors that may have occurred.
                                                                            //used to capture and handle validation in DTO
    @PostMapping
    public ResponseEntity<String> createRegistration(@RequestBody @Validated Registration registration, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMessage =  new StringBuilder();
            bindingResult.getAllErrors().stream().forEach(error -> errorMessage.append(error.getDefaultMessage()).append("\n")
            );
            return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
        }
        registrationService.saveRegistrationDetails(registration);
        return new ResponseEntity<>("Registration successfully", HttpStatus.CREATED);
    }

}
