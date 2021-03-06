package JavaFx;

import SQLConnections.DataConnect;
import UserType.TeacherTableView;
import UserType.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;

public class LoginTeacherFxmlController implements Initializable {
    public static User user;
    private String name;
    private String surname;
    private String email;
    private String date;
    private int grade;
    @FXML
    private TableColumn tableEmail;
    @FXML
    private TableColumn tableName;
    @FXML
    private TableColumn tableSurname;
    @FXML
    private TableColumn tableGrade;
    @FXML
    private TableColumn tableDate;
    @FXML
    private Button filter;
    @FXML
    private Button addGrade;
    @FXML
    private Button editGrade;
    @FXML
    private Button refresh;
    @FXML
    private TableView tableView;
    @FXML
    private CheckBox filterSwitch;
    private URL url;
    private ResourceBundle resourceBundle;
    private boolean isFiltered;
    private LinkedHashSet<TeacherTableView> filteredList = new LinkedHashSet<>();
    @FXML
    private Button Back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.url = url;
        this.resourceBundle = resourceBundle;
        ObservableList<TeacherTableView> obList = FXCollections.observableArrayList();

        if (!isFiltered) {
            try {
                for (TeacherTableView v : getStudentData()) {
                    obList.add(v);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            for (TeacherTableView v : filteredList) {
                obList.add(v);
            }
        }

        setCells();
        tableView.setItems(obList);

    }

    protected void updateTable() {
        initialize(url, resourceBundle);
    }

    protected ArrayList<TeacherTableView> getStudentData() throws SQLException {
        ArrayList<TeacherTableView> arrList = new ArrayList<>();
        Connection con = DataConnect.getConnection();
        PreparedStatement statement1 = con.prepareStatement("select * from skola.user where Class = \"%s\" and isStudent = true".formatted(user.getClass1()));
        ResultSet getUser = statement1.executeQuery();
        while (getUser.next()) {
            name = getUser.getString("Name");
            surname = getUser.getString("Lastname");
            email = getUser.getString("Email");
            PreparedStatement getThis = con.prepareStatement("select %s,Date from skola.grades where UserID = \"%s\"".formatted(user.getSubject(), getUser.getString("UserID")));
            ResultSet temp = getThis.executeQuery();

            while (temp.next()) {
                date = temp.getString("Date");
                grade = temp.getInt("%s".formatted(user.getSubject()));
                arrList.add(new TeacherTableView(email, name, surname, grade, date));
            }
        }
        return arrList;
    }

    public void onEditPressed() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/editGradeTeacher.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();
        EditGradeTeacherController.classPass = this;
    }

    public void onAddPressed() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addGradeTeacher.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();
        addGradeTeacherController.classPass = this;

    }

    public void onFilterPressed() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/filterGradeTeacher.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void onBackPressed() throws IOException {
        Stage stage = (Stage) Back.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void onFilterPressedInUtil() throws SQLException {
        filterGradeTeacherController instance = new filterGradeTeacherController();
        if (filterSwitch.isSelected()) {
            isFiltered = true;
            filterGradeTeacherController.classPass = this;
            filteredList = instance.filterTable();
        } else {
            isFiltered = false;
        }
        initialize(url, resourceBundle);
    }


    private void setCells() {
        tableEmail.setCellValueFactory(new PropertyValueFactory<TeacherTableView, String>("email"));
        tableName.setCellValueFactory(new PropertyValueFactory<TeacherTableView, String>("name"));
        tableSurname.setCellValueFactory(new PropertyValueFactory<TeacherTableView, String>("surname"));
        tableGrade.setCellValueFactory(new PropertyValueFactory<TeacherTableView, Integer>("grade"));
        tableDate.setCellValueFactory(new PropertyValueFactory<TeacherTableView, String>("date"));
    }


}
