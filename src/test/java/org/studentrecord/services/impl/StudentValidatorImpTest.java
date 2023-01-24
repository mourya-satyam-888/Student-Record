package org.studentrecord.services.impl;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.studentrecord.models.Student;
import org.studentrecord.services.StudentValidator;
import org.studentrecord.services.impl.studentvalidationstructure.ValidateAgeTestStructure;
import org.studentrecord.services.impl.studentvalidationstructure.ValidateCourseTestStructure;
import org.studentrecord.services.impl.studentvalidationstructure.ValidateStudentTestStructure;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Student validator test.
 */
class StudentValidatorImpTest {
  /**
   * The Student validator.
   */
  StudentValidator studentValidator = new StudentValidatorImp();

  private static Stream<ValidateStudentTestStructure> generateTestToValidateStudent() {
    Student student1 = new Student("Student1", -15,
        "Address 1", "1", Arrays.asList("A", "B", "C", "D"));
    //negative Age
    ValidateStudentTestStructure testcase1 = new ValidateStudentTestStructure();
    testcase1.setStudent(student1);
    testcase1.setTestName("Age is negative");
    testcase1.setErrorMessage("Invalid Age");
    //EmptyName
    Student student2 = new Student("", 10,
        "Address 2", "2", Arrays.asList("A", "B", "C", "D"));
    ValidateStudentTestStructure testcase2 = new ValidateStudentTestStructure();
    testcase2.setStudent(student2);
    testcase2.setTestName("Empty Name");
    testcase2.setErrorMessage("Empty Name");
    //valid case
    Student student3 = new Student("Student3", 15,
        "Address 1", "1", Arrays.asList("A", "B", "C", "D"));
    ValidateStudentTestStructure testcase3 = new ValidateStudentTestStructure();
    testcase3.setStudent(student3);
    testcase3.setTestName("Valid Case");
    testcase3.setErrorMessage("");
    return Stream.of(testcase1, testcase2, testcase3);
  }

  /**
   * Test validate student.
   *
   * @param testcase the testcase
   */
  @ParameterizedTest
  @MethodSource("generateTestToValidateStudent")
  void testValidateStudent(ValidateStudentTestStructure testcase) {
    try {
      studentValidator.validateStudent(testcase.getStudent());
      assertEquals(testcase.getErrorMessage(), "", testcase.getTestName());
    } catch (Exception e) {
      assertEquals(testcase.getErrorMessage(), e.getMessage(), testcase.getTestName());
    }
  }

  private static Stream<ValidateCourseTestStructure> generateTestToValidateCourses() {
    //Less than 4 distinct courses
    ValidateCourseTestStructure testcase1 = new ValidateCourseTestStructure();
    testcase1.setCourses(Arrays.asList("A", "B", "C", "C"));
    testcase1.setTestName("Less than four distinct Elements");
    testcase1.setErrorMessage("atleast four courses required");
    //Valid choice
    ValidateCourseTestStructure testcase2 = new ValidateCourseTestStructure();
    testcase2.setCourses(Arrays.asList("A", "B", "E", "F"));
    testcase2.setTestName("Valid Course");
    testcase2.setErrorMessage("");
    //Invalid choices
    ValidateCourseTestStructure testcase3 = new ValidateCourseTestStructure();
    testcase3.setCourses(Arrays.asList("A", "G", "B", "C"));
    testcase3.setTestName("Invalid Choice");
    testcase3.setErrorMessage("Course must be From A,B,C,D,E or F");
    return Stream.of(testcase1, testcase2, testcase3);
  }

  /**
   * Test validate courses.
   *
   * @param testcase the testcase
   */
  @ParameterizedTest
  @MethodSource("generateTestToValidateCourses")
  void testValidateCourses(ValidateCourseTestStructure testcase) {
    try {
      studentValidator.validateCourses(testcase.getCourses());
      assertEquals(testcase.getErrorMessage(), "", testcase.getTestName());
    } catch (Exception e) {
      assertEquals(testcase.getErrorMessage(), e.getMessage(), testcase.getTestName());
    }
  }

  private static Stream<ValidateAgeTestStructure> generateTestToValidateAge() {
    //Not integer
    ValidateAgeTestStructure testcase1 = new ValidateAgeTestStructure();
    testcase1.setAge("a1");
    testcase1.setTestName("Invalid Age");
    testcase1.setErrorMessage("Age must be integer");
    //Valid Age
    ValidateAgeTestStructure testcase2 = new ValidateAgeTestStructure();
    testcase2.setAge("15");
    testcase2.setTestName("Valid Age");
    testcase2.setErrorMessage("");
    return Stream.of(testcase1, testcase2);
  }

  /**
   * Validate age.
   *
   * @param testcase the testcase
   */
  @ParameterizedTest
  @MethodSource("generateTestToValidateAge")
  void validateAge(ValidateAgeTestStructure testcase) {
    try {
      studentValidator.validateAge(testcase.getAge());
      assertEquals(testcase.getErrorMessage(), "", testcase.getTestName());
    } catch (Exception e) {
      assertEquals(testcase.getErrorMessage(), e.getMessage(), testcase.getTestName());
    }
  }
}