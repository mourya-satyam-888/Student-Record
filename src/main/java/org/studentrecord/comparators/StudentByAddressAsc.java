package org.studentrecord.comparators;

import java.util.Comparator;
import org.studentrecord.models.Student;

/**
 * The type Student by address asc.
 */
public class StudentByAddressAsc implements Comparator<Student> {
  @Override
  public int compare(final Student o1, final Student o2) {
    return o1.getAddress().compareTo(o2.getAddress());
  }
}
