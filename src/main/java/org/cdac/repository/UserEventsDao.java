package org.cdac.repository;

import java.util.List;

import org.cdac.domain.Event;
import org.cdac.domain.SnaAccount;

public interface UserEventsDao {

	Event getEvent(int eventId);
	
	void createEvent(Event event);
	
	List<Event> findForUser(SnaAccount userId);
	
	List<Event> getEvents();
	
	int deleteSingleEvent(int deleteId);
}
