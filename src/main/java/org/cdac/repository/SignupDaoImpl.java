package org.cdac.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.cdac.domain.SnaAccount;
import org.cdac.domain.SnaAuthority;
import org.cdac.web.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("signupDao")
public class SignupDaoImpl implements SignupDao {
	
	@PersistenceContext
	EntityManager em;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Override
	public boolean checkUserEmail(String email) {		
		//String checkEmailCount = "Select COUNT(e) from SnaAccount e where e.email = :userEmail";
		TypedQuery<Long> query = em.createNamedQuery("SnaAccount.checkEmailCount", Long.class);
		//TypedQuery<Long> query = em.cre
		query.setParameter("userEmail", email);		
		long emailCount = query.getSingleResult();
		logger.info("Welcome in dao! The cl-ient email is {}.",emailCount);
		if(emailCount > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean addUserAccount(SnaAccount snaAccount) {
		em.persist(snaAccount);
		em.flush();
		return true;
	}

	@Override
	public SnaAccount findUserByEmail(String attendeeEmail) {
		if(attendeeEmail == null) {
			throw new IllegalArgumentException("Email cannot be null");
		}		
		try {
			//String findUser = "Select e from SnaAccount e where e.email = :userEmail";
			TypedQuery<SnaAccount> query = em.createNamedQuery("SnaAccount.findUser", SnaAccount.class);
			SnaAccount snaEmail = query.setParameter("userEmail", attendeeEmail).getSingleResult();			
			return snaEmail;
		} catch(EmptyResultDataAccessException notFound) {
			return null;
		} catch(NoResultException nre) {
			return null;
		} catch(Exception ex) {
			return null;
		}
	}

	@Override
	public SnaAuthority getUserRole(String userRole) {
		if(userRole == null) {
			throw new IllegalArgumentException("Role cannot be null");
		}
		try{
			TypedQuery<SnaAuthority> query = em.createNamedQuery("SnaAuthority.getUserRole", SnaAuthority.class);
			SnaAuthority snaRole = query.setParameter("userRole", userRole).getSingleResult();
			return snaRole;	
		}catch(Exception e) {
			return null;
		}
		
		
	}
	
	

}
