package miniGame.model.utils;

import javafx.scene.control.Alert;

public class Messager {


    Messager (String message) {
        Alert alert = new Alert(javafx.scene.control.Alert.AlertType.INFORMATION);

        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }


}
