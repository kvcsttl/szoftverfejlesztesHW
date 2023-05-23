package towersproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class mainSceneController {

    public void startSolution(ActionEvent actionEvent) {
        Alert about = new Alert(Alert.AlertType.INFORMATION);
        about.setTitle("Infó");
        about.setHeaderText("Figyelem!");
        about.setContentText("Mivel ez nem egy játék, a gomb megnyomása után\n a feladat magától fog megoldódni.");
        about.showAndWait();
    }
}
