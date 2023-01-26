package org.studentrecord.comparators;

import java.util.Comparator;
import org.studentrecord.models.Student;

/**
 * The type Student by age asc.
 */
public class StudentByAgeAsc implements Comparator<Student> {
  @Override
  public int compare(final Student o1, final Student o2) {
    return Integer.compare(o1.getAge(), o2.getAge());
  }
}
