package org.studentrecord.models.studentteststructure;

import org.studentrecord.models.Student;
import org.studentrecord.testsstructure.BaseTest;

/**
 * The type Student equals test structure.
 */
public class StudentEqualsTestStructure extends BaseTest {
  private Student firstStudent;
  private Student secondStudent;
  private Boolean expectedOutput;

  /**
   * Gets expected output.
   *
   * @return the expected output
   */
  public Boolean getExpectedOutput() {
    return expectedOutput;
  }

  /**
   * Sets expected output.
   *
   * @param expectedOutput the expected output
   */
  public void setExpectedOutput(Boolean expectedOutput) {
    this.expectedOutput = expectedOutput;
  }

  /**
   * Gets first student.
   *
   * @return the first student
   */
  public Student getFirstStudent() {
    return firstStudent;
  }

  /**
   * Sets first student.
   *
   * @param firstStudent the first student
   */
  public void setFirstStudent(Student firstStudent) {
    this.firstStudent = firstStudent;
  }

  /**
   * Gets second student.
   *
   * @return the second student
   */
  public Student getSecondStudent() {
    return secondStudent;
  }

  /**
   * Sets second student.
   *
   * @param secondStudent the second student
   */
  public void setSecondStudent(Student secondStudent) {
    this.secondStudent = secondStudent;
  }
}
