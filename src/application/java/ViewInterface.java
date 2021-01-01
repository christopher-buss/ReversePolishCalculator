package application.java;

import java.util.function.Consumer;

/**
 * The Interface ViewInterface.
 * 
 * @author Christopher Buss
 */
public interface ViewInterface {
  
  /**
   * Gets the expression to evaluate.
   *
   * @return the infix / postfix expression
   */
  public String getExpression();
  
  /**
   * Sets the answer field to equal expression.
   *
   * @param expression the new entry
   */
  public void setAnswer(String expression);
  
  /**
   * Adds the calc observer.
   *
   * @param f the observer
   */
  public void addCalcObserver(Observer f);
  
  /**
   * Adds the type observer.
   *
   * @param type the type (infix or postfix)
   */
  public void addTypeObserver(Consumer<OpType> type);  
}
