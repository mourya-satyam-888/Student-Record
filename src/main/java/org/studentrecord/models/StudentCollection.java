package org.studentrecord.models;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Singleton Class.
 */
public class StudentCollection implements Serializable {
  private HashSet<Student> students = new HashSet<>();
  //Early Binding
  private static StudentCollection studentCollection = new StudentCollection();

  private StudentCollection() {

  }

  public static StudentCollection getInstance() {
    return studentCollection;
  }

  public void addStudent(final Student student) {
    //to add student
  }

  public void deleteStudent(final String rollNo) {
    //delete student
  }

  public HashSet<Student> getStudents() {
    return students;
  }
}
