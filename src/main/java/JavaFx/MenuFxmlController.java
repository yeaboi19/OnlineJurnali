package JavaFx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
// FIXME: 2/15/2022

public class MenuFxmlController implements Initializable {
    @FXML
    Button login;
    @FXML
    Button register;
    @FXML
    Button student;
    @FXML
    Button teacher;
    @FXML
    Button back;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // sugma kok?
        // kok sugma?
    }

    @FXML
    public void onRegisterPressed() throws IOException {
        try {
            Stage stage = (Stage) register.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("/studentOrTeacher.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onStudentPressed() throws IOException {
        try {
            Stage stage = (Stage) student.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("/registerStudent.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onTeacherPressed() throws IOException {
        try {
            Stage stage = (Stage) teacher.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("/register.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onLoginPressed() {
        Stage stage;
        Parent parent;
        stage = (Stage) login.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("/login.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
    public void exit(){
        Platform.exit();
    }
}
