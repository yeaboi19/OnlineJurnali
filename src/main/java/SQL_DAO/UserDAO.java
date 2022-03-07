package SQL_DAO;

import SQLConnections.DataConnect;
import UserType.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    private static final Connection con = DataConnect.getConnection();

    public static boolean exists(User user) {
        try {
            PreparedStatement ps = con.prepareStatement("select * from skola.user WHERE Name='" + user.getName() + "' AND Lastname='" + user.getLastName() + "' AND Email='" + user.getEmail() + "';");
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean add(User user) {
        if (exists(user)) return false;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT into skola.user(Name,Lastname,Email,Class,Subject,isStudent,isMale)value(?,?,?,?,?,?,?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getClass1());
            ps.setString(5, user.getSubject());
            ps.setBoolean(6, user.isStudent());
            ps.setBoolean(7, user.isMale());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static User get(String name, String surname, String email) {
        try {
            PreparedStatement ps = con.prepareStatement("select * from skola.user WHERE Name='" + name + "' AND Lastname='" + surname + "' AND Email='" + email + "';");
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            int idRet = rs.getInt(1);
            String nameRet = rs.getString(2);
            String lastNameRet = rs.getString(3);
            String emailRet = rs.getString(4);
            String classRet = rs.getString(5);
            String subjectRet = rs.getString(6);
            boolean isStudentRet = rs.getBoolean(7);
            boolean isMaleRet = rs.getBoolean(8);
            return new User(idRet, nameRet, lastNameRet, emailRet, classRet, subjectRet, isStudentRet, isMaleRet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<User> getAll(){
        try{
            ArrayList<User> ret = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT * from skola.user");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int idRet = rs.getInt(1);
                String nameRet = rs.getString(2);
                String lastNameRet = rs.getString(3);
                String emailRet = rs.getString(4);
                String classRet = rs.getString(5);
                String subjectRet = rs.getString(6);
                boolean isStudentRet = rs.getBoolean(7);
                boolean isMaleRet = rs.getBoolean(8);
                ret.add(new User(idRet, nameRet, lastNameRet, emailRet, classRet, subjectRet, isStudentRet, isMaleRet));
            }
            return ret;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean remove(User user) {
        try {
            PreparedStatement pr = con.prepareStatement("DELETE FROM skola.user WHERE Email='" + user.getEmail() + "'");
            return pr.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int edit(User oldUser, User newUser) { // tu oldUser databaseshi araa newUsers sheqmnis (its a feature not a bug)
        if (!add(newUser)) {
            System.out.println("cant edit,changed user already exists");
            return 1;
        } else if (!remove(oldUser)) {
            System.out.println("cant edit,there is no old user");
            return 2;
        } else {
            System.out.println("edit has been made");
            return 0;
        }
    }
}
