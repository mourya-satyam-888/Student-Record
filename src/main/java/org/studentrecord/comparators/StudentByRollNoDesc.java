package org.studentrecord.comparators;

import java.util.Comparator;
import org.studentrecord.models.Student;

/**
 * The type Student by roll no desc.
 */
public class StudentByRollNoDesc implements Comparator<Student> {
  @Override
  public int compare(final Student o1, final Student o2) {
    return o2.getRollNo().compareTo(o1.getRollNo());
  }
}
