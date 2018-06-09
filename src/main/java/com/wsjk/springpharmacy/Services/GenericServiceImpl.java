package com.wsjk.springpharmacy.Services;

import com.wsjk.springpharmacy.DAO.IGenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public abstract class GenericServiceImpl<T> implements GenericService<T> {
    private IGenericDAO<T> genericDao;

    public GenericServiceImpl(IGenericDAO<T> genericDao) {
        this.genericDao=genericDao;
    }

    public GenericServiceImpl() {
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(T entity) {
        genericDao.saveOrUpdate(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> findAll() {
        return genericDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public T findOne(int id) {
        return genericDao.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(T entity) {
        genericDao.create(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(T entity) {
        genericDao.delete(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final Integer id){
        genericDao.deleteById(id);
    }
}
