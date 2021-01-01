package application.java;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * The Class AsciiView.
 * Used for presenting GUI for calculator.
 * 
 * @author Dave Cohen
 * @author Christopher Buss
 */
// Christopher Buss - Modified from Dave Cohen's JavaFx Observer example code
public class AsciiView implements ViewInterface {
 
  private String question;
  Observer calc = null;
  Consumer<OpType> changeType = null;

  /**
   * Displays main menu to user.
   */
  public void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();

    // The order of these checks is critical because hasNext blocks
    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.charAt(0)) {
        case 'C':
        case 'c':
          if (calc != null) {
            calc.tell();
          }
          break;
        case 'I':
        case 'i':
          if (changeType != null) {
            changeType.accept(OpType.INFIX);
          }
          break;
        case 'P':
        case 'p':
          if (changeType != null) {
            changeType.accept(OpType.POSTFIX);
          }
          break;
        case '?':
          question = t.substring(1);
          System.out.println("Question set to: " + question);
          break;
        case 'Q':
        case 'q':
          System.out.println("Bye");
          finished = true;
          break;
        default:
          help();
      }
    }
    s.close();
  }

  /**
   * Prints out help menu to user.
   */
  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("  ?Expression - to set expression");
    System.out.println("  P - to change to postfix");
    System.out.println("  I - to change to infix");
    System.out.println("  C - to calculate");
    System.out.println("  Q - to exit");
  }

  /**
   * Adds the calc observer.
   *
   * @param f the observer
   */
  public void addCalcObserver(Observer f) {
    calc = f;
  }

  /**
   * Adds the type observer.
   *
   * @param l the consumer.
   */
  public void addTypeObserver(Consumer<OpType> l) {
    changeType = l;
  }

  /**
   * Gets the expression.
   *
   * @return the expression
   */
  public String getExpression() {
    return question;
  }

  /**
   * Sets the answer.
   *
   * @param a the new answer
   */
  public void setAnswer(String a) {
    System.out.println("Answer is just around the corner");
  }

}
