package service.Impl;

import dao.Impl.ReviewDaoImpl;
import dao.ReviewDao;
import po.Review;
import service.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    ReviewDao reviewDao = new ReviewDaoImpl();

    @Override
    public Review selectById(Integer id) {
        return reviewDao.selectById(id);
    }

    @Override
    public boolean insert(Review review) {
        return reviewDao.insert(review);
    }

    @Override
    public boolean update(Review review) {
        return reviewDao.update(review);
    }

    @Override
    public boolean delete(Integer id) {
        return reviewDao.delete(id);
    }
}
