package application.java;

import main.java.CalcModel;
import main.java.exceptions.InvalidExpressionException;
import main.java.exceptions.StackEmptyException;

/**
 * The Class Controller.
 * Used to decouple the UI interface from the calculator.
 * 
 * @author Christopher Buss.
 */
public class Controller {  
  
  ViewInterface view = null;
  private CalcModel cmod = new CalcModel();
  
  /**
   * Calculate the given expression.
   *
   * @throws InvalidExpressionException the invalid expression exception
   * @throws StackEmptyException the stack empty exception
   */
  public void calculate() {
    Float evaluation = cmod.evaluate(view.getExpression());
    if (evaluation == Float.NEGATIVE_INFINITY) {
      /* Display exception message */
      view.setAnswer(cmod.getException().getMessage());
    } else {
      /* Display evaluated method result */
      view.setAnswer(evaluation.toString());
    }
  }

  /**
   * Change type of calculator.
   *
   * @param type the type
   */
  public void changeType(OpType type) {
    this.view.setAnswer("Changed to " + type);
    cmod.setType(type);
  }
  
  /**
   * Instantiates a new controller.
   *
   * @param view the view
   */
  public Controller(ViewInterface view) {
    this.view = view;
    view.addCalcObserver(this::calculate);
    view.addTypeObserver(this::changeType);
  }
}
