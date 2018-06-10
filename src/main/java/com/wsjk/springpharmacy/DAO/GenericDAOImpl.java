package com.wsjk.springpharmacy.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericDAOImpl< T extends Serializable> implements  IGenericDAO<T>{
    @Autowired
    EntityManager entityManager;

    private Class< ? extends T > entityClass;

    //@SuppressWarnings("unchecked")
    public GenericDAOImpl(){
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        entityClass = (Class) pt.getActualTypeArguments()[0];
    }

    protected final Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

@Override
    public T findOne( int id ){
        return getCurrentSession().get(entityClass, id );
    }
    @Override

    public List< T > findAll(){
        return getCurrentSession().createQuery( "from " + entityClass.getName() ).list();
    }

    //@SuppressWarnings("unchecked")
    @Override
    public void create(T entity) {
        // TODO Auto-generated method stub
         getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        // TODO Auto-generated method stub
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        // TODO Auto-generated method stub
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        T entity = this.findOne(id);
        this.delete(entity);
    }
}
