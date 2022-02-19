package JavaFx;

import Registration.Entry;
import UserType.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginFxmlController {

    @FXML
    public TextField nameid;
    @FXML
    public TextField surnameid;
    @FXML
    public TextField emailid;

    @FXML
    public void onClosePressed() {
        Platform.exit();
    }



    @FXML
    public void onLoginPressed() {
        Entry.login(nameid.getText(), surnameid.getText(), emailid.getText());// es abrunebs users
        //da minda ro eg user gadavides /TestFxmlController -shi
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/test.fxml"));
            Parent root1 = null;
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onEmailPressed() {
        onLoginPressed();
    }


}
