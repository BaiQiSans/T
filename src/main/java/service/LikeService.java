package service;

import dao.LikeDao;
import po.Like;

import java.util.List;

public interface LikeService{
    //多条件查询

    //        public Scrip selectByName(String name);
    //根据id查询
    public Like selectById(Integer userId,Integer scripId);
    //新增数据
    public abstract boolean insert(Like like);
    //修改数据
    public abstract boolean update(Like like);
    //删除数据
    public abstract boolean delete(Integer userId,Integer scripId);
}
