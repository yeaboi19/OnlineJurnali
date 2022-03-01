package JavaFx;

import SQL_DAO.UserDAO;
import UserType.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterFxmlController {
    @FXML
    public TextField nameid;
    @FXML
    public TextField surnameid;
    @FXML
    public TextField emailid;
    @FXML
    public CheckBox maleid;
    @FXML
    public CheckBox femaleid;
    @FXML
    public ChoiceBox subjectid;
    @FXML
    public TextField classid;
    @FXML
    public TextField nameStudent;
    @FXML
    public TextField surnameStudent;
    @FXML
    public TextField emailStudent;
    @FXML
    public CheckBox maleStudent;
    @FXML
    public CheckBox femaleStudent;
    @FXML
    public TextField gradeStudent;
    @FXML
    public Button back;

    @FXML
    public void onClosePressed() {
        try {
            Stage stage = (Stage) back.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("/studentOrTeacher.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void registerTeacher() throws SQLException {
        UserDAO.add(new User(0,nameid.getText(), surnameid.getText(), emailid.getText(), classid.getText(), String.valueOf(subjectid.getSelectionModel().getSelectedItem()), false, maleid.isSelected()));
        System.out.println("DEBUG: ADDED teacher- "+nameid.getText()+" email- "+emailid.getText());
    }
    @FXML
    public void registerStudent() throws SQLException{
        UserDAO.add(new User(0,nameStudent.getText(),surnameStudent.getText(),emailStudent.getText(),gradeStudent.getText(),"null",true,maleStudent.isSelected()));
        System.out.println("DEBUG: ADDED student- "+nameStudent.getText()+" email- "+emailStudent.getText());
    }
}
