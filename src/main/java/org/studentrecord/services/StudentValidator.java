package org.studentrecord.services;

import java.util.List;
import org.studentrecord.exceptions.ValidationException;
import org.studentrecord.models.Student;

/**
 * The interface Student validator.
 */
public interface StudentValidator {
  /**
   * Validate student boolean.
   *
   * @param s the s
   * @return the boolean
   * @throws ValidationException the validation exception
   */
  Boolean validateStudent(Student s);

  /**
   * Validate courses boolean.
   *
   * @param courses the courses
   * @return the boolean
   * @throws ValidationException the validation exception
   */
  Boolean validateCourses(List<String> courses);

  /**
   * Validate age boolean.
   *
   * @param age the age
   * @return the boolean
   * @throws ValidationException the validation exception
   */
  Boolean validateAge(String age);
}
