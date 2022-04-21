package service.Impl;

import dao.Impl.ScripDaoImpl;
import dao.ScripDao;
import po.Scrip;
import service.ScripService;

import java.util.List;

public class ScripServiceImpl implements ScripService {
    ScripDao scripDao = new ScripDaoImpl();

    @Override
    public Scrip selectById(Integer id) {
        return scripDao.selectById(id);
    }

    @Override
    public boolean insert(Scrip scrip) {
        return scripDao.insert(scrip);
    }

    @Override
    public boolean update(Scrip scrip) {
        return scripDao.update(scrip);
    }

    @Override
    public boolean delete(Integer id) {
        return scripDao.delete(id);
    }
}
