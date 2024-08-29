import java.sql.*;

// 부모 클래스 (리팩토링)
public class UserDAO {

    private SimpleConnectionMaker simpleConnectionMaker;

    public UserDAO() {
        simpleConnectionMaker = new SimpleConnectionMaker();
    }
    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = simpleConnectionMaker.makeNewConnection();

        PreparedStatement ps = c.prepareStatement(  "insert into users(id,name,password) values(?,?,?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPw());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User getUser(String id) throws ClassNotFoundException, SQLException {
        Connection c = simpleConnectionMaker.makeNewConnection();
        
        PreparedStatement ps = c.prepareStatement(  "select * from users where id=?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();

        user.SetId(rs.getString("id"));
        user.SetName(rs.getString("name"));
        user.SetPw(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    /*public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDAO dao = new UserDAO();

        User user = new User();

        user.SetId("cat999");
        user.SetName("고먐미");
        user.SetPw("kitty2134");

        dao.add(user);

        System.out.println(user.getName() + " 등록성공");

        User user2 = dao.getUser("cat999");
        System.out.println(user2.getName() + "조회 성공");
        System.out.println("id : " + user2.getId());
        System.out.println("password : " + user2.getPw());
    }*/
}





