package dao;

import po.Envelope;

import java.util.List;

public interface EnvelopeDao {
    //多条件查询
    public abstract List<Envelope> selectCondition(Envelope envelope);

    //        public Scrip selectByName(String name);
    //根据id查询
    public abstract Envelope selectById(Integer id);
    //新增数据
    public abstract boolean insert(Envelope envelope);
    //修改数据
    public abstract boolean update(Envelope envelope);
    //删除数据
    public abstract boolean delete(Integer id);
}
