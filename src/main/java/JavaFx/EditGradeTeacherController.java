package JavaFx;

import SQLConnections.DataConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditGradeTeacherController {
    @FXML
    private TextField editEmail;
    @FXML
    private TextField editDate;
    @FXML
    private TextField editGradeText;
    @FXML
    private Button editButton;


    public void onEditPressedInUtil() throws SQLException {
        String date = editDate.getText();
        String email = editEmail.getText();
        int grade = Integer.valueOf(editGradeText.getText());
        Connection con = DataConnect.getConnection();
        PreparedStatement statement = con.prepareStatement("select UserID from skola.user where Email = \"%s\"".formatted(email));
        ResultSet set = statement.executeQuery();
        int id = -1;
        while (set.next()) {
            id = set.getInt("UserID");
        }
        statement = con.prepareStatement("update skola.grades set %s = \"%d\" where UserID = \"%d\" and Date = \"%s\"".formatted(LoginTeacherFxmlController.user.getSubject(), grade, id, date));
        statement.execute();


    }
}
