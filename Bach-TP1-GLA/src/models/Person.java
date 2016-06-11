package models;

import java.util.Date;

public class Person {

	private FullName name;
	private Address address;
	private int numberMobile;
	private Date birthday;

	public Person() {
	}

	public Person(FullName name, Address address, int numberMobile, Date birthday) {
		this.name = name;
		this.address = address;
		this.numberMobile = numberMobile;
		this.birthday = birthday;
	}

	public FullName getName() {
		return name;
	}

	public void setName(FullName name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getNumberMobile() {
		return numberMobile;
	}

	public void setNumberMobile(int numberMobile) {
		this.numberMobile = numberMobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
