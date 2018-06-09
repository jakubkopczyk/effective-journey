package com.wsjk.springpharmacy.DAO;

import com.wsjk.springpharmacy.model.NaRecepteEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class NaRecepteDAOImpl extends GenericDAOImpl<NaRecepteEntity>
        implements NaRecepteDAO {
    @Override
    public NaRecepteEntity findByName(String name) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<NaRecepteEntity> query = builder.createQuery(NaRecepteEntity.class);
        Root<NaRecepteEntity> root = query.from(NaRecepteEntity.class);
        query.select(root).where(builder.equal(builder.lower(root.get("nazwa")), name.toLowerCase()));
        Query<NaRecepteEntity> q=getCurrentSession().createQuery(query);
        return q.getSingleResult();
    }
}
