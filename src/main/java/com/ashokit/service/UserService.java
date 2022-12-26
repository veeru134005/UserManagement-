package com.ashokit.service;

import java.util.List;

import com.ashokit.pojos.UserForm;
import com.ashokit.pojos.UserUnLock;

public interface UserService {
	
	public String signIn(UserForm login);
	
	//User Registrations- Start
	public String userRegistration(UserForm signUp);
	public List<String> getCounty();
	public List<String> getState(String countryName);
	public List<String> getCity(String state);
	//User Registrations- End
	
	//User Unlock
	public String userActivate(String email);
	public String userUnLock(UserUnLock userUnLock);
	
	// forgot-Password
	public String forgotPassword(String email);
	
	
}
