package org.ifi.p20.gla.data.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name = "address")
@NamedQueries({ @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a ORDER BY a.addressId"),
		@NamedQuery(name = "Address.findAddressByPersonId", query = "SELECT a FROM Address a, Person ps WHERE a.person.personId=ps.personId ORDER BY a.addressId") })
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private int addressId;

	@Column(name = "arrondissement", nullable = true)
	private String arrondissement;

	@Column(name = "country", nullable = true)
	private String country;

	@Column(name = "number", nullable = true)
	private String number;

	@Column(name = "province", nullable = true)
	private String province;

	@Column(name = "street", nullable = true)
	private String street;

	// bi-directional many-to-one association to Person
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person person;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getArrondissement() {
		return this.arrondissement;
	}

	public void setArrondissement(String arrondissement) {
		this.arrondissement = arrondissement;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}