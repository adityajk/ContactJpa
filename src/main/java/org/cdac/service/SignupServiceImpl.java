package org.cdac.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.cdac.domain.SnaAccount;
import org.cdac.repository.SignupDao;
import org.cdac.web.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("signupService")
public class SignupServiceImpl implements SignupService {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	private final SignupDao signupDao;
	private final StandardPasswordEncoder standardPasswordEncoder;	
	
	@Autowired
	public SignupServiceImpl(SignupDao signupDao, StandardPasswordEncoder standardPasswordEncoder) {
		this.signupDao = signupDao;
		this.standardPasswordEncoder = standardPasswordEncoder;		
	}

	@Override
	public boolean checkUserEmail(String email) {
		//logger.info("Welcome in service! The client email is {}.",email);
		boolean emailPresent = signupDao.checkUserEmail(email);
		return emailPresent;
	}

	@Override
	public boolean addUserAccount(SnaAccount snaAccount) {
		String role = "ROLE_USER";
		String language = "en";
		String pattern = "dd-MM-yy:HH:mm:SS";
		int isActive = 1;
		
		String encodedPassword = standardPasswordEncoder.encode(snaAccount.getPassword());
		String user_id = UUID.randomUUID().toString().replaceAll("-", "");
		
		snaAccount.setUserId(user_id);
		snaAccount.setPassword(encodedPassword);
		snaAccount.setLanguage(language);
		snaAccount.setIsActive(isActive);
		
		Date today = new Date();		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(today);
		try {
			snaAccount.setDateJoined(simpleDateFormat.parse(date));
			snaAccount.setLastLogin(simpleDateFormat.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		snaAccount.setSnaAuthority(signupDao.getUserRole(role));		
		
		boolean userAdded = signupDao.addUserAccount(snaAccount);
		
		return userAdded;
	}

	@Override
	public SnaAccount findUserByEmail(String attendeeEmail) {
		return signupDao.findUserByEmail(attendeeEmail);
	}
	
}
