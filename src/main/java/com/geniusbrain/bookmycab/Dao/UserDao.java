package com.geniusbrain.bookmycab.Dao;

import com.geniusbrain.bookmycab.model.AppUser;
import com.geniusbrain.bookmycab.model.UserDetails;

public interface UserDao {

    boolean isValidUser(String userId);

    UserDetails getUser(String userId);

    AppUser addUser(AppUser userDetails);

    UserDetails updateUser(String userId, UserDetails userDetails);

    void deleteUser(String userId);
}
