package com.school.SchoolApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =  "school_Id")
    private Integer schoolId;

    private String name;

    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name =  "school_Id", referencedColumnName = "school_Id")
    private List<Student> students;
}
