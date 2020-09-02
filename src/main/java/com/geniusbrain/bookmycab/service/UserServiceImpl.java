package com.geniusbrain.bookmycab.service;

import com.geniusbrain.bookmycab.Dao.UserDao;
import com.geniusbrain.bookmycab.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(String userId){
		return userDao.getUser(userId);
	}
	
	@Override
	public User addUser(User user) {
		return userDao.addUser(user);
	}
	
	@Override
	public User updateUser(String userId, User user) {
		return userDao.updateUser(userId, user);
	}
	
	@Override
	public void deleteUser(String userId) {
		userDao.deleteUser(userId);
	}

	@Override
	public double getWalletMoney(String userId) {
		User user = getUser(userId);
		return user.getWalletMoney();
	}

	@Override
	public double addWalletMoney(String userId, double amount) {
		User user = getUser(userId);
		double totalAmount = user.getWalletMoney() + amount;
		user.setWalletMoney(totalAmount);
		userDao.updateUser(userId, user);
		return totalAmount;
	}

}
