package jdbc;

import java.sql.*;

/**
 * @author javie
 * @date 2019/9/22 13:44
 */
public class Connect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
        String sql = "select * from emp";
        PreparedStatement ps = conn.prepareStatement(sql);
        // ps.setInt(1, 1001);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            Object object = resultSet.getObject(1);
            Object object1 = resultSet.getObject(2);
            Object object2 = resultSet.getObject(3);
            Object object3 = resultSet.getObject(4);
            System.out.println(object+","+object1+","+object2+","+object3);
        }
        resultSet.close();
        conn.close();
    }
}
