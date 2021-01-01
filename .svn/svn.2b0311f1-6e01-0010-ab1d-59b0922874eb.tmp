package main.java.stack;

import java.util.ArrayList;
import java.util.List;
import main.java.Entry;
import main.java.exceptions.StackEmptyException;

/**
 * The Class Stack.
 * Used for storing entries for use in the calculator.
 * Uses a LIFO (Last In, First Out) method for storing data.
 * 
 * @Author Christopher Buss.
 */
public class Stack {
  /** List for storing stack entries. */
  private List<Entry> entries = new ArrayList<Entry>();

  /**
   * Get size of stack.
   *
   * @return int - the size of the stack 
   */
  public int size() {
    return entries.size();
  }

  /**
   * View top of stack.
   *
   * @return the entry at top of stack
   * @throws StackEmptyException if stack is empty
   */
  public Entry top() throws StackEmptyException {
    if (this.size() - 1 < 0) {
      throw new StackEmptyException("Stack is empty!");
    }
    return entries.get(this.size() - 1);
  }

  /**
   * Push to stack.
   *
   * @param entry the entry that's pushed to stack
   */
  public void push(Entry entry) {
    entries.add(entry);
  }

  /**
   * Pop from stack.
   *
   * @return the entry popped from stack
   * @throws StackEmptyException if stack is empty
   */
  public Entry pop() throws StackEmptyException {
    if (this.size() - 1 < 0) {
      throw new StackEmptyException("Stack is empty!");
    }
    Entry poppedItem = entries.get(this.size() - 1);
    entries.remove(this.size() - 1);
    return poppedItem;
  }

  /**
   * Checks if the stack is empty.
   *
   * @return True if stack is empty
   */
  public Boolean isEmpty() {
    return (this.size() == 0);
  }
}
