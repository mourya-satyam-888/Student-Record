package org.studentrecord.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class Student implements Serializable, Comparable<Student> {
  @NotNull(message = "Empty Name")
  @NotEmpty(message = "Empty Name")
  private final String name;
  @Min(value = 3, message = "Invalid Age")
  private final int age;
  @NotNull(message = "Empty Address")
  private final String address;
  private final String rollNo;
  private List<String> courses;

  public Student(final String name, final int age, final String address, final String rollNo, final List<String> courses) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNo = rollNo;
    this.courses = courses;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int compareTo(Student o) {
    return 0;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address + '\'' +
        ", rollNo='" + rollNo + '\'' +
        ", courses=" + courses +
        '}';
  }
}
