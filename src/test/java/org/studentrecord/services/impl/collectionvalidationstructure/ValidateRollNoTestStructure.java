package org.studentrecord.services.impl.collectionvalidationstructure;

import java.util.List;
import org.studentrecord.models.Student;
import org.studentrecord.testsstructure.BaseTest;

/**
 * The type Validate roll no test structure.
 */
public class ValidateRollNoTestStructure extends BaseTest {
  private String rollNo;
  private List<Student> students;

  /**
   * Gets roll no.
   *
   * @return the roll no
   */
  public String getRollNo() {
    return rollNo;
  }

  /**
   * Sets roll no.
   *
   * @param rollNo the roll no
   */
  public void setRollNo(String rollNo) {
    this.rollNo = rollNo;
  }

  /**
   * Gets students.
   *
   * @return the students
   */
  public List<Student> getStudents() {
    return students;
  }

  /**
   * Sets students.
   *
   * @param students the students
   */
  public void setStudents(List<Student> students) {
    this.students = students;
  }
}
