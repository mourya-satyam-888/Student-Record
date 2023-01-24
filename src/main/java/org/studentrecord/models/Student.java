package org.studentrecord.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * The type Student.
 */
@SuppressWarnings("serial")
public class Student implements Serializable, Comparable<Student> {
  /**
   * name.
   */
  @NotNull(message = "Empty Name")
  @NotEmpty(message = "Empty Name")
  private String name;
  /**
   * Age.
   */
  @Min(value = 3, message = "Invalid Age")
  private int age;
  /**
   * Address.
   */
  @NotNull(message = "Empty Address")
  private String address;
  /**
   * Roll Number.
   */
  private String rollNo;
  /**
   * List of Courses.
   */
  private List<String> courses;

  /**
   * Instantiates a new Student.
   */
  public Student() {
    //to initialise Student
  }

  /**
   * Instantiates a new Student.
   *
   * @param name    the name
   * @param age     the age
   * @param address the address
   * @param rollNo  the roll no
   * @param courses the courses
   */
  public Student(final String name, final int age,
                 final String address, final String rollNo, final List<String> courses) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNo = rollNo;
    this.courses = courses;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets age.
   *
   * @return the age
   */
  public int getAge() {
    return age;
  }

  /**
   * Gets address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

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
  public void setRollNo(final String rollNo) {
    this.rollNo = rollNo;
  }

  /**
   * Gets courses.
   *
   * @return the courses
   */
  public List<String> getCourses() {
    return courses;
  }

  /**
   * Sets courses.
   *
   * @param courses the courses
   */
  public void setCourses(final List<String> courses) {
    this.courses = courses;
  }

  @Override
  public int hashCode() {
    return rollNo.hashCode();
  }

  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof Student)) {
      return false;
    }
    final Student student = (Student) obj;
    return rollNo.equals(student.getRollNo());
  }

  @Override
  public int compareTo(final Student student) {
    if (student.getName().equals(name)) {
      return rollNo.compareTo(student.getRollNo());
    }
    return name.compareTo(student.getName());
  }

  @Override
  public String toString() {
    return "Student{"
        + "name='" + name + '\''
        + ", age=" + age
        + ", address='" + address + '\''
        + ", rollNo='" + rollNo + '\''
        + ", courses=" + courses + '}';
  }
}
