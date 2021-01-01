package main.java.stack;

import main.java.Entry;
import main.java.exceptions.BadTypeException;
import main.java.exceptions.StackEmptyException;

/**
 * The Class NumStack.
 * 
 * <p>A facade of the Stack Class to provide a stack that only takes float values.
 * This is because Reverse Polish Notation (RPN) only uses a stack of numeric values.
 * 
 * @author Christopher Buss.
 */
public class NumStack {
  
  /** The num stack. */
  private Stack numStack = new Stack();

  /**
   * Get the size of stack.
   *
   * @return int - the size of the stack
   */
  public int size() {
    return numStack.size();
  }

  /**
   * Push float value to stack.
   *
   * @param i the float value to be pushed to stack
   */
  public void push(float i) {
    this.numStack.push(new Entry(i));
  }

  /**
   * Pop float value from stack.
   *
   * @return getValue from stack else infinity if float value not present.
   */
  public float pop() throws StackEmptyException {
    try {
      return this.numStack.pop().getValue();
    } catch (BadTypeException e) {
      return Float.POSITIVE_INFINITY;
    }
  } 

  /**
   * Checks if the stack is empty.
   *
   * @return boolean true if stack empty
   */
  public Boolean isEmpty() {
    return this.numStack.isEmpty();
  } 
}
