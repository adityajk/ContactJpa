package org.cdac.service;

import org.cdac.domain.SnaAccount;

public interface UserContext {

	SnaAccount getCurrentUser();
	
	void setCurrentUser(SnaAccount snaAccount);
}
