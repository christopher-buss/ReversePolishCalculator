package main.java;

/**
 * The Enum Symbol.
 * Symbols needed for arithmetic operations.
 * 
 * @Author Christopher Buss.
 */
public enum Symbol {
  LEFT_BRACKET("(", Integer.MAX_VALUE),
  RIGHT_BRACKET(")", Integer.MAX_VALUE),
  TIMES("*", 2),
  DIVIDE("/", 2),
  PLUS("+", 1),
  MINUS("-", 1),
  INVALID("$", Integer.MIN_VALUE),
  ;

  /** Stored symbol. */
  private String symbol;
  
  private int precedence;

  /**
   * Instantiates a new symbol enum.
   *
   * @param symbol - the symbol associated with the enum name.
   */
  private Symbol(String symbol, int precedence) {
    this.symbol = symbol;
    this.precedence = precedence;
  }

  /**
   * Gets the string representation of the symbol.
   * 
   * @return symbol string representation
   */
  public String toString() {
    return this.symbol;
  }
  
  /**
   * Gets the precedence of the symbol for mathematical comparison.
   * 
   * @return precedence of symbol
   */
  public int getPrecendence() {
    return this.precedence;
  }
}

