package org.studentrecord.exceptions;

import org.studentrecord.enums.ExceptionCode;

/**
 * The type File exception.
 */
@SuppressWarnings("serial")
public class FileException extends BaseApplicationException {

  /**
   * Instantiates a new File exception.
   *
   * @param message the message
   */
  public FileException(final String message) {
    super(message, ExceptionCode.FILE_ERROR);
  }
}

