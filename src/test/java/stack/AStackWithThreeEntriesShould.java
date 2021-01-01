package test.java.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.Entry;
import main.java.exceptions.BadTypeException;
import main.java.exceptions.StackEmptyException;
import main.java.stack.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The Class AStackWithThreeEntriesShould.
 * Used for testing a stack with multiple entries.
 * 
 * @Author Christopher Buss.
 */
class AStackWithThreeEntriesShould {
  private Stack stack;
  private Entry entry = new Entry(10);
  private Entry entry1 = new Entry(5);
  private Entry entry2 = new Entry(7);

  /**
   * Initilisation of stack class for all relevant tests.
   * 
   * <p>Refactored from Test 11.
   */
  @BeforeEach
  void init() {
    stack = new Stack();
    stack.push(entry);
    stack.push(entry1);
    stack.push(entry2);
  }

  /**
   * Check stack has a size of three test.
   * 
   * <p>Unable to push more than one item to singular variable. ArrayList now created.
   * Push() refactored to push to List over entries variable.
   * Size() refactored due to built in size() function on ArrayList - size variable removed.
   */
  @Test 
  void haveASizeOfThreeTest() {
    assertEquals(3, stack.size());
  }

  /**
   * Have entry value of seven after one pop call.
   *
   *<p>Refactored pop() to pop item from top of ArrayList.
   */
  @Test
  void haveEntryValueOfSevenAfterOnePopCallTest() throws StackEmptyException, BadTypeException {
    assertEquals(7, stack.pop().getValue());
  }

  /**
   * Have entry value of five after two pop call test.
   *
   * <p>No refactoring required. Test passed. Works as intended,
   */
  @Test
  void haveEntryValueOfFiveAfterTwoPopCallTest() throws StackEmptyException, BadTypeException {
    stack.pop();
    assertEquals(5, stack.pop().getValue());
  }

  /**
   * Have entry value of ten after three pop call test.
   *
   * <p>No refactoring required. Test passed. Works as intended.
   */
  @Test
  void haveEntryValueOfTenAfterThreePopCallTest() throws StackEmptyException, BadTypeException {
    stack.pop();
    stack.pop();
    assertEquals(10, stack.pop().getValue());
  }

  /**
   * Throw empty stack exception when pop call three times test.
   *
   * <p>Custom exception StackEmptyException created. 
   * Pop refactored to throw StackEmptyException if size of stack is < 0.
   * Refactored previous tests that called stack.pop() to throw StackEmptyException.
   */
  @Test
  void throwEmptyStackExceptionWhenPopCallThreeTimesTest() throws StackEmptyException {
    stack.pop();
    stack.pop();
    stack.pop();
    assertThrows(StackEmptyException.class, () -> {
      stack.pop();
    });
  }
}
