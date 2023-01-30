package org.studentrecord.controllers;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.studentrecord.models.Student;
import org.studentrecord.services.StudentCollectionValidator;
import org.studentrecord.services.StudentValidator;
import org.studentrecord.services.impl.StudentCollectionValidatorImpl;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentCollectionControllerTest {
  @InjectMocks
  StudentCollectionController studentCollectionController;
  @Mock
  StudentController studentController;
  @Mock
  StudentCollectionValidator studentCollectionValidator;

  @Test
  void addStudentWhenSuccessTest() {
    final String name = "name 1";
    final String age = "10";
    final String address = "address 1";
    final String rollNo = "rollNo 1";
    final List<String> courses = Arrays.asList("A", "B", "C", "D");
    Mockito.when(studentCollectionValidator.validateRollNoAbsent(Mockito.anyString()))
        .thenReturn(true);
    Student student = new Student();
    student.setRollNo("rollNo");
    Mockito.when(studentController.createStudent(Mockito.anyString(), Mockito.anyString(),
            Mockito.anyString(), Mockito.anyString(), Mockito.anyList()))
        .thenReturn(student);
    studentCollectionController.addStudent(name, age, address, rollNo, courses);
    Mockito.verify(studentCollectionValidator).validateRollNoAbsent(Mockito.anyString());
    Mockito.verify(studentController).createStudent(Mockito.anyString(), Mockito.anyString(),
        Mockito.anyString(), Mockito.anyString(), Mockito.anyList());
  }
}