package JavaFx;

import UserType.GradesInfo;
import SQLConnections.DataConnect;
import UserType.User;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginSceneStudentController implements Initializable {
    public static User user;

    @FXML
    private Label welcomeLabel;
    @FXML
    private TableView tableGrade;
    @FXML
    private ChoiceBox subjectid;
    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeLabel.setText("Welcome back %s %s".formatted(user.getName(), user.getLastName()));
        subjectid.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                tableGrade.getColumns().clear();
                tableGrade.getItems().clear();
                tableGrade.setPlaceholder(new Label("No grades to display"));
                String subject = String.valueOf(subjectid.getSelectionModel().getSelectedItem());
                List<GradesInfo> gradesInfo = null;
                try {
                    gradesInfo = getUserData();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                List<TableColumn> listOfColumns = new ArrayList<>();
                for (GradesInfo iterator : gradesInfo) {
                    TableColumn column = new TableColumn(iterator.getDate());
                    column.setMinWidth(80);
                    listOfColumns.add(column);
                    //need to somehow write iterator.getSubject(subject) in this column
                }

                tableGrade.getColumns().addAll(listOfColumns);
                tableGrade.refresh();
            }
        });
    }

    private List<GradesInfo> getUserData() throws SQLException {
        Connection con = DataConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from skola.grades where UserID = \"%s\"".formatted(user.getId()));
        ResultSet set = ps.executeQuery();
        List<GradesInfo> gradesInfo = new ArrayList<>();
        GradesInfo temp = null;
        while (set.next()) {
            temp = new GradesInfo(user.getId(),set.getInt("Georgian"), set.getInt("History"), set.getInt("Math"), set.getInt("Physics"), set.getInt("Biology"), set.getInt("Chemistry"), set.getInt("Geography"), set.getInt("English"), set.getInt("Russian"), set.getString("Date"));
            gradesInfo.add(temp);
        }
        return gradesInfo;
    }

    @FXML
    public void onClosePressed() {
        try {
            Stage stage = (Stage) back.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("/login.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  /*onChoiceBoxSelect (just my note for me)
          get choice
          loop through gradesInfo add a column with date and under that column add a grade. should be easy
          nigger
   */

}
