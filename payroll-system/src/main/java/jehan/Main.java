package jehan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * Main class for launching the JavaFX application.
 */
public class Main extends Application {

    /**
     * The entry point for the JavaFX application.
     *
     * @param primaryStage The primary stage for this application.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Prince Finishing Payroll System");
            primaryStage.setResizable(false);
            
            Image icon = new Image((getClass().getResourceAsStream("/images/payroll_icon.png")));
            primaryStage.getIcons().add(icon);
            
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The main method that launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
