package test.java.evaluations;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.StandardCalc;
import main.java.exceptions.BadTypeException;
import main.java.exceptions.InvalidExpressionException;
import main.java.exceptions.StackEmptyException;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

/**
 * The Class AStandardCalcShould.
 * Used for testing the convertion of infix to postfix notation.
 * 
 * <p>https://schuchert.github.io/wikispaces/pages/Katas.ShuntingYardAlgorithm
 * Tests based from ShuntingYardAlgorithm Katas @author schuchert
 * 
 * @author Christopher Buss.
 * 
 */
class AStandardCalcShould {
  private StandardCalc calc;
  
  /**
   * Initialisation of shunting algorithm class for all relevant tests.
   */
  @BeforeEach
  void init() {
    calc = new StandardCalc();
  }
  
  /**
   * Throw invalidexpression exception if the string supplied is empty test.
   */
  @Test
  void throwInvalidExpressionIfStringSuppliedEmptyTest() throws InvalidExpressionException, 
      StackEmptyException, BadTypeException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate("");
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception);    
  }
  
  /**
   * Throw invalidexpression exception if the string supplied is null test.
   */
  @Test
  void throwInvalidExpressionIfStringSuppliedNullTest() throws StackEmptyException, 
      BadTypeException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate(null);
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception);    
  }
  
  /**
   * Be able to handle a simple literal number that doesn't need converting test.
   */
  @Test
  void beAbleToHandleSimpleLiteralNumberTest() throws InvalidExpressionException, 
      StackEmptyException, BadTypeException {
    assertEquals(45f, calc.evaluate("45"), 0f);
  }
   
  /**
   * Be able to translate a simple infix expression into postfix test.
   */  
  @Test
  void translateBasicInfixToPostfix() throws InvalidExpressionException, 
      StackEmptyException, BadTypeException {
    assertEquals(11f, calc.evaluate("3 + 8"), 0f);
  }
  
  /**
   * Be able to translate a simple infix expression into postfix test.
   */ 
  @Test
  void translateAnotherBasicInfixToPostfixTest() throws InvalidExpressionException,
      StackEmptyException, BadTypeException {
    assertEquals(-2f, calc.evaluate("2 - 4"));
  }
  
  /**
   * Be able to translate an infix expression with mutiple operators into postfix test.
   */ 
  @Test
  void translateInfixExpWithMultipleOperatorsToPostfixTest() throws InvalidExpressionException,
      StackEmptyException, BadTypeException {
    assertEquals(5f, calc.evaluate("2 + 9 - 6"));
  }  
  
  /**
   * Be able to translate an infix expression with mutiple operators of different
   * precedence into postfix test.
   */ 
  @Test
  void translateInfixExpWithMultipleOperatorsOfDifferentPrecendeceToPostfixTest() throws 
      InvalidExpressionException, StackEmptyException, BadTypeException {
    assertEquals(56f, calc.evaluate("2 + 9 * 6"), 0f);
  }
  
  /**
   * Handle simple brackets test.
   */
  @Test
  void handleSimpleBracketsTest() throws InvalidExpressionException, 
      StackEmptyException, BadTypeException {
    assertEquals(7f, calc.evaluate("(3 + 4)"), 0f);
  }
  
  /**
   * Handle brackets with multiple operators of different prescedence test.
   */
  @Test
  void handleMoreComplicatedBracketsTest() throws InvalidExpressionException, 
      StackEmptyException, BadTypeException {
    assertEquals(35f, calc.evaluate("(3 + 4) * 5"), 0f);
  }
  
  /**
   * Handle no spaces used in infix notation test.
   */
  @Test
  void handleALackOfSpacesTest() throws InvalidExpressionException, 
      StackEmptyException, BadTypeException {
    assertEquals(12f, calc.evaluate("(3+(4-5))*6"), 0f);
  }
  
  /**
   * Throw InvalidExpressionException if brackets do not align test.
   */
  @Test
  void notAllowMismatchedBracketsTest() throws StackEmptyException, BadTypeException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate("(4 + (5)");
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception); 
  } 
  
  /**
   * Check that operators that are not allowed throw error test.
   */
  @Test
  void notAllowInvalidOperatorsTest() throws StackEmptyException, BadTypeException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate("3 £ 4");
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception); 
  }
  
  /**
   * Allow for decimal inputs test.
   */
  @Test
  void allowForDecimalInputsTest() throws InvalidExpressionException, 
      StackEmptyException, BadTypeException {
    assertEquals(7.2f, calc.evaluate("2.4 * 3"), 0.001f);
  }
  
  /**
   * Not allow the invalid symbol test.
   */
  @Test
  void notAllowInvalidSymbolTest() throws StackEmptyException, BadTypeException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate("3 $ 4"); // The symbol for invalid 
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception);
  }
}
