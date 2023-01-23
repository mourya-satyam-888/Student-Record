package org.studentrecord.services;

import java.util.List;
import org.studentrecord.models.Student;

public interface IStudentValidator {
  Boolean validateStudent(final Student s) throws Exception;

  Boolean validateCourses(final List<String> courses) throws Exception;

  Boolean validateAge(String Age) throws Exception;
}
