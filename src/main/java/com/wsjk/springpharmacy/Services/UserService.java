package com.wsjk.springpharmacy.Services;

import com.wsjk.springpharmacy.model.UserEntity;

public interface UserService extends GenericService<UserEntity> {
    UserEntity findByUsername(String username);

}
