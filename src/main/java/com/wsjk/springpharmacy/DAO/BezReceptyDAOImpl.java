package com.wsjk.springpharmacy.DAO;

import com.wsjk.springpharmacy.model.BezReceptyEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class BezReceptyDAOImpl extends GenericDAOImpl<BezReceptyEntity>
        implements BezReceptyDAO {
    @Override
    public BezReceptyEntity findByName(String name) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<BezReceptyEntity> query = builder.createQuery(BezReceptyEntity.class);
        Root<BezReceptyEntity> root = query.from(BezReceptyEntity.class);
        query.select(root).where(builder.equal(builder.lower(root.get("nazwa")), name.toLowerCase()));
        Query<BezReceptyEntity> q=getCurrentSession().createQuery(query);
        return q.getSingleResult();
    }
}
