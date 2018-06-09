package com.wsjk.springpharmacy.Services;

import com.wsjk.springpharmacy.model.BezReceptyEntity;

public interface BezReceptyService extends GenericService<BezReceptyEntity> {
    BezReceptyEntity findByName(String name);
}
