package org.studentrecord.services;

import org.studentrecord.enums.Orders;
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

  /**
   * Validate roll no present boolean.
   *
   * @param rollNo the roll no
   * @return the boolean
   */
  Boolean validateRollNoPresent(String rollNo);

  /**
   * Validate sorting order orders.
   *
   * @param order the order
   * @return the orders
   */
  Orders validateSortingOrder(String order);
}
