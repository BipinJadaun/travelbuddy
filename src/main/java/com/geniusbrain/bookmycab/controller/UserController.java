package com.geniusbrain.bookmycab.controller;

import com.geniusbrain.bookmycab.exception.ResourceAlreadyExistException;
import com.geniusbrain.bookmycab.exception.ResourceNotFoundException;
import com.geniusbrain.bookmycab.model.UserDetails;
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

	@PostMapping("/register")
	public UserDetails userRegistration(@RequestBody UserDetails userDetails) throws ResourceAlreadyExistException {
		validationService.validateNewUser(userDetails.getUserId());
		return userService.addUser(userDetails);
	}

	@PutMapping("/updateProfile")
	public void updateUserProfile(@RequestParam("userId") String userId, @RequestBody UserDetails userDetails) throws ResourceNotFoundException {
		validationService.validateUser(userId);
		userService.updateUser(userId, userDetails);
	}

	@DeleteMapping("/deleteProfile")
	public void deleteUserProfile(@RequestParam("userId") String userId) throws ResourceNotFoundException {
		validationService.validateUser(userId);
		userService.deleteUser(userId);
	}

	@GetMapping("/getUser")
	public UserDetails getUser(@RequestParam("userId") String userId) throws ResourceNotFoundException {
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
