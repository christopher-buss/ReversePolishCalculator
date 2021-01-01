package test.java.stack;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.exceptions.StackEmptyException;
import main.java.stack.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Class ANewlyCreatedStackShould.
 * Used for testing an empty stack.
 * 
 * @Author Christopher Buss.
 */
class ANewlyCreatedStackShould {
  private Stack stack;

  /**
   * Initialisation of stack class for all relevant tests.
   * 
   * <p>Refactored after more than one class needed same test.
   * Different stacks tests put into seperate classes for same init statements. 
   */
  @BeforeEach
  void init() {
    stack = new Stack();
  }

  /**
   * Check that stack size getter works.
   * 
   * <p>Returned arbitary value to allow test to pass.
   */
  @Test
  void haveASizeOfZeroTest() {
    assertEquals(0, stack.size());
  }

  /**
   * Check that stack is empty.
   * 
   * <p>Returned true.
   */
  @Test
  void returnTrueWhenEmpty() {
    assertTrue(stack.isEmpty());
  }

  /**
   * Throw empty stack exception when checking top of stack test.
   * 
   * <p>Custom exception EmptyStackException created.
   * Top() refactored to throw exception if size of stack is 0.
   * Refactored previous tests that called stack.top() to throw StackEmptyException.
   */
  @Test
  void throwEmptyStackExceptionWhenCheckingTopOfStackTest() {
    assertThrows(StackEmptyException.class, () -> {
      stack.top();
    });
  }

  /**
   * Throw empty stack exception when popping from stack test.
   * 
   * <p>No refactoring required. Test passed. Works as intended.
   */  
  @Test
  void throwEmptyStackExceptionWhenPoppingFromStackTest() {
    assertThrows(StackEmptyException.class, () -> {
      stack.pop();
    });
  }
}
