package com.ashokit.utility;

import java.rmi.ServerException;

import com.ashokit.entity.Users;
import com.ashokit.pojos.UserUnLock;

public class UserUtlity {

	public static void validateUserUnlockForm(UserUnLock userUnLock) throws Exception {

		if (userUnLock.getTempPassword() == null) {
			throw new ServerException("PleseEntry Temparary Password");
		}
		if (userUnLock.getPassword() == null) {
			throw new ServerException("PleseEntry Password");
		}
		if (userUnLock.getConfirmPassword() == null) {
			throw new ServerException("PleseEntry ConfirmPassword");
		}
		if (!userUnLock.getConfirmPassword().trim().equalsIgnoreCase(userUnLock.getPassword().trim())) {
			throw new ServerException("New Password and Confirm Password should be same");
		}

	}

	public static void validateRegistration(Users userSignUp) throws Exception {
		if (userSignUp.getFirstName() == null) {
			throw new ServerException("Please Enter First Name");
		}

		if (userSignUp.getLastName() == null) {
			throw new ServerException("Please Enter Last Name");
		}
		if (userSignUp.getEmail() == null) {
			throw new ServerException("Please Enter EmailId");
		}
		if (userSignUp.getEmail() == null) {
			throw new ServerException("Please Enter First Name");
		}
		if (userSignUp.getPhoneNumber() == null) {
			throw new ServerException("Please Enter PhoneNumber");
		}
		if (userSignUp.getDob() == null) {
			throw new ServerException("Please Select Date Of Birth");
		}
		if (userSignUp.getGender() == null) {
			throw new ServerException("Please Select Gender");
		}
		if (userSignUp.getCountry() == null) {
			throw new ServerException("Please Select Country");
		}
		if (userSignUp.getState() == null) {
			throw new ServerException("Please Select Country");
		}
		if (userSignUp.getCity() == null) {
			throw new ServerException("Please Select City");
		}

	}

}
