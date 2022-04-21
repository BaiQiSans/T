package service;

import dao.ReviewDao;
import po.Review;

import java.util.List;

public interface ReviewService{
        //多条件查询

//        public Scrip selectByName(String name);
        //根据id查询
        public abstract Review selectById(Integer id);
        //新增数据
        public abstract boolean insert(Review review);
        //修改数据
        public abstract boolean update(Review review);
        //删除数据
        public abstract boolean delete(Integer id);
}
