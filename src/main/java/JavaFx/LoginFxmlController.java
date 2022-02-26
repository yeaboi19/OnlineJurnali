package JavaFx;

import UserType.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    public Label errorlable;
    @FXML
    public Button back;

    @FXML
    public void onClosePressed() {
        try {
            Stage stage = (Stage) back.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("/menu.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onLoginPressed() {
        try {
            User user = new User(nameid.getText(), surnameid.getText(), emailid.getText());
            if (user.getId() == -1){
                errorlable.setVisible(true);
                return;
            }
            errorlable.setVisible(false);
            FXMLLoader fxmlLoader = null;
            if (user.isStudent()) {
                LoginSceneStudentController.user = user;
                fxmlLoader = new FXMLLoader(getClass().getResource("/loginSceneStudent.fxml"));
            }
            Parent root1 = null;
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
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
