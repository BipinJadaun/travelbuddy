package com.geniusbrain.bookmycab.service;

import com.geniusbrain.bookmycab.Dao.UserDao;
import com.geniusbrain.bookmycab.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails getUser(String userId){
		return userDao.getUser(userId);
	}
	
	@Override
	public UserDetails addUser(UserDetails userDetails) {
		return userDao.addUser(userDetails);
	}
	
	@Override
	public UserDetails updateUser(String userId, UserDetails userDetails) {
		return userDao.updateUser(userId, userDetails);
	}
	
	@Override
	public void deleteUser(String userId) {
		userDao.deleteUser(userId);
	}

	@Override
	public double getWalletMoney(String userId) {
		UserDetails userDetails = getUser(userId);
		return userDetails.getWalletMoney();
	}

	@Override
	public double addWalletMoney(String userId, double amount) {
		UserDetails userDetails = getUser(userId);
		double totalAmount = userDetails.getWalletMoney() + amount;
		userDetails.setWalletMoney(totalAmount);
		userDao.updateUser(userId, userDetails);
		return totalAmount;
	}

}
