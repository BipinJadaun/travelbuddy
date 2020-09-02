package com.geniusbrain.bookmycab.Dao;

import com.geniusbrain.bookmycab.model.User;
import com.geniusbrain.bookmycab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean isValidUser(String userId) {
		return userRepository.existsById(userId);
	}

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId).get();
	}
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(String userId, User user) {
		User user1 = userRepository.findById(userId).get();

		user1.setPassword(user.getPassword());
		user1.setFullName(user.getFullName());
		user1.setPhoneNo(user.getPhoneNo());
		user1.setMailId(user.getMailId());

		return userRepository.save(user1);
	}
	
	@Override
	public void deleteUser(String userId){
		User user = userRepository.findById(userId).get();
		userRepository.delete(user);
	}
}
