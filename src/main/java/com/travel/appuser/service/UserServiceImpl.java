package com.travel.appuser.service;

import com.travel.appuser.dao.UserDao;
import com.travel.appuser.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public AppUser getUser(String userId){
		return userDao.getUser(userId);
	}
	
	@Override
	public AppUser addUser(AppUser user) {
		user.setActive(true);
		user.getRoles().add("User");
		return userDao.addUser(user);
	}
	
	@Override
	public AppUser updateUser(String userId, AppUser appUser) {
		return userDao.updateUser(userId, appUser);
	}
	
	@Override
	public void deleteUser(String userId) {
		userDao.deleteUser(userId);
	}

	@Override
	public double getWalletMoney(String userId) {
		AppUser AppUser = getUser(userId);
		return AppUser.getWalletMoney();
	}

	@Override
	public double addWalletMoney(String userId, double amount) {
		AppUser AppUser = getUser(userId);
		double totalAmount = AppUser.getWalletMoney() + amount;
		AppUser.setWalletMoney(totalAmount);
		updateUser(userId, AppUser);
		return totalAmount;
	}

}
