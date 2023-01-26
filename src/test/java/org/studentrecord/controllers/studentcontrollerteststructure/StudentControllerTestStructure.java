package org.studentrecord.controllers.studentcontrollerteststructure;

import java.util.List;
import org.studentrecord.testsstructure.BaseTest;

public class StudentControllerTestStructure extends BaseTest {
  private String name;
  private String age;
  private String address;
  private String rollNo;
  private List<String> courses;

  public StudentControllerTestStructure(String name, String age, String address,
                                        String rollNo, List<String> courses) {
    super();
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNo = rollNo;
    this.courses = courses;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRollNo() {
    return rollNo;
  }

  public void setRollNo(String rollNo) {
    this.rollNo = rollNo;
  }

  public List<String> getCourses() {
    return courses;
  }

  public void setCourses(List<String> courses) {
    this.courses = courses;
  }
}
