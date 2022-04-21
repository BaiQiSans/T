package dao.Impl;

import dao.EnvelopeScripDao;
import po.EnvelopeScrip;
import po.Picture;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EnvelopeScripDaoImpl implements EnvelopeScripDao {
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
    public List<EnvelopeScrip> selectCondition(EnvelopeScrip envelopeScrip) {
        return null;
    }

    @Override
    public EnvelopeScrip selectById(Integer envelopeId,Integer scripId) {
        try {
            String querySQL = "SELECT * FROM envelope_scrip WHERE envelope_id = ? and scrip_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(querySQL);
            preparedStatement.setInt(1, envelopeId);
            preparedStatement.setInt(2, scripId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return EnvelopeScrip.initialize(resultSet); else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(EnvelopeScrip envelopeScrip) {
        try {
            String sql = "insert into envelope_scrip(envelope_id,scrip_id) values(" + envelopeScrip.getEnvelopeId() + "," +envelopeScrip.getScripId()+")";
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
    public boolean update(EnvelopeScrip envelopeScrip) {
        return false;
    }

    @Override
    public boolean delete(Integer envelopeId,Integer scripId) {
        int num = 0;
        try {
            String sql = "delete from user WHERE envelope_id = ? and scrip_id = ?";//创建sql语句
            ps=conn.prepareStatement(sql);
            ps.setInt(1, envelopeId);
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
