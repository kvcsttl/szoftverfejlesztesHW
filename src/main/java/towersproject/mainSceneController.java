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
    private StackPane firstTower, secondTower, thirdTower;
    private int numDiscs = 8;

    @FXML
    private void startSolution(ActionEvent actionEvent) {
        Alert about = new Alert(Alert.AlertType.INFORMATION);
        about.setTitle("Infó");
        about.setHeaderText("Figyelem!");
        about.setContentText("Mivel ez nem egy játék, a gomb megnyomása után\n a feladat magától fog megoldódni.");
        about.showAndWait();
    }

    private void moveDisc(StackPane fromTower, StackPane targetTower) {
        Rectangle disc = (Rectangle) fromTower.getChildren().remove(fromTower.getChildren().size()-1);
        targetTower.getChildren().add(disc);
        Alert about = new Alert(Alert.AlertType.INFORMATION);
        about.setTitle("Infó");
        about.setHeaderText("Figyelem!");
        about.setContentText("Mivel ez nem egy játék, a gomb megnyomása után\n a feladat magától fog megoldódni.");
        about.showAndWait();
    }

    private void solveHanoi(int numDiscs, StackPane fromTower, StackPane targetTower, StackPane helpTower) {
        if (numDiscs == 1){
            moveDisc(fromTower, targetTower);
        }else{
            solveHanoi(numDiscs-1, fromTower, helpTower, targetTower);
            moveDisc(fromTower, targetTower);
            solveHanoi(numDiscs-1, helpTower, targetTower, fromTower);
        }
    }

    @FXML
    private void exitApp(ActionEvent actionEvent) {
        Logger.info("Exiting");
        Platform.exit();
    }
    @FXML
    public void solve(){

    }
}
