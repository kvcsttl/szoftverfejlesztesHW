package towersproject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.tinylog.Logger;

public class mainSceneController {

    @FXML
    private void start(ActionEvent actionEvent) {
        Logger.info("Popping alert");
        Alert about = new Alert(Alert.AlertType.INFORMATION);
        about.setTitle("Infó");
        about.setHeaderText("Figyelem!");
        about.setContentText("Mivel ez nem egy játék, a gomb megnyomása után\n a feladat magától fog megoldódni.\nA megoldást a konzolon követheted.");
        about.showAndWait();
        Logger.info("Solving started");
        solution();
        Logger.info("Solving finished");
    }

    private void solution() {
        var h = new Hanoi();
        h.solve();
    }

    @FXML
    private void exitApp(ActionEvent actionEvent) {
        Logger.info("Exiting");
        Platform.exit();
    }

}
