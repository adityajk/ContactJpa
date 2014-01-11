package org.cdac.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.cdac.domain.DeleteEvent;
import org.cdac.domain.Event;
import org.cdac.domain.SnaAccount;
import org.cdac.model.CreateEvent;
import org.cdac.service.EventsService;
import org.cdac.service.SignupService;
import org.cdac.service.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/events")
public class EventController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private final EventsService eventsService;
	private final SignupService signupService;
	private final UserContext userContext;
	
	@Autowired
	public EventController(EventsService eventsService, SignupService signupService, UserContext userContext) {
		this.eventsService = eventsService;
		this.signupService = signupService;
		this.userContext = userContext;
	}
	
	@RequestMapping("/")
	public String events(ModelMap map) {	
		//logger.info("Welcome events! All Events.");
		List<Event> events = eventsService.getEvents();
		map.put("events", events);
		return "eventList";
	}
	
	@RequestMapping("/my")
	public String myEvents(ModelMap map) {
		//logger.info("Welcome events! My events.");
		SnaAccount currentUser = userContext.getCurrentUser();
		//int currentuserId = currentUser.getId();
		map.put("events", eventsService.findForUser(currentUser));
		map.put("currentuser", currentUser);
		return "myEvents";
	}
	
	@RequestMapping("/{eventId}")
	public String showEvent(@PathVariable int eventId, ModelMap map) {
		//logger.info("Welcome events! get event.");
		Event event = eventsService.getEvent(eventId);
		if(event == null) {
			map.put("message", "fail");
			return "showEvent";
		} else {
			map.put("message", "success");
			map.put("event", event);
			return "showEvent";
		}
		
	}
	
	@RequestMapping(value="/delete/row", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteRow(@RequestBody DeleteEvent deleteEvent) {
		logger.info("Welcome events! delete event.");
		int count = eventsService.deleteSingleEvent(deleteEvent);
		if(count > 0) {
			return "success";
		} else {
			return "fail";
		}		
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createEvent(Map<String, Object> map) {
		//logger.info("Welcome events! Create event.");
		map.put("createEvent", new CreateEvent());
		return "createEvent";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createEvent(@Valid @ModelAttribute("createEvent") CreateEvent createEvent, BindingResult eventResult, ModelMap map) {
		if(eventResult.hasErrors()) {
			return "createEvent"; 
		} 
		
		SnaAccount attendee = signupService.findUserByEmail(createEvent.getAttendeeEmail());
		if(attendee == null) {
			eventResult.rejectValue("attendeeEmail", "attendeeEmail.missing", "No user with this email");
		}
		
		if(eventResult.hasErrors()) {
			return "createEvent"; 
		}
		
		boolean eventAdded = eventsService.createEvent(createEvent);
		if(eventAdded) {
			map.put("eventAdded", "success");
		} else {
			map.put("eventAdded", "fail");
		}
		
		return "createEvent";
	}
	
}
