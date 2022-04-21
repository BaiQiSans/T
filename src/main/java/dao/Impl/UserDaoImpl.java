package dao.Impl;

import dao.UserDao;
import po.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    static JDBCUtils jdbcUtils = new JDBCUtils();
    static ResultSet rs = null;
    static Connection conn = null;
    static PreparedStatement ps =null;//预编译的数据库操作对象
    boolean IsSuccess = false;

    static {
        try {
            conn = JDBCUtils.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public List<User> selectCondition(User user) {
        return null;
    }

    public User selectByEmail(String email){
        try {
            Connection connection = JDBCUtils.getConnection();
 //           System.out.println("我执行了");
            String sql = "SELECT * FROM user WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);//这里的报错
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet.toString());
            if (resultSet.next()) return User.initialize(resultSet); else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User selectByName(String name) {
        try {
            Connection connection = JDBCUtils.getConnection();
            System.out.println("我执行了");
            String sql = "SELECT * FROM user WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);//这里的报错
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet.toString());
            if (resultSet.next()) return User.initialize(resultSet); else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User selectById(Integer id) {
        try {
            String querySQL = "SELECT * FROM user WHERE pk_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(querySQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return User.initialize(resultSet); else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(User user) {
        try {
            String sql = "insert into user(pk_id,avatar_path,name,private_secret,introduction,is_admin,email) values(" + user.getId() + "," +user.getAvatarPath()+","+user.getName() + "," + user.getPrivateSecret() + "," + user.getIntroduction() + ","+user.isAdmin()+","+user.getEmail()+")";
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            int result = ps.executeUpdate();
            if (result != 0) {
                IsSuccess = true;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return IsSuccess;
    }

    @Override
    public boolean update(User user) {
        int num=0;
        try {
            String sql = "update user SET pk_id="+user.getId()+",avatar_path='"+user.getAvatarPath()+"',name='"+user.getName()+"',private_secret='"+user.getPrivateSecret()+"',introduction='"+user.getIntroduction()+"',is_admin="+user.isAdmin()+",email="+user.getEmail()+"WHERE pk_id ="+user.getId();
            ps=conn.prepareStatement(sql);
            num=ps.executeUpdate();
            if(num!=0)
                IsSuccess =true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return IsSuccess;
    }

    @Override
    public boolean delete(Integer id) {
        int num = 0;
        try {
            String sql = "delete from user where pk_id = "+id;//创建sql语句
            ps=conn.prepareStatement(sql);
            num = ps.executeUpdate();
            if(num!=0)
                IsSuccess =true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return IsSuccess;
    }
}
