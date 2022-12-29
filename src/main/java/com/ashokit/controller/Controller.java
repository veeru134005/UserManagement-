package com.ashokit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Users;
import com.ashokit.pojos.User;
import com.ashokit.pojos.UserUnLock;
import com.ashokit.service.UserService;

@RestController
public class Controller {

	@Autowired
	private UserService service;

	@PostMapping(value = "/signin")
	public String login(@RequestBody User login) {
		return service.login(login);
	}

	// User Registrations- Start

	@PostMapping(value = "/signup")
	public String userRegistration(@RequestBody Users signUp) throws Exception {
		return service.registerUser(signUp);
	}

	@GetMapping("/countries")
	public Map<Integer,String> getCounty() {
		return service.getCounty();
	}

	@GetMapping("/state/{countryid}")
	public Map<Integer,String> getState(@PathVariable Integer countryid) {
		return service.getState(countryid);
	}

	@GetMapping("/city/{stateid}")
	public Map<Integer,String> getCity(@PathVariable Integer stateid) {
		return service.getCity(stateid);
	}

	// User Registrations- End

	// User Unlock
	@GetMapping("/checkEmail/{email}")
	public String checkEmail(@PathVariable String email) {
		return service.checkEmail(email);
	}

	@PostMapping("/unlockuser")
	public String unLockUser(@RequestBody UserUnLock userUnLock) throws Exception {
		return service.userUnLock(userUnLock);
	}

	// forgot-Password
	@GetMapping("/forgot/{email}")
	public String forgotPassword(@PathVariable String email) {
		return service.forgotPassword(email);
	}

}
