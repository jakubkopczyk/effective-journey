package com.wsjk.springpharmacy.Services;

import com.wsjk.springpharmacy.model.NaRecepteEntity;

public interface NaRecepteService extends GenericService<NaRecepteEntity> {
    NaRecepteEntity findByName(String name);
}
