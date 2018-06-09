package com.wsjk.springpharmacy.Services;

import com.wsjk.springpharmacy.DAO.IGenericDAO;
import com.wsjk.springpharmacy.DAO.NaRecepteDAO;
import com.wsjk.springpharmacy.model.NaRecepteEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NaRecepteServiceImpl extends GenericServiceImpl<NaRecepteEntity>
        implements NaRecepteService {
    private NaRecepteDAO naRecepteDAO;

    public NaRecepteServiceImpl(@Qualifier("naRecepteDAOImpl") IGenericDAO<NaRecepteEntity> genericDao) {
        super(genericDao);
        this.naRecepteDAO = (NaRecepteDAO) genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public NaRecepteEntity findByName(String name) {
        return naRecepteDAO.findByName(name);
    }
}
