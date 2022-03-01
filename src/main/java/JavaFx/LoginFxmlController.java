package JavaFx;

import UserType.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    public Button login;
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
            Stage stage = (Stage) login.getScene().getWindow();
            Parent parent = null;
            if (user.isStudent()) {
                LoginSceneStudentController.user = user;
                parent = FXMLLoader.load(getClass().getResource("/loginSceneStudent.fxml"));
            }else{
                parent = FXMLLoader.load(getClass().getResource("/loginTeacher.fxml"));
            }
            Scene scene = new Scene(parent);
            stage.setScene(scene);
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
