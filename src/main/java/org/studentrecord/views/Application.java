package org.studentrecord.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.studentrecord.constants.MenuConstants;
import org.studentrecord.controllers.DataBaseController;
import org.studentrecord.controllers.StudentCollectionController;
import org.studentrecord.models.Student;

/**
 * The type Application.
 */
public class Application {
  /**
   * The constant scanner.
   */
  private static Scanner scanner = new Scanner(System.in);
  /**
   * The constant terminated.
   */
  private static Boolean terminated = false;

  /**
   * Show termination menu.
   */
  private static void showTerminationMenu() {
    System.out.println("Do you wish to save the record in file(y/n)?");
    final String option = scanner.nextLine().strip();
    if (MenuConstants.YES.equals(option)) {
      saveStudent();
    }
    System.out.println("Terminated successfully");
    terminated = true;
  }


  /**
   * Save student.
   */
  private static void saveStudent() {
    DataBaseController.writeData();
  }

  /**
   * Delete student.
   */
  private static void deleteStudent() {
    System.out.println("Enter the roll no of the student to be deleted");
    final String rollNo = scanner.nextLine().strip();
    StudentCollectionController.deleteStudent(rollNo);
    System.out.println("The Student deleted successfully");
  }

  /**
   * Display student menu.
   */
  private static void displayStudentMenu() {
    System.out.println(
        "Select order in which data needs to be sorted\n"
            + "1. According to name in ascending order\n"
            + "2. According to name in descending order\n"
            + "3. According to age in ascending order\n"
            + "4. According to age in descending order\n"
            + "5. According to roll no in ascending order\n"
            + "6. According to roll no in descending order\n"
            + "7. According to address in ascending order\n"
            + "8. According to address in descending order\n");
    final String order = scanner.nextLine().strip();
    final List<Student> students = StudentCollectionController.sortStudentByOrder(order);
    System.out.println(students);
  }

  /**
   * Add student.
   */
  private static void addStudent() {
    System.out.println(
        "Give the input in following order line by line\n"
            + "1. Full name\n"
            + "2. Age\n"
            + "3. Roll No\n"
            + "4. Address\n"
            + "5. 4 courses from A,B,C,D,E or F in 4 lines");
    final String studentName = scanner.nextLine().strip();
    final String studentAge = scanner.nextLine().strip();
    final String studentRollNo = scanner.nextLine().strip();
    final String studentAddress = scanner.nextLine().strip();
    final List<String> courses = new ArrayList<>();
    for (int i = 1; i <= 4; i++) {
      final String courseName = scanner.nextLine().strip();
      courses.add(courseName);
    }
    StudentCollectionController.addStudent(studentName, studentAge,
        studentAddress, studentRollNo, courses);
    System.out.println("The student Added");
  }

  /**
   * Select option.
   */
  private static void selectOption() {
    try {
      final String option = scanner.nextLine().strip();
      switch (option) {
        case "1":
          addStudent();
          break;
        case "2":
          displayStudentMenu();
          break;
        case "3":
          deleteStudent();
          break;
        case "4":
          saveStudent();
          break;
        case "5":
          showTerminationMenu();
          break;
        default:
          System.out.println("select correct option");
          selectOption();
          break;
      }
    } catch (Exception e) {
      showErrors(e.getMessage());
    }
  }

  /**
   * Show menu.
   */
  private static void showMenu() {
    System.out.println(
        "Select one of the 5 options available by entering number\n"
            + "1. Add Student Details\n"
            + "2. Display Student Details\n"
            + "3. Delete Student Details\n" + "4. Save Student Details\n"
            + "5. Exit");
    selectOption();
  }

  /**
   * Show errors.
   *
   * @param errorMessage the error message
   */
  private static void showErrors(final String errorMessage) {
    //will be used to show validation errors
    System.out.println("The following error occurred");
    System.out.println(errorMessage);
  }

  /**
   * Load data.
   */
  private static void loadData() {
    try {
      DataBaseController.readData();
    } catch (Exception e) {
      terminated = true;
      showErrors(e.getMessage());
    }
  }

  /**
   * Run.
   */
  public static void run() {
    loadData();
    while (!terminated) {
      showMenu();
    }
  }
}
