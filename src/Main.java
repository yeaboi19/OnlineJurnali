import SQLConnections.DataConnect;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DataConnect d = DataConnect.getInstance();
        Connection con = d.getConnection();

        PreparedStatement p;

        try {
            p = con.prepareStatement("Use samee");
            p.execute();
            p = con.prepareStatement("SELECT * from kok");
            ResultSet res = p.executeQuery();
            ResultSetMetaData rsmd = res.getMetaData();
            while (res.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(res.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }// This is a Test
        // you may remove this code

    }

}
/*
student id - ****0
teacher id - ****1
admin id   - ****3
 */