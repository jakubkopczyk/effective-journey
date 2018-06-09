package com.wsjk.springpharmacy.DAO;

import com.wsjk.springpharmacy.model.BezReceptyEntity;

public interface BezReceptyDAO extends IGenericDAO<BezReceptyEntity> {
    BezReceptyEntity findByName(String name);
}
