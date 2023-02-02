package org.studentrecord.comparators;

import java.util.Comparator;
import org.studentrecord.models.Student;

/**
 * The type Student by name desc.
 */
public class StudentByNameDesc implements Comparator<Student> {
  @Override
  public int compare(final Student o1, final Student o2) {
    return o2.getName().compareTo(o1.getName());
  }
}
