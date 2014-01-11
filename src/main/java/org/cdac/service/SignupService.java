package org.cdac.service;

import org.cdac.domain.SnaAccount;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SignupService {
	
	public boolean checkUserEmail(String email);
	
	public boolean addUserAccount(SnaAccount snaAccount);

	public SnaAccount findUserByEmail(String attendeeEmail);
}
