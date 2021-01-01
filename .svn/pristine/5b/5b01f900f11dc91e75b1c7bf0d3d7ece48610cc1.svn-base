package test.java.calcmodel;

import static org.junit.Assert.assertEquals;

import application.java.OpType;
import main.java.CalcModel;
import main.java.exceptions.InvalidExpressionException;
import main.java.exceptions.StackEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 
/**
 * The Class ACalcModelShould.
 * Used for testing different calculators when calling CalcModel.
 * 
 * @author Christopher Buss.
 */
class ACalcModelShould {
  CalcModel cm;
  
  /**
   * Initialisation of entry class for all relevant tests.
   */
  @BeforeEach
  void init() {
    cm = new CalcModel();
  }

  /**
   * Return correct value after postfix call test.
   */
  @Test
  void returnCorrectValueAfterPostfixCallTest() throws InvalidExpressionException, 
      StackEmptyException {
    cm.setType(OpType.POSTFIX);
    assertEquals(14f, cm.evaluate("7 7 +"), 0f);
  }
  
  /**
   * Return correct value after infix call test.
   */
  @Test
  void returnCorrectValueAfterInfixCallTest() throws InvalidExpressionException, 
      StackEmptyException {
    cm.setType(OpType.INFIX);
    assertEquals(14f, cm.evaluate("7 + 7"), 0f);
  }
}
