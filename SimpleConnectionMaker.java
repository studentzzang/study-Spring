import java.sql.*;

public class SimpleConnectionMaker {
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbcmysql://localhost/spring", "spring", "book");

        return c;
    }
}
