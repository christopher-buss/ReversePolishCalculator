package main.java.stack;

import main.java.Entry;
import main.java.Symbol;
import main.java.exceptions.BadTypeException;
import main.java.exceptions.StackEmptyException;

/**
 * The Class OpStack.
 * 
 * <p>A facade of the Stack Class for Operators (such as + or -).
 * 
 * @author Christopher Buss.
 */
public class OpStack {
  
  /** The op stack. */
  Stack opStack = new Stack();
  
  /**
   * Push entry to stack.
   *
   * @param i the symbol entry to push
   */
  public void push(Symbol i) {
    this.opStack.push(new Entry(i));
  }  
  
  /**
   * Pop operator.
   *
   * @return the symbol popped from the stack
   * @throws StackEmptyException the stack empty exception
   */
  public Symbol pop() throws StackEmptyException {
    try {
      return this.opStack.pop().getSymbol();
    } catch (BadTypeException e) {
      return Symbol.INVALID;
    }
  }
  
  /**
   * Checks if the stack is empty.
   *
   * @return boolean true if stack empty
   */
  public Boolean isEmpty() {
    return this.opStack.isEmpty();
  }

  /**
   * View top of stack.
   *
   * @return symbol at top of stack
   * @throws StackEmptyException if stack empty
   */
  public Symbol top() throws StackEmptyException {
    try {
      return this.opStack.top().getSymbol();
    } catch (BadTypeException e) {
      return Symbol.INVALID;
    }
  }
}
