package dao.Impl;

import dao.CollectionDao;
import po.Collection;
import po.Envelope;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CollectionDaoImpl implements CollectionDao {
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
    public List<Collection> selectCondition(Collection collection) {
        return null;
    }

    @Override
    public Collection selectById(Integer userId,Integer scripId) {
        try {
            String querySQL = "SELECT * FROM collection WHERE user_id = ? and scrip_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(querySQL);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, scripId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return Collection.initialize(resultSet); else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(Collection collection) {
        return false;
    }

    @Override
    public boolean update(Collection collection) {
        return false;
    }

    @Override
    public boolean delete(Integer userId,Integer scripId) {
        int num = 0;
        try {
            String sql = "delete from collection where WHERE user_id = ? and scrip_id = ?";//创建sql语句
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
