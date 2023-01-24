package org.studentrecord.services.impl;

import org.studentrecord.exceptions.ValidationException;
import org.studentrecord.models.Student;
import org.studentrecord.models.StudentCollection;
import org.studentrecord.services.StudentCollectionValidator;

/**
 * The type Student collection validator.
 */
public class StudentCollectionValidatorImp implements StudentCollectionValidator {
  @Override
  public Boolean validateRollNoAbsent(final String rollNo) {
    final Student student = new Student();
    student.setRollNo(rollNo);
    final StudentCollection studentCollection = StudentCollection.getInstance();
    if (studentCollection.getStudents().contains(student)) {
      throw new ValidationException("Roll No already exists");
    }
    return true;
  }
}
