/**
 * This is filled by the fxml loader at runtime.
 */

package application.java;

import java.util.function.Consumer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

/**
 * The Class GuiView.
 * Used for presenting GUI for calculator.
 * 
 * @author Dave Cohen
 * @author Christopher Buss
 */
// Christopher Buss - Modified from Dave Cohen's JavaFx Observer example code
public class GuiView implements ViewInterface {
  /**
   * Adds the calc observer.
   *
   * @param f the observer
   */
  public void addCalcObserver(Observer f) {
    calcButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        f.tell();
      }
    });
  }

  /**
   * Adds the type observer.
   *
   * @param l the consumer
   */
  public void addTypeObserver(Consumer<OpType> l) {
    type.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      
      @Override
      public void changed(ObservableValue<? extends Toggle> observable,
          Toggle from, Toggle to) {
        l.accept(to == postfixButton ? OpType.POSTFIX : OpType.INFIX);
      }
    });
  }

  /**
   * Gets the expression to evaluate.
   *
   * @return the infix / postfix expression
   */
  public String getExpression() {
    return question.getText();
  }

  /**
   * Sets the answer field to equal expression.
   *
   * @param answer the new entry
   */
  public void setAnswer(String answer) {
    this.answer.setText(answer);
  }
    
  /* FXML elements for GUI */
  
  @FXML
  // fx:id="calcButton"
  private Button calcButton; // Value injected by FXMLLoader

  @FXML
  // fx:id="infixButton"
  private RadioButton infixButton; // Value injected by FXMLLoader

  @FXML
  // fx:id="type"
  private ToggleGroup type; // Value injected by FXMLLoader

  @FXML
  // fx:id="postfixButton"
  private RadioButton postfixButton; // Value injected by FXMLLoader

  @FXML
  // fx:id="question"
  private TextField question; // Value injected by FXMLLoader

  @FXML
  // fx:id="answer"
  private Label answer; // Value injected by FXMLLoader
}
