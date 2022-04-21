package service.Impl;

import dao.EnvelopeDao;
import dao.Impl.EnvelopeDaoImpl;
import po.Envelope;
import service.EnvelopeService;

import java.util.List;

public class EnvelopeServiceImpl implements EnvelopeService {
    EnvelopeDao envelopeDao = new EnvelopeDaoImpl();

    @Override
    public Envelope selectById(Integer id) {
        return envelopeDao.selectById(id);
    }

    @Override
    public boolean insert(Envelope envelope) {
        return envelopeDao.insert(envelope);
    }

    @Override
    public boolean update(Envelope envelope) {
        return envelopeDao.update(envelope);
    }

    @Override
    public boolean delete(Integer id) {
        return envelopeDao.delete(id);
    }
}
