package com.ashokit.utility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.ServerException;
import java.util.stream.Stream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ashokit.entity.Users;
import com.ashokit.pojos.UserUnLock;

@Component
public class UserUtlity {

	@Autowired
	private JavaMailSender sender;

	public boolean sendEmail(Users users) throws Exception {

		MimeMessage mimeMsg = sender.createMimeMessage();

		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMsg);

		messageHelper.setTo(users.getEmail());
		messageHelper.setSubject("Registration Mail");
		messageHelper.setText(readBody("RegistrationMail.txt", users), true);
		sender.send(mimeMsg);
		return true;
	}

	private String readBody(String fileName, Users users) {

		StringBuffer sb = new StringBuffer();
		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {

			lines.forEach(line -> {

				line = line.replace("${firstName}", users.getFirstName());
				line = line.replace("${lastName}", users.getFirstName());
				line = line.replace("${email}", users.getFirstName());

				sb.append(line);
			});

		} catch (Exception e) {
			// TODO: handle exception
		}

		return sb.toString();
	}

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
