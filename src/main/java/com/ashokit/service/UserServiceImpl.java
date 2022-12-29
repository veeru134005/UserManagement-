package com.ashokit.service;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.ashokit.entity.City;
import com.ashokit.entity.Country;
import com.ashokit.entity.State;
import com.ashokit.entity.Users;
import com.ashokit.pojos.User;
import com.ashokit.pojos.UserUnLock;
import com.ashokit.repo.CityRepository;
import com.ashokit.repo.CountryRepository;
import com.ashokit.repo.StateRepository;
import com.ashokit.repo.UserRepository;
import com.ashokit.utility.UserUtlity;

public class UserServiceImpl implements UserService {

	@Autowired
	private CityRepository cityRepo;

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private CountryRepository countryRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public String login(User login) {
		return userRepo.login(login.getEmail(), login.getPassword()) != null ? "User Login Successfully"
				: "Invalide Credentials";
	}

	@Override
	public String registerUser(Users userSignUp) throws Exception {

		UserUtlity.validateRegistration(userSignUp);
		
		if (!checkEmail(userSignUp.getEmail()).isBlank()) {
			return "Email Already Exists";
		}

		userSignUp.setPassword(String.valueOf(new Random().nextInt(125452)));

		sendEmail(userSignUp);

		return userRepo.save(userSignUp) != null ? "UserCreated SuccessFully"
				: "Unable to Create User Please try Again";
	}

	@Override
	public Map<Integer, String> getCounty() {
		return countryRepo.findAll().stream().collect(Collectors.toMap(Country::getCountryId, Country::getCountryName));
	}

	@Override
	public Map<Integer, String> getState(Integer countryId) {
		return stateRepo.getState(countryId).stream().collect(Collectors.toMap(State::getStateId, State::getStateName));
	}

	@Override
	public Map<Integer, String> getCity(Integer stateId) {
		return cityRepo.getCity(stateId).stream().collect(Collectors.toMap(City::getCitId, City::getCityName));
	}

	@Override
	public String checkEmail(String email) {

		if (userRepo.checkEmail(email) != null) {
			return "Email Already exist";
		} else {
			return "";
		}
	}

	@Override
	public String userUnLock(UserUnLock userUnLock) throws Exception {

		UserUtlity.validateUserUnlockForm(userUnLock);

		if (!userUnLock.getPassword().trim().equalsIgnoreCase(userRepo.getPassword(userUnLock.getEmail()))) {
			return "Please Enter Valide Temparary Password";
		} else {

			userRepo.userUnlock(userUnLock.getPassword(), userUnLock.getEmail());
			return "Account unlocked, please proceed with login";
		}

	}

	@Override
	public String forgotPassword(String email) {

		if (checkEmail(email).isBlank()) {
			return "InValid Email";
		}

		sendEmail(userRepo.getPassword(email), email);

		return "Password send To your MailId";
	}

	private void sendEmail(String password, String email) {

	}

	private void sendEmail(Users signUp) {

	}

}
