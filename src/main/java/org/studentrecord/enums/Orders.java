package org.studentrecord.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * The enum Orders.
 */
public enum Orders {
  /**
   * Name asc orders.
   */
  NAME_ASC("1"),
  /**
   * Name desc orders.
   */
  NAME_DESC("2"),
  /**
   * Age asc orders.
   */
  AGE_ASC("3"),
  /**
   * Age desc orders.
   */
  AGE_DESC("4"),
  /**
   * Roll no asc orders.
   */
  ROLL_NO_ASC("5"),
  /**
   * Roll no desc orders.
   */
  ROLL_NO_DESC("6"),
  /**
   * Address asc orders.
   */
  ADDRESS_ASC("7"),
  /**
   * Address desc orders.
   */
  ADDRESS_DESC("8");

  /**
   * The Option.
   */
  private String option;
  /**
   * The constant ENCODING.
   */
  private static final Map<String, Orders> ENCODING = new HashMap<>();

  static {
    for (final Orders order : Orders.values()) {
      ENCODING.put(order.getOption(), order);
    }
  }

  /**
   * Instantiates a new Orders.
   *
   * @param option the option
   */
  Orders(final String option) {
    this.option = option;
  }

  /**
   * Gets option.
   *
   * @return the option
   */
  public String getOption() {
    return option;
  }

  /**
   * Gets order by option.
   *
   * @param option the option
   * @return the order by option
   */
  public static Orders getOrderByOption(final String option) {
    return ENCODING.get(option);
  }
}
