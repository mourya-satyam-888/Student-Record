package org.studentrecord.testsstructure;

/**
 * The type Base test.
 */
public class BaseTest {
  /**
   * The Test name.
   */
  public String testName;
  /**
   * The Error message.
   */
  public String errorMessage;
  /**
   * The Error expected.
   */
  public Boolean errorExpected;

  /**
   * Gets test name.
   *
   * @return the test name
   */
  public String getTestName() {
    return testName;
  }

  /**
   * Sets test name.
   *
   * @param testName the test name
   */
  public void setTestName(String testName) {
    this.testName = testName;
  }

  /**
   * Gets error message.
   *
   * @return the error message
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * Sets error message.
   *
   * @param errorMessage the error message
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * Gets error expected.
   *
   * @return the error expected
   */
  public Boolean getErrorExpected() {
    return errorExpected;
  }

  /**
   * Sets error expected.
   *
   * @param errorExpected the error expected
   */
  public void setErrorExpected(Boolean errorExpected) {
    this.errorExpected = errorExpected;
  }
}
