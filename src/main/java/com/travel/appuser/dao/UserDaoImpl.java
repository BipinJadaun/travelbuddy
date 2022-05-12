package com.travel.appuser.dao;

import com.travel.appuser.model.AppUser;
import com.travel.appuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean isValidUser(String userId) {
		return userRepository.existsById(userId);
	}

	@Override
	public AppUser getUser(String userId) {
		return userRepository.findById(userId).get();
	}
	
	@Override
	public AppUser addUser(AppUser user) {
		return userRepository.save(user);
	}
	
	@Override
	public AppUser updateUser(String userId, AppUser appUser) {
		AppUser temp = userRepository.findById(userId).get();

		temp.setFullName(appUser.getFullName());
		temp.setPhoneNo(appUser.getPhoneNo());
		temp.setMailId(appUser.getMailId());

		return userRepository.save(temp);
	}
	
	@Override
	public void deleteUser(String userId){
		AppUser temp = userRepository.findById(userId).get();
		userRepository.delete(temp);
	}
}
