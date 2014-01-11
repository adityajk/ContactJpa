package org.cdac.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.cdac.domain.SnaAccount;
import org.cdac.model.Register;
import org.cdac.service.SignupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	SignupService signupService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request, ModelMap map) {				
			return "redirect:/";		
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signIn(Map<String, Object> map) {
		//map.put("login", new Login());
		return "signin";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signUp(Map<String, Object> map) {
		map.put("register", new Register());
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signUp(@Valid @ModelAttribute("register") Register register, BindingResult formResult, ModelMap map) {
		if(formResult.hasErrors()) {
			map.put("genderValue", register.getGender());			
			return "signup";
		} else if(signupService.checkUserEmail(register.getEmail())) {
			String emailPresentError = "Email already registered";
			map.put("emailPresent", emailPresentError);
			return "signup";
		} else {
			SnaAccount snaAccount = new SnaAccount();
			
			snaAccount.setFirstName(register.getFirstName());
			snaAccount.setLastName(register.getLastName());
			snaAccount.setEmail(register.getEmail());
			snaAccount.setGender(register.getGender());
			snaAccount.setPassword(register.getPassword());
			
			boolean userAdded = signupService.addUserAccount(snaAccount);
			if(userAdded) {
				map.put("userAdded", "success");
			} else {
				map.put("userAdded", "fail");
			}
			
			return "signup";
		}		
	}
	
	
}
