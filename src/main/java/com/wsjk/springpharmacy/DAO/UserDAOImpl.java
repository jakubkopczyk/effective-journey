package com.wsjk.springpharmacy.DAO;

import com.wsjk.springpharmacy.model.UserEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserDAOImpl extends GenericDAOImpl<UserEntity>
        implements UserDAO {
    @Override
    public UserEntity findByUsername(String username) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = query.from(UserEntity.class);
        query.select(root).where(builder.equal(builder.lower(root.get("USERNAME")), username.toLowerCase()));
        Query<UserEntity> q=getCurrentSession().createQuery(query);
        return q.getSingleResult();
    }
}
