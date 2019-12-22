import java.sql.*;

public class dbConnection {
    public static Connection getConnection() throws SQLException {
        String host = "jdbc:mysql://localhost:3306/restraurant?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        String userName = "root";
        String userPass = "1234";
        Connection con = DriverManager.getConnection(host, userName, userPass);
        return con;
    }
}
