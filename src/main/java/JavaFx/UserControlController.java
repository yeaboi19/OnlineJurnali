package JavaFx;

import SQL_DAO.UserDAO;
import UserType.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class UserControlController implements Initializable {
    @FXML
    private TableView userTable;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn lastColumn;
    @FXML
    private TableColumn emailColumn;
    @FXML
    private TableColumn classColumn;
    @FXML
    private TableColumn subjectColumn;
    @FXML
    private TableColumn isStudentColumn;
    @FXML
    private TableColumn isMaleColumn;

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
    private CheckBox isMale1;
    @FXML
    private CheckBox isStudent1;
    @FXML
    private TextField nameField1;
    @FXML
    private TextField lastField1;
    @FXML
    private TextField emailField1;
    @FXML
    private TextField classField1;
    @FXML
    private ChoiceBox subjectChoice1;

    @FXML
    private Button close;
    @FXML
    private Button commitButton;
    @FXML
    private Label infoLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTable();
    }

    protected void updateTable(){
        ObservableList<User> obList = FXCollections.observableArrayList();
        ArrayList<User> temp = UserDAO.getAll();
        for (User u :
                temp) {
            System.out.println(u);
        }
        obList.addAll(temp);
        nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        lastColumn.setCellValueFactory(new PropertyValueFactory<User,String>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        classColumn.setCellValueFactory(new PropertyValueFactory<User,String>("class1"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<User,String>("subject"));
        isStudentColumn.setCellValueFactory(new PropertyValueFactory<User,Boolean>("isStudent"));
        isMaleColumn.setCellValueFactory(new PropertyValueFactory<User,Boolean>("isMale"));
        userTable.setItems(obList);
    }

    public void onClosePressed(){

    }
    public void onCommitPressed(){
        updateTable();
    }
}
