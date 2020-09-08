package com.geniusbrain.bookmycab.Dao;

import com.geniusbrain.bookmycab.model.UserDetails;
import com.geniusbrain.bookmycab.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public boolean isValidUser(String userId) {
		return userDetailsRepository.existsById(userId);
	}

	@Override
	public UserDetails getUser(String userId) {
		return userDetailsRepository.findById(userId).get();
	}
	
	@Override
	public UserDetails addUser(UserDetails userDetails) {
		return userDetailsRepository.save(userDetails);
	}
	
	@Override
	public UserDetails updateUser(String userId, UserDetails userDetails) {
		UserDetails userDetails1 = userDetailsRepository.findById(userId).get();

		userDetails1.setFullName(userDetails.getFullName());
		userDetails1.setPhoneNo(userDetails.getPhoneNo());
		userDetails1.setMailId(userDetails.getMailId());

		return userDetailsRepository.save(userDetails1);
	}
	
	@Override
	public void deleteUser(String userId){
		UserDetails userDetails = userDetailsRepository.findById(userId).get();
		userDetailsRepository.delete(userDetails);
	}
}
