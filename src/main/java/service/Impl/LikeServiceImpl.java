package service.Impl;

import dao.Impl.LikeDaoImpl;
import dao.LikeDao;
import po.Like;
import service.LikeService;

import java.util.List;

public class LikeServiceImpl implements LikeService {
    LikeDao likeDao = new LikeDaoImpl();
    @Override
    public Like selectById(Integer userId, Integer scripId) {
        return likeDao.selectById(userId,scripId);
    }

    @Override
    public boolean insert(Like like) {
        return likeDao.insert(like);
    }

    @Override
    public boolean update(Like like) {
        return likeDao.update(like);
    }

    @Override
    public boolean delete(Integer userId,Integer scripId) {
        return likeDao.delete(userId,scripId);
    }
}
