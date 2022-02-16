package JavaFx;

import Registration.Entry;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

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
    public void onClosePressed() {
        Platform.exit();
    }

    @FXML
    public void registerTeacher() throws SQLException {
        Entry.register(nameid.getText(), surnameid.getText(), emailid.getText(), classid.getText(), String.valueOf(subjectid.getSelectionModel().getSelectedItem()), false, maleid.isSelected());
        System.out.println("DEBUG: ADDED user- "+nameid.getText()+" email- "+emailid.getText());
    }
}
