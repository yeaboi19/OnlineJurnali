package JavaFx;

import SQLConnections.DataConnect;
import UserType.TeacherTableView;
import UserType.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class filterGradeTeacherController implements Initializable {
    @FXML
    private TextField filterDate;
    @FXML
    private TextField filterEmail;
    @FXML
    private TextField filterName;
    @FXML
    private TextField filterSurname;
    @FXML
    private TextField filterGrade;

    protected static String dateString = "";
    protected static String emailString = "";
    protected static String nameString = "";
    protected static String surnameString = "";
    protected static String gradeString = "";

    protected static boolean dateFlag = false;
    protected static boolean emailFlag = false;
    protected static boolean nameFlag = false;
    protected static boolean surnameFlag = false;
    protected static boolean gradeFlag = false;

    protected static LoginTeacherFxmlController classPass;



    protected ArrayList<TeacherTableView> filterTable() throws SQLException {
        Boolean[] FLAGS = {dateFlag, emailFlag, nameFlag, surnameFlag}; // The priority follows from 0
        String[] NAMES = {"date", "email", "name", "surname"};
        String[] STRINGS = {dateString, emailString, nameString, surnameString};
        //THESE 3 MUST BE SYNCED AT ALL TIMES ALSO THEY MUST GET INITIALIZED IN HERE SINCE JAVA HATES POINTERS
        ArrayList<TeacherTableView> arrList = classPass.getStudentData();
        ArrayList<TeacherTableView> updatedList = new ArrayList<>();
        int index = 0;
        while (index != FLAGS.length) {
            if (FLAGS[index]) {
                for (TeacherTableView v : arrList) {
                    if (v.getWhat(NAMES[index]).equalsIgnoreCase(STRINGS[index])) updatedList.add(v);
                }
            }
            index++;
        }
        return updatedList;
    }

    public void onFPressed() {
        dateFlag = filterDate.getText().length() != 0;
        dateString = filterDate.getText();
    }

    public void onEPressed() {
        emailFlag = filterEmail.getText().length() != 0;
        emailString = filterEmail.getText();
    }

    public void onNPressed() {
        nameFlag = filterName.getText().length() != 0;
        nameString = filterName.getText();
    }

    public void onSPressed() {
        surnameFlag = filterSurname.getText().length() != 0;
        surnameString = filterSurname.getText();
    }

    public void onGPressed() {
        gradeFlag = filterGrade.getText().length() != 0;
        gradeString = filterGrade.getText();
    }

    public void onCPressed() {
        filterDate.setText("");
        filterGrade.setText("");
        filterName.setText("");
        filterSurname.setText("");
        filterEmail.setText("");
        dateFlag = false;
        gradeFlag = false;
        nameFlag = false;
        surnameFlag = false;
        emailFlag = false;
        dateString = "";
        gradeString = "";
        nameString = "";
        surnameString = "";
        emailString = "";
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (emailString.length() > 0) {
            filterEmail.setText(emailString);
        }
        if (dateString.length() > 0) {
            filterDate.setText(dateString);
        }
        if (nameString.length() > 0) {
            filterName.setText(nameString);
        }
        if (surnameString.length() > 0) {
            filterSurname.setText(surnameString);
        }
        if (gradeString.length() > 0) {
            filterGrade.setText(gradeString);
        }
    }
}



/*String statement = "";
            if (nameFlag || surnameFlag || emailFlag) {
                statement = "Select UserID,Name,Lastname,Email from skola.user Where ";
                if (nameFlag && !emailFlag) statement += "Name = '" + nameString + "' ";
                if (nameFlag && surnameFlag && !emailFlag) statement += "AND";
                if (surnameFlag && !emailFlag) statement += " Lastname = '" + surnameString + "' ";
                if (emailFlag) statement += " Email = '" + emailString + "' ";
                //Statement to get Students stuff
            }

            int idRet = 0;
            if (statement.length() > 0) {
                PreparedStatement ps = con.prepareStatement(statement);
                ResultSet resSet = ps.executeQuery();// Student - Name Surname Email and UserID
                while (resSet.next()) {
                    idRet = resSet.getInt(1);
                    String nameRet = resSet.getString(2);
                    String lastNameRet = resSet.getString(3);
                    String emailRet = resSet.getString(4);
                }
            }

            String statement2 = "Select Subject,Class from skola.user Where UserId=" + userId;
            PreparedStatement ps2 = con.prepareStatement(statement2);
            ResultSet resSet2 = ps2.executeQuery();
            resSet2.next();
            String subject = resSet2.getString(1);
            int subj = subjToInt(subject);
            String clas = resSet2.getString(2);
            statement2 = "SELECT " + subject + ",DATE from skola.grades WHERE UserID='"+idRet+ "' AND Class='" +clas+"'";
            ps2= con.prepareStatement(statement2);
            resSet2 = ps2.executeQuery();
            while (resSet2.next()){
                resSet2.getString(1);
                resSet2.getString()
            }*/
