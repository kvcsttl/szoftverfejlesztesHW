package towersproject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import org.tinylog.Logger;

public class mainSceneController {

    @FXML
    private void startSolution(ActionEvent actionEvent) {
        Alert about = new Alert(Alert.AlertType.INFORMATION);
        about.setTitle("Infó");
        about.setHeaderText("Figyelem!");
        about.setContentText("Mivel ez nem egy játék, a gomb megnyomása után\n a feladat magától fog megoldódni.");
        about.showAndWait();
    }

    @FXML
    private void exitApp(ActionEvent actionEvent) {
        Logger.info("Exiting");
        Platform.exit();
    }
}
