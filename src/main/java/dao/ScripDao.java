package dao;

import po.Scrip;

import java.util.List;

public interface ScripDao {
        //多条件查询
        public abstract List<Scrip> selectCondition(Scrip scrip);

//        public Scrip selectByName(String name);
        //根据id查询
        public abstract Scrip selectById(Integer id);
        //新增数据
        public abstract boolean insert(Scrip scrip);
        //修改数据
        public abstract boolean update(Scrip scrip);
        //删除数据
        public abstract boolean delete(Integer id);
}
