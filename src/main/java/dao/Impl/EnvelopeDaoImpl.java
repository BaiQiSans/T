package dao.Impl;

import dao.EnvelopeDao;
import po.Envelope;
import po.EnvelopeScrip;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EnvelopeDaoImpl implements EnvelopeDao {
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
    public List<Envelope> selectCondition(Envelope envelope) {
        return null;
    }

    @Override
    public Envelope selectById(Integer id) {
        try {
            String querySQL = "SELECT * FROM user WHERE pk_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(querySQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return Envelope.initialize(resultSet); else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(Envelope envelope) {
        try {
            String sql = "insert into envelope(pk_id,name,introduction,is_private) values(" + envelope.getId() + "," +envelope.getName()+","+envelope.getIntroduction()+","+envelope.isPrivate()+")";
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
    public boolean update(Envelope envelope) {
        int num=0;
        try {
            String sql = "update envelope SET pk_id="+envelope.getId()+",name="+envelope.getName()+",introduction="+envelope.getIntroduction()+",is_private="+envelope.isPrivate()+"where pk_id ="+envelope.getId();
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
