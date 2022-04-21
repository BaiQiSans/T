package dao;

import po.User;

import java.util.List;

public interface UserDao {
        //多条件查询
        public abstract List<User> selectCondition(User user);

        public User selectByName(String name);

        public User selectByEmail(String email);
        //根据id查询
        public abstract User selectById(Integer id);
        //新增数据
        public abstract boolean insert(User user);
        //修改数据
        public abstract boolean update(User user);
        //删除数据
        public abstract boolean delete(Integer id);


}
