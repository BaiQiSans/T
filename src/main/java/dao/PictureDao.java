package dao;

import po.Picture;

import java.util.List;

public interface PictureDao {
        //多条件查询
        public abstract List<Picture> selectCondition(Picture picture);

//        public Scrip selectByName(String name);
        //根据id查询
        public abstract Picture selectById(Integer id);
        //新增数据
        public abstract boolean insert(Picture picture);
        //修改数据
        public abstract boolean update(Picture picture);
        //删除数据
        public abstract boolean delete(Integer id);
}
