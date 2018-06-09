package com.wsjk.springpharmacy.DAO;

import com.wsjk.springpharmacy.model.BezReceptyEntity;
import com.wsjk.springpharmacy.model.NaRecepteEntity;

public interface NaRecepteDAO extends IGenericDAO<NaRecepteEntity> {
    NaRecepteEntity findByName(String name);
}
