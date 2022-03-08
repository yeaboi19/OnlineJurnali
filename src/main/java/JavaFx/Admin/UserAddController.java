package JavaFx.Admin;

import SQL_DAO.UserDAO;
import UserType.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserAddController implements Initializable {
    @FXML
    private TableView userTable;

    @FXML
    private TextField nameField;
    @FXML
    private TextField lastField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField classField;
    @FXML
    private ChoiceBox subjectChoice;
    @FXML
    private CheckBox isStudent;
    @FXML
    private CheckBox isMale;

    @FXML
    private Button close;
    @FXML
    private Button commitButton;
    @FXML
    private Label infoLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn column1 = setUpColumn("name", "name");
        TableColumn column2 = setUpColumn("lastname", "lastName");
        TableColumn column3 = setUpColumn("email", "email");
        TableColumn column4 = setUpColumn("class", "class1");
        TableColumn column5 = setUpColumn("subject", "subject");
        TableColumn column6 = setUpColumn("isStudent", "isStudent");
        TableColumn column7 = setUpColumn("isMale", "isMale");
        userTable.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7);
        userTable.setOnMousePressed(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                int index = userTable.getSelectionModel().getSelectedIndex();
                User user = (User) userTable.getItems().get(index);
                nameField.setText(user.getName());
                lastField.setText(user.getLastName());
                emailField.setText(user.getEmail());
                classField.setText(user.getClass1());
                subjectChoice.setValue(user.getSubject());
                isStudent.setSelected(user.isStudent());
                isMale.setSelected(user.isMale());
            }
        });
        updateTable();
    }
    protected void updateTable() {
        ObservableList<User> obList = FXCollections.observableArrayList();
        obList.addAll(UserDAO.getAll());
        userTable.setItems(obList);
    }

    private TableColumn setUpColumn(String columnName, String idInUser) {
        if (idInUser.charAt(0) == 'i' && idInUser.charAt(1) == 's') {
            TableColumn<User, Boolean> column = new TableColumn<>(columnName);
            column.setCellValueFactory(new PropertyValueFactory<>(idInUser));
            return column;
        } else {
            TableColumn<User, String> column = new TableColumn<>(columnName);
            column.setCellValueFactory(new PropertyValueFactory<>(idInUser));
            return column;
        }
    }

    public void onClosePressed() {
        try {
            Stage stage = (Stage) close.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("/login.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCommitPressed(){
        User user = textFieldToUser(nameField, lastField, emailField, classField, subjectChoice, isStudent, isMale);
        if(UserDAO.add(user)){
            infoLabel.setText("epic addition \\(@^0^@)/");
        }else{
            infoLabel.setText("something gon wrong ;((");
        }
        updateTable();
    }
    private User textFieldToUser(TextField name, TextField last, TextField email, TextField class1, ChoiceBox subject, CheckBox isStudent, CheckBox isMale) {
        return new User(0, name.getText(), last.getText(), email.getText(), class1.getText(), String.valueOf(subject.getSelectionModel().getSelectedItem()), isStudent.isSelected(), isMale.isSelected());
    }


    public void onRemovePressed(){
        try {
            Stage stage = (Stage) close.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("/Admin/userRemoveControl.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onEditPressed(){
        try {
            Stage stage = (Stage) close.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("/Admin/userEditControl.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
