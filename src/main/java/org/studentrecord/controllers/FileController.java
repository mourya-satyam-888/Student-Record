package org.studentrecord.controllers;

import org.studentrecord.services.FileService;
import org.studentrecord.services.impl.FileServiceImpl;

/**
 * The type Data base controller.
 */
public class FileController {
  /**
   * Read data.
   */
  public void readData() {
    final FileService fileService = new FileServiceImpl();
    fileService.readFile();
  }

  /**
   * Write data.
   */
  public void writeData() {
    final FileService fileService = new FileServiceImpl();
    fileService.writeFile();
  }
}
