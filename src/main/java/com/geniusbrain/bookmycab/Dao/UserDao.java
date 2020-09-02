package com.geniusbrain.bookmycab.Dao;

import com.geniusbrain.bookmycab.exception.ResourceAlreadyExistException;
import com.geniusbrain.bookmycab.exception.ResourceNotFoundException;
import com.geniusbrain.bookmycab.model.User;

public interface UserDao {

    boolean isValidUser(String userId);

    User getUser(String userId);

    User addUser(User user);

    User updateUser(String userId, User user);

    void deleteUser(String userId);
}
