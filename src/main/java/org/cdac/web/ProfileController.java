package org.cdac.web;

import java.util.Map;

import org.cdac.model.UpdatePassword;
import org.cdac.model.UpdateProfile;
import org.cdac.service.ProfileService;
import org.cdac.service.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	@Autowired
	private ProfileService profilerService;
	@Autowired
	private UserContext userContext;
	
	@RequestMapping(value = {"/myProfile", "/", ""}, method = RequestMethod.GET)
	public String myProfile(Map<String, Object> map) {
		logger.info("Welcome to Profile! My profile.");
		map.put("updateProfile", new UpdateProfile());
		return "myProfile";
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePass(Map<String, Object> map) {
		logger.info("Welcome to change Password.");
		map.put("updatePassword", new UpdatePassword());
		return "changePass";
	}
	
	
	
	public UserContext getUserContext() {
		return userContext;
	}

	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}

	public ProfileService getProfilerService() {
		return profilerService;
	}

	public void setProfilerService(ProfileService profilerService) {
		this.profilerService = profilerService;
	}
	
}
