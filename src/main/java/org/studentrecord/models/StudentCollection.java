package org.studentrecord.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Singleton Class.
 */
@SuppressWarnings("serial")
public final class StudentCollection implements Serializable {
  /**
   * List of students.
   */
  private Set<Student> students = new HashSet<>();

  /**
   * instance made using Early Binding.
   */
  private static StudentCollection instance = new StudentCollection();

  private StudentCollection() {

  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static StudentCollection getInstance() {
    return instance;
  }

  /**
   * Add student.
   *
   * @param student the student
   */
  public void addStudent(final Student student) {
    students.add(student);
  }

  /**
   * Delete student.
   *
   * @param rollNo the roll no
   */
  public void deleteStudent(final String rollNo) {
    final Student student = new Student();
    student.setRollNo(rollNo);
    students.remove(student);
  }

  /**
   * Gets students.
   *
   * @return the students
   */
  public Set<Student> getStudents() {
    return students;
  }

  public void setStudents(final Set<Student> students) {
    this.students = students;
  }

  /**
   * Clear list.
   */
  public void clearList() {
    students.clear();
  }
}
