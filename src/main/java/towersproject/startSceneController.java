package towersproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import org.tinylog.Logger;

public class startSceneController {

    @FXML
    private void switchToMainScene(ActionEvent event) throws IOException {
        Logger.info("Switching to the second scene.");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mainScene.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
