package Registration;

import SQLConnections.DataConnect;

import java.sql.*;

public class Entry {

    protected static boolean doesExist(String email, String name, String surname) throws SQLException {
        Connection con = DataConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("USE skola");
        Statement statement = con.createStatement();
        ResultSet set = null;
        String tmp = "select * from user where Email = \"%s\"".formatted(email);
        System.out.println(tmp);
        try {
            set = statement.executeQuery("select * from user where Email = \"%s\";".formatted(email));
        } catch (SQLException e) {
            return false;
        }
        while (set.next()) {
            if (set.getString("Name").equalsIgnoreCase(name) && set.getString("Lastname").equalsIgnoreCase(surname)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    //name,surname,email,teacher/student,grade,subject.
    public static boolean register(String name, String surname, String email, String grade, String subject,Boolean isStudent) throws SQLException {
        if (doesExist(email, name, surname)){
            return false;
        }
        Connection con = DataConnect.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT into user(Name,Lastname,Email,Class,Subject,isStudent)value(?,?,?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,surname);
        ps.setString(3,email);
        ps.setString(4,grade);
        ps.setString(5,subject);
        ps.setBoolean(6,isStudent);
        ps.execute();
        return true;
    }
}
