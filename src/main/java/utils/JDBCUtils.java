package utils;

import java.sql.*;

public class JDBCUtils {

//    private static DataSource ds;
//    static {
//        try {
//            Properties pro = new Properties();
//            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
//            ds= DruidDataSourceFactory.createDataSource(pro);MyConnectionPool.
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public static Connection getConnection() throws SQLException {
        return MyConnectionPool.getConnection();
    }

    public static void close(Statement stmt,Connection conn) {
        close(null,stmt,conn);
    }

    public static void close(ResultSet rs,Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
