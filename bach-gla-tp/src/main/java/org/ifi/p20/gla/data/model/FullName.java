package org.ifi.p20.gla.data.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the full_name database table.
 * 
 */
@Entity
@Table(name="full_name")
@NamedQuery(name="FullName.findAll", query="SELECT f FROM FullName f ORDER BY f.fullNameId")
public class FullName implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="full_name_id")
	private int fullNameId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	public FullName() {
	}

	public int getFullNameId() {
		return this.fullNameId;
	}

	public void setFullNameId(int fullNameId) {
		this.fullNameId = fullNameId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getToString() {
		return firstName + " " 	+ lastName;
	}
	
	public String toString() {
		return "" + firstName + lastName;
	}

}