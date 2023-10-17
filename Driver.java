package cs3500.pa05;

import cs3500.pa05.controller.WelcomeController;
import cs3500.pa05.view.BujoView;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Represents an interactive bullet journal with a GUI.
 */
public class Driver extends Application {
  /**
   * Starts the GUI for a simple interactive journal.
   *
   * @param primaryStage the JavaFX stage to add elements to
   */
  @Override
  public void start(Stage primaryStage) {
    StackPane root = new StackPane();
    root.setStyle("-fx-background-color: #1B03A3");
    Scene scene = new Scene(root, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.show();

    PauseTransition pause = new PauseTransition(Duration.seconds(2));
    pause.setOnFinished(e -> {
      Platform.runLater(() -> {
        // Code executed on the JavaFX Application Thread
        // instantiate a simple welcome GUI view
        WelcomeController welcomeController = new WelcomeController(primaryStage);
        BujoView view = new BujoView(welcomeController, "Welcome.fxml");

        try {
          // load and place the view's scene onto the stage
          primaryStage.setScene(view.load());
          primaryStage.setTitle("Welcome");
          welcomeController.run();

          // render the stage
          primaryStage.show();
        } catch (IllegalStateException exc) {
          System.err.println("Unable to load GUI.");
        }
      });
    });

    pause.play();
  }

  /**
   * Runs a GUI application.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    Application.launch();
  }
}
