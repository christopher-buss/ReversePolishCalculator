package test.java.evaluations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import main.java.RevPolishCalc;
import main.java.exceptions.InvalidExpressionException;
import main.java.exceptions.StackEmptyException;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

/**
 * The Class AReversePolishCalculatorShould.
 * Used for testing the evaluation of postfix expressions.
 * 
 * <p>https://tinyurl.com/rpn-calc-test-cases
 * Tests based from Reverse-Polish-Notation-Calculator @author michellewong910
 * 
 * @author Christopher Buss
 */
class AReversePolishCalculatorShould {
  private RevPolishCalc calc;
  
  /**
   * Initialisation of reverse polish class for all relevant tests.
   */
  @BeforeEach
  void init() {
    calc = new RevPolishCalc();
  }
  
  /**
   * Throw exception if input is null test.
   */
  @Test
  void throwExceptionIfInputIsNullTest() throws StackEmptyException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate(null);
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception);
  }
  
  /**
   * Evaluate A single number as the input test.
   */
  @Test
  void evaluateASingleNumberAsTheInputTest() throws InvalidExpressionException, 
      StackEmptyException {
    assertEquals(5f, calc.evaluate("5"), 0f);
  }
  
  /**
   * Evaluate single number plus zero test.
   */
  @Test
  void evaluateSingleNumberPlusZeroTest() throws InvalidExpressionException, StackEmptyException {
    assertEquals(5f, calc.evaluate("5 0 +"), 0f);
  }
  
  /**
   * Evaluate single number plus one test.
   */
  @Test
  void evaluateSingleNumberPlusOneTest() throws InvalidExpressionException, StackEmptyException {
    assertEquals(6f, calc.evaluate("5 1 +"), 0f);
  }
  
  /**
   * Evaluate single number minus one test.
   */
  @Test 
  void evaluateSingleNumberMinusOneTest() throws InvalidExpressionException, StackEmptyException {
    assertEquals(4f, calc.evaluate("5 1 -"), 0f);
  }  
  
  /**
   * Evaluate two operations test.
   */
  @Test
  void evaluateTwoOperationsTest() throws InvalidExpressionException, StackEmptyException {
    assertEquals(8f, calc.evaluate("5 1 - 4 +"), 0f);
  }
  
  /**
   * Evaluate two operations after each other test.
   */
  @Test
  void evaluateTwoOperationsAfterEachOtherTest() throws InvalidExpressionException, 
      StackEmptyException {
    assertEquals(2f, calc.evaluate("5 1 4 - +"), 0f);
  }
  
  /**
   * Evaluate times and divide operations test.
   */
  @Test
  void evaluateTimesAndDivideOperationsTest() throws InvalidExpressionException, 
      StackEmptyException {
    assertEquals(2f, calc.evaluate("4 2 1 * /"), 0f);
  }
  
  
  /**
   * Evaluate negative numbers test.
   */
  @Test
  void evaluateNegativeNumbersTest() throws InvalidExpressionException, StackEmptyException {
    assertEquals(-5f, calc.evaluate("-5 1 /"), 0f);
  }
  
  /**
   * Throw exception if incorrect operators used test.
   */
  @Test
  void throwExceptionIfIncorrectOperatorsUsedTest() throws StackEmptyException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate("3 % 4");
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception);
  }
  
  /**
   * Throw exception if no operators used with multiple operands test.
   */
  @Test
  void throwExceptionIfNoOperatorsUsed() throws StackEmptyException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate("3 4");
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception);
  }
  
  /**
   * Evaluate A complicated postfix expression test.
   */
  @Test
  void evaluateAComplicatedPostfixExpressionTest() throws InvalidExpressionException,
      StackEmptyException {
    assertEquals(7f, calc.evaluate("5 4 7 - + 7 * 2 * 4 /"), 0f);
  }
  
  /**
   * Allow for decimal calculations test.
   */
  @Test
  void allowForDecimalCalculationsTest() throws InvalidExpressionException, 
      StackEmptyException  {
    assertEquals(5f, calc.evaluate("2.5 2 *"), 0f);
  }
  
  /**
   * Not allow the invalid symbol test.
   */
  @Test
  void notAllowInvalidSymbolTest() throws StackEmptyException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate("3 $ 4"); // The symbol for invalid 
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception);
  }
  
  /**
   * Not allow a single operator test.
   */
  @Test
  void notAllowSingleOperatorTest() throws StackEmptyException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate("+"); 
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception);
  }
  
  /**
   * Not allow a single digit followed by an operator.
   */
  @Test
  void notAllowSingleNumberFollowedByOperator() throws StackEmptyException {
    InvalidExpressionException exception = null;
    try {
      calc.evaluate("5 +"); 
    } catch (InvalidExpressionException e) {
      exception = e;
    }
    assertNotNull(exception);
  }
}
