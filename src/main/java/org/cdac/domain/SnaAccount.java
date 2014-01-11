package org.cdac.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sna_account database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="SnaAccount.checkEmailCount", query="Select COUNT(e) from SnaAccount e where e.email = :userEmail"),
	@NamedQuery(name="SnaAccount.findUser", query="Select e from SnaAccount e where e.email = :userEmail")
})
@Table(name="sna_account")
public class SnaAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_joined")
	private Date dateJoined;

	private String email;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="is_active")
	private int isActive;

	private String language;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login")
	private Date lastLogin;

	@Column(name="last_name")
	private String lastName;

	private String password;

	@Column(name="user_id")
	private String userId;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="snaAccount1")
	private List<Event> events1;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="snaAccount2")
	private List<Event> events2;

	//bi-directional many-to-one association to SnaAuthority
	@ManyToOne
	@JoinColumn(name="role_id")
	private SnaAuthority snaAuthority;

	public SnaAccount() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateJoined() {
		return this.dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Event> getEvents1() {
		return this.events1;
	}

	public void setEvents1(List<Event> events1) {
		this.events1 = events1;
	}

	public List<Event> getEvents2() {
		return this.events2;
	}

	public void setEvents2(List<Event> events2) {
		this.events2 = events2;
	}

	public SnaAuthority getSnaAuthority() {
		return this.snaAuthority;
	}

	public void setSnaAuthority(SnaAuthority snaAuthority) {
		this.snaAuthority = snaAuthority;
	}

}