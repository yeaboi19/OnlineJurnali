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
            ps.executeUpdate();
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
            return pr.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean edit(User oldUser, User newUser) {
        try{
            String statement="UPDATE skola.user set Name='"+newUser.getName()+"',Lastname='"+newUser.getLastName()+"',Email='"+newUser.getEmail()+"',Class='"+newUser.getClass1()+"',Subject='"+newUser.getSubject()+"',isStudent="+newUser.isStudent()+",isMale="+newUser.isMale()+" WHERE Name='"+oldUser.getName()+"' AND Lastname='"+oldUser.getLastName()+"' AND Email='"+oldUser.getEmail()+"' AND Class='"+oldUser.getClass1()+"' AND Subject='"+oldUser.getSubject()+"' AND isStudent="+oldUser.isStudent()+" AND isMale="+oldUser.isMale();
//            System.out.println(statement);
            PreparedStatement pr = con.prepareStatement(/*"UPDATE skola.user set Name=?,Lastname=?,Email=?,Class=?,Subject=?,isStudent=?,isMale=? WHERE Name=? AND Lastname=? AND Email=? AND Class=? AND Subject=? AND isStudent=? AND isMale=?"*/statement);
//            pr.setString(1,oldUser.getName());
//            pr.setString(2,oldUser.getLastName());
//            pr.setString(3, oldUser.getEmail());
//            pr.setString(4, oldUser.getClass1());
//            pr.setString(5,oldUser.getSubject());
//            pr.setBoolean(6,oldUser.isStudent());
//            pr.setBoolean(7,oldUser.isMale());
//
//            pr.setString(8,newUser.getName());
//            pr.setString(9,newUser.getLastName());
//            pr.setString(10, newUser.getEmail());
//            pr.setString(11, newUser.getClass1());
//            pr.setString(12,newUser.getSubject());
//            pr.setBoolean(12,newUser.isStudent());
//            pr.setBoolean(13,newUser.isMale());
            int ret = pr.executeUpdate(); //ulamazoa mara azrze ar var mag gzit rato ar mushaobda
//            System.out.println(ret);
            return ret != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
