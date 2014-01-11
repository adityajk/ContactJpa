package org.cdac.service;

import java.util.List;

import org.cdac.domain.DeleteEvent;
import org.cdac.domain.Event;
import org.cdac.domain.SnaAccount;
import org.cdac.model.CreateEvent;

public interface EventsService {

	Event getEvent(int eventId);
	
	boolean createEvent(CreateEvent createEvent);
	
	List<Event> findForUser(SnaAccount userId);
	
	List<Event> getEvents();
	
	int deleteSingleEvent(DeleteEvent deleteEvent);
	
}
