package mybootapp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Group")
@Table(name = "TGroup")
@Data
public class Group implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Attributes
	 */

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", length = 200, nullable = false)
	private String name;

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "ownGroup")
	private Set<Person> persons;
	

	/**
	 * Constructors
	 */
	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	/**
	 * Getters and Setters
	 */
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPerson(Person person) {
		if (this.persons == null) {
			this.persons = new HashSet<>();
		}
		this.persons.add(person);
	}

	/**
	 * Méthode equals
	 */

	public boolean equals(Group group) {
		return (this.name.equals(group.getName()));
	}

}
