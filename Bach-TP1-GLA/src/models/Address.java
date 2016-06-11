package models;

public class Address {

	private String number;
	private String street;
	private String arrondissement;
	private String province;
	private String country;

	public Address() {
		super();
	}

	public Address(String number, String street, String arrondissement, String province, String country) {
		super();
		this.number = number;
		this.street = street;
		this.arrondissement = arrondissement;
		this.province = province;
		this.country = country;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(String arrondissement) {
		this.arrondissement = arrondissement;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
