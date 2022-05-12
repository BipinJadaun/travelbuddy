package com.travel.appuser.service;

import com.travel.appuser.dao.UserDao;
import com.travel.exception.ResourceAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    @Autowired
    private UserDao userDao;

    public void validateNewUser(String userId) throws ResourceAlreadyExistException {
//        if(!userDao.isValidUser(userId)){
//            throw new ResourceAlreadyExistException("User already exist: "+ userId);
//        }
    }

}
