package org.studentrecord.comparators;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.studentrecord.comparators.comparatorTestStructure.ComparatorTestStructure;
import org.studentrecord.enums.Courses;
import org.studentrecord.models.Student;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Student by name desc test.
 */
class StudentByNameDescTest {
  private static Stream<ComparatorTestStructure> generateCompareTest() {
    Student student1 = new Student("name 1", 10,
        "address 1", "rollno 1",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    Student student2 = new Student("name 2", 11,
        "address 2", "rollno 2",
        Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    //first less than second by address
    ComparatorTestStructure testcase1 = new ComparatorTestStructure();
    testcase1.setFirstStudent(student1);
    testcase1.setSecondStudent(student2);
    testcase1.setExpectedOutput(1);
    testcase1.setTestName("First less by Name than Second");
    //first greater than second
    ComparatorTestStructure testcase2 = new ComparatorTestStructure();
    testcase2.setFirstStudent(student2);
    testcase2.setSecondStudent(student1);
    testcase2.setExpectedOutput(-1);
    testcase2.setTestName("Second less by Name than First");
    //Equal
    ComparatorTestStructure testcase3 = new ComparatorTestStructure();
    testcase3.setFirstStudent(student1);
    testcase3.setSecondStudent(student1);
    testcase3.setExpectedOutput(0);
    testcase3.setTestName("Equal");
    return Stream.of(testcase1, testcase2, testcase3);
  }

  /**
   * Compare.
   *
   * @param testcase the testcase
   */
  @ParameterizedTest
  @MethodSource("generateCompareTest")
  void compare(ComparatorTestStructure testcase) {
    final StudentByNameDesc studentByNameDesc = new StudentByNameDesc();
    final Student firstStudent = testcase.getFirstStudent();
    final Student secondStudent = testcase.getSecondStudent();
    final int actualOutput = studentByNameDesc.compare(firstStudent, secondStudent);
    assertEquals(testcase.getExpectedOutput(), actualOutput, testcase.getTestName());
  }
}