import java.sql.*;

public class NUserDAO extends UserDAO {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 로드

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/spring", "root", "1234");

        //n사 DB 생성 코드

        return c;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        NUserDAO dao = new NUserDAO();

        User user = new User();

        user.SetId("jundoll");
        user.SetName("준돌이");
        user.SetPw("jj88");

        dao.add(user);

        System.out.println(user.getName() + " 등록성공");

        User user2 = dao.getUser("cat999");
        System.out.println(user2.getName() + " 조회 성공");
        System.out.println("id : " + user2.getId());
        System.out.println("password : " + user2.getPw());
    }
}
