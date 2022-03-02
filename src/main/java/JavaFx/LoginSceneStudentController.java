package JavaFx;

import UserType.GradesInfo;
import SQLConnections.DataConnect;
import UserType.GradesInfoLite;
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
    private TableView tableGrade;
    @FXML
    private TableColumn date;
    @FXML
    private TableColumn georgian;
    @FXML
    private TableColumn history;
    @FXML
    private TableColumn math;
    @FXML
    private TableColumn physics;
    @FXML
    private TableColumn biology;
    @FXML
    private TableColumn chemistry;
    @FXML
    private TableColumn geography;
    @FXML
    private TableColumn english;
    @FXML
    private TableColumn russian;
    @FXML
    private Button back;
    @FXML
    private Label Name;
    @FXML
    private Label Surname;
    private ObservableList<GradesInfoLite> obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableGrade.setEditable(true);
        Name.setText("Name:" + user.getName());
        Surname.setText("Surname:" + user.getLastName());
        List<GradesInfo> gradesInfos = null;
        try {
            gradesInfos = getUserData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (GradesInfo gradesInfo : gradesInfos){
           obList.add(new GradesInfoLite(gradesInfo.getDate(), gradesInfo.getGeorgian(), gradesInfo.getHistory(), gradesInfo.getMath(), gradesInfo.getPhysics(), gradesInfo.getBiology(), gradesInfo.getChemistry(), gradesInfo.getGeography(), gradesInfo.getEnglish(), gradesInfo.getRussian()));
        }
        setCells();
        tableGrade.setItems(obList);
        tableGrade.refresh();
    }

    private List<GradesInfo> getUserData() throws SQLException {
        Connection con = DataConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from skola.grades where UserID = \"%s\"".formatted(user.getId()));
        ResultSet set = ps.executeQuery();
        List<GradesInfo> gradesInfo = new ArrayList<>();
        GradesInfo temp = null;
        while (set.next()) {
            temp = new GradesInfo(user.getId(), set.getInt("Georgian"), set.getInt("History"), set.getInt("Math"), set.getInt("Physics"), set.getInt("Biology"), set.getInt("Chemistry"), set.getInt("Geography"), set.getInt("English"), set.getInt("Russian"), set.getString("Date"));
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

    private void setCells(){
        date.setCellValueFactory(new PropertyValueFactory<GradesInfo,String>("date"));
        georgian.setCellValueFactory(new PropertyValueFactory<GradesInfo,Integer>("georgian"));
        history.setCellValueFactory(new PropertyValueFactory<GradesInfo,Integer>("history"));
        math.setCellValueFactory(new PropertyValueFactory<GradesInfo,Integer>("math"));
        physics.setCellValueFactory(new PropertyValueFactory<GradesInfo,Integer>("physics"));
        biology.setCellValueFactory(new PropertyValueFactory<GradesInfo,Initializable>("biology"));
        chemistry.setCellValueFactory(new PropertyValueFactory<GradesInfo,Integer>("chemistry"));
        geography.setCellValueFactory(new PropertyValueFactory<GradesInfo,Integer>("geography"));
        english.setCellValueFactory(new PropertyValueFactory<GradesInfo,Integer>("english"));
        russian.setCellValueFactory(new PropertyValueFactory<GradesInfo,Integer>("russian"));
    }


}
