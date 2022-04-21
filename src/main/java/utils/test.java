package utils;

import po.Like;
import po.Review;
import po.User;
import service.Impl.UserServiceImpl;
import service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = userService.selectByName("白崎");
        System.out.println(user);
        //Review review = DBInJ.fastPreparedExecuteQuery("SELECT * FROM review WHERE pk_id = ?", resultSet -> ModelKit.constructModel(Review.class, resultSet), 1);
    }

//    public static User selectByName(String name) {
//        JDBCUtils jdbcUtils = new JDBCUtils();
//        ResultSet rs = null;
//        Connection conn = null;
//        PreparedStatement ps =null;//预编译的数据库操作对象
//        boolean Success = false;
//        try {
//            conn = JDBCUtils.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        try {
//            String querySQL = "SELECT * FROM review WHERE pk_id = ?";
//            PreparedStatement preparedStatement = conn.prepareStatement(querySQL);
////            preparedStatement.setString(1, name);
//            preparedStatement.setInt(1, 1);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) return ModelKit.constructModel(User.class, resultSet) /*User.initialize(resultSet)*/; else return null;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
