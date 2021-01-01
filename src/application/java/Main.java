package application.java;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Class Main.
 * Used for intialising JavaFX package.
 * 
 * @author Dave Cohen
 * @author Christopher Buss
 */
// Christopher Buss - Modified from Dave Cohen's JavaFx Observer example code
public class Main extends Application {
  static FXMLLoader loader;
  static Parent root;

  /**
   * Creates the scene for the GUI.
   *
   * @param primaryStage the primary stage
   */
  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(root, 400, 400);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * The main method.
   * Displays GUI view or ASCII view depending on how program is launched.
   *
   * @param args The command line arguments
   * @throws IOException The program exits if it cannot start the GUI
   */
  public static void main(String[] args) throws IOException {
    Boolean ascii = false;
    ViewInterface v;

    if (System.console() != null) {
      ascii = true;
    }

    // Create desired view type.
    if (ascii) {
      v = new AsciiView();
    } else {
      loader = new FXMLLoader(application.java.Main.class.getResource("GuiConfig.fxml"));
      root = loader.load();
      v = loader.getController();
    }

    // Controller is decoupled from the actual type of view
    new Controller(v);

    // Start collecting user interactions
    if (ascii) {
      ((AsciiView) v).menu();
      // We need to explicitly exit here because the Application has been
      // automatically started
      System.exit(0);
    } else {
      Application.launch(args);
    }
  }
}
