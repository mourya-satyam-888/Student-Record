package org.studentrecord.comparators;

import java.util.Comparator;
import org.studentrecord.models.Student;

/**
 * The type Student by age desc.
 */
public class StudentByAgeDesc implements Comparator<Student> {
  @Override
  public int compare(final Student o1, final Student o2) {
    return Integer.compare(o2.getAge(), o1.getAge());
  }
}
