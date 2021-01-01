package test.java.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import main.java.Symbol;
import main.java.Type;
import org.junit.jupiter.api.Test;

/**
 * The Class AnEnumShould.
 * Used for testing the creation and matching of enums.
 * 
 * @Author Christopher Buss.
 */
class AnEnumShould {  
  
  /** The symbol. */
  private Symbol[] symbol = {Symbol.PLUS, Symbol.LEFT_BRACKET, Symbol.RIGHT_BRACKET, 
      Symbol.TIMES, Symbol.DIVIDE, Symbol.MINUS, Symbol.INVALID};
  
  /** The type. */
  private Type[] type = {Type.NUMBER, Type.SYMBOL, Type.STRING, Type.INVALID};  
  
  /** The arithmetic operations the string types represent. */
  private String[] stringRepresentation = {"+", "(", ")", "*", "/", "-", "$"};
  
  /** A printable representation of the type enum. */
  private String[] typeRepresentation = {"Number", "Symbol", "String", "Invalid"};
  
  /**
   * Check that all required types are in enum.
   */
  @Test
  void haveTypePresentInEnumTest() {
    for (int i = 0; i < type.length; i++) {
      assertFalse(symbol[i] == null);
    }
  } 
  
  /**
   * Check that the Type has a printable representation.
   * 
   * <p>Added corresponding values to Type enum class.
   */
  @Test
  void haveTypeRefferingToRepresentationTest() {
    for (int i = 0; i < type.length; i++) {
      assertEquals(typeRepresentation[i], type[i].toString());
    }
  }
  
  /**
   * Check that all required Symbols are in enum.
   */
  @Test
  void haveSymbolPresentInEnumTest() {
    for (int i = 0; i < symbol.length; i++) {
      assertFalse(symbol[i] == null);
    }
  } 
  
  /**
   * Check that each Symbol matches its arithmetic operation.
   * 
   * <p>Added corresponding values to String enum class.
   */
  @Test
  void haveSymbolRefferingToRepresentationTest() {
    for (int i = 0; i < symbol.length; i++) {
      assertEquals(stringRepresentation[i], symbol[i].toString());
    }
  }
}


