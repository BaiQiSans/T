package service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Impl.UserDaoImpl;
import dao.UserDao;
import po.User;
import service.UserService;
import utils.ResultInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public User login(String email,String privateSecret){
        UserService userService = new UserServiceImpl();
        User user = userService.selectByEmail(email);
        return user;

    }

    @Override
    public ResultInfo regist(User user) {
        return new ResultInfo();
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public User selectById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User selectByEmail(String email) {
        return userDao.selectByEmail(email);
    }
}
