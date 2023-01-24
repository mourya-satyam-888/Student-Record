package org.studentrecord.services.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.studentrecord.constants.ValidationConstants;
import org.studentrecord.enums.Courses;
import org.studentrecord.exceptions.ValidationException;
import org.studentrecord.models.Student;
import org.studentrecord.services.StudentValidator;

/**
 * The type Student validator.
 */
public class StudentValidatorImp implements StudentValidator {
  /**
   * Factory to create validator.
   */
  private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  /**
   * validator to check violations.
   */
  private final Validator validator = factory.getValidator();

  @Override
  public Boolean validateStudent(final Student student) {
    final Set<ConstraintViolation<Student>> violations = validator.validate(student);
    for (final ConstraintViolation<Student> violation : violations) {
      throw new ValidationException(violation.getMessage());
    }
    return true;
  }

  @Override
  public Boolean validateCourses(final List<String> courseList) {
    if (courseList.size() != ValidationConstants.MIN_COURSES) {
      throw new ValidationException("atleast four courses required");
    }
    final HashSet<String> courseSet = new HashSet<>(courseList);
    if (courseSet.size() < ValidationConstants.MIN_COURSES) {
      throw new ValidationException("atleast four courses required");
    }
    try {
      for (final String s : courseSet) {
        Courses.valueOf(s);
      }
    } catch (Exception e) {
      throw new ValidationException("Course must be From A,B,C,D,E or F");
    }
    return true;
  }

  @Override
  public Boolean validateAge(final String age) {
    try {
      Integer.parseInt(age);
    } catch (Exception e) {
      throw new ValidationException("Age must be integer");
    }
    return true;
  }
}
