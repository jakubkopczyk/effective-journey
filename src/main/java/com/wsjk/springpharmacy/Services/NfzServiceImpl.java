package com.wsjk.springpharmacy.Services;

import com.wsjk.springpharmacy.DAO.IGenericDAO;
import com.wsjk.springpharmacy.DAO.NfzDAO;
import com.wsjk.springpharmacy.model.NfzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NfzServiceImpl extends GenericServiceImpl<NfzEntity>
        implements NfzService {
    private NfzDAO nfzDAO;

    public NfzServiceImpl() {
    }

    @Autowired
    public NfzServiceImpl(
            @Qualifier("nfzDAOImpl") IGenericDAO<NfzEntity> genericDao) {
        super(genericDao);
        this.nfzDAO = (NfzDAO) genericDao;
    }
}
