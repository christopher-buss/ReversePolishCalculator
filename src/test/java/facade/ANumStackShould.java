package test.java.facade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import main.java.exceptions.StackEmptyException;
import main.java.stack.NumStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Class ANumStackShould.
 * Used for testing a numStack.
 *
 * @author Christopher Buss.
 */
class ANumStackShould {  
  /** The num stack. */
  private NumStack numStack;
  
  /**
   * Initialisation of numstack class for all relevant tests.
   * 
   * <p>Refactored after more than one class needed same test.
   * Different stacks tests put into seperate classes for same init statements. 
   */  
  @BeforeEach
  void init() {
    numStack = new NumStack();
  }

  /**
   * Have A size of zero with no entries test.
   * 
   * <p>Returned an arbitary value to pass test.
   */
  @Test
  void haveASizeOfZeroWithNoEntriesTest() {
    assertEquals(0, numStack.size());
  }

  /**
   * Have A size of one with one entry test.
   * 
   * <p>Refactored code from test 30 to no longer return arbitary value.
   */
  @Test
  void haveASizeOfOneWithOneEntryTest() {
    numStack.push(5f);
    assertEquals(1, numStack.size());
  }
  
  /**
   * Should return value pushed to the stack.
   */
  @Test
  void returnValuePushedToStackTest() throws StackEmptyException {
    numStack.push(5f);
    assertEquals(5f, numStack.pop(), 0f);
  }
  
  /**
   * Should return true if the stack is empty.
   */
  @Test
  void returnTrueWhenStackIsEmptyTest() {
    assertTrue(numStack.isEmpty());
  }  
  
  /**
   * Should return false if stack is not empty.
   */
  @Test
  void returnFalseWhenStackIsNotEmptyTest() {
    numStack.push(5f);
    assertFalse(numStack.isEmpty());
  }
}
