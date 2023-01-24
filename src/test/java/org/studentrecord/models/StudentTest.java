package org.studentrecord.models;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.studentrecord.models.studentteststructure.StudentCompareToTestStructure;
import org.studentrecord.models.studentteststructure.StudentEqualsTestStructure;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Student test.
 */
class StudentTest {
  private static Stream<StudentEqualsTestStructure> generateStudentEqualsTest() {
    Student student1 = new Student("student1", 10,
        "address1", "rollNo1", Arrays.asList("A", "B", "C", "D"));
    Student student2 = new Student("student2", 10,
        "address2", "rollNo2", Arrays.asList("A", "B", "C", "D"));
    Student student3 = new Student("student1", 10,
        "address1", "rollNo1", Arrays.asList("A", "B", "C", "D"));
    //two not equal students
    StudentEqualsTestStructure testcase1 = new StudentEqualsTestStructure();
    testcase1.setFirstStudent(student1);
    testcase1.setSecondStudent(student2);
    testcase1.setTestName("Roll No. different");
    testcase1.setExpectedOutput(false);
    //two students equal
    StudentEqualsTestStructure testcase2 = new StudentEqualsTestStructure();
    testcase2.setFirstStudent(student1);
    testcase2.setSecondStudent(student3);
    testcase2.setTestName("Roll No. same");
    testcase2.setExpectedOutput(true);
    return Stream.of(testcase1, testcase2);
  }

  /**
   * Test equals.
   *
   * @param testcase the testcase
   */
  @ParameterizedTest
  @MethodSource("generateStudentEqualsTest")
  void testEquals(StudentEqualsTestStructure testcase) {
    Student student1 = testcase.getFirstStudent();
    assertEquals(testcase.getExpectedOutput(),
        student1.equals(testcase.getSecondStudent()), testcase.getTestName());
  }

  private static Stream<StudentCompareToTestStructure> generateStudentCompareToTest() {
    Student student1 = new Student("student1", 10,
        "address1", "rollNo1", Arrays.asList("A", "B", "C", "D"));
    Student student2 = new Student("student2", 10,
        "address1", "rollNo2", Arrays.asList("A", "B", "C", "D"));
    Student student3 = new Student("student1", 10,
        "address1", "rollNo2", Arrays.asList("A", "B", "C", "D"));
    //name different first less than second
    StudentCompareToTestStructure testcase1 = new StudentCompareToTestStructure();
    testcase1.setFirstStudent(student1);
    testcase1.setSecondStudent(student2);
    testcase1.setExpectedOutput(-1);
    testcase1.setTestName("Name different first less");
    //name same first less than second
    StudentCompareToTestStructure testcase2 = new StudentCompareToTestStructure();
    testcase2.setFirstStudent(student1);
    testcase2.setSecondStudent(student3);
    testcase2.setExpectedOutput(-1);
    testcase2.setTestName("Name same first less");
    //name and roll number both same
    StudentCompareToTestStructure testcase3 = new StudentCompareToTestStructure();
    testcase3.setFirstStudent(student1);
    testcase3.setSecondStudent(student1);
    testcase3.setExpectedOutput(0);
    testcase3.setTestName("Name and roll number both same");
    //first greater than second
    StudentCompareToTestStructure testcase4 = new StudentCompareToTestStructure();
    testcase4.setFirstStudent(student2);
    testcase4.setSecondStudent(student1);
    testcase4.setExpectedOutput(1);
    testcase4.setTestName("First less than second");
    return Stream.of(testcase1, testcase2, testcase3, testcase4);
  }

  /**
   * Compare to.
   *
   * @param testcase the testcase
   */
  @ParameterizedTest
  @MethodSource("generateStudentCompareToTest")
  void compareTo(StudentCompareToTestStructure testcase) {
    Student student1 = testcase.getFirstStudent();
    assertEquals(testcase.getExpectedOutput(),
        student1.compareTo(testcase.getSecondStudent()), testcase.getTestName());
  }
}