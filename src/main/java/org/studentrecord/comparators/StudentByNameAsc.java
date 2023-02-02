package org.studentrecord.comparators;

import java.util.Comparator;
import org.studentrecord.models.Student;

/**
 * The type Student by name asc.
 */
public class StudentByNameAsc implements Comparator<Student> {
  @Override
  public int compare(final Student o1, final Student o2) {
    return o1.getName().compareTo(o2.getName());
  }
}
