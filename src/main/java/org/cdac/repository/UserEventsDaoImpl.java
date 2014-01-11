package org.cdac.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.cdac.domain.Event;
import org.cdac.domain.SnaAccount;
import org.springframework.stereotype.Repository;

@Repository("userEventsDao")
public class UserEventsDaoImpl implements UserEventsDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Event getEvent(int eventId) {
		if(eventId == 0) {
			return null;
		}
		try {
			TypedQuery<Event> query = em.createNamedQuery("Event.getEvent", Event.class);
			Event event = query.setParameter("eventId", eventId).getSingleResult();
			return event;
		} catch(Exception ex) {
			return null;
		}
		
	}

	@Override
	public void createEvent(Event event) {
		em.persist(event);
	}

	@Override
	public List<Event> findForUser(SnaAccount userId) {
		TypedQuery<Event> query = em.createNamedQuery("Event.findForUser", Event.class);
		List<Event> userEvents = query.setParameter("userId1", userId).setParameter("userId2", userId).getResultList();
		return userEvents;
	}

	@Override
	public List<Event> getEvents() {
		try {
			TypedQuery<Event> query = em.createNamedQuery("Event.getAllEvents", Event.class);
			List<Event> events = query.getResultList();
			return events;
		} catch(Exception ex) {
			return null;
		}
		
	}

	@Override
	public int deleteSingleEvent(int deleteId) {
		int count = em.createNamedQuery("Event.deleteSingleEvent").setParameter("deleteId", deleteId).executeUpdate();		
		return count;
	}

}
