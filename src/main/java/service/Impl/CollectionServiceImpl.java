package service.Impl;

import dao.CollectionDao;
import dao.Impl.CollectionDaoImpl;
import po.Collection;
import service.CollectionService;

import java.util.List;

public class CollectionServiceImpl implements CollectionService {
    CollectionDao collectionDao = new CollectionDaoImpl();

    @Override
    public Collection selectById(Integer userId, Integer scripId) {
        return collectionDao.selectById(userId,scripId);
    }

    @Override
    public boolean insert(Collection collection) {
        return collectionDao.insert(collection);
    }

    @Override
    public boolean update(Collection collection) {
        return collectionDao.update(collection);
    }

    @Override
    public boolean delete(Integer userId, Integer scripId) {
        return collectionDao.delete(userId,scripId);
    }
}
