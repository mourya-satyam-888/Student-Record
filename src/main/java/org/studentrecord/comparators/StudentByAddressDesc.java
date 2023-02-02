package org.studentrecord.comparators;

import java.util.Comparator;
import org.studentrecord.models.Student;

/**
 * The type Student by address desc.
 */
public class StudentByAddressDesc implements Comparator<Student> {
  @Override
  public int compare(final Student o1, final Student o2) {
    return o2.getAddress().compareTo(o1.getAddress());
  }
}
