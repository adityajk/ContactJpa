package org.cdac.repository;

import org.cdac.domain.SnaAccount;
import org.cdac.domain.SnaAuthority;

public interface SignupDao {

	public boolean checkUserEmail(String email);
	
	public boolean addUserAccount(SnaAccount snaAccount);
	
	public SnaAccount findUserByEmail(String attendeeEmail);
	
	public SnaAuthority getUserRole(String role);
}
