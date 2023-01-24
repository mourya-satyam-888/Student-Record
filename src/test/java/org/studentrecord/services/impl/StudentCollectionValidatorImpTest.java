package org.studentrecord.services.impl;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.studentrecord.models.Student;
import org.studentrecord.models.StudentCollection;
import org.studentrecord.services.StudentCollectionValidator;
import org.studentrecord.services.impl.collectionvalidationstructure.ValidateRollNoTestStructure;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Student collection validator test.
 */
class StudentCollectionValidatorImpTest {

  /**
   * The Student collection validator.
   */
  StudentCollectionValidator studentCollectionValidator;

  /**
   * Init.
   */
  @BeforeEach
  void init() {
    studentCollectionValidator = new StudentCollectionValidatorImp();
  }

  private static Stream<ValidateRollNoTestStructure> generateTestToValidateRollNo() {
    Student student1 = new Student("Student 1", 10, "address1",
        "rollno 1", Arrays.asList("A", "B", "C", "D"));
    //testcase for rollno already exists
    ValidateRollNoTestStructure testcase1 = new ValidateRollNoTestStructure();
    testcase1.setRollNo("rollno 1");
    testcase1.setStudents(Arrays.asList(student1));
    testcase1.setTestName("Duplicate Roll No");
    testcase1.setErrorMessage("Roll No already exists");
    //Different roll no
    ValidateRollNoTestStructure testcase2 = new ValidateRollNoTestStructure();
    testcase2.setRollNo("rollno 2");
    testcase2.setStudents(Arrays.asList(student1));
    testcase2.setTestName("New Roll Number");
    testcase2.setErrorMessage("");
    return Stream.of(testcase1, testcase2);
  }

  /**
   * Validate roll no.
   *
   * @param testcase the testcase
   */
  @ParameterizedTest
  @MethodSource("generateTestToValidateRollNo")
  void validateRollNo(ValidateRollNoTestStructure testcase) {
    StudentCollection studentCollection = StudentCollection.getInstance();
    for (Student s : testcase.getStudents()) {
      studentCollection.addStudent(s);
    }
    try {
      studentCollectionValidator.validateRollNoAbsent(testcase.getRollNo());
      assertEquals(testcase.getErrorMessage(), "", testcase.getTestName());
    } catch (Exception e) {
      assertEquals(testcase.getErrorMessage(), e.getMessage(), testcase.getTestName());
    }
  }

  /**
   * Clear.
   */
  @AfterEach
  void clear() {
    //clear the singleton pattern list
    StudentCollection.getInstance().clearList();
  }
}