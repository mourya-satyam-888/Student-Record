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
import org.studentrecord.models.Student;
import org.studentrecord.services.IStudentValidator;

public class StudentValidator implements IStudentValidator {
  private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  Validator validator = factory.getValidator();

  @Override
  public Boolean validateStudent(Student student) throws Exception {
    Set<ConstraintViolation<Student>> violations = validator.validate(student);
    for (ConstraintViolation<Student> violation : violations) {
      throw new Exception(violation.getMessage());
    }
    return true;
  }

  @Override
  public Boolean validateCourses(List<String> courseList) throws Exception {
    if (courseList.size() != ValidationConstants.MIN_COURSES) {
      throw new Exception("atleast four courses required");
    }
    HashSet<String> courseSet = new HashSet<>(courseList);
    if (courseSet.size() < ValidationConstants.MIN_COURSES) {
      throw new Exception("atleast four courses required");
    }
    try {
      for (String s : courseSet) {
        Courses.valueOf(s);
      }
    } catch (Exception e) {
      throw new Exception("Course must be From A,B,C,D,E or F");
    }
    return true;
  }

  @Override
  public Boolean validateAge(String Age) throws Exception {
    try {
      Integer.parseInt(Age);
    } catch (Exception e) {
      throw new Exception("Age must be integer");
    }
    return true;
  }
}
