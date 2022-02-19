package Registration;

import SQLConnections.DataConnect;
import UserType.User;

import java.sql.*;

public class Entry {
    // FIXME: 2/15/2022
    protected static boolean doesExist(String email, String name, String surname) {
        Connection con = DataConnect.getConnection();
        Statement statement = null;
        try {
            PreparedStatement ps = con.prepareStatement("USE skola");
            statement = con.createStatement();
        } catch (SQLException e) {
            System.out.println("No Schema named `skola`");
        }
        ResultSet set = null;
        try {
            set = statement.executeQuery("select * from user where Email = \"%s\"".formatted(email));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DEBUG: doesExist returned FALSE");
            return false;
        }
        try {
            if (set.next()) {
                return set.getString("Name").equalsIgnoreCase(name) && set.getString("Lastname").equalsIgnoreCase(surname);
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    //name,surname,email,teacher/student,grade,subject.
    public static boolean register(String name, String surname, String email, String grade, String subject, Boolean isStudent, Boolean isMale) throws SQLException {
        if (doesExist(email, name, surname)) {
            return false;
        }
        Connection con = DataConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT into skola.user(Name,Lastname,Email,Class,Subject,isStudent,isMale)value(?,?,?,?,?,?,?)");
        ps.setString(1, name);
        ps.setString(2, surname);
        ps.setString(3, email);
        ps.setString(4, grade);
        ps.setString(5, subject);
        ps.setBoolean(6, isStudent);
        ps.setBoolean(7, isMale);
        ps.execute();
        return true;
    }

    public static User login(String name, String surname, String email) {
        if (doesExist(email,name,surname)){
            return new User(name,surname,email);
        }

        return new User();
    }

    public User getUser(String name,String surname,String email){
        if(!doesExist(email,name,surname))return null;
        Connection con = DataConnect.getConnection();
        try {
            PreparedStatement p = con.prepareStatement("select * from skola.user WHERE Name=\""+name+"\" AND Lastname=\""+surname+"\" AND Email=\""+email+"\";");
            ResultSet res = p.executeQuery();
            ResultSetMetaData rsmd = res.getMetaData();

            res.next();
            String idRet=res.getString(1);
            String nameRet=res.getString(2);
            String lastNameRet=res.getString(3);
            String emailRet=res.getString(4);
            String classRet=res.getString(5);
            String subjectRet=res.getString(6);
            boolean isStudentRet=res.getBoolean(7);
            boolean isMaleRet=res.getBoolean(8);
            User ret = new User(idRet,nameRet,lastNameRet,emailRet,classRet,subjectRet,isStudentRet,isMaleRet);
            return ret;
        } catch (SQLException e) {
            System.out.println("ERROR: AT \"getUser\" PreparedStatement");
        }
        return null;
    }

}
