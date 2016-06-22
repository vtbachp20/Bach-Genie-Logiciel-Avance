package org.ifi.p20.gla.data.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phone_number database table.
 * 
 */
@Entity
@Table(name="phone_number")
@NamedQueries({ @NamedQuery(name="PhoneNumber.findAll", query="SELECT p FROM PhoneNumber p ORDER BY p.phoneNumberId"),
	@NamedQuery(name="PhoneNumber.findPhoneNumberByPersonId", query="SELECT p FROM PhoneNumber p, Person ps WHERE p.person.personId=ps.personId ORDER BY p.phoneNumberId")
})
public class PhoneNumber implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String TYPE_WORK_PHONE = "work_phone";
	public static final String TYPE_HOME_PHONE = "home_phone";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="phone_number_id")
	private int phoneNumberId;

	@Column(name="number")
	private String number;

	@Column(name="type")
	private String type;

	//bi-directional many-to-one association to Person
	@ManyToOne(cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;

	public PhoneNumber() {
	}

	public int getPhoneNumberId() {
		return this.phoneNumberId;
	}

	public void setPhoneNumberId(int phoneNumberId) {
		this.phoneNumberId = phoneNumberId;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}