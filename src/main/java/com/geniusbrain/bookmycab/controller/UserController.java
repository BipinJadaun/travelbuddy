package com.geniusbrain.bookmycab.controller;

import com.geniusbrain.bookmycab.model.UserDetails;
import com.geniusbrain.bookmycab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/getUser")
	@PreAuthorize("hasRole('USER')")
	public UserDetails getUser(@RequestParam("userId") String userId) {
		return userService.getUser(userId);
	}

	@PutMapping("/updateProfile")
	@PreAuthorize("hasRole('USER')")
	public UserDetails updateUserProfile(@RequestParam("userId") String userId, @RequestBody UserDetails userDetails) {
		return userService.updateUser(userId, userDetails);
	}

	@DeleteMapping("/deleteProfile")
	@PreAuthorize("hasRole('USER')")
	public void deleteUserProfile(@RequestParam("userId") String userId) {
		userService.deleteUser(userId);
	}

	@GetMapping("/getWalletMoney")
	@PreAuthorize("hasRole('USER')")
	public double getWalletMoney(@RequestParam("userId") String userId) {
		return userService.getWalletMoney(userId);
	}

	@PutMapping("/addWalletMoney")
	@PreAuthorize("hasRole('USER')")
	public double addWalletMoney(@RequestParam("userId") String userId, @RequestParam("amount") double amount) {
		return userService.addWalletMoney(userId, amount);
	}
}
