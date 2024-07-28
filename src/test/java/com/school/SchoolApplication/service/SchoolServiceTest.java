package com.school.SchoolApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.SchoolApplication.entity.School;
import com.school.SchoolApplication.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SchoolServiceTest {

    private final ObjectMapper objectMapper = new ObjectMapper(); //one object to another object . Here mapped JSON object

    @Test
    public void testExamples() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();

        List<School> schoolList = objectMapper.readValue(classLoader.getResourceAsStream("data/school_data.json"), new TypeReference<List<School>>() {});

        System.out.println("Schools: " + objectMapper.writeValueAsString(schoolList));

        // all school name
        List<String> schoolNames = schoolList.stream().map(School::getName).toList(); //collect(Collectors.toList());

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(schoolNames);
        System.out.println("All School Names: " + json);
        System.out.println();

        //all students
        List<Student> studentList = schoolList.stream().flatMap(i->i.getStudents().stream()).toList();
        ObjectMapper objectMapper1 = new ObjectMapper();
        String json1 = objectMapper1.writeValueAsString(studentList);
        System.out.println("All Students List: " + json1);
        System.out.println();

        //map<schoolName, List<Student>>
        Map<String, List<Student>> mapOfSchoolNameWithStudentsList = schoolList.stream().collect(Collectors.toMap(School::getName, School::getStudents));
        ObjectMapper objectMapper2 = new ObjectMapper();
        String json2 = objectMapper2.writeValueAsString(mapOfSchoolNameWithStudentsList);
        System.out.println("Map of School Name and List of Students" + json2);
        System.out.println();

        //map<studentName, age>
        Map<String, Integer> mapOfStudentNameWithAge = schoolList.stream().flatMap(i->i.getStudents().stream())
                                                                            .collect(Collectors.toMap(Student::getName, Student::getAge));
        ObjectMapper objectMapper3 = new ObjectMapper();
        String json3 = objectMapper3.writeValueAsString(mapOfStudentNameWithAge);
        System.out.println("Map of Student Name and their age" + json3);
        System.out.println();

        /**
         * Map<Integer, List<Student>
         */

        Map<Integer, List<Student>> studentsWithTheirAges = schoolList.stream().flatMap(i->i.getStudents().stream())
                                                                                .collect(Collectors.groupingBy(Student::getAge));
        String json9 = objectMapper3.writeValueAsString(studentsWithTheirAges);
        System.out.println("Map of Age and students group by ages" + json9);
        System.out.println();

        Map<Boolean, List<Student>> studentPartionByAgeLesThanTen = schoolList.stream().flatMap(i->i.getStudents().stream())
                                                                                    .collect(Collectors.partitioningBy(age -> age.getAge()>10));
        String json10 = objectMapper3.writeValueAsString(studentPartionByAgeLesThanTen );
        System.out.println("Partion By Age and students group by ages" + json10);
        System.out.println();

    }
    @Test
    public void testExamplesOfMap() throws IOException {

        Map<Integer, String> mapOfIdWithName = new HashMap<>();

        mapOfIdWithName.put(1, "Varsha");
        mapOfIdWithName.put(2, "Harsha");
        mapOfIdWithName.put(3, "Mansi");
        mapOfIdWithName.put(4, "Virat");

        for(Map.Entry<Integer, String> entry : mapOfIdWithName.entrySet()){
            System.out.println("Key :" + entry.getKey() + "Value :" + entry.getValue());
        }

        for(Integer key : mapOfIdWithName.keySet()){
            System.out.println("Key :" + key);
        }
         for(String value : mapOfIdWithName.values()){
             System.out.println("Value :" + value);
         }

         Map<String, List<Student>> map = new HashMap<>();

        ClassLoader classLoader = getClass().getClassLoader();
        List<Student> studentList = objectMapper.readValue(classLoader.getResourceAsStream("data/student_data.json"), new TypeReference<List<Student>>() {});

        map.put("AAA",studentList);
        map.put("BBB", studentList);
        map.put("CCC",studentList);

        for(Map.Entry<String, List<Student>> entry : map.entrySet()){
            System.out.println("Key :" +entry.getKey());

            for(Student student:entry.getValue()){
                System.out.println(student.getName());
                System.out.println();
            }
        }
    }

    @Test
    public void testExamplesOfHashMap() throws IOException {

        HashMap<Integer, String> hashmapOfIdWithName = new HashMap<>();

        hashmapOfIdWithName.put(1, "Varsha");
        hashmapOfIdWithName.put(2, "Harsha");
        hashmapOfIdWithName.put(3, "Mansi");
        hashmapOfIdWithName.put(4, "Virat");
        hashmapOfIdWithName.put(4, "Devansh");


        for(HashMap.Entry<Integer, String> entry: hashmapOfIdWithName.entrySet()){
            System.out.println("Hashmap key :" + entry.getKey());
            System.out.println("Hashmap value :" + entry.getValue());
            System.out.println();
        }

    }


}