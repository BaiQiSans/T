package service.Impl;

import dao.EnvelopeScripDao;
import dao.Impl.EnvelopeScripDaoImpl;
import po.Envelope;
import po.EnvelopeScrip;
import service.EnvelopeScripService;
import service.EnvelopeService;

import java.util.List;

public class EnvelopeScripServiceImpl implements EnvelopeScripService {
    EnvelopeScripDao envelopeScripDao = new EnvelopeScripDaoImpl();


    @Override
    public EnvelopeScrip selectById(Integer envelopeId, Integer scripId) {
        return envelopeScripDao.selectById(envelopeId,scripId);
    }

    @Override
    public boolean insert(EnvelopeScrip envelopeScrip) {
        return envelopeScripDao.insert(envelopeScrip);
    }

    @Override
    public boolean update(EnvelopeScrip envelopeScrip) {
        return envelopeScripDao.update(envelopeScrip);
    }

    @Override
    public boolean delete(Integer envelopeId,Integer scripId) {
        return envelopeScripDao.delete(envelopeId,scripId);
    }
}
