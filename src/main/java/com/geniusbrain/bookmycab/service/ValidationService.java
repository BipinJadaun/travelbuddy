package com.geniusbrain.bookmycab.service;

import com.geniusbrain.bookmycab.Dao.UserDao;
import com.geniusbrain.bookmycab.exception.ResourceAlreadyExistException;
import com.geniusbrain.bookmycab.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    @Autowired
    private UserDao userDao;

    public void validateUser(String userId) throws ResourceNotFoundException{
        if(!userDao.isValidUser(userId)){
            throw new ResourceNotFoundException("Invalid user: "+ userId);
        }
    }

    public void validateNewUser(String userId) throws ResourceAlreadyExistException {
        if(userDao.isValidUser(userId)){
            throw new ResourceAlreadyExistException("UserDetails already exist: "+ userId);
        }
    }

}
