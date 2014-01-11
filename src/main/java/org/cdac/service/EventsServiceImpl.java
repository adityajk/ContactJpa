package org.cdac.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.TypedQuery;

import org.cdac.domain.DeleteEvent;
import org.cdac.domain.Event;
import org.cdac.domain.SnaAccount;
import org.cdac.model.CreateEvent;
import org.cdac.repository.SignupDao;
import org.cdac.repository.UserEventsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("eventsService")
public class EventsServiceImpl implements EventsService {	
	
	private final UserEventsDao userEventsDao;
	private final SignupDao signupDao;
	private final UserContext userContext;
	
	@Autowired
	public EventsServiceImpl(UserEventsDao userEventsDao, SignupDao signupDao, UserContext userContext) {
		this.userEventsDao = userEventsDao;
		this.signupDao = signupDao;
		this.userContext = userContext;
	}

	@Override
	@Transactional(readOnly = true)
	public Event getEvent(int eventId) {
		//System.out.println("Get event");
		return userEventsDao.getEvent(eventId);
		
	}

	@Override
	@Transactional
	public boolean createEvent(CreateEvent createEvent) {
		Event e = new Event();
		SnaAccount attendee = signupDao.findUserByEmail(createEvent.getAttendeeEmail());		
		
		e.setSnaAccount1(userContext.getCurrentUser());
		e.setSnaAccount2(attendee);
		e.setDescription(createEvent.getDescription());
		e.setSummary(createEvent.getSummary());
		e.setEventWhen(createEvent.getWhen());
		
		userEventsDao.createEvent(e);
		
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Event> findForUser(SnaAccount userId) {		
		return userEventsDao.findForUser(userId);
	}

	@Override
	public List<Event> getEvents() {
		return userEventsDao.getEvents();
	}

	@Override
	@Transactional
	public int deleteSingleEvent(DeleteEvent deleteEvent) {
		int count = userEventsDao.deleteSingleEvent(deleteEvent.getDeleteId());
		return count;
	}

}
