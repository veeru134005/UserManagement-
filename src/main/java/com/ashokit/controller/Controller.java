package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.pojos.UserForm;
import com.ashokit.pojos.UserUnLock;
import com.ashokit.service.UserService;

@RestController
public class Controller {

	@Autowired
	private UserService service;

	@PostMapping(value = "/signin")
	public String signIn(@RequestBody UserForm login) {
		return service.signIn(login);
	}

	// User Registrations- Start

	@PostMapping(value = "/signup")
	public String userRegistration(@RequestBody UserForm signUp) {
		return service.userRegistration(signUp);
	}

	@GetMapping("/countries")
	public List<String> getCounty() {
		return service.getCounty();
	}

	@GetMapping("/state/{country}")
	public List<String> getState(@PathVariable String country) {
		return service.getState(country);
	}

	@GetMapping("/city/{state}")
	public List<String> getCity(@PathVariable String state) {
		return service.getCity(state);
	}

	// User Registrations- End

	// User Unlock
	@GetMapping("/activation/{email}")
	public String userActivate(@PathVariable String email) {
		return service.userActivate(email);
	}

	@PostMapping("/unlockuser")
	public String unLockUser(@RequestBody UserUnLock userUnLock) {
		return service.userUnLock(userUnLock);
	}

	// forgot-Password
	@GetMapping("/forgot/{email}")
	public String forgotPassword(@PathVariable String email) {
		return service.forgotPassword(email);
	}

}
