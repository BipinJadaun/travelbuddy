package com.geniusbrain.bookmycab.service;

import com.geniusbrain.bookmycab.exception.ResourceAlreadyExistException;
import com.geniusbrain.bookmycab.exception.ResourceNotFoundException;
import com.geniusbrain.bookmycab.model.User;

public interface UserService {
    User getUser(String userId);

    User addUser(User user);

    User updateUser(String userId, User user);

    void deleteUser(String userId);

    double getWalletMoney(String userId);

    double addWalletMoney(String userId, double amount);
}
