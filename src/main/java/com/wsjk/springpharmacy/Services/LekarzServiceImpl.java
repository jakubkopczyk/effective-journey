package com.wsjk.springpharmacy.Services;

import com.wsjk.springpharmacy.DAO.IGenericDAO;
import com.wsjk.springpharmacy.DAO.LekarzDAO;
import com.wsjk.springpharmacy.DAO.NfzDAO;
import com.wsjk.springpharmacy.model.LekarzEntity;
import com.wsjk.springpharmacy.model.NfzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LekarzServiceImpl extends GenericServiceImpl<LekarzEntity>
        implements LekarzService {
    private LekarzDAO lekarzDAO;

    public LekarzServiceImpl() {
    }

    @Autowired
    public LekarzServiceImpl(
            @Qualifier("lekarzDAOImpl") IGenericDAO<LekarzEntity> genericDao) {
        super(genericDao);
        this.lekarzDAO = (LekarzDAO) genericDao;
    }

}
