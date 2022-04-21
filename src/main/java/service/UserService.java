package service;

import dao.UserDao;
import po.User;
import utils.ResultInfo;

import java.util.List;

public interface UserService {
        //注册
        public ResultInfo regist(User user);
        //登录
        public User login(String email,String privateSecret);

        public User selectByName(String name);
        //根据id查询
        public abstract User selectById(Integer id);
        //新增数据
        public abstract boolean insert(User user);
        //修改数据
        public abstract boolean update(User user);
        //删除数据
        public abstract boolean delete(Integer id);
        //根据email查询
        public User selectByEmail(String email);

}
