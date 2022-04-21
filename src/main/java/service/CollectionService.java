package service;

import dao.CollectionDao;
import po.Collection;

import java.util.List;

public interface CollectionService{
    //多条件查询

    //        public Scrip selectByName(String name);
    //根据id查询
    public Collection selectById(Integer userId,Integer scripId);
    //新增数据
    public abstract boolean insert(Collection collection);
    //修改数据
    public abstract boolean update(Collection collection);
    //删除数据
    public abstract boolean delete(Integer userId,Integer scripId);
}
