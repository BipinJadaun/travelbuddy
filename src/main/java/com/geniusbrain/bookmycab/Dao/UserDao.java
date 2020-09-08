package com.geniusbrain.bookmycab.Dao;

import com.geniusbrain.bookmycab.model.UserDetails;

public interface UserDao {

    boolean isValidUser(String userId);

    UserDetails getUser(String userId);

    UserDetails addUser(UserDetails userDetails);

    UserDetails updateUser(String userId, UserDetails userDetails);

    void deleteUser(String userId);
}
