package org.studentrecord.controllers;


import org.studentrecord.services.DataBaseService;
import org.studentrecord.services.impl.DataBaseServiceImpl;

/**
 * The type Data base controller.
 */
public class DataBaseController {
  /**
   * Read data.
   */
  public static void readData() {
    final DataBaseService dataBaseService = new DataBaseServiceImpl();
    dataBaseService.readFile();
  }

  /**
   * Write data.
   */
  public static void writeData() {
    final DataBaseService dataBaseService = new DataBaseServiceImpl();
    dataBaseService.writeFile();
  }
}
