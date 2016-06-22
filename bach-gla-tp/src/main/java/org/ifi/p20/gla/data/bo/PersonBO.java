package org.ifi.p20.gla.data.bo;

import java.util.List;

import org.ifi.p20.gla.data.model.Address;
import org.ifi.p20.gla.data.model.Person;
import org.ifi.p20.gla.data.model.PhoneNumber;

public interface PersonBO {

	public void save(Person person);

	public void update(Person person);

	public void delete(Person person);

	void delete(PhoneNumber phoneNumber);

	void delete(Address address);

	public Person findByPersonId(int personId);

	public List<Person> findByPersonName(String personName);

	public List<Person> findAllPerson();
}
