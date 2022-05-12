package com.travel.appuser.dao;

import com.travel.appuser.model.AppUser;

public interface UserDao {

    boolean isValidUser(String userId);

    AppUser getUser(String userId);

    AppUser addUser(AppUser userDetails);

    AppUser updateUser(String userId, AppUser userDetails);

    void deleteUser(String userId);
}
