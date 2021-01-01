package test.java.entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.Entry;
import main.java.exceptions.BadTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The Class AnEntryWithValueConstructorShould.
 * Used for testing an entry with a value constructor.
 * 
 * @Author Christopher Buss.
 */
class AnEntryWithValueConstructorShould {  
  private Entry entry;

  /**
   * Initialisation of entry class for all relevant tests.
   */  
  @BeforeEach
  void init() {
    entry = new Entry(5);
  }

  /**
   * Check that value of entry corresponds to value.
   * 
   * <p>Arbitary value passed and returned to pass test.
   */
  @Test 
  void beAbleToGetValueTest() throws BadTypeException {
    assertEquals(5f, entry.getValue());
  }

  /**
   * Check that bad type exception thrown if symbol constructor used.
   * 
   * <p>Refactored test 17 to store symbol as variable.
   * If symbol is null, throw exception. 
   */
  @Test
  void throwBadTypeExceptionIfNoSymbolTest() {
    assertThrows(BadTypeException.class, () -> {
      entry.getSymbol();
    });
  }
}
