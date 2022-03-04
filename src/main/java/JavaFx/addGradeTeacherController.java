package JavaFx;

import SQLConnections.DataConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class addGradeTeacherController {
    @FXML
    private TextField addEmail;
    @FXML
    private TextField addGradeText;
    protected static LoginTeacherFxmlController classPass;


    public void onAddPressedInUtil() throws SQLException {
        String email = addEmail.getText();
        int grade = Integer.valueOf(addGradeText.getText());
        Connection con = DataConnect.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT `UserID` from `skola`.`user` where Email = \"%s\"".formatted(email));
        ResultSet set = statement.executeQuery();
        int id = -1;
        while (set.next()){
            id = set.getInt("UserID");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        statement = con.prepareStatement("INSERT INTO `skola`.`grades` (`UserID`, `%s`, `Date` , `Class`) VALUES (?,?,?,?);".formatted(LoginTeacherFxmlController.user.getSubject()));
        statement.setInt(1,id);
        statement.setInt(2,grade);
        statement.setString(3,dtf.format(now));
        statement.setString(4,LoginTeacherFxmlController.user.getClass1());
        statement.execute();
        classPass.updateTable();

    }
}
