package JavaFx;

import UserType.TeacherTableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class filterGradeTeacherController implements Initializable {
    @FXML
    private TextField filterDate;
    @FXML
    private TextField filterEmail;

    protected static String dateString = "";
    protected static String emailString = "";

    protected static boolean dateFlag;
    protected static boolean emailFlag;

    protected static LoginTeacherFxmlController classPass;

    protected static ArrayList<TeacherTableView> filterTable() throws SQLException {

        ArrayList<TeacherTableView> arrList = classPass.getStudentData();
        ArrayList<TeacherTableView> updatedList = new ArrayList<>();
        for (TeacherTableView v : arrList) {
            if (dateFlag && emailFlag) {
                if (v.getDate().equalsIgnoreCase(dateString) && v.getEmail().equalsIgnoreCase(emailString)) {
                    updatedList.add(v);
                }
                continue;
            } else if (dateFlag) {
                if (v.getDate().equalsIgnoreCase(dateString)) {
                    updatedList.add(v);
                }
            } else if (emailFlag) {
                if (v.getEmail().equalsIgnoreCase(emailString)) {
                    updatedList.add(v);
                }
            }
        }
        return updatedList;


    }

    public void onFPressed() {
        dateFlag = true;
        if (filterDate.getText().length() == 0){
            dateFlag = false;
        }
        dateString = filterDate.getText();
    }

    public void onEPressed() {
        emailFlag = true;
        if (filterEmail.getText().length() == 0){
            emailFlag = false;
        }
        emailString = filterEmail.getText();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (emailString.length() > 0) {
            filterEmail.setText(emailString);
        }
        if (dateString.length() > 0){
            filterDate.setText(dateString);
        }
    }
}
