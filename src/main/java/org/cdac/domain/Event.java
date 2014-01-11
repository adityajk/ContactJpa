package org.cdac.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Event.findForUser", query="Select e from Event e where e.snaAccount1 = :userId1 OR e.snaAccount2 = :userId2 order by e.id"),
	@NamedQuery(name="Event.getEvent", query="Select e from Event e where e.id = :eventId"),
	@NamedQuery(name="Event.getAllEvents", query="Select e from Event e order by e.id"),
	@NamedQuery(name="Event.deleteSingleEvent", query="Delete from Event e where e.id = :deleteId")
})
@Table(name="events")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue	
	private int id;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="event_when")
	private Date eventWhen;

	private String summary;

	//bi-directional many-to-one association to SnaAccount
	@ManyToOne
	@JoinColumn(name="owner_id")
	private SnaAccount snaAccount1;

	//bi-directional many-to-one association to SnaAccount
	@ManyToOne
	@JoinColumn(name="attendee_id")
	private SnaAccount snaAccount2;

	public Event() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEventWhen() {
		return this.eventWhen;
	}

	public void setEventWhen(Date eventWhen) {
		this.eventWhen = eventWhen;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public SnaAccount getSnaAccount1() {
		return this.snaAccount1;
	}

	public void setSnaAccount1(SnaAccount snaAccount1) {
		this.snaAccount1 = snaAccount1;
	}

	public SnaAccount getSnaAccount2() {
		return this.snaAccount2;
	}

	public void setSnaAccount2(SnaAccount snaAccount2) {
		this.snaAccount2 = snaAccount2;
	}

}