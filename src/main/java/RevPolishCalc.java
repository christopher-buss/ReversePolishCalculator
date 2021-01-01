package main.java;

import main.java.exceptions.InvalidExpressionException;
import main.java.exceptions.StackEmptyException;
import main.java.stack.NumStack;

/**
 * The Class RevPolishCalc.
 * Takes a postfix expression, and using stacks, evaluates the expression,
 * returning a float of completed calculation.
 * 
 * @author Christopher Buss.
 */
public class RevPolishCalc extends IsOperator implements Calculator {
  
  /** The num stack. */
  private NumStack numStack;

  /**
   * Evaluates postfix notation.
   *
   * @param postfix the postfix
   * @return the evaluation of the postfix expression
   * @throws InvalidExpressionException postfix expression is invalid
   * @throws StackEmptyException if stack empty
   */
  public float evaluate(String postfix) throws InvalidExpressionException, StackEmptyException {
    /* Check that provided string exists */
    if (postfix == null) {
      throw new InvalidExpressionException("Input provided is null");
    }    
    
    /* Initialise num stack */
    numStack = new NumStack(); 
    
    try {
      for (String token : postfix.trim().split("\\s+")) { // Splits tokens at white space
        
        /* Push to stack if token is not a number */
        if (!this.isOperator(token)) {
          numStack.push(Float.parseFloat(token));
        } else {          
          if (numStack.size() < 2) {
            throw new InvalidExpressionException(
                "Operator before numbers, invalid expression");
          }
          
          /* Operands for arithmetic operations */
          float firstOperand = numStack.pop();
          float secondOperand = numStack.pop();
        
          /* Switch case of different operators */
          switch (getOp().toString()) {
            case "+":
              numStack.push(firstOperand + secondOperand);
              break;
            case "-":
              numStack.push(secondOperand - firstOperand);
              break;
            case "*":
              numStack.push(firstOperand * secondOperand);
              break;
            case "/":
              numStack.push(secondOperand / firstOperand);
              break;
            default:
              throw new InvalidExpressionException("Invalid input");      
          }
        }
      } 
    } catch (NumberFormatException e) {
      throw new InvalidExpressionException("Invalid input");
    }
    
    /* Check if there is only one final calculation */
    if (numStack.size() != 1) {
      throw new InvalidExpressionException("Invalid input");
    }
    
    /* Pops final postfix calcuation from stack */
    return numStack.pop();
  }
}
