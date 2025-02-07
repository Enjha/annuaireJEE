package mybootapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Attributes
	 */

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Basic(optional = false)
	@Column(name = "lastName", length = 20, nullable = false)
	private String lastName;

	@Basic(optional = false)
	@Column(name = "first_name", length = 20, nullable = false)
	private String firstName;

	@Basic()
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_day", nullable = false)
	private Date birthDay;

	@Basic(optional = false)
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "website", length = 200)
	private String website;

	@Basic(optional = false)
	@Column(name = "password", length = 20, nullable = false)
	private String password;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ownGroup")
	private Group ownGroup;

	public Person() {
		super();
	}

	public Person(String lastName, String firstName, Date birthDay, String email, String website, String password) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDay = birthDay;
		this.email = email;
		this.website = website;
		this.password = password;
	}

	/**
	 * Getters and Setters
	 */

	public long getId() {
		return id;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Group getOwnGroup() {
		return ownGroup;
	}

	public void setOwnGroup(Group ownGroup) {
		this.ownGroup = ownGroup;
	}

	@PreUpdate
	public void beforeUpdate() {
		System.err.println("PreUpdate of " + this);
	}


	@PostUpdate
	public void afterUpdate() {
		System.err.println("PostUpdate of " + this);
	}

	/**
	 * Méthode equals
	 */

	public boolean equals(Person person) {
		return this.email.equals(person.getEmail());
	}
}