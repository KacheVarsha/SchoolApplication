package com.school.SchoolApplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity                 // for validation, added validation dependency in pom.xml
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull(message = "First name can not be null")
    @Size(min = 1, max = 30, message = "First must be between 1 to 30 characters")
    private String firstName;

    @Column
    @NotNull(message = "Last name can not be null")
    @Size(min = 1, max = 30, message = "Last name must be between 1 to 30 characters")
    private String lastName;

    @Column
    @NotBlank(message = "UserName can not be Blank")
    private String userName;

    @NotNull(message = "Email should not be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Mobile number can not be null")   // default message : must not be null
    @Pattern(regexp = "\\d{10}", message = "Mobile number should be exactly 10 digits")
    private String mobileNumber;

}