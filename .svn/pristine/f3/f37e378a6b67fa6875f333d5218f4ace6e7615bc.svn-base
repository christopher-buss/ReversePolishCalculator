package test.java.facade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import main.java.Symbol;
import main.java.exceptions.BadTypeException;
import main.java.exceptions.StackEmptyException;
import main.java.stack.OpStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Class AnOpStackShould.
 * 
 * @author Christopher Buss.
 */
class AnOpStackShould {
  
  /** The op stack. */
  private OpStack opStack;
  
  /**
   * Initialisation of opstack class for all relevant tests.
   */
  @BeforeEach
  void init() {
    opStack = new OpStack();
  }
  
  /**
   * Return value pushed to stack test.
   *
   * @throws StackEmptyException the stack empty exception
   */
  @Test
  void returnValuePushedToStackTest() throws StackEmptyException {
    opStack.push(Symbol.MINUS);
    assertEquals(Symbol.MINUS, opStack.pop());
  }
  
  /**
   * Should return true if the stack is empty.
   */
  @Test
  void returnTrueWhenStackIsEmptyTest() {
    assertTrue(opStack.isEmpty());
  }  
  
  /**
   * Should return false if stack is not empty.
   */
  @Test
  void returnFalseWhenStackIsNotEmptyTest() {
    opStack.push(Symbol.PLUS);
    assertFalse(opStack.isEmpty());
  } 
  
  /**
   * Return value at top of stack without popping from stack test.
   *
   * @throws StackEmptyException the stack empty exception
   * @throws BadTypeException the bad type exception
   */
  @Test
  void returnValueAtTopOfStackWithoutPoppingFromStackTest() throws 
        StackEmptyException, BadTypeException {
    opStack.push(Symbol.PLUS);
    opStack.push(Symbol.DIVIDE);
    assertEquals("Entry peeked", opStack.top(), Symbol.DIVIDE);
    assertEquals("Entry popped is not the entry that should be at top of stack",
        opStack.pop(), Symbol.DIVIDE);
  }
}
