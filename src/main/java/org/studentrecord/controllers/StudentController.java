package org.studentrecord.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.studentrecord.enums.Courses;
import org.studentrecord.models.Student;
import org.studentrecord.services.StudentValidator;
import org.studentrecord.services.impl.StudentValidatorImpl;

/**
 * The type Student controller.
 */
public class StudentController {
  /**
   * Create student student.
   *
   * @param studentName    the student name
   * @param age            the age
   * @param studentAddress the student address
   * @param studentRollNo  the student roll no
   * @param courses        the courses
   * @return the student
   */
  public Student createStudent(final String studentName, final String age,
                               final String studentAddress, final String studentRollNo,
                               final List<String> courses) {
    final StudentValidator studentValidator = new StudentValidatorImpl();
    studentValidator.validateAge(age);
    final int studentAge = Integer.parseInt(age);
    studentValidator.validateCourses(courses);
    final List<Courses> studentCourses = courses.stream()
        .map(Courses::valueOf).collect(Collectors.toList());
    final Student student = new Student(studentName, studentAge,
        studentAddress, studentRollNo, studentCourses);
    studentValidator.validateStudent(student);
    return student;
  }
}
