package main.java.exceptions;

/**
 * The Class InvalidExpressionException. 
 * Thrown when the type called does not match entries actual type.
 * 
 * @Author Christopher Buss.
 */
@SuppressWarnings("serial")
public class InvalidExpressionException extends Exception {

  /**
   * Instantiates a new invalid expression exception.
   *
   * @param message - the error statement provided on exception call
   */
  public InvalidExpressionException(String message) {
    super(message);
  }
}
