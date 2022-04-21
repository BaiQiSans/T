package dao.Impl;

import dao.ScripDao;
import po.Scrip;
import po.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ScripDaoImpl implements ScripDao {
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
    public List<Scrip> selectCondition(Scrip scrip) {
        return null;
    }

    @Override
    public Scrip selectById(Integer id) {
        try {
            String querySQL = "SELECT * FROM user WHERE pk_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(querySQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return Scrip.initialize(resultSet); else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(Scrip scrip) {
        try {
            String sql = "insert into scrip(pk_id,user_id,quote_scrip_id,is_private,content,picture_ids,title,readership,is_audit_status) values(" + scrip.getId() + "," +scrip.getUserId()+","+scrip.getQuoteScripId() + "," + scrip.isPrivate() + "," + scrip.getContent() + ","+scrip.getPictureIds()+","+scrip.getTitle()+","+scrip.getReadership()+","+scrip.isAuditStatus()+")";
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
    public boolean update(Scrip scrip) {
        int num=0;
        try {
            String sql = "update scrip SET pk_id="+scrip.getId()+",user_id="+scrip.getUserId()+",quote_scrip_id="+scrip.getQuoteScripId()+",is_private="+ scrip.isPrivate()+",content='"+scrip.getContent()+"',picture_ids="+scrip.getPictureIds()+",title="+scrip.getTitle()+",readership="+scrip.getReadership()+",is_audit_status="+scrip.isAuditStatus()+"where pk_id ="+ scrip.getId();
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
