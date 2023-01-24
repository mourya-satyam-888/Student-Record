package org.studentrecord.services;

import org.studentrecord.exceptions.ValidationException;

/**
 * The interface Student collection validator.
 */
public interface StudentCollectionValidator {
  /**
   * Validate roll no boolean.
   *
   * @param rollNo the roll no
   * @return the boolean
   * @throws ValidationException the validation exception
   */
  Boolean validateRollNoAbsent(String rollNo);
}
