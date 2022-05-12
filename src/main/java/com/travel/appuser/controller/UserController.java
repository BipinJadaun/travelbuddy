package com.travel.appuser.controller;

import com.travel.appuser.model.AppUser;
import com.travel.bookmycab.controller.CabBookingController;
import com.travel.appuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	@PreAuthorize("hasRole('ROLE_USER')")
	public EntityModel<AppUser> getUser(@PathVariable String userId) {
		AppUser user = userService.getUser(userId);
		EntityModel<AppUser> resource = EntityModel.of(user);
		Link trips = WebMvcLinkBuilder.linkTo(methodOn(CabBookingController.class).getBookingHistory(userId)).withRel("Booking History");
		resource.add(trips);
		Link wallet_money = linkTo(methodOn(UserController.class).getWalletMoney(userId)).withRel("Wallet");
		resource.add(wallet_money);
		return resource;
	}

	@PutMapping("/{userId}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public AppUser updateUserProfile(@PathVariable String userId, @RequestBody AppUser appUser) {
		return userService.updateUser(userId, appUser);
	}

	@DeleteMapping("/{userId}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public void deleteUserProfile(@PathVariable String userId) {
		userService.deleteUser(userId);
	}

	@GetMapping("/{userId}/getWalletMoney")
	@PreAuthorize("hasRole('ROLE_USER')")
	public double getWalletMoney(@PathVariable String userId) {
		return userService.getWalletMoney(userId);
	}

	@PutMapping("/{userId}/addWalletMoney")
	@PreAuthorize("hasRole('ROLE_USER')")
	public double addWalletMoney(@PathVariable String userId, @RequestParam("amount") double amount) {
		return userService.addWalletMoney(userId, amount);
	}
}
