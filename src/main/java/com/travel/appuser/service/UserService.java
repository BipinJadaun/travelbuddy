package com.travel.appuser.service;

import com.travel.appuser.model.AppUser;

public interface UserService {
    AppUser getUser(String userId);

    AppUser addUser(AppUser user);

    AppUser updateUser(String userId, AppUser appUser);

    void deleteUser(String userId);

    double getWalletMoney(String userId);

    double addWalletMoney(String userId, double amount);
}
