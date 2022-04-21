package dao.Impl;

import dao.ReviewDao;
import po.Review;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReviewDaoImpl implements ReviewDao {
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
    public List<Review> selectCondition(Review review) {
        return null;
    }

    @Override
    public Review selectById(Integer id) {
        return null;
    }

    @Override
    public boolean insert(Review review) {
        try {
            String sql = "insert into review(pk_id,scrip_id,user_id,content) values(" + review.getId() + "," +review.getScripId()+","+review.getUserId()+ "," +review.getContent()+")";
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
    public boolean update(Review review) {
        int num=0;
        try {
            String sql = "update review SET pk_id="+review.getId()+",scrip_id="+review.getScripId()+",user_id="+review.getUserId()+",content='"+review.getContent()+"'where pk_id ="+ review.getId();
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
