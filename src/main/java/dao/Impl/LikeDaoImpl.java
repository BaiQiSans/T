package dao.Impl;

import dao.LikeDao;
import po.Like;
import po.Picture;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LikeDaoImpl implements LikeDao {
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
    public List<Like> selectCondition(Like like) {
        return null;
    }

    @Override
    public Like selectById(Integer userId,Integer scripId) {
        try {
            String querySQL = "SELECT * FROM like where user_id = ? and scrip_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(querySQL);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, scripId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return Like.initialize(resultSet); else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(Like like) {
        try {
            String sql = "insert into like(user_id,scrip_id) values(" + like.getUserId() + "," +like.getScripId()+")";
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
    public boolean update(Like like) {
        int num=0;
        try {
            String sql = "update like SET user_id="+like.getUserId()+",scrip_id="+like.getScripId()+"where user_id ="+like.getUserId() +"and scrip_id ="+like.getScripId();
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
    public boolean delete(Integer userId,Integer scripId) {
        int num = 0;
        try {
            String sql = "delete from user where user_id = ? and scrip_id = ?";//创建sql语句
            ps=conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, scripId);
            num = ps.executeUpdate();
            if(num!=0)
                IsSuccess =true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return IsSuccess;
    }
}
