package test.java.entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.Entry;
import main.java.Symbol;
import main.java.exceptions.BadTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The Class AnEntryWithSymbolConstructorShould.
 * Used for testing an entry with Symbol constructor.
 * 
 * @Author Christopher Buss.
 */
class AnEntryWithSymbolConstructorShould {
  private Entry entry;
  
  /**
   * Initialisation of entry class for all relevant tests.
   */  
  @BeforeEach
  void init() {
    entry = new Entry(Symbol.PLUS);
  }
  
  /**
   * Be able to get symbol test.
   *
   * <p>Created symbol enum with singular value 'PLUS' to satisfy test.
   * GetSymbol created, returning arbitary value.
   */
  @Test
  void beAbleToGetSymbolTest() throws BadTypeException {
    assertEquals(Symbol.PLUS, entry.getSymbol());
  }
 
  /**
   * Throw bad type exception if no value test.
   * 
   * <p>Refactored getSymbol(), getString() to use Type enum for consistency.
   */
  @Test
  void throwBadTypeExceptionIfNoValueTest() {
    assertThrows(BadTypeException.class, () -> {
      entry.getValue();
    });
  }
}
