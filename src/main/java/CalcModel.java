package main.java;

import application.java.OpType;
import main.java.exceptions.InvalidExpressionException;
import main.java.exceptions.StackEmptyException;

/**
 * The Class CalcModel.
 * Used for calling the correct calculator when expression passed.
 * 
 * @author Christopher Buss.
 */
public class CalcModel {
  private Exception exception;
  
  /** The current type of calculator. */
  private Calculator current = new RevPolishCalc(); // By default calculator is set to postfix
  
  /**
   * Evaluates infix or postfix expression depending on current expression.
   *
   * @param expression the passed infix or postifx expression
   * @return float the evaluated expression or -infinity if expression evaluated unsuccessfully
   * @throws InvalidExpressionException if expression is invalid
   * @throws StackEmptyException if the stack is empty
   */
  public float evaluate(String expression) {    
    try {
      return current.evaluate(expression);
    } catch (InvalidExpressionException | StackEmptyException e) {
      exception = e;
      return Float.NEGATIVE_INFINITY;
    }
  }
  
  /**
   * Sets the current variable to the expression to be called.
   *
   * @param type the new type
   */
  public void setType(OpType type) {
    this.current = (type == OpType.INFIX ? new StandardCalc() : new RevPolishCalc());
  }
  
  /**
   * Gets the exception returned by the calculator.
   *
   * @return exception
   */
  public Exception getException() {
    return this.exception;
  }
}
