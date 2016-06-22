package org.ifi.p20.gla.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@Table(name = "person")
@NamedQueries({ @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p ORDER BY p.personId"),
		@NamedQuery(name = "Person.findPersonByPersonId", query = "SELECT p FROM Person p WHERE p.personId=:personId"),
		@NamedQuery(name = "Person.findPersonByName", query = "SELECT p FROM Person p, FullName f WHERE p.fullName.fullNameId=f.fullNameId AND ( (f.firstName LIKE :personName) OR (f.lastName LIKE :personName) ) ORDER BY p.personId") })
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private int personId;

	// bi-directional many-to-one association to Address
	@OneToMany(mappedBy = "person", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Address> addresses;

	// uni-directional one-to-one association to FullName
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "full_name_id")
	private FullName fullName;

	// bi-directional many-to-one association to PhoneNumber
	@OneToMany(mappedBy = "person", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<PhoneNumber> phoneNumbers;

	public Person() {
//		setFullName(new FullName());
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setPerson(this);

		return address;
	}

	public Address removeAddress(Address address) {
//		address.setPerson(null);
		getAddresses().remove(address);
		address=null;
		
		return address;
	}

	public FullName getFullName() {
		return this.fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return this.phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public PhoneNumber addPhoneNumber(PhoneNumber phoneNumber) {
		getPhoneNumbers().add(phoneNumber);
		phoneNumber.setPerson(this);

		return phoneNumber;
	}

	public PhoneNumber removePhoneNumber(PhoneNumber phoneNumber) {
//		phoneNumber.setPerson(null);
		this.phoneNumbers.remove(phoneNumber);
		phoneNumber=null;

		return phoneNumber;
	}

}