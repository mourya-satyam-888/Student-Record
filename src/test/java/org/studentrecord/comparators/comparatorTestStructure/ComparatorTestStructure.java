package org.studentrecord.comparators.comparatorTestStructure;

import org.studentrecord.models.Student;
import org.studentrecord.testsstructure.BaseTest;

/**
 * The type Student compare to test structure.
 */
public class ComparatorTestStructure extends BaseTest {
  private Student firstStudent;
  private Student secondStudent;
  private int expectedOutput;

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

  /**
   * Gets expected output.
   *
   * @return the expected output
   */
  public int getExpectedOutput() {
    return expectedOutput;
  }

  /**
   * Sets expected output.
   *
   * @param expectedOutput the expected output
   */
  public void setExpectedOutput(int expectedOutput) {
    this.expectedOutput = expectedOutput;
  }
}
