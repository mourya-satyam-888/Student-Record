package org.studentrecord.services.impl.collectionvalidationstructure;

import java.util.List;
import org.studentrecord.models.Student;
import org.studentrecord.testsstructure.BaseTest;

public class ValidateRollNoTestStructure extends BaseTest {
  private String rollNo;
  private List<Student> students;

  public String getRollNo() {
    return rollNo;
  }

  public void setRollNo(String rollNo) {
    this.rollNo = rollNo;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }
}
