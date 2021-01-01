package test.java.stack;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.Entry;
import main.java.exceptions.BadTypeException;
import main.java.exceptions.StackEmptyException;
import main.java.stack.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The Class AStackWithOneEntryShould.
 * Used for testing a stack with one entry.
 * 
 * @Author Christopher Buss.
 */
class AStackWithOneEntryShould {
  private Stack stack;
  private Entry entry;

  /**
   * Initialisation of stack class for all relevant tests.
   */
  @BeforeEach
  void init() {
    stack = new Stack();
    entry = new Entry(10);
    stack.push(entry);
  }

  /**
   * Push entry onto stack test.
   * 
   * <p>Entry class formed with arbitary getValue reference. No functionality added.
   * Entry is passed to variable in Stack.
   * Top() function created to retrieve variable from Stack.
   */
  @Test
  void checkThatEntryPushedToStackTest() throws StackEmptyException, BadTypeException {
    assertEquals(10, stack.top().getValue());
  }

  /**
   * Check stack now has a size of one.
   * 
   * <p>Test 1 refactored to be stored as a variable.
   */
  @Test
  void haveASizeOfOneTest() {
    assertEquals(1, stack.size());
  }
  
  /**
   * Check that stack is not empty.
   */
  @Test
  void returnFalseAsNotEmpty() {
    assertFalse(stack.isEmpty());
  }

  /**
   * Pop correct entry from stack test.
   *
   *<p>Removed entry from variable and got value of entry.
   */
  @Test
  void popCorrectEntryFromStackTest() throws StackEmptyException, BadTypeException {
    assertEquals(10, stack.pop().getValue());
  }

  /**
   * Have A size of zero after pop() call test.
   *
   * <p>Reduced size of size variable by 1.
   */
  @Test
  void haveASizeOfZeroAfterPopCallTest() throws StackEmptyException {
    stack.pop();
    assertEquals(0, stack.size());
  }

  /**
   * Get correct entry from top() call.
   * 
   *<p>Check entry value is same as matched.
   */
  @Test
  void getCorrectEntryFromStackTest() throws StackEmptyException, BadTypeException {
    assertEquals(10, stack.top().getValue());
  }

  /**
   * Have A size of one after top() call test.
   *
   * <p>Did not decrease size variable by 1.
   */
  @Test
  void haveASizeOfOneAfterTopCallTest() throws StackEmptyException {
    stack.top();
    assertEquals(1, stack.size());
  }
}