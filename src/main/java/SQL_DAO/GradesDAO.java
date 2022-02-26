package SQL_DAO;

import SQLConnections.DataConnect;
import UserType.GradesInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradesDAO {
    private static Connection con = DataConnect.getConnection();

    public boolean exists(int userId){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * from skola.grades where UserID=" + userId + " ");
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean add(GradesInfo gInfo){
        if(exists(gInfo.getUserId()))return false;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO skola.grades(UserID, Georgian, History, Math, Physics, Biology, Chemistry, Geography, English, Russian, Date)value(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, gInfo.getUserId());
            ps.setInt(2, gInfo.getGeorgian());
            ps.setInt(3, gInfo.getHistory());
            ps.setInt(4, gInfo.getMath());
            ps.setInt(5, gInfo.getPhysics());
            ps.setInt(6, gInfo.getBiology());
            ps.setInt(7, gInfo.getChemistry());
            ps.setInt(8, gInfo.getGeography());
            ps.setInt(9, gInfo.getEnglish());
            ps.setInt(10, gInfo.getRussian());
            ps.setString(11, gInfo.getDate());
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<GradesInfo> get(int userId){
        if(!exists(userId))return null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * from skola.grades where UserID="+userId+" ");
            ResultSet rs = ps.executeQuery();
            ArrayList<GradesInfo> ret = new ArrayList<>();
            while (rs.next()){
                 int georgian= rs.getInt(2);
                 int history = rs.getInt(3);
                 int math= rs.getInt(4);
                 int physics= rs.getInt(5);
                 int biology= rs.getInt(6);
                 int chemistry= rs.getInt(7);
                 int geography= rs.getInt(8);
                 int english= rs.getInt(9);
                 int russian= rs.getInt(10);
                 String date= rs.getString(11);

                GradesInfo temp= new GradesInfo(userId,georgian,history,math,physics,biology,chemistry,geography,english,russian,date);
                ret.add(temp);
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
