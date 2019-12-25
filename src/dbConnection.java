import java.sql.*;
// bu alan database driver ile birlikte database bağlanıtsını sağlıyor
public class dbConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");  
        String host = "jdbc:mysql://localhost:3306/restraurant?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey&characterEncoding=UTF-8";
        String userName = "root";
        String userPass = "1234";
        Connection con = DriverManager.getConnection(host, userName, userPass);
        return con;
    }
}
