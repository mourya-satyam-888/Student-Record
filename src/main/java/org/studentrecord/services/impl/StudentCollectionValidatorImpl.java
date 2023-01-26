package org.studentrecord.services.impl;

import org.studentrecord.enums.Orders;
import org.studentrecord.exceptions.ValidationException;
import org.studentrecord.models.Student;
import org.studentrecord.models.StudentCollection;
import org.studentrecord.services.StudentCollectionValidator;

/**
 * The type Student collection validator.
 */
public class StudentCollectionValidatorImpl implements StudentCollectionValidator {
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

  @Override
  public Boolean validateRollNoPresent(final String rollNo) {
    final Student student = new Student();
    student.setRollNo(rollNo);
    final StudentCollection studentCollection = StudentCollection.getInstance();
    if (!studentCollection.getStudents().contains(student)) {
      throw new ValidationException("Roll No do not exists");
    }
    return true;
  }

  @Override
  public Orders validateSortingOrder(final String order) {
    final Orders sortOrder = Orders.getOrderByOption(order);
    if (sortOrder == null) {
      throw new ValidationException("The given input option doesn't exist");
    }
    return sortOrder;
  }
}
