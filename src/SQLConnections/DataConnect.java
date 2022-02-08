package SQLConnections;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    private Connection con;
    private static final DataConnect instance = new DataConnect();

    private DataConnect() {
        try {
            con = DriverManager.getConnection(Info.HOST, Info.USER, Info.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataConnect getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return con;
    }

}