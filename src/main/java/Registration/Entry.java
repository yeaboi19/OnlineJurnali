package Registration;

import SQLConnections.DataConnect;

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
            set = statement.executeQuery("select * from skola.user where Email = " + email + ";");
        } catch (SQLException e) {
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

    public static boolean login(String name, String surname, String email) {
        if (doesExist(name,surname,email)){
            // dont have time will doit later
            //fuck intelij ram consumption
        }
        return false;
    }
}
