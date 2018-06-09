package com.wsjk.springpharmacy.DAO;

import com.wsjk.springpharmacy.model.UserEntity;

public interface UserDAO extends IGenericDAO<UserEntity> {
    UserEntity findByUsername(String username);
}
