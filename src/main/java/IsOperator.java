package main.java;

/**
 * The Class IsOperator.
 * Used to check if a string token is an operator (+*-/).
 */
public class IsOperator {
  
  /** Used to store Symbol operator if found. */
  private static Symbol op;
  
  /**
   * Checks if token is operator.
   * Iterates through the Symbol enum to check if the token is present.
   *
   * @param token the inputted string
   * @return true if token is an operator
   */
  protected boolean isOperator(String token) {
    if (!(token.equals("(") || token.equals(")") || token.equals("$"))) {    
      for (Symbol operator : Symbol.values()) {
        if (operator.toString().equals(token)) {
          op = operator;
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Gets the operator found.
   *
   * @return the operator
   */
  public static Symbol getOp() {
    return op;
  }
}
