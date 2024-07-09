package jehan.components;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class for switching scenes in a JavaFX application.
 */
public class SwitchSceneActionEvent {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Switches the scene based on the provided FXML file and title.
     *
     * @param event The ActionEvent that triggered the scene switch.
     * @param fxmlFilePath The path to the FXML file to load.
     * @param title The title for the new scene.
     * @throws IOException If the FXML file cannot be loaded.
     */
    public void switchScene(ActionEvent event, String fxmlFilePath, String title) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlFilePath));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle(title + " Section");
        stage.setScene(scene);
        stage.show();
    }
}
