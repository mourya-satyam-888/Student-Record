package org.studentrecord;

import org.studentrecord.views.Application;

/**
 * The type Main.
 */
public class Main {
  /**
   * The constant APPLICATION.
   */
  private static final Application APPLICATION = new Application();

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(final String[] args) {
    APPLICATION.run();
  }
}