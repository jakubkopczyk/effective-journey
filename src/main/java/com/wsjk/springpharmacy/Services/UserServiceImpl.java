package com.wsjk.springpharmacy.Services;

import com.wsjk.springpharmacy.DAO.IGenericDAO;
import com.wsjk.springpharmacy.DAO.UserDAO;
import com.wsjk.springpharmacy.model.UserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends GenericServiceImpl<UserEntity>
implements UserService{
    private UserDAO userDAO;

    public UserServiceImpl(@Qualifier("userDAOImpl") IGenericDAO<UserEntity> genericDao) {
        super(genericDao);
        this.userDAO = (UserDAO) genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
