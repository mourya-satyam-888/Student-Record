package org.studentrecord.controllers;

import java.util.ArrayList;
import java.util.List;
import org.studentrecord.comparators.StudentByAddressAsc;
import org.studentrecord.comparators.StudentByAddressDesc;
import org.studentrecord.comparators.StudentByAgeAsc;
import org.studentrecord.comparators.StudentByAgeDesc;
import org.studentrecord.comparators.StudentByNameAsc;
import org.studentrecord.comparators.StudentByNameDesc;
import org.studentrecord.comparators.StudentByRollNoAsc;
import org.studentrecord.comparators.StudentByRollNoDesc;
import org.studentrecord.enums.Orders;
import org.studentrecord.models.Student;
import org.studentrecord.models.StudentCollection;
import org.studentrecord.services.StudentCollectionValidator;
import org.studentrecord.services.impl.StudentCollectionValidatorImpl;

/**
 * The type Student collection controller.
 */
public class StudentCollectionController {


  /**
   * The Student collection validator.
   */
  protected StudentCollectionValidator studentCollectionValidator
      = new StudentCollectionValidatorImpl();
  /**
   * The Student controller.
   */
  protected StudentController studentController = new StudentController();

  /**
   * Add student.
   *
   * @param studentName    the student name
   * @param studentAge     the student age
   * @param studentAddress the student address
   * @param studentRollNo  the student roll no
   * @param courses        the courses
   */
  public void addStudent(final String studentName, final String studentAge,
                         final String studentAddress, final String studentRollNo,
                         final List<String> courses) {
    studentCollectionValidator.validateRollNoAbsent(studentRollNo);
    final Student student = studentController.createStudent(studentName, studentAge,
        studentAddress, studentRollNo, courses);
    StudentCollection.getInstance().addStudent(student);
  }

  /**
   * Delete student.
   *
   * @param studentRollNo the student roll no
   */
  public void deleteStudent(final String studentRollNo) {
    studentCollectionValidator.validateRollNoPresent(studentRollNo);
    StudentCollection.getInstance().deleteStudent(studentRollNo);
  }

  /**
   * Sort student by order list.
   *
   * @param order the order
   * @return the list
   */
  public static List<Student> sortStudentByOrder(final String order) {
    final StudentCollectionValidator
        studentCollectionValidator = new StudentCollectionValidatorImpl();
    final Orders sortOrder = studentCollectionValidator.validateSortingOrder(order);
    final List<Student> students = new ArrayList<>(StudentCollection.getInstance().getStudents());
    switch (sortOrder) {
      case NAME_ASC:
        students.sort(new StudentByNameAsc());
        break;
      case NAME_DESC:
        students.sort(new StudentByNameDesc());
        break;
      case AGE_ASC:
        students.sort(new StudentByAgeAsc());
        break;
      case AGE_DESC:
        students.sort(new StudentByAgeDesc());
        break;
      case ADDRESS_ASC:
        students.sort(new StudentByAddressAsc());
        break;
      case ADDRESS_DESC:
        students.sort(new StudentByAddressDesc());
        break;
      case ROLL_NO_ASC:
        students.sort(new StudentByRollNoAsc());
        break;
      case ROLL_NO_DESC:
        students.sort(new StudentByRollNoDesc());
        break;
      default:
        break;
    }
    return students;
  }
}
