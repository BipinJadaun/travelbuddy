package com.geniusbrain.bookmycab.controller;

import com.geniusbrain.bookmycab.model.UserDetails;
import com.geniusbrain.bookmycab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
public class UserController {
	
	@Autowired
	private UserService userService;

	//HATEOAS implementation: instead of returning just user details, a link to check the booking history.
	@GetMapping("/{userId}")
	public EntityModel<UserDetails> getUser(@PathVariable String userId) {
		UserDetails user = userService.getUser(userId);
		EntityModel<UserDetails> resource = EntityModel.of(user);
		Link trips = linkTo(methodOn(BookingController.class).getBookingHistory(userId)).withRel("Trips");
		resource.add(trips);
//		Link wallet_money = linkTo(methodOn(UserController.class).getWalletMoney(userId)).withRel("Wallet Money");
//		resource.add(wallet_money);
		return resource;
	}

	@PutMapping("/{userId}")
	public UserDetails updateUserProfile(@PathVariable String userId, @RequestBody UserDetails userDetails) {
		return userService.updateUser(userId, userDetails);
	}

	@DeleteMapping("/{userId}")
	public void deleteUserProfile(@PathVariable String userId) {
		userService.deleteUser(userId);
	}

	@GetMapping("/{userId}/getWalletMoney")
	public double getWalletMoney(@PathVariable String userId) {
		return userService.getWalletMoney(userId);
	}

	@PutMapping("/{userId}/addWalletMoney")
	public double addWalletMoney(@PathVariable String userId, @RequestParam("amount") double amount) {
		return userService.addWalletMoney(userId, amount);
	}
}
