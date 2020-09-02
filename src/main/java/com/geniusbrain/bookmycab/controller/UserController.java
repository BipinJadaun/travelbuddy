package com.geniusbrain.bookmycab.controller;

import com.geniusbrain.bookmycab.exception.ResourceAlreadyExistException;
import com.geniusbrain.bookmycab.exception.ResourceNotFoundException;
import com.geniusbrain.bookmycab.model.User;
import com.geniusbrain.bookmycab.service.UserService;
import com.geniusbrain.bookmycab.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ValidationService validationService;

	@GetMapping("/login")
	public void userLogin(@RequestParam ("userName") String userName, @RequestParam("password") String password) {
		
	}

	@PostMapping("/register")
	public User userRegistration(@RequestBody User user) throws ResourceAlreadyExistException {
		validationService.validateNewUser(user.getUserId());
		return userService.addUser(user);
	}

	@PutMapping("/updateProfile")
	public void updateUserProfile(@RequestParam("userId") String userId, @RequestBody User user) throws ResourceNotFoundException {
		validationService.validateUser(userId);
		userService.updateUser(userId, user);
	}

	@DeleteMapping("/deleteProfile")
	public void deleteUserProfile(@RequestParam("userId") String userId) throws ResourceNotFoundException {
		validationService.validateUser(userId);
		userService.deleteUser(userId);
	}

	@GetMapping("/getUser")
	public User getUser(@RequestParam("userId") String userId) throws ResourceNotFoundException {
		validationService.validateUser(userId);
		return userService.getUser(userId);
	}

	@GetMapping("/getWalletMoney")
	public double getWalletMoney(@RequestParam("userId") String userId)throws ResourceNotFoundException {
		validationService.validateUser(userId);
		return userService.getWalletMoney(userId);
	}

	@PutMapping("/addWalletMoney")
	public double addWalletMoney(@RequestParam("userId") String userId, @RequestParam("amount") double amount) throws ResourceNotFoundException {
		validationService.validateUser(userId);
		return userService.addWalletMoney(userId, amount);
	}
}
