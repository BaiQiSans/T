package service.Impl;

import dao.Impl.PictureDaoImpl;
import dao.PictureDao;
import po.Picture;
import service.PictureService;

import java.util.List;

public class PictureServiceImpl implements PictureService {
    PictureDao pictureDao = new PictureDaoImpl();

    @Override
    public Picture selectById(Integer id) {
        return pictureDao.selectById(id);
    }

    @Override
    public boolean insert(Picture picture) {
        return pictureDao.insert(picture);
    }

    @Override
    public boolean update(Picture picture) {
        return pictureDao.update(picture);
    }

    @Override
    public boolean delete(Integer id) {
        return pictureDao.delete(id);
    }
}
