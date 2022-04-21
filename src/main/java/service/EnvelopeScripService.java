package service;

import dao.EnvelopeScripDao;
import po.EnvelopeScrip;

import java.util.List;

public interface EnvelopeScripService{
    //多条件查询

    //        public Scrip selectByName(String name);
    //根据id查询
    public abstract EnvelopeScrip selectById(Integer envelopeId,Integer scripId);
    //新增数据
    public abstract boolean insert(EnvelopeScrip envelopeScrip);
    //修改数据
    public abstract boolean update(EnvelopeScrip envelopeScrip);
    //删除数据
    public abstract boolean delete(Integer envelopeId,Integer scripId);
}
