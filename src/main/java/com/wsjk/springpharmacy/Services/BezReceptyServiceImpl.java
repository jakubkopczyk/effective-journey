package com.wsjk.springpharmacy.Services;

import com.wsjk.springpharmacy.DAO.BezReceptyDAO;
import com.wsjk.springpharmacy.DAO.IGenericDAO;
import com.wsjk.springpharmacy.model.BezReceptyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BezReceptyServiceImpl extends GenericServiceImpl<BezReceptyEntity>
        implements BezReceptyService {
    private BezReceptyDAO bezReceptyDAO;

    public BezReceptyServiceImpl() {
    }

    @Autowired
    public BezReceptyServiceImpl(@Qualifier("bezReceptyDAOImpl") IGenericDAO<BezReceptyEntity> genericDao) {
        super(genericDao);
        this.bezReceptyDAO = (BezReceptyDAO) genericDao;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BezReceptyEntity findByName(String name) {
        return this.bezReceptyDAO.findByName(name);
    }
}
