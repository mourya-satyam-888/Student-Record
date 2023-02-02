package org.studentrecord.controllers;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.studentrecord.controllers.studentcontrollerteststructure.StudentControllerTestStructure;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {
  private static Stream<StudentControllerTestStructure> generateTest() {
    //negative age
    StudentControllerTestStructure testcase1 = new StudentControllerTestStructure(
        "name 1", "-10", "address 1", "rollNo 1",
        Arrays.asList("A", "B", "C", "D"));
    testcase1.setTestName("Negative Age");
    testcase1.setErrorExpected(true);
    StudentControllerTestStructure testcase2 = new StudentControllerTestStructure(
        "", "10", "address 1", "rollNo 1",
        Arrays.asList("A", "B", "C", "D"));
    testcase2.setTestName("Empty Name");
    testcase2.setErrorExpected(true);
    StudentControllerTestStructure testcase3 = new StudentControllerTestStructure(
        "name 1", "10", "address 1", "rollNo 1",
        Arrays.asList("A", "B", "C", "D"));
    testcase3.setTestName("Valid Case");
    testcase3.setErrorExpected(false);

    return Stream.of(testcase1, testcase2, testcase3);
  }

  @ParameterizedTest
  @MethodSource("generateTest")
  void createStudentTest(StudentControllerTestStructure testcase) {
    try {
      StudentController studentController = new StudentController();
      studentController.createStudent(
          testcase.getName(), testcase.getAge(),
          testcase.getAddress(), testcase.getRollNo(),
          testcase.getCourses());
      assertTrue(true, testcase.getTestName());
    } catch (Exception e) {
      if (!testcase.getErrorExpected())
        fail(testcase.getTestName());
      assertTrue(true, testcase.getTestName());
    }
  }
}