package com.ashokit.repo;

import java.util.Map;

import com.ashokit.entity.Users;
import com.ashokit.pojos.LoginForm;
import com.ashokit.pojos.UserUnLock;

public interface UserService {
	
	public String login(LoginForm login);
	
	//User Registrations- Start
	public String registerUser(Users signUp) throws Exception;
	
	public Map<Integer,String> getCounty();
	public String checkEmail(String email);
	public Map<Integer,String> getState(Integer countryId);
	public Map<Integer,String> getCity(Integer stateId);
	//User Registrations- End
	
	//User Unlock
	//public String userActivate(String email);
	public String userUnLock(UserUnLock userUnLock) throws Exception;
	
	// forgot-Password
	public String forgotPassword(String email);
	
	
}
