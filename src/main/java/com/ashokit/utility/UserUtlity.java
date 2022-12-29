package com.ashokit.utility;

import java.rmi.ServerException;

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

}
