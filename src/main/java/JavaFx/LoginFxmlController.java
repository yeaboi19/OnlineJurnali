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
        User user = Entry.login(nameid.getText(), surnameid.getText(), emailid.getText());

        FXMLLoader fxmlLoader = null;
        try {
            if (user.isStudent()) {
                LoginSceneStudentController.user = user;
                fxmlLoader = new FXMLLoader(getClass().getResource("/loginSceneStudent.fxml"));
            }
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
