package com.geniusbrain.bookmycab.service;

import com.geniusbrain.bookmycab.model.UserDetails;

public interface UserService {
    UserDetails getUser(String userId);

    UserDetails addUser(UserDetails userDetails);

    UserDetails updateUser(String userId, UserDetails userDetails);

    void deleteUser(String userId);

    double getWalletMoney(String userId);

    double addWalletMoney(String userId, double amount);
}
