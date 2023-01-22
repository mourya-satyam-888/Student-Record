package org.studentrecord.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable, Comparable<Student> {
  private final String name;
  private final int age;
  private final String address;
  private final String rollNo;
  private final ArrayList<String> courses = new ArrayList<>();

  public Student(final String name, final int age, final String address, final String rollNo) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNo = rollNo;
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
