package org.cdac.service;

import org.cdac.domain.SnaAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityUserContext implements UserContext {
	private final SignupService signupService;
	private final UserDetailsService userDetailsService;
	
	@Autowired
	public SpringSecurityUserContext(SignupService signupService, UserDetailsService userDetailsService) {
		this.signupService = signupService;
		this.userDetailsService = userDetailsService;
	}

	@Override
	public SnaAccount getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if(authentication == null) {
			return null;
		}
		
		String email = authentication.getName();
		return signupService.findUserByEmail(email);
	}

	@Override
	public void setCurrentUser(SnaAccount snaAccount) {
		throw new UnsupportedOperationException();
	}

}
