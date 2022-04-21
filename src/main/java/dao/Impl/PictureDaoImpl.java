package dao.Impl;

import dao.PictureDao;
import po.Picture;
import po.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PictureDaoImpl implements PictureDao {
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
    public List<Picture> selectCondition(Picture picture) {
        return null;
    }

    @Override
    public Picture selectById(Integer id) {
        try {
            String querySQL = "SELECT * FROM picture WHERE pk_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(querySQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return Picture.initialize(resultSet); else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(Picture picture) {
        try {
            String sql = "insert into picture(pk_id,picture_path) values(" + picture.getId() + "," +picture.getPicturePath()+")";
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
    public boolean update(Picture picture) {
        int num=0;
        try {
            String sql = "update picture SET pk_id="+picture.getId()+",picture_path='"+picture.getPicturePath()+"'where pk_id ="+picture.getId();
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
