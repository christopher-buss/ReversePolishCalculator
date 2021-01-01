package main.java;

import main.java.exceptions.InvalidExpressionException;
import main.java.exceptions.StackEmptyException;

/**
 * Generic interface for allowing calculation of string expressions.
 * 
 * @author Christopher Buss
 */
public interface Calculator {
  
  /**
   * Evaluate infix or postfix expression.
   *
   * @param expression the infix or postfix expression
   * @return the evaluated expression
   * @throws InvalidExpressionException if invalid expression
   * @throws StackEmptyException if stack is empty
   */
  public float evaluate(String expression) throws InvalidExpressionException, StackEmptyException;
}
