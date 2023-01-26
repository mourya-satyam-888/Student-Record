package org.studentrecord.comparators;

import java.util.Comparator;
import org.studentrecord.models.Student;

/**
 * The type Student by roll no asc.
 */
public class StudentByRollNoAsc implements Comparator<Student> {
  //will make for all combinations
  @Override
  public int compare(final Student o1, final Student o2) {
    return o1.getRollNo().compareTo(o2.getRollNo());
  }
}
