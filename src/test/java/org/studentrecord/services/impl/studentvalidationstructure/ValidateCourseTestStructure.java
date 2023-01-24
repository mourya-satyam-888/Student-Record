package org.studentrecord.services.impl.studentvalidationstructure;

import java.util.List;
import org.studentrecord.testsstructure.BaseTest;

/**
 * The type Validate course test structure.
 */
public class ValidateCourseTestStructure extends BaseTest {
  private List<String> courses;

  /**
   * Gets courses.
   *
   * @return the courses
   */
  public List<String> getCourses() {
    return courses;
  }

  /**
   * Sets courses.
   *
   * @param courses the courses
   */
  public void setCourses(List<String> courses) {
    this.courses = courses;
  }
}
